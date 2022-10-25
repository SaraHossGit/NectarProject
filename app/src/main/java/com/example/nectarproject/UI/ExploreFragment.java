package com.example.nectarproject.UI;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nectarproject.Adapter.CategoriesAdapter;
import com.example.nectarproject.R;
import com.example.nectarproject.Repo.Local.CategoriesModel;
import com.example.nectarproject.ViewModel.ExploreViewModel;

import java.util.ArrayList;
import java.util.List;

public class ExploreFragment extends Fragment {

    private ExploreViewModel mViewModel;
    RecyclerView recyclerView;
    CategoriesAdapter categoriesAdapter;

    ArrayList <CategoriesModel> categoriesModelsList = new ArrayList<>();
    // Groceries Data
    int[] catImage = {R.drawable.smartphones, R.drawable.laptops, R.drawable.fragrances,
            R.drawable.skincare, R.drawable.groceries, R.drawable.home_decoration, R.drawable.furniture,
            R.drawable.tops, R.drawable.womens_dresses, R.drawable.womens_shoes, R.drawable.mens_shirts,
            R.drawable.mens_shoes, R.drawable.mens_watches, R.drawable.womens_watches, R.drawable.womens_bags,
            R.drawable.womens_jewellery, R.drawable.sunglasses, R.drawable.automotive, R.drawable.motorcycle,
            R.drawable.lighting
    };

    int[] cardViewColor = {Color.parseColor("#26F8A44C"), Color.parseColor("#2653B175"),
            Color.parseColor("#40D3B0E0"),Color.parseColor("#40B7DFF5"),
            Color.parseColor("#26F8A44C"), Color.parseColor("#2653B175"),
            Color.parseColor("#40D3B0E0"),Color.parseColor("#40B7DFF5"),
            Color.parseColor("#26F8A44C"), Color.parseColor("#2653B175"),
            Color.parseColor("#40D3B0E0"),Color.parseColor("#40FDE598"),
            Color.parseColor("#26F8A44C"), Color.parseColor("#2653B175"),
            Color.parseColor("#40D3B0E0"),Color.parseColor("#40B7DFF5"),
            Color.parseColor("#26F8A44C"), Color.parseColor("#2653B175"),
            Color.parseColor("#40D3B0E0"),Color.parseColor("#40FDE598")};

    public static ExploreFragment newInstance() {
        return new ExploreFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_explore, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ExploreViewModel.class);

        ExploreViewModel CategoriesVM = new ViewModelProvider(this).get(ExploreViewModel.class);
        CategoriesVM.getCategoriesList(getContext()).observe(getViewLifecycleOwner(), new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> catList) {

                setCategories(catList);

            }
        });


    }

    private void setCategories(List<String> catList) {

        for (int i = 0; i < catList.size();i++){
            categoriesModelsList.add(new CategoriesModel(
                    CategoriesModel.MAX_VIEW,
                    cardViewColor[i],
                    catImage[i],
                    catList.get(i)
            ));
        }
        recyclerView = getView().findViewById(R.id.explore_recycler_view);
        categoriesAdapter = new CategoriesAdapter(getContext(), categoriesModelsList);
        recyclerView.setAdapter(categoriesAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

    }

}