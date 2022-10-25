package com.example.nectarproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.nectarproject.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterViewHolder> {

    Context context;
    List<String> images; // list for storing urls of images.

    public SliderAdapter(Context context, List<String> images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public SliderAdapterViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new SliderAdapterViewHolder(view);
    }


    @Override
    public void onBindViewHolder(SliderAdapterViewHolder viewHolder, final int position) {
        // set data to item of Slider View.
        Glide.with(context)
                .load(images.get(position))
                .centerCrop()
                .into(viewHolder.imageView);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    static class SliderAdapterViewHolder extends SliderViewAdapter.ViewHolder {

        ImageView imageView;

        public SliderAdapterViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.details_product_image);

        }
    }
}

