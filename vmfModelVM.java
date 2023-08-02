import java.util.ArrayList;

public class vmfModelVM {
    protected String name; 
    protected ItemSlot[] slotList;
    protected ItemSlot[] startInventoryList;
    protected Money moneyBox;
    protected Money userInput; 
    protected ArrayList<Transactions> transactionList;
    protected int maxItems;
    protected int numItems;

    public vmfModelVM(String name, int slotNum, int maxItems) {
        this.name = name;
        this.slotList = new ItemSlot[slotNum];
        this.startInventoryList = new ItemSlot[slotNum];
        this.moneyBox = new Money();
        this.userInput = new Money();
        this.transactionList = new ArrayList<Transactions>();
        this.maxItems = maxItems;
        this.numItems = 0;
    }

    public vmfModelVM(){
        this.name = null;
        this.slotList = new ItemSlot[99];
        this.startInventoryList = new ItemSlot[99];
        this.moneyBox = new Money();
        this.userInput = new Money();
        this.transactionList = new ArrayList<Transactions>();
        this.maxItems = 0;
        this.numItems = 0;
    }

    public void addToSlotList(ItemSlot list) {
        this.slotList[numItems] = list;
    }

    public ItemSlot[] getSlotList() {
        return this.slotList;
    }

    public String getName(){
        return this.name;
    }

    public int getNumItems(){
        return this.numItems;
    }

    public void incrementNumItems() {
        this.numItems += 1;
    }

    public int getMaxItems(){
        return maxItems;
    }

    public boolean addItem(String name, int price, int calories) {
        boolean flag = false;
        if (price > 0 && calories > 0) {
            Item temp = new Item(name, calories, price);

            this.slotList[numItems].setItem(temp);
            incrementNumItems();
            flag = true;
            
        } else flag = false;
        return flag;
    }  

    public String getItemList() {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < slotList.length; i++){
            temp.append("1. " + slotList[i].getItem().getName());
        }

        return temp.toString();
    }
}
