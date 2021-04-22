package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    public static Order myOrder = new Order();
    public static OneStoreOrder myStore = new OneStoreOrder();

    ImageButton donutImageButton;
    ImageButton coffeeImageButton;
    ImageButton orderDetailsImageButton;
    ImageButton storeOrdersImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        donutImageButton = (ImageButton) findViewById(R.id.mmDonutImage);
        donutImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, OrderingDonuts.class);
                startActivity(i);
            }
        });

        coffeeImageButton = (ImageButton) findViewById(R.id.mmCoffeeImage);
        coffeeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, OrderingCoffee.class);
                startActivity(i);
            }
        });

        orderDetailsImageButton = (ImageButton) findViewById(R.id.mmOrderImage);
        orderDetailsImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, OrderDetails.class);
                startActivity(i);
            }
        });

        storeOrdersImageButton = (ImageButton) findViewById(R.id.mmStoreOrderImage);
        storeOrdersImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, StoreOrders.class);
                startActivity(i);
            }
        });


    }

}