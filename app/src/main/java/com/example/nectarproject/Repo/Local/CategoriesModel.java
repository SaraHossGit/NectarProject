package com.example.nectarproject.Repo.Local;

public class CategoriesModel {

    public static final int MAX_VIEW=0;
    public static final int MIN_VIEW=1;
    public int type = MIN_VIEW;

    private int cardViewColor;
    private int catImage;
    private String catName;

    public CategoriesModel(int type, int cardViewColor, int catImage, String catName) {
        this.type = type;
        this.cardViewColor = cardViewColor;
        this.catImage = catImage;
        this.catName = catName;
    }

    public int getType() {
        return type;
    }

    public int getCardViewColor() {
        return cardViewColor;
    }

    public int getCatImage() {
        return catImage;
    }

    public String getCatName() {
        return catName;
    }
}
