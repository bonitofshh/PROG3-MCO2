import java.util.ArrayList;
import java.util.Scanner;

public class SVM extends VM {
    ArrayList<Item> cartList;
    ItemSlot[] addOnSlotList;
    int numAddOn;
    /**
     * 
     * @param name
     * @param slotNum
     */
    public SVM(String name, int slotNum, int maxItems, int numAddOn){
        super(name, slotNum, maxItems);
        super.name = name;
        super.slotList = new ItemSlot[slotNum];
        super.startInventoryList = new ItemSlot[slotNum];
        super.moneyBox = new Money();
        super.userInput = new Money();
        super.transactionList = new ArrayList<Transactions>();
        super.maxItems = maxItems;
        this.addOnSlotList = new ItemSlot[numAddOn];
        this.numAddOn = numAddOn;
    }

    /**
     * 
     * @param name
     * @param slotList
     * @param startInventoryList
     * @param moneyBox
     */
    public SVM(String name, ItemSlot slotList[], ItemSlot startInventoryList[], Money moneyBox, int maxItems, int numAddOn){
        super(name, slotList, startInventoryList, moneyBox, maxItems);
        super.name = name;
        super.slotList = slotList;
        super.startInventoryList = startInventoryList;
        super.moneyBox = moneyBox;
        super.userInput = new Money();
        super.transactionList = new ArrayList<Transactions>();
        super.maxItems = maxItems;
        this.addOnSlotList = new ItemSlot[numAddOn];
        this.numAddOn = numAddOn;
    }

    public SVM(){
        super();
    }
   
    public boolean validIngredients() {
        ItemSlot[] tempList = slotList;
        ArrayList<Item> tempCart = cartList;

        int count = -1;
        while (tempCart != null) { //checks if cart is empty or not
            count++;
            for (int i = 0; i < tempList.length; i++) {
                if (tempCart.get(count) == tempList[i].getItem() 
                            && isItemAvail(tempList[i].getItem().getName(), maxItems) == false) {
                    
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

    
    public void displayAddOns(){ 
        System.out.println("\nAvailable add-ons: ");
        System.out.println("Item Name\tPrice\tCalories\tQty");
        for(int i = 0; i < addOnSlotList.length; i++){
            System.out.println("["+ (i+1) + "] " + addOnSlotList[i].getItem().getName() + "\t" + addOnSlotList[i].getItem().getPrice() + 
            "\t" + addOnSlotList[i].getItem().getCalories() + "\t\t" + addOnSlotList[i].getQuantity(numAddOn));
        }
        System.out.println("\n");
    }

    @Override
    public VM createVM(Scanner sc, ArrayList<VM> vmList){
        System.out.println("Enter Vending Machine name: "); //asks for vending machine name 
        String slotNameSVM = sc.nextLine();
        slotNameSVM = sc.nextLine();
        int isValidSVM = 0;
        SVM SVM = new SVM(null, 0, 0, 0);
        while (isValidSVM == 0) {
            System.out.println("Enter number of slots for individual items: "); //asks for number of slots 
            int slotNum = sc.nextInt();
            if (slotNum < 8 || slotNum > 20) {
                System.out.println("Invalid number of slots!");
            }
            else { 
                //TODO: CHECK IF PWEDE GANTO
                int rawr = 0;
                int maxItems = 0;
                while (rawr == 0) {
                    System.out.println("Enter max quantity of items per slot: ");
                    maxItems = sc.nextInt();
                    if (maxItems < 5 || maxItems > 20) System.out.println("Invalid number!");
                    else rawr = 1;
                }
                System.out.println("Enter number of slots for add-ons: ");
                numAddOn = sc.nextInt();
                if(numAddOn < 0)
                    System.out.println("Invalid number of add-ons");
                else {
                    SVM = new SVM(slotNameSVM, slotNum, maxItems, numAddOn);
                    vmList.add(SVM);
                    
                    System.out.println("Enter the customizable item (eg. sandwich/ramen/mongolian rice): ");
                    String specialItem = sc.nextLine();
                    specialItem = sc.nextLine();
                    for(int i = 0; i < slotNum; i++){
                        int flag = 0, tempPrice = 0, tempQty = 0, tempCalories = 0;
                        String tempName;
                        System.out.println("Enter item name for Slot [" + (i+1) + "]: ");
                        if(i > 0)
                            tempName = sc.nextLine();
                        tempName = sc.nextLine();
                        
                        while (flag == 0){
                            System.out.println("Enter " + tempName + "'s price: ");
                            tempPrice = sc.nextInt();
                            if(tempPrice <= 0) System.out.println("Has to be positive");
                            else flag = 1;
                        }
                        flag = 0;
                        while (flag == 0){
                            System.out.println("Enter " + tempName + "'s calories: ");
                            tempCalories = sc.nextInt();
                            if(tempCalories < 0) System.out.println("Cannot be negative!");
                            else flag = 1;
                        }
                        flag = 0;
                        while (flag == 0){
                            System.out.println("Enter " + tempName + "'s quantity: ");
                            tempQty = sc.nextInt();
                            if(tempQty <= 0) System.out.println("The value has to be positive.");
                            else if (tempQty > maxItems) System.out.println("It can only hold " + maxItems + " items!");
                            else flag = 1;
                        }
                        
                        Item tempItem = new Item(tempName, tempCalories, tempPrice); //creates temporary instance of item with user inputs of name, calories, and price
                        Item[] itemList = new Item[maxItems];
                        for (int j = 0; j < tempQty; j++){
                            itemList[j] = tempItem; 
                        }
                        ItemSlot temp = new ItemSlot(itemList, tempItem); //creates temporary instance slot based on inputted quantity and item 
                        SVM.getSlotList()[i] = temp; //saves value to the slot of the vending machine 
                    }

                    for(int i = 0; i < numAddOn; i++){
                        int flag = 0, tempPrice = 0, tempQty = 0, tempCalories = 0;
                        System.out.println("Enter add-on name for Slot [" + (i+1) + "]: ");
                        String tempName = sc.nextLine();
                        tempName = sc.nextLine();
                        while (flag == 0){
                            System.out.println("Enter " + tempName + "'s price: ");
                            tempPrice = sc.nextInt();
                            if(tempPrice <= 0) System.out.println("Has to be positive");
                            else flag = 1;
                        }
                        flag = 0;
                        while (flag == 0){
                            System.out.println("Enter " + tempName + "'s calories: ");
                            tempCalories = sc.nextInt();
                            if(tempCalories < 0) System.out.println("Cannot be negative!");
                            else flag = 1;
                        }
                        flag = 0;
                        while (flag == 0){
                            System.out.println("Enter " + tempName + "'s quantity: ");
                            tempQty = sc.nextInt();
                            if(tempQty <= 0) System.out.println("The value has to be positive.");
                            else if (tempQty > maxItems) System.out.println("It can only hold " + maxItems + " items!");
                            else flag = 1;
                        }
                        
                        Item tempAddOn = new addOn(tempName, tempCalories, tempPrice);
                        Item[] addOnList = new Item[maxItems];
                        for (int j = 0; j < tempQty; j++){
                            addOnList[j] = tempAddOn; 
                        }
                        ItemSlot temp = new ItemSlot(addOnList, tempAddOn);
                        ItemSlot[] addOnSlotList = new ItemSlot[numAddOn];
                        addOnSlotList[i] = temp;
                    }   
                    //isValid = 1;
                    System.out.println("Vending machine successfully created.");
                    SVM.setStartInventory(SVM.getSlotList()); //saves starting inventory of the vending machine
                    return SVM;
                }
                
            }
        }
        return SVM;
    }
    
    @Override
    public void displayProducts(ItemSlot[] product, int maxItems){ 
        System.out.println("\nAvailable products: ");
        System.out.println("Item Name\tPrice\tCalories\tQty");
        for(int i = 0; i < product.length; i++){
            System.out.println("["+ (i+1) + "] " + product[i].getItem().getName() + "\t" + product[i].getItem().getPrice() + 
            "\t" + product[i].getItem().getCalories() + "\t\t" + product[i].getQuantity(maxItems));
        }
        System.out.println("\n");
        System.out.println("\nAvailable add-ons: ");
        System.out.println("Item Name\tPrice\tCalories\tQty");
        for(int i = 0; i < addOnSlotList.length; i++){
            System.out.println("["+ (i+1) + "] " + addOnSlotList[i].getItem().getName() + "\t" + addOnSlotList[i].getItem().getPrice() + 
            "\t" + addOnSlotList[i].getItem().getCalories() + "\t\t" + addOnSlotList[i].getQuantity(numAddOn));
        }
        System.out.println("\n");
    }
}

