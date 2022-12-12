package com.example.opsctask;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CollectionViewActivity extends AppCompatActivity {

    public ArrayAdapter adapter;
    private ListView listView;
    public CollectionManager collManager;
    private Button addColl;
    private Button loadColls;

    private FirebaseDatabase database = FirebaseDatabase.getInstance("https://opsc-task-d66df-default-rtdb.europe-west1.firebasedatabase.app/");
    private DatabaseReference casifyRef = database.getReference();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collection_view);

        collManager = (CollectionManager) getApplicationContext();

        listView = findViewById(R.id.collections_LV);
        addColl = findViewById(R.id.addColl_BTN);
        loadColls = findViewById(R.id.uploadColl_BTN);

        adapter = new ArrayAdapter(this, R.layout.list_view_layout, collManager.CollectionList);

        listView.setAdapter(adapter);

        addColl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SwitchActivities();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                EnterCollection(i);
            }
        });


    }

    private void EnterCollection(int collIndex){
        Intent switchActIntent = new Intent(this, ShowCollectionActivity.class);
        switchActIntent.putExtra("COLL_INDEX", collIndex);
        startActivity(switchActIntent);
    }

    private  void SwitchActivities(){
        Intent switchActivityIntent = new Intent(this, CreateCollectionActivity.class);
        startActivity(switchActivityIntent);
    }

    @Override protected void onResume(){
        super.onResume();
        adapter.notifyDataSetChanged();
    }

}
