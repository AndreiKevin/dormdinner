package com.mobdeve.s16.chua.andreikevin.dormdinner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class fullRecipeAdapter extends RecyclerView.Adapter<fullRecipeAdapter.ViewHolder> {
    private String titles;
    private String imageUrls;
    private OnItemClickListener onItemClickListener;

    public void setRecipes(String title, String imageUrl) {
        this.titles = title;
        this.imageUrls = imageUrl;
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
        holder.recipeNameTextView.setText(titles);
        Picasso.with(holder.itemView.getContext()).load(imageUrls).into(holder.imageView);
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
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView recipeNameTextView;
        ImageView imageView;
        TextView yesAmt;
        TextView noAmt;

        public ViewHolder(View itemView) {
            super(itemView);
            recipeNameTextView = itemView.findViewById(R.id.recipeName);
            imageView = itemView.findViewById(R.id.recipeBanner);
        }
    }
}