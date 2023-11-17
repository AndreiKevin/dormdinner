package com.mobdeve.s16.chua.andreikevin.dormdinner;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface fullRecipeApiService {
    @GET("recipes/{id}/information")
    Call<FullRecipe> searchRecipe(
            @Path("id") String id,
            @Query("apiKey") String apiKey);
}