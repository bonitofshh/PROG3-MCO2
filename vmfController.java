import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class vmfController {
    private vmfView vmfView;
    private vmfModel vmfModel;

    public vmfController(vmfView vmfView, vmfModel vmfModel){
        this.vmfView = vmfView;
        this.vmfModel = vmfModel;

        this.vmfView.setCreateBtn_Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0){
                vmfView.getMainFrame().dispose();
                vmfView.vmChoice();
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
                vmfView.initializeRVM(); 
            }
        });

        this.vmfView.setSpecialBtn_Listener(new ActionListener() {//Special VM
            public void actionPerformed(ActionEvent arg0){
                vmfView.getMainFrame().dispose();
                
            }
        });

        this.vmfView.setNextBtn_Listener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0){
                vmfView.getMainFrame().dispose();
                //initializeRVM2();
                
            }
        });
    }
}
