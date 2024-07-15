package com.kamjritztex.buyeasy;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FashionFragment extends Fragment {

    private RecyclerView recyclerView;
    private FashionAdapter adapter;
    private List<FashionItem> fashionItemList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fashion, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        fashionItemList = new ArrayList<>();

        // Add sample data
        fashionItemList.add(new FashionItem(R.drawable.high, "High Star", "Men Checked Regular Fit Shirt", "4.0", 39900, 2799, 74, 728));
        fashionItemList.add(new FashionItem(R.drawable.hrxab, "Hrx By Hrithik Roshan", "Abstract Printed Hooded Crop Sweatshirt With Shorts", "4.0", 4900, 1899, 22, 1481));
        fashionItemList.add(new FashionItem(R.drawable.hrx, "Hrx By Hrithik Roshan", "Women Striped Co-Ords Set", "4.4", 31794, 3299, 55, 1484));
        fashionItemList.add(new FashionItem(R.drawable.teamsprit, "TeamSprit", "Teamspirit Typographic Print Crew-Neck Top", "4.5", 940, 1799, 50, 899));
        fashionItemList.add(new FashionItem(R.drawable.fig, "FIG", "FIG Women Printed Shirt Dress ", "3.0", 2100, 2599, 30, 1899));
        fashionItemList.add(new FashionItem(R.drawable.women, "High Star", "DL Woman Viscose Modal Shirt", "4.2", 29900, 1799, 50, 899));
        fashionItemList.add(new FashionItem(R.drawable.roadster, "Roadster", "Regular Fit Striped Crew-Neck T-Shirt", "3.0", 4900, 799, 50, 349));
        fashionItemList.add(new FashionItem(R.drawable.dennis, "DENNISLINGO PREMIUM A...", "Classic Slim Fit Shirt with Full Sleeves", "3.6", 68900, 647, 65, 444));

        // Add more items...

        adapter = new FashionAdapter(fashionItemList, item -> {
            // Handle item click
            Intent intent = new Intent(getContext(), ProductActivity.class);
            intent.putExtra("item", item);
            startActivity(intent);
        });

        recyclerView.setAdapter(adapter);

        return view;
    }
}