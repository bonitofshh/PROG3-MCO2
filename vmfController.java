import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vmfController {
    private vmfView vmfView;
    private vmfModel vmfModel;
    private vmfModelVM vmfModelVM;
    private vmfModelSVM vmfModelSVM;

    public vmfController(vmfView vmfView, vmfModel vmfModel){
        this.vmfView = vmfView;
        this.vmfModel = vmfModel;

        this.vmfView.setCreateBtn_Listener(new ActionListener() {//Create Vending 
            @Override
            public void actionPerformed(ActionEvent arg0){
                vmfView.setStatus(vmfView.getFirstMenu(), false); 
                vmfView.setStatus(vmfView.getChoiceMenuFrame(), true); 
                vmfView.setVmSuccessLbl("");
                vmfView.setitemStatusLbl("");
                }
            }); 
            
        this.vmfView.setTestBtn_Listener(new ActionListener() {//button to search vending machines
            public void actionPerformed(ActionEvent arg0){
                if (vmfModel.vmList.size() <= 0) vmfView.setVmSuccessLbl("There are no vending machines.");
                else {
                    vmfView.setStatus(vmfView.getFirstMenu(), false); 
                    vmfView.setVendingListTextArea(vmfModel.getVMList());
                    vmfView.setStatus(vmfView.getVmListFrame(), true);
                    vmfView.getVmListFrame().revalidate();
                    vmfView.getVmListFrame().repaint();  
                }
            }
        });

        this.vmfView.setVMTestBtn_Listener(new ActionListener() {//Test Features RVM
            public void actionPerformed(ActionEvent arg0) {
                int found = 0, index = 0;
                for (int i = 0; i < vmfModel.vmList.size(); i++) {
                    if (vmfView.getVMNameTxt().equals(vmfModel.vmList.get(i).getName())) {
                        vmfView.setVMupdateLbl(vmfModel.vmList.get(i).getName());
                        index = i;
                        found = 1;

                        for (int j = 0; j < vmfModel.vmList.get(index).getSlotList().length; j++) {
                            switch(j) {
                                case 0:
                                    if (vmfModel.vmList.get(index).getSlotList()[j].getItem() != null) {
                                        vmfView.setVMslotName1(vmfModel.vmList.get(index).getSlotList()[j].getItem().getName());
                                        vmfView.setVMslotPrice1(String.valueOf(vmfModel.vmList.get(index).getSlotList()[j].getItem().getPrice()));
                                        vmfView.setVMslotQty1(String.valueOf(vmfModel.vmList.get(index).getSlotList()[j].getQuantity(vmfModel.vmList.get(index).getMaxItems()))); 
                                    } else {
                                        vmfView.setVMslotName1("Empty");
                                        vmfView.setVMslotPrice1("0");
                                        vmfView.setVMslotQty1("0");
                                    }
                                    break;
                                    
                                case 1:
                                    if (vmfModel.vmList.get(index).getSlotList()[j].getItem() != null) {
                                    vmfView.setVMslotName2(vmfModel.vmList.get(index).getSlotList()[j].getItem().getName());
                                    vmfView.setVMslotPrice2(String.valueOf(vmfModel.vmList.get(index).getSlotList()[j].getItem().getPrice()));
                                    vmfView.setVMslotQty2(String.valueOf(vmfModel.vmList.get(index).getSlotList()[j].getQuantity(vmfModel.vmList.get(index).getMaxItems())));
                                    } else {
                                        vmfView.setVMslotName2("Empty");
                                        vmfView.setVMslotPrice2("0");
                                        vmfView.setVMslotQty2("0");
                                    }
                                    break;
                                case 2:
                                    if (vmfModel.vmList.get(index).getSlotList()[j].getItem() != null) {
                                    vmfView.setVMslotName3(vmfModel.vmList.get(index).getSlotList()[j].getItem().getName());
                                    vmfView.setVMslotPrice3(String.valueOf(vmfModel.vmList.get(index).getSlotList()[j].getItem().getPrice()));
                                    vmfView.setVMslotQty3(String.valueOf(vmfModel.vmList.get(index).getSlotList()[j].getQuantity(vmfModel.vmList.get(index).getMaxItems())));
                                    } else {
                                        vmfView.setVMslotName3("Empty");
                                        vmfView.setVMslotPrice3("0");
                                        vmfView.setVMslotQty3("0");
                                    }
                                    break;

                                case 3:
                                    if (vmfModel.vmList.get(index).getSlotList()[j].getItem() != null) {
                                    vmfView.setVMslotName4(vmfModel.vmList.get(index).getSlotList()[j].getItem().getName());
                                    vmfView.setVMslotPrice4(String.valueOf(vmfModel.vmList.get(index).getSlotList()[j].getItem().getPrice()));
                                    vmfView.setVMslotQty4(String.valueOf(vmfModel.vmList.get(index).getSlotList()[j].getQuantity(vmfModel.vmList.get(index).getMaxItems())));
                                    } else {
                                        vmfView.setVMslotName4("Empty");
                                        vmfView.setVMslotPrice4("0");
                                        vmfView.setVMslotQty4("0");
                                    }
                                    break;

                                case 4:
                                    if (vmfModel.vmList.get(index).getSlotList()[j].getItem() != null) {
                                    vmfView.setVMslotName5(vmfModel.vmList.get(index).getSlotList()[j].getItem().getName());
                                    vmfView.setVMslotPrice5(String.valueOf(vmfModel.vmList.get(index).getSlotList()[j].getItem().getPrice()));
                                    vmfView.setVMslotQty5(String.valueOf(vmfModel.vmList.get(index).getSlotList()[j].getQuantity(vmfModel.vmList.get(index).getMaxItems())));
                                    } else {
                                        vmfView.setVMslotName5("Empty");
                                        vmfView.setVMslotPrice5("0");
                                        vmfView.setVMslotQty5("0");
                                    }
                                    break; 

                                case 5:
                                    if (vmfModel.vmList.get(index).getSlotList()[j].getItem() != null) {
                                    vmfView.setVMslotName6(vmfModel.vmList.get(index).getSlotList()[j].getItem().getName());
                                    vmfView.setVMslotPrice6(String.valueOf(vmfModel.vmList.get(index).getSlotList()[j].getItem().getPrice()));
                                    vmfView.setVMslotQty6(String.valueOf(vmfModel.vmList.get(index).getSlotList()[j].getQuantity(vmfModel.vmList.get(index).getMaxItems())));
                                    } else {
                                        vmfView.setVMslotName6("Empty");
                                        vmfView.setVMslotPrice6("0");
                                        vmfView.setVMslotQty6("Empty");
                                    }
                                    break;

                                case 6:
                                    if (vmfModel.vmList.get(index).getSlotList()[j].getItem() != null) {
                                    vmfView.setVMslotName7(vmfModel.vmList.get(index).getSlotList()[j].getItem().getName());
                                    vmfView.setVMslotPrice7(String.valueOf(vmfModel.vmList.get(index).getSlotList()[j].getItem().getPrice()));
                                    vmfView.setVMslotQty7(String.valueOf(vmfModel.vmList.get(index).getSlotList()[j].getQuantity(vmfModel.vmList.get(index).getMaxItems())));
                                    } else {
                                        vmfView.setVMslotName7("");
                                        vmfView.setVMslotPrice7("");
                                        vmfView.setVMslotQty7("");
                                    }
                                    break;

                                case 7:
                                    if (vmfModel.vmList.get(index).getSlotList()[j].getItem() != null) {
                                    vmfView.setVMslotName8(vmfModel.vmList.get(index).getSlotList()[j].getItem().getName());
                                    vmfView.setVMslotPrice8(String.valueOf(vmfModel.vmList.get(index).getSlotList()[j].getItem().getPrice()));
                                    vmfView.setVMslotQty8(String.valueOf(vmfModel.vmList.get(index).getSlotList()[j].getQuantity(vmfModel.vmList.get(index).getMaxItems())));
                                    } else {
                                        vmfView.setVMslotName8("");
                                        vmfView.setVMslotPrice8("");
                                        vmfView.setVMslotQty8("");
                                    }
                                    break;

                                case 8:
                                    if (vmfModel.vmList.get(index).getSlotList()[j].getItem() != null) {
                                    vmfView.setVMslotName9(vmfModel.vmList.get(index).getSlotList()[j].getItem().getName());
                                    vmfView.setVMslotPrice9(String.valueOf(vmfModel.vmList.get(index).getSlotList()[j].getItem().getPrice()));
                                    vmfView.setVMslotQty9(String.valueOf(vmfModel.vmList.get(index).getSlotList()[j].getQuantity(vmfModel.vmList.get(index).getMaxItems())));
                                    } else {
                                        vmfView.setVMslotName9("");
                                        vmfView.setVMslotPrice9("");
                                        vmfView.setVMslotQty9("");
                                    }
                                    break;

                                case 9:
                                    if (vmfModel.vmList.get(index).getSlotList()[j].getItem() != null) {
                                    vmfView.setVMslotName10(vmfModel.vmList.get(index).getSlotList()[j].getItem().getName());
                                    vmfView.setVMslotPrice10(String.valueOf(vmfModel.vmList.get(index).getSlotList()[j].getItem().getPrice()));
                                    vmfView.setVMslotQty10(String.valueOf(vmfModel.vmList.get(index).getSlotList()[j].getQuantity(vmfModel.vmList.get(index).getMaxItems())));
                                    } else {
                                        vmfView.setVMslotName10("");
                                        vmfView.setVMslotPrice10("");
                                        vmfView.setVMslotQty10("");
                                    }
                                    break;
                            }
                        }

                        vmfView.setNameVMLbl(vmfModel.vmList.get(i).getName());
                        //TODO: UPDATE ALL VALUES
                        vmfView.getFirstMenu().revalidate();
                        vmfView.getFirstMenu().repaint();
                    }   
                }
                if (found == 0) {
                    vmfView.setVMupdateLbl("Vending Machine not found!");
                    vmfView.getFirstMenu().revalidate();
                    vmfView.getFirstMenu().repaint();
                }
                vmfView.setStatus(vmfView.getVmListFrame(), false);
                vmfView.setStatus(vmfView.getTestVmFrame(), true);
            }
        });

        this.vmfView.setVMMtBtn_Listener(new ActionListener() { //Perform Maintenance VM
            public void actionPerformed(ActionEvent arg0) {
                int found = 0;
                for (int i = 0; i < vmfModel.vmList.size(); i++) {
                    if (vmfView.getVMNameTxt().equals(vmfModel.vmList.get(i).getName())) {
                        vmfView.setVMupdateLbl(vmfModel.vmList.get(i).getName());
                        found = 1;

                        vmfView.setNameVMLbl(vmfModel.vmList.get(i).getName());
                        //TODO: UPDATE ALL VALUES
                        vmfView.getFirstMenu().revalidate();
                        vmfView.getFirstMenu().repaint();
                    }   
                }
                if (found == 0) {
                    vmfView.setVMupdateLbl("Vending Machine not found!");
                    vmfView.getFirstMenu().revalidate();
                    vmfView.getFirstMenu().repaint();
                }

                vmfView.setVMtotalMoneyLblTxt(String.valueOf(vmfModelVM.getMoneyBox().getTotalMoney()));
                vmfView.setVMslotListTxt(vmfModelVM.getInventoryList());

                vmfView.setStatus(vmfView.getVmListFrame(), false);
                vmfView.setStatus(vmfView.getMaintenanceFrameVM(), true);
            
            }
        });
        
        this.vmfView.setExitBtn_Listener(new ActionListener() {//Exit
            public void actionPerformed(ActionEvent arg0){
                vmfView.setStatus(vmfView.getFirstMenu(), false); 
            }
        });

        this.vmfView.setBuyBtnVM_Listener(new ActionListener() {//Buy button from vending machine
            public void actionPerformed(ActionEvent arg0) {
                int index = -1;
                String name = vmfView.getItemNameTxtVM();
                for (int i = 0; i < vmfModelVM.getSlotList().length; i++) {
                    if (name.equals(vmfModelVM.getSlotList()[i].getItem().getName())) index = i;
                }

                if (index == -1) {
                    vmfView.setRVMtextArea("Item not found!");
                    vmfView.setTotalPriceTextArea("0"); 
                    vmfView.getTestVmFrame().revalidate();
                    vmfView.getTestVmFrame().repaint();  
                    vmfModelVM.emptyMoney(vmfModelVM.getUserInput()); //resets user inputted money value 

                } else if (vmfModelVM.isItemAvail(vmfModelVM.getSlotList()[index].getItem().getName(), vmfModelVM.getMaxItems(), vmfModelVM.getSlotList()) == false){
                    vmfView.setRVMtextArea("Item is not available!");
                    vmfView.setTotalPriceTextArea("0"); 
                    vmfView.getTestVmFrame().revalidate();
                    vmfView.getTestVmFrame().repaint(); 
                    vmfModelVM.emptyMoney(vmfModelVM.getUserInput()); //resets user inputted money value 

                } else if (vmfModelVM.validChange(vmfModelVM.getSlotList()[index].getItem().getName()) != null) {
                    vmfView.setRVMtextArea(vmfModelVM.validChange(vmfModelVM.getSlotList()[index].getItem().getName()));
                    vmfView.setTotalPriceTextArea("0"); 
                    vmfView.getTestVmFrame().revalidate();
                    vmfView.getTestVmFrame().repaint(); 
                    vmfModelVM.emptyMoney(vmfModelVM.getUserInput()); //resets user inputted money value 

                } else {      
                    int updateFrame = vmfModelVM.dispenseItem(name, vmfModelVM.getSlotList()); //dispenses item 
                    switch (updateFrame) {
                        case 0:
                            vmfView.setVMslotQty1(String.valueOf(vmfModelVM.getSlotList()[updateFrame].getQuantity(vmfModelVM.getMaxItems())));
                            break;
                        case 1:
                            vmfView.setVMslotQty2(String.valueOf(vmfModelVM.getSlotList()[updateFrame].getQuantity(vmfModelVM.getMaxItems())));
                            break;
                        case 2: 
                            vmfView.setVMslotQty3(String.valueOf(vmfModelVM.getSlotList()[updateFrame].getQuantity(vmfModelVM.getMaxItems())));
                            break;
                        case 3:
                            vmfView.setVMslotQty4(String.valueOf(vmfModelVM.getSlotList()[updateFrame].getQuantity(vmfModelVM.getMaxItems())));
                            break;
                        case 4:
                            vmfView.setVMslotQty5(String.valueOf(vmfModelVM.getSlotList()[updateFrame].getQuantity(vmfModelVM.getMaxItems())));
                            break;
                        case 5:
                            vmfView.setVMslotQty6(String.valueOf(vmfModelVM.getSlotList()[updateFrame].getQuantity(vmfModelVM.getMaxItems())));
                            break;
                        case 6:
                            vmfView.setVMslotQty7(String.valueOf(vmfModelVM.getSlotList()[updateFrame].getQuantity(vmfModelVM.getMaxItems())));
                            break;
                        case 7:
                            vmfView.setVMslotQty8(String.valueOf(vmfModelVM.getSlotList()[updateFrame].getQuantity(vmfModelVM.getMaxItems())));
                            break;
                        case 8:
                            vmfView.setVMslotQty9(String.valueOf(vmfModelVM.getSlotList()[updateFrame].getQuantity(vmfModelVM.getMaxItems())));
                            break;
                        case 9:
                            vmfView.setVMslotQty10(String.valueOf(vmfModelVM.getSlotList()[updateFrame].getQuantity(vmfModelVM.getMaxItems())));
                            break;
                    }
                    vmfView.setTotalPriceTextArea("0"); 
                    vmfView.getTestVmFrame().revalidate();
                    vmfView.getTestVmFrame().repaint(); 
                    vmfView.setRVMtextArea("You have received [" + vmfModelVM.getSlotList()[index].getItem().getName() + "]" + "\nChange: " + vmfModelVM.dispenseChange(name));
                    vmfModelVM.createTransaction(name);//creates a transaction 
                    vmfModelVM.emptyMoney(vmfModelVM.getUserInput()); //resets user inputted money value 
                    vmfView.setItemNameTxtVM("");
                }

                vmfView.setStatus(vmfView.getDispenseRVMItemFrame(), true);
            }
        });

        this.vmfView.setRegularBtn_Listener(new ActionListener() {// Regular VM
            public void actionPerformed(ActionEvent arg0) {
                vmfView.setStatus(vmfView.getChoiceMenuFrame(), false); 
                vmfView.clearRVMTxtVM();
                vmfView.setStatus(vmfView.getRvmMenuFrame(), true); 
            }
        });

        this.vmfView.setSpecialBtn_Listener(new ActionListener() {// Special VM
            public void actionPerformed(ActionEvent arg0) {
                vmfView.setStatus(vmfView.getChoiceMenuFrame(), false); 
                vmfView.clearRVMTxtVM();
                vmfView.setStatus(vmfView.getSVMMenuFrame(), true);
            }
        });

        this.vmfView.setVmNextBtn_Listener(new ActionListener() {//Button from asking VM deets to Item deets
            public void actionPerformed(ActionEvent arg0) {

                if (Integer.parseInt(vmfView.getRVMSlotNumTxt()) < 8 || Integer.parseInt(vmfView.getRVMSlotNumTxt()) > 10) {
                    vmfView.setVMspecsLbl("Only 8-10 slots are allowed!");
                } else {

                    String tempName = vmfView.getRVMNameTxt();
                    int tempSlot = Integer.parseInt(vmfView.getRVMSlotNumTxt().trim());
                    int tempMax = Integer.parseInt(vmfView.getRVMMaxItemTxt().trim());

                    vmfModelVM = new vmfModelVM(tempName, tempSlot, tempMax);

                    vmfView.setStatus(vmfView.getRvmMenuFrame(), false);
                    vmfView.setStatus(vmfView.getAddItemFrame(), true); 

                    boolean result = vmfModel.vmList.add(vmfModelVM);      
                    
                    if (result) {
                        vmfView.setVmSuccessLbl("Vending Machine successfully created");
                        vmfView.getFirstMenu().revalidate();
                        vmfView.getFirstMenu().repaint();
                    } else {
                        vmfView.setVmSuccessLbl("Vending Machine creation failed :(");
                        vmfView.getFirstMenu().revalidate();
                        vmfView.getFirstMenu().repaint();
                    }
                }
            }
        });

        this.vmfView.setAddBtnVM_Listener(new ActionListener() {//Button that sets and adds item to the machine
            public void actionPerformed(ActionEvent arg0) {       
                if (vmfView.getItemNameTxt().equals(null) || Integer.parseInt(vmfView.getItemPriceTxt()) <= 0 || 
                Integer.parseInt(vmfView.getItemCaloriesTxt()) <= 0) {
                    vmfView.setitemStatusLbl("Check your values!");

                } else {
                    
                    Item tempItem = new Item (vmfView.getItemNameTxt().trim(), 
                            Integer.parseInt(vmfView.getItemCaloriesTxt().trim()), Integer.parseInt(vmfView.getItemPriceTxt().trim()));
                    
                    Item[] itemList = new Item[Integer.parseInt(vmfView.getRVMMaxItemTxt().trim())];
                    for (int j = 0; j < Integer.parseInt(vmfView.getItemQuantityTxt()); j++){
                        itemList[j] = tempItem; 
                    }
                    ItemSlot temp = new ItemSlot(itemList, tempItem);
                    vmfModelVM.getSlotList()[vmfModelVM.getNumItems()] = temp;
    
                    boolean flag = (vmfModelVM.getSlotList()[vmfModelVM.getNumItems()] != null);
                    if (flag) {
                        vmfView.setitemStatusLbl("Item added!");
                        vmfModelVM.incrementNumItems();
                        vmfView.clearItemTxt();

                        if (vmfModelVM.slotList.length == vmfModelVM.getNumItems()) {
                            vmfView.setVisibleNextBtnVM(true);
                            vmfView.setVisibleAddBtnVM(false);
                            vmfView.getAddItemFrame().revalidate();
                            vmfView.getAddItemFrame().repaint();
                        }
                    } else {
                        vmfView.setitemStatusLbl("Item adding failed :(");
                    }
                }
            }
        });   
        
        this.vmfView.setNextBtnVM_Listener(new ActionListener() { //Button that redirects to main frame when creation is done
            public void actionPerformed(ActionEvent arg0) {
                vmfView.setStatus(vmfView.getAddItemFrame(), false);  
                vmfView.setStatus(vmfView.getFirstMenu(), true); 
            }
        });
    
        this.vmfView.setExitBtnVM_Listener(new ActionListener() {//Exit from testing vending features for RVM
            public void actionPerformed(ActionEvent arg0) {
                vmfView.setItemNameTxtVM("");
                vmfView.setStatus(vmfView.getTestVmFrame(), false);
                vmfView.setVmSuccessLbl("");
                vmfView.setStatus(vmfView.getFirstMenu(), true); 
            }
        });

        this.vmfView.setVMCoin1(new ActionListener() {//adds 1 1coin to user input
            public void actionPerformed(ActionEvent arg0){
                vmfModelVM.userInput.setCoin1(vmfModelVM.userInput.getCoin1() + 1);
                vmfView.setTotalPriceTextArea(String.valueOf(vmfModelVM.getUserInput().getTotalMoney())); 
                vmfView.getTestVmFrame().revalidate();
                vmfView.getTestVmFrame().repaint();  
            }
        });

        this.vmfView.setVMCoin5(new ActionListener() {//adds 1 5coin to user input
            public void actionPerformed(ActionEvent arg0){
                vmfModelVM.userInput.setCoin5(vmfModelVM.userInput.getCoin5() + 1);
                vmfView.setTotalPriceTextArea(String.valueOf(vmfModelVM.getUserInput().getTotalMoney())); 
                vmfView.getTestVmFrame().revalidate();
                vmfView.getTestVmFrame().repaint();  
            }
        });

        this.vmfView.setVMCoin10(new ActionListener() {//adds 1 10coin to user input
            public void actionPerformed(ActionEvent arg0){
                vmfModelVM.userInput.setCoin10(vmfModelVM.userInput.getCoin10() + 1);
                vmfView.setTotalPriceTextArea(String.valueOf(vmfModelVM.getUserInput().getTotalMoney())); 
                vmfView.getTestVmFrame().revalidate();
                vmfView.getTestVmFrame().repaint();  
            }
        });

        this.vmfView.setVMbill20(new ActionListener() {//adds 1 20bill to user input
            public void actionPerformed(ActionEvent arg0){
                vmfModelVM.userInput.setBill20(vmfModelVM.userInput.getBill20() + 1);
                vmfView.setTotalPriceTextArea(String.valueOf(vmfModelVM.getUserInput().getTotalMoney())); 
                vmfView.getTestVmFrame().revalidate();
                vmfView.getTestVmFrame().repaint();  
            }
        });

        this.vmfView.setVMbill50(new ActionListener() {//adds 1 50bill to user input
            public void actionPerformed(ActionEvent arg0){
                vmfModelVM.userInput.setBill50(vmfModelVM.userInput.getBill50() + 1);
                vmfView.setTotalPriceTextArea(String.valueOf(vmfModelVM.getUserInput().getTotalMoney())); 
                vmfView.getTestVmFrame().revalidate();
                vmfView.getTestVmFrame().repaint();  
            }
        });

        this.vmfView.setVMbill100(new ActionListener() {//adds 1 100bill to user input
            public void actionPerformed(ActionEvent arg0){
                vmfModelVM.userInput.setBill100(vmfModelVM.userInput.getBill100() + 1);
                vmfView.setTotalPriceTextArea(String.valueOf(vmfModelVM.getUserInput().getTotalMoney())); 
                vmfView.getTestVmFrame().revalidate();
                vmfView.getTestVmFrame().repaint();  
            }
        });

        this.vmfView.setVMupdateQuantityBtn_Listener(new ActionListener() {//Update Qty Button in VM Maintenance
            public void actionPerformed(ActionEvent arg0) {
                String name = vmfView.getVMmaintenanceNameTxt1();
                int found = -1;
                for (int i = 0; i < vmfModelVM.slotList.length; i++) {
                    if (name.equals(vmfModelVM.getSlotList()[i].getItem().getName())) {
                        found = 0;
                        if (vmfModelVM.getSlotList()[i].getQuantity(vmfModelVM.getMaxItems()) + Integer.parseInt(vmfView.getVMmaintenanceQuantityTxt()) > vmfModelVM.getMaxItems()) {
                            vmfView.setVMmaintenanceNameTxt1Lbl("Over Limit!");
                            vmfView.setVMmaintenanceNameTxt2("");
                            vmfView.setVMmaintenanceQuantityTxt("");
                            vmfView.getMaintenanceFrameVM().revalidate();
                            vmfView.getMaintenanceFrameVM().repaint();  
                        } else {
                            //Integer.parseInt(vmfView.getVMmaintenanceQuantityTxt());
                            boolean result = vmfModelVM.getSlotList()[i].addStock(Integer.parseInt(vmfView.getVMmaintenanceQuantityTxt()), vmfModelVM.getMaxItems());
                            if (result) {
                                vmfView.setVMmaintenanceNameTxt1Lbl("Stocking success!");
                                vmfView.setVMmaintenanceNameTxt2("");
                                vmfView.setVMmaintenanceQuantityTxt("");
                                vmfView.setVMslotListTxt(vmfModelVM.getInventoryList());
                                vmfModelVM.transactionList.clear();
                                vmfModelVM.setStartInventory(vmfModelVM.getSlotList());
                                vmfView.getMaintenanceFrameVM().revalidate();
                                vmfView.getMaintenanceFrameVM().repaint(); 

                            } else {
                                vmfView.setVMmaintenanceNameTxt1Lbl("Failed!");
                                vmfView.setVMmaintenanceNameTxt2("");
                                vmfView.setVMmaintenanceQuantityTxt("");
                                vmfView.getMaintenanceFrameVM().revalidate();
                                vmfView.getMaintenanceFrameVM().repaint(); 
                            }
                        }
                    }
                }
                

                if (found == -1) {
                    vmfView.setVMmaintenanceNameTxt1Lbl("Error! ->this button is sposed to b qty");
                    vmfView.setVMmaintenanceNameTxt2("");
                    vmfView.setVMmaintenanceQuantityTxt("");
                    vmfView.getMaintenanceFrameVM().revalidate();
                    vmfView.getMaintenanceFrameVM().repaint();  
                }
            }
        });

        this.vmfView.setVMupdatePriceBtn_Listener(new ActionListener() {//Update Price Button in VM Maintenance
            public void actionPerformed(ActionEvent arg0) {
                String name = vmfView.getVMmaintenanceNameTxt2();
                int found = -1;
                for (int i = 0; i < vmfModelVM.slotList.length; i++) {
                    if (name.equals(vmfModelVM.getSlotList()[i].getItem().getName())) {
                        found = 0;
                        if (Integer.parseInt(vmfView.getVMmaintenanceNewPriceTxt().trim()) > 0) {
                            vmfModelVM.getSlotList()[i].getItem().setPrice(Integer.parseInt(vmfView.getVMmaintenanceNewPriceTxt().trim()));
                            vmfView.setVMmaintenanceNameTxt2Lbl("Price updated!");
                            vmfView.setVMmaintenanceNameTxt1("");
                            vmfView.setVMmaintenanceNewPriceTxt("");
                            vmfView.setVMslotListTxt(vmfModelVM.getInventoryList());
                            vmfView.getMaintenanceFrameVM().revalidate();
                            vmfView.getMaintenanceFrameVM().repaint();  
                        }
                    }
                }

                if (found == -1) {
                    vmfView.setVMmaintenanceNameTxt2Lbl("Error!");
                    vmfView.setVMmaintenanceNameTxt1("");
                    vmfView.setVMmaintenanceNewPriceTxt("");
                    vmfView.getMaintenanceFrameVM().revalidate();
                    vmfView.getMaintenanceFrameVM().repaint();  
                }
            }
        });

        this.vmfView.setVMcollectBtnBtn_Listener(new ActionListener() {//Collect Money in VM Maintenance
            public void actionPerformed(ActionEvent arg0) {
                vmfView.setRVMtextArea("You have received: " + vmfModelVM.getMoneyBox().getTotalMoney());
                vmfModelVM.emptyMoney(vmfModelVM.getMoneyBox());

                vmfView.setVMtotalMoneyLblTxt(String.valueOf(vmfModelVM.getMoneyBox().getTotalMoney())); 
                vmfView.getMaintenanceFrameVM().revalidate();
                vmfView.getMaintenanceFrameVM().repaint();  
                vmfView.setStatus(vmfView.getDispenseRVMItemFrame(), true);
            }
        });

        this.vmfView.setVMcoin1MT_Listener(new ActionListener() {//adds 1 1coin to the machine
            public void actionPerformed(ActionEvent arg0) {
                vmfModelVM.moneyBox.setCoin1(vmfModelVM.moneyBox.getCoin1() + 1);
                vmfView.setVMtotalMoneyLblTxt(String.valueOf(vmfModelVM.getMoneyBox().getTotalMoney())); 
                
                vmfView.getMaintenanceFrameVM().revalidate();
                vmfView.getMaintenanceFrameVM().repaint();  
            }
        });

        this.vmfView.setVMcoin5MT_Listener(new ActionListener() {//adds 1 5coin to the machine
            public void actionPerformed(ActionEvent arg0) {
                vmfModelVM.moneyBox.setCoin5(vmfModelVM.moneyBox.getCoin5() + 1);
                vmfView.setVMtotalMoneyLblTxt(String.valueOf(vmfModelVM.getMoneyBox().getTotalMoney())); 
                vmfView.getMaintenanceFrameVM().revalidate();
                vmfView.getMaintenanceFrameVM().repaint();  
            }
        });

        this.vmfView.setVMcoin10MT_Listener(new ActionListener() {//adds 1 10coin to the machine
            public void actionPerformed(ActionEvent arg0) {
                vmfModelVM.moneyBox.setCoin10(vmfModelVM.moneyBox.getCoin10() + 1);
                vmfView.setVMtotalMoneyLblTxt(String.valueOf(vmfModelVM.getMoneyBox().getTotalMoney())); 
                vmfView.getMaintenanceFrameVM().revalidate();
                vmfView.getMaintenanceFrameVM().repaint();  
            }
        });

        this.vmfView.setVMbill20MT_Listener(new ActionListener() {//adds 1 20bill to the machine
            public void actionPerformed(ActionEvent arg0) {
                vmfModelVM.moneyBox.setBill20(vmfModelVM.moneyBox.getBill20() + 1);
                vmfView.setVMtotalMoneyLblTxt(String.valueOf(vmfModelVM.getMoneyBox().getTotalMoney())); 
                vmfView.getMaintenanceFrameVM().revalidate();
                vmfView.getMaintenanceFrameVM().repaint();  
            }
        });

        this.vmfView.setVMbill50MT_Listener(new ActionListener() {//adds 1 50bill to the machine
            public void actionPerformed(ActionEvent arg0) {
                vmfModelVM.moneyBox.setBill50(vmfModelVM.moneyBox.getBill50() + 1);
                vmfView.setVMtotalMoneyLblTxt(String.valueOf(vmfModelVM.getMoneyBox().getTotalMoney())); 
                vmfView.getMaintenanceFrameVM().revalidate();
                vmfView.getMaintenanceFrameVM().repaint();  
            }
        });

        this.vmfView.setVMbill100MT_Listener(new ActionListener() {//adds 1 100bill to the machine
            public void actionPerformed(ActionEvent arg0) {
                vmfModelVM.moneyBox.setBill100(vmfModelVM.moneyBox.getBill100() + 1);
                vmfView.setVMtotalMoneyLblTxt(String.valueOf(vmfModelVM.getMoneyBox().getTotalMoney())); 
                vmfView.getMaintenanceFrameVM().revalidate();
                vmfView.getMaintenanceFrameVM().repaint();  
            }
        });

        this.vmfView.setVMmaintenanceBackbtn_Listener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                vmfView.setStatus(vmfView.getMaintenanceFrameVM(), false);
                vmfView.setStatus(vmfView.getFirstMenu(), true);
            }
        });

        this.vmfView.setVMmaintenanceTransactionBtn_Listener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){

                vmfView.setRVMTransactionsTextArea(vmfModelVM.printTransactionSummary());
                vmfView.setStatus(vmfView.getRVMTransactions(), true); 
                vmfView.getRVMTransactions().revalidate();
                vmfView.getRVMTransactions().repaint();  
            }
        });
    
    }
}
