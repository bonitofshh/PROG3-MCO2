import java.util.ArrayList;

public class SpecialItem extends Item{
    Item baseIngredient;
    ArrayList<Item> ingredients;
    
    public SpecialItem (String name){
        super(name, 0, 0);
        ingredients = new ArrayList<Item>();
    }

    public void addIngredient(Item ingredient){
        ingredients.add(ingredient);
        super.calories += ingredient.getCalories();
        super.price += ingredient.getPrice();
    } 
}
