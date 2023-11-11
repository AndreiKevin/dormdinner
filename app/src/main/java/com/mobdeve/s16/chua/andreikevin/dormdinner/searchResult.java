package com.mobdeve.s16.chua.andreikevin.dormdinner;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobdeve.s16.chua.andreikevin.dormdinner.API.ApiResponseCallback;
import com.mobdeve.s16.chua.andreikevin.dormdinner.API.RecipeAdapter;
import com.mobdeve.s16.chua.andreikevin.dormdinner.API.RecipeApiClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class searchResult extends AppCompatActivity {

    public List<Items> items = new ArrayList<Items>();
    private RecipeApiClient recipeApiClient;
    public RecipeAdapter recipeAdapter;
    private RecyclerView recipesRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_result);

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
            public void onSuccess(List<String> recipeNames, List<String> imageUrls) {
            }

            @Override
            public void onSuccess(List<String> recipeNames, List<String> imageUrls, ArrayList<Integer> usedCount, ArrayList<Integer> missedCount) {
                recipeAdapter.setRecipes(recipeNames, imageUrls, usedCount, missedCount);
                recipeAdapter.setOnItemClickListener(new RecipeAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        // Get the clicked recipe name and image URL
                        String recipeName = recipeNames.get(position);
                        String imageUrl = imageUrls.get(position);

                        // Create an intent and pass the relevant data to the new activity
                        Intent intent = new Intent(searchResult.this, viewRecipe.class);
                        intent.putExtra("recipeName", recipeName);
                        intent.putExtra("imageUrl", imageUrl);
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
