package com.mobdeve.s16.chua.andreikevin.dormdinner.recylerViewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobdeve.s16.chua.andreikevin.dormdinner.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<searchResultsViewHolder> {

    Context context;
    List<Items> items;
    private ItemClickListener itemClickListener;

    public interface ItemClickListener {
        void onItemClicked(int position);
    }

    public Adapter(Context context, List<Items> items, ItemClickListener itemClickListener) {
        this.context = context;
        this.items = items;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public searchResultsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new searchResultsViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull searchResultsViewHolder holder, int position) {
        holder.pic.setImageResource(items.get(position).getPic());
        holder.recipeName.setText(items.get(position).getRecipeName());
        holder.none.setText(Integer.toString(items.get(position).getNone()));
        holder.have.setText(Integer.toString(items.get(position).getHave()));

        // Listener to navigate to recipe page
        holder.itemView.setOnClickListener(v -> itemClickListener.onItemClicked(position));

    }


    @Override
    public int getItemCount() {
        return items.size();
    }
}
