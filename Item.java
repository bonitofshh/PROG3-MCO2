/**
 * An item object that shows an item's name, number of calories, and its' price.
 * @author Ian Gabriel S. De Jesus & Sean Riley P. Veracruz
 * @version %I% %G%
 * @since 1.0
 */

public class Item {
    protected String name;
    protected int calories;
    private int price;
    
    /**
     * A function that creates an item details by giving a name, number of calories, and price.
     * @param name the name of the item
     * @param calories the number of calories of the item
     * @param price the numerical price of the item (whole number)
     */

    public Item(String name, int calories, int price) {
        this.name = name;
        this.calories = calories;
        this.price = price;
    }

    /**
     * Creates an empty item object with default values.
     */
    public Item(){
        this.name = null;
        this.calories = 0;
        this.price = 0;
    }

    /**
     * A function that gets the name of the item.
     * @return the name of the item.
     */
    public String getName(){
        return name;
    }

    /**
     * A function that gets the number of calories of the item.
     * @return number of calories
     */
    public int getCalories(){
        return calories;
    }

    /**
     * A function that gets the price of the item.
     * @return price of the item.
     */
    public int getPrice(){
        return price;
    }

    /**
     * Changes the price of an item.
     * @param price new price of the item.
     */
    public void setPrice(int price){
        this.price = price;
    }
}
