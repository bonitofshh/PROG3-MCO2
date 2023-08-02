/**
 * An addOn class that extends an item
 * @author Ian Gabriel S. De Jesus & Sean Riley P. Veracruz
 * @version %I% %G%
 * @since 1.0
 */

public class addOn extends Item {
    /**
     * sets name calories and price of addon
     * @param name name of item
     * @param calories calories of item
     * @param price price of item
     */
    public addOn(String name, int calories, int price){
        super(name, calories, price);
    }

    /**
     * makes add on object with null values
     */
    public addOn(){
        super.name = null;
        super.calories = 0;
        super.price = 0;
    }
}
