package com.kamjritztex.buyeasy;

import java.io.Serializable;

public class FashionItem implements Serializable {
    private int imageResource;
    private String name;
    private String description;
    private String rating;
    private int ratingCount;
    private int price;
    private int discount;
    private int offerPrice;

    private int quantity;

    public FashionItem() {
    }

    public FashionItem(int imageResource, String name, String description, String rating, int ratingCount, int price, int discount, int offerPrice) {
        this.imageResource = imageResource;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.ratingCount = ratingCount;
        this.price = price;
        this.discount = discount;
        this.offerPrice = offerPrice;
        this.quantity = 1;
    }

    public int getImageResource() { return imageResource; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getRating() { return rating; }
    public int getRatingCount() { return ratingCount; }
    public int getPrice() { return price; }
    public int getDiscount() { return discount; }
    public int getOfferPrice() { return offerPrice; }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setOfferPrice(int offerPrice) {
        this.offerPrice = offerPrice;
    }
}
