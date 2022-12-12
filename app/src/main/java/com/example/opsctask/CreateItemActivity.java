package com.example.opsctask;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class CreateItemActivity extends AppCompatActivity {

    private Button takeImgButton;
    private Button addItem;
    private ImageView itemImg;
    private CollectionManager collManager;
    private int collIndex;


    @Override
     protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item);

        addItem = findViewById(R.id.addItemButton);
        takeImgButton = findViewById(R.id.takeItemImgButton);
        itemImg = findViewById(R.id.itemImgView);
        collManager = (CollectionManager) getApplicationContext();
        collIndex = getIntent().getExtras().getInt("COLL_INDEX");

        takeImgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), cameraActivity.class);
                startActivity(i);
            }
        });

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText name = findViewById(R.id.itemName_ET);
                EditText desc = findViewById(R.id.itemDescription_ET);
                EditText date = findViewById(R.id.itemDate_ET);

                Item item = new Item(name.getText().toString(), desc.getText().toString(), date.getText().toString());


                collManager.CollectionList.get(collIndex).AddItemToCollection(item);

                finish();
            }
        });
     }


/*
    @Override public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_IMAGE_CAPTURE &&
        ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
            takePhoto();
        }
    }

    private void takePhoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
    }

 */
}
