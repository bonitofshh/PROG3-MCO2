import java.util.ArrayList;

public class SVM extends VM {
    ArrayList<Item> cartList;

    /**
     * 
     * @param name
     * @param slotNum
     */
    public SVM(String name, int slotNum, int maxItems){
        super(name, slotNum, maxItems);
        super.name = name;
        super.slotList = new ItemSlot[slotNum];
        super.startInventoryList = new ItemSlot[slotNum];
        super.moneyBox = new Money();
        super.userInput = new Money();
        super.transactionList = new ArrayList<Transactions>();
        super.maxItems = maxItems;
    }

    /**
     * 
     * @param name
     * @param slotList
     * @param startInventoryList
     * @param moneyBox
     */
    public SVM(String name, ItemSlot slotList[], ItemSlot startInventoryList[], Money moneyBox, int maxItems){
        super(name, slotList, startInventoryList, moneyBox, maxItems);
        super.name = name;
        super.slotList = slotList;
        super.startInventoryList = startInventoryList;
        super.moneyBox = moneyBox;
        super.userInput = new Money();
        super.transactionList = new ArrayList<Transactions>();
        super.maxItems = maxItems;
    }
   
    public boolean validIngredients() {
        ItemSlot[] tempList = slotList;
        ArrayList<Item> tempCart = cartList;

        int count = -1;
        while (tempCart != null) { //checks if cart is empty or not
            count++;
            for (int i = 0; i < tempList.length; i++) {
                if (tempCart.get(count) == tempList[i].getItem() 
                            && isItemAvail(tempList[i].getItem().getName()) == false) {
                    
                    return false;
                    
                    
                } else if (tempCart.get(count) == tempList[i].getItem()) {                     
                    //TODO: Check if this works

                    //1st solution:
                    tempCart.remove(count);
                    ArrayList<Item> tempS = new ArrayList<Item>();
                    for (int j = 0; j < tempList.length; j++) {
                        tempS.add(tempList[j].getItem()) ;
                    }
                    tempS.remove(count);

                    for (int j = 0; j < tempS.size(); j++) {
                        tempList[j].setItem(tempS.get(j));
                    }

                    //2nd solution:  
                    tempList[i].removeOneStock(tempList[i].getItemList(), maxItems);
                    tempS.remove(count);
                }
            }
        }
        return true;
    }

    /**
     * 
     */
    public void removeFromSVM(){
        for (int i = 0; i < cartList.size(); i++) {
            Item temp = cartList.get(i);

            for (int j = 0; j < slotList.length; j++) {
                if (temp == slotList[j].getItem()) {
                    slotList[j].removeOneStock(slotList[j].getItemList(), maxItems);
                }
            }
        }
    }


}