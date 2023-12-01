package com.mobdeve.s16.chua.andreikevin.dormdinner;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class settings extends AppCompatActivity {

    SeekBar sliderSettings;
    TextView sliderValue;
    ImageButton btnAddAvoidIngredients;
    EditText editAddAvoidIngredients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        //this.sliderSettings = (SeekBar) findViewById(R.id.sliderSettings);
        //this.sliderValue = (TextView) findViewById(R.id.sliderValue);
        this.btnAddAvoidIngredients = (ImageButton) findViewById(R.id.btnAddAvoidIngredients);
        this.editAddAvoidIngredients = (EditText) findViewById(R.id.editAddAvoidIngredients);

        btnAddAvoidIngredients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View addView = layoutInflater.inflate(R.layout.new_ingredient_settings, null);

                final TextView text = (TextView) addView.findViewById(R.id.ingredientSettings);
                text.setText(editAddAvoidIngredients.getText().toString());

                ImageButton delete_ingredient = (ImageButton) addView.findViewById(R.id.btnTrashSettings);
                final View.OnClickListener thisListener = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((LinearLayout) addView.getParent()).removeView(addView);
                    }
                };

                delete_ingredient.setOnClickListener(thisListener);
                /* TODO: add text entered checker logic */
                ((LinearLayout) findViewById(R.id.avoidIngredientsParent)).addView(addView);
                editAddAvoidIngredients.setText("");
            }

        });
    }
}