public class addOn extends Item {
    public addOn(String name, int calories, int price){
        super(name, calories, price);
    }

    public addOn(){
        super.name = null;
        super.calories = 0;
        super.price = 0;
    }
}
