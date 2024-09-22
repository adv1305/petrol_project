package com.petrol.petrol_project.product_page;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.petrol.petrol_project.R;

public class safety_kits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safety_kits);

        Button addToCart1 = findViewById(R.id.add_to_cart_1);
        Button addToCart2 = findViewById(R.id.add_to_cart_2);
        Button addToCart3 = findViewById(R.id.add_to_cart_3);
        Button addToCart4 = findViewById(R.id.add_to_cart_4);

        addToCart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(safety_kits.this, "Item added to your cart", Toast.LENGTH_SHORT).show();
            }
        });

        addToCart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(safety_kits.this, "Item added to your cart", Toast.LENGTH_SHORT).show();
            }
        });

        addToCart3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(safety_kits.this, "Item added to your cart", Toast.LENGTH_SHORT).show();
            }
        });

        addToCart4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(safety_kits.this, "Item added to your cart", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
