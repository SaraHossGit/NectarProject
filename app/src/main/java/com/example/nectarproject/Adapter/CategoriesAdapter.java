package com.example.nectarproject.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.nectarproject.R;
import com.example.nectarproject.Repo.Local.CategoriesModel;
import com.example.nectarproject.UI.CatSearchActivity;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter {

    Context context;
    List<CategoriesModel> categoriesList;

    public CategoriesAdapter(Context context, List<CategoriesModel> categoriesList) {
        this.context = context;
        this.categoriesList = categoriesList;
    }

    // To determine whether we are holding the minimized or maximized view
    @Override
    public int getItemViewType(int position) {

        switch (categoriesList.get(position).type) {
            case 0:
                return CategoriesModel.MAX_VIEW;
            case 1:
                return CategoriesModel.MIN_VIEW;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType){
            case CategoriesModel.MAX_VIEW:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_cat_item2, parent, false);
                return new MaxViewHolder(view);
            case CategoriesModel.MIN_VIEW:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_cat_item, parent, false);
                return new MinViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        CategoriesModel currentCat = categoriesList.get(position);
        switch (currentCat.type){
            case CategoriesModel.MIN_VIEW:
                ((MinViewHolder) holder).productName.setText(categoriesList.get(position).getCatName());
                ((MinViewHolder) holder).catCard.setBackgroundColor(categoriesList.get(position).getCardViewColor());
                ((MinViewHolder) holder).catImage.setImageResource(categoriesList.get(position).getCatImage());

                // Intent on the details page of the selected category
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(context, CatSearchActivity.class);
                        int catIdx =holder.getAdapterPosition();
                        i.putExtra("cat",categoriesList.get(catIdx).getCatName());
                        context.startActivity(i);
                    }
                });
                break;

            case CategoriesModel.MAX_VIEW:
                ((MaxViewHolder) holder).productName.setText(categoriesList.get(position).getCatName());
                ((MaxViewHolder) holder).catCard.setBackgroundColor(categoriesList.get(position).getCardViewColor());
                ((MaxViewHolder) holder).catImage.setImageResource(categoriesList.get(position).getCatImage());

                // Intent on the details page of the selected category
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(context, CatSearchActivity.class);
                        int catIdx =holder.getAdapterPosition();
                        i.putExtra("cat",categoriesList.get(catIdx).getCatName());
                        context.startActivity(i);
                    }
                });
                break;

        }
    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    // To hold the items from the model
    public class MinViewHolder extends RecyclerView.ViewHolder{

        public TextView productName;
        public ImageView catImage;
        public LinearLayout catCard;

        public MinViewHolder(@NonNull View itemView) {
            super(itemView);

            productName = itemView.findViewById(R.id.min_cat_name);
            catImage = itemView.findViewById(R.id.min_cat_image);
            catCard = itemView.findViewById(R.id.min_layout_card_view);

        }
    }


    // To hold the title
    public class MaxViewHolder extends RecyclerView.ViewHolder{

        public TextView productName;
        public ImageView catImage;
        public LinearLayout catCard;

        public MaxViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.max_cat_name);
            catImage = itemView.findViewById(R.id.max_cat_image);
            catCard = itemView.findViewById(R.id.max_layout_card_view);
        }
    }
}
