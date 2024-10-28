package com.petrol.petrol_project;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.petrol.petrol_project.util.FirebaseConstants;

public class profile extends AppCompatActivity {

    // Declare variables for each TextView
    TextInputEditText tvFirstName, tvEmail, tvPhone;

    // Initialize Firebase Auth instance
    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseUser currentUser = auth.getCurrentUser();

    // Initialize Firebase Firestore instance
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);  // Assuming the XML file is named activity_main.xml

        // Initialize the TextViews
        tvFirstName = findViewById(R.id.tvFirstName);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        currentUser = auth.getCurrentUser();

        if (currentUser == null) {
            Intent intent = new Intent(profile.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        // Set data to the TextViews (static data for now)
        tvFirstName.setText("John");
        tvEmail.setText("john.doe@email.com");
        tvPhone.setText("+123456789");

        // If fetching from Firebase or another data source, you can populate the TextViews dynamically
         Example:
         fetchDataFromFirebase(currentUser.getUid().toString());
    }

    // Example method to fetch data from Firebase (pseudo-code)
    private void fetchDataFromFirebase(String userId) {
        // Fetch data from the Firebase Firestore 'USER_COLLECTION' collection
        db.collection(FirebaseConstants.USER_COLLECTION.toString())
                .document(userId)  // Assuming you're fetching data for a specific user
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document.exists()) {
                            // Fetch the data from Firestore and set it to the TextViews
                            String firstName = document.getString("name");
                            String email = document.getString("email");
                            String phone = document.getString("phone");

                            // Set the data to TextViews
                            tvFirstName.setText(firstName);
                            tvEmail.setText(email);
                            tvPhone.setText(phone);
                        } else {
                            Log.d(TAG, "No such document");
                        }
                    } else {
                        Log.d(TAG, "Failed to fetch document: ", task.getException());
                    }
                });
    }
}