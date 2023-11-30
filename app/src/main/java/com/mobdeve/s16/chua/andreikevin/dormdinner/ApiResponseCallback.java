package com.mobdeve.s16.chua.andreikevin.dormdinner;

import java.util.ArrayList;
import java.util.List;

public interface ApiResponseCallback {

    void onFailure(String errorMessage);

    void onSuccess(List<String> recipeNames, List<String> imageUrls, List<String> recipeID, ArrayList<Integer> likes, ArrayList<Integer> usedCount, ArrayList<Integer> missedCount/*, ArrayList<Integer> amount*/);
}
