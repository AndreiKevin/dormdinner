package com.mobdeve.s16.chua.andreikevin.dormdinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class favoriteRecipes extends AppCompatActivity {
    private ImageButton pantry_on_btn, settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite_recipes);

        pantry_on_btn = findViewById(R.id.pantryBtn_off);
        pantryClicked(pantry_on_btn);

        settings = findViewById(R.id.settings);
        settingsClicked(settings);

    }

    public void pantryClicked(View v){
        Intent goPantry = new Intent(getApplicationContext(), pantry.class);
        v.setOnClickListener(x -> {
            startActivity(goPantry);
            this.finish();
        });
    }

    public void settingsClicked(View v){
        Intent goSettings = new Intent(getApplicationContext(), settings.class);
        v.setOnClickListener(x -> {
            startActivity(goSettings);
        });
    }
}