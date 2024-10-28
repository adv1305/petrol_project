package com.petrol.petrol_project.product_page;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.ComponentActivity; // Changed from EdgeToEdge to ComponentActivity
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.petrol.petrol_project.R;

public class car_accessories extends AppCompatActivity { // Updated class name

    TextView carTitle;
    ImageView productImage1, productImage2, productImage3, productImage4;
    Button addToCart1, addToCart2, addToCart3, addToCart4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_car_accessories); // Ensure the layout file name matches

        // Initialize views
        carTitle = findViewById(R.id.car_title);
        productImage1 = findViewById(R.id.product_image_1);
        productImage2 = findViewById(R.id.product_image_2);
        productImage3 = findViewById(R.id.product_image_3);
        productImage4 = findViewById(R.id.product_image_4);
        addToCart1 = findViewById(R.id.add_to_cart_1);
        addToCart2 = findViewById(R.id.add_to_cart_2);
        addToCart3 = findViewById(R.id.add_to_cart_3);
        addToCart4 = findViewById(R.id.add_to_cart_4);

        // Set up the click listener for add-to-cart buttons
        View.OnClickListener addToCartListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(car_accessories.this, "Item added to your cart", Toast.LENGTH_SHORT).show();
            }
        };

        // Assign the listener to buttons
        addToCart1.setOnClickListener(addToCartListener);
        addToCart2.setOnClickListener(addToCartListener);
        addToCart3.setOnClickListener(addToCartListener);
        addToCart4.setOnClickListener(addToCartListener);
    }
}
