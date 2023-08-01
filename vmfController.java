import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class vmfController {
    private vmfView vmfView;
    private vmfModel vmfModel;
    private vmfModelVM vmfModelVM;
    private vmfModelSVM vmfModelSVM;

    public vmfController(vmfView vmfView, vmfModel vmfModel, vmfModelVM vmfModelVM, vmfModelSVM vmfModelSVM){
        this.vmfView = vmfView;
        this.vmfModel = vmfModel;
        this.vmfModelVM = vmfModelVM;
        this.vmfModelSVM = vmfModelSVM;

        this.vmfView.setCreateBtn_Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0){
                vmfView.getMainFrame().dispose();
                vmfView.choiceMenu();
            }
        }); //Create Vending 
            
        this.vmfView.setTestBtn_Listener(new ActionListener() {//Test Vending
            public void actionPerformed(ActionEvent arg0){
                //add test VM frame
                vmfView.getMainFrame().dispose();
                
            }
        });
        this.vmfView.setExitBtn_Listener(new ActionListener() {//Exit
            public void actionPerformed(ActionEvent arg0){
                vmfView.getMainFrame().dispose();
            }
        });

        this.vmfView.setRegularBtn_Listener(new ActionListener() {//Regular VM
            public void actionPerformed(ActionEvent arg0){
                vmfView.getMainFrame().dispose();

                vmfView.rvmMenu(); 
            }
        });

        this.vmfView.setSpecialBtn_Listener(new ActionListener() {//Special VM
            public void actionPerformed(ActionEvent arg0){
                vmfView.getMainFrame().dispose();
                
            }
        });
    }

        public void addItemsToMachine() {
            //TODO: WE'RE HERE
            this.vmfView.setNextBtn_Listener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0){
                    vmfView.getMainFrame().dispose();
                    for (int i = 0; i < vmfView.toInt(vmfView.getSlotNumTxt()); i++) {
                        vmfView.addItemsMenu();
                    }
    
                    vmfModelVM VM = new vmfModelVM(vmfView.getVmNameTxt(), vmfView.toInt(vmfView.getSlotNumTxt()), vmfView.toInt(vmfView.getMaxItemTxt())); 
                    boolean result = vmfModel.vmList.add(VM);
    
                    if(result) {
                        vmfView.setVmSuccessLbl("Vending Machine successfully created");
                    } else {
                        vmfView.setVmSuccessLbl("Vending Machine creation failed :(");
                    }
    
                    vmfView.clearTxtVM();
                }
            });
    
            this.vmfView.setAddBtn_Listener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    
                    if (vmfView.getItemNameTxt().isEmpty() || vmfView.toInt(vmfView.getItemPriceTxt()) <= 0 || 
                    vmfView.toInt(vmfView.getSlotNumTxt()) < 7 || vmfView.toInt(vmfView.getItemCaloriesTxt()) <= 0 || 
                    vmfView.toInt(vmfView.getSlotNumTxt()) > 10) {
                        vmfView.setitemSuccessLbl("Check your values!");
                    } else {
                        int slotIndex = vmfView.toInt(vmfView.getSlotNumTxt());
                        boolean flag = vmfModelVM.addItem(vmfView.getItemNameTxt(), vmfView.toInt(vmfView.getItemPriceTxt()), 
                                vmfView.toInt(vmfView.getItemCaloriesTxt()), slotIndex);
                        
                        boolean result = vmfModelVM.slotList[slotIndex].addStock(vmfView.toInt(vmfView.getItemQuantityTxt()), 
                                vmfModelVM.maxItems);
        
                        if (flag && result) {
                            vmfView.setitemStatusLbl("Item added");
                        } else {
                            vmfView.setitemStatusLbl("Item adding failed :(");
                        }
                    }
                }
        });
    }
}
