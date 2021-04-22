package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
/**
 * An Activity class that provides the functionality of the Main Menu.
 * This is the activity class of the "activity_main.xml" Window.
 * @author Abdullah Salem, Gent Blaku
 *
 */
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
        this.setTitle(R.string.Main_Menu);
        donutImageButton = (ImageButton) findViewById(R.id.mmDonutImage);
        donutImageButton.setOnClickListener(new View.OnClickListener() {
            /**
             * This triggers on the click of the donut image-button
             * @param v is the current view
             */
            @Override
            public void onClick(View v) {
                try{
                    Intent i = new Intent(MainActivity.this, OrderingDonuts.class);
                    startActivity(i);
                } catch (Exception e){

                }
            }
        });

        coffeeImageButton = (ImageButton) findViewById(R.id.mmCoffeeImage);
        coffeeImageButton.setOnClickListener(new View.OnClickListener() {
            /**
             * This triggers on the click of the coffee image-button
             * @param v is the current view
             */
            @Override
            public void onClick(View v) {
                try{
                    Intent i = new Intent(MainActivity.this, OrderingCoffee.class);
                    startActivity(i);
                } catch (Exception e){

                }
            }
        });

        orderDetailsImageButton = (ImageButton) findViewById(R.id.mmOrderImage);
        orderDetailsImageButton.setOnClickListener(new View.OnClickListener() {
            /**
             * This triggers on the click of the shopping cart image-button
             * @param v is the current view
             */
            @Override
            public void onClick(View v) {
                try{
                    Intent i = new Intent(MainActivity.this, OrderDetails.class);
                    startActivity(i);
                } catch (Exception e){

                }
            }
        });

        storeOrdersImageButton = (ImageButton) findViewById(R.id.mmStoreOrderImage);
        storeOrdersImageButton.setOnClickListener(new View.OnClickListener() {
            /**
             * This triggers on the click of the list and shopping-cart image-button
             * @param v is the current view
             */
            @Override
            public void onClick(View v) {
                try{
                    Intent i = new Intent(MainActivity.this, StoreOrders.class);
                    startActivity(i);
                } catch (Exception e){

                }

            }
        });


    }

}