package com.mobdeve.s16.chua.andreikevin.dormdinner.API;

import com.google.gson.annotations.SerializedName;

public class Recipe {
    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String name;

    @SerializedName("image")
    private String image;

    public int getUsedIngredientCount() {
        return usedIngredientCount;
    }

    public int getMissedIngredientCount() {
        return missedIngredientCount;
    }

    @SerializedName("usedIngredientCount")
    private int usedIngredientCount;

    @SerializedName("missedIngredientCount")
    private int missedIngredientCount;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return image;
    }
}
