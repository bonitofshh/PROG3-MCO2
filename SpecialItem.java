import java.util.ArrayList;

public class SpecialItem extends Item{
    ArrayList<Item> ingredients;
    Item baseIngredient;
    
    public SpecialItem (String name, Item baseIngredient){

        super(name, 0, 0);
        ingredients = new ArrayList<Item>();
        this.baseIngredient = baseIngredient;
    }
    public SpecialItem (String name){
        super(name, 0, 0);
        ingredients = new ArrayList<Item>();
        this.baseIngredient = null;
    }
    
    public void addIngredient(Item ingredient){
        ingredients.add(ingredient);
    } 

    public ArrayList<Item> getIngredients() {
        return this.ingredients;
    }

    public void resetCustomItem() {
        this.price = 0;
        this.calories = 0;
    }

    public Item getBaseIngredient(){

        return this.baseIngredient;
    }
}

