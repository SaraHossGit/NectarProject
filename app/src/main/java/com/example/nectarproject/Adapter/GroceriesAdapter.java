//package com.example.nectarproject.Adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.nectarproject.R;
//import com.example.nectarproject.Repo.Local.GroceriesModel;
//
//import java.util.ArrayList;
//
//public class GroceriesAdapter extends RecyclerView.Adapter<GroceriesAdapter.ViewHolder>{
//
//    Context context;
//    ArrayList<GroceriesModel> data = new ArrayList<>();
//
//    public GroceriesAdapter(Context context, ArrayList<GroceriesModel> data) {
//        this.context = context;
//        this.data = data;
//    }
//
//    @NonNull
//    @Override
//    public GroceriesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_cat_item, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull GroceriesAdapter.ViewHolder holder, int position) {
////        holder.groceryCard.setCardBackgroundColor(data.get(position).getCardViewColor());
//        holder.groceryCard.setBackgroundColor(data.get(position).getCardViewColor());
//        holder.groceryName.setText(data.get(position).getGroceryName());
//        holder.groceryImage.setImageResource(data.get(position).getGroceryImage());
//    }
//
//    @Override
//    public int getItemCount() {
//        return data.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder{
//
//        TextView groceryName;
//        ImageView groceryImage;
//        LinearLayout groceryCard;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            groceryName = itemView.findViewById(R.id.grocery_name);
//            groceryImage = itemView.findViewById(R.id.grocery_image);
//            groceryCard = itemView.findViewById(R.id.layout_card_view);
//        }
//    }
//}
