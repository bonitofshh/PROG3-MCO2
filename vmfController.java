import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;

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
                vmfView.clearRVMTxtVM();
                vmfView.setStatus(vmfView.getRvmMenuFrame(), true); 
            }
        });

        this.vmfView.setSpecialBtn_Listener(new ActionListener() {// Special VM
            public void actionPerformed(ActionEvent arg0) {
                vmfView.setStatus(vmfView.getChoiceMenuFrame(), false); 
                vmfView.setStatus(vmfView.getSVMMenuFrame(), true);

            }
        });

        //TODO: MAKE INPUT VALIDATION FOR THIS PART (SLOT NUM SHOULD BE BETWEEN 8-10) 
        //TODO: TEST IF THIS WORKS
        this.vmfView.setVmNextBtn_Listener(new ActionListener() {//Button from asking VM deets to Item deets
            public void actionPerformed(ActionEvent arg0) {

                //TODO: REVERT BACK TO 8 AND 10
                if (Integer.parseInt(vmfView.getRVMSlotNumTxt()) < 1 || Integer.parseInt(vmfView.getRVMSlotNumTxt()) > 100) {
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

        this.vmfView.setNextBtnSVM_Listener(new ActionListener() {//Button from asking SVM deets to Item deets
            public void actionPerformed(ActionEvent arg0) {
                
            }
        });
    
        this.vmfView.setAddBtnVM_Listener(new ActionListener() {
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
    
        this.vmfView.setNextBtnVM_Listener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                vmfView.setStatus(vmfView.getAddItemFrame(), false);  
                vmfView.setStatus(vmfView.getFirstMenu(), true);               
            }
        });
    }
}
