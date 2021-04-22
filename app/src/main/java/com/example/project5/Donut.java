package com.example.project5;

public class Donut extends MenuItem{

    enum AllFlavors { JELLYFILLED, BOSTONKREME, STRAWBERRYLEMONSWIRL, MAPLEFROSTED, BLUEBERRYCAKE, ICECREAMCAKE,CHOCOLOCO, GLAZED, BERRYBEAUTIFUL  }



    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX= 6;
    private static final int SEVEN = 7;
    private static final int EIGHT = 8;
    private static final int NINE = 9;

    private static final double DONUTPRICE= 1.39;


    private AllFlavors mouthExplosion;

    /**
     * This constructor initializes a Donut object with it's properties.
     * @param number the number of donuts
     * @param flavor the donut flavor e.g. jelly filled
     */
    public Donut(int number, int flavor) {
        super();
        super.setPrice(DONUTPRICE);
        super.setQuantity(number);

        switch (flavor) {
            case ONE:
                this.mouthExplosion = AllFlavors.JELLYFILLED;
                break;
            case TWO:
                this.mouthExplosion = AllFlavors.BOSTONKREME;
                break;
            case THREE:
                this.mouthExplosion = AllFlavors.STRAWBERRYLEMONSWIRL;
                break;
            case FOUR:
                this.mouthExplosion = AllFlavors.MAPLEFROSTED;
                break;
            case FIVE:
                this.mouthExplosion = AllFlavors.BLUEBERRYCAKE;
                break;
            case SIX:
                this.mouthExplosion = AllFlavors.ICECREAMCAKE;
                break;
            case SEVEN:
                this.mouthExplosion = AllFlavors.CHOCOLOCO;
                break;
            case EIGHT:
                this.mouthExplosion = AllFlavors.GLAZED;
                break;
            case NINE:
                this.mouthExplosion = AllFlavors.BERRYBEAUTIFUL;
                break;

        }
    }


    /**
     * This method fetches the price of a Donut object.
     * @return a double, the price of a Donut object.
     */
    public double itemPrice() {
        return super.getPrice() * super.getQuantity();
    }





    /**
     * This method checks if two Donut objects are equal.
     * @param obj Donut object to be checked against
     * @return true if the objects are equal, false if not.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Donut) {
            Donut other = (Donut)obj;

            String shortOther = other.toString().substring(0,other.toString().length()-FIVE);
            String shortThis = this.toString().substring(0, this.toString().length()-FIVE);

            return shortOther.equals(shortThis);
        }


        return false;
    }




    /**
     * This method returns a String representation of a Donut object.
     * @return String representation of a Donut object.
     */
    @Override
    public String toString() {
        String myDonut = "";


            if (this.mouthExplosion == AllFlavors.JELLYFILLED) {
                myDonut = new String(myDonut + "jelly filled(");
            }
            else if (this.mouthExplosion == AllFlavors.BOSTONKREME) {
                myDonut = new String(myDonut + "boston kreme(");
            }
            else if (this.mouthExplosion == AllFlavors.STRAWBERRYLEMONSWIRL) {
                myDonut = new String(myDonut + "strawberry-lemon swirl(");
            }
            else if (this.mouthExplosion == AllFlavors.BLUEBERRYCAKE) {
                myDonut = new String(myDonut + "blueberry cake(");
            }
            else if (this.mouthExplosion == AllFlavors.ICECREAMCAKE) {
                myDonut = new String(myDonut + "ice-creame cake(");
            }
            else if (this.mouthExplosion == AllFlavors.MAPLEFROSTED) {
                myDonut = new String(myDonut + "maple frosted(");
            }
            else if (this.mouthExplosion == AllFlavors.BERRYBEAUTIFUL) {
                myDonut = new String(myDonut + "berry beautiful(");
            }
            else if (this.mouthExplosion == AllFlavors.CHOCOLOCO) {
                myDonut = new String(myDonut + "choco loco(");
            }
            else if (this.mouthExplosion == AllFlavors.GLAZED) {
                myDonut = new String(myDonut + "glazed(");
            }

        myDonut = new String(myDonut + super.getQuantity() + ")");

        return myDonut;
    }
}

