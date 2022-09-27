package com.example.nectarproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHandler> {

    Context context;
    ArrayList <ProductModel> data = new ArrayList<>();

    public ProductAdapter(Context context, ArrayList<ProductModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ProductAdapter.ViewHandler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_list_item1, parent, false);
        return new ViewHandler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHandler holder, int position) {
        holder.productName.setText(data.get(position).getProductName());
        holder.productAmount.setText(data.get(position).getProductAmount());
        holder.productPrice.setText(data.get(position).getProductPrice());
        holder.productImage.setImageResource(data.get(position).getProductImage());
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
