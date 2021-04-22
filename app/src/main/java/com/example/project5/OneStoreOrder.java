package com.example.project5;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class provides the functionality of managing multiple orders as well as other features.
 * @author Abdullah Salem, Gent Blaku
 *
 */
public class OneStoreOrder implements Customizable{
    private ArrayList<Order> storeOrdersList;


    /**
     * The default constructor of the StoreOrders class.
     */
    public OneStoreOrder() {
        storeOrdersList = new ArrayList<Order>();
    }

    /**
     * This method fetches the size of the list.
     * @return the size of the list as an integer.
     */
    public int getSize() {
        return this.storeOrdersList.size();
    }

    /**
     * This methods fetches the Order at the given index.
     * @param index is the index of the order in the list.
     * @return the order
     */
    public Order getOrder(int index) {
        return this.storeOrdersList.get(index);
    }


    /**
     * This function adds an object to the list.
     * @param obj is an object that is being added to the list
     * @return true if an object is added, false if otherwise.
     */
    @Override
    public boolean add(Object obj) {
        if (obj instanceof Order) {
            Order order = (Order)obj;
            this.storeOrdersList.add(order);
            return true;
        }
        return false;
    }
    /**
     * This function removes an object from the list, if it is in the list.
     * @param obj is an object that is being removed from the list
     * @return true if an object is removed, false if otherwise.
     */
    @Override
    public boolean remove(Object obj) {
        return false;
    }


    /**
     * This function removes an object from the list, if it is in the list.
     * @param removeIndex is the index that is being removed from the list
     * @return true if an object is removed, false if otherwise.
     */
    public boolean remove(int removeIndex) {
        if (removeIndex <= storeOrdersList.size()) {
            this.storeOrdersList.remove(removeIndex);
            return true;
        }
        return false;
    }

    /**
     * This function overrides the toString function.
     * @return currString is a String containing all orders of the list.
     */
    @Override
    public String toString() {
        if (this.storeOrdersList.isEmpty())
            return null;

        String currString="";
        for (int i=0; i<this.storeOrdersList.size(); i++) {
            currString = currString + this.storeOrdersList.get(i).toString() + "\n";
        }
        return currString;
    }

}
