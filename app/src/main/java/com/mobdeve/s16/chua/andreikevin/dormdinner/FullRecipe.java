package com.mobdeve.s16.chua.andreikevin.dormdinner;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class FullRecipe {
    @SerializedName("title")
    private String name;

    @SerializedName("image")
    private String image;

    @SerializedName("sourceName")
    private String sourceName;

    @SerializedName("usedIngredientCount")
    private int usedIngredientCount;

    @SerializedName("missedIngredientCount")
    private int missedIngredientCount;
    @SerializedName("readyInMinutes")
    private int readyInMinutes;

    @SerializedName("creditsText")
    private String credits;

    public List<ExtendedIngredient> getExtendedIngredients() {
        return extendedIngredients;
    }

    @SerializedName("extendedIngredients")
    private List<ExtendedIngredient> extendedIngredients;

    @SerializedName("instructions")
    private String instructions;

    public String getInstructions() { return instructions; }

    public int getReadyInMinutes() {
        return readyInMinutes;
    }

    public String getCredits(){ return credits; }

    public int getUsedIngredientCount() {
        return usedIngredientCount;
    }

    public int getMissedIngredientCount() {
        return missedIngredientCount;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return image;
    }
}
