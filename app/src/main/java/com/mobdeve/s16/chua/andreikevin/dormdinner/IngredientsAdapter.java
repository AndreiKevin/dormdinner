package com.mobdeve.s16.chua.andreikevin.dormdinner;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.IngredientsViewHolder> {
    private ArrayList<ingredientData> ingredients;

    public static class IngredientsViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView name;
        public TextView amount;

        public IngredientsViewHolder(View v) {
            super(v);
            image = v.findViewById(R.id.ingredientImage);
            name = v.findViewById(R.id.ingredientName);
            amount = v.findViewById(R.id.ingredientAmt);
        }
    }

    public IngredientsAdapter(ArrayList<ingredientData> myDataset) {
        ingredients = myDataset;
    }

    @Override
    public IngredientsAdapter.IngredientsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create the view layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_ingredients, parent, false);
        IngredientsViewHolder vh = new IngredientsViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(IngredientsViewHolder holder, int position) {
        ingredientData data = ingredients.get(position);
        holder.amount.setText(data.getIngredientAmt() + " ");
        holder.name.setText(data.getIngredientName());

        // Glide library downscales the image to use less memory
        Glide.with(holder.image.getContext())
                .load(data.getIngredientImage())
                .into(holder.image);

        // Not downscaled version
        //holder.image.setImageResource(data.getIngredientImage());
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }
}

