package com.example.project5;

public class Coffee extends MenuItem{
    private static final double COFFEE_PRICE_DEFAULT = 1.49; // the price of a small coffee - 50 cents
    private static final double  PRICE_PER_ADD_IN= 0.20;
    private static final double  PRICE_PER_SIZE_UP = 0.50;
    private static final int SHORT = 1;
    private static final int TALL = 2;
    private static final int GRANDE = 3;
    private static final int VENTI = 4;
    private static final int ONE = 1;
    private static final int ELEVEN = 11;

    private boolean cream;
    private boolean milk;
    private boolean whippedCream;
    private boolean syrup;
    private boolean caramel;
    private int numOfAddIns;
    private int size;

    /**
     * Constructor for the Coffee class
     */
    public Coffee() {
        super(COFFEE_PRICE_DEFAULT, ONE);
    }

    /**
     * Sets the size of a Coffee object
     * @param newSize the desired size
     */
    public void setSize(int newSize) {
        this.size = newSize;
    }

    /**
     * A method that calculates and returns the price of this item
     * @return a double containing the price of the item
     */
    @Override
    public double itemPrice() {
        return (this.getPrice() + (this.size * PRICE_PER_SIZE_UP) + (this.numOfAddIns * PRICE_PER_ADD_IN)) * super.getQuantity();
    }


    /**
     * A method that adds add-ins to a Coffee Object, such as cream or syrup.
     * @param obj object to be added to the add-ins for Coffee
     * @return true if add-in successful, false if not.
     */

    public boolean add(Object obj) {
        if (obj instanceof String) {
            String AddIn = (String)obj;
            if (AddIn.equals("Cream") && !this.cream) {
                this.numOfAddIns++;
                this.cream = true;
                return true;
            }
            else if (AddIn.equals("Milk") && !this.milk) {
                this.numOfAddIns++;
                this.milk = true;
                return true;
            }
            else if (AddIn.equals("Whipped Cream") && !this.whippedCream) {
                this.numOfAddIns++;
                this.whippedCream = true;
                return true;
            }
            else if (AddIn.equals("Syrup") && !this.syrup) {
                this.numOfAddIns++;
                this.syrup = true;
                return true;
            }
            else if (AddIn.equals("Caramel") && !this.caramel) {
                this.numOfAddIns++;
                this.caramel = true;
                return true;
            }
        }
        return false;
    }

    /**
     * A method that removes add-ins from a Coffee object.
     * @param obj object to be added in as an add-in for the Coffee
     * @return true if add-in removed, false if not.
     */

    public boolean remove(Object obj) {
        if (obj instanceof String) {
            String AddIn = (String)obj;
            if (AddIn.equals("Cream") && this.cream) {
                this.numOfAddIns--;
                this.cream = false;
                return true;
            }
            else if (AddIn.equals("Milk") && this.milk) {
                this.numOfAddIns--;
                this.milk = false;
                return true;
            }
            else if (AddIn.equals("Whipped Cream") && this.whippedCream) {
                this.numOfAddIns--;
                this.whippedCream = false;
                return true;
            }
            else if (AddIn.equals("Syrup") && this.syrup) {
                this.numOfAddIns--;
                this.syrup = false;
                return true;
            }
            else if (AddIn.equals("Caramel") && this.caramel) {
                this.numOfAddIns--;
                this.caramel = false;
                return true;
            }
        }
        return false;
    }

    /**
     * A method that checks if one coffee object is equal to another.
     * @param obj Coffee object to be checked against
     * @return true if equal, false if not
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Coffee) {
            Coffee other = (Coffee)obj;

            String shortOther = other.toString().substring(ELEVEN);
            String shortThis = this.toString().substring(ELEVEN);

            return shortOther.equals(shortThis);
        }


        return false;
    }



    /**
     * This method returns the string representation of a Coffee object.
     * @return String representation of Coffee object
     */
    @Override
    public String toString() {
        String myCoffee = "Coffee (" + this.getQuantity() + ") ";
        switch(this.size)
        {
            case SHORT:
                myCoffee = myCoffee + "Short ";
                break;
            case TALL:
                myCoffee = myCoffee + "Tall ";
                break;
            case GRANDE:
                myCoffee = myCoffee + "Grande ";
                break;
            case VENTI:
                myCoffee = myCoffee + "Venti ";
                break;
        }

        if (this.numOfAddIns > 0) {
            int numCommas = this.numOfAddIns - ONE;
            myCoffee = myCoffee + "[";

            if (this.cream) {
                myCoffee = myCoffee + "Cream";
                if (numCommas > 0) {
                    myCoffee = myCoffee + ", ";
                    numCommas--;
                }
            }

            if (this.syrup) {
                myCoffee = myCoffee + "Syrup";
                if (numCommas > 0) {
                    myCoffee = myCoffee + ", ";
                    numCommas--;
                }
            }

            if (this.milk) {
                myCoffee = myCoffee + "Milk";
                if (numCommas > 0) {
                    myCoffee = myCoffee + ", ";
                    numCommas--;
                }
            }

            if (this.caramel) {
                myCoffee = myCoffee + "Caramel";
                if (numCommas > 0) {
                    myCoffee = myCoffee + ", ";
                    numCommas--;
                }
            }

            if (this.whippedCream) {
                myCoffee = myCoffee + "Whipped Cream";
                if (numCommas > 0) {
                    myCoffee = myCoffee + ", ";
                    numCommas--;
                }
            }

            myCoffee = myCoffee + "]";

        }
        //hey this is me
        return myCoffee;
    }
}
