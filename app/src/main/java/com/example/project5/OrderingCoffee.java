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
        this.setTitle(R.string.Order_Coffee);
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

    /**
     * This helper method updates the current page to match any changes made by the user.
     */
    private void update() {
        double total = myCoffee.itemPrice();
        running_total.setText(myCoffee.formatPrice(total));
    }

    /**
     * This function is called when the milk option is selected, it adds milk to the Coffee Object.
     * @param view is the current view.
     */
    public void handleMilk(View view){
        if (milk.isChecked())
            myCoffee.add("Milk");
        else
            myCoffee.remove("Milk");
        update();
    }

    /**
     * This function is called when the Cream option is selected, it adds Cream to the Coffee Object.
     * @param view is the current view.
     */
    public void handleCream(View view){
        if (cream.isChecked())
            myCoffee.add("Cream");
        else
            myCoffee.remove("Cream");
        update();
    }


    /**
     * This function is called when the Syrup option is selected, it adds Syrup to the Coffee Object.
     * @param view is the current view.
     */
    public void handleSyrup(View view){
        if (syrup.isChecked())
            myCoffee.add("Syrup");
        else
            myCoffee.remove("Syrup");
        update();
    }

    /**
     * This function is called when the caramel option is selected, it adds caramel to the Coffee Object.
     * @param view is the current view.
     */
    public void handleCaramel(View view){
        if (caramel.isChecked())
            myCoffee.add("Caramel");
        else
            myCoffee.remove("Caramel");
        update();
    }

    /**
     * This function is called when the whipped cream  option is selected, it adds whipped cream to the Coffee Object.
     * @param view is the current view.
     */
    public void handleWhippedCream(View view){
        if (whipped_cream.isChecked())
            myCoffee.add("Whipped Cream");
        else
            myCoffee.remove("Whipped Cream");
        update();
    }

    /**
     * This function is called when user clicks Add to Order, it adds a Coffee Object to the current Order
     * @param view is the current view
     */
    public void addToOrder(View view) {

        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(this, R.string.coffee_confirm , duration);
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