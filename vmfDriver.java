public class vmfDriver {
    
    public static void main(String[] args){

        //vmfOld vmfView = new vmfOld();
        //vmfView.firstMenu();
        vmfView vmfView = new vmfView();
        vmfController vmfController = new vmfController(vmfView, null);
    }
}
