package com.mobdeve.s16.chua.andreikevin.dormdinner;

import java.util.List;

public interface recipeResponseCallback {

    void onFailure(String errorMessage);

    void onSuccess(String title, String imageUrls, int readyInMinutes, String credits, List<String> extraName, List<String> imgUrl, String[] instructions);
}
