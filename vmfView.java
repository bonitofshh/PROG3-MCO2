import javax.swing.*;

import java.awt.Font;
import java.awt.TextField;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;

public class vmfView {
    
    private JFrame firstMenuFrame, choiceMenuFrame, rvmMenuFrame, svmMenuFrame, addItemsFrame, vmListFrame, testVMFrame, maintenanceFrameVM;

    private JButton createBtn, testBtn, exitBtn, regularBtn, specialBtn;
    private JButton nextBtnVM, nextBtnSVM,addBtnVM, addBtnSVM, viewBtn;
    private JButton VMcoinBtn, VMbillBtn;
    private JButton updateBtn, collectBtn, buyBtnVM, updateQuantiyBtn, updatePriceBtn;
    private JButton vmNextBtn, vmTestBtn, vmMtBtn;

    private JLabel nameLbl, slotNumLbl1,slotNumLbl2, maxItemLbl;
    private JLabel itemNameLbl, itemPriceLbl, itemCaloriesLbl, itemQuantityLbl;
    private JLabel VMspecsLbl, vmSuccessLbl, itemSuccessLbl;
    private JLabel itemStatusLbl, vmUpdateLbl;
    private JLabel sectionLbl, nameVMLbl;

    private JTextField vmNameTxt;
    private JTextField rvmNameTxt, rvmSlotNumTxt, rvmMaxItemTxt;
    private JTextField svmNameTxt, svmSlotNumTxt, svmMaxItemTxt;
    private JTextField itemNameTxt, itemPriceTxt, itemCaloriesTxt, itemQuantityTxt;

    private JTextArea vendingListTextArea, slotTextArea, totalPriceTextArea, inventoryTextArea;

    private JTextArea VMslotName1, VMslotName2, VMslotName3, VMslotName4, VMslotName5, VMslotName6, VMslotName7, VMslotName8, VMslotName9, VMslotName10, totalPrice, slotList;
    private JLabel VMslotQty1, VMslotQty2, VMslotQty3, VMslotQty4, VMslotQty5, VMslotQty6, VMslotQty7, VMslotQty8, VMslotQty9, VMslotQty10;
    private JLabel VMslotPrice1, VMslotPrice2, VMslotPrice3, VMslotPrice4, VMslotPrice5, VMslotPrice6, VMslotPrice7, VMslotPrice8, VMslotPrice9, VMslotPrice10;
    private JButton VMcoin1, VMcoin5, VMcoin10, VMbill20, VMbill50, VMbill100;

    private JLabel sectionLbl1, sectionLbl2, sectionLbl3, sectionLbl4, sectionLbl5, VMtotalMoneyLbl;
    private JLabel itemNameLbl1, itemNameLbl2, quantityLbl, newPriceLbl;
    private JTextField maintenanceNameTxt1, maintenanceNameTxt2, maintenanceQuantityTxt, maintenanceNewPriceTxt;

    JLabel svmMenuNameLbl,svmMenuSlotNumLbl, svmMenuAddOnNumLbl, svmMenuMaxItemLbl;
    JTextField svmMenuNameTxt, svmMenuSlotNumTxt, svmMenuAddOnTxt,svmMenuMaxItemTxt, itemNameTxtVM;

    JFrame dispenseRVMItemFrame;
    JTextArea RVMtextArea;

    JButton exitBtnVM;

    JLabel VMnameLbl, VMsectionLbl1, VMsectionLbl2, VMsectionLbl3, VMsectionLbl4, VMsectionLbl5;
    JLabel VMitemNameLbl1, VMquantityLbl, VMitemNameLbl2, VMnewPriceLbl;
    JTextArea VMtotalPrice, VMslotList;

    JTextField VMmaintenanceNameTxt1, VMmaintenanceNameTxt2, VMmaintenanceQuantityTxt, VMmaintenanceNewPriceTxt;
    JButton VMupdateQuantityBtn, VMupdatePriceBtn, VMcollectBtn;
    JButton VMcoin1MT, VMcoin5MT, VMcoin10MT, VMbill20MT, VMbill50MT, VMbill100MT; 

    JLabel VMmaintenanceNameTxt1Lbl, VMmaintenanceNameTxt2Lbl;

    public vmfView(){
        firstMenu();
        choiceMenu();
        rvmMenu();
        svmMenu();
        vmListMenu();
        addItemsMenu();
        testVMMenu();
        maintenanceMenu();
        dispenseRVMItem();
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
        vmSuccessLbl.setBounds(120, 120, 460, 157);
        
        this.createBtn.setBounds(120, 176, 460, 157);
        this.testBtn.setBounds(120, 371, 460, 157);
        this.exitBtn.setBounds(120, 566, 460, 157);

        vmSuccessLbl.setBounds(220, 50, 460, 157);

        firstMenuFrame.add(vmSuccessLbl);
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
        slotNumLbl1 = new JLabel("# of item slots (8-10): ");
        maxItemLbl = new JLabel("Max # per slot: ");
        VMspecsLbl = new JLabel("");

        rvmNameTxt = new JTextField();
        rvmSlotNumTxt = new JTextField();
        rvmMaxItemTxt = new JTextField();

        this.vmNextBtn = new JButton("Next");

        VMspecsLbl.setBounds(280, 368, 268, 30);
        rvmMenuFrame.setSize(700, 900);
        nameLbl.setBounds(30, 131, 253, 42);
        slotNumLbl1.setBounds(30, 302, 253, 42);
        maxItemLbl.setBounds(30, 474, 253, 42);

        rvmNameTxt.setBounds(296, 113, 308, 76);
        rvmSlotNumTxt.setBounds(296, 285, 308, 76);
        rvmMaxItemTxt.setBounds(296, 456, 308, 76);

        vmNextBtn.setBounds(184, 645, 308, 165);

        rvmMenuFrame.add(VMspecsLbl);
        rvmMenuFrame.add(nameLbl);
        rvmMenuFrame.add(slotNumLbl1);
        rvmMenuFrame.add(maxItemLbl);
        rvmMenuFrame.add(rvmNameTxt);
        rvmMenuFrame.add(rvmSlotNumTxt);
        rvmMenuFrame.add(rvmMaxItemTxt);
        rvmMenuFrame.add(vmNextBtn);

        rvmMenuFrame.setResizable(false);
        rvmMenuFrame.setLayout(null);
        rvmMenuFrame.setVisible(false);
        rvmMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setVMspecsLbl(String string) {
        this.VMspecsLbl.setText(string);
    }

    public void svmMenu(){

        svmMenuFrame = new JFrame("Intialize SVM");
        svmMenuNameLbl = new JLabel("SVM name: ");
        svmMenuSlotNumLbl = new JLabel("# of item slots: ");
        svmMenuAddOnNumLbl = new JLabel("# of add-on slots: ");
        svmMenuMaxItemLbl = new JLabel("Max # per slot: ");

        svmMenuNameTxt = new JTextField();
        svmMenuSlotNumTxt = new JTextField();
        svmMenuAddOnTxt = new JTextField();
        svmMenuMaxItemTxt = new JTextField();

        addBtnSVM = new JButton("Add");
        nextBtnSVM = new JButton("Next");

        svmMenuFrame.setSize(700, 900);
        svmMenuNameLbl.setBounds(22, 217, 207, 36);
        svmMenuSlotNumLbl.setBounds(22, 340, 207, 36);
        svmMenuAddOnNumLbl.setBounds(22, 461, 255, 36);
        svmMenuMaxItemLbl.setBounds(22, 583, 296, 36);

        svmMenuNameTxt.setBounds(316, 195, 340, 67);
        svmMenuSlotNumTxt.setBounds(316, 314, 308, 76);
        svmMenuAddOnTxt.setBounds(316, 432, 308, 76);
        svmMenuMaxItemTxt.setBounds(316, 557, 308, 76);

        
        nextBtnSVM.setBounds(148, 711, 340, 145);

        //svmMenuFrame.add(svmMenuFrame);
        svmMenuFrame.add(svmMenuNameLbl);
        svmMenuFrame.add(svmMenuSlotNumLbl);
        svmMenuFrame.add(svmMenuAddOnNumLbl);
        svmMenuFrame.add(svmMenuMaxItemLbl);
        svmMenuFrame.add(svmMenuNameTxt);
        svmMenuFrame.add(svmMenuSlotNumTxt);
        svmMenuFrame.add(svmMenuAddOnTxt);
        svmMenuFrame.add(svmMenuMaxItemTxt);

        svmMenuFrame.setResizable(false);
        svmMenuFrame.setLayout(null);
        svmMenuFrame.setVisible(false);
        svmMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JFrame getRvmMenuFrame(){
        return this.rvmMenuFrame;
    }

    public void setVmNextBtn_Listener(ActionListener actionListener){
        this.vmNextBtn.addActionListener(actionListener);
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

//TODO: DUPLICATE ITEMSMENU TO ADDONSMENU

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

        addBtnVM = new JButton("Add");
        nextBtnVM = new JButton("Next");
        
        nextBtnVM.setVisible(false);

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

        addBtnVM.setBounds(189, 427, 304, 117);
        nextBtnVM.setBounds(189, 686, 304, 118);

        addItemsFrame.add(itemNameLbl);
        addItemsFrame.add(itemPriceLbl);
        addItemsFrame.add(itemCaloriesLbl);
        addItemsFrame.add(itemQuantityLbl);
        addItemsFrame.add(itemNameTxt);
        addItemsFrame.add(itemPriceTxt);
        addItemsFrame.add(itemCaloriesTxt);
        addItemsFrame.add(itemQuantityTxt);
        addItemsFrame.add(addBtnVM);
        addItemsFrame.add(nextBtnVM);

        addItemsFrame.add(itemStatusLbl);

        addItemsFrame.setResizable(false);
        addItemsFrame.setLayout(null);
        addItemsFrame.setVisible(false);
        addItemsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setVisibleNextBtnVM(boolean bool){
        nextBtnVM.setVisible(bool);
    }

    public void setNextBtnVM_Listener(ActionListener actionListener){
        this.nextBtnVM.addActionListener(actionListener);
    }

    public void setVisibleAddBtnVM(boolean bool) {
        addBtnVM.setVisible(bool);
    }

    public void setVisibleAddBtnSVM(boolean bool) {
        addBtnSVM.setVisible(bool);
    }

    public JFrame getAddItemFrame(){
        return this.addItemsFrame;
    }

    public void setAddBtnVM_Listener(ActionListener actionListener){
        this.addBtnVM.addActionListener(actionListener);
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

        vmUpdateLbl = new JLabel("");
        nameLbl = new JLabel("Enter VM name: ");
        sectionLbl = new JLabel("Vending Machines");
        vmNameTxt = new JTextField();
        vmTestBtn = new JButton("Test");
        vmMtBtn = new JButton("Maintenance");
        vendingListTextArea = new JTextArea("");
        

        vmListFrame.setSize(700, 900);
        vmUpdateLbl.setBounds(293, 20, 331, 30);
        nameLbl.setBounds(75, 66, 202, 34);
        sectionLbl.setBounds(277, 120, 242, 34);
        vmNameTxt.setBounds(293, 44, 331, 62);

        vmTestBtn.setBounds(293, 110, 80, 20);
        vmMtBtn.setBounds(380, 110, 80, 20);

        vendingListTextArea.setBounds(75, 148, 549, 650);

        vmListFrame.add(vmMtBtn);
        vmListFrame.add(vmTestBtn);
        vmListFrame.add(vmUpdateLbl);
        vmListFrame.add(nameLbl);
        vmListFrame.add(sectionLbl);
        vmListFrame.add(vmNameTxt);
        vmListFrame.add(vendingListTextArea);

        vmListFrame.setResizable(false);
        vmListFrame.setLayout(null);
        vmListFrame.setVisible(false);
        vmListFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vendingListTextArea.setEditable(false);
    }

    public void setVMupdateLbl(String text) {
        this.vmUpdateLbl.setText(text);
    }

    public JFrame getVmListFrame(){
        return this.vmListFrame;
    }

    public String getVMNameTxt(){
        return this.vmNameTxt.getText();
    }

    public void setVendingListTextArea(String string){
        this.vendingListTextArea.setText(string);
    }

    public void setVMTestBtn_Listener(ActionListener actionListener) {
        this.vmTestBtn.addActionListener(actionListener);
    }

    public void setVMMtBtn_Listener(ActionListener actionListener) {
        this.vmMtBtn.addActionListener(actionListener);
    }

    public void testVMMenu(){
        testVMFrame = new JFrame("Test Regular Vending Machine");

        //vendingMachineTextArea = new JTextArea("RVM Name");
        nameVMLbl = new JLabel("");
        itemNameLbl = new JLabel("Enter Item name: ");
        itemNameTxtVM = new JTextField();
        totalPriceTextArea = new JTextArea("Total: ");
        sectionLbl = new JLabel("Add Money");
        buyBtnVM = new JButton("Buy");
        exitBtnVM = new JButton("Exit");

        VMslotName1 = new JTextArea(""); //insert item names here
        VMslotName2 = new JTextArea("");
        VMslotName3 = new JTextArea("");
        VMslotName4 = new JTextArea("");
        VMslotName5 = new JTextArea("");
        VMslotName6 = new JTextArea("");
        VMslotName7 = new JTextArea("");
        VMslotName8 = new JTextArea("");
        VMslotName9 = new JTextArea("");
        VMslotName10 = new JTextArea("");
        
        VMslotPrice1 = new JLabel("Price: "); //insert prices 
        VMslotPrice2 = new JLabel("Price: ");
        VMslotPrice3 = new JLabel("Price: ");
        VMslotPrice4 = new JLabel("Price: ");
        VMslotPrice5 = new JLabel("Price: ");
        VMslotPrice6 = new JLabel("Price: ");
        VMslotPrice7 = new JLabel("Price: ");
        VMslotPrice8 = new JLabel("Price: ");
        VMslotPrice9 = new JLabel("Price: ");
        VMslotPrice10 = new JLabel("Price: ");

        VMslotQty1 = new JLabel("Qty: "); //insert quantities
        VMslotQty2 = new JLabel("Qty: ");
        VMslotQty3 = new JLabel("Qty: ");
        VMslotQty4 = new JLabel("Qty: ");
        VMslotQty5 = new JLabel("Qty: ");
        VMslotQty6 = new JLabel("Qty: ");
        VMslotQty7 = new JLabel("Qty: ");
        VMslotQty8 = new JLabel("Qty: ");
        VMslotQty9 = new JLabel("Qty: ");
        VMslotQty10 = new JLabel("Qty: ");

        VMcoin1 = new JButton("1");
        VMcoin5 = new JButton("5");
        VMcoin10 = new JButton("10");
        VMbill20 = new JButton("20");
        VMbill50 = new JButton("50");
        VMbill100 = new JButton("100");

        testVMFrame.setSize(700, 900);

        nameVMLbl.setBounds(33, 41, 226, 79);
        itemNameLbl.setBounds(480, 277, 180, 28);
        itemNameTxtVM.setBounds(486, 311, 183, 67);
        totalPriceTextArea.setBounds(486, 524, 183, 67);
        sectionLbl.setBounds(335, 684, 140, 24);

        exitBtnVM.setBounds(486, 600, 80, 30);

        VMslotName1.setBounds(33, 156, 152, 64);
        VMslotName2.setBounds(202, 156, 152, 64);
        VMslotName3.setBounds(33, 256, 152, 64);
        VMslotName4.setBounds(202, 256, 152, 64);
        VMslotName5.setBounds(33, 356, 152, 64);
        VMslotName6.setBounds(202, 356, 152, 64);
        VMslotName7.setBounds(33, 469, 152, 64);
        VMslotName8.setBounds(202, 469, 152, 64);
        VMslotName9.setBounds(33, 573, 152, 64);
        VMslotName10.setBounds(202, 573, 152, 64);

        VMslotPrice1.setBounds(30, 220, 81, 28);
        VMslotPrice2.setBounds(202, 220, 81, 28);
        VMslotPrice3.setBounds(30, 320, 81, 28);
        VMslotPrice4.setBounds(202, 320, 81, 28);
        VMslotPrice5.setBounds(30, 420, 81, 28);
        VMslotPrice6.setBounds(202, 420, 81, 28);
        VMslotPrice7.setBounds(30, 533, 81, 28);
        VMslotPrice8.setBounds(202, 533, 81, 28);
        VMslotPrice9.setBounds(30, 637, 81, 28);
        VMslotPrice10.setBounds(202, 637, 81, 28);

        VMslotQty1.setBounds(151, 220, 63, 28);
        VMslotQty2.setBounds(322, 220, 63, 28);
        VMslotQty3.setBounds(151, 320, 63, 28);
        VMslotQty4.setBounds(322, 320, 63, 28);
        VMslotQty5.setBounds(151, 420, 63, 28);
        VMslotQty6.setBounds(322, 420, 63, 28);
        VMslotQty7.setBounds(151, 533, 63, 28);
        VMslotQty8.setBounds(322, 533, 63, 28);
        VMslotQty9.setBounds(151, 637, 63, 28);
        VMslotQty10.setBounds(322, 637, 63, 28);

        VMcoin1.setBounds(128, 720, 95, 69);
        VMcoin5.setBounds(322, 720, 95, 69);
        VMcoin10.setBounds(516, 720, 95, 69);
        VMbill20.setBounds(128, 801, 95, 69);
        VMbill50.setBounds(322, 801, 95, 69);
        VMbill100.setBounds(516, 801, 95, 69);

        buyBtnVM.setBounds(526, 390, 96, 69);

        totalPriceTextArea.setEditable(false);

        VMslotName1.setEditable(false); 
        VMslotName2.setEditable(false);
        VMslotName3.setEditable(false);
        VMslotName4.setEditable(false);
        VMslotName5.setEditable(false);
        VMslotName6.setEditable(false);
        VMslotName7.setEditable(false);
        VMslotName8.setEditable(false);
        VMslotName9.setEditable(false);
        VMslotName10.setEditable(false);

        testVMFrame.add(nameVMLbl);
        testVMFrame.add(itemNameLbl);
        testVMFrame.add(itemNameTxtVM);
        testVMFrame.add(totalPriceTextArea);
        testVMFrame.add(sectionLbl);
        testVMFrame.add(buyBtnVM);
        testVMFrame.add(exitBtnVM);

        testVMFrame.add(VMslotName1);
        testVMFrame.add(VMslotName2);
        testVMFrame.add(VMslotName3);
        testVMFrame.add(VMslotName4);
        testVMFrame.add(VMslotName5);
        testVMFrame.add(VMslotName6);
        testVMFrame.add(VMslotName7);
        testVMFrame.add(VMslotName8);
        testVMFrame.add(VMslotName9);
        testVMFrame.add(VMslotName10);

        testVMFrame.add(VMslotPrice1);
        testVMFrame.add(VMslotPrice2);
        testVMFrame.add(VMslotPrice3);
        testVMFrame.add(VMslotPrice4);
        testVMFrame.add(VMslotPrice5);
        testVMFrame.add(VMslotPrice6);
        testVMFrame.add(VMslotPrice7);
        testVMFrame.add(VMslotPrice8);
        testVMFrame.add(VMslotPrice9);
        testVMFrame.add(VMslotPrice10);

        testVMFrame.add(VMslotQty1);
        testVMFrame.add(VMslotQty2);
        testVMFrame.add(VMslotQty3);
        testVMFrame.add(VMslotQty4);
        testVMFrame.add(VMslotQty5);
        testVMFrame.add(VMslotQty6);
        testVMFrame.add(VMslotQty7);
        testVMFrame.add(VMslotQty8);
        testVMFrame.add(VMslotQty9);
        testVMFrame.add(VMslotQty10);

        testVMFrame.add(VMcoin1);
        testVMFrame.add(VMcoin5);
        testVMFrame.add(VMcoin10);
        testVMFrame.add(VMbill20);
        testVMFrame.add(VMbill50);
        testVMFrame.add(VMbill100);

        testVMFrame.setResizable(false);
        testVMFrame.setLayout(null);
        testVMFrame.setVisible(false);
        testVMFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public String getTotalPriceTextArea() {
        return this.totalPriceTextArea.getText();
    }

    public void setTotalPriceTextArea(String text) {
        this.totalPriceTextArea.setText("Total: " + text);
    }

    public void setExitBtnVM_Listener(ActionListener actionListener) {
        this.exitBtnVM.addActionListener(actionListener);
    }

    public void setVMCoin1(ActionListener actionListener) {
        this.VMcoin1.addActionListener(actionListener);
    }

    public void setVMCoin5(ActionListener actionListener) {
        this.VMcoin5.addActionListener(actionListener);
    }

    public void setVMCoin10(ActionListener actionListener) {
        this.VMcoin10.addActionListener(actionListener);
    }

    public void setVMbill20(ActionListener actionListener) {
        this.VMbill20.addActionListener(actionListener);
    }

    public void setVMbill50(ActionListener actionListener) {
        this.VMbill50.addActionListener(actionListener);
    }

    public void setVMbill100(ActionListener actionListener) {
        this.VMbill100.addActionListener(actionListener);
    }
    
    public String getItemNameTxtVM() {
        return this.itemNameTxtVM.getText();
    }

    public void setItemNameTxtVM(String text) {
        this.itemNameTxtVM.setText(text);
    }

    public void setBuyBtnVM_Listener (ActionListener actionListener) {
        this.buyBtnVM.addActionListener(actionListener);
    }

    public void setNameVMLbl (String text) {
        this.nameVMLbl.setText(text);
    }

    public void setVMslotName1 (String text){
        this.VMslotName1.setText(text);
    }

    public void setVMslotName2 (String text) {
        this.VMslotName2.setText(text);
    }

    public void setVMslotName3 (String text) {
        this.VMslotName3.setText(text);
    }

    public void setVMslotName4 (String text) {
        this.VMslotName4.setText(text);
    }        

    public void setVMslotName5 (String text) {
        this.VMslotName5.setText(text);
    }

    public void setVMslotName6 (String text) {
        this.VMslotName6.setText(text);
    }

    public void setVMslotName7 (String text) {
        this.VMslotName7.setText(text);
    }

    public void setVMslotName8 (String text) {
        this.VMslotName8.setText(text);
    }

    public void setVMslotName9 (String text) {
        this.VMslotName9.setText(text);
    }

    public void setVMslotName10 (String text) {
        this.VMslotName10.setText(text);
    }  

    public void setVMslotPrice1 (String text) {
        this.VMslotPrice1.setText("Php: " + text);
    }

    public void setVMslotPrice2 (String text) {
        this.VMslotPrice2.setText("Php: " + text);
    }

    public void setVMslotPrice3 (String text) {
        this.VMslotPrice3.setText("Php: " + text);
    }

    public void setVMslotPrice4 (String text) {
        this.VMslotPrice4.setText("Php: " + text);
    }

    public void setVMslotPrice5 (String text) {
        this.VMslotPrice5.setText("Php: " + text);
    }

    public void setVMslotPrice6 (String text) {
        this.VMslotPrice6.setText("Php: " + text);
    }

    public void setVMslotPrice7 (String text) {
        this.VMslotPrice7.setText("Php: " + text);
    }

    public void setVMslotPrice8 (String text) {
        this.VMslotPrice8.setText("Php: " + text);
    }

    public void setVMslotPrice9 (String text) {
        this.VMslotPrice9.setText("Php: " + text);
    }

    public void setVMslotPrice10 (String text) {
        this.VMslotPrice10.setText("Php: " + text);
    }

    public void setVMslotQty1 (String text) {
        this.VMslotQty1.setText("Qty: " + text);
    }

    public void setVMslotQty2 (String text) {
        this.VMslotQty2.setText("Qty: " + text);
    }

    public void setVMslotQty3 (String text) {
        this.VMslotQty3.setText("Qty: " + text);
    }

    public void setVMslotQty4 (String text) {
        this.VMslotQty4.setText("Qty: " + text);
    }

    public void setVMslotQty5 (String text) {
        this.VMslotQty5.setText("Qty: " + text);
    }

    public void setVMslotQty6 (String text) {
        this.VMslotQty6.setText("Qty: " + text);
    }

    public void setVMslotQty7 (String text) {
        this.VMslotQty7.setText("Qty: " + text);
    }

    public void setVMslotQty8 (String text) {
        this.VMslotQty8.setText("Qty: " + text);
    }

    public void setVMslotQty9 (String text) {
        this.VMslotQty9.setText("Qty: " + text);
    }

    public void setVMslotQty10 (String text) {
        this.VMslotQty10.setText("Qty: " + text);
    }

    public String getVMslotQty1 (){
        return this.VMslotQty1.getText();
    }

    public String getVMslotQty2 (){
        return this.VMslotQty2.getText();
    }

    public String getVMslotQty3 (){
        return this.VMslotQty3.getText();
    }

    public String getVMslotQty4 (){
        return this.VMslotQty4.getText();
    }

    public String getVMslotQty5 (){
        return this.VMslotQty5.getText();
    }

    public String getVMslotQty6 (){
        return this.VMslotQty6.getText();
    }

    public String getVMslotQty7 (){
        return this.VMslotQty7.getText();
    }

    public String getVMslotQty8 (){
        return this.VMslotQty8.getText();
    }

    public String getVMslotQty9 (){
        return this.VMslotQty9.getText();
    }

    public String getVMslotQty10 (){
        return this.VMslotQty10.getText();
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
        maintenanceFrameVM = new JFrame("Maintenance Window");

        VMnameLbl = new JLabel("");
        VMtotalMoneyLbl = new JLabel("");
        VMsectionLbl1 = new JLabel("Add Stock");
        VMsectionLbl2 =  new JLabel("Change Price");
        VMsectionLbl3 = new JLabel("Collect Money");
        VMsectionLbl4 = new JLabel("Inventory");
        VMsectionLbl5 = new JLabel("Replenish Change");
        VMtotalPrice = new JTextArea("Total Money: ");

        VMmaintenanceNameTxt1Lbl = new JLabel("");
        VMmaintenanceNameTxt2Lbl = new JLabel("");
        VMitemNameLbl1 = new JLabel("Item name: ");
        VMquantityLbl = new JLabel("Quantity: ");
        VMitemNameLbl2 = new JLabel("Item name: ");
        VMnewPriceLbl = new JLabel("New price: ");

        VMmaintenanceNameTxt1 = new JTextField("");
        VMmaintenanceNameTxt2 = new JTextField("");
        VMmaintenanceQuantityTxt = new JTextField();
        VMmaintenanceNewPriceTxt = new JTextField();

        VMupdateQuantityBtn = new JButton("Update");
        VMupdatePriceBtn =  new JButton("Update");
        VMcollectBtn = new JButton("Collect");
        VMslotList = new JTextArea("");

        VMcoin1MT = new JButton("1");
        VMcoin5MT = new JButton("5");
        VMcoin10MT = new JButton("10");
        VMbill20MT = new JButton("20");
        VMbill50MT = new JButton("50");
        VMbill100MT = new JButton("100");

        maintenanceFrameVM.setSize(700, 900);

        VMnameLbl.setBounds(33, 41, 226, 79);
        VMsectionLbl1.setBounds(33, 137, 90, 29);
        VMsectionLbl2.setBounds(367, 137, 117, 29);
        VMsectionLbl3.setBounds(33, 389, 127, 29);
        VMsectionLbl4.setBounds(466, 389, 88, 29);
        VMsectionLbl5.setBounds(56, 564, 159, 29);
        VMtotalPrice.setBounds(59, 839, 158, 29);

        VMtotalMoneyLbl.setBounds(56, 533, 230, 29);

        VMitemNameLbl1.setBounds(33, 192, 97, 29);
        VMquantityLbl.setBounds(33, 262, 77, 29);
        VMitemNameLbl2.setBounds(367, 192, 97, 29);
        VMnewPriceLbl.setBounds(367, 262, 77, 29);

        VMmaintenanceNameTxt1Lbl.setBounds(144, 120, 187, 59);
        VMmaintenanceNameTxt1.setBounds(144, 176, 187, 59);
        VMmaintenanceNameTxt2Lbl.setBounds(473, 120, 187, 59);
        VMmaintenanceNameTxt2.setBounds(473, 176, 187, 59);
        VMmaintenanceQuantityTxt.setBounds(144, 246, 187, 59);
        VMmaintenanceNewPriceTxt.setBounds(473, 246, 187, 59);

        VMupdateQuantityBtn.setBounds(184, 318, 104, 63);
        VMupdatePriceBtn.setBounds(517, 316, 103, 63);
        VMcollectBtn.setBounds(30, 418, 100, 86);
        VMslotList.setBounds(447, 420, 224, 317);

        VMcoin1MT.setBounds(39, 617, 68, 85);
        VMcoin5MT.setBounds(177, 617, 68, 85);
        VMcoin10MT.setBounds(314, 617, 68, 85);
        VMbill20MT.setBounds(39, 726, 68, 85);
        VMbill50MT.setBounds(177, 726, 68, 85);
        VMbill100MT.setBounds(314, 726, 68, 85);

        maintenanceFrameVM.add(VMtotalMoneyLbl);
        maintenanceFrameVM.add(VMmaintenanceNameTxt1Lbl);
        maintenanceFrameVM.add(VMmaintenanceNameTxt2Lbl);
        maintenanceFrameVM.add(VMnameLbl);
        maintenanceFrameVM.add(VMsectionLbl1);
        maintenanceFrameVM.add(VMsectionLbl2);
        maintenanceFrameVM.add(VMsectionLbl3);
        maintenanceFrameVM.add(VMsectionLbl4);
        maintenanceFrameVM.add(VMsectionLbl5);
        maintenanceFrameVM.add(VMtotalPrice);
        maintenanceFrameVM.add(VMitemNameLbl1);
        maintenanceFrameVM.add(VMquantityLbl);
        maintenanceFrameVM.add(VMitemNameLbl2);
        maintenanceFrameVM.add(VMnewPriceLbl);
        maintenanceFrameVM.add(VMmaintenanceNameTxt1);
        maintenanceFrameVM.add(VMmaintenanceNameTxt2);
        maintenanceFrameVM.add(VMmaintenanceQuantityTxt);
        maintenanceFrameVM.add(VMmaintenanceNewPriceTxt);
        maintenanceFrameVM.add(VMupdateQuantityBtn);
        maintenanceFrameVM.add(VMupdatePriceBtn);
        maintenanceFrameVM.add(VMcollectBtn);
        maintenanceFrameVM.add(VMslotList);
        maintenanceFrameVM.add(VMcoin1MT);
        maintenanceFrameVM.add(VMcoin5MT);
        maintenanceFrameVM.add(VMcoin10MT);
        maintenanceFrameVM.add(VMbill20MT);
        maintenanceFrameVM.add(VMbill50MT);
        maintenanceFrameVM.add(VMbill100MT);

        VMslotList.setEditable(false);
        maintenanceFrameVM.setResizable(false);
        maintenanceFrameVM.setLayout(null);
        maintenanceFrameVM.setVisible(false);
    }

    public void setVMcoin1MT_Listener(ActionListener actionListener) {
        this.VMcoin1MT.addActionListener(actionListener);
    }

    public void setVMcoin5MT_Listener(ActionListener actionListener) {
        this.VMcoin5MT.addActionListener(actionListener);
    }

    public void setVMcoin10MT_Listener(ActionListener actionListener) {
        this.VMcoin10MT.addActionListener(actionListener);
    }

    public void setVMbill20MT_Listener(ActionListener actionListener) {
        this.VMbill20MT.addActionListener(actionListener);
    }

    public void setVMbill50MT_Listener(ActionListener actionListener) {
        this.VMbill50MT.addActionListener(actionListener);
    }

    public void setVMbill100MT_Listener(ActionListener actionListener) {
        this.VMbill100MT.addActionListener(actionListener);
    }

    public void setVMupdateQuantityBtn_Listener(ActionListener actionListener) {
        this.VMupdateQuantityBtn.addActionListener(actionListener);
    }

    public void setVMupdatePriceBtn_Listener(ActionListener actionListener) {
        this.VMupdatePriceBtn.addActionListener(actionListener);
    }
    
    public void setVMcollectBtnBtn_Listener(ActionListener actionListener) {
        this.VMcollectBtn.addActionListener(actionListener);
    }
    
    public void setVMtotalMoneyLblTxt(String text) {
        this.VMtotalMoneyLbl.setText("Total Money in Machine: " + text);
    }
    
    public void setVMmaintenanceNameTxt1Lbl(String text) {
        this.VMmaintenanceNameTxt1Lbl.setText(text);
    }

    public void setVMmaintenanceNameTxt2Lbl (String text) {
        this.VMmaintenanceNameTxt2Lbl.setText(text);
    }

    public String getVMmaintenanceNameTxt1() {
        return this.VMmaintenanceNameTxt1.getText();
    }

    public void setVMmaintenanceNameTxt1(String text) {
        this.VMmaintenanceNameTxt1.setText(text);
    }

    public String getVMmaintenanceNameTxt2() {
        return this.VMmaintenanceNameTxt2.getText();
    }

    public void setVMmaintenanceNameTxt2(String text) {
        this.VMmaintenanceNameTxt2.setText(text);
    }

    public String getVMmaintenanceQuantityTxt() {
        return this.VMmaintenanceQuantityTxt.getText();
    }

    public void setVMmaintenanceQuantityTxt(String text) {
        this.VMmaintenanceQuantityTxt.setText(text);
    }

    public String getVMmaintenanceNewPriceTxt() {
        return this.VMmaintenanceNewPriceTxt.getText();
    }

    public void setVMmaintenanceNewPriceTxt(String text) {
        this.VMmaintenanceNewPriceTxt.setText(text);
    }

    public void setVMnameLblTxt (String text) {
        this.VMnameLbl.setText(text);
    }

    public void setVMslotListTxt(String text) {
        this.VMslotList.setText(text);
    }

    public JFrame getMaintenanceFrameVM(){
        return this.maintenanceFrameVM;
    }

    public void dispenseRVMItem(){

        dispenseRVMItemFrame = new JFrame("Notice!");
        dispenseRVMItemFrame.setSize(350, 250);

        RVMtextArea = new JTextArea();
        RVMtextArea.setBounds( 10, 10, 300, 180);

        dispenseRVMItemFrame.add(RVMtextArea);

        RVMtextArea.setEditable(false);

        dispenseRVMItemFrame.setResizable(false);
        dispenseRVMItemFrame.setLayout(null);
        dispenseRVMItemFrame.setVisible(false);
        RVMtextArea.setEditable(false);
        testVMFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JFrame getDispenseRVMItemFrame() {
        return this.dispenseRVMItemFrame;
    }

    public String getRVMtextArea() {
        return this.RVMtextArea.getText();
    }

    public void setRVMtextArea(String text) {
        this.RVMtextArea.setText(text);
    }
}


