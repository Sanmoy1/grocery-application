package com.example.groceryapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.groceryapplication.R;

public class MainActivity extends AppCompatActivity {

    TextView textView4;
    Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView4=findViewById(R.id.textView4);
        startButton=findViewById(R.id.startButton);

        textView4.setOnClickListener(view -> {
            Intent n= new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(n);
        });

        startButton.setOnClickListener(view -> {
            Intent n= new Intent(getApplicationContext(), DashboardActivity.class);
            startActivity(n);
        });
    }
}