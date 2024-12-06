package com.example.groceryapplication.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.groceryapplication.DatabaseHelper;
import com.example.groceryapplication.R;

public class DeliveryActivity extends AppCompatActivity{

    private EditText streetAddressEditText, cityEditText, stateEditText, zipcodeEditText;
    private Button submitButton;
    private DatabaseHelper dbHelper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        // Initialize views
        streetAddressEditText = findViewById(R.id.streetAddressEditText);
        cityEditText = findViewById(R.id.cityEditText);
        stateEditText = findViewById(R.id.stateEditText);
        zipcodeEditText = findViewById(R.id.zipcodeEditText);
        submitButton = findViewById(R.id.button);

        dbHelper = new DatabaseHelper(this);

        // Set onClickListener for Submit button
        submitButton.setOnClickListener(v -> {
            // Validate input fields
            if (validateFields()) {
                // If fields are valid, proceed with submission
                submitDeliveryDetails();
            } else {
                // If fields are not valid, show a toast message
                Toast.makeText(DeliveryActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            }
            Intent i=new Intent(this,PaymentActivity.class);
            startActivity(i);
        });
    }
    private boolean validateFields() {
        return !streetAddressEditText.getText().toString().isEmpty()
                && !cityEditText.getText().toString().isEmpty()
                && !stateEditText.getText().toString().isEmpty()
                && !zipcodeEditText.getText().toString().isEmpty();
    }

    // Method to handle delivery details submission
    private void submitDeliveryDetails() {
        // Retrieve delivery details from input fields
        String streetAddress = streetAddressEditText.getText().toString();
        String city = cityEditText.getText().toString();
        String state = stateEditText.getText().toString();
        String zipcode = zipcodeEditText.getText().toString();

        long result = dbHelper.addDelivery(streetAddress, city, state, zipcode);
        if (result != -1) {
            // Show a toast message to indicate successful submission
            Toast.makeText(this, "Delivery details submitted successfully", Toast.LENGTH_SHORT).show();
        } else {
            // Show a toast message to indicate failure
            Toast.makeText(this, "Failed to submit delivery details", Toast.LENGTH_SHORT).show();
        }


        // Delivery delivery = new Delivery(streetAddress, city, state, zipcode);
        // DatabaseHelper dbHelper = new DatabaseHelper(this);
        // dbHelper.addDelivery(delivery);

        // Show a toast message to indicate successful submission
        //Toast.makeText(this, "Delivery details submitted successfully", Toast.LENGTH_SHORT).show();


    }
}
