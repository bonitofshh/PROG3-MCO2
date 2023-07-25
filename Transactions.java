/**
 * A transaction object that is created given a successful purchase.
 * It records the item name, and the price it was sold for.
 * @author Ian Gabriel S. De Jesus & Sean Riley P. Veracruz
 * @version %I% %G%
 * @since 1.0
 */

public class Transactions {
    private String name;
    private int price;

    /**
     * Creates a transaction object given an item name and the amount it was sold for.
     * @param name the name of the item
     * @param price the price of the item
     */
    public Transactions (String name, int price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Gets the name of the item
     * @return name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the price of the item
     * @return price of the item
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the name of the item
     * @param name new name of the item
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the new price of the item
     * @param price new price of the product
     */
    public void setPrice(int price) {
        this.price = price;
    }
}
