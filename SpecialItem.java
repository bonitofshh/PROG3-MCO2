/**
 * A specialItem class that extends item
 * @author Ian Gabriel S. De Jesus & Sean Riley P. Veracruz
 * @version %I% %G%
 * @since 1.0
 */
import java.util.ArrayList;

public class SpecialItem extends Item{
    protected ArrayList<Item> ingredients;
    protected Item baseIngredient;
    
    /**
     * Creates a special item object
     * @param name name of special object
     */
    public SpecialItem (String name){
        super(name, 0, 0);
        ingredients = new ArrayList<Item>();
        baseIngredient = new Item();
    }

    /**
     * adds an ingredient to the list of ingredients
     * @param ingredient item object
     */
    public void addIngredient(Item ingredient){
        ingredients.add(ingredient);
        super.calories += ingredient.getCalories();
        super.price += ingredient.getPrice();
    } 

    public String printIngredientList(){
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < ingredients.size(); i++) {
            temp.append((i+1) + ". " + ingredients.get(i).getName() + "\n");
        }
        return temp.toString();
    }

    /**
     * gets the list of ingredients
     * @return arraylist of ingredients
     */
    public ArrayList<Item> getIngredients() {
        return this.ingredients;
    }

    public Item getBaseIngredient(){
        return this.baseIngredient;
    }

    public void setBaseIngredient(Item baseIngredient){
        this.baseIngredient = baseIngredient;
    }
    /**
     * resets custom item's price and calories
     */
    public void resetCustomItem() {
        for (int i = 0; i < ingredients.size(); i++) ingredients.remove(i);
        this.price = 0;
        this.calories = 0;
    }
}
