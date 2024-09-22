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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.petrol.petrol_project.users.Users;

public class signup_page extends AppCompatActivity {

    TextView signup_txt,login_txt;
    EditText sig_email, sig_pwd, sig_name, sig_phone;
    Button sig_btn;

    FirebaseAuth auth;
    Users users;
    DatabaseReference databaseReference;

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
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");
        users = new Users();

        sig_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = sig_email.getText().toString();
                String pwd = sig_pwd.getText().toString();

                if (!sig_email.getText().toString().isEmpty() && !sig_pwd.getText().toString().isEmpty()) {
                    auth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(signup_page.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser currentUser = auth.getCurrentUser();
                                if (currentUser != null) {
                                    Toast.makeText(signup_page.this, "Signup Successfully!!", Toast.LENGTH_SHORT).show();
                                    users.setUsername(sig_name.getText().toString());
                                    users.setPhone(Long.parseLong(sig_phone.getText().toString()));
                                    users.setEmail(sig_email.getText().toString());
                                    databaseReference.child(currentUser.getUid()).setValue(users);
                                    Intent intent = new Intent(signup_page.this, MainActivity.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(signup_page.this, "User creation failed!", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(signup_page.this, "Signup failed!", Toast.LENGTH_SHORT).show();
                            }
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
