/**
 * Main file
 * @author Ian Gabriel S. De Jesus & Sean Riley P. Veracruz
 * @version %I% %G%
 * @since 1.0
 */
public class vmfDriver {
    
    public static void main(String[] args){

        vmfView vmfView = new vmfView();
        vmfModel vmfModel = new vmfModel();
        vmfController vmfController = new vmfController(vmfView, vmfModel);
    }
}
