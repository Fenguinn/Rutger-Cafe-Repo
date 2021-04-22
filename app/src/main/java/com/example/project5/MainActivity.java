package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageButton myButton = (ImageButton) findViewById(R.id.mmDonutImage);
        myButton.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(MainActivity.this, OrderingDonuts.class);
                startActivity(intent);
            }


        });










    }



}