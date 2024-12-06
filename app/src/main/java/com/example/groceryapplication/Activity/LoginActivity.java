package com.example.groceryapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.groceryapplication.R;

public class LoginActivity extends AppCompatActivity {

    EditText loginEmailId;
    EditText loginPassword;
    Button logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        loginEmailId=findViewById(R.id.loginEmailId);
        loginPassword=findViewById(R.id.loginPassword);
        logIn=findViewById(R.id.logIn);
        /*String email= loginEmailId.getText().toString();
        String pass=String.valueOf(loginPassword.getText());*/

        logIn.setOnClickListener(view -> {
            String email = loginEmailId.getText().toString();
            String pass = loginPassword.getText().toString();
            if(email.equals("user@test.com")&&pass.equals("123")) {
                Intent n = new Intent(getApplicationContext(), DashboardActivity.class);
                startActivity(n);
                Toast.makeText(this,"Login Successful!",Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this,"Enter \n Email id = user@test.com \n Password = 123",Toast.LENGTH_LONG).show();
            }
        });

    }
}
