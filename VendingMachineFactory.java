import java.util.Scanner;
import java.util.ArrayList; //imports utilities

public class VendingMachineFactory {
    public static void main(String args[]) {
        //TODO NOTE: TEMPORARY VALUES FOR FASTER TESTING
        Item bread = new Item("Bread", 100, 50);
        Item bacon = new Item("Bacon", 80, 20);
        Item chicken = new Item("Chicken", 90, 40);
        Item sausage = new Item("Sausage", 40, 30);
        Item chips = new Item("Chips", 150, 25);
        Item sprite = new Item("Sprite", 140, 40);
        Item water = new Item("Water", 20, 20);
        Item hotdog = new Item("Hotdog", 105, 35);

        int testMax = 20;
        Item[] breadList = new Item[testMax];
        for (int i = 0; i < 15; i++) breadList[i] = bread;
        ItemSlot breadSlot = new ItemSlot(breadList, bread);

        Item[] baconList = new Item[testMax];
        for (int i = 0; i < 13; i++) baconList[i] = bacon;
        ItemSlot baconSlot = new ItemSlot(baconList, bacon);

        Item[] chickenList = new Item[testMax];
        for (int i = 0; i < 11; i++) chickenList[i] = chicken;
        ItemSlot chickenSlot = new ItemSlot(chickenList, chicken);
        
        Item[] sausageList = new Item[testMax];
        for (int i = 0; i < 18; i++) sausageList[i] = sausage;
        ItemSlot sausageSlot = new ItemSlot(sausageList, sausage);
        
        Item[] chipsList = new Item[testMax];
        for (int i = 0; i < 14; i++) chipsList[i] = chips;
        ItemSlot chipsSlot = new ItemSlot(chipsList, chips);
        
        Item[] spriteList = new Item[testMax];
        for (int i = 0; i < 17; i++) spriteList[i] = sprite;
        ItemSlot spriteSlot = new ItemSlot(spriteList, sprite);
        
        Item[] waterList = new Item[testMax];
        for (int i = 0; i < 12; i++) waterList[i] = water;
        ItemSlot waterSlot = new ItemSlot(waterList, water);
        
        Item[] hotdogList = new Item[testMax];
        for (int i = 0; i < 10; i++) hotdogList[i] = hotdog;
        ItemSlot hotdogSlot = new ItemSlot(hotdogList, hotdog);

        ItemSlot slots[] = {breadSlot, baconSlot, chickenSlot, sausageSlot, chipsSlot, spriteSlot, waterSlot, hotdogSlot};
        Money moneyBox = new Money(10, 10, 10, 10, 10, 10);
        ArrayList<Transactions> transactionList = new ArrayList<Transactions>();

        VM bakery = new VM("Egg Drop-R", slots, slots, moneyBox, testMax);
        //VM eggDrop = new VM("Egg Drop-S", slots, slots, moneyBox, testMax);

        int choice = 0;

        Scanner sc = new Scanner(System.in);
        ArrayList<VM> vmList = new ArrayList<VM>(); //declares instances of the scanner and arrayList of vending machines
        vmList.add(bakery);
        //vmList.add(eggDrop);

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
                            VM VM = new VM();
                            VM.createVM(sc, vmList);
                            break;
                        case 2: // TODO: Create a special vending machine function (MCO2)
                            SVM SVM = new SVM();
                            SVM.createVM(sc, vmList);
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
                            
                            VM.displayInterface();
                            
                            
                            while (vmTest != 3) {
                                System.out.println("[1] Test Vending Features\n[2] Perform Maintenance\n[3] Exit");
                                vmTest = sc.nextInt();   
                                switch(vmTest) {
                                    case 1: //start of test vending features component
                                        VM.testVM(sc);
                                        break;
                                    case 2: //start of maintenance features
                                        VM.maintenanceVM(sc);    
                                        break;
                                    default: System.out.println("Invalid option!");                            
                                }   
                            }
                        } 
                    }
                    break; 
                case 3: choice = 3; break; //exits program   
                default: choice = 0;
            }
        }
            sc.close(); //closes scanner
    }
}