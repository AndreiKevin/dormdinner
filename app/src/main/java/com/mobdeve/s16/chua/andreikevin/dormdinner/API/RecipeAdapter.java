package com.mobdeve.s16.chua.andreikevin.dormdinner.API;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobdeve.s16.chua.andreikevin.dormdinner.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    private List<String> recipes;
    private List<String> imageUrls;
    private ArrayList<Integer> usedIngredientCount;
    private ArrayList<Integer> missedIngredientCount;
    private OnItemClickListener onItemClickListener;

    public void setRecipes(List<String> recipes, List<String> imageUrls, ArrayList<Integer> usedIngredientCount, ArrayList<Integer> missedIngredientCount) {
        this.recipes = recipes;
        this.imageUrls = imageUrls;
        this.missedIngredientCount = missedIngredientCount;
        this.usedIngredientCount = usedIngredientCount;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String recipeName = recipes.get(position);
        String imageUrl = imageUrls.get(position);
        holder.recipeNameTextView.setText(recipeName);

        int usedCount = usedIngredientCount.get(position);
        holder.yesAmt.setText(String.valueOf(usedCount));
        int missedCount = missedIngredientCount.get(position);
        holder.noAmt.setText(String.valueOf(missedCount));

        Picasso.with(holder.itemView.getContext()).load(imageUrl).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return recipes != null ? recipes.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView recipeNameTextView;
        ImageView imageView;
        TextView yesAmt;
        TextView noAmt;

        public ViewHolder(View itemView) {
            super(itemView);
            recipeNameTextView = itemView.findViewById(R.id.recipeName);
            imageView = itemView.findViewById(R.id.resultRecyclerPic);
            yesAmt = itemView.findViewById(R.id.yesAmt);
            noAmt = itemView.findViewById(R.id.noAmt);
        }
    }
}