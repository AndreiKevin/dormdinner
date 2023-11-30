package com.mobdeve.s16.chua.andreikevin.dormdinner;

public class ingredientData {
    private String ingredientName;
    private Double ingredientAmt;
    private String ingredientImage;

    public ingredientData(String ingredientName, String ingredientImage) {
        this.ingredientName = ingredientName;
        this.ingredientImage = ingredientImage;
    }

    public String getIngredientName() {
        return this.ingredientName;
    }

    public Double getIngredientAmt() {
        return this.ingredientAmt;
    }

    public String getIngredientImage() {
        return this.ingredientImage;
    }
}
