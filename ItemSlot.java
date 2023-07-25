/**
 * A slot object that is created given a user's input on a given number of slots.
 * @author Ian Gabriel S. De Jesus & Sean Riley P. Veracruz
 * @version %I% %G%
 * @since 1.0
 */


public class ItemSlot {
    private int quantity;
    private Item item;
    

    /**
     * A class that creates an ItemSlot object.
     * @param quantity number of items
     * @param item item object
     */

    public ItemSlot(int quantity, Item item) {
        this.quantity = quantity;
        this.item = item;
    }

    /**
     * A class that creates an ItemSlot object without quantity.
     * @param quantity number of items
     * @param item item object
     */
    public ItemSlot(Item item) {
        this.quantity = 0;
        this.item = item;
    }
    
    /**
     * Gets current quantity of items in the slot. 
     * @return the number of items in the slot.
     */
    public int getQuantity() {
        return quantity;
    }

    
    /**
     * Gets the item in the slot
     * @return Item object in the slot
     */

    public Item getItem() {
        return item;
    }

    /**
     * Sets the quantity of items in the item slot.
     * @param quantity number of items
     */

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
