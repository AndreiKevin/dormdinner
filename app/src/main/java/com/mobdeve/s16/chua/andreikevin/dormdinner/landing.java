package com.mobdeve.s16.chua.andreikevin.dormdinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class landing extends AppCompatActivity {
    private static final int DELAY = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing);

        Handler handler = new Handler();

        // Create a Runnable that calls the doSomething() method
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Intent favorite = new Intent(getApplicationContext(), favoriteRecipes.class);
                startActivity(favorite);
                finish();
            }
        };
        handler.postDelayed(runnable, DELAY);
    }
}