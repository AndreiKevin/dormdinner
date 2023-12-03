package com.mobdeve.s16.chua.andreikevin.dormdinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterFavorites extends RecyclerView.Adapter<favResultsViewHolder> {

    Context context;
    List<Items> items;

    private ItemClickListener itemClickListener;

    DBHandler dbHandler;

    public interface ItemClickListener {
        void onItemClicked(int position);
    }

    public AdapterFavorites(Context context, List<Items> items, ItemClickListener itemClickListener) {
        this.context = context;
        this.items = items;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public favResultsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new favResultsViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view_2, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull favResultsViewHolder holder, int position) {
        dbHandler = new DBHandler(context);
        Picasso.with(context).load(items.get(position).getPic()).into(holder.pic);
        holder.recipeName.setText(items.get(position).getRecipeName());
        holder.itemView.setOnClickListener(v -> itemClickListener.onItemClicked(position));

        dbHandler = new DBHandler(this.context);

        Items itemlist = items.get(position);


        /*holder.pic2.setOnClickListener(v -> {
            SQLiteDatabase db = dbHandler.getWritableDatabase();
            Cursor cursor = db.rawQuery("Select * from favoriteRecipes where recipe_name = ?", new String[]{items.get(holder.getAdapterPosition()).getRecipeName()});
            if (cursor.getCount() > 0){
                dbHandler.deleteData(items.get(position).getRecipeName());
                Toast.makeText(context, "Recipe removed from bookmark!", Toast.LENGTH_SHORT).show();
                holder.pic2.setOnCheckedChangeListener((buttonView, isChecked) -> {
                    itemlist.setToggled(isChecked);
                });
            } else {
                dbHandler.addNewFav(items.get(holder.getAdapterPosition()).getRecipeName()/*, items.get(holder.getAdapterPosition()).getPic()*//*);
                Toast.makeText(context, "Added to bookmarked", Toast.LENGTH_SHORT).show();
                holder.pic2.setOnCheckedChangeListener((buttonView, isChecked) -> {
                    itemlist.setToggled(isChecked);
                });
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

