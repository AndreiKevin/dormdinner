package com.mobdeve.s16.chua.andreikevin.dormdinner.recylerViewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobdeve.s16.chua.andreikevin.dormdinner.R;
import com.mobdeve.s16.chua.andreikevin.dormdinner.database.DBHandler;

import java.util.List;

public class searchResultsAdapter extends RecyclerView.Adapter<searchResultsViewHolder> {

    Context context;
    List<Items> items;

    DBHandler dbHandler;

    public searchResultsAdapter(Context context, List<Items> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public searchResultsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new searchResultsViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull searchResultsViewHolder holder, int position) {
        holder.pic.setImageResource(items.get(position).getPic());
        holder.pic2.setImageResource(items.get(position).getPic2());
        holder.recipeName.setText(items.get(position).getRecipeName());
        holder.none.setText(Integer.toString(items.get(position).getNone()));
        holder.have.setText(Integer.toString(items.get(position).getHave()));

        dbHandler = new DBHandler(this.context);

        holder.pic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHandler.addNewFav(items.get(holder.getAdapterPosition()).getRecipeName()/*, items.get(holder.getAdapterPosition()).getPic()*/);
                Toast.makeText(context, "Added to bookmarked", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return items.size();
    }
}
