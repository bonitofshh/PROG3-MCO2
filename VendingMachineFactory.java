import java.util.Scanner;
import java.util.ArrayList; //imports utilities

public class VendingMachineFactory {
    public static void main(String args[]) {
        Item bread = new Item("Bread", 100, 50);
        Item bacon = new Item("Bacon", 80, 20);
        Item chicken = new Item("Chicken", 90, 40);
        Item sausage = new Item("Sausage", 40, 30);
        Item chips = new Item("Chips", 150, 25);
        Item sprite = new Item("Sprite", 140, 40);
        Item water = new Item("Water", 20, 20);
        Item hotdog = new Item("Hotdog", 105, 35);

        ItemSlot breadSlot = new ItemSlot(15, bread);
        ItemSlot baconSlot = new ItemSlot(13, bacon);
        ItemSlot chickenSlot = new ItemSlot(11, chicken);
        ItemSlot sausageSlot = new ItemSlot(18, sausage);
        ItemSlot chipsSlot = new ItemSlot(14, chips);
        ItemSlot spriteSlot = new ItemSlot(17, sprite);
        ItemSlot waterSlot = new ItemSlot(12, water);
        ItemSlot hotdogSlot = new ItemSlot(10, hotdog);

        ItemSlot slots[] = {breadSlot, baconSlot, chickenSlot, sausageSlot, chipsSlot, spriteSlot, waterSlot, hotdogSlot};
        Money moneyBox = new Money(10, 10, 10, 10, 10, 10, 10, 10, 10, 0);
        ArrayList<Transactions> transactionList = new ArrayList<Transactions>();

        VM bakery = new VM("Egg Drop", slots, slots, moneyBox);

        int choice = 0;
        String itemName = null; //declares and initializes holder variables for user input

        Scanner sc = new Scanner(System.in);
        ArrayList<VM> vmList = new ArrayList<VM>(); //declares instances of the scanner and arrayList of vending machines
        vmList.add(bakery);
        bakery.setStartInventory(bakery.getSlotList());
        System.out.println("Welcome to the Vending Machine Factory!");

        while (choice != 3) { //loop program until user exits 
            System.out.println("[1] Make Vending Machine\n[2] Test Vending Machine\n[3] Exit");
            choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("[1] Regular Vending Machine\n[2] Special Vending Machine");
                    int vendingType = sc.nextInt();

                    switch (vendingType) {
                        case 1: 
                            System.out.println("Enter Vending Machine name: "); //asks for vending machine name 
                            String slotName = sc.nextLine();
                            slotName = sc.nextLine();
                            int isValid = 0;
                            while (isValid == 0) {
                                System.out.println("Enter number of slots: "); //asks for number of slots 
                                int slotNum = sc.nextInt();
                                if (slotNum < 8 || slotNum > 20) {
                                    System.out.println("Invalid number of slots!");
                                }
                                else { 
                                    VM VM = new VM(slotName, slotNum);  
                                    vmList.add(VM); //creates instance of a vending machine and asks for user input for item name, calories, price, and quantity 
                                    for(int i = 0; i < slotNum; i++){
                                        int flag = 0, tempPrice = 0, tempQty = 0, tempCalories = 0;
                                        System.out.println("Enter item name for Slot [" + (i+1) + "]: ");
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
                                            else if (tempQty > 20) System.out.println("It can only hold 20 items!");
                                            else flag = 1;
                                        }
                                        
                                        Item tempItem = new Item(tempName, tempCalories, tempPrice); //creates temporary instance of item with user inputs of name, calories, and price
                                        ItemSlot temp = new ItemSlot(tempQty, tempItem); //creates temporary instance slot based on inputted quantity and item 
                                        VM.getSlotList()[i] = temp; //saves value to the slot of the vending machine 
                                        
                                    }
                                    isValid = 1;
                                    System.out.println("Vending machine successfully created.");
                                    VM.setStartInventory(VM.getSlotList()); //saves starting inventory of the vending machine
                                }
                            }
                            
                            break;

                        case 2: // TODO: Create a special vending machine function (MCO2)
                            /* 
                            Implement customizable preset items 
                            */
                            break;
                        default: choice = 0;
                    } 
                    break; 

                case 2: 
                    int index = -1;

                    if (vmList.isEmpty() == true) System.out.println("No vending machines!");//validates if vending machines exist 
                    else {
                        
                        System.out.println("Enter the name of the vending machine to test: [0] to exit");
                    
                        for (int i = 0; i < vmList.size(); i++) {
                            System.out.println((i+1) + ". " + vmList.get(i).getName());
                        }
                        String vmName = sc.nextLine(); //input buffer
                        vmName = sc.nextLine();
                    
                        if (vmName.equals("0")) break; 
                        int flag = 0;
                        
                        for (int i = 0; i < vmList.size(); i++) {
                            if (vmName.equals(vmList.get(i).getName())) {
                                index = i;
                                flag = 1;
                            } //looks for vending machine 
                        }
                        if (flag == 0) System.out.println("Vending Machine not found");
                        else {
                            int vmTest = -1;
                            VM VM = vmList.get(index);

                            System.out.println("\nDisplaying Starting Inventory:");
                            VM.displayProducts(VM.getStartInventory());//displays starting inventory of the vending machine 

                            while (vmTest != 3) {
                            System.out.println("[1] Test Vending Features\n[2] Perform Maintenance\n[3] Exit");
                            vmTest = sc.nextInt();
                                
                            switch(vmTest) {
                                case 1: //start of test vending features component
                                    int guard = 0;
                                    VM.displayProducts(VM.getSlotList()); 
                                    VM.addMoney(VM.getUserInput(), sc);
                                    System.out.println("Enter name of item to purchase: ");
                                    itemName = sc.nextLine(); 
                                    itemName = sc.nextLine();
                                    for(int i = 0;  i < VM.getSlotList().length; i++){
                                        if(itemName.equals(VM.getSlotList()[i].getItem().getName())){ //checks if item exists 
                                            if(VM.isItemAvail(itemName) == true) { //checks if item is available
                                                if(VM.validChange(itemName) == true) { //checks if the vending machine has enough change 
                                                    VM.dispenseItem(itemName, VM.getSlotList()); //dispenses item 
                                                    Money tempChange = VM.dispenseChange(itemName); //dispenses user's change 
                                                    VM.createTransaction(itemName); //creates a transaction 
                                                    tempChange.displayDenominations(); //displays the denominations of the change 
                                                    VM.emptyMoney(VM.getUserInput()); //resets user inputted money value 
                                                    guard = 1;
                                                } else guard = 1;
                                            }
                                        }
                                    }
                                    if(guard == 0){ //returns user's money and resets money input when previous conditions aren't met
                                            System.out.println("Item not found");
                                            System.out.println("Returning money...");
                                            VM.emptyMoney(VM.getUserInput());
                                    }
                                    break;
                                case 2: //start of maintenance features
                                    guard = 0;
                                    while (guard == 0){
                                        System.out.println("Welcome back, operator!");
                                        System.out.println("[1] Restock items\n[2] Change Item Price\n[3] Collect Money in Vending Machine\n[4] Replenish Change");
                                        System.out.println("[5] Show Transaction Summary\n[6] Exit");
                                        choice = sc.nextInt();

                                        switch(choice){
                                            case 1: 
                                                System.out.println("\n(Displaying Initial Inventory)");
                                                VM.displayProducts(VM.getStartInventory());
                                                System.out.println("\n(Displaying Current Inventory)");

                                                VM.displayProducts(VM.getSlotList()); //displays ending inventory after previous purchases 
                                                System.out.println("Enter item name to restock: ");

                                                itemName = sc.nextLine();//input buffer 
                                                itemName = sc.nextLine();
                                                VM.addStock(itemName, sc);                                                     
                                                break;
                                            case 2: 
                                                VM.displayProducts(VM.getSlotList()); 
                                                System.out.println("Enter item name to change price: ");
                                                itemName = sc.nextLine(); //input buffer 
                                                itemName = sc.nextLine();
                                                VM.setPrice(itemName, sc);//changes item's price 
                                                break;
                                            case 3:
                                                System.out.println("Collecting money from money box....");
                                                System.out.println("You have collected " + VM.getMoneyBox().getTotalMoney() + " from the money box");
                                                VM.getMoneyBox().displayDenominations();
                                                VM.emptyMoney(VM.getMoneyBox()); //empties money box 
                                                break;
                                            case 4:
                                                VM.addMoney(VM.getMoneyBox(), sc); //adds change
                                                break;
                                            case 5: 
                                                VM.printTransactionSummary(); //prints summary of transactions
                                                //
                                                break;  
                                            case 6: guard = 1; break;
                                            default: 
                                                System.out.println("Invalid option!");   
                                        }
                                    } 
                                    break;
                                default: System.out.println("Invalid option!");                            
                            }   
                        }
                    } 
                }
                    break; 
                case 3: choice = 3; //exits program 
                    break;
                default: choice = 0;
            }
        }
            sc.close(); //closes scanner
    }
}