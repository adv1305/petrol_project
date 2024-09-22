package com.petrol.petrol_project.product_page;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.petrol.petrol_project.R;

public class maintenance_tools extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_maintenance_tools);

        // Add click listeners for each "Add to Cart" button
        Button addToCart1 = findViewById(R.id.add_to_cart_1);
        Button addToCart2 = findViewById(R.id.add_to_cart_2);
        Button addToCart3 = findViewById(R.id.add_to_cart_3);
        Button addToCart4 = findViewById(R.id.add_to_cart_4);

        View.OnClickListener addToCartListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(maintenance_tools.this, "Item added to your cart", Toast.LENGTH_SHORT).show();
            }
        };

        addToCart1.setOnClickListener(addToCartListener);
        addToCart2.setOnClickListener(addToCartListener);
        addToCart3.setOnClickListener(addToCartListener);
        addToCart4.setOnClickListener(addToCartListener);
    }
}
