import java.util.ArrayList;

public class vmfModel {
    protected ArrayList<vmfModelVM> vmList = new ArrayList<>();

    public vmfModel(){
        this.vmList = new ArrayList<>();
    }

    public int getVmIndex(String name) {
        int index = -1;
        for (int i = 0; i < vmList.size(); i++) {
            if (name.equals(vmList.get(i).getName()))
            index = i;
        }
        return index;
    }
    public String getVMList(){
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < vmList.size(); i++) {
            temp.append((i+1) + ". " + vmList.get(i).name + "\n");
        }

        return temp.toString();
    }
    
}
