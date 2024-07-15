package com.kamjritztex.buyeasy;


import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {

    private ImageView imageView,heartIcon;
    private TextView nameTextView, descriptionTextView, ratingTextView, ratingCountTextView, priceTextView, discountTextView, offerPriceTextView, quantityTextView;
    private Button increaseButton, decreaseButton, addToCartButton;
    private int quantity = 1;
    private FashionItem item;
    private CartViewModel cartViewModel;

    public static ArrayList<FashionItem> wishlist=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        imageView = findViewById(R.id.imageView);
        nameTextView = findViewById(R.id.nameTextView);
        descriptionTextView = findViewById(R.id.descriptionTextView);
        ratingTextView = findViewById(R.id.ratingTextView);
        ratingCountTextView = findViewById(R.id.ratingCountTextView);
        priceTextView = findViewById(R.id.priceTextView);
        discountTextView = findViewById(R.id.discountTextView);
        offerPriceTextView = findViewById(R.id.offerPriceTextView);
        quantityTextView = findViewById(R.id.quantityTextView);
        increaseButton = findViewById(R.id.increaseButton);
        decreaseButton = findViewById(R.id.decreaseButton);
        addToCartButton = findViewById(R.id.addToCartButton);
        heartIcon = findViewById(R.id.heartIcon);

        item = (FashionItem) getIntent().getSerializableExtra("item");
        cartViewModel = new ViewModelProvider(this).get(CartViewModel.class);

        if (item != null) {
            imageView.setImageResource(item.getImageResource());
            nameTextView.setText(item.getName());
            descriptionTextView.setText(item.getDescription());
            ratingTextView.setText(String.valueOf(item.getRating()));
            ratingCountTextView.setText(String.valueOf(item.getRatingCount()));
            priceTextView.setText("₹" + item.getPrice());
            discountTextView.setText(item.getDiscount() + "% off");
            offerPriceTextView.setText("Offer Price ₹" + item.getOfferPrice());
            quantityTextView.setText(String.valueOf(quantity));
        }

        increaseButton.setOnClickListener(v -> {
            quantity++;
            quantityTextView.setText(String.valueOf(quantity));
        });

        decreaseButton.setOnClickListener(v -> {
            if (quantity > 1) {
                quantity--;
                quantityTextView.setText(String.valueOf(quantity));
            }
        });

        addToCartButton.setOnClickListener(v -> {
            item.setQuantity(quantity);
            Log.d("YourActivity", "Adding item to cart: " + item.getName() + " Quantity: " + quantity);
            //cartViewModel.addItem(item, quantity);
            boolean add = CartFragment.al.add(item);
            if(add){
                Toast.makeText(this, "Product added to cart..", Toast.LENGTH_SHORT).show();
            }
        });

        heartIcon.setOnClickListener(v -> {
            // Change color to primary color
            heartIcon.setColorFilter(getResources().getColor(R.color.pink));
            Toast.makeText(ProductActivity.this, "Added to Wishlist", Toast.LENGTH_SHORT).show();
            wishlist.add(item);
        });

    }
}
