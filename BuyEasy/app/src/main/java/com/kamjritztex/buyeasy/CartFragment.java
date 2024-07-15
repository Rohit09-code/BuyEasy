package com.kamjritztex.buyeasy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CartFragment extends Fragment {

    private RecyclerView cartRecyclerView;
    private CartAdapter cartAdapter;
    private TextView totalPriceTextView;

    public static ArrayList<FashionItem> al = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        cartRecyclerView = view.findViewById(R.id.cartRecyclerView);
        totalPriceTextView = view.findViewById(R.id.totalPriceTextView);

        // Set up RecyclerView
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        cartAdapter = new CartAdapter(al);
        cartRecyclerView.setAdapter(cartAdapter);

        updateTotalPrice(al);

        Button checkoutButton = view.findViewById(R.id.checkoutButton);

        // Handle checkout button click
        checkoutButton.setOnClickListener(v -> {

            Intent intent = new Intent(getActivity(), CheckoutActivity.class);
            String text = totalPriceTextView.getText().toString();
            int totalPrice = extractNumericValue(text);
            intent.putExtra("total_price",totalPrice);
            startActivity(intent);
        });

        return view;
    }

    public static int extractNumericValue(String text) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        }
        return 0;
    }

    // Update total price based on cart items
    private void updateTotalPrice(List<FashionItem> items) {
        int totalPrice = 0;
        for (FashionItem item : items) {
            totalPrice += item.getOfferPrice() * item.getQuantity();
        }
        totalPriceTextView.setText("Total: ₹" + totalPrice);
    }
}
