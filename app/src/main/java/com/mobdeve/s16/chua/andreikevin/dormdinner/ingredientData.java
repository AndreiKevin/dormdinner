package com.mobdeve.s16.chua.andreikevin.dormdinner;

public class ingredientData {
    private String ingredientName;
    private Double ingredientAmt;
    private String ingredientImage;

    public ingredientData(String ingredientName) {
        this.ingredientName = ingredientName;
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
