/**
 * A specialItem class that extends item
 * @author Ian Gabriel S. De Jesus & Sean Riley P. Veracruz
 * @version %I% %G%
 * @since 1.0
 */
import java.util.ArrayList;

public class SpecialItem extends Item{
    private ArrayList<Item> ingredients;
    private Item baseIngredient;
    
    /**
     * Creates a special item object
     * @param name name of special object
     */
    public SpecialItem (String name){
        super(name, 0, 0);
        ingredients = new ArrayList<Item>();
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

    /**
     * gets the list of ingredients
     * @return arraylist of ingredients
     */
    public ArrayList<Item> getIngredients() {
        return this.ingredients;
    }

    /**
     * resets custom item's price and calories
     */
    public void resetCustomItem() {
        this.price = 0;
        this.calories = 0;
    }
}
