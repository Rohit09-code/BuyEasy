package com.kamjritztex.buyeasy;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class CheckoutActivity extends AppCompatActivity implements PaymentResultListener {
    private Button payment;

    private Checkout checkout; // Razorpay Checkout instance

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        payment = findViewById(R.id.save_address);


        payment.setOnClickListener(v -> {
            // Logic to save the address
            Intent intent = getIntent();
            int totalPrice = intent.getIntExtra("total_price", 0);
            startPayment(totalPrice);
        });
    }

    private void startPayment(int amountInRupees) {
        checkout = new Checkout();
        checkout.setKeyID("rzp_test_1DP5mmOlF5G5ag");

        try {
            double amountInRupeesDouble = amountInRupees;
            int amountInPaisa = (int) (amountInRupeesDouble * 100); // Convert rupees to paisa

            JSONObject options = new JSONObject();
            options.put("currency", "INR");
            options.put("amount", amountInPaisa); // Amount in paisa
            options.put("name", "BuyEasy");
            options.put("description", "Order Payment");


            checkout.open(CheckoutActivity.this, options);
        } catch (Exception e) {
            Toast.makeText(this, "Error in starting payment: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(this, "Payment Successful", Toast.LENGTH_SHORT).show();

        CartFragment.al.clear();
        CartAdapter.cartItems.clear();

        // Show success message in a dialog
        new AlertDialog.Builder(this)
                .setTitle("Payment Successful")
                .setMessage("Your payment was successful!")
                .setPositiveButton("OK", (dialog, which) -> {
                    // Optionally, you can add any further actions here
                    Intent intent =new Intent(CheckoutActivity.this, MainActivity.class);
                    startActivity(intent);
                })
                .show();

    }

    @Override
    public void onPaymentError(int code, String response) {
        Toast.makeText(this, "Payment Failed: " + response, Toast.LENGTH_SHORT).show();
        Log.e(TAG, "Payment failed: " + code + " " + response);
        // Handle payment failure
    }



}
