package com.mobdeve.s16.chua.andreikevin.dormdinner.API;

import java.util.ArrayList;
import java.util.List;

public interface ApiResponseCallback {
    default void onSuccess(List<String> recipeNames) {

    }

    void onSuccess(List<String> recipeNames, List<String> imageUrls);

    void onFailure(String errorMessage);

    void onSuccess(List<String> recipeNames, List<String> imageUrls, ArrayList<Integer> usedCount, ArrayList<Integer> missedCount);
}
