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

    public int getNumItems(){
        return numItems;
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
            slotList[numItems].setItem(new Item(name, price, calories));
            incrementNumItems();
            flag = true;
            
        } else flag = false;

        return flag;
    }  
    
    public boolean addVM(String name, ItemSlot[] slotList, int maxItems) {
        //(vmList).add(new VM(name, slotList, maxItems))

        boolean flag = false;
        return flag;
    }
}
