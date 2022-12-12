package com.example.opsctask;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Console;

public class ShowCollectionActivity extends AppCompatActivity {

    private ArrayAdapter adapter;
    private ListView listView;
    private Button addItemButton;
    private Button uploadCollectionButton;

    private TextView collName;
    private TextView collDesc;
    private TextView progressPercentage;

    private ProgressBar progressBar;
    private CollectionClass collEnter;
    private CollectionManager collManager;
    private int collIndex;

    private FirebaseDatabase database = FirebaseDatabase.getInstance("https://opsc-task-d66df-default-rtdb.europe-west1.firebasedatabase.app/");
    private DatabaseReference casifyRef = database.getReference("Collections");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.show_collection);

        collManager = (CollectionManager) getApplicationContext();
        collEnter = collManager.CollectionList.get(collIndex);

        collName = findViewById(R.id.collName_TV);
        collDesc = findViewById(R.id.collDesc_TV);
        adapter = new ArrayAdapter(this, R.layout.list_view_layout, collEnter.getCollection());

        progressBar = findViewById(R.id.progressBar);
        progressPercentage = findViewById(R.id.progressPercentage_TV);

        addItemButton = findViewById(R.id.addItem_BTN);
        uploadCollectionButton = findViewById(R.id.uploadColl_BTN);
        collManager = (CollectionManager) getApplicationContext();

        collIndex = getIntent().getExtras().getInt("COLL_INDEX");

        collName.setText(collEnter.getCollName());
        collDesc.setText(collEnter.getCollDescription());

        progressBar.setMax(collEnter.getCollGoal());
        progressBar.setProgress(collEnter.getCollection().size());
        progressPercentage.setText(new StringBuilder().append( (int) ((float) collEnter.getCollection().size() / (float) collEnter.getCollGoal() * 100)).append("%").toString());

        listView = findViewById(R.id.items_LV);
        listView.setAdapter(adapter);



        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddItemActivityLaunch();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                LaunchItemViewActivity(i);
            }
        });

        uploadCollectionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                casifyRef.child(collEnter.collName).setValue(collEnter.getCollection());
            }
        });
    }

    public void AddItemActivityLaunch(){
        Intent createItem = new Intent(this,CreateItemActivity.class);
        createItem.putExtra("COLL_INDEX", collIndex);
        startActivity(createItem);
    }

    @Override protected void onResume(){
        super.onResume();
        progressBar.setProgress(collEnter.getCollection().size());
        progressPercentage.setText(new StringBuilder().append( (int) ((float) collEnter.getCollection().size() / (float) collEnter.getCollGoal() * 100)).append("%").toString());
        adapter.notifyDataSetChanged();
    }

    public void LaunchItemViewActivity(int itemIndex){
        Intent switchActIntent = new Intent(this, ShowItemActivity.class);
        switchActIntent.putExtra("ITEM_INDEX", itemIndex);
        switchActIntent.putExtra("COLL_INDEX", collIndex);
        startActivity(switchActIntent);
    }
}
