package com.petrol.petrol_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.petrol.petrol_project.output.Output;
import com.petrol.petrol_project.output.RecyclerAdapter;
import com.petrol.petrol_project.product_page.productpage;

import java.util.ArrayList;

public class petrol_homepage extends AppCompatActivity {

    ImageButton img0, img1, img2, img3;
    Button ex_btn;
    TextView req_txt;

    RecyclerView oprecycler_view;
    ArrayList<Output> outputArrayList;
    RecyclerAdapter recyclerAdapter;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_petrol_homepage);

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

        EventChangeListener();

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

    private void EventChangeListener() {
        db.collection("requests").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    Toast.makeText(petrol_homepage.this, "Error fetching data", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (value != null) {
                    // Get the count of documents
                    int count = value.size();
                    String countStr = String.valueOf(count);

                    // Clear the list and update
                    outputArrayList.clear();
                    for (QueryDocumentSnapshot document : value) {
                        Output output = document.toObject(Output.class);

                        // Example: Set OrderNo and Time. Customize as per your need
                        output.setOrderNo(countStr); // Be cautious with setting a static value here
                        output.setTime("16:09"); // Example static time

                        outputArrayList.add(output);
                    }
                    recyclerAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(petrol_homepage.this, "No data available", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
