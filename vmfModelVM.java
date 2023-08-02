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
            temp[i] = new ItemSlot(slotList[i].getItemList(), slotList[i].getItem());
        }

        // Update the startInventoryList with the temp copy
        this.startInventoryList = temp;
    }

    public void createTransaction(String name){
        int price, index = -1;
        for (int i = 0; i < slotList.length; i++) {
            if (name.equals(slotList[i].getItem().getName()) == true) {
                index = i;
            }
        }
        price = slotList[index].getItem().getPrice();
        Transactions transaction = new Transactions(name, price);
        transactionList.add(transaction);
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
            temp.append( (i+1) + ". " + slotList[i].getItem().getName());
        }

        return temp.toString();
    }

    public String getInventoryList() {
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < slotList.length; i++){
            temp.append( (i+1) + ". " + slotList[i].getItem().getName() + " - " + 
            slotList[i].getItem().getPrice() + "Php - " + slotList[i].getQuantity(maxItems) + " pcs\n");
        }

        return temp.toString();
    }

        /**
     * Function that checks if a certain item is available for purchase
     * @param name String of the item to be searched
     * @return true if item quantity is > 0, false if otherwise
     */
    public boolean isItemAvail(String name, int maxItems, ItemSlot[] list){
        for(int i = 0; i < list.length; i++){
            if(name.equals(list[i].getItem().getName()) == true)
                if(list[i].getQuantity(maxItems) > 0) return true; 
        }
        return false; 
    }

/**
     * Function that dispenses item and updates the inventory of the vending machine
     * @param name String of the item to be searched
     * @param slotList inventory arraylist that gets updated
     */
    public int dispenseItem(String name, ItemSlot[] slotList){
        int index = -1;
        for(int i = 0; i < slotList.length; i++){
            if(name.equals(slotList[i].getItem().getName()) == true)
                index = i;    
            
        }

        slotList[index].removeOneStock(slotList[index].getItemList(), maxItems);
        return index;
    }

    public String printTransactionSummary() {
        int totalMoney = 0;
        StringBuilder temp = new StringBuilder();
        System.out.println("Transaction No.\tItem Name\tNo. of Sales"); 
        for (int i = 0; i < transactionList.size(); i++) {
            temp.append("[" + (i+1) + "]\t\t" + transactionList.get(i).getName() + "\t\t 1\n");
            totalMoney+=transactionList.get(i).getPrice();
        }
        temp.append("\nTotal Money: " + totalMoney);

        return temp.toString();
    }

    public void emptyMoney(Money money){ 
        money.setBill100(0);
        money.setBill50(0);
        money.setBill20(0);
        money.setCoin10(0);
        money.setCoin5(0);
        money.setCoin1(0);
    }

    public String validChange(String name){
        int index = -1;
        for (int i = 0; i<slotList.length; i++) {
            if (name.equals(slotList[i].getItem().getName()) == true) {
                index = i;
            }
        } 
        int tempChange = slotList[index].getItem().getPrice();
        if (tempChange > userInput.getTotalMoney()) {
            return "Not enough money to purchase.";

        } else if (tempChange == userInput.getTotalMoney()) return null;
        else if ((userInput.getTotalMoney() - tempChange)  > moneyBox.getTotalMoney()) return "Not enough change!";

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
            return "Not enough change!";
        }
        else 
            return null;
    }

    /**
     * A function that dispenses change and updates the vending machine's moneyBox
     * @param name String of the item to be searched
     * @return the user's change in denominations
     */
    public int dispenseChange(String name){
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
        
        return change.getTotalMoney();    
    }
}
