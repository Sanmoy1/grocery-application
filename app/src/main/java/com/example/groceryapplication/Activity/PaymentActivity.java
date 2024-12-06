package com.example.groceryapplication.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.groceryapplication.DatabaseHelper;
import com.example.groceryapplication.R;

public class PaymentActivity extends AppCompatActivity{

    private TextView orderCostEditText;
    private EditText paymentAmountEditText;
    private Button payButton;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        // Initialize views
        orderCostEditText = findViewById(R.id.orderCostEditText);
        paymentAmountEditText = findViewById(R.id.paymentAmountEditText);
        payButton = findViewById(R.id.payButton);

        // Initialize DatabaseHelper
        dbHelper = new DatabaseHelper(this);

        String totalPrice = getIntent().getStringExtra("totalPrice");

        // Set the total price as the text of the orderCostEditText
        orderCostEditText.setText("12.2");

        // Set onClickListener for Pay button
        payButton.setOnClickListener(v -> {
            // Validate input fields
            if (validateFields()) {
                // If fields are valid, proceed with payment
                performPayment();
            } else {
                // If fields are not valid, show a toast message
                Toast.makeText(PaymentActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validateFields() {
        return !orderCostEditText.getText().toString().isEmpty()
                && !paymentAmountEditText.getText().toString().isEmpty();
    }

    private void performPayment() {
        // Retrieve payment details from input fields
        double orderCost = Double.parseDouble(orderCostEditText.getText().toString());
        double paymentAmount = Double.parseDouble(paymentAmountEditText.getText().toString());

        // Add payment information to the database
        long result = dbHelper.addPayment(orderCost, paymentAmount, "Paid");
        Toast.makeText(this, "Payment successful", Toast.LENGTH_SHORT).show();
        Intent i=new Intent(this,DashboardActivity.class);
        startActivity(i);
        /*if (result != -1) {
            // Show a toast message to indicate successful payment
            Toast.makeText(this, "Payment successful", Toast.LENGTH_SHORT).show();
        } else {
            // Show a toast message to indicate failure
            Toast.makeText(this, "Failed to process payment", Toast.LENGTH_SHORT).show();
        }*/
    }
}
