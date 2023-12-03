package com.mobdeve.s16.chua.andreikevin.dormdinner;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class favResultsViewHolder extends RecyclerView.ViewHolder {

    ImageView pic;
    ToggleButton pic2;
    TextView recipeName;


    public favResultsViewHolder(@NonNull View itemView) {
        super(itemView);

        pic = itemView.findViewById(R.id.resultRecyclerPic);
        recipeName = itemView.findViewById(R.id.recipeName);
    }
}

