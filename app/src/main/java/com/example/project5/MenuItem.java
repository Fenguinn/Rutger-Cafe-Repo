package com.example.project5;


import java.text.DecimalFormat;

/**
 * This class holds the properties of an Object representing a Menu Item, such as Coffee or Donuts.
 * @author Abdullah Salem, Gent Blaku
 *
 */
public class MenuItem {
    private double price;
    private int quantity;

    /**
     * The default constructor for a instance of an menu item class.
     */

    public MenuItem () {}

    /**
     * An overloaded constructor for a instance of an menu item class that accepts a double as a price.
     * @param itemPrice is the price of an item
     * @param number the quantity of this certain item
     */
    public MenuItem (double itemPrice, int number) {
        this.price = itemPrice;
        this.quantity = number;
    }

    /**
     * A method that calculates and returns the price of this item
     * @return price, a double containing the price of the item
     */
    public double itemPrice() {
        return this.price * this.quantity;
    }


    /**
     * This method sets the price of a Menu Item object.
     * @param number the price to be set to.
     */
    public void setPrice(double number) {
        this.price = number;
    }

    /**
     * This method fetches the price of a Menu Item object.
     * @return price the price of the Object.
     */
    public double getPrice() {
        return this.price;
    }


    /**
     * This method sets the quantity of a Menu Item object.
     * @param number the quantity to be set to.
     */
    public void setQuantity(int number) {
        this.quantity = number;
    }

    /**
     * This method fetches the quantity of a Menu Item object.
     * @return quantity the quantity of the object.
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * This method increments the quantity of a Menu Item Object by a certain amount.
     * @param number the number to be incremented by.
     */
    public void incrementQuantity(int number) {
        this.quantity += number;
    }

    /**
     * This uses the DecimalFormat class to format into dollar format.
     * @param price the price to be formatted
     * @return a String representation of the formatted price
     */
    public String formatPrice(double price) {
        DecimalFormat df = new DecimalFormat("$#,##0.00");
        String formattedPay = df.format(price);
        return formattedPay;
    }

}
