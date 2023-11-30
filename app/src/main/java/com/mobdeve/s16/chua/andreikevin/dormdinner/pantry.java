package com.mobdeve.s16.chua.andreikevin.dormdinner;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class pantry extends AppCompatActivity {
    private ImageButton favs_on_btn, settings, search, btnAddIngredients;
    EditText editAddIngredients;
    ArrayList<String> ingredientList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantry);


        favs_on_btn = findViewById(R.id.favoriteBtn_off);
        favsClicked(favs_on_btn);

        settings = findViewById(R.id.settings);
        settingsClicked(settings);

        search = findViewById(R.id.search_btn_pantry);
        //searchClicked(search);

        this.btnAddIngredients = (ImageButton) findViewById(R.id.btnAddIngredients);
        this.editAddIngredients = (EditText) findViewById(R.id.editAddIngredients);

        TinyDB tinydb = new TinyDB(this);

        if(tinydb.getListString("PantryIngredients").size() > 0) {
            ingredientList = tinydb.getListString("PantryIngredients");
            for(int i = 0; i < ingredientList.size(); i++){
                LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View addView = layoutInflater.inflate(R.layout.new_ingredient_pantry, null);

                final TextView text = (TextView) addView.findViewById(R.id.ingredientPantry);
                text.setText(ingredientList.get(i));
                addView.setTag(ingredientList.get(i));

                ImageButton delete_ingredient = (ImageButton) addView.findViewById(R.id.btnTrashPantry);
                final View.OnClickListener thisListener = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((LinearLayout) addView.getParent()).removeView(addView);
                        ingredientList.remove(addView.getTag().toString());
                        tinydb.putListString("PantryIngredients", ingredientList);
                    }
                };

                delete_ingredient.setOnClickListener(thisListener);
                ((LinearLayout) findViewById(R.id.addIngredientsParent)).addView(addView);
            }
        }

        btnAddIngredients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View addView = layoutInflater.inflate(R.layout.new_ingredient_pantry, null);

                final TextView text = (TextView) addView.findViewById(R.id.ingredientPantry);
                text.setText(editAddIngredients.getText().toString());
                addView.setTag(editAddIngredients.getText().toString());

                ImageButton delete_ingredient = (ImageButton) addView.findViewById(R.id.btnTrashPantry);
                final View.OnClickListener thisListener = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((LinearLayout) addView.getParent()).removeView(addView);
                        ingredientList.remove(addView.getTag().toString());
                        tinydb.putListString("PantryIngredients", ingredientList);
                    }
                };

                delete_ingredient.setOnClickListener(thisListener);

                /* TODO: add text entered checker logic */

                String ingredient = editAddIngredients.getText().toString();
                ingredientList.add(ingredient);

                ((LinearLayout) findViewById(R.id.addIngredientsParent)).addView(addView);
                editAddIngredients.setText("");
                tinydb.putListString("PantryIngredients", ingredientList);
            }
        });

    }

    public void favsClicked(View v) {
        Intent goFavs = new Intent(getApplicationContext(), favoriteRecipes.class);
        v.setOnClickListener(x -> {
            startActivity(goFavs);
            this.finish();
        });
    }

    public void settingsClicked(View v) {
        Intent goSettings = new Intent(getApplicationContext(), settings.class);
        v.setOnClickListener(x -> {
            startActivity(goSettings);
        });
    }

    public void searchClicked(View v) {
        if(ingredientList.size() > 0) {
            Intent goSearchResults = new Intent(getApplicationContext(), searchResult.class);
            v.setOnClickListener(x -> {
                goSearchResults.putExtra("ingredientList", ingredientList);
                startActivity(goSearchResults);
            });
        }
        else {
            Toast.makeText(this, "Oops! Make sure to add ingredients in your pantry first.",
                    Toast.LENGTH_LONG).show();
        }
    }
}