package com.petrol.petrol_project.product_page;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.petrol.petrol_project.R;

public class productpage extends AppCompatActivity {

    TextView prod_txt;
    Button lubricants_oils_btn, car_accessories_btn,maintenance_tools_btn,cleaning_products_btn,safety_kits_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_productpage);

        prod_txt = findViewById(R.id.prod_txt);
        lubricants_oils_btn = findViewById(R.id.lubricants_oils_btn);
        car_accessories_btn= findViewById(R.id.car_accessories_btn);
        maintenance_tools_btn= findViewById(R.id.maintenance_tools_btn);
        cleaning_products_btn= findViewById(R.id.cleaning_products_btn);
        safety_kits_btn= findViewById(R.id.safety_kits_btn);

        lubricants_oils_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(productpage.this,lubricants_oils.class);
                startActivity(intent1);
            }
        });

        car_accessories_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(productpage.this,car_accessories.class);
                startActivity(intent2);
            }
        });

        maintenance_tools_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(productpage.this,maintenance_tools.class);
                startActivity(intent3);
            }
        });

        cleaning_products_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(productpage.this,cleaning_products.class);
                startActivity(intent4);
            }
        });

        safety_kits_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(productpage.this,safety_kits.class);
                startActivity(intent5);
            }
        });


    }
}