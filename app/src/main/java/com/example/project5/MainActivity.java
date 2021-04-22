package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton donutImageButton;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        donutImageButton = (ImageButton) findViewById(R.id.mmDonutImage);
        donutImageButton.setOnClickListener(this);


    }
    public void onClick(View view) {
        Intent i = new Intent(MainActivity.this, OrderingDonuts.class);
        startActivity(i);
    }

}