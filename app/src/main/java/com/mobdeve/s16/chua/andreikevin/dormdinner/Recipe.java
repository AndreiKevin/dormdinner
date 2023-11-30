package com.mobdeve.s16.chua.andreikevin.dormdinner;

import com.google.gson.annotations.SerializedName;

public class Recipe {
    @SerializedName("id")
    private String id;

    @SerializedName("title")
    private String name;

    @SerializedName("image")
    private String image;

    @SerializedName("likes")
    private int likes;

    public int getAmount() {
        return amount;
    }

    @SerializedName("amount")
    private int amount;

    public int getUsedIngredientCount() {
        return usedIngredientCount;
    }

    public int getLikes(){ return likes; }

    public int getMissedIngredientCount() {
        return missedIngredientCount;
    }

    @SerializedName("usedIngredientCount")
    private int usedIngredientCount;

    @SerializedName("missedIngredientCount")
    private int missedIngredientCount;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return image;
    }
}
