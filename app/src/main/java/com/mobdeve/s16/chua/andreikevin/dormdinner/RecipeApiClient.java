package com.mobdeve.s16.chua.andreikevin.dormdinner;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecipeApiClient {
    private static final String BASE_URL = "https://api.spoonacular.com/";
    private static final String API_KEY = "a284a551561946fabbb45092a06f6376";
    private static final String number = "20";

    private RecipeApiService apiService;

    public RecipeApiClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(RecipeApiService.class);
    }

    public void searchRecipesByIngredients(List<String> ingredients, final ApiResponseCallback callback) {
        String ingredientString = TextUtils.join(",", ingredients);
        Call<List<Recipe>> call = apiService.searchRecipesByIngredients(ingredientString, API_KEY, number);

        call.enqueue(new Callback<List<Recipe>>() {
            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
                if (response.isSuccessful()) {
                    List<Recipe> recipes = response.body();
                    List<String> recipeNames = new ArrayList<>();
                    List<String> imageUrls = new ArrayList<>();
                    List<String> recipeIDs = new ArrayList<>();
                    ArrayList<Integer> likes = new ArrayList<>();
                    ArrayList<Integer> usedCount = new ArrayList<>();
                    ArrayList<Integer> missedCount = new ArrayList<>();

                    if (recipes != null) {
                        for (Recipe recipe : recipes) {
                            recipeIDs.add(recipe.getId());
                            likes.add(recipe.getLikes());
                            recipeNames.add(recipe.getName());
                            imageUrls.add(recipe.getImageUrl());
                            usedCount.add(recipe.getUsedIngredientCount());
                            missedCount.add(recipe.getMissedIngredientCount());
                        }
                    }

                    callback.onSuccess(recipeNames, imageUrls, recipeIDs, likes, usedCount, missedCount/*, amount*/);
                } else {
                    callback.onFailure("Failed to fetch recipes");
                }
            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {
                callback.onFailure(t.getMessage());
            }
        });
    }
}

