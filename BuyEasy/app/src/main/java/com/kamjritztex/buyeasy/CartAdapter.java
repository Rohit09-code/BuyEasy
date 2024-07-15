package com.kamjritztex.buyeasy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    public static List<FashionItem> cartItems;

    public CartAdapter(List<FashionItem> cartItems) {
        this.cartItems = cartItems;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new CartViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        FashionItem item = cartItems.get(position);

        holder.imageView.setImageResource(item.getImageResource());
        holder.nameTextView.setText(item.getName());
        holder.descriptionTextView.setText(item.getDescription());
        holder.offerPriceTextView.setText("Offer Price: ₹" + item.getOfferPrice());
        holder.quantityTextView.setText("Quantity: " + item.getQuantity());
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    static class CartViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView nameTextView;
        TextView descriptionTextView;

        TextView offerPriceTextView;
        TextView quantityTextView;

        CartViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            offerPriceTextView = itemView.findViewById(R.id.offerPriceTextView);
            quantityTextView = itemView.findViewById(R.id.quantityTextView);
        }


    }
}
