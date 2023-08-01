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
    private JButton updateBtn, collectBtn;

    private JLabel nameLbl, slotNumLbl1,slotNumLbl2, maxItemLbl;
    private JLabel itemNameLbl, itemPriceLbl, itemCaloriesLbl, itemQuantityLbl;
    private JLabel itemStatusLbl;
    private JLabel sectionLbl;

    private JTextField vmNameTxt, slotNumTxt, maxItemTxt;
    private JTextField itemNameTxt, itemPriceTxt, itemCaloriesTxt, itemQuantityTxt;

    private JTextArea vendingListTextArea, slotTextArea, totalPriceTextArea, inventoryTextArea;


    public vmfView(){
        //firstMenu();
        //choiceMenu();
        //rvmMenu();
        addItems();
        //vmListMenu();
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

    public void setNextBtn_Listener(ActionListener actionListener){
        this.nextBtn.addActionListener(actionListener);
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



    }

}
