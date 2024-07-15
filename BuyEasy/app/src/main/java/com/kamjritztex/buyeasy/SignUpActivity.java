package com.kamjritztex.buyeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    public static User[] al=new User[1];
    public EditText username, password, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_up);
        username = findViewById(R.id.edit_username);
        password = findViewById(R.id.edit_password);
        email = findViewById(R.id.edit_email);

        Button btnSignup = findViewById(R.id.btnSignup);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameStr = username.getText().toString().trim();
                String passwordStr = password.getText().toString().trim();
                String emailStr = email.getText().toString().trim();

                if (usernameStr.isEmpty()) {
                    username.setError("Username is required");
                    return;
                }

                if (passwordStr.isEmpty()) {
                    password.setError("Password is required");
                    return;
                }

                if (emailStr.isEmpty()) {
                    email.setError("Email is required");
                    return;
                }

                // If all fields are valid, create a User object and add to the list
                User user = new User(usernameStr,emailStr,passwordStr);
                al[0]=user;

                // Show success message and navigate to LoginActivity
                Toast.makeText(SignUpActivity.this, "User Registered successfully.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            }
        });

        TextView text = findViewById(R.id.txt_sign_in);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            }
        });
    }
}
