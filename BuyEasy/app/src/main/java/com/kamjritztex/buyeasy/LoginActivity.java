package com.kamjritztex.buyeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    private EditText mail,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mail=findViewById(R.id.edit_email);
        pass=findViewById(R.id.edit_password);

        Button btnLogin=findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();

            }
        });

        TextView btnSign=findViewById(R.id.txt_sign_up);
        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });


    }

    private void login() {

        String email, password;

        email = mail.getText().toString().trim();
        password = pass.getText().toString().trim();

        User user=SignUpActivity.al[0];
        if(SignUpActivity.al[0] !=null) {
            if (email.isEmpty()) {
                mail.setError("Enter email");
            } else if (password.isEmpty()) {
                pass.setError("Enter Password");
            } else if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {

                Toast.makeText(this, "Login Sucessfull..", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            } else {
                Toast.makeText(this, "Invalid credentials..", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Please Signup first..", Toast.LENGTH_SHORT).show();
        }

    }
}