import java.util.ArrayList;

public class vmfModel {
    ArrayList<vmfModelVM> vmList = new ArrayList<>();

    public vmfModel(){
        this.vmList = new ArrayList<>();
    }

    public String getVMList(){
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < vmList.size(); i++) {
            temp.append((i+1) + ". " + vmList.get(i).name + "\n");
        }

        return temp.toString();
    }
    
}
