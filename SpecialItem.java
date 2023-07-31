import java.util.ArrayList;

public class SpecialItem extends Item{
    ArrayList<Item> ingredients;
    Item baseIngredient;
    
    public SpecialItem (String name, Item baseIngredient){
<<<<<<< Updated upstream
        super(name, 0, 0);
        ingredients = new ArrayList<Item>();
        this.baseIngredient = baseIngredient;
=======
        super(name, 0, 0);
        ingredients = new ArrayList<Item>();
        this.baseIngredient = baseIngredient;
    }
    public SpecialItem (String name){
        super(name, 0, 0);
        ingredients = new ArrayList<Item>();
        this.baseIngredient = null;
>>>>>>> Stashed changes
    }
    
    public void addIngredient(Item ingredient){
        ingredients.add(ingredient);
        //super.calories = super.getCalories() + ingredient.getCalories();
        //super.price = super.getPrice() + ingredient.getPrice();
        //updatePrice(ingredient.getPrice());
        //updateCalories(ingredient.getCalories());
    } 

    public ArrayList<Item> getIngredients() {
        return this.ingredients;
    }

    public void resetCustomItem() {
        this.price = 0;
        this.calories = 0;
    }

    public Item getBaseIngredient(){
<<<<<<< Updated upstream
        return baseIngredient;
    }
=======
        return this.baseIngredient;
    }

>>>>>>> Stashed changes
}

