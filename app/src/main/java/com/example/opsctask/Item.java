package com.example.opsctask;

import android.media.Image;
import android.text.Editable;


public class Item {

    protected Image itemPicture;
    protected String itemName;
    protected String itemDescription;
    protected String itemDate;


    public Image getItemPicture() {
        return itemPicture;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getItemDate() {
        return itemDate;
    }

    public Item(Image itemPicture, String itemName, String itemDescription, String itemDate) {
        this.itemPicture = itemPicture;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemDate = itemDate;
    }

    public Item(String itemName, String itemDescription, String itemDate) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemDate = itemDate;
    }

    public Item(Image itemPicture, String itemName, String itemDescription) {
        this.itemPicture = itemPicture;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }

    public Item(){

    }

    @Override public String toString(){
        return itemName;
    }

}
