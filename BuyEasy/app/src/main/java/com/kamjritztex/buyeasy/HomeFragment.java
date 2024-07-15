package com.kamjritztex.buyeasy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;



public class HomeFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Set click listeners for menu items
        view.findViewById(R.id.menu_mobile).setOnClickListener(v -> loadFragment(new MobileFragment()));
        view.findViewById(R.id.menu_fashion).setOnClickListener(v -> loadFragment(new FashionFragment()));
        view.findViewById(R.id.menu_electronics).setOnClickListener(v -> loadFragment(new ElectronicsFragment()));
        view.findViewById(R.id.menu_tvs).setOnClickListener(v -> loadFragment(new TvFragment()));
        view.findViewById(R.id.menu_smart).setOnClickListener(v -> loadFragment(new SmartGadgetsFragment()));
        view.findViewById(R.id.menu_toys).setOnClickListener(v -> loadFragment(new ToysFragment()));

        // Load the default fragment
        if (savedInstanceState == null) {
            loadFragment(new FashionFragment());
        }

        return view;
    }


    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}