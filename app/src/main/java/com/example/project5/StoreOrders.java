package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
/**
 * An Activity class that provides the functionality to manage multiple orders
 * This is the activity class of the "activity_store_orders.xml" Window.
 * @author Abdullah Salem, Gent Blaku
 *
 */
public class StoreOrders extends AppCompatActivity {
    private static final int ONE = 1;
    private ArrayList<String> allTheStoreOrdersList;
    private ArrayAdapter arrayAdapter;
    private ListView StoreOrdersList;
    private Button cancelOrderbutton;
    private int positionBadStoreOrder;


    /**
     * This function is called automatically and initializes the elements of the activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_orders);
        this.setTitle("Store Orders");

        StoreOrdersList = (ListView)findViewById(R.id.StoreOrdersList);
        cancelOrderbutton = (Button)findViewById(R.id.CancelOrderButton);

        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, allTheStoreOrdersList );
        StoreOrdersList.setAdapter(arrayAdapter);


        StoreOrdersList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long arg3) {
                positionBadStoreOrder = position;
            }
        });

        this.update();
    }
    /**
     * This is a helper function that is called several times through out the class. It changes the page to match any changes made by the user.
     */
    private void update() {

        allTheStoreOrdersList.clear();

        for (int i=0; i<MainActivity.myStore.getSize(); i++){
            MainActivity.myStore.getOrder(i).calculatePayment();
            allTheStoreOrdersList.add("Order #" + i + "\n"
                                        +MainActivity.myStore.getOrder(i).toString() +
                                        "\nOrder total: " + MainActivity.myStore.getOrder(i).getTotal() +" " +
                    "                   (subtotal: " + MainActivity.myStore.getOrder(i).getSubtotal() +", tax: " + MainActivity.myStore.getOrder(i).getSalesTax()  );
        }
    }




    /**
     * This function is called when the cancel order button is clicked. It removes the selected order from the list.
     */
    public void cancelThisOrder(View view) {
        try {
            this.allTheStoreOrdersList.remove(positionBadStoreOrder);
            MainActivity.myStore.remove(positionBadStoreOrder);
            this.update();
        } catch (Exception e) {
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(this, "Please select something to remove" , duration);
            toast.show();
        }

    }









}