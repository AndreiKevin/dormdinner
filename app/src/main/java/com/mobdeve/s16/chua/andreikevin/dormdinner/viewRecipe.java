package com.mobdeve.s16.chua.andreikevin.dormdinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
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
    recipeData sampleRecipe1;

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
            sampleRecipe1 = new recipeData("Baked Chicken Thighs with Apples and Onions",
                                                        new URL("https://www.allrecipes.com/cook/fabeveryday"),
                                                        "fabeveryday",
                                                        R.drawable.sample_recipe_1,
                                                        recipeIngredientsInPantry.size(), recipeIngredientsMissing.size(),
                                                        45, 17, instructions,
                                                        recipeIngredientsInPantry, recipeIngredientsMissing, false);

            // Load the recipe
            setDataToLayout(sampleRecipe1);

            // The available ingredient list will be shown as recycler view
            RecyclerView ingredientsRecycler = findViewById(R.id.ingredientsRecycler);
            ingredientsRecycler.setHasFixedSize(true);

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            ingredientsRecycler.setLayoutManager(layoutManager);

            IngredientsAdapter mAdapter = new IngredientsAdapter(sampleRecipe1.getRecipeIngredientsInPantry());
            ingredientsRecycler.setAdapter(mAdapter);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
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


    /* TODO: change logic later on */
    public void btnFavoriteClicked(View v) {
        if (sampleRecipe1.getIsFavorite()) {
            sampleRecipe1.setIsFavorite(false);
            btnFavorite.setImageResource(R.drawable.btn_favorite_off);
        }
        else {
            sampleRecipe1.setIsFavorite(true);
            btnFavorite.setImageResource(R.drawable.btn_favorite_on);
        }
    }
}