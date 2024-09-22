package com.petrol.petrol_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.petrol.petrol_project.output.Output;
import com.petrol.petrol_project.output.RecyclerAdapter;
import com.petrol.petrol_project.product_page.productpage;
import com.petrol.petrol_project.util.FirebaseConstants;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class petrol_homepage extends AppCompatActivity {

    ImageButton img0, img1, img2, img3;
    Button ex_btn;
    TextView req_txt;

    RecyclerView oprecycler_view;
    ArrayList<Output> outputArrayList;
    RecyclerAdapter recyclerAdapter;
    FirebaseFirestore db ;

    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_petrol_homepage);

        if (auth.getCurrentUser() == null) {
            Intent intent = new Intent(petrol_homepage.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        img0 = findViewById(R.id.img0);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);

        ex_btn = findViewById(R.id.ex_btn);
        req_txt = findViewById(R.id.req_txt);
        oprecycler_view = findViewById(R.id.oprecycler_view);

        oprecycler_view.setHasFixedSize(true);
        oprecycler_view.setLayoutManager(new LinearLayoutManager(this));

        outputArrayList = new ArrayList<>();
        recyclerAdapter = new RecyclerAdapter(outputArrayList, this);
        oprecycler_view.setAdapter(recyclerAdapter);

        auth = FirebaseAuth.getInstance();
        currentUser = auth.getCurrentUser();
        db = FirebaseFirestore.getInstance();

        CollectionReference reference = FirebaseFirestore
                .getInstance()
                .collection(FirebaseConstants.USER_COLLECTION.toString())
                .document(currentUser.getUid())
                .collection(FirebaseConstants.REQUEST.toString());





        if(currentUser == null){
            Intent intent = new Intent(petrol_homepage.this, MainActivity.class);
            startActivity(intent);
            finish();
        }



        reference.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    outputArrayList.clear();
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Output output = document.toObject(Output.class);
                        outputArrayList.add(output);
                    }
                    recyclerAdapter.notifyDataSetChanged();  // Notify the adapter about data changes
                } else {
                    Toast.makeText(petrol_homepage.this, "Error getting documents: " + task.getException(), Toast.LENGTH_SHORT).show();
                }
            }
        });





        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(petrol_homepage.this, request_form.class);
                intent1.putExtra("request", "Petrol");
                startActivity(intent1);
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(petrol_homepage.this, request_form.class);
                intent2.putExtra("request", "Diesel");
                startActivity(intent2);
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(petrol_homepage.this, request_form.class);
                intent3.putExtra("request", "CNG");
                startActivity(intent3);
            }
        });

        ex_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(petrol_homepage.this, productpage.class);
                startActivity(intent4);
            }
        });

    }

}
