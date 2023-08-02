/**
 * A vmfModelSVM object that extends vmfModelVM
 * @author Ian Gabriel S. De Jesus & Sean Riley P. Veracruz
 * @version %I% %G%
 * @since 1.0
 */
import java.util.ArrayList;
import java.util.Scanner;

public class vmfModelSVM extends vmfModelVM {
    ItemSlot[] addOnSlotList;
    String[] prepItemList;
    String[] prepAddOnList;
    int numAddOn;
    int numAddOnCreated;
    SpecialItem customItem;
    
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

    /**
     * gets number of addons created
     * @return numAddOnCreated
     */
    public int getNumAddOnCreated(){
        return this.numAddOnCreated;
    }

    /**
     * adds one to numberofaddons created
     */
    public void incrementNumAddOnCreated(){
        this.numAddOnCreated+=1;
    }

    /**
     * gets the addonSLotList
     * @return addOnSlotList
     */
    public ItemSlot[] getAddOnSlotList(){
        return addOnSlotList;
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

    /**
     * gets the String preparation for each item
     * @return string array
     */
    public String[] getPrepItemList(){
        return this.prepItemList;
    }

    /**
     * gets the String preparation for each addOn
     * @return string array
     */
    public String[] getPrepAddOnSlotList(){
        return this.prepAddOnList;
    }
}
