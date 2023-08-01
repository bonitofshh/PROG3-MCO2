import java.util.ArrayList;

public class vmfModelVM {
    protected String name; 
    protected ItemSlot[] slotList;
    protected ItemSlot[] startInventoryList;
    protected Money moneyBox;
    protected Money userInput; 
    protected ArrayList<Transactions> transactionList;
    protected int maxItems;

    public vmfModelVM(String name, int slotNum, int maxItems) {
        this.name = name;
        this.slotList = new ItemSlot[slotNum];
        this.startInventoryList = new ItemSlot[slotNum];
        this.moneyBox = new Money();
        this.userInput = new Money();
        this.transactionList = new ArrayList<Transactions>();
        this.maxItems = maxItems;
    }

    public vmfModelVM(){
        this.name = null;
        this.slotList = new ItemSlot[99];
        this.startInventoryList = new ItemSlot[99];
        this.moneyBox = new Money();
        this.userInput = new Money();
        this.transactionList = new ArrayList<Transactions>();
        this.maxItems = 0;
    }

    public boolean addItem(String name, int price, int calories, int index) {
        boolean flag = false;

        if (price > 0 && calories > 0) {
            try {
                slotList[index].setItem(new Item(name, price, calories));
                flag = true;
            }

            catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } else {
            flag = false;
        }
        
        return flag;
    }  
    
    public boolean addVM(String name, ItemSlot[] slotList, int maxItems) {
        //(vmList).add(new VM(name, slotList, maxItems))

        boolean flag = false;
        return flag;
    }
}
