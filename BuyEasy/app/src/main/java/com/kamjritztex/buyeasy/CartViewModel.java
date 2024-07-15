package com.kamjritztex.buyeasy;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class CartViewModel extends ViewModel {

    private final MutableLiveData<List<CartItem>> cartItems = new MutableLiveData<>(new ArrayList<>());

    public LiveData<List<CartItem>> getCartItems() {
        return cartItems;
    }

    public void addItem(FashionItem item, int quantity) {
        List<CartItem> currentItems = cartItems.getValue();
        boolean itemExists = false;

        // Check if item already exists in cart
        for (CartItem cartItem : currentItems) {
            if (cartItem.getItem().equals(item)) {
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
                itemExists = true;
                break;
            }
        }

        // If item doesn't exist, add new item
        if (!itemExists) {
            currentItems.add(new CartItem(item, quantity));
            Log.d("CartViewModel", "Item added to cart: " + item.getName() + " Quantity: " + quantity
                +"price" + item.getOfferPrice()
            );
        }

        // Update LiveData with new cart items
             cartItems.setValue(currentItems);

    }


    public static class CartItem {
        private FashionItem item;
        private int quantity;

        public CartItem(FashionItem item, int quantity) {
            this.item = item;
            this.quantity = quantity;
        }

        public FashionItem getItem() {
            return item;
        }

        public void setItem(FashionItem item) {
            this.item = item;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
