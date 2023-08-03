/**
 * vmfController that is middle of model and view
 * @author Ian Gabriel S. De Jesus & Sean Riley P. Veracruz
 * @version %I% %G%
 * @since 1.0
 */

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

        //TODO: IMPLEMENT INSTANCE OF
        this.vmfView.setVMTestBtn_Listener(new ActionListener() {//Test Features for both RVM and SVM
            public void actionPerformed(ActionEvent arg0) {
                int found = 0, index = -1;;
                for (int i = 0; i < vmfModel.vmList.size(); i++) {
                    if (vmfView.getVMNameTxt().equals(vmfModel.vmList.get(i).getName())) {
                        vmfView.setVMupdateLbl(vmfModel.vmList.get(i).getName());
                        found = 1;
                        index = i;
                        if (vmfModel.vmList.get(index) instanceof vmfModelSVM) { //if vm is an svm 
                            vmfModelSVM svmObject = (vmfModelSVM) vmfModel.vmList.get(i);
                            //TODO: INSERT ASSIGNMENT OF ITEMS AND ADDONS HERE
                            vmfView.setStatus(vmfView.getVmListFrame(), false);
                            vmfView.setStatus(vmfView.getcustomSVMMenuFrame(), true);
                            
                        } else { //if vm is a vm 
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
                            vmfView.getTestVmFrame().revalidate();
                            vmfView.getTestVmFrame().repaint(); 
                            
                            vmfView.setStatus(vmfView.getVmListFrame(), false);
                            vmfView.setStatus(vmfView.getTestVmFrame(), true);
                        }                        
                    }   
                }
                if (found == -1) {
                    vmfView.setVMupdateLbl("Vending Machine not found!");
                    vmfView.getFirstMenu().revalidate();
                    vmfView.getFirstMenu().repaint();
                }   
            }
        });

        this.vmfView.setcustomSVMreturnBtn_Listener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0){
                vmfView.setStatus(vmfView.getcustomSVMMenuFrame(), false);
                vmfView.setStatus(vmfView.getFirstMenu(), true);

            }
        });
        
        //TODO: SVM MAINTENANCE
        this.vmfView.setVMMtBtn_Listener(new ActionListener() { //Perform Maintenance VM and SVM
            public void actionPerformed(ActionEvent arg0) {
                int found = -1;
                for (int i = 0; i < vmfModel.vmList.size(); i++) {
                    if (vmfView.getVMNameTxt().equals(vmfModel.vmList.get(i).getName())) {
                        vmfView.setVMupdateLbl(vmfModel.vmList.get(i).getName());
                        found = 1;

                        if (vmfModel.vmList.get(i) instanceof vmfModelSVM) {  //SVM MAINTENANCE
                            //TODO: SVM MAINTENANCE
                            vmfView.setNameVMLbl(vmfModel.vmList.get(i).getName());
                            vmfView.getFirstMenu().revalidate();
                            vmfView.getFirstMenu().repaint();

                            vmfView.setVMtotalMoneyLblTxt(String.valueOf(vmfModel.vmList.get(i).getMoneyBox().getTotalMoney()));
                            vmfView.setVMslotListTxt(vmfModel.vmList.get(i).getInventoryList());

                            vmfView.setStatus(vmfView.getVmListFrame(), false);
                            vmfView.setStatus(vmfView.getMaintenanceFrameVM(), true);
                        }

                        } else { //RVM MAINTENANCE
                            vmfView.setNameVMLbl(vmfModel.vmList.get(i).getName());
                            vmfView.getFirstMenu().revalidate();
                            vmfView.getFirstMenu().repaint();

                            vmfView.setVMtotalMoneyLblTxt(String.valueOf(vmfModel.vmList.get(i).getMoneyBox().getTotalMoney()));
                            vmfView.setVMslotListTxt(vmfModel.vmList.get(i).getInventoryList());

                            vmfView.setStatus(vmfView.getVmListFrame(), false);
                            vmfView.setStatus(vmfView.getMaintenanceFrameVM(), true);
                        }
                        
                    }   
                
                if (found == -1) {
                    vmfView.setVMupdateLbl("Vending Machine not found!");
                    vmfView.getFirstMenu().revalidate();
                    vmfView.getFirstMenu().repaint();
                }
            }
        });
        
        this.vmfView.setExitBtn_Listener(new ActionListener() {//Exit
            public void actionPerformed(ActionEvent arg0){
                vmfView.setStatus(vmfView.getFirstMenu(), false); 
            }
        });

        this.vmfView.setBuyBtnVM_Listener(new ActionListener() {//Buy button from vending machine
            public void actionPerformed(ActionEvent arg0) {
                int index = -1, vmIndex = -1;
                String name = vmfView.getItemNameTxtVM();
                index = vmfModel.getVmIndex(vmfView.getNameVMLbl());
                for (int i = 0; i < vmfModel.vmList.get(vmIndex).getSlotList().length; i++) {
                    if (name.equals(vmfModel.vmList.get(vmIndex).getSlotList()[i].getItem().getName())) index = i;
                }

                if (index == -1) {
                    vmfView.setRVMtextArea("Item not found!");
                    vmfView.setTotalPriceTextArea("0"); 
                    vmfView.getTestVmFrame().revalidate();
                    vmfView.getTestVmFrame().repaint();  
                    vmfModel.vmList.get(vmIndex).emptyMoney(vmfModel.vmList.get(vmIndex).getUserInput()); //resets user inputted money value 

                } else if (vmfModel.vmList.get(vmIndex).isItemAvail(vmfModel.vmList.get(vmIndex).getSlotList()[index].getItem().getName(), vmfModel.vmList.get(vmIndex).getMaxItems(), vmfModel.vmList.get(vmIndex).getSlotList()) == false){
                    vmfView.setRVMtextArea("Item is not available!");
                    vmfView.setTotalPriceTextArea("0"); 
                    vmfView.getTestVmFrame().revalidate();
                    vmfView.getTestVmFrame().repaint(); 
                    vmfModel.vmList.get(vmIndex).emptyMoney(vmfModel.vmList.get(vmIndex).getUserInput()); //resets user inputted money value 

                } else if (vmfModel.vmList.get(vmIndex).validChange(vmfModel.vmList.get(vmIndex).getSlotList()[index].getItem().getName()) != null) {
                    vmfView.setRVMtextArea(vmfModel.vmList.get(vmIndex).validChange(vmfModel.vmList.get(vmIndex).getSlotList()[index].getItem().getName()));
                    vmfView.setTotalPriceTextArea("0"); 
                    vmfView.getTestVmFrame().revalidate();
                    vmfView.getTestVmFrame().repaint(); 
                    vmfModel.vmList.get(vmIndex).emptyMoney(vmfModel.vmList.get(vmIndex).getUserInput()); //resets user inputted money value 

                } else {      
                    int updateFrame = vmfModel.vmList.get(vmIndex).dispenseItem(name, vmfModel.vmList.get(vmIndex).getSlotList()); //dispenses item 
                    switch (updateFrame) {
                        case 0:
                            vmfView.setVMslotQty1(String.valueOf(vmfModel.vmList.get(vmIndex).getSlotList()[updateFrame].getQuantity(vmfModel.vmList.get(vmIndex).getMaxItems())));
                            break;
                        case 1:
                            vmfView.setVMslotQty2(String.valueOf(vmfModel.vmList.get(vmIndex).getSlotList()[updateFrame].getQuantity(vmfModel.vmList.get(vmIndex).getMaxItems())));
                            break;
                        case 2: 
                            vmfView.setVMslotQty3(String.valueOf(vmfModel.vmList.get(vmIndex).getSlotList()[updateFrame].getQuantity(vmfModel.vmList.get(vmIndex).getMaxItems())));
                            break;
                        case 3:
                            vmfView.setVMslotQty4(String.valueOf(vmfModel.vmList.get(vmIndex).getSlotList()[updateFrame].getQuantity(vmfModel.vmList.get(vmIndex).getMaxItems())));
                            break;
                        case 4:
                            vmfView.setVMslotQty5(String.valueOf(vmfModel.vmList.get(vmIndex).getSlotList()[updateFrame].getQuantity(vmfModel.vmList.get(vmIndex).getMaxItems())));
                            break;
                        case 5:
                            vmfView.setVMslotQty6(String.valueOf(vmfModel.vmList.get(vmIndex).getSlotList()[updateFrame].getQuantity(vmfModel.vmList.get(vmIndex).getMaxItems())));
                            break;
                        case 6:
                            vmfView.setVMslotQty7(String.valueOf(vmfModel.vmList.get(vmIndex).getSlotList()[updateFrame].getQuantity(vmfModel.vmList.get(vmIndex).getMaxItems())));
                            break;
                        case 7:
                            vmfView.setVMslotQty8(String.valueOf(vmfModel.vmList.get(vmIndex).getSlotList()[updateFrame].getQuantity(vmfModel.vmList.get(vmIndex).getMaxItems())));
                            break;
                        case 8:
                            vmfView.setVMslotQty9(String.valueOf(vmfModel.vmList.get(vmIndex).getSlotList()[updateFrame].getQuantity(vmfModel.vmList.get(vmIndex).getMaxItems())));
                            break;
                        case 9:
                            vmfView.setVMslotQty10(String.valueOf(vmfModel.vmList.get(vmIndex).getSlotList()[updateFrame].getQuantity(vmfModel.vmList.get(vmIndex).getMaxItems())));
                            break;
                    }
                    vmfView.setTotalPriceTextArea("0"); 
                    vmfView.getTestVmFrame().revalidate();
                    vmfView.getTestVmFrame().repaint(); 
                    vmfView.setRVMtextArea("You have received [" + vmfModel.vmList.get(vmIndex).getSlotList()[index].getItem().getName() + "]" + "\nChange: " + vmfModel.vmList.get(vmIndex).dispenseChange(name));
                    vmfModel.vmList.get(vmIndex).createTransaction(name);//creates a transaction 
                    vmfModel.vmList.get(vmIndex).emptyMoney(vmfModel.vmList.get(vmIndex).getUserInput()); //resets user inputted money value 
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
                
                if (Integer.parseInt(vmfView.getRVMMaxItemTxt()) <= 0 || Integer.parseInt(vmfView.getRVMSlotNumTxt()) < 0) {
                    vmfView.setVMspecsLbl("Only positive values!");

                } else if (Integer.parseInt(vmfView.getRVMSlotNumTxt()) > 10 || Integer.parseInt(vmfView.getRVMSlotNumTxt()) > 10) { //TODO revert other >10 to < 8
                    vmfView.setVMspecsLbl("Only 8-10 slots are allowed!");
                    
                } else if (vmfView.getRVMNameTxt().equals("")) {
                    vmfView.setVMspecsLbl("Name cannot be empty!");
                }
                else {

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

        //TODO: TEST
        this.vmfView.setNextBtnSVM_Listener(new ActionListener() {//Button from asking SVM deets to Item deets
            public void actionPerformed(ActionEvent arg0) {
                
                if (vmfView.getsvmMenuNameTxt().isEmpty() || vmfView.getsvmMenuSlotNumTxt().isEmpty() ||
                vmfView.getsvmMenuAddOnTxt().isEmpty() || vmfView.getsvmMenuMaxItemTxt().isEmpty() || 
                vmfView.getsvmMenuCustomTxt().isEmpty()) {
                    vmfView.setsvmMenuCheckLbl("All Fields must be filled!");
                } else {
                    String tempName = vmfView.getsvmMenuNameTxt();
                    int tempSlotNum = Integer.parseInt(vmfView.getsvmMenuSlotNumTxt());
                    int tempAddOnNum = Integer.parseInt(vmfView.getsvmMenuAddOnTxt());
                    int tempMax = Integer.parseInt(vmfView.getsvmMenuMaxItemTxt());
                    String customName = vmfView.getsvmMenuCustomTxt();

                    if (tempSlotNum <= 0 || tempAddOnNum <= 0 || tempMax <= 0) {
                        vmfView.setsvmMenuCheckLbl("Only positive values!");
                    } else if (tempSlotNum <= 0 || tempAddOnNum <= 0) {
                        vmfView.setsvmMenuCheckLbl("Only 8-10 slots are allowed!");
                    } else {
                        vmfModelSVM = new vmfModelSVM(tempName, tempSlotNum, tempMax, tempAddOnNum, customName);

                        boolean result = vmfModel.vmList.add(vmfModelSVM);      
                        
                        vmfView.setStatus(vmfView.getSVMMenuFrame(), false);
                        vmfView.setStatus(vmfView.getsvmAddItemsFrame(), true);

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
            }
        });

        this.vmfView.setAddBtnVM_Listener(new ActionListener() {//Button that sets and adds item to the rvm machine
            public void actionPerformed(ActionEvent arg0) {      
                int vmIndex = 0; 
                int found = 0;
                if (vmfView.getItemNameTxt().equals("") || Integer.parseInt(vmfView.getItemPriceTxt()) <= 0 || 
                Integer.parseInt(vmfView.getItemCaloriesTxt()) <= 0) {
                    vmfView.setitemStatusLbl("Check your values!");

                } else {
                    vmIndex = vmfModel.getVmIndex(vmfView.getRVMNameTxt());
                    Item tempItem = new Item (vmfView.getItemNameTxt().trim(), 
                            Integer.parseInt(vmfView.getItemCaloriesTxt().trim()), Integer.parseInt(vmfView.getItemPriceTxt().trim()));
                    
                    Item[] itemList = new Item[Integer.parseInt(vmfView.getRVMMaxItemTxt().trim())];
                    for (int j = 0; j < Integer.parseInt(vmfView.getItemQuantityTxt()); j++){
                        itemList[j] = tempItem; 
                    }
                    ItemSlot temp = new ItemSlot(itemList, tempItem);
                    if(vmfModelVM.getSlotList().length > 0){
                            for (int i = 0; i < vmfModelVM.getSlotList().length; i++) {
                                if (vmfModelVM.getSlotList()[i] != null){
                                    if (vmfModelVM.getSlotList()[i].getItem().getName().equals(vmfView.getItemNameTxt().trim())) {
                                    found = 1;
                                    }
                                }
                            }
                        }
                        
                    if (found == 1)
                        vmfView.setitemStatusLbl("Item name already exists!");
                    else{
                        vmfModel.vmList.get(vmIndex).getSlotList()[vmfModel.vmList.get(vmIndex).getNumItems()] = temp;
    
                        boolean flag = (vmfModel.vmList.get(vmIndex).getSlotList()[vmfModel.vmList.get(vmIndex).getNumItems()] != null);
                        if (flag) {
                            vmfView.setitemStatusLbl("Item added!");
                            vmfModel.vmList.get(vmIndex).incrementNumItems();
                            vmfView.clearItemTxt();

                            if (vmfModel.vmList.get(vmIndex).slotList.length == vmfModel.vmList.get(vmIndex).getNumItems()) {
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
            }
        });   
        
        //TODO: FINISHED FUNCTION(?)
        this.vmfView.svmAddBtnSVMMENUItem_Listener(new ActionListener() {//Button that sets and adds item to the svm
            public void actionPerformed(ActionEvent arg0) {
                int vmIndex = 0;
                int found = 0;
                if (vmfView.getsvmItemNameTxtMENU().isEmpty() || vmfView.getsvmItemPriceTxtMENU().isEmpty() ||
                vmfView.getsvmItemCaloriesTxtMENU().isEmpty() || vmfView.getsvmItemQuantityTxtMENU().isEmpty() ||
                vmfView.getsvmItemPrepTxtMENU().isEmpty()) {
                vmfView.setsvmItemStatusLblMENU("All Fields must be filled!");
                } else {
                    vmIndex = vmfModel.getVmIndex(vmfView.getsvmMenuNameTxt());//TODO 
                    String itemName = vmfView.getsvmItemNameTxtMENU();
                    int itemPrice = Integer.parseInt(vmfView.getsvmItemPriceTxtMENU());
                    int itemCalories = Integer.parseInt(vmfView.getsvmItemCaloriesTxtMENU());
                    int itemQty = Integer.parseInt(vmfView.getsvmItemQuantityTxtMENU());
                    String itemPrep = vmfView.getsvmItemPrepTxtMENU();

                    
                    //(vmfModelSVM) vmfModel.vmList.get(vmIndex).getPrepItemList()[vmfModel.vmList.get(vmIndex).getNumItems()] = ;                
                    if (itemPrice <= 0 || itemCalories <= 0 || itemQty <= 0) {
                        vmfView.setsvmItemStatusLblMENU("Only Positive values!");
                    } else {
                        if(vmfModelSVM.getSlotList().length > 0){
                            for (int i = 0; i < vmfModelSVM.getSlotList().length; i++) {
                                if (vmfModelSVM.getSlotList()[i] != null){
                                    if (vmfModelSVM.getSlotList()[i].getItem().getName().equals(itemName)) {
                                    found = 1;
                                    }
                                }
                            }
                        }
                        
                        if (found == 1)
                            vmfView.setsvmItemStatusLblMENU("Item name already exists!");
                        else{
                            Item tempItem = new Item(itemName, itemCalories, itemPrice);
                            Item[] itemList = new Item[vmfModelSVM.getMaxItems()];
                            for(int j = 0; j < itemQty; j++){
                                itemList[j] = tempItem;
                            }
                            ItemSlot temp = new ItemSlot(itemList, tempItem);
                            vmfModel.vmList.get(vmIndex).getSlotList()[vmfModel.vmList.get(vmIndex).getNumItems()] = temp;
                            if(vmfModel.vmList.get(vmIndex) instanceof vmfModelSVM){
                                vmfModelSVM svmObject = (vmfModelSVM) vmfModel.vmList.get(vmIndex);
                                svmObject.getPrepItemList()[vmfModel.vmList.get(vmIndex).getNumItems()] = itemPrep;
                            }

                            boolean flag = (vmfModel.vmList.get(vmIndex).getSlotList()[vmfModel.vmList.get(vmIndex).getNumItems()] != null);
                            if (flag) {
                                vmfView.setsvmItemStatusLblMENU("Item added!");
                                vmfModel.vmList.get(vmIndex).incrementNumItems();
                                vmfView.clearSVMItemTxt();

                                if (vmfModel.vmList.get(vmIndex).slotList.length == vmfModel.vmList.get(vmIndex).getNumItems()) {
                                    vmfView.setsvmNextBtnSVMMENUItem(true);
                                    vmfView.setsvmAddBtnSVMMENUItem(false);
                                    vmfView.getsvmAddItemsFrame().revalidate();
                                    vmfView.getsvmAddItemsFrame().repaint();
                                    }
                                } else {
                                    vmfView.setsvmItemStatusLblMENU("Item adding failed :(");
                                }
                        }
                    }
                } 
            }
        });

        this.vmfView.svmNextBtnSVMMENUItem_Listener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0){
                vmfView.setStatus(vmfView. getsvmAddItemsFrame(), false);
                vmfView.setStatus(vmfView.getsvmAddAddOnFrame(), true);
            }
        });

        this.vmfView.addOnsvmAddBtnSVMMENU_Listener(new ActionListener() {//Button that sets and adds add-ons to the svm
            public void actionPerformed(ActionEvent arg0) {
                int vmIndex = 0;
                int found = 0;
                if (vmfView.getsvmAddOnNameTxtMENU().isEmpty() || vmfView.getsvmAddOnPriceTxtMENU().isEmpty() ||
                vmfView.getsvmAddOnCaloriesTxtMENU().isEmpty() || vmfView.getsvmAddOnQuantityTxtMENU().isEmpty() ||
                vmfView.getsvmAddOnPrepTxtMENU().isEmpty()) {
                vmfView.setsvmAddOnStatusLblMENU("All Fields must be filled!"); //TODO add the method to view
                } else {
                    vmIndex = vmfModel.getVmIndex(vmfView.getsvmMenuNameTxt());//TODO 
                    String AddOnName = vmfView.getsvmAddOnNameTxtMENU();
                    int AddOnPrice = Integer.parseInt(vmfView.getsvmAddOnPriceTxtMENU());
                    int AddOnCalories = Integer.parseInt(vmfView.getsvmAddOnCaloriesTxtMENU());
                    int AddOnQty = Integer.parseInt(vmfView.getsvmAddOnQuantityTxtMENU());
                    String AddOnPrep = vmfView.getsvmAddOnPrepTxtMENU();

                    
                    //(vmfModelSVM) vmfModel.vmList.get(vmIndex).getPrepItemList()[vmfModel.vmList.get(vmIndex).getNumItems()] = ;                
                    if (AddOnPrice <= 0 || AddOnCalories <= 0 || AddOnQty <= 0) {
                        vmfView.setsvmAddOnStatusLblMENU("Only Positive values!");
                    } else {
                        if(vmfModelSVM.getAddOnSlotList().length > 0){
                            for (int i = 0; i < vmfModelSVM.getAddOnSlotList().length; i++) {
                                if (vmfModelSVM.getAddOnSlotList()[i] != null){
                                    if (vmfModelSVM.getAddOnSlotList()[i].getItem().getName().equals(AddOnName)) {
                                    found = 1;
                                    }
                                }
                            }
                        }
                        
                        if (found == 1)
                            vmfView.setsvmAddOnStatusLblMENU("Add-on name already exists!");
                        else{
                            Item tempAddOn= new Item(AddOnName, AddOnCalories, AddOnPrice);
                            Item[] itemList = new Item[vmfModelSVM.getMaxItems()];
                            for(int j = 0; j < AddOnQty; j++){
                                itemList[j] = tempAddOn;
                            }
                            ItemSlot temp = new ItemSlot(itemList, tempAddOn);
                            //vmfModel.vmList.get(vmIndex).getAddOnSlotList()[vmfModel.vmList.get(vmIndex).getNumItems()] = temp; //TODO check if correct
                            if(vmfModel.vmList.get(vmIndex) instanceof vmfModelSVM){
                                vmfModelSVM svmObject = (vmfModelSVM) vmfModel.vmList.get(vmIndex);
                                svmObject.getAddOnSlotList()[svmObject.getNumAddOn() - 1] = temp; //switch to here, tried -1 need to check tho
                                svmObject.getPrepItemList()[svmObject.getNumAddOn() -1] = AddOnPrep;
                                boolean flag = (svmObject.getAddOnSlotList()[svmObject.getNumAddOn() - 1] != null);
                                if (flag) {
                                vmfView.setsvmAddOnStatusLblMENU("Add-on added!");

                                svmObject.incrementNumAddOnCreated();
                                vmfView.clearSVMAddOnTxt();

                                if (svmObject.getAddOnSlotList().length == svmObject.getNumAddOn()) {
                                    vmfView.setVisiblesvmNextBtnSVMMENU(true);
                                    vmfView.setVisibleaddOnsvmAddBtnSVMMENU(false);
                                    vmfView.getsvmAddAddOnFrame().revalidate();
                                    vmfView.getsvmAddAddOnFrame().repaint();
                                    
                                    System.out.println(svmObject.getAddOnList());
                                    }
                                } else {
                                    vmfView.setsvmAddOnStatusLblMENU("Add-on adding failed :(");
                                }
                            }

                            
                        }
                    }
                } 
            }
        });

        this.vmfView.addOnsvmNextBtnSVMMENU_Listener(new ActionListener() { //Button that redirects to main frame when creation of rvm is done
            public void actionPerformed(ActionEvent arg0) {
                vmfView.setStatus(vmfView.getsvmAddAddOnFrame(), false);  
                vmfView.setStatus(vmfView.getFirstMenu(), true); 
            }
        });
        this.vmfView.setNextBtnVM_Listener(new ActionListener() { //Button that redirects to main frame when creation of rvm is done
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
                int vmIndex = vmfModel.getVmIndex(vmfView.getVMupdateLbl());
                vmfModel.vmList.get(vmIndex).userInput.setCoin1(vmfModel.vmList.get(vmIndex).userInput.getCoin1() + 1);
                vmfView.setTotalPriceTextArea(String.valueOf(vmfModel.vmList.get(vmIndex).getUserInput().getTotalMoney())); 
                vmfView.getTestVmFrame().revalidate();
                vmfView.getTestVmFrame().repaint();  
            }
        });

        this.vmfView.setVMCoin5(new ActionListener() {//adds 1 5coin to user input
            public void actionPerformed(ActionEvent arg0){
                int vmIndex = vmfModel.getVmIndex(vmfView.getVMupdateLbl());
                vmfModel.vmList.get(vmIndex).userInput.setCoin5(vmfModel.vmList.get(vmIndex).userInput.getCoin5() + 1);
                vmfView.setTotalPriceTextArea(String.valueOf(vmfModel.vmList.get(vmIndex).getUserInput().getTotalMoney())); 
                vmfView.getTestVmFrame().revalidate();
                vmfView.getTestVmFrame().repaint();  
            }
        });

        this.vmfView.setVMCoin10(new ActionListener() {//adds 1 10coin to user input
            public void actionPerformed(ActionEvent arg0){
                int vmIndex = vmfModel.getVmIndex(vmfView.getVMupdateLbl());
                vmfModel.vmList.get(vmIndex).userInput.setCoin10(vmfModel.vmList.get(vmIndex).userInput.getCoin10() + 1);
                vmfView.setTotalPriceTextArea(String.valueOf(vmfModel.vmList.get(vmIndex).getUserInput().getTotalMoney())); 
                vmfView.getTestVmFrame().revalidate();
                vmfView.getTestVmFrame().repaint();  
            }
        });

        this.vmfView.setVMbill20(new ActionListener() {//adds 1 20bill to user input
            public void actionPerformed(ActionEvent arg0){
                int vmIndex = vmfModel.getVmIndex(vmfView.getVMupdateLbl());             
                vmfModel.vmList.get(vmIndex).userInput.setBill20(vmfModel.vmList.get(vmIndex).userInput.getBill20() + 1);
                vmfView.setTotalPriceTextArea(String.valueOf(vmfModel.vmList.get(vmIndex).getUserInput().getTotalMoney())); 
                vmfView.getTestVmFrame().revalidate();
                vmfView.getTestVmFrame().repaint();  
            }
        });

        this.vmfView.setVMbill50(new ActionListener() {//adds 1 50bill to user input
            public void actionPerformed(ActionEvent arg0){
                int vmIndex = vmfModel.getVmIndex(vmfView.getVMupdateLbl());          
                vmfModel.vmList.get(vmIndex).userInput.setBill50(vmfModel.vmList.get(vmIndex).userInput.getBill50() + 1);
                vmfView.setTotalPriceTextArea(String.valueOf(vmfModel.vmList.get(vmIndex).getUserInput().getTotalMoney())); 
                vmfView.getTestVmFrame().revalidate();
                vmfView.getTestVmFrame().repaint();  
            }
        });

        this.vmfView.setVMbill100(new ActionListener() {//adds 1 100bill to user input
            public void actionPerformed(ActionEvent arg0){
                int vmIndex = vmfModel.getVmIndex(vmfView.getVMupdateLbl());          
                vmfModel.vmList.get(vmIndex).userInput.setBill100(vmfModel.vmList.get(vmIndex).userInput.getBill100() + 1);
                vmfView.setTotalPriceTextArea(String.valueOf(vmfModel.vmList.get(vmIndex).getUserInput().getTotalMoney())); 
                vmfView.getTestVmFrame().revalidate();
                vmfView.getTestVmFrame().repaint();  
            }
        });

        this.vmfView.setVMupdateQuantityBtn_Listener(new ActionListener() {//Update Qty Button in VM Maintenance
            public void actionPerformed(ActionEvent arg0) {
                int vmIndex = vmfModel.getVmIndex(vmfView.getVMupdateLbl());
                //TODO: FIND A WAY TO ACCESS THE ADDONSLOT LIST
                String name = vmfView.getVMmaintenanceNameTxt1();
                int found = -1;
                if (vmfModel.vmList.get(vmIndex) instanceof vmfModelSVM) {

                }
                for (int i = 0; i < vmfModel.vmList.get(vmIndex).slotList.length; i++) {
                    if (name.equals(vmfModel.vmList.get(vmIndex).getSlotList()[i].getItem().getName())) {
                        found = 0;
                        if (vmfModel.vmList.get(vmIndex).getSlotList()[i].getQuantity(vmfModel.vmList.get(vmIndex).getMaxItems()) + Integer.parseInt(vmfView.getVMmaintenanceQuantityTxt()) > vmfModel.vmList.get(vmIndex).getMaxItems()) {
                            vmfView.setVMmaintenanceNameTxt1Lbl("Over Limit!");
                            vmfView.setVMmaintenanceNameTxt2("");
                            vmfView.setVMmaintenanceQuantityTxt("");
                            vmfView.getMaintenanceFrameVM().revalidate();
                            vmfView.getMaintenanceFrameVM().repaint();  
                        } else {
                            boolean result = vmfModel.vmList.get(vmIndex).getSlotList()[i].addStock(Integer.parseInt(vmfView.getVMmaintenanceQuantityTxt()), vmfModel.vmList.get(vmIndex).getMaxItems());
                            if (result) {
                                vmfView.setVMmaintenanceNameTxt1Lbl("Stocking success!");
                                vmfView.setVMmaintenanceNameTxt2("");
                                vmfView.setVMmaintenanceQuantityTxt("");
                                vmfView.setVMslotListTxt(vmfModel.vmList.get(vmIndex).getInventoryList());
                                vmfModel.vmList.get(vmIndex).transactionList.clear();
                                vmfModel.vmList.get(vmIndex).setStartInventory(vmfModel.vmList.get(vmIndex).getSlotList());
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
                int vmIndex = vmfModel.getVmIndex(vmfView.getVMupdateLbl());
                
                String name = vmfView.getVMmaintenanceNameTxt2();
                int found = -1;
                if (vmfModel.vmList.get(vmIndex) instanceof vmfModelSVM) {
                    vmfModelSVM svmObject = (vmfModelSVM) vmfModel.vmList.get(vmIndex);
                    for (int i = 0; i < svmObject.getAddOnSlotList().length; i++) {
                        if (name.equals(svmObject.getAddOnSlotList()[i].getItem().getName())) {
                            found = 0;
                            if (Integer.parseInt(vmfView.getVMmaintenanceNewPriceTxt().trim()) > 0) {
                                svmObject.getAddOnSlotList()[i].getItem().setPrice(Integer.parseInt(vmfView.getVMmaintenanceNewPriceTxt().trim()));
                                vmfView.setVMmaintenanceNameTxt2Lbl("Price updated!");
                                vmfView.setVMmaintenanceNameTxt1("");
                                vmfView.setVMmaintenanceNewPriceTxt("");
                                vmfView.setVMslotListTxt(svmObject.getInventoryList());
                                vmfView.getMaintenanceFrameVM().revalidate();
                                vmfView.getMaintenanceFrameVM().repaint();  
                            }
                        }
                    }
                }
                
                    for (int i = 0; i < vmfModel.vmList.get(vmIndex).slotList.length; i++) {
                        if (name.equals(vmfModel.vmList.get(vmIndex).getSlotList()[i].getItem().getName())) {
                            found = 0;
                            if (Integer.parseInt(vmfView.getVMmaintenanceNewPriceTxt().trim()) > 0) {
                                vmfModel.vmList.get(vmIndex).getSlotList()[i].getItem().setPrice(Integer.parseInt(vmfView.getVMmaintenanceNewPriceTxt().trim()));
                                vmfView.setVMmaintenanceNameTxt2Lbl("Price updated!");
                                vmfView.setVMmaintenanceNameTxt1("");
                                vmfView.setVMmaintenanceNewPriceTxt("");
                                vmfView.setVMslotListTxt(vmfModel.vmList.get(vmIndex).getInventoryList());
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
                int vmIndex = vmfModel.getVmIndex(vmfView.getVMupdateLbl());
                
                vmfView.setRVMtextArea("You have received: " + vmfModel.vmList.get(vmIndex).getMoneyBox().getTotalMoney());
                vmfModel.vmList.get(vmIndex).emptyMoney(vmfModel.vmList.get(vmIndex).getMoneyBox());

                vmfView.setVMtotalMoneyLblTxt(String.valueOf(vmfModel.vmList.get(vmIndex).getMoneyBox().getTotalMoney())); 
                vmfView.getMaintenanceFrameVM().revalidate();
                vmfView.getMaintenanceFrameVM().repaint();  
                vmfView.setStatus(vmfView.getDispenseRVMItemFrame(), true);
            }
        });

        this.vmfView.setVMcoin1MT_Listener(new ActionListener() {//adds 1 1coin to the VM machine
            public void actionPerformed(ActionEvent arg0) {
                int vmIndex = vmfModel.getVmIndex(vmfView.getVMupdateLbl());
                
                vmfModel.vmList.get(vmIndex).moneyBox.setCoin1(vmfModel.vmList.get(vmIndex).moneyBox.getCoin1() + 1);
                vmfView.setVMtotalMoneyLblTxt(String.valueOf(vmfModel.vmList.get(vmIndex).getMoneyBox().getTotalMoney())); 
                
                vmfView.getMaintenanceFrameVM().revalidate();
                vmfView.getMaintenanceFrameVM().repaint();  
            }
        });

        this.vmfView.setVMcoin5MT_Listener(new ActionListener() {//adds 1 5coin to the VM machine
            public void actionPerformed(ActionEvent arg0) {
                int vmIndex = vmfModel.getVmIndex(vmfView.getVMupdateLbl());
                
                vmfModel.vmList.get(vmIndex).moneyBox.setCoin5(vmfModel.vmList.get(vmIndex).moneyBox.getCoin5() + 1);
                vmfView.setVMtotalMoneyLblTxt(String.valueOf(vmfModel.vmList.get(vmIndex).getMoneyBox().getTotalMoney())); 
                vmfView.getMaintenanceFrameVM().revalidate();
                vmfView.getMaintenanceFrameVM().repaint();  
            }
        });

        this.vmfView.setVMcoin10MT_Listener(new ActionListener() {//adds 1 10coin to the VM machine
            public void actionPerformed(ActionEvent arg0) {
                int vmIndex = vmfModel.getVmIndex(vmfView.getVMupdateLbl());
                
                vmfModel.vmList.get(vmIndex).moneyBox.setCoin10(vmfModel.vmList.get(vmIndex).moneyBox.getCoin10() + 1);
                vmfView.setVMtotalMoneyLblTxt(String.valueOf(vmfModel.vmList.get(vmIndex).getMoneyBox().getTotalMoney())); 
                vmfView.getMaintenanceFrameVM().revalidate();
                vmfView.getMaintenanceFrameVM().repaint();  
            }
        });

        this.vmfView.setVMbill20MT_Listener(new ActionListener() {//adds 1 20bill to the VM machine
            public void actionPerformed(ActionEvent arg0) {
                int vmIndex = vmfModel.getVmIndex(vmfView.getVMupdateLbl());
                
                vmfModel.vmList.get(vmIndex).moneyBox.setBill20(vmfModel.vmList.get(vmIndex).moneyBox.getBill20() + 1);
                vmfView.setVMtotalMoneyLblTxt(String.valueOf(vmfModel.vmList.get(vmIndex).getMoneyBox().getTotalMoney())); 
                vmfView.getMaintenanceFrameVM().revalidate();
                vmfView.getMaintenanceFrameVM().repaint();  
            }
        });

        this.vmfView.setVMbill50MT_Listener(new ActionListener() {//adds 1 50bill to the VM machine
            public void actionPerformed(ActionEvent arg0) {
                int vmIndex = vmfModel.getVmIndex(vmfView.getVMupdateLbl());
                
                vmfModel.vmList.get(vmIndex).moneyBox.setBill50(vmfModel.vmList.get(vmIndex).moneyBox.getBill50() + 1);
                vmfView.setVMtotalMoneyLblTxt(String.valueOf(vmfModel.vmList.get(vmIndex).getMoneyBox().getTotalMoney())); 
                vmfView.getMaintenanceFrameVM().revalidate();
                vmfView.getMaintenanceFrameVM().repaint();  
            }
        });

        this.vmfView.setVMbill100MT_Listener(new ActionListener() {//adds 1 100bill to the VM machine
            public void actionPerformed(ActionEvent arg0) {
                int vmIndex = vmfModel.getVmIndex(vmfView.getVMupdateLbl());

                vmfModel.vmList.get(vmIndex).moneyBox.setBill100(vmfModel.vmList.get(vmIndex).moneyBox.getBill100() + 1);
                vmfView.setVMtotalMoneyLblTxt(String.valueOf(vmfModel.vmList.get(vmIndex).getMoneyBox().getTotalMoney())); 
                vmfView.getMaintenanceFrameVM().revalidate();
                vmfView.getMaintenanceFrameVM().repaint();  
            }
        });

        this.vmfView.setVMmaintenanceBackbtn_Listener(new ActionListener(){//Back button to exit maintenance in RVM
            public void actionPerformed(ActionEvent arg0){
                vmfView.setStatus(vmfView.getMaintenanceFrameVM(), false);
                vmfView.setStatus(vmfView.getFirstMenu(), true);
            }
        });

        this.vmfView.setVMmaintenanceTransactionBtn_Listener(new ActionListener(){//Gets transactionlist summary for rvm
            public void actionPerformed(ActionEvent arg0){
                int vmIndex = vmfModel.getVmIndex(vmfView.getVMupdateLbl());
                vmfView.setRVMTransactionsTextArea(vmfModel.vmList.get(vmIndex).printTransactionSummary());
                vmfView.setStatus(vmfView.getRVMTransactions(), true); 
                vmfView.getRVMTransactions().revalidate();
                vmfView.getRVMTransactions().repaint();  
            }
        });
    
    }
}
