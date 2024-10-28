package com.petrol.petrol_project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;

public class welcome_page extends AppCompatActivity {

    Button login_txt,signup_txt;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcome_page);

        login_txt = findViewById(R.id.login_txt);
        signup_txt = findViewById(R.id.signup_txt);

        auth= FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            Intent intent = new Intent(welcome_page.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        login_txt.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        signup_txt.setOnClickListener(v -> {
            Intent intent = new Intent(this, signup_page.class);
            startActivity(intent);
            finish();
        });
    }
}