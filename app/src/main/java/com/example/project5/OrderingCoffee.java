package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
/**
 * An Activity class that provides the functionality to manage ordering coffee
 * This is the activity class of the "activity_ordering_coffee.xml" Window.
 * @author Abdullah Salem, Gent Blaku
 *
 */
public class OrderingCoffee extends AppCompatActivity {
    public final static int ONE = 1;
    public final static int TWO = 2;
    public final static int THREE = 3;
    public final static int FOUR = 4;

    private Coffee myCoffee;
    private CheckBox milk;
    private CheckBox cream;
    private CheckBox syrup;
    private CheckBox caramel;
    private CheckBox whipped_cream;

    private TextView running_total;
    private Spinner coffeeSize;
    private Button addToOrderButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordering_coffee);
        this.setTitle("Order Coffee");
        myCoffee = new Coffee();

        milk = (CheckBox)findViewById(R.id.milkBox);
        cream = (CheckBox)findViewById(R.id.creamBox);
        syrup = (CheckBox)findViewById(R.id.syrupBox);
        caramel = (CheckBox)findViewById(R.id.caramelBox);
        whipped_cream = (CheckBox)findViewById(R.id.whippedCreamBox);
        running_total = (TextView)findViewById(R.id.subtotal_textview);
        coffeeSize = (Spinner)findViewById(R.id.coffeeSizeList);
        addToOrderButton = (Button)findViewById(R.id.AddToOrderButton);


        coffeeSize.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int size = coffeeSize.getSelectedItemPosition() + ONE;
                myCoffee.setSize(size);
                update();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        update();
    }

    private void update() {
        double total = myCoffee.itemPrice();
        running_total.setText(myCoffee.formatPrice(total));
    }

    public void handleMilk(View view){
        if (milk.isChecked())
            myCoffee.add("Milk");
        else
            myCoffee.remove("Milk");
        update();
    }


    public void handleCream(View view){
        if (cream.isChecked())
            myCoffee.add("Cream");
        else
            myCoffee.remove("Cream");
        update();
    }


    public void handleSyrup(View view){
        if (syrup.isChecked())
            myCoffee.add("Syrup");
        else
            myCoffee.remove("Syrup");
        update();
    }
    public void handleCaramel(View view){
        if (caramel.isChecked())
            myCoffee.add("Caramel");
        else
            myCoffee.remove("Caramel");
        update();
    }
    public void handleWhippedCream(View view){
        if (whipped_cream.isChecked())
            myCoffee.add("Whipped Cream");
        else
            myCoffee.remove("Whipped Cream");
        update();
    }

    public void addToOrder(View view) {

        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(this, "Coffee has been added to Order" , duration);
        toast.show();


        //RunningTotal.setText("gent1");
        MainActivity.myOrder.add(myCoffee);
        cream.setChecked(false);
        cream.setChecked(false);
        milk.setChecked(false);
        caramel.setChecked(false);
        whipped_cream.setChecked(false);
        syrup.setChecked(false);

        myCoffee = new Coffee();

        int size = coffeeSize.getSelectedItemPosition() + ONE;
        myCoffee.setSize(size);
        update();
    }



}