import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;




public class vmfView {
    
    private JFrame mainFrame;

    private JButton createBtn, testBtn, exitBtn, regularBtn, specialBtn;
    private JButton nextBtn, addBtn, viewBtn;
    private JButton coinBtn, billBtn;
    private JButton updateBtn, collectBtn, buyBtn;


    private JLabel nameLbl, slotNumLbl1,slotNumLbl2, maxItemLbl;
    private JLabel itemNameLbl, itemPriceLbl, itemCaloriesLbl, itemQuantityLbl;
    private JLabel itemStatusLbl;
    private JLabel sectionLbl;

    private JTextField vmNameTxt, slotNumTxt, maxItemTxt;
    private JTextField itemNameTxt, itemPriceTxt, itemCaloriesTxt, itemQuantityTxt;

    private JTextArea vendingListTextArea, slotTextArea, totalPriceTextArea, inventoryTextArea;

    
    JTextArea slotName1, slotName2, slotName3, slotName4, slotName5, slotName6, slotName7, slotName8, slotName9, slotName10, totalPrice;
    JLabel slotQty1, slotQty2, slotQty3, slotQty4, slotQty5, slotQty6, slotQty7, slotQty8, slotQty9, slotQty10;
    JLabel slotPrice1, slotPrice2, slotPrice3, slotPrice4, slotPrice5, slotPrice6, slotPrice7, slotPrice8, slotPrice9, slotPrice10;
    JButton coin1, coin5, coin10, bill20, bill50, bill100;


    public vmfView(){
        //firstMenu();
        //choiceMenu();
        //rvmMenu();
        //addItems();
        //vmListMenu();
        testVMMenu();
    }

    public void firstMenu(){
        this.createBtn = new JButton("Create Vending Machine");
        this.testBtn = new JButton("Test Vending Machine");
        this.exitBtn = new JButton("Exit");
        mainFrame = new JFrame("Vending Machine Factory");
        mainFrame.setSize(700, 900);
        mainFrame.setResizable(false);
        mainFrame.setLayout(null);
        this.createBtn.setBounds(120, 176, 460, 157);
        this.testBtn.setBounds(120, 371, 460, 157);
        this.exitBtn.setBounds(120, 566, 460, 157);

        mainFrame.add(createBtn);
        mainFrame.add(testBtn);
        mainFrame.add(exitBtn);
        mainFrame.setVisible(true);
    }

    public void setCreateBtn_Listener(ActionListener actionListener){
        this.createBtn.addActionListener(actionListener);
    }

    public void setTestBtn_Listener(ActionListener actionListener){
        this.testBtn.addActionListener(actionListener);
    }

    public void setExitBtn_Listener(ActionListener actionListener){
        this.exitBtn.addActionListener(actionListener);
    }

    public void choiceMenu(){
        JButton regularBtn = new JButton("Regular Vending Machine");
        JButton specialBtn = new JButton("Special Vending Machine");
        mainFrame = new JFrame("Vending Machine Factory");
        mainFrame.setSize(700, 900);
        mainFrame.setResizable(false);
        mainFrame.setLayout(null);
        regularBtn.setBounds(120, 274, 460, 157);
        specialBtn.setBounds(120, 469, 460, 157);
        mainFrame.add(regularBtn);
        mainFrame.add(specialBtn);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setRegularBtn_Listener(ActionListener actionListener){
        this.regularBtn.addActionListener(actionListener);
    }

    public void setSpecialBtn_Listener(ActionListener actionListener){
        this.specialBtn.addActionListener(actionListener);
    }

    public void rvmMenu(){

        mainFrame = new JFrame("intialize RVM");
        nameLbl = new JLabel("VM name: ");
        slotNumLbl1 = new JLabel("# of item slots: ");
        maxItemLbl = new JLabel("Max # per slot: ");

        vmNameTxt = new JTextField();
        slotNumTxt = new JTextField();
        maxItemTxt = new JTextField();

        nextBtn = new JButton("next ->");

        mainFrame.setSize(700, 900);
        nameLbl.setBounds(30, 131, 253, 42);
        slotNumLbl1.setBounds(30, 302, 253, 42);
        maxItemLbl.setBounds(30, 474, 253, 42);

        vmNameTxt.setBounds(296, 113, 308, 76);
        slotNumTxt.setBounds(296, 285, 308, 76);
        maxItemTxt.setBounds(296, 456, 308, 76);

        nextBtn.setBounds(184, 645, 308, 165);

        mainFrame.add(nameLbl);
        mainFrame.add(slotNumLbl1);
        mainFrame.add(maxItemLbl);
        mainFrame.add(vmNameTxt);
        mainFrame.add(slotNumTxt);
        mainFrame.add(maxItemTxt);
        mainFrame.add(nextBtn);

        mainFrame.setResizable(false);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
    }


// TODO svm menu not yet updated
    public void svmMenu(){

        mainFrame = new JFrame("intialize SVM");
        nameLbl = new JLabel("VM name: ");
        slotNumLbl1 = new JLabel("# of item slots: ");
        slotNumLbl2 = new JLabel("# of add-on slots: ");
        maxItemLbl = new JLabel("Max # per slot: ");

        vmNameTxt = new JTextField();
        slotNumTxt = new JTextField();
        maxItemTxt = new JTextField();

        nextBtn = new JButton("next ->");

        mainFrame.setSize(700, 900);
        nameLbl.setBounds(40, 60, 200, 35);
        slotNumLbl1.setBounds(40, 120, 200, 35);
        slotNumLbl2.setBounds(40, 120, 200, 35);
        maxItemLbl.setBounds(40, 180, 200, 35);
        vmNameTxt.setBounds(150, 60, 100, 30);
        slotNumTxt.setBounds(150, 120, 100, 30);
        maxItemTxt.setBounds(150, 180, 100, 30);
        nextBtn.setBounds(100, 240, 100, 30);

        mainFrame.add(nameLbl);
        mainFrame.add(slotNumLbl1);
        mainFrame.add(slotNumLbl2);
        mainFrame.add(maxItemLbl);
        mainFrame.add(vmNameTxt);
        mainFrame.add(slotNumTxt);
        mainFrame.add(maxItemTxt);
        mainFrame.add(nextBtn);

        mainFrame.setResizable(false);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
    }
    public JFrame getMainFrame(){
        return mainFrame;
    }

    public void addItemsMenu(){
        mainFrame = new JFrame("Add Items");

        itemNameLbl = new JLabel("Enter item name: ");
        itemPriceLbl = new JLabel("Enter item price: ");
        itemCaloriesLbl = new JLabel("Enter item calories: ");
        itemQuantityLbl = new JLabel("Enter item quantity: ");

        itemStatusLbl = new JLabel("item added to slot[i]");


        itemNameTxt = new JTextField();
        itemPriceTxt = new JTextField();
        itemCaloriesTxt = new JTextField();
        itemQuantityTxt = new JTextField(); 

        addBtn = new JButton("Add");
        nextBtn = new JButton("Next");

        mainFrame.setSize(700, 900);

        itemNameLbl.setBounds(82, 101, 268, 30);
        itemPriceLbl.setBounds(82, 169, 268, 30);
        itemCaloriesLbl.setBounds(82, 229, 268, 30);
        itemQuantityLbl.setBounds(82, 292, 268, 30);
        itemStatusLbl.setBounds(280, 368, 268, 30);

        itemNameTxt.setBounds(341, 77, 304, 54);
        itemPriceTxt.setBounds(341, 145, 304, 54);
        itemCaloriesTxt.setBounds(341, 209, 304, 54);
        itemQuantityTxt.setBounds(341, 271, 304, 54);

        addBtn.setBounds(189, 427, 304, 117);
        nextBtn.setBounds(189, 686, 304, 118);

        mainFrame.add(itemNameLbl);
        mainFrame.add(itemPriceLbl);
        mainFrame.add(itemCaloriesLbl);
        mainFrame.add(itemQuantityLbl);
        mainFrame.add(itemNameTxt);
        mainFrame.add(itemPriceTxt);
        mainFrame.add(itemCaloriesTxt);
        mainFrame.add(itemQuantityTxt);
        mainFrame.add(addBtn);

        //shows up when item is added successfully 
        mainFrame.add(itemStatusLbl);

        //only shows up when items added = slot.length/size
        mainFrame.add(nextBtn);


        mainFrame.setResizable(false);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
    }

    public void vmListMenu(){
        mainFrame = new JFrame("Vending Machine List");

        nameLbl = new JLabel("Enter VM name: ");
        sectionLbl = new JLabel("Vending Machines");
        vmNameTxt = new JTextField();
        vendingListTextArea = new JTextArea(" fklsdnfkldsanfklasnkl ");
        

        mainFrame.setSize(700, 900);
        nameLbl.setBounds(75, 66, 202, 34);
        sectionLbl.setBounds(277, 120, 242, 34);
        vmNameTxt.setBounds(293, 44, 331, 62);
        vendingListTextArea.setBounds(75, 148, 549, 650);

        mainFrame.add(nameLbl);
        mainFrame.add(sectionLbl);
        mainFrame.add(vmNameTxt);
        mainFrame.add(vendingListTextArea);

        mainFrame.setResizable(false);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
    }

    public void testVMMenu(){
        mainFrame = new JFrame("Test Regular Vending Machine");

        //vendingMachineTextArea = new JTextArea("RVM Name");
        nameLbl = new JLabel("Egg Drop");
        itemNameLbl = new JLabel("Enter item name: ");
        itemNameTxt = new JTextField();
        totalPriceTextArea = new JTextArea("Total: ");
        sectionLbl = new JLabel("Add Money");
        buyBtn = new JButton("Buy");

        slotName1 = new JTextArea("bread"); //insert item names here
        slotName2 = new JTextArea("bread");
        slotName3 = new JTextArea("bread");
        slotName4 = new JTextArea("bread");
        slotName5 = new JTextArea("bread");
        slotName6 = new JTextArea("bread");
        slotName7 = new JTextArea("bread");
        slotName8 = new JTextArea("bread");
        slotName9 = new JTextArea("bread");
        slotName10 = new JTextArea("bread");
        
        slotPrice1 = new JLabel("price: 1"); //insert prices 
        slotPrice2 = new JLabel("price: 1");
        slotPrice3 = new JLabel("price: 1");
        slotPrice4 = new JLabel("price: 1");
        slotPrice5 = new JLabel("price: 1");
        slotPrice6 = new JLabel("price: 1");
        slotPrice7 = new JLabel("price: 1");
        slotPrice8 = new JLabel("price: 1");
        slotPrice9 = new JLabel("price: 1");
        slotPrice10 = new JLabel("price: 1");

        slotQty1 = new JLabel("Qty: 4"); //insert quantities
        slotQty2 = new JLabel("Qty: 4");
        slotQty3 = new JLabel("Qty: 4");
        slotQty4 = new JLabel("Qty: 4");
        slotQty5 = new JLabel("Qty: 4");
        slotQty6 = new JLabel("Qty: 4");
        slotQty7 = new JLabel("Qty: 4");
        slotQty8 = new JLabel("Qty: 4");
        slotQty9 = new JLabel("Qty: 4");
        slotQty10 = new JLabel("Qty: 4");

        coin1 = new JButton("1");
        coin5 = new JButton("5");
        coin10 = new JButton("10");
        bill20 = new JButton("20");
        bill50 = new JButton("50");
        bill100 = new JButton("100");

        mainFrame.setSize(700, 900);

        nameLbl.setBounds(33, 41, 226, 79);
        itemNameLbl.setBounds(480, 277, 180, 28);
        itemNameTxt.setBounds(486, 311, 183, 67);
        totalPriceTextArea.setBounds(486, 524, 183, 67);
        sectionLbl.setBounds(335, 684, 140, 24);

        slotName1.setBounds(33, 156, 152, 64);
        slotName2.setBounds(202, 156, 152, 64);
        slotName3.setBounds(33, 256, 152, 64);
        slotName4.setBounds(202, 256, 152, 64);
        slotName5.setBounds(33, 356, 152, 64);
        slotName6.setBounds(202, 356, 152, 64);
        slotName7.setBounds(33, 469, 152, 64);
        slotName8.setBounds(202, 469, 152, 64);
        slotName9.setBounds(33, 573, 152, 64);
        slotName10.setBounds(202, 573, 152, 64);

        slotPrice1.setBounds(30, 220, 81, 28);
        slotPrice2.setBounds(202, 220, 81, 28);
        slotPrice3.setBounds(30, 320, 81, 28);
        slotPrice4.setBounds(202, 320, 81, 28);
        slotPrice5.setBounds(30, 420, 81, 28);
        slotPrice6.setBounds(202, 420, 81, 28);
        slotPrice7.setBounds(30, 533, 81, 28);
        slotPrice8.setBounds(202, 533, 81, 28);
        slotPrice9.setBounds(30, 637, 81, 28);
        slotPrice10.setBounds(202, 637, 81, 28);

        slotQty1.setBounds(151, 220, 63, 28);
        slotQty2.setBounds(322, 220, 63, 28);
        slotQty3.setBounds(151, 320, 63, 28);
        slotQty4.setBounds(322, 320, 63, 28);
        slotQty5.setBounds(151, 420, 63, 28);
        slotQty6.setBounds(322, 420, 63, 28);
        slotQty7.setBounds(151, 533, 63, 28);
        slotQty8.setBounds(322, 533, 63, 28);
        slotQty9.setBounds(151, 637, 63, 28);
        slotQty10.setBounds(322, 637, 63, 28);

        coin1.setBounds(128, 720, 95, 69);
        coin5.setBounds(322, 720, 95, 69);
        coin10.setBounds(516, 720, 95, 69);
        bill20.setBounds(128, 801, 95, 69);
        bill50.setBounds(322, 801, 95, 69);
        bill100.setBounds(516, 801, 95, 69);

        buyBtn.setBounds(526, 390, 96, 69);

        mainFrame.add(nameLbl);
        mainFrame.add(itemNameLbl);
        mainFrame.add(itemNameTxt);
        mainFrame.add(totalPriceTextArea);
        mainFrame.add(sectionLbl);
        mainFrame.add(buyBtn);

        mainFrame.add(slotName1);
        mainFrame.add(slotName2);
        mainFrame.add(slotName3);
        mainFrame.add(slotName4);
        mainFrame.add(slotName5);
        mainFrame.add(slotName6);
        mainFrame.add(slotName7);
        mainFrame.add(slotName8);
        mainFrame.add(slotName9);
        mainFrame.add(slotName10);

        mainFrame.add(slotPrice1);
        mainFrame.add(slotPrice2);
        mainFrame.add(slotPrice3);
        mainFrame.add(slotPrice4);
        mainFrame.add(slotPrice5);
        mainFrame.add(slotPrice6);
        mainFrame.add(slotPrice7);
        mainFrame.add(slotPrice8);
        mainFrame.add(slotPrice9);
        mainFrame.add(slotPrice10);

        mainFrame.add(slotQty1);
        mainFrame.add(slotQty2);
        mainFrame.add(slotQty3);
        mainFrame.add(slotQty4);
        mainFrame.add(slotQty5);
        mainFrame.add(slotQty6);
        mainFrame.add(slotQty7);
        mainFrame.add(slotQty8);
        mainFrame.add(slotQty9);
        mainFrame.add(slotQty10);

        mainFrame.add(coin1);
        mainFrame.add(coin5);
        mainFrame.add(coin10);
        mainFrame.add(bill20);
        mainFrame.add(bill50);
        mainFrame.add(bill100);

        mainFrame.setResizable(false);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
    }

    public int toInt (String string){
        return Integer.parseInt(string);
    }

    public String getVmNameTxt(){
        return this.vmNameTxt.getText();
    }

    public String getSlotNumTxt(){
        return this.slotNumTxt.getText();
    }

    public String getMaxItemTxt(){
        return this.maxItemTxt.getText();
    }

    public void clearTxtVM(){
        this.vmNameTxt.setText("");
        this.slotNumTxt.setText("");
        this.maxItemTxt.setText("");
    }

    public void setNextBtn_Listener(ActionListener actionListener){
        this.nextBtn.addActionListener(actionListener);
    }

    public String getItemNameTxt() {
        return this.itemNameTxt.getText();
    } 

    public String getItemPriceTxt() {
        return this.itemPriceTxt.getText();
    }

    public String getItemCaloriesTxt() {
        return this.itemCaloriesTxt.getText();
    }

    public String getItemQuantityTxt() {
        return this.itemQuantityTxt.getText();
    }

    public void setAddBtn_Listener(ActionListener actionListener){
        this.addBtn.addActionListener(actionListener);
    }
}
