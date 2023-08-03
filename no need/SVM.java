import java.util.ArrayList;
import java.util.Scanner;

public class SVM extends VM {
    //ArrayList<Item> cartList;
    ItemSlot[] addOnSlotList;
    int numAddOn;
    SpecialItem customItem;
    /**
     * 
     * @param name
     * @param slotNum
     */
    public SVM(String name, int slotNum, int maxItems, int numAddOn, String specialItem){
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
        this.customItem = new SpecialItem(specialItem);
    }

    /**
     * 
     * @param name
     * @param slotList
     * @param startInventoryList
     * @param moneyBox
     */
    public SVM(String name, ItemSlot slotList[], ItemSlot startInventoryList[], Money moneyBox, int maxItems, int numAddOn, String specialItem){
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
        this.customItem = new SpecialItem(specialItem);
    }

    public SVM(){
        super();
        this.addOnSlotList = new ItemSlot[numAddOn];

    }
   
    public ItemSlot[] getAddOnSlotList(){
        return addOnSlotList;
    }

    //TODO: FIX TOMORROW
    public boolean validIngredients() {
        ItemSlot[] tempList = slotList;
        ItemSlot[] tempAddOn = addOnSlotList;
        ArrayList<Item> tempCart = customItem.getIngredients();

        int count = -1;
        while (tempCart.size() > 0) { //checks if cart is empty or not
            count++;
            for (int i = 0; i < tempList.length; i++) {
                //TODO: CHECK IF CONDITION WORKS
                if (tempCart.get(count) == tempList[i].getItem() 
                        && isItemAvail(tempList[i].getItem().getName(), maxItems, tempList) == false) {
                    return false;
                    
                } else if (tempCart.get(count) == tempList[i].getItem()) { 
                    tempList[i].removeOneStock(tempList[i].getItemList(), maxItems);
                    tempCart.remove(count); 
                    count = -1;
                }
            }
            if (tempCart.size() > 0) {
                count++;
                for (int i = 0; i < tempAddOn.length; i++) {
                    if (tempCart.get(count) == tempList[i].getItem()
                            && isItemAvail(tempAddOn[i].getItem().getName(), maxItems, tempAddOn) == false) {
                        return false;

                    } else if (tempCart.get(count) == tempAddOn[i].getItem()) { 
                        tempList[i].removeOneStock(tempAddOn[i].getItemList(), maxItems);
                        tempCart.remove(count);
                        count = -1;
                    }
                }
            }
            
        }
        return true;
    }

    /**
     * 
     */
    public void removeFromSVM(){
        for (int i = 0; i < customItem.ingredients.size(); i++) {
            Item temp = customItem.ingredients.get(i);

            for (int j = 0; j < slotList.length; j++) {
                if (temp == slotList[j].getItem()) {
                    slotList[j].removeOneStock(slotList[j].getItemList(), maxItems);
                } else if (temp == addOnSlotList[j].getItem()) {
                    addOnSlotList[j].removeOneStock(addOnSlotList[j].getItemList(), numAddOn);
                }
            }
        }
    }

    /**
     * A function that adds stock to the vending machine
     * @param name String of the item to be searched
     * @param sc Scanner function that takes in input
     */
    @Override
    public void addStock(String name, Scanner sc){
        int index = -1, addStock = -1, isAddOn = 0;

        for (int i = 0; i < slotList.length; i++) {
            if (name.equals(slotList[i].getItem().getName()) == true) index = i;
        }

        for (int i = 0; i < addOnSlotList.length; i++) {
            if (name.equals(addOnSlotList[i].getItem().getName()) == true) {
                index = i;
                isAddOn = 1;
            }
        }

        if(index == -1) System.out.println("Item not found!");
        else{
            switch(isAddOn) {
                case 0:
                    do {
                        System.out.println("How many [" + name + "] would you like to add?");
                        addStock = sc.nextInt();
                    } while (addStock < 0);
                    
                    if (addStock == 0) System.out.println("Stocking cancelled.");
                    else if (slotList[index].getQuantity(maxItems) + addStock > 20) System.out.println("Number of items cannot exceed 20!");
                    else {
                        slotList[index].addStock(addStock, maxItems);
                        System.out.println("[" + addStock + "] stocks of [" + name + "] have been successfully added.");
                        transactionList.clear();
                        setStartInventory(getSlotList()); 
                    }
                    break;
                case 1:
                    do {
                        System.out.println("How many [" + name + "] would you like to add?");
                        addStock = sc.nextInt();
                    } while (addStock < 0);
                    
                    if (addStock == 0) System.out.println("Stocking cancelled.");
                    else if (addOnSlotList[index].getQuantity(maxItems) + addStock > 20) System.out.println("Number of items cannot exceed 20!");
                    else {
                        addOnSlotList[index].addStock(addStock, maxItems);
                        System.out.println("[" + addStock + "] stocks of [" + name + "] have been successfully added.");
                        transactionList.clear();
                        setStartInventory(getSlotList()); 
                    }
                    break;
            }
            
        }
    }

    /**
     * Sets a new price for an item in the vending machine
     * @param name String of the item to be searched
     * @param sc Scanner function that takes in input
     */
    @Override
    public void setPrice (String name, Scanner sc){
        int index = -1, isAddOn = 0, newPrice;
        for(int i = 0; i < slotList.length; i++){
            if(name.equals(slotList[i].getItem().getName()) == true){
                index = i;
            }
        }

        for(int i = 0; i < addOnSlotList.length; i++){
            if(name.equals(addOnSlotList[i].getItem().getName()) == true){
                index = i;
                isAddOn = 1;
            }
        }

        if (index == -1){
            System.out.println("Item not found!");
        } else {
            switch(isAddOn) {
                case 0: 
                    do {
                        System.out.println("Set " + slotList[index].getItem().getName() + "'s new price to: ");
                        newPrice = sc.nextInt();
                        slotList[index].getItem().setPrice(newPrice);
                    } while (newPrice <= 0);
                    
                    System.out.println(slotList[index].getItem().getName() + "'s new price has been set to: " + slotList[index].getItem().getPrice());
                    break;
                case 1:
                    do{
                        System.out.println("Set " + addOnSlotList[index].getItem().getName() + "'s new price to: ");
                        newPrice = sc.nextInt();
                        addOnSlotList[index].getItem().setPrice(newPrice);
                    } while (newPrice <= 0);
                        
                    System.out.println(addOnSlotList[index].getItem().getName() + "'s new price has been set to: " + addOnSlotList[index].getItem().getPrice());
                    break;
            }
        }  
    }

    @Override
    public VM createVM(Scanner sc, ArrayList<VM> vmList){
        System.out.println("Enter Vending Machine name: "); //asks for vending machine name 
        String slotNameSVM = sc.nextLine();
        slotNameSVM = sc.nextLine();
        int isValidSVM = 0;
        SVM SVM = new SVM(null, 0, 0, 0, null);
        while (isValidSVM == 0) {
            System.out.println("Enter number of slots for individual items: "); //asks for number of slots 
            int slotNum = sc.nextInt();
            

            //TODO: REVERT BACK
            if (slotNum < 1 || slotNum > 20) {
                System.out.println("Invalid number of slots!");
            }
            System.out.println("Enter number of slots for add-ons: ");
            numAddOn = sc.nextInt();
            if(numAddOn < 0)
                System.out.println("Invalid number of add-ons");
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
               
                System.out.println("Enter the customizable item (eg. sandwich/ramen/mongolian rice): ");
                String specialItem = sc.nextLine();
                specialItem = sc.nextLine();

                SVM = new SVM(slotNameSVM, slotNum, maxItems, numAddOn, specialItem);
                vmList.add(SVM);
                for(int i = 0; i < slotNum; i++){
                    int flag = 0, tempPrice = 0, tempQty = 0, tempCalories = 0;
                    String tempName;
                    System.out.println("Enter item name for Slot [" + (i+1) + "]: ");
                    if(i > 0) tempName = sc.nextLine();  
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
                    SVM.getAddOnSlotList()[i] = temp;
                }   
                //isValid = 1;
                System.out.println("Vending machine successfully created.");
                SVM.setStartInventory(SVM.getSlotList()); //saves starting inventory of the vending machine
                return SVM;
                
                
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
    }

    public void displayAddOns(){
        System.out.println("\nAvailable add-ons: ");
        System.out.println("Item Name\tPrice\tCalories\tQty");
        for(int i = 0; i < addOnSlotList.length; i++){
            System.out.println("["+ (i+1) + "] " + addOnSlotList[i].getItem().getName() + "\t" + addOnSlotList[i].getItem().getPrice() + 
            "\t" + addOnSlotList[i].getItem().getCalories() + "\t\t" + addOnSlotList[i].getQuantity(maxItems));
        }
        System.out.println("\n");
    }

    public String[] preparationString(Scanner sc){
        String[] preparations = new String[customItem.ingredients.size()];

        //TODO: INPUTBUFFER THINGY
        for (int i = 0; i < customItem.ingredients.size(); i++) {
            System.out.print("Enter preparation for [" + customItem.ingredients.get(i).getName() + "]: ");
            String tempPrep = sc.nextLine();
            tempPrep = sc.nextLine();
            preparations[i] = tempPrep;
        }
        return preparations;
    }

    @Override
    public void testVM(Scanner sc){
        int beep = 0, exists = 0;
        while (beep == 0) {
            System.out.println("[1] Make a custom item\n[2] Buy an individual item\n[3] Cancel");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    String ingredientName = "temp";       
                    int tempNum = -1;
                    displayProducts(slotList, maxItems);
                    while (!ingredientName.equals("done")) { 
                        tempNum++;
                        exists = 0;
                        System.out.println("Enter name of ingredient to add (Type \"done\" if finished): ");
                        //TODO: IMPLEMENT RILEY BRUTE FORCE SOLUTION
                        ingredientName = sc.nextLine();
                        ingredientName = sc.nextLine();
                        for(int i = 0;  i < getSlotList().length; i++){
                            if(ingredientName.equals(getSlotList()[i].getItem().getName())){ //checks if item exists 
                                exists = 1;
                                if(isItemAvail(ingredientName, maxItems, slotList) == true) { //checks if item is available
                                    customItem.addIngredient(getSlotList()[i].getItem());
                                    System.out.println("[" + getSlotList()[i].getItem().getName() + "] has been added.");
                                } else if (ingredientName.equals("done")) exists = 1; //TODO: PROGRAM DOESNT RECOGNIZE
                                else System.out.println("Item is not available!");
                            }
                        if (exists == 0) System.out.println("Item doesn't exist!");   
                        } 
                    }  

                    String addOnName = "temp";
                    tempNum = -1;
                    displayAddOns();
                    while (!addOnName.equals("done")) {
                        tempNum++;
                        exists = 0;
                        System.out.println("Enter name of add-on to add (Type \"done\" if finished): ");
                        //TODO: IMPLEMENT RILEY BRUTE FORCE SOLUTION
                        addOnName = sc.nextLine();
                        if (tempNum == 0) addOnName = sc.nextLine();
                        for(int i = 0;  i < getAddOnSlotList().length; i++) {
                            if(addOnName.equals(getAddOnSlotList()[i].getItem().getName())) { //checks if item exists 
                                exists = 1;
                                if(isItemAvail(addOnName, maxItems, addOnSlotList) == true) { //checks if item is available
                                    customItem.addIngredient(getAddOnSlotList()[i].getItem());
                                    System.out.println("[" + getAddOnSlotList()[i].getItem().getName() + "] has been added.");
                                    
                                } else if (addOnName.equals("done")) exists = 1;
                                else  System.out.println("Add-on is not available!");
                            }
                        if (exists == 0) System.out.println("Add-on doesn't exist!");  
                        }     
                    }

                    System.out.println("\nYour total is: " + customItem.getPrice());
                    System.out.println("\nSummary of [" + customItem.getName() + "]: ");
                    for (int i = 0; i < customItem.ingredients.size(); i++) {
                        System.out.println("[+] " + customItem.ingredients.get(i).getName());
                    }

                    //TODO: Find bug that causes the value of customItem.ingredients.size() to reset
                    addMoney(getUserInput(), sc);
                    if (validChangeCustom() == true) {
                        if (validIngredients() == true) {

                            
                            String[] preps = preparationString(sc);

                            for (int i = 0; i < preps.length; i++) {
                                System.out.println("The [" + customItem.ingredients.get(i).getName() + 
                                "] is being [" + preps[i] + "].");
                            }
                            
                            removeFromSVM();
                            customItem.resetCustomItem();
                            System.out.println("You have received [" + customItem.getName() +"]");
                            dispenseCustomChange();
                            beep = 1;
                            
                        }
                        else {
                            System.out.println("The vending machine does not have enough ingredients!");
                            System.out.println("Returning money...");
                            emptyMoney(getUserInput());
                            customItem.ingredients.clear();
                        }
                    } else if (userInput.getTotalMoney() < customItem.getPrice()){
                        System.out.println("Not enough inserted!");
                        System.out.println("Returning money...");
                        emptyMoney(getUserInput());
                        customItem.ingredients.clear();
                    }
                    break;
                case 2: //TODO: JUST COPY INDIV VM PROCESS
                    break;
                case 3: beep = 1;
                    break;
                default:
            }
        }
    }

    public boolean validChangeCustom(){
        int tempChange = customItem.getPrice();
        if (tempChange > userInput.getTotalMoney()) {
            System.out.println("Not enough money to purchase.");
            System.out.println("Returning money...");
            emptyMoney(userInput);
            return false;

        } else if (tempChange == userInput.getTotalMoney()) return true;
        else if ((userInput.getTotalMoney() - tempChange)  > moneyBox.getTotalMoney()) {
            System.out.println("Not enough change!");
            System.out.println("Returning money...");
            emptyMoney(userInput);
            return false;
        } 

        for (int i = 1; i <= 6; i++){
                int numDenomGet = switch(i) {
                    case 1 -> moneyBox.getBill100();
                    case 2 -> moneyBox.getBill50();
                    case 3 -> moneyBox.getBill20();
                    case 4 -> moneyBox.getCoin10();
                    case 5 -> moneyBox.getCoin5();
                    case 6 -> moneyBox.getCoin1();
                    default -> 0;
                };

                int numValue = switch (i) { 
                    case 1 -> 100;
                    case 2 -> 50;
                    case 3 -> 20;
                    case 4 -> 10;
                    case 5 -> 5;
                    case 6 -> 1;
                    default -> 0;
                };

                if (tempChange >= numValue){ 
                    while(numDenomGet>0){
                        tempChange -= numValue; 
                        numDenomGet--; 
                    }
                }
        }
        if(tempChange != 0) {
            System.out.println("Not enough change!");
            System.out.println("Returning money...");
            emptyMoney(userInput);
            return false;
        }
        else 
            return tempChange == 0;
    }
    
    @Override
    public void displayInterface(){
        System.out.println("\nDisplaying Inventory:");
        displayProducts(getStartInventory(), maxItems);
        displayAddOns(); 
    }
    
    public Money dispenseCustomChange(){
        Money change = new Money();
        int i = 0;
        int tempChange = userInput.getTotalMoney() - customItem.getPrice();
        
        if(tempChange == 0) { //Checks if there is a need for change 
            moneyBox.setBill100(moneyBox.getBill100()+ userInput.getBill100()); 
            moneyBox.setBill50(moneyBox.getBill50()+ userInput.getBill50()); 
            moneyBox.setBill20(moneyBox.getBill20()+ userInput.getBill20()); 
            moneyBox.setCoin10(moneyBox.getCoin10()+ userInput.getCoin10()); 
            moneyBox.setCoin5(moneyBox.getCoin5()+ userInput.getCoin5()); 
            moneyBox.setCoin1(moneyBox.getCoin1()+ userInput.getCoin1()); 
        }

        while(tempChange > 0){
            for (i = 1; i <= 10; i++){
                int numDenomGet = switch(i) {//assigns the number of bills in the machine to this variable
                    case 1 -> moneyBox.getBill100();
                    case 2 -> moneyBox.getBill50();
                    case 3 -> moneyBox.getBill20();
                    case 4 -> moneyBox.getCoin10();
                    case 5 -> moneyBox.getCoin5();
                    case 6 -> moneyBox.getCoin1();
                    default -> 0;
                };

                int numValue = switch (i) { //assigns the value of a bill/coin to this variable
                    case 1 -> 100;
                    case 2 -> 50;
                    case 3 -> 20;
                    case 4 -> 10;
                    case 5 -> 5;
                    case 6 -> 1;
                    default -> 0;
                };

                int count = 0; //counter for number of bills a certain denomination has to be returned to the user as change
                if(tempChange >= numValue){ //checks if change is greater than the value of the current bill/coin
                    while(numDenomGet>0){  //while there are still available denominations of a certain bill/coin in the machine
                        tempChange -= numValue; //subtracts the current value from the change
                        numDenomGet--;  //decrements the number of bills in the machine
                        count++; //increases the count by 1
                    }
                }

                switch(i) { //adds the user's money input to the current moneyBox of the machine
                    case 1: moneyBox.setBill100(numDenomGet + userInput.getBill100()); break;
                    case 2: moneyBox.setBill50(numDenomGet + userInput.getBill50()); break;
                    case 3: moneyBox.setBill20(numDenomGet + userInput.getBill20()); break;
                    case 4: moneyBox.setCoin10(numDenomGet + userInput.getCoin10()); break;
                    case 5: moneyBox.setCoin5(numDenomGet + userInput.getCoin5()); break;
                    case 6: moneyBox.setCoin1(numDenomGet + userInput.getCoin1()); break;      
                };
                switch(i) { //sets the number of denominations to be given to the user as change
                    case 1: change.setBill100(count); break;
                    case 2: change.setBill50(count); break;
                    case 3: change.setBill20(count); break;
                    case 4: change.setCoin10(count); break;
                    case 5: change.setCoin5(count); break;
                    case 6: change.setCoin1(count); break;      
                };

                switch(i) { //Sets the user input's money denominations back to 0
                    case 1: userInput.setBill100(0); break;
                    case 2: userInput.setBill50(0); break;
                    case 3: userInput.setBill20(0); break;
                    case 4: userInput.setCoin10(0); break;
                    case 5: userInput.setCoin5(0); break;
                    case 6: userInput.setCoin1(0); break;      
                };
            }   
        }
        System.out.println("You have received " + change.getTotalMoney() + " in change.");
        return change;    
    }
}
