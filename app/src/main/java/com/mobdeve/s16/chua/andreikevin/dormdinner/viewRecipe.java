package com.mobdeve.s16.chua.andreikevin.dormdinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

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


        // In MCO3 we will do recipeData = get from Intent() instead

        /* initialize missing and in-pantry ingredients of sample recipe 1 */
        ArrayList<ingredientData> recipeIngredientsInPantry = new ArrayList<ingredientData>();
        ArrayList<ingredientData> recipeIngredientsMissing = new ArrayList<ingredientData>();

        recipeIngredientsInPantry.add(new ingredientData("bone-in, skin on chicken thighs", "4 (4 ounce)", R.drawable.sample_recipe_1_chicken));
        recipeIngredientsInPantry.add(new ingredientData("ground black pepper", "1/2 teaspoon", R.drawable.sample_recipe_1_black_pepper));
        recipeIngredientsInPantry.add(new ingredientData("salt", "1/2 teaspoon", R.drawable.sample_recipe_1_salt));
        recipeIngredientsInPantry.add(new ingredientData("vegetable oil", "2 tablespoons", R.drawable.sample_recipe_1_vegetable_oil));
        recipeIngredientsInPantry.add(new ingredientData("onion, sliced", "1 medium", R.drawable.sample_recipe_1_sliced_onion));
        recipeIngredientsInPantry.add(new ingredientData("apples, sliced", "2 medium", R.drawable.sample_recipe_1_sliced_apples));

        recipeIngredientsMissing.add(new ingredientData("heavy cream", "1/4 cup", R.drawable.sample_recipe_1_heavy_cream));
        recipeIngredientsMissing.add(new ingredientData("cornstarch", "1 tablespoon", R.drawable.sample_recipe_1_cornstarch));
        recipeIngredientsMissing.add(new ingredientData("fresh thyme leaves", "1/2 tablespoon", R.drawable.sample_recipe_1_thyme_leaves));
        recipeIngredientsMissing.add(new ingredientData("apple cider", "1 cup", R.drawable.sample_recipe_1_apple_cider));
        recipeIngredientsMissing.add(new ingredientData("chicken stock", "1/2 cup", R.drawable.sample_recipe_1_chicken_stock));

        /* initialize cooking instructions for sample recipe 1 */
        ArrayList<String> instructions = new ArrayList<String>();
        instructions.add("Preheat the oven to 350 degrees F (175 degrees C). Season both sides of chicken thighs with salt and pepper.");
        instructions.add("Heat oil in a deep oven-proof skillet or Dutch oven over medium-high heat. Add chicken thighs to hot oil and cook until browned on both sides, about 4 minutes per side. Transfer chicken to a plate and keep warm.");
        instructions.add("Add sliced onions to the skillet and sauté until they just start to brown, about 3 minutes. Pour in apple cider and chicken stock, scraping the bottom of the pan to loosen any browned bits. Stir in thyme and salt. Simmer until onions are soft, 4 to 5 minutes. Turn off the heat.");
        instructions.add("Add chicken back to the skillet and spoon some sauce over the top. Arrange sliced apples around chicken. Cover the skillet with a lid or aluminum foil.");
        instructions.add("Bake in the preheated oven for 15 minutes. Remove skillet from the oven and carefully uncover. Transfer chicken from the skillet to a plate and keep warm. Whisk heavy cream and cornstarch together in a small bowl. Stir gently into sauce in the skillet. Place chicken back into the skillet and spoon some of sauce over chicken.");
        instructions.add("Return skillet to the oven and bake, uncovered, until the chicken is no longer pink at the bone and juices run clear, and an instant-read thermometer inserted near bone reads at least 165 degrees F (74 degrees C), about 15 minutes more. Serve chicken and apples with sauce.");

        /* initialize sample recipe 1 */
        try {
            recipeData = new recipeData("Baked Chicken Thighs with Apples and Onions",
                                                        new URL("https://www.allrecipes.com/cook/fabeveryday"),
                                                        "fabeveryday",
                                                        R.drawable.sample_recipe_1,
                                                        recipeIngredientsInPantry.size(), recipeIngredientsMissing.size(),
                                                        45, 17, instructions,
                                                        recipeIngredientsInPantry, recipeIngredientsMissing, false);

            // Start of calls that are sample generation independent
            setDataToLayout(recipeData);
            showPantryIngredients();
            showMissingIngredients();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        // END OF SAMPLE GENERATION



    }

    private void setDataToLayout(recipeData sampleRecipe) {
        this.recipeName.setText(sampleRecipe.getRecipeName());
        this.recipeCredits.setText(sampleRecipe.getRecipeCredits());
        this.recipeBanner.setImageResource(sampleRecipe.getRecipeBanner());
        this.cntLikes.setText(sampleRecipe.getCntLikes()+" likes");
        this.cntIngredientsInPantry.setText(sampleRecipe.getCntIngredientsInPantry()+" in pantry");
        this.cntIngredientsMissing.setText(sampleRecipe.getCntIngredientsMissing()+" missing");
        this.readyInMinutes.setText(sampleRecipe.getReadyInMinutes()+" mins");
    }

    private void IngredientsLayouter(ArrayList<ingredientData> ingredientList, ViewGroup parent, int insertAfterChildID) {
        // Util function to generate the views for pantry and missing ingredients
        // get index of the target child
        int index = 0;
        for (int i=0; i < parent.getChildCount(); i++) {
            if (parent.getChildAt(i).getId() == insertAfterChildID) {
                index = i;
                index++;
                break;
            }
        }

        LayoutInflater vi = (LayoutInflater) getLayoutInflater();

        for (ingredientData ingredient : ingredientList) {
            View listIngredients = vi.inflate(R.layout.list_ingredients, null);

            TextView ingredientAmt = (TextView) listIngredients.findViewById(R.id.ingredientAmt);
            ingredientAmt.setText(ingredient.getIngredientAmt() + " ");
            TextView ingredientName = (TextView) listIngredients.findViewById(R.id.ingredientName);
            ingredientName.setText(ingredient.getIngredientName());
            // Load image using Glide to downscale for memory efficiency
            Glide.with(this.getApplicationContext())
                    .load(ingredient.getIngredientImage())
                    .into((ImageView) listIngredients.findViewById(R.id.ingredientImage));

            // Need to make params for the ViewGroup programatically since the parent properties don't follow
            ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            Resources r = getResources();
            int px = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    20,
                    r.getDisplayMetrics()
            );
            params.setMargins(px, 0, px, 26);
            parent.addView(listIngredients, index, params);
            index++;
        }
    }

    private void showPantryIngredients() {
        IngredientsLayouter(recipeData.getRecipeIngredientsInPantry(), findViewById(R.id.parentLinearLayout), R.id.pantryIngredientsLabel);
    }

    private void showMissingIngredients() {
        IngredientsLayouter(recipeData.getRecipeIngredientsMissing(), findViewById(R.id.parentLinearLayout), R.id.missingIngredientsLabel);
    }

    private void InstructionsLayouter(int stepCnt, String instruction) {
        // Util function to insert instruction views


    }

    /* TODO: change logic later on */
    public void btnFavoriteClicked(View v) {
        if (recipeData.getIsFavorite()) {
            recipeData.setIsFavorite(false);
            btnFavorite.setImageResource(R.drawable.btn_favorite_off);
        }
        else {
            recipeData.setIsFavorite(true);
            btnFavorite.setImageResource(R.drawable.btn_favorite_on);
        }
    }
}