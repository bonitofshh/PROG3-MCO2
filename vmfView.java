import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.Font;
import java.awt.TextField;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;

public class vmfView {
    
    private JFrame firstMenuFrame, choiceMenuFrame, rvmMenuFrame, svmMenuFrame, addItemsFrame, vmListFrame, testVMFrame, maintenanceFrame;

    private JButton createBtn, testBtn, exitBtn, regularBtn, specialBtn;
    private JButton nextBtnVM, nextBtnSVM,addBtn, viewBtn, nextItemBtn;
    private JButton coinBtn, billBtn;
    private JButton updateBtn, collectBtn, buyBtn, updateQuantiyBtn, updatePriceBtn;


    private JLabel nameLbl, slotNumLbl1,slotNumLbl2, maxItemLbl;
    private JLabel itemNameLbl, itemPriceLbl, itemCaloriesLbl, itemQuantityLbl;
    private JLabel vmSuccessLbl, itemSuccessLbl;
    private JLabel itemStatusLbl;
    private JLabel sectionLbl;

    private JTextField vmNameTxt;
    private JTextField rvmNameTxt, rvmSlotNumTxt, rvmMaxItemTxt;
    private JTextField svmNameTxt, svmSlotNumTxt, svmMaxItemTxt;
    private JTextField itemNameTxt, itemPriceTxt, itemCaloriesTxt, itemQuantityTxt;

    private JTextArea vendingListTextArea, slotTextArea, totalPriceTextArea, inventoryTextArea;

    private JTextArea slotName1, slotName2, slotName3, slotName4, slotName5, slotName6, slotName7, slotName8, slotName9, slotName10, totalPrice, slotList;
    private JLabel slotQty1, slotQty2, slotQty3, slotQty4, slotQty5, slotQty6, slotQty7, slotQty8, slotQty9, slotQty10;
    private JLabel slotPrice1, slotPrice2, slotPrice3, slotPrice4, slotPrice5, slotPrice6, slotPrice7, slotPrice8, slotPrice9, slotPrice10;
    private JButton coin1, coin5, coin10, bill20, bill50, bill100;

    private JLabel sectionLbl1, sectionLbl2, sectionLbl3, sectionLbl4, sectionLbl5;
    private JLabel itemNameLbl1, itemNameLbl2, quantityLbl, newPriceLbl;
    private JTextField maintenanceNameTxt1, maintenanceNameTxt2, maintenanceQuantityTxt, maintenanceNewPriceTxt;


    public vmfView(){
        firstMenu();
        choiceMenu();
        rvmMenu();
        svmMenu();
        addItemsMenu();
        testVMMenu();
    }

    public void firstMenu(){
        vmSuccessLbl = new JLabel("");

        this.createBtn = new JButton("Create Vending Machine");
        this.testBtn = new JButton("Test Vending Machine");
        this.exitBtn = new JButton("Exit");
        firstMenuFrame = new JFrame("Vending Machine Factory");
        firstMenuFrame.setSize(700, 900);
        firstMenuFrame.setResizable(false);
        firstMenuFrame.setLayout(null);
        this.createBtn.setBounds(120, 176, 460, 157);
        this.testBtn.setBounds(120, 371, 460, 157);
        this.exitBtn.setBounds(120, 566, 460, 157);

        //TODO: above the create vending machine button
        vmSuccessLbl.setBounds(0, 0, 0, 0);

        firstMenuFrame.add(createBtn);
        firstMenuFrame.add(testBtn);
        firstMenuFrame.add(exitBtn);
        firstMenuFrame.setVisible(true);
    }

    public JFrame getFirstMenu(){
        return this.firstMenuFrame;
    }

    public void setVmSuccessLbl(String string) {
        this.vmSuccessLbl.setText(string);
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
        this.regularBtn = new JButton("Regular Vending Machine");
        this.specialBtn = new JButton("Special Vending Machine");
        choiceMenuFrame = new JFrame("Vending Machine Factory");
        choiceMenuFrame.setSize(700, 900);
        choiceMenuFrame.setResizable(false);
        choiceMenuFrame.setLayout(null);
        regularBtn.setBounds(120, 274, 460, 157);
        specialBtn.setBounds(120, 469, 460, 157);
        choiceMenuFrame.add(regularBtn);
        choiceMenuFrame.add(specialBtn);
        choiceMenuFrame.setVisible(false);
        choiceMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JFrame getChoiceMenuFrame(){
        return choiceMenuFrame;
    }

    public void setRegularBtn_Listener(ActionListener actionListener){
        this.regularBtn.addActionListener(actionListener);
    }

    public void setSpecialBtn_Listener(ActionListener actionListener){
        this.specialBtn.addActionListener(actionListener);
    }

    public void rvmMenu(){

        rvmMenuFrame = new JFrame("Intialize RVM");
        nameLbl = new JLabel("VM name: ");
        slotNumLbl1 = new JLabel("# of item slots: ");
        maxItemLbl = new JLabel("Max # per slot: ");

        rvmNameTxt = new JTextField();
        rvmSlotNumTxt = new JTextField();
        rvmMaxItemTxt = new JTextField();

        this.nextBtnVM = new JButton("Next");

        rvmMenuFrame.setSize(700, 900);
        nameLbl.setBounds(30, 131, 253, 42);
        slotNumLbl1.setBounds(30, 302, 253, 42);
        maxItemLbl.setBounds(30, 474, 253, 42);

        rvmNameTxt.setBounds(296, 113, 308, 76);
        rvmSlotNumTxt.setBounds(296, 285, 308, 76);
        rvmMaxItemTxt.setBounds(296, 456, 308, 76);

        nextBtnVM.setBounds(184, 645, 308, 165);

        rvmMenuFrame.add(nameLbl);
        rvmMenuFrame.add(slotNumLbl1);
        rvmMenuFrame.add(maxItemLbl);
        rvmMenuFrame.add(rvmNameTxt);
        rvmMenuFrame.add(rvmSlotNumTxt);
        rvmMenuFrame.add(rvmMaxItemTxt);
        rvmMenuFrame.add(nextBtnVM);

        rvmMenuFrame.setResizable(false);
        rvmMenuFrame.setLayout(null);
        rvmMenuFrame.setVisible(false);
        rvmMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void svmMenu(){

        JLabel svmMenuNameLbl,svmMenuSlotNumLbl, svmMenuAddOnNumLbl, svmMenuMaxItemLbl;
        JTextField svmMenuNameTxt, svmMenuSlotNumTxt, svmMenuAddOnTxt,svmMenuMaxItemTxt;
        JButton svmMenuNextBtn;

        svmMenuFrame = new JFrame("Intialize SVM");
        svmMenuNameLbl = new JLabel("SVM name: ");
        svmMenuSlotNumLbl = new JLabel("# of item slots: ");
        svmMenuAddOnNumLbl = new JLabel("# of add-on slots: ");
        svmMenuMaxItemLbl = new JLabel("Max # per slot: ");

        svmMenuNameTxt = new JTextField();
        svmMenuSlotNumTxt = new JTextField();
        svmMenuAddOnTxt = new JTextField();
        svmMenuMaxItemTxt = new JTextField();

        svmMenuNextBtn = new JButton("Next");

        svmMenuFrame.setSize(700, 900);
        svmMenuNameLbl.setBounds(22, 217, 207, 36);
        svmMenuSlotNumLbl.setBounds(22, 340, 207, 36);
        svmMenuAddOnNumLbl.setBounds(22, 461, 255, 36);
        svmMenuMaxItemLbl.setBounds(22, 583, 296, 36);

        svmMenuNameTxt.setBounds(316, 195, 340, 67);
        svmMenuSlotNumTxt.setBounds(316, 314, 308, 76);
        svmMenuAddOnTxt.setBounds(316, 432, 308, 76);
        svmMenuMaxItemTxt.setBounds(316, 557, 308, 76);

        svmMenuNextBtn.setBounds(148, 711, 340, 145);

        svmMenuFrame.add(svmMenuFrame);
        svmMenuFrame.add(svmMenuNameLbl);
        svmMenuFrame.add(svmMenuSlotNumLbl);
        svmMenuFrame.add(svmMenuAddOnNumLbl);
        svmMenuFrame.add(svmMenuMaxItemLbl);
        svmMenuFrame.add(svmMenuNameTxt);
        svmMenuFrame.add(svmMenuSlotNumTxt);
        svmMenuFrame.add(svmMenuAddOnTxt);
        svmMenuFrame.add(svmMenuMaxItemTxt);
        svmMenuFrame.add(svmMenuNextBtn);

        svmMenuFrame.setResizable(false);
        svmMenuFrame.setLayout(null);
        svmMenuFrame.setVisible(true);
        svmMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JFrame getRvmMenuFrame(){
        return this.rvmMenuFrame;
    }

    public void setNextBtnVM_Listener(ActionListener actionListener){
        this.nextBtnVM.addActionListener(actionListener);
    }

    public String getRVMNameTxt(){
        return rvmNameTxt.getText();
    }

    public String getRVMSlotNumTxt(){

        return rvmSlotNumTxt.getText();
    }

    public String getRVMMaxItemTxt(){
        return rvmMaxItemTxt.getText();
    }

    public void clearRVMTxtVM(){
        this.rvmNameTxt.setText("");
        this.rvmSlotNumTxt.setText("");
        this.rvmMaxItemTxt.setText("");
    }

    
    public JFrame getSVMMenuFrame(){
        return this.svmMenuFrame;
    }

    public String getSVMNameTxt(){
        return svmNameTxt.getText();
    }

    public String getSVMSlotNumTxt(){

        return svmSlotNumTxt.getText();
    }

    public String getSVMMaxItemTxt(){
        return svmMaxItemTxt.getText();
    }

    public void clearSVMTxtVM(){
        this.svmNameTxt.setText("");
        this.svmSlotNumTxt.setText("");
        this.svmMaxItemTxt.setText("");
    }
    public void setNextBtnSVM_Listener(ActionListener actionListener){
        this.nextBtnSVM.addActionListener(actionListener);
    }

    public void addItemsMenu(){
        addItemsFrame = new JFrame("Add Items");

        itemNameLbl = new JLabel("Enter item name: ");
        itemPriceLbl = new JLabel("Enter item price: ");
        itemCaloriesLbl = new JLabel("Enter item calories: ");
        itemQuantityLbl = new JLabel("Enter item quantity: ");

        itemStatusLbl = new JLabel("");

        itemNameTxt = new JTextField();
        itemPriceTxt = new JTextField();
        itemCaloriesTxt = new JTextField();
        itemQuantityTxt = new JTextField(); 

        addBtn = new JButton("Add");
        nextItemBtn = new JButton("Next");

        addItemsFrame.setSize(700, 900);

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
        nextItemBtn.setBounds(189, 686, 304, 118);

        addItemsFrame.add(itemNameLbl);
        addItemsFrame.add(itemPriceLbl);
        addItemsFrame.add(itemCaloriesLbl);
        addItemsFrame.add(itemQuantityLbl);
        addItemsFrame.add(itemNameTxt);
        addItemsFrame.add(itemPriceTxt);
        addItemsFrame.add(itemCaloriesTxt);
        addItemsFrame.add(itemQuantityTxt);
        addItemsFrame.add(addBtn);

        //shows up when item is added successfully 
        addItemsFrame.add(itemStatusLbl);

        //only shows up when items added = slot.length/size
        //addItemsFrame.add(nextItemBtn);


        addItemsFrame.setResizable(false);
        addItemsFrame.setLayout(null);
        addItemsFrame.setVisible(false);
        addItemsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JFrame getAddItemFrame(){
        return this.addItemsFrame;
    }

    public void setAddBtn_Listener(ActionListener actionListener){
        this.addBtn.addActionListener(actionListener);
    }

    public void setNextItemBtn_Listener(ActionListener actionListener){
        this.nextItemBtn.addActionListener(actionListener);
    }

    public void clearItemTxt(){
        this.itemNameTxt.setText("");
        this.itemPriceTxt.setText("");
        this.itemCaloriesTxt.setText("");
        this.itemQuantityTxt.setText("");
    }


    public void setitemStatusLbl(String string) {
        this.itemStatusLbl.setText(string);
    }
    public void vmListMenu(){
        vmListFrame = new JFrame("Vending Machine List");

        nameLbl = new JLabel("Enter VM name: ");
        sectionLbl = new JLabel("Vending Machines");
        vmNameTxt = new JTextField();
        vendingListTextArea = new JTextArea(" fklsdnfkldsanfklasnkl ");
        

        vmListFrame.setSize(700, 900);
        nameLbl.setBounds(75, 66, 202, 34);
        sectionLbl.setBounds(277, 120, 242, 34);
        vmNameTxt.setBounds(293, 44, 331, 62);
        vendingListTextArea.setBounds(75, 148, 549, 650);

        vmListFrame.add(nameLbl);
        vmListFrame.add(sectionLbl);
        vmListFrame.add(vmNameTxt);
        vmListFrame.add(vendingListTextArea);

        vmListFrame.setResizable(false);
        vmListFrame.setLayout(null);
        vmListFrame.setVisible(false);
        vmListFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JFrame getVmListFrame(){
        return this.vmListFrame;
    }

    public void testVMMenu(){
        testVMFrame = new JFrame("Test Regular Vending Machine");

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

        testVMFrame.setSize(700, 900);

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

        testVMFrame.add(nameLbl);
        testVMFrame.add(itemNameLbl);
        testVMFrame.add(itemNameTxt);
        testVMFrame.add(totalPriceTextArea);
        testVMFrame.add(sectionLbl);
        testVMFrame.add(buyBtn);

        testVMFrame.add(slotName1);
        testVMFrame.add(slotName2);
        testVMFrame.add(slotName3);
        testVMFrame.add(slotName4);
        testVMFrame.add(slotName5);
        testVMFrame.add(slotName6);
        testVMFrame.add(slotName7);
        testVMFrame.add(slotName8);
        testVMFrame.add(slotName9);
        testVMFrame.add(slotName10);

        testVMFrame.add(slotPrice1);
        testVMFrame.add(slotPrice2);
        testVMFrame.add(slotPrice3);
        testVMFrame.add(slotPrice4);
        testVMFrame.add(slotPrice5);
        testVMFrame.add(slotPrice6);
        testVMFrame.add(slotPrice7);
        testVMFrame.add(slotPrice8);
        testVMFrame.add(slotPrice9);
        testVMFrame.add(slotPrice10);

        testVMFrame.add(slotQty1);
        testVMFrame.add(slotQty2);
        testVMFrame.add(slotQty3);
        testVMFrame.add(slotQty4);
        testVMFrame.add(slotQty5);
        testVMFrame.add(slotQty6);
        testVMFrame.add(slotQty7);
        testVMFrame.add(slotQty8);
        testVMFrame.add(slotQty9);
        testVMFrame.add(slotQty10);

        testVMFrame.add(coin1);
        testVMFrame.add(coin5);
        testVMFrame.add(coin10);
        testVMFrame.add(bill20);
        testVMFrame.add(bill50);
        testVMFrame.add(bill100);

        testVMFrame.setResizable(false);
        testVMFrame.setLayout(null);
        testVMFrame.setVisible(false);
        testVMFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JFrame getTestVmFrame() {
        return this.testVMFrame;
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

    public void setStatus (JFrame frame, boolean bool) {
        frame.setVisible(bool);
    }

    public void maintenanceMenu(){
        maintenanceFrame = new JFrame("Maintenance Window");

        nameLbl = new JLabel("Egg Drop");
        sectionLbl1 = new JLabel("Add Stock");
        sectionLbl2 =  new JLabel("Change Price");
        sectionLbl3 = new JLabel("Collect Money");
        sectionLbl4 = new JLabel("Inventory");
        sectionLbl5 = new JLabel("Replenish Change");
        totalPrice = new JTextArea("Total Money: ");

        itemNameLbl1 = new JLabel("Item name: ");
        quantityLbl = new JLabel("Quantity: ");
        itemNameLbl2 = new JLabel("Item name: ");
        newPriceLbl = new JLabel("New price: ");

        maintenanceNameTxt1 = new JTextField();
        maintenanceNameTxt2 = new JTextField();
        maintenanceQuantityTxt = new JTextField();
        maintenanceNewPriceTxt = new JTextField();

        updateQuantiyBtn = new JButton("update");
        updatePriceBtn =  new JButton("update");
        collectBtn = new JButton("collect");
        slotList = new JTextArea("1. Bread - 50 pesos - 15 pcs");

        coin1 = new JButton("1");
        coin5 = new JButton("5");
        coin10 = new JButton("10");
        bill20 = new JButton("20");
        bill50 = new JButton("50");
        bill100 = new JButton("100");

        maintenanceFrame.setSize(700, 900);

        nameLbl.setBounds(33, 41, 226, 79);
        sectionLbl1.setBounds(33, 137, 90, 29);
        sectionLbl2.setBounds(367, 137, 117, 29);
        sectionLbl3.setBounds(33, 389, 127, 29);
        sectionLbl4.setBounds(466, 389, 88, 29);
        sectionLbl5.setBounds(56, 564, 159, 29);
        totalPrice.setBounds(59, 839, 158, 29);

        itemNameLbl1.setBounds(33, 192, 97, 29);
        quantityLbl.setBounds(33, 262, 77, 29);
        itemNameLbl2.setBounds(367, 192, 97, 29);
        newPriceLbl.setBounds(367, 262, 77, 29);

        maintenanceNameTxt1.setBounds(144, 176, 187, 59);
        maintenanceNameTxt2.setBounds(473, 176, 187, 59);
        maintenanceQuantityTxt.setBounds(144, 246, 187, 59);
        maintenanceNewPriceTxt.setBounds(473, 246, 187, 59);

        updateQuantiyBtn.setBounds(184, 318, 104, 63);
        updatePriceBtn.setBounds(517, 316, 103, 63);
        collectBtn.setBounds(30, 418, 100, 86);
        slotList.setBounds(447, 420, 224, 317);

        coin1.setBounds(39, 617, 68, 85);
        coin5.setBounds(177, 617, 68, 85);
        coin10.setBounds(314, 617, 68, 85);
        bill20.setBounds(39, 726, 68, 85);
        bill50.setBounds(177, 726, 68, 85);
        bill100.setBounds(314, 726, 68, 85);

        maintenanceFrame.add(nameLbl);
        maintenanceFrame.add(sectionLbl1);
        maintenanceFrame.add(sectionLbl2);
        maintenanceFrame.add(sectionLbl3);
        maintenanceFrame.add(sectionLbl4);
        maintenanceFrame.add(sectionLbl5);
        maintenanceFrame.add(totalPrice);
        maintenanceFrame.add(itemNameLbl1);
        maintenanceFrame.add(quantityLbl);
        maintenanceFrame.add(itemNameLbl2);
        maintenanceFrame.add(newPriceLbl);
        maintenanceFrame.add(maintenanceNameTxt1);
        maintenanceFrame.add(maintenanceNameTxt2);
        maintenanceFrame.add(maintenanceQuantityTxt);
        maintenanceFrame.add(maintenanceNewPriceTxt);
        maintenanceFrame.add(updateQuantiyBtn);
        maintenanceFrame.add(updatePriceBtn);
        maintenanceFrame.add(collectBtn);
        maintenanceFrame.add(slotList);
        maintenanceFrame.add(coin1);
        maintenanceFrame.add(coin5);
        maintenanceFrame.add(coin10);
        maintenanceFrame.add(bill20);
        maintenanceFrame.add(bill50);
        maintenanceFrame.add(bill100);

        maintenanceFrame.setResizable(false);
        maintenanceFrame.setLayout(null);
        maintenanceFrame.setVisible(true);

    }

    public JFrame getMaintenanceFrame(){
        return this.maintenanceFrame;
    }
}


