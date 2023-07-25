import java.util.ArrayList;
import java.util.Scanner;

/**
 * A vending machine object that is created given a user's input on a name and number of slots.
 * @author Ian Gabriel S. De Jesus 
 * @author Sean Riley P. Veracruz
 * @version %I% %G%
 * @since 1.0
 */

public class VM {
    protected String name; 
    protected ItemSlot[] slotList;
    protected ItemSlot[] startInventoryList;
    protected Money moneyBox;
    protected Money userInput; 
    protected ArrayList<Transactions> transactionList;

    /**
     * Creates a VM object and sets each attribute to default
     * @param slotName Name of the vending machine
     * @param slotNum Number of slots of the vending machine
     */
    public VM(String slotName, int slotNum){
        this.name = slotName;
        this.slotList = new ItemSlot[slotNum];
        this.startInventoryList = new ItemSlot[slotNum];
        this.moneyBox = new Money();
        this.userInput = new Money();
        this.transactionList = new ArrayList<Transactions>();
    }

    public VM(String name, ItemSlot slotList[], ItemSlot startInventoryList[], Money moneyBox){
        this.name = name;
        this.slotList = slotList;
        this.startInventoryList = startInventoryList;
        this.moneyBox = moneyBox;
        this.userInput = new Money();
        this.transactionList = new ArrayList<Transactions>();
    }

    /**
     * Gets the slotList attribute of a vending machine
     * @return slotList -> contains the number of slots and corresponding item
     */
    public ItemSlot[] getSlotList(){
        return slotList;
    }

    /**
     * Gets the name of the vending machine
     * @return name of the vending machine
     */
    public String getName() {
        return name;
    }

    /**
     * A function that returns userInput 
     * @return userInput that contains number of denominations the user has put into the vending machine
     */
    public Money getUserInput(){
        return userInput;
    }

    /**
     * A function that returns moneyBox 
     * @return moneyBox that contains number of denominations the the vending machine has
     */
    public Money getMoneyBox(){
        return moneyBox;
    }

    /**
     * A function that gets the start inventory
     * @return startInventory that returns the starting inventory of the machine's last stock
     */
    public ItemSlot[] getStartInventory(){
        return startInventoryList;
    }

    /**
     * Sets the starting inventory of the machine
     * @param startInventoryList ItemSlot[] array that saves the starting inventory
     */
    public void setStartInventory(ItemSlot[] slotList) {

        // Create a temp copy of the slotList array
        ItemSlot[] temp = new ItemSlot[slotList.length];
        for (int i = 0; i < slotList.length; i++) {
            temp[i] = new ItemSlot(slotList[i].getQuantity(), slotList[i].getItem());
        }

        // Update the startInventoryList with the temp copy
        this.startInventoryList = temp;
    }

    /**
     * A function that displays the products given a parameter in the machine
     * @param product ItemSlot[] array that contains items and quantities
     */
    public void displayProducts(ItemSlot[] product){ 
        System.out.println("\nAvailable products: ");
        System.out.println("Item Name\tPrice\tCalories\tQty");
        for(int i = 0; i < product.length; i++){
            System.out.println("["+ (i+1) + "] " + product[i].getItem().getName() + "\t" + product[i].getItem().getPrice() + 
            "\t" + product[i].getItem().getCalories() + "\t\t" + product[i].getQuantity());
        }
        System.out.println("\n");
    }
    
    /**
     * Adds money to a certain Money variable
     * @param money chosen Money variable that increments a certain denomination
     * @param sc Scanner that scans inputs
     */
    public void addMoney(Money money, Scanner sc){ //will change when gui is implemented
        int choice =  -1;
        System.out.println("\nEnter amount to add:");
        System.out.println("[1] 1 Peso coin/s");
        System.out.println("[2] 5 Peso coin/s");
        System.out.println("[3] 10 Peso coin/s");
        System.out.println("[4] 20 Peso coin/s");
        System.out.println("[5] 20 Peso bill/s");
        System.out.println("[6] 50 Peso bill/s");
        System.out.println("[7] 100 Peso bill/s");
        System.out.println("[8] 200 Peso bill/s");
        System.out.println("[9] 500 Peso bill/s");
        System.out.println("[10] 1000 Peso bill/s");
        System.out.print("[0] Continue: ");
        
        while(choice != 0){
            choice = sc.nextInt();
            switch(choice){
                case 1: 
                    System.out.print("Added 1 Peso coin! : ");
                    money.setCoin1(money.getCoin1() + 1); 
                    break;
                case 2: 
                    System.out.print("Added 5 Peso coin! : ");
                    money.setCoin5(money.getCoin5() + 1);  
                    break;
                case 3:
                    System.out.print("Added 10 Peso coin! : ");
                    money.setCoin10(money.getCoin10() + 1); 
                    break;
                case 4: 
                    System.out.print("Added 20 Peso coin! : ");
                    money.setCoin20(money.getCoin20() + 1); 
                    break;
                case 5:
                    System.out.print("Added 20 Peso bill! : ");
                    money.setBill20(money.getBill20() + 1); 
                    break;
                case 6: 
                    System.out.print("Added 50 Peso bill! : ");
                    money.setBill50(money.getBill50() + 1); 
                    break;
                case 7:
                    System.out.print("Added 100 Peso bill! : ");
                    money.setBill100(money.getBill100() + 1); 
                    break;
                case 8: 
                    System.out.print("Added 200 Peso bill! : ");
                    money.setBill200(money.getBill200() + 1); ; 
                    break;
                case 9:
                    System.out.print("Inserted 500 Peso bill! : ");
                    money.setBill500(money.getBill500() + 1); 
                    break;
                case 10: 
                    System.out.print("Inserted 1000 Peso bill! : ");
                    money.setBill1000(money.getBill1000() + 1); 
                    break;
                case 0: 
                    break;
                default: 
                    System.out.print("Invalid input! : ");
            }
        }
        System.out.println("Total money added: " + money.getTotalMoney());
    }

    /**
     * Function that checks if a certain item is available for purchase
     * @param name String of the item to be searched
     * @return true if item quantity is > 0, false if otherwise
     */
    public boolean isItemAvail(String name){
        for(int i = 0; i < slotList.length; i++){
            if(name.equals(slotList[i].getItem().getName()) == true)
                if(slotList[i].getQuantity()>0)
                    return true;   
        }
        return false; 
    }

    /**
     * Function that dispenses item and updates the inventory of the vending machine
     * @param name String of the item to be searched
     * @param slotList inventory arraylist that gets updated
     */
    public void dispenseItem(String name, ItemSlot[] slotList){
        int index = -1;
        for(int i = 0; i < slotList.length; i++){
            if(name.equals(slotList[i].getItem().getName()) == true)
                index = i;    
            
        }
        System.out.println("You have received [1] [" + slotList[index].getItem().getName() +"]");
        slotList[index].setQuantity(slotList[index].getQuantity() - 1);
    }
   
    /**
     * Creates a transaction if a purchase was successful
     * @param name String of the item to be searched
     */
    public void createTransaction(String name){
        int price, index = -1;
         for (int i = 0; i<slotList.length; i++) {
            if (name.equals(slotList[i].getItem().getName()) == true) {
                index = i;
            }
        }
        price = slotList[index].getItem().getPrice();
        Transactions transaction = new Transactions(name, price);
        transactionList.add(transaction);
    }

    /**
     * A function that checks if there is enough change for the user
     * @param name String of the item to be searched
     * @return true if the machine has enough change, false if otherwise
     */
    public boolean validChange(String name){
        int index = -1;
        for (int i = 0; i<slotList.length; i++) {
            if (name.equals(slotList[i].getItem().getName()) == true) {
                index = i;
            }
        } 
        int tempChange = slotList[index].getItem().getPrice();
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

        for (int i = 1; i <= 10; i++){
                int numDenomGet = switch(i) {
                    case 1 -> moneyBox.getBill1000(); 
                    case 2 -> moneyBox.getBill500(); 
                    case 3 -> moneyBox.getBill200(); 
                    case 4 -> moneyBox.getBill100();
                    case 5 -> moneyBox.getBill50();
                    case 6 -> moneyBox.getBill20();
                    case 7 -> moneyBox.getCoin20();
                    case 8 -> moneyBox.getCoin10();
                    case 9 -> moneyBox.getCoin5();
                    case 10 -> moneyBox.getCoin1();
                    default -> 0;
                };

                int numValue = switch (i) { 
                    case 1 -> 1000;
                    case 2 -> 500;
                    case 3 -> 200;
                    case 4 -> 100;
                    case 5 -> 50;
                    case 6 -> 20;
                    case 7 -> 20;
                    case 8 -> 10;
                    case 9 -> 5;
                    case 10 -> 1;
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


    /**
     * A function that dispenses change and updates the vending machine's moneyBox
     * @param name String of the item to be searched
     * @return the user's change in denominations
     */
    public Money dispenseChange(String name){
        Money change = new Money();
        int index = -1, i = 0;
        boolean found = false;
        int tempChange = userInput.getTotalMoney();
        for (i = 0; i<slotList.length; i++) {
            if (name.equals(slotList[i].getItem().getName()) == true) {
                index = i;
                found = true;
            }
        } 
        if(found == true) tempChange -= (slotList[index].getItem().getPrice()); //Checks if the item has been found
        if(tempChange == 0){ //Checks if there is a need for change
            moneyBox.setBill1000(moneyBox.getBill1000()+ userInput.getBill1000()); 
            moneyBox.setBill500(moneyBox.getBill500()+ userInput.getBill500()); 
            moneyBox.setBill200(moneyBox.getBill200()+ userInput.getBill200()); 
            moneyBox.setBill100(moneyBox.getBill100()+ userInput.getBill100()); 
            moneyBox.setBill50(moneyBox.getBill50()+ userInput.getBill50()); 
            moneyBox.setBill20(moneyBox.getBill20()+ userInput.getBill20()); 
            moneyBox.setCoin20(moneyBox.getCoin20()+ userInput.getCoin20()); 
            moneyBox.setCoin10(moneyBox.getCoin10()+ userInput.getCoin10()); 
            moneyBox.setCoin5(moneyBox.getCoin5()+ userInput.getCoin5()); 
            moneyBox.setCoin1(moneyBox.getCoin1()+ userInput.getCoin1()); 
        }

        while(tempChange > 0){
            for (i = 1; i <= 10; i++){
                int numDenomGet = switch(i) {//assigns the number of bills in the machine to this variable
                    case 1 -> moneyBox.getBill1000(); 
                    case 2 -> moneyBox.getBill500(); 
                    case 3 -> moneyBox.getBill200(); 
                    case 4 -> moneyBox.getBill100();
                    case 5 -> moneyBox.getBill50();
                    case 6 -> moneyBox.getBill20();
                    case 7 -> moneyBox.getCoin20();
                    case 8 -> moneyBox.getCoin10();
                    case 9 -> moneyBox.getCoin5();
                    case 10 -> moneyBox.getCoin1();
                    default -> 0;
                };

                int numValue = switch (i) { //assigns the value of a bill/coin to this variable
                    case 1 -> 1000;
                    case 2 -> 500;
                    case 3 -> 200;
                    case 4 -> 100;
                    case 5 -> 50;
                    case 6 -> 20;
                    case 7 -> 20;
                    case 8 -> 10;
                    case 9 -> 5;
                    case 10 -> 1;
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
                    case 1: moneyBox.setBill1000(numDenomGet + userInput.getBill1000()); break;
                    case 2: moneyBox.setBill500(numDenomGet + userInput.getBill500()); break;
                    case 3: moneyBox.setBill200(numDenomGet + userInput.getBill200()); break;
                    case 4: moneyBox.setBill100(numDenomGet + userInput.getBill100()); break;
                    case 5: moneyBox.setBill50(numDenomGet + userInput.getBill50()); break;
                    case 6: moneyBox.setBill20(numDenomGet + userInput.getBill20()); break;
                    case 7: moneyBox.setCoin20(numDenomGet + userInput.getCoin20()); break;
                    case 8: moneyBox.setCoin10(numDenomGet + userInput.getCoin10()); break;
                    case 9: moneyBox.setCoin5(numDenomGet + userInput.getCoin5()); break;
                    case 10: moneyBox.setCoin1(numDenomGet + userInput.getCoin1()); break;      
                };
                switch(i) { //sets the number of denominations to be given to the user as change
                    case 1: change.setBill1000(count); break;
                    case 2: change.setBill500(count); break;
                    case 3: change.setBill200(count); break;
                    case 4: change.setBill100(count); break;
                    case 5: change.setBill50(count); break;
                    case 6: change.setBill20(count); break;
                    case 7: change.setCoin20(count); break;
                    case 8: change.setCoin10(count); break;
                    case 9: change.setCoin5(count); break;
                    case 10: change.setCoin1(count); break;      
                };

                switch(i) { //Sets the user input's money denominations back to 0
                    case 1: userInput.setBill1000(0); break;
                    case 2: userInput.setBill500(0); break;
                    case 3: userInput.setBill200(0); break;
                    case 4: userInput.setBill100(0); break;
                    case 5: userInput.setBill50(0); break;
                    case 6: userInput.setBill20(0); break;
                    case 7: userInput.setCoin20(0); break;
                    case 8: userInput.setCoin10(0); break;
                    case 9: userInput.setCoin5(0); break;
                    case 10: userInput.setCoin1(0); break;      
                };
            }   
        }
        System.out.println("You have received " + change.getTotalMoney() + " in change.");
        return change;    
    }

    /**
     * A function that adds stock to the vending machine
     * @param name String of the item to be searched
     * @param sc Scanner function that takes in input
     */
    public void addStock(String name, Scanner sc){
        int index = -1, addStock = -1;
        //Scanner sc = new Scanner(System.in);

        for (int i = 0; i < slotList.length; i++) {
            if (name.equals(slotList[i].getItem().getName()) == true) {
                index = i;
            }
        }

        if(index == -1) System.out.println("Item not found!");
        else{
            do {
                System.out.println("How many [" + name + "] would you like to add?");
                addStock = sc.nextInt();
            } while (addStock < 0);
            
            if (addStock == 0) System.out.println("Stocking cancelled.");
            else if (slotList[index].getQuantity() + addStock > 20) System.out.println("Number of items cannot exceed 20!");
            else {
                slotList[index].setQuantity(slotList[index].getQuantity() + addStock);
                System.out.println("[" + addStock + "] stocks of [" + name + "] have been successfully added.");
                transactionList.clear();
                setStartInventory(getSlotList()); 
            }
        }
    }

    /**
     * Sets a new price for an item in the vending machine
     * @param name String of the item to be searched
     * @param sc Scanner function that takes in input
     */
    public void setPrice (String name, Scanner sc){
        //Scanner sc = new Scanner(System.in);
        int index = -1;
        int newPrice;

        for(int i = 0; i < slotList.length; i++){
            if(name.equals(slotList[i].getItem().getName()) == true){
                index = i;
            }
        }

        if (index == -1){
            System.out.println("Item not found!");
        } else {
            do{
                System.out.println("Set " + slotList[index].getItem().getName() + "'s new price to: ");
                newPrice = sc.nextInt();
                slotList[index].getItem().setPrice(newPrice);
            } while (newPrice <= 0);
                
            System.out.println(slotList[index].getItem().getName() + "'s new price has been set to: " + slotList[index].getItem().getPrice());
        }
        
    }

    /**
     * Empties out a certain Money attribute. It sets all the denominations back to 0.
     * @param money attribute that will get zeroed out.
     */
    public void emptyMoney(Money money){ // TODO: possible feature is to place collected money inside a "savings" attribute inside Vending Machine Factory
        money.setBill1000(0);
        money.setBill500(0);
        money.setBill200(0);
        money.setBill100(0);
        money.setBill50(0);
        money.setBill20(0);
        money.setCoin20(0);
        money.setCoin10(0);
        money.setCoin5(0);
        money.setCoin1(0);
    }

    /**
     * Prints out a transaction summary from last restock
     */
    public void printTransactionSummary() {
        int totalMoney = 0;
        System.out.println("Transaction No.\tItem Name\tNo. of Sales"); 
        for (int i = 0; i < transactionList.size(); i++) {
            System.out.println("[" + (i+1) + "]\t\t" + transactionList.get(i).getName() + "\t\t 1");
            totalMoney+=transactionList.get(i).getPrice();
        }
        System.out.println("Total Money: " + totalMoney);
    }
}
