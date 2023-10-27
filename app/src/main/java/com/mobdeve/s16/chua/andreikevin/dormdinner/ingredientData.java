package com.mobdeve.s16.chua.andreikevin.dormdinner;

public class ingredientData {
    private String ingredientName;
    private String ingredientAmt;
    private Integer ingredientImage;

    public ingredientData(String ingredientName, String ingredientAmt, Integer ingredientImage) {
        this.ingredientName = ingredientName;
        this.ingredientAmt = ingredientAmt;
        this.ingredientImage = ingredientImage;
    }

    public String getIngredientName() {
        return this.ingredientName;
    }

    public String getIngredientAmt() {
        return this.ingredientAmt;
    }

    public Integer getIngredientImage() {
        return this.ingredientImage;
    }
}
