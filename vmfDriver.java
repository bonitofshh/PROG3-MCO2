public class vmfDriver {
    
    public static void main(String[] args){

        vmfView vmfView = new vmfView();
        vmfModel vmfModel = new vmfModel();
        vmfController vmfController = new vmfController(vmfView, vmfModel);
    }
}
