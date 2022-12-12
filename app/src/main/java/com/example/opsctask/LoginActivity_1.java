package com.example.opsctask;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity_1 extends AppCompatActivity {
    Button loginButton, cancelButton;
    EditText username, password;
    TextView attemptsText;

    int attemptsNum = 3;

    protected void GoToCollectionPage(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);

        loginButton = findViewById(R.id.button2);
        username = findViewById(R.id.editTextTextPersonName);
        password = findViewById(R.id.editTextTextPassword);

        attemptsText = findViewById(R.id.textView8);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(view.getContext(), CollectionViewActivity.class);
                    startActivity(i);

                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect Information", Toast.LENGTH_SHORT).show();

                    attemptsText.setVisibility(View.VISIBLE);
                    attemptsText.setBackgroundColor(Color.GRAY);


                    attemptsNum--;
                    attemptsText.setText(String.format(Locale.getDefault(), "%d", attemptsNum));

                    if (attemptsNum == 0) {
                     loginButton.setEnabled(false);
                    }

                }
            }
        });


    }
}