package com.mobdeve.s16.chua.andreikevin.dormdinner;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class searchResult extends AppCompatActivity {

    public List<Items> items = new ArrayList<Items>();
    private RecipeApiClient recipeApiClient;
    public RecipeAdapter recipeAdapter;
    private RecyclerView recipesRecyclerView;
    private TextView totalCnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_result);

        totalCnt = findViewById(R.id.numCount);
        recipesRecyclerView = findViewById(R.id.searchResultRecycler);
        Intent intent = getIntent();
        ArrayList<String> ingredientList = intent.getStringArrayListExtra("ingredientList");
        recipeApiClient = new RecipeApiClient();
        recipeAdapter = new RecipeAdapter();

        String joined = "";

        for (int i = 0; i < ingredientList.size(); i++) {
            joined += ingredientList.get(i);

            // Add a comma except for the last element
            if (i < ingredientList.size() - 1) {
                joined += ",";
            }
        }
        List<String> ingredientLists = Arrays.asList(joined.split(","));

        recipeApiClient.searchRecipesByIngredients(ingredientLists, new ApiResponseCallback() {
            @Override
            public void onSuccess(List<String> recipeNames, List<String> imageUrls, List<String> recipeID, ArrayList<Integer> likes, ArrayList<Integer> usedCount, ArrayList<Integer> missedCount/*, ArrayList<Integer> amount*/) {
                recipeAdapter.setRecipes(recipeNames, imageUrls, recipeID, likes, usedCount, missedCount);
                totalCnt.setText(String.valueOf(recipeAdapter.getItemCount()));
                recipeAdapter.setOnItemClickListener(new RecipeAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        // Get the clicked recipe name and image URL
                        int countUsed = usedCount.get(position);
                        int countMissed = missedCount.get(position);
                        String recipeIDs = recipeID.get(position);
                        int numLikes = likes.get(position);

                        // Create an intent and pass the relevant data to the new activity
                        Intent intent = new Intent(searchResult.this, viewRecipe.class);
                        intent.putExtra("usedCount", countUsed);
                        intent.putExtra("missedCount", countMissed);
                        intent.putExtra("recipeID", recipeIDs);
                        intent.putExtra("likes", numLikes);
                        intent.putExtra("ingredientList", ingredientList);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(String errorMessage) {
                Toast.makeText(searchResult.this, errorMessage, Toast.LENGTH_SHORT).show();
            }
        });

        recipesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        recipesRecyclerView.setAdapter(recipeAdapter);

        /*items.add(new Items("1", R.drawable.roasted_chicken, false, 4, 3, "Rosemary-Roasted Chicken with Potatoes"));
        items.add(new Items("2", R.drawable.chicken_casserole, false, 0, 1, "Chicken and Apple Stuffing Casserole"));*/

        /*recipesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        Adapter adapter = new Adapter(this, items, position -> {
            Items item = items.get(position);
            Intent intent2 = new Intent(this, viewRecipe.class);
            intent2.putExtra("itemId", item.getId());
            startActivity(intent2);
        });
        recipesRecyclerView.setAdapter(adapter);*/
    }
}
