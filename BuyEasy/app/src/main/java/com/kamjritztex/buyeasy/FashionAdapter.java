package com.kamjritztex.buyeasy;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FashionAdapter extends RecyclerView.Adapter<FashionAdapter.FashionViewHolder> {

    private List<FashionItem> fashionItems;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(FashionItem item);
    }

    public FashionAdapter(List<FashionItem> fashionItems, OnItemClickListener listener) {
        this.fashionItems = fashionItems;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FashionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_fashion, parent, false);
        return new FashionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FashionViewHolder holder, int position) {
        FashionItem currentItem = fashionItems.get(position);
        holder.imageView.setImageResource(currentItem.getImageResource());
        holder.nameTextView.setText(currentItem.getName());
        holder.descriptionTextView.setText(currentItem.getDescription());
        holder.ratingTextView.setText(String.valueOf(currentItem.getRating()));
        holder.ratingCountTextView.setText(String.valueOf(currentItem.getRatingCount()));
        holder.priceTextView.setText("₹" + currentItem.getPrice());
        holder.discountTextView.setText(currentItem.getDiscount() + "% off");
        holder.offerPriceTextView.setText("Offer Price ₹" + currentItem.getOfferPrice());

        holder.itemView.setOnClickListener(v -> listener.onItemClick(currentItem));
    }

    @Override
    public int getItemCount() {
        return fashionItems.size();
    }

    public static class FashionViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView nameTextView;
        public TextView descriptionTextView;
        public TextView ratingTextView;
        public TextView ratingCountTextView;
        public TextView priceTextView;
        public TextView discountTextView;
        public TextView offerPriceTextView;

        public FashionViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            ratingTextView = itemView.findViewById(R.id.ratingTextView);
            ratingCountTextView = itemView.findViewById(R.id.ratingCountTextView);
            priceTextView = itemView.findViewById(R.id.priceTextView);
            discountTextView = itemView.findViewById(R.id.discountTextView);
            offerPriceTextView = itemView.findViewById(R.id.offerPriceTextView);
        }
    }
}
