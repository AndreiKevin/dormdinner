package com.mobdeve.s16.chua.andreikevin.dormdinner;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecipeApiService {
    @GET("recipes/findByIngredients")
    Call<List<Recipe>> searchRecipesByIngredients(
            @Query("ingredients") String ingredients,
            @Query("apiKey") String apiKey,
            @Query("number") String number);
}