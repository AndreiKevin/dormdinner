package com.mobdeve.s16.chua.andreikevin.dormdinner;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobdeve.s16.chua.andreikevin.dormdinner.recylerViewAdapter.searchResultsAdapter;
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
}
