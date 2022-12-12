package com.example.opsctask;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ShowItemActivity extends AppCompatActivity {

    private ImageView itemImg;
    private TextView itemName;
    private TextView itemDesc;
    private TextView itemDate;
    private CollectionManager collManager;
    private Item item;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_item);

        itemImg = findViewById(R.id.itemImageViewPage_IV);
        itemName = findViewById(R.id.itemHeader_TV);
        itemDesc = findViewById(R.id.itemDescViewPage_TV);
        itemDate = findViewById(R.id.itemDateViewPage_TV);

        int collIndex = getIntent().getExtras().getInt("COLL_INDEX");
        int itemIndex = getIntent().getExtras().getInt("ITEM_INDEX");
        collManager = (CollectionManager) getApplicationContext();

        item = collManager.CollectionList.get(collIndex).getCollection().get(itemIndex); // Damn that's ugly. Oh well.
        itemName.setText(item.getItemName());
        itemDesc.setText(item.getItemDescription());
        itemDate.setText(item.getItemDate());


    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
