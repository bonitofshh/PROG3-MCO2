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

        this.vmfView.setCreateBtn_Listener(new ActionListener() {//Create Vending 
            @Override
            public void actionPerformed(ActionEvent arg0){
                vmfView.setStatus(vmfView.getFirstMenu(), false); 
                vmfView.setStatus(vmfView.getChoiceMenuFrame(), true); 
                }
            }); 
            
        this.vmfView.setTestBtn_Listener(new ActionListener() {//Test Vending
            public void actionPerformed(ActionEvent arg0){
                if (vmfModel.vmList.size() <= 0) vmfView.setVmSuccessLbl("There are no vending machines.");
                else {
                    vmfView.setStatus(vmfView.getFirstMenu(), false); 
                    //add test VM frame
                }
            }
        });
        
        this.vmfView.setExitBtn_Listener(new ActionListener() {//Exit
            public void actionPerformed(ActionEvent arg0){
                vmfView.setStatus(vmfView.getFirstMenu(), false); 
            }
        });

        this.vmfView.setRegularBtn_Listener(new ActionListener() {// Regular VM
            public void actionPerformed(ActionEvent arg0) {
                vmfView.setStatus(vmfView.getChoiceMenuFrame(), false); 
                vmfView.setStatus(vmfView.getRvmMenuFrame(), true); 
            }
        });

        this.vmfView.setSpecialBtn_Listener(new ActionListener() {// Special VM
            public void actionPerformed(ActionEvent arg0) {
                vmfView.setStatus(vmfView.getChoiceMenuFrame(), false); 
                //Add create svm frame
            }
        });

        //TODO: MAKE INPUT VALIDATION FOR THIS PART (SLOT NUM SHOULD BE BETWEEN 8-10) 
        //TODO: TEST IF THIS WORKS
        this.vmfView.setNextBtnVM_Listener(new ActionListener() {//Button from asking VM deets to Item deets
            public void actionPerformed(ActionEvent arg0) {

                vmfModelVM VM = new vmfModelVM(vmfView.getVmNameTxt(), Integer.parseInt(vmfView.getSlotNumTxt()), Integer.parseInt(vmfView.getMaxItemTxt()));
                boolean result = vmfModel.vmList.add(VM);

                vmfView.setStatus(vmfView.getRvmMenuFrame(), false);
                vmfView.setStatus(vmfView.getAddItemFrame(), true); 

                if(result) {
                    vmfView.setVmSuccessLbl("Vending Machine successfully created");
                } else {
                    vmfView.setVmSuccessLbl("Vending Machine creation failed :(");
                }

                vmfView.clearTxtVM();
            }
        });

        this.vmfView.setNextBtnSVM_Listener(new ActionListener() {//Button from asking SVM deets to Item deets
            public void actionPerformed(ActionEvent arg0) {

            }
        });
    
        this.vmfView.setAddBtn_Listener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                
                if (vmfView.getItemNameTxt().equals(null) || Integer.parseInt(vmfView.getItemPriceTxt()) <= 0 || 
                Integer.parseInt(vmfView.getItemCaloriesTxt()) <= 0) {
                    vmfView.setitemStatusLbl("Check your values!");

                } else {
                    boolean flag = vmfModelVM.addItem(vmfView.getItemNameTxt(), Integer.parseInt(vmfView.getItemPriceTxt()), 
                            Integer.parseInt(vmfView.getItemCaloriesTxt()));
                    
                    boolean result = vmfModelVM.slotList[vmfModelVM.getNumItems()].addStock(Integer.parseInt(vmfView.getItemQuantityTxt()), 
                            vmfModelVM.maxItems);
    
                    if (flag && result) {
                        vmfView.setitemStatusLbl("Item added");
                        vmfView.clearItemTxt();
                    } else {
                        vmfView.setitemStatusLbl("Item adding failed :(");
                    }
                }
            }
        });   
    }
}
