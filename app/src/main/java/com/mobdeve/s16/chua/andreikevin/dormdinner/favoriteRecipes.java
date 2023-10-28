package com.mobdeve.s16.chua.andreikevin.dormdinner;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobdeve.s16.chua.andreikevin.dormdinner.database.DBHandler;
import com.mobdeve.s16.chua.andreikevin.dormdinner.recylerViewAdapter.Adapter;
import com.mobdeve.s16.chua.andreikevin.dormdinner.recylerViewAdapter.Items;

import java.util.ArrayList;
import java.util.List;

public class favoriteRecipes extends AppCompatActivity {
    private ImageButton pantry_on_btn, settings;
    TextView txt;
    DBHandler db;
    Button delete;
    Adapter.ItemClickListener itemClickListener;
    public List<Items> items1 = new ArrayList<Items>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite_recipes);

        pantry_on_btn = findViewById(R.id.pantryBtn_off);
        pantryClicked(pantry_on_btn);

        settings = findViewById(R.id.settings);
        settingsClicked(settings);

        //TODO experimental code:
        txt = findViewById(R.id.recipeNameFavs);
        delete = findViewById(R.id.delete);
        db = new DBHandler(this);
        txt.setText(" ");

        Cursor res = db.getData();

        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()){
            buffer.append("\n" + "recipeName: " + res.getString(1) + "\n");
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(favoriteRecipes.this);
        builder.setCancelable(true);
        builder.setTitle("Bookmarked");
        builder.setMessage(buffer.toString());
        builder.show();

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = txt.getText().toString();
                Boolean checkdata = db.deleteData(text);
                if(checkdata == true){
                    Toast.makeText(favoriteRecipes.this, "Deleted", Toast.LENGTH_SHORT).show();}
                else {Toast.makeText(favoriteRecipes.this, "Not deleted", Toast.LENGTH_SHORT).show();}
            }
        });
        //TODO experimental code

        RecyclerView recyclerView = findViewById(R.id.favsRecycler);

        items1.add(new Items("1", R.drawable.roasted_chicken, false, 4, 3, "Rosemary-Roasted Chicken with Potatoes"));
        items1.add(new Items("2", R.drawable.chicken_casserole, false, 0, 1, "Chicken and Apple Stuffing Casserole"));
        items1.add(new Items("3", R.drawable.roasted_chicken, false, 4, 3, "Rosemary-Roasted Chicken with Potatoes"));
        items1.add(new Items("4", R.drawable.chicken_casserole, false, 0, 1, "Chicken and Apple Stuffing Casserole"));
        items1.add(new Items("5", R.drawable.roasted_chicken, false, 4, 3, "Rosemary-Roasted Chicken with Potatoes"));
        items1.add(new Items("6", R.drawable.chicken_casserole, false, 0, 1, "Chicken and Apple Stuffing Casserole"));
        items1.add(new Items("7", R.drawable.roasted_chicken, false, 4, 3, "Rosemary-Roasted Chicken with Potatoes"));
        items1.add(new Items("8", R.drawable.chicken_casserole, false, 0, 1, "Chicken and Apple Stuffing Casserole"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Adapter adapter = new Adapter(this, items1, position -> {
            Items item = items1.get(position);
            Intent intent = new Intent(this, viewRecipe.class);
            intent.putExtra("itemId", item.getId());
            startActivity(intent);
        });
        recyclerView.setAdapter(adapter);
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

    public void sampleRecipeClicked(View v){
        Intent goSampleRecipe = new Intent(getApplicationContext(), viewRecipe.class);
        v.setOnClickListener(x -> {
            startActivity(goSampleRecipe);
        });
    }
}