package com.kamjritztex.buyeasy;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new HomeFragment());

        NavigationBarView bottomNavigationView=findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id==R.id.home){
                    loadFragment(new HomeFragment());
                    return true;
                } else if (id==R.id.cart) {
                    loadFragment(new CartFragment());
                    return true;
                } else if (id==R.id.wishlist) {
                    loadFragment(new WishlistFragment());
                    return true;
                } else if (id==R.id.profile) {
                    loadFragment(new ProfileFragment());
                    return true;
                }

                return false;
            }
        });

    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.home_fragment_container,fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }


}