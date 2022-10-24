package com.example.nectarproject.Repo.Local;

public class GroceriesModel {
    private int cardViewColor;
    private int groceryImage;
    private String groceryName;

    public GroceriesModel(int cardViewColor, int groceryImage, String groceryName) {
        this.cardViewColor = cardViewColor;
        this.groceryImage = groceryImage;
        this.groceryName = groceryName;
    }

    public int getCardViewColor() {
        return cardViewColor;
    }

    public int getGroceryImage() {
        return groceryImage;
    }

    public String getGroceryName() {
        return groceryName;
    }
}
