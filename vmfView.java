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

    private JLabel nameLbl, slotNumLbl, maxItemLbl;
    private JLabel itemNameLbl, itemPriceLbl, itemCaloriesLbl, itemQuantityLbl;
    private JLabel itemStatusLbl;
    private JLabel sectionLbl;

    private JTextField vmNameTxt, slotNumTxt, maxItemTxt;
    private JTextField itemNameTxt, itemPriceTxt, itemCaloriesTxt, itemQuantityTxt;

    private JTextArea vendingListTextArea, slotTextArea, totalPriceTextArea, inventoryTextArea;


    public vmfView(){
        firstMenu();
        //vmChoice();
        //initializeRVM();
    }

    public void firstMenu(){
        this.createBtn = new JButton("Create Vending Machine");
        this.testBtn = new JButton("Test Vending Machine");
        this.exitBtn = new JButton("Exit");
        mainFrame = new JFrame("Vending Machine Factory");
        mainFrame.setSize(350, 450);
        mainFrame.setResizable(false);
        mainFrame.setLayout(null);
        this.createBtn.setBounds(60, 90, 200, 35);
        this.testBtn.setBounds(60, 150, 200, 35);
        this.exitBtn.setBounds(60, 210, 200, 35);

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

    public void vmChoice(){
        JButton regularBtn = new JButton("Regular Vending Machine");
        JButton specialBtn = new JButton("Special Vending Machine");
        mainFrame = new JFrame("Vending Machine Factory");
        mainFrame.setSize(350, 450);
        mainFrame.setResizable(false);
        mainFrame.setLayout(null);
        regularBtn.setBounds(60, 90, 200, 35);
        specialBtn.setBounds(60, 150, 200, 35);
        mainFrame.add(regularBtn);
        mainFrame.add(specialBtn);
        mainFrame.setVisible(true);
    }

    public void setRegularBtn_Listener(ActionListener actionListener){
        this.regularBtn.addActionListener(actionListener);
    }

    public void setSpecialBtn_Listener(ActionListener actionListener){
        this.specialBtn.addActionListener(actionListener);
    }

    public void initializeRVM(){

        mainFrame = new JFrame("intialize RVM");
        nameLbl = new JLabel("VM name: ");
        slotNumLbl = new JLabel("# of slots: ");
        maxItemLbl = new JLabel("Max # per slot: ");

        vmNameTxt = new JTextField();
        slotNumTxt = new JTextField();
        maxItemTxt = new JTextField();

        nextBtn = new JButton("next ->");

        mainFrame.setSize(350, 450);
        nameLbl.setBounds(40, 60, 200, 35);
        slotNumLbl.setBounds(40, 120, 200, 35);
        maxItemLbl.setBounds(40, 180, 200, 35);
        vmNameTxt.setBounds(150, 60, 100, 30);
        slotNumTxt.setBounds(150, 120, 100, 30);
        maxItemTxt.setBounds(150, 180, 100, 30);
        nextBtn.setBounds(100, 240, 100, 30);

        mainFrame.add(nameLbl);
        mainFrame.add(slotNumLbl);
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

    public JFrame getMainFrame(){
        return mainFrame;
    }

}
