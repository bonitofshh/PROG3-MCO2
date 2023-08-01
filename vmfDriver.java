public class vmfDriver {
    
    public static void main(String[] args){

        vmfView vmfView = new vmfView();
        vmfModel vmfModel = new vmfModel();
        vmfModelVM vmfModelVM = new vmfModelVM();
        vmfModelSVM vmfModelSVM = new vmfModelSVM();
        vmfController vmfController = new vmfController(vmfView, vmfModel, vmfModelVM, vmfModelSVM);
    }
}
