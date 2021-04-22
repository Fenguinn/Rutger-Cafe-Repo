package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * This activity class provides the functionality for ordering donuts.
 * This is the controller class of the "activity_ordering_donuts.xml" activity.
 * @author Abdullah Salem, Gent Blaku
 *
 */
public class OrderingDonuts extends AppCompatActivity {

    public final static int ZERO = 0;
    public final static int ONE = 1;
    public final static int TWO = 2;
    public final static int THREE = 3;
    public final static int FOUR = 4;
    public final static int FIVE = 5;
    public final static int SIX = 6;
    public final static int SEVEN = 7;
    public final static int EIGHT = 8;
    public final static int NINE = 9;
    public final static int TEN = 10;
    public final static int ELEVEN = 11;
    public final static int TWELVE = 12;

    private ArrayList<Donut> myDonuts;
    private ArrayList<String> myListStrings;
    private TextView subtotalTextViewDonuts;
    private ArrayAdapter<String> arrayAdapter;
    private int positionBadDonut;

    private Spinner flavorPicker;
    private Spinner quantityPicker;
    private ListView donutList_ListView;
    private Button addToListButton;
    private Button removeFromListButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordering_donuts);

        myDonuts = new ArrayList<Donut>();
        myListStrings = new ArrayList<String>();
        subtotalTextViewDonuts = (TextView) findViewById(R.id.subtotalTextViewDonuts);
        flavorPicker = (Spinner)findViewById(R.id.flavorSpinner);
        quantityPicker = (Spinner)findViewById(R.id.numDonutSpinner);
        donutList_ListView = (ListView)findViewById(R.id.donutListView);

        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, myListStrings );
        donutList_ListView.setAdapter(arrayAdapter);


        donutList_ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long arg3) {
                positionBadDonut = position;
            }
        });
    }


    private void update() {
        myListStrings.clear();

        double subtotal = 0;

        for (int x = 0; x < this.myDonuts.size(); x++) {
            myListStrings.add(this.myDonuts.get(x).toString());
            subtotal += this.myDonuts.get(x).itemPrice();
        }

        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, myListStrings );
        donutList_ListView.setAdapter(arrayAdapter);

        MenuItem formatter = new MenuItem();

        subtotalTextViewDonuts.setText(formatter.formatPrice(subtotal));
    }

    public void addToList(View view) {
        int flavor = flavorPicker.getSelectedItemPosition();
        int quantity = quantityPicker.getSelectedItemPosition() + ONE;

        Donut myDonut = new Donut(quantity, flavor+1);
        myDonuts.add(myDonut);
        update();
    }

    public void removeFromList(View view) {
        try {
            this.myDonuts.remove(positionBadDonut);
            this.update();
        } catch (Exception e) {
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(this, "Please select something to remove" , duration);
            toast.show();
        }
    }

    public void addToOrder(View view) {
        if (myDonuts.isEmpty()) {
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(this, "Please pick a donut!" , duration);
            toast.show();
            return;
        }

        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(this, "Donut(s) have been added to Order" , duration);
        toast.show();



        for (int x = 0; x < this.myDonuts.size(); x++) {
            MainActivity.myOrder.add(this.myDonuts.get(x));
        }
        this.myDonuts = new ArrayList<Donut>();
        this.update();
    }
}