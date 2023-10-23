package com.mobdeve.s16.chua.andreikevin.dormdinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class pantry extends AppCompatActivity {
    private ImageButton favs_on_btn, settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantry);


        favs_on_btn = findViewById(R.id.favoriteBtn_off);
        favsClicked(favs_on_btn);

        settings = findViewById(R.id.settings);
        settingsClicked(settings);

    }

    public void favsClicked(View v){
        Intent goFavs = new Intent(getApplicationContext(), favoriteRecipes.class);
        v.setOnClickListener(x -> {
            startActivity(goFavs);
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