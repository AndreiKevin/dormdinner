package com.mobdeve.s16.chua.andreikevin.dormdinner;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class searchResultsViewHolder extends RecyclerView.ViewHolder {

    ImageView pic;
    ToggleButton pic2;
    TextView recipeName;
    TextView have;
    TextView none;


    public searchResultsViewHolder(@NonNull View itemView) {
        super(itemView);

        pic = itemView.findViewById(R.id.resultRecyclerPic);
        pic2 = itemView.findViewById(R.id.addToFav);
        recipeName = itemView.findViewById(R.id.recipeName);
        have = itemView.findViewById(R.id.yesAmt);
        none = itemView.findViewById(R.id.noAmt);
    }
}

