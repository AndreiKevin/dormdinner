package com.mobdeve.s16.chua.andreikevin.dormdinner.recylerViewAdapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobdeve.s16.chua.andreikevin.dormdinner.R;

public class searchResultsViewHolder extends RecyclerView.ViewHolder {

    ImageView pic;
    ImageView pic2;
    TextView recipeName;
    TextView have;
    TextView none;


    public searchResultsViewHolder(@NonNull View itemView) {
        super(itemView);

        pic = itemView.findViewById(R.id.pic);
        pic2 = itemView.findViewById(R.id.addToFav);
        recipeName = itemView.findViewById(R.id.recipeName);
        have = itemView.findViewById(R.id.yesAmt);
        none = itemView.findViewById(R.id.noAmt);
    }
}
