package com.petrol.petrol_project;

import static com.petrol.petrol_project.R.id.log_txt;

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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    TextView log_txt,sig_txt;
    EditText log_email,log_pwd;

    Button log_btn;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        log_txt= findViewById(R.id.log_txt);
        sig_txt= findViewById(R.id.sig_txt);
        log_email= findViewById(R.id.log_email);
        log_pwd= findViewById(R.id.log_pwd);
        log_btn= findViewById(R.id.log_btn);
        auth= FirebaseAuth.getInstance();

        log_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email= log_email.getText().toString();
                String pwd= log_pwd.getText().toString();

                if(!log_email.getText().toString().isEmpty() && !log_pwd.getText().toString().isEmpty()){
                    auth.signInWithEmailAndPassword(email,pwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isComplete()){
                                Toast.makeText(MainActivity.this, "Login Successfully!!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this,petrol_homepage.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(MainActivity.this, "Login failed!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else {
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


