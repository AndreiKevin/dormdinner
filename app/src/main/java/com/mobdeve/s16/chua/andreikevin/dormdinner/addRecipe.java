package com.mobdeve.s16.chua.andreikevin.dormdinner;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class addRecipe extends AppCompatActivity{
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_recipe);

        url ="https://api.spoonacular.com/recipes/complexSearch";
    }
}
