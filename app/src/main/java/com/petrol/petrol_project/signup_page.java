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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.petrol.petrol_project.users.Users;
import com.petrol.petrol_project.util.FirebaseConstants;

import java.util.HashMap;
import java.util.Map;

public class signup_page extends AppCompatActivity {

    TextView signup_txt,login_txt;
    EditText sig_email, sig_pwd, sig_name, sig_phone;
    Button sig_btn;

    FirebaseAuth auth;
    Users users;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup_page);

        signup_txt = findViewById(R.id.signup_txt);
        sig_name = findViewById(R.id.sig_name);
        sig_phone = findViewById(R.id.sig_phone);
        sig_email = findViewById(R.id.sig_email);
        sig_pwd = findViewById(R.id.sig_pwd);
        sig_btn = findViewById(R.id.sig_btn);
        login_txt = findViewById(R.id.login_txt);
        auth = FirebaseAuth.getInstance();
        users = new Users();

        db = FirebaseFirestore.getInstance();

        if (auth.getCurrentUser() != null) {
            Intent intent = new Intent(signup_page.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        sig_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = sig_email.getText().toString();
                String pwd = sig_pwd.getText().toString();
                String name = sig_name.getText().toString();
                String phone = sig_phone.getText().toString();

                if (!email.isEmpty() && !pwd.isEmpty() && !name.isEmpty() && !phone.isEmpty()) {
                    auth.createUserWithEmailAndPassword(email, pwd)
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    FirebaseUser currentUser = auth.getCurrentUser();
                                    if (currentUser != null) {
                                        // Get user ID
                                        String userId = currentUser.getUid();

                                        // Create a user object to store in Firestore
                                        Map<String, Object> user = new HashMap<>();
                                        user.put("name", name);
                                        user.put("email", email);
                                        user.put("phone", phone);
                                        user.put("userId", userId); // Add user ID to the user object

                                        // Save user data to Firestore
                                        db.collection(FirebaseConstants.USER_COLLECTION.toString()).document(userId)
                                                .set(user)
                                                .addOnSuccessListener(aVoid -> {
                                                    Toast.makeText(signup_page.this, "Signup Successfully!!", Toast.LENGTH_SHORT).show();
                                                    Intent intent = new Intent(signup_page.this, MainActivity.class);
                                                    startActivity(intent);
                                                    finish();
                                                })
                                                .addOnFailureListener(e -> {
                                                    Toast.makeText(signup_page.this, "Firestore error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                                });
                                    }
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(signup_page.this, "Signup failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                } else {
                    Toast.makeText(signup_page.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

        login_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(signup_page.this, MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}
