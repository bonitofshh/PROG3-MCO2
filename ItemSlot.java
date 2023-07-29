/**
 * A slot object that is created given a user's input on a given number of slots.
 * @author Ian Gabriel S. De Jesus & Sean Riley P. Veracruz
 * @version %I% %G%
 * @since 1.0
 */


public class ItemSlot {
    private Item[] itemList;
    private Item item;

    /**
     * A class that creates an ItemSlot object.
     * @param itemList list of items
     * @param item item object
     */

    public ItemSlot(Item[] itemList, Item item) {
        this.itemList = itemList;
        this.item = item;
    }

    /**
     * Gets the item of the slot. 
     * @return the item of the slot.
     */
    public Item getItem() {
        return item;
    }

    /**
     * Gets the item of the slot. 
     * @return the item of the slot.
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * Gets the list of items in the slot
     * @return ItemList of the slot
     */

    public Item[] getItemList() {
        return itemList;
    }

    /**
     * Adds quantity of item objects in the item slot.
     * @param quantity number of items
     */
    public void addStock (int quantity, int maxItems){
        for (int i = 0; i < maxItems; i++) {
            if (itemList[i] == null && quantity > 0) {
                itemList[i] = item;
                quantity--;
            }
        }
    }

    /**
     * Removes one instance of the item
     * @param item the item to be removed
     */
    public void removeOneStock (Item[] itemList, int maxItems){
        for (int i = 0; i < maxItems; i++){
            if (itemList[i] == null){
                int index = i-1;
                itemList[index] = null;
                i = maxItems;
            }
        }
    }

    /**
     * Gets the number of objects in a slot
     * @return number of objects
     */
    public int getQuantity(int maxItems) {
        int count = 0;
        for (int i = 0; i < maxItems; i++) {
            if (itemList[i] != null) count++;
        }
        return count;
    }
}
