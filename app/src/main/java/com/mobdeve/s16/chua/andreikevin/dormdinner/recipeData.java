package com.mobdeve.s16.chua.andreikevin.dormdinner;

import java.net.URL;
import java.util.ArrayList;

public class recipeData {
    private String recipeName;
    private URL recipeSource; /*TODO: change data type if need be*/
    private String recipeCredits;
    private Integer recipeBanner;
    private Integer cntIngredientsInPantry;
    private Integer cntIngredientsMissing;
    private Integer readyInMinutes;
    private Integer cntLikes;
    private ArrayList<String> recipeInstructions;
    private ArrayList<ingredientData> recipeIngredientsInPantry;
    private ArrayList<ingredientData> recipeIngredientsMissing;
    private boolean isFavorite;

    public recipeData(String recipeName, URL recipeSource, String recipeCredits,
                      Integer recipeBanner, Integer cntIngredientsInPantry, Integer cntIngredientsMissing, Integer readyInMinutes, Integer cntLikes,
                      ArrayList<String> recipeInstructions, ArrayList<ingredientData> recipeIngredientsInPantry, ArrayList<ingredientData> recipeIngredientsMissing, boolean isFavorite) {
        this.recipeName = recipeName;
        this.recipeSource = recipeSource;
        this.recipeCredits = recipeCredits;
        this.recipeBanner = recipeBanner;
        this.cntIngredientsInPantry = cntIngredientsInPantry;
        this.cntIngredientsMissing = cntIngredientsMissing;
        this.readyInMinutes = readyInMinutes;
        this.cntLikes = cntLikes;
        this.recipeInstructions = recipeInstructions;
        this.recipeIngredientsInPantry = recipeIngredientsInPantry;
        this.recipeIngredientsMissing = recipeIngredientsMissing;
        this.isFavorite = isFavorite;
    }

    public String getRecipeName() {
        return this.recipeName;
    }

    public URL getRecipeSource() {
        return this.recipeSource;
    }

    public String getRecipeCredits() {
        return this.recipeCredits;
    }

    public Integer getRecipeBanner() {
        return this.recipeBanner;
    }

    public Integer getCntIngredientsInPantry() {
        return this.cntIngredientsInPantry;
    }

    public Integer getCntIngredientsMissing() {
        return this.cntIngredientsMissing;
    }

    public Integer getReadyInMinutes() {
        return this.readyInMinutes;
    }

    public Integer getCntLikes() {
        return this.cntLikes;
    }

    public ArrayList<String> getRecipeInstructions() {
        return this.recipeInstructions;
    }

    public ArrayList<ingredientData> getRecipeIngredientsInPantry() {
        return this.recipeIngredientsInPantry;
    }

    public ArrayList<ingredientData> getRecipeIngredientsMissing() {
        return this.recipeIngredientsMissing;
    }

    public boolean getIsFavorite() {
        return this.isFavorite;
    }

    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }
}
