package com.example.opsctask;

import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CollectionClass {

    protected String collName;

    public String getCollName() {
        return collName;
    }

    public String getCollDescription() {
        return collDescription;
    }

    public int getCollGoal() {
        return collGoal;
    }

    public List<Item> getCollection() {
        return collection;
    }

    protected String collDescription;
    protected int collGoal;

    protected List<Item> collection = new ArrayList<Item>();

    // CONSTRUCTORS //


    public CollectionClass(String name, String description, int goal){
        collGoal = goal;
        collName = name;
        collDescription = description;
    }

    public void AddItemToCollection(Item item){
        collection.add(item);
    }

    @Override public String toString(){
        return (collName + " - " + collDescription + "." + "\nGoal progress: " + collection.size() + "/" + collGoal);
    }
}
