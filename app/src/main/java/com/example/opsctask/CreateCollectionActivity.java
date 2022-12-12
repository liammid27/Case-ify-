package com.example.opsctask;

import static java.lang.Integer.parseInt;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateCollectionActivity extends AppCompatActivity {

    private EditText collName;
    private EditText collGoal;
    private EditText collDescription;
    private Button createButton;
    public CollectionManager collManager;



    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_collection);

        collName = findViewById(R.id.collName_ET);
        collGoal = findViewById(R.id.collGoal_ET);
        collDescription = findViewById(R.id.collDescription_ET);
        createButton = findViewById(R.id.createCollButton);
        collManager  = (CollectionManager) getApplicationContext();

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CollectionClass coll = new CollectionClass(collName.getText().toString(),
                        collDescription.getText().toString(),
                        parseInt(collGoal.getText().toString()));

                collManager.CollectionList.add(coll);
                Toast.makeText(CreateCollectionActivity.this, collManager.CollectionList.get(0).toString(), Toast.LENGTH_SHORT).show();

                collName.setText("");
                collGoal.setText("");
                collDescription.setText("");

                finish();
            }
        });
    }



}
