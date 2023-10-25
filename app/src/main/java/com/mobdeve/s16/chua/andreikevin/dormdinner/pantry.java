package com.mobdeve.s16.chua.andreikevin.dormdinner;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class pantry extends AppCompatActivity {
    private ImageButton favs_on_btn, settings, search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantry);

        favs_on_btn = findViewById(R.id.favoriteBtn_off);
        favsClicked(favs_on_btn);

        settings = findViewById(R.id.settings);
        settingsClicked(settings);

        search = findViewById(R.id.search_btn_pantry);
        searchClicked(search);
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

    public void searchClicked(View v){
        Intent goSearchResults = new Intent(getApplicationContext(), searchResult.class);
        v.setOnClickListener(x -> {
            startActivity(goSearchResults);
        });
    }
}