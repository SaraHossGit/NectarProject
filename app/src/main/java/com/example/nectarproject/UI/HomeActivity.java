package com.example.nectarproject.UI;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.nectarproject.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView navBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        navBar = findViewById(R.id.bottom_navigation);

        final FragmentManager fragmentManager = getSupportFragmentManager();


        // define your fragments here
        final Fragment fragment1 = new ShopFragment();
        final Fragment fragment2 = new ExploreFragment();
//        final Fragment fragment3 = new ThirdFragment();
        fragmentManager.beginTransaction().replace(R.id.rlContainer, fragment1).commit();

        // handle navigation selection
        navBar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.page_1:
                        fragment = fragment1;
                        break;
                    case R.id.page_2:
                        fragment = fragment2;
                        break;
                    case R.id.page_3:
                    default:
//                        fragment = fragment3;
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.rlContainer, fragment).commit();
                return true;
            }
        });




    }


}