package com.example.nectarproject.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.nectarproject.R;
import com.example.nectarproject.Repo.Remote.ProductModel;
import com.example.nectarproject.UI.DetailsActivity;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHandler> {

    Context context;
    List<ProductModel> data;

    public ProductAdapter(Context context, List<ProductModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ProductAdapter.ViewHandler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_product_item, parent, false);
        return new ViewHandler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHandler holder, int position) {
        holder.productName.setText(data.get(position).getProductName());
//        holder.productAmount.setText(data.get(position).getProductStock());
//        holder.productPrice.setText(data.get(position).getProductPrice());
//        holder.productImage.setImageResource(data.get(position).getProductImage());
        Glide.with(context)
                .load(data.get(position).getProductImage())
                .centerCrop()
                .into(holder.productImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsActivity.class);
//                intent.putExtra("movieSelected", viewHolder.getBindingAdapterPosition());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHandler extends RecyclerView.ViewHolder{

        TextView productName, productAmount, productPrice;
        ImageView productImage;

        public ViewHandler(@NonNull View itemView) {
            super(itemView);

            productName = itemView.findViewById(R.id.product_name);
            productAmount = itemView.findViewById(R.id.product_amount);
            productPrice = itemView.findViewById(R.id.product_price);
            productImage = itemView.findViewById(R.id.product_image);
        }
    }
}
