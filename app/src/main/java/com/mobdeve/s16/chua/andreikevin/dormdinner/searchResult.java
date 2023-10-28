package com.mobdeve.s16.chua.andreikevin.dormdinner;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobdeve.s16.chua.andreikevin.dormdinner.recylerViewAdapter.Adapter;
import com.mobdeve.s16.chua.andreikevin.dormdinner.recylerViewAdapter.Items;

import java.util.ArrayList;
import java.util.List;

public class searchResult extends AppCompatActivity {

    public List<Items> items = new ArrayList<Items>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_result);

        RecyclerView recyclerView = findViewById(R.id.searchResultRecycler);

        items.add(new Items("1", R.drawable.roasted_chicken, false, 4, 3, "Rosemary-Roasted Chicken with Potatoes"));
        items.add(new Items("2", R.drawable.chicken_casserole, false, 0, 1, "Chicken and Apple Stuffing Casserole"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Adapter adapter = new Adapter(this, items, position -> {
            Items item = items.get(position);
            Intent intent = new Intent(this, viewRecipe.class);
            intent.putExtra("itemId", item.getId());
            startActivity(intent);
        });
        recyclerView.setAdapter(adapter);
    }
}
