/**
 * A vmfModelSVM object that extends vmfModelVM
 * @author Ian Gabriel S. De Jesus & Sean Riley P. Veracruz
 * @version %I% %G%
 * @since 1.0
 */
import java.util.ArrayList;
import java.util.Scanner;

public class vmfModelSVM extends vmfModelVM {
    protected ItemSlot[] addOnSlotList;
    protected String[] prepItemList;
    protected String[] prepAddOnList;
    protected int numAddOn;

    protected int numAddOnCreated;
    protected SpecialItem customItem;
    
    /**
     * makes a svm object
     * @param name name of machine
     * @param slotNum number of slot
     * @param maxItems max items
     * @param numAddOn number of addon slots
     * @param specialItem name of special item
     */
    public vmfModelSVM(String name, int slotNum, int maxItems, int numAddOn, String specialItem){
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
        this.numAddOnCreated = 0;
        this.customItem = new SpecialItem(specialItem);
        this.prepItemList = new String[slotNum];
        this.prepAddOnList = new String[numAddOn];
    }

    /**
     * makes an empty svm object
     */
    public vmfModelSVM(){
        super();
        this.addOnSlotList = new ItemSlot[numAddOn];
    }

    public SpecialItem getCustomItem(){
        return this.customItem;
    }

    /**
     * gets number of addons created
     * @return numAddOnCreated
     */
    public int getNumAddOnCreated(){
        return this.numAddOnCreated;
    }
    
    public int getNumAddOn() {
        return this.numAddOn;
    }
    /**
     * adds one to numberofaddons created
     */
    public void incrementNumAddOnCreated(){
        this.numAddOnCreated+=1;
    }


    /**
     * checks if the machine has valid ingredients for the custom item
     * @return true if enough, false if not
     */
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
     * checks if the machine has enough change
     * @return true if yes, false if not
     */
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
    
    /**
     * dispenses change in denominations
     * @return money object that contains number of denominations
     */
    public int dispenseCustomChange(){
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
        return change.getTotalMoney();    
    }

    /**
     * gets the String preparation for each item
     * @return string array
     */
    public String[] getPrepItemList(){
        return this.prepItemList;
    }

    public ItemSlot[] getAddOnSlotList(){
        return this.addOnSlotList;
    }

    /**
     * gets the String preparation for each addOn
     * @return string array
     */
    public String[] getPrepAddOnSlotList(){
        return this.prepAddOnList;
    }

    @Override
    public String printInventoryList() {
        StringBuilder temp = new StringBuilder();

        temp.append("Items: \n");
        for (int i = 0; i < slotList.length; i++){
            temp.append( (i+1) + ". " + slotList[i].getItem().getName() + " - " + 
            slotList[i].getItem().getPrice() + "Php - " + slotList[i].getQuantity(maxItems) + " pcs\n");
        }

        temp.append("\nAdd-ons: \n");
        for (int i = 0; i < addOnSlotList.length; i++) {
            temp.append( (i+1) + ". " + addOnSlotList[i].getItem().getName() + " - " + 
            addOnSlotList[i].getItem().getPrice() + "Php - " + addOnSlotList[i].getQuantity(maxItems) + " pcs\n");
        }

        return temp.toString();
    }

    public String printAddOnList(){
        StringBuilder temp = new StringBuilder();
        
        for (int i = 0; i < addOnSlotList.length; i++) {
            temp.append( (i+1) + ". " + addOnSlotList[i].getItem().getName() + " - " + 
            addOnSlotList[i].getItem().getPrice() + "Php - " + addOnSlotList[i].getQuantity(maxItems) + " pcs\n");
        }

        return temp.toString();
    }

    @Override
    public void createTransaction(String name){
        int price = 0, index = -1;
        for (int z = 0; z < customItem.ingredients.size(); z++){
            String temp = customItem.getIngredients().get(z).getName();
            
            for (int i = 0; i < slotList.length; i++) {
                if (temp.equals(slotList[i].getItem().getName()) == true) {
                    price += slotList[index].getItem().getPrice();
                }
            }

            for (int i = 0; i < addOnSlotList.length; i++) {
                if (temp.equals(addOnSlotList[i].getItem().getName()) == true) {
                    price += addOnSlotList[index].getItem().getPrice();
                }
            }
        }  
        Transactions transaction = new Transactions(name, price);
        transactionList.add(transaction);
    }

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

    public String preparationStrings(){
        StringBuilder preps = new StringBuilder();

        for (int i = 0; i < customItem.ingredients.size(); i++) {
            String tempName = customItem.ingredients.get(i).getName();

            for (int j = 0; j < slotList.length; j++) {
                if(tempName.equals(slotList[j].getItem().getName())) {
                    preps.append(getPrepItemList()[j] + tempName + ". . .\n");
                }
            }

            for (int j = 0; j < addOnSlotList.length; j++) {
                if(tempName.equals(addOnSlotList[j].getItem().getName())) {
                    preps.append(getPrepAddOnSlotList()[j] + tempName + ". . .\n");
                }
            }
        }

        preps.append("\n\nYou have received " + customItem.getName());
        return preps.toString();
    }

    public void returnIngredients(){
        for (int i = 0; i < getCustomItem().getIngredients().size(); i++) {
            Item temp = getCustomItem().getIngredients().get(i);
            for (int j = 0; j < slotList.length; j++) {
                if (temp == getSlotList()[j].getItem()) {
                    getSlotList()[j].addStock(1, maxItems);
                    customItem.getIngredients().remove(0);
                }
            }    
            
            for (int j = 0; j < addOnSlotList.length; j++) {
                if (temp == getAddOnSlotList()[j].getItem()) {
                    getAddOnSlotList()[j].addStock(1, maxItems);
                    customItem.getIngredients().remove(0);
                }
            }
            
        }
    }
}
