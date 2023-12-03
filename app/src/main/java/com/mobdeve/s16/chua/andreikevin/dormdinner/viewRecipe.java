package com.mobdeve.s16.chua.andreikevin.dormdinner;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class viewRecipe extends AppCompatActivity {

    TextView recipeName;
    TextView recipeCredits;
    ImageView recipeBanner;
    TextView cntLikes;
    TextView cntIngredientsInPantry;
    TextView cntIngredientsMissing;
    TextView readyInMinutes;
    ImageButton btnFavorite;
    /* TODO:change logic later on */
    recipeData recipeData;
    DBHandler db;
    String recipeBannerUrl;

    //TODO here
    String recipeID;
    int likes, usedCnt, missedCnt, readyMins;
    private RecyclerView recipesRecyclerView;
    private fullRecipeApi recipeApiClient;
    private ArrayList<Integer> amounts;
    String recipeTitle;
    ArrayList<String> ingredientList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_recipe);
        this.recipeName = (TextView) findViewById(R.id.recipeName);
        this.recipeCredits = (TextView) findViewById(R.id.recipeCredits);
        this.recipeBanner = (ImageView) findViewById(R.id.recipeBanner);
        this.cntLikes = (TextView) findViewById(R.id.cntLikes);
        this.cntIngredientsInPantry = (TextView) findViewById(R.id.cntIngredientsInPantry);
        this.cntIngredientsMissing = (TextView) findViewById(R.id.cntIngredientsMissing);
        this.readyInMinutes = (TextView) findViewById(R.id.readyInMinutes);
        this.btnFavorite = (ImageButton) findViewById(R.id.btnFavorite);
        LayoutInflater vi = (LayoutInflater) getLayoutInflater();
        View ingredient_view = vi.inflate(R.layout.list_ingredients, null);

        /* initialize missing and in-pantry ingredients of sample recipe 1 */
        ArrayList<ingredientData> recipeIngredientsInPantry = new ArrayList<ingredientData>();
        ArrayList<ingredientData> recipeIngredientsMissing = new ArrayList<ingredientData>();
        ArrayList<String> instructions = new ArrayList<String>();

        //TODO Here
        recipeID = getIntent().getStringExtra("recipeID");
        likes = getIntent().getIntExtra("likes", 0);
        usedCnt = getIntent().getIntExtra("usedCount", 0);
        missedCnt = getIntent().getIntExtra("missedCount", 0);
        ingredientList = getIntent().getStringArrayListExtra("ingredientList");

        Intent intent = getIntent();
        recipeApiClient = new fullRecipeApi();

        TinyDB tinydb = new TinyDB(this);
        ArrayList<String> ingredientList = tinydb.getListString("PantryIngredients");

        recipeApiClient.searchRecipesByRecipe(recipeID, new recipeResponseCallback() {
            @Override
            public void onSuccess(String recipeNames, String imageUrl, int readyMin, String credits, List<String> extraName, List<String> imgUrl, List<String> instructions) {
                recipeName.setText(recipeNames);
                recipeTitle = recipeNames;
                recipeBannerUrl = imageUrl;
                Picasso.with(viewRecipe.this).load(imageUrl).into(recipeBanner);
                readyInMinutes.setText(String.valueOf(readyMin) + " mins");
                recipeCredits.setText(credits);
                for(int i = 0; i < extraName.size(); i++){
                    if(containsWord(extraName.get(i), ingredientList)){
                        recipeIngredientsInPantry.add(new ingredientData(extraName.get(i), imgUrl.get(i)));
                    }
                    else {
                        recipeIngredientsMissing.add(new ingredientData(extraName.get(i), imgUrl.get(i)));
                    }
                }

                db = new DBHandler(viewRecipe.this);
                Cursor res = db.getData();

                if (res.getCount() < 1) {
                    btnFavorite.setImageResource(R.drawable.btn_favorite_off);
                } else {
                    boolean isRecipeFound = false;

                    while (res.moveToNext()) {
                        if (res.getString(0).equals(recipeTitle)) {
                            btnFavorite.setImageResource(R.drawable.btn_favorite_on);
                            isRecipeFound = true;
                            break;
                        }
                    }

                    if (!isRecipeFound) {
                        btnFavorite.setImageResource(R.drawable.btn_favorite_off);
                    }
                }

                try {
                    recipeData = new recipeData("1",
                            recipeNames,
                            new URL("https://www.allrecipes.com/cook/fabeveryday"),
                            credits,
                            R.drawable.sample_recipe_1,
                            usedCnt, missedCnt,
                            readyMin, likes, instructions,
                            recipeIngredientsInPantry, recipeIngredientsMissing, false);

                    // Start of calls that are sample generation independent
                    setDataToLayout(recipeData);
                    showPantryIngredients();
                    showMissingIngredients();
                    showInstructions();
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void onFailure(String errorMessage) {
                Toast.makeText(viewRecipe.this, errorMessage, Toast.LENGTH_SHORT).show();
            }
        });



        // In MCO3 we will do recipeData = get from Intent() instead
        /*if(getIntent().hasExtra("itemId")) {
            String itemId = getIntent().getStringExtra("itemId");
            // Now you have itemId. Continue doing your API call and other works
        }else {
            throw new RuntimeException("Item/Recipe has no ID");
        }*/


        /*recipeIngredientsInPantry.add(new ingredientData("bone-in, skin on chicken thighs", 1.0, R.drawable.sample_recipe_1_chicken));
        recipeIngredientsInPantry.add(new ingredientData("ground black pepper", 1.0, R.drawable.sample_recipe_1_black_pepper));
        recipeIngredientsInPantry.add(new ingredientData("salt", 1.0, R.drawable.sample_recipe_1_salt));
        recipeIngredientsInPantry.add(new ingredientData("vegetable oil", 1.5, R.drawable.sample_recipe_1_vegetable_oil));
        recipeIngredientsInPantry.add(new ingredientData("onion, sliced", 1.0, R.drawable.sample_recipe_1_sliced_onion));
        recipeIngredientsInPantry.add(new ingredientData("apples, sliced", 2.0, R.drawable.sample_recipe_1_sliced_apples));*/

        /*recipeIngredientsMissing.add(new ingredientData("heavy cream", "1/4 cup", R.drawable.sample_recipe_1_heavy_cream));
        recipeIngredientsMissing.add(new ingredientData("cornstarch", "1 tablespoon", R.drawable.sample_recipe_1_cornstarch));
        recipeIngredientsMissing.add(new ingredientData("fresh thyme leaves", "1/2 tablespoon", R.drawable.sample_recipe_1_thyme_leaves));
        recipeIngredientsMissing.add(new ingredientData("apple cider", "1 cup", R.drawable.sample_recipe_1_apple_cider));
        recipeIngredientsMissing.add(new ingredientData("chicken stock", "0.5", R.drawable.sample_recipe_1_chicken_stock));*/

        /* initialize cooking instructions for sample recipe 1 */

        /*instructions.add("Preheat the oven to 350 degrees F (175 degrees C). Season both sides of chicken thighs with salt and pepper.");
        instructions.add("Heat oil in a deep oven-proof skillet or Dutch oven over medium-high heat. Add chicken thighs to hot oil and cook until browned on both sides, about 4 minutes per side. Transfer chicken to a plate and keep warm.");
        instructions.add("Add sliced onions to the skillet and sauté until they just start to brown, about 3 minutes. Pour in apple cider and chicken stock, scraping the bottom of the pan to loosen any browned bits. Stir in thyme and salt. Simmer until onions are soft, 4 to 5 minutes. Turn off the heat.");
        instructions.add("Add chicken back to the skillet and spoon some sauce over the top. Arrange sliced apples around chicken. Cover the skillet with a lid or aluminum foil.");
        instructions.add("Bake in the preheated oven for 15 minutes. Remove skillet from the oven and carefully uncover. Transfer chicken from the skillet to a plate and keep warm. Whisk heavy cream and cornstarch together in a small bowl. Stir gently into sauce in the skillet. Place chicken back into the skillet and spoon some of sauce over chicken.");
        instructions.add("Return skillet to the oven and bake, uncovered, until the chicken is no longer pink at the bone and juices run clear, and an instant-read thermometer inserted near bone reads at least 165 degrees F (74 degrees C), about 15 minutes more. Serve chicken and apples with sauce.");
*/
        /* initialize sample recipe 1 */

        // END OF SAMPLE GENERATION



    }

    private void setDataToLayout(recipeData sampleRecipe) {
        this.recipeName.setText(sampleRecipe.getRecipeName());
        this.recipeCredits.setText(sampleRecipe.getRecipeCredits());
        //this.recipeBanner.setImageResource(sampleRecipe.getRecipeBanner());
        this.cntLikes.setText(sampleRecipe.getCntLikes()+" likes");
        this.cntIngredientsInPantry.setText(sampleRecipe.getCntIngredientsInPantry()+" in pantry");
        this.cntIngredientsMissing.setText(sampleRecipe.getCntIngredientsMissing()+" missing");
        this.readyInMinutes.setText(sampleRecipe.getReadyInMinutes()+" mins");
    }

    private void IngredientsLayouter(ArrayList<ingredientData> ingredientList, ViewGroup parent, int insertAfterChildID) {
        // Util function to generate the views for pantry and missing ingredients
        // get index of the target child
        int index = getIndexAfterChild(parent, insertAfterChildID);

        LayoutInflater vi = (LayoutInflater) getLayoutInflater();

        for (ingredientData ingredient : ingredientList) {
            View ingredient_view = vi.inflate(R.layout.list_ingredients, null);

            TextView ingredientAmt = (TextView) ingredient_view.findViewById(R.id.ingredientAmt);
            ingredientAmt.setText(ingredient.getIngredientAmt() + " ");
            TextView ingredientName = (TextView) ingredient_view.findViewById(R.id.ingredientName);
            ingredientName.setText(ingredient.getIngredientName());
            // Load image using Glide to downscale for memory efficiency
            Glide.with(this.getApplicationContext())
                    .load(ingredient.getIngredientImage())
                    .into((ImageView) ingredient_view.findViewById(R.id.ingredientImage));

            // Need to make params for the ViewGroup programatically since the parent properties don't follow
            ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            Resources r = getResources();
            int px = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    20,
                    r.getDisplayMetrics()
            );
            params.setMargins(px, 0, px, 26);
            parent.addView(ingredient_view, index, params);
            index++;
        }
    }

    private int getIndexAfterChild(ViewGroup parent, int insertAfterChildID) {
        // Util function to know where to insert after a specific child view of a parent view group
        int index = 0;
        for (int i=0; i < parent.getChildCount(); i++) {
            if (parent.getChildAt(i).getId() == insertAfterChildID) {
                index = i;
                index++;
                return index;
            }
        }
        throw new RuntimeException("Index of child cannot be found. This should never happen.");
    }

    private void showPantryIngredients() {
        IngredientsLayouter(recipeData.getRecipeIngredientsInPantry(), findViewById(R.id.parentLinearLayout), R.id.pantryIngredientsLabel);
    }

    private void showMissingIngredients() {
        IngredientsLayouter(recipeData.getRecipeIngredientsMissing(), findViewById(R.id.parentLinearLayout), R.id.missingIngredientsLabel);
    }

    private void showInstructions() {
        // Util function to insert instruction views
        ViewGroup parent = findViewById(R.id.parentLinearLayout);

        LayoutInflater vi = (LayoutInflater) getLayoutInflater();

        int stepCnt = 0;
        for (String instruction : recipeData.getRecipeInstructions()) {
            View instruction_view = vi.inflate(R.layout.list_instructions, null);

            TextView step_count = (TextView) instruction_view.findViewById(R.id.step_count);
            step_count.setText(Integer.toString(stepCnt+1));
            TextView step_description = (TextView) instruction_view.findViewById(R.id.step_description);
            step_description.setText(instruction);

            // Need to make params for the ViewGroup programatically since the parent properties don't follow
            ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            Resources r = getResources();
            /*int px = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    20,
                    r.getDisplayMetrics()
            );*/
            params.setMargins(0, 0, 0, 30);
            parent.addView(instruction_view, -1, params);
            stepCnt++;
        }
    }

    /* TODO: change logic later on */
    public void btnFavoriteClicked(View v) {
        db = new DBHandler(this);
        Cursor res = db.getData();

        if(res.getCount() < 1){
            db.addNewFav(recipeTitle, recipeBannerUrl, recipeID);
            recipeData.setIsFavorite(true);
            btnFavorite.setImageResource(R.drawable.btn_favorite_on);
        } else {
            boolean isRecipeFound = false;

            while (res.moveToNext()) {
                if (res.getString(0).equals(recipeTitle)) {
                    db.deleteData(recipeTitle);
                    recipeData.setIsFavorite(false);
                    btnFavorite.setImageResource(R.drawable.btn_favorite_off);
                    isRecipeFound = true;
                    // refresh Activity
                    Intent intent = new Intent(this, favoriteRecipes.class);
                    startActivity(intent);
                    finish();
                    break; 
                }
            }

            if (!isRecipeFound) {
                db.addNewFav(recipeTitle, recipeBannerUrl, recipeID);
                recipeData.setIsFavorite(true);
                btnFavorite.setImageResource(R.drawable.btn_favorite_on);
            }
        }


        /*(if (recipeData.getIsFavorite()) {
            recipeData.setIsFavorite(false);
            btnFavorite.setImageResource(R.drawable.btn_favorite_off);
        }
        else {
            recipeData.setIsFavorite(true);
            btnFavorite.setImageResource(R.drawable.favs_on);
        }*/
    }

    public void shareClicked(View v) {
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        String shareBody = recipeData.toString();
        String shareSubject = recipeTitle;
        share.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
        share.putExtra(Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(share, "Share using"));
    }

    public void printClicked(View v) {
        generatePDF(v);
    }

    private boolean containsWord(String sentence, ArrayList<String> wordsToCheck) {
        sentence = sentence.toLowerCase();
        wordsToCheck.replaceAll(String::toLowerCase);
        for (String word : wordsToCheck) {
            if (sentence.contains(word)) {
                return true;
            }
        }
        return false;
    }

    private void generatePDF(View view) {
        String filename = recipeData.getRecipeName().replaceAll("[,\\s]+", "");;
        String filecontent = recipeData.toString();
        PrintHelper fop = new PrintHelper();
        Boolean isSuccessful = false;
        try {
            isSuccessful = fop.write(filename, filecontent);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (isSuccessful) {
            Toast.makeText(getApplicationContext(),filename + ".pdf created and downloaded.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Oops! Failed to download PDF file.", Toast.LENGTH_LONG).show();
        }
    }
}