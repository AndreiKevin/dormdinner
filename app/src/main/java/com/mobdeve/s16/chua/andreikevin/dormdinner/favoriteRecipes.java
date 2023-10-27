package com.mobdeve.s16.chua.andreikevin.dormdinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobdeve.s16.chua.andreikevin.dormdinner.database.DBHandler;
import com.mobdeve.s16.chua.andreikevin.dormdinner.recylerViewAdapter.Items;
import com.mobdeve.s16.chua.andreikevin.dormdinner.recylerViewAdapter.searchResultsAdapter;

import java.util.ArrayList;
import java.util.List;

public class favoriteRecipes extends AppCompatActivity {
    private ImageButton pantry_on_btn, settings;
    TextView txt;
    DBHandler db;
    Button delete;
    public List<Items> items = new ArrayList<Items>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite_recipes);

        pantry_on_btn = findViewById(R.id.pantryBtn_off);
        pantryClicked(pantry_on_btn);

        settings = findViewById(R.id.settings);
        settingsClicked(settings);

        //TODO experimental code:
        /*txt = findViewById(R.id.recipeNameFavs);
        delete = findViewById(R.id.delete);
        db = new DBHandler(this);
        txt.setText("Rosemary-Roasted Chicken with Potatoes");

        Cursor res = db.getData();

        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()){
            buffer.append("recipeName: " + res.getString(1) + "\n");
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
                if(checkdata == true){Toast.makeText(favoriteRecipes.this, "Deleted", Toast.LENGTH_SHORT).show();}
                else {Toast.makeText(favoriteRecipes.this, "Not deleted", Toast.LENGTH_SHORT).show();}
            }
        });*/
        //TODO experimental code

        RecyclerView recyclerView = findViewById(R.id.favsRecycler);

        items.add(new Items(R.drawable.roasted_chicken, false, 4, 3, "Rosemary-Roasted Chicken with Potatoes"));
        items.add(new Items(R.drawable.chicken_casserole, false, 0, 1, "Chicken and Apple Stuffing Casserole"));
        items.add(new Items(R.drawable.roasted_chicken, false, 4, 3, "Rosemary-Roasted Chicken with Potatoes"));
        items.add(new Items(R.drawable.chicken_casserole, false, 0, 1, "Chicken and Apple Stuffing Casserole"));
        items.add(new Items(R.drawable.roasted_chicken, false, 4, 3, "Rosemary-Roasted Chicken with Potatoes"));
        items.add(new Items(R.drawable.chicken_casserole, false, 0, 1, "Chicken and Apple Stuffing Casserole"));
        items.add(new Items(R.drawable.roasted_chicken, false, 4, 3, "Rosemary-Roasted Chicken with Potatoes"));
        items.add(new Items(R.drawable.chicken_casserole, false, 0, 1, "Chicken and Apple Stuffing Casserole"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new searchResultsAdapter(getApplicationContext(), items));
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