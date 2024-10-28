package com.petrol.petrol_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    TextView log_txt,sig_txt;
    EditText log_email,log_pwd;

    Button log_btn;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EdgeToEdge.enable(this);
        log_txt= findViewById(R.id.log_txt);
        sig_txt= findViewById(R.id.sig_txt);
        log_email= findViewById(R.id.log_email);
        log_pwd= findViewById(R.id.log_pwd);
        log_btn= findViewById(R.id.log_btn);
        auth= FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            Intent intent = new Intent(MainActivity.this, petrol_homepage.class);
            startActivity(intent);
            finish();
        }

        log_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!log_email.getText().toString().isEmpty() && !log_pwd.getText().toString().isEmpty()) {
                    auth.signInWithEmailAndPassword(log_email.getText().toString(), log_pwd.getText().toString())
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    // Login was successful
                                    Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(MainActivity.this, petrol_homepage.class);
                                    startActivity(intent);
                                    finish();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    // Login failed
                                    Toast.makeText(MainActivity.this, "Login Failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                } else {
                    Toast.makeText(MainActivity.this, "Please fill all the fields!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        sig_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,signup_page.class);
                startActivity(intent1);
            }
        });


    }
}


