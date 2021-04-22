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
import java.util.StringTokenizer;

/**
 * This Activity class is for the current order menu
 * and allows for storing and manipulation of the user's order of Coffee and/or Donuts.
 * @author Abdullah Salem, Gent Blaku
 *
 */
public class OrderDetails extends AppCompatActivity {

    private ListView currentOrderList;
    private Button removeFromOrderButton;
    private Button placeOrderButton;
    private TextView subtotalTextView;
    private TextView salesTaxTextView;
    private TextView totalTextView;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> orderArrayListStrings;
    private int positionBadOrder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try{
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_order_details);
            this.setTitle(R.string.Order_Details);
            subtotalTextView = (TextView)findViewById(R.id.subtotalTextView);
            salesTaxTextView = (TextView)findViewById(R.id.taxTextView);
            totalTextView    = (TextView)findViewById(R.id.totalTextView);
            currentOrderList = (ListView)findViewById(R.id.orderListView);
            removeFromOrderButton = (Button)findViewById(R.id.removeItemButton);
            placeOrderButton      = (Button)findViewById(R.id.placeOrderButton);
            orderArrayListStrings = new ArrayList<String>();


            arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, orderArrayListStrings );
            currentOrderList.setAdapter(arrayAdapter);

            currentOrderList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapter, View v, int position, long arg3) {
                    positionBadOrder = position;
                }
            });


            update();
        }catch (Exception e){

        }

    }



    /**
     * This helper method updates the current page to match any changes made by the user.
     */
    private void update() {
        MainActivity.myOrder.calculatePayment();
        orderArrayListStrings.clear();
        StringTokenizer tokens = new StringTokenizer(MainActivity.myOrder.toString() + "\n" , "\n");
        while (tokens.hasMoreTokens()) {
           orderArrayListStrings.add(tokens.nextToken());
        }

        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, orderArrayListStrings );
        currentOrderList.setAdapter(arrayAdapter);

        subtotalTextView.setText(""+MainActivity.myOrder.getSubtotal());
        salesTaxTextView.setText(""+MainActivity.myOrder.getSalesTax());
        totalTextView.setText(""+MainActivity.myOrder.getTotal());
    }

    /**
     * This method removes an Object from the current order
     */
    public void removeItem(View view) {
        try{
            orderArrayListStrings.remove(positionBadOrder);
            MainActivity.myOrder.remove(positionBadOrder);
            update();
        }catch (Exception e) {
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(this, R.string.empty_remove_warning, duration);
            toast.show();
        }


    }


    /**
     * This method adds the current order to store orders and is triggered when the user clicks the Place Order button.
     */
    public void placeMyOrder(View view) {
        if (MainActivity.myOrder.isEmpty()) {
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(this, R.string.empty_order_warning, duration);
            toast.show();
            return;
        }



        if (MainActivity.myOrder != null) {
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(this, R.string.order_confirmation , duration);
            toast.show();

            MainActivity.myStore.add(MainActivity.myOrder);
            MainActivity.myOrder = new Order();
        }
        update();
//        Stage stage = (Stage) this.PlaceOrderButton.getScene().getWindow();     // do what you have to do
//        stage.close();
    }







}