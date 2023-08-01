import java.util.ArrayList;

public class vmfModelSVM extends vmfModelVM{
    ItemSlot[] addOnSlotList;
    int numAddOn;
    SpecialItem customItem;

    public vmfModelSVM(String name, int slotNum, int maxItems, int numAddOn, String specialItem) {
        super.name = name;
        super.slotList = new ItemSlot[slotNum];
        super.startInventoryList = new ItemSlot[slotNum];
        super.moneyBox = new Money();
        super.userInput = new Money();
        super.transactionList = new ArrayList<Transactions>();
        super.maxItems = maxItems;
        this.addOnSlotList = new ItemSlot[numAddOn];
        this.numAddOn = numAddOn;
        this.customItem = new SpecialItem(specialItem);
    }

    public vmfModelSVM(){
        super();
        this.addOnSlotList = new ItemSlot[numAddOn];
    }

}
