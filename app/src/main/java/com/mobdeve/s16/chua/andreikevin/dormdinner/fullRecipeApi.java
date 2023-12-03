package com.mobdeve.s16.chua.andreikevin.dormdinner;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class fullRecipeApi {
    private static final String BASE_URL = "https://api.spoonacular.com/";
    private static final String API_KEY = "a284a551561946fabbb45092a06f6376";

    private Retrofit retrofit;


    private fullRecipeApiService apiService;

    public fullRecipeApi() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(fullRecipeApiService.class);
    }

    public void searchRecipesByRecipe(String id, final recipeResponseCallback callback) {
        Call<FullRecipe> call = apiService.searchRecipe(id, API_KEY);

        call.enqueue(new Callback<FullRecipe>() {
            @Override
            public void onResponse(Call<FullRecipe> call, Response<FullRecipe> response) {
                if (response.isSuccessful()) {
                    FullRecipe recipes = response.body();
                    String title, imageUrls, creditsText;
                    List<String> instructions = new ArrayList<>();;
                    int readyInMinutes;

                    title = recipes.getName();

                    for(int i = 0; i < recipes.getInstructions().get(0).steps.size(); i++) {
                        instructions.add(recipes.getInstructions().get(0).steps.get(i).step);
                    }

                    imageUrls = recipes.getImageUrl();
                    readyInMinutes = recipes.getReadyInMinutes();
                    creditsText = recipes.getCredits();

                    List<ExtendedIngredient> extendedIngredients = recipes.getExtendedIngredients();
                    int ingredientCount = extendedIngredients.size();

                    List<String> originalIng = new ArrayList<>();
                    List<String> imgUrl = new ArrayList<>();
                    for (ExtendedIngredient ingredient : extendedIngredients) {
                        String name = ingredient.original;
                        originalIng.add(name);
                    }
                    for (ExtendedIngredient ingredient : extendedIngredients) {
                        String url = "https://spoonacular.com/cdn/ingredients_100x100/"+ingredient.image;
                        imgUrl.add(url);
                    }

                    callback.onSuccess(title, imageUrls, readyInMinutes, creditsText, originalIng, imgUrl, instructions);
                } else {
                    callback.onFailure("Failed to fetch recipes");
                }
            }

            @Override
            public void onFailure(Call<FullRecipe> call, Throwable t) {
                callback.onFailure(t.getMessage());
            }
        });
    }
}

