
import java.text.DecimalFormat;
import java.util.LinkedList;

/**
 *
 * @author damianchng
 */

//Recipe object is main purpose of program. Used for storing recipes user wants to rate. Used in most/all aspects of program.
public class Recipe {
    
    private String name; //name of recipe
    private double rating; //1.0-10.0
    private LinkedList<Ingredient> ingredients; //list of all the recipes
    private int cookTime; //minutes
    private double price; // SGD$ 0.00
    private Category category; //Appetizer, Main Course, Desert
    
    /**
     *
     * @param name
     * @param rating
     * @param ingredients
     * @param cookTime
     * @param category
     */
    public Recipe(String name, double rating, LinkedList<Ingredient> ingredients, int cookTime, Category category){
        //init variables
        this.name = name;
        this.rating = rating;
        this.ingredients = ingredients;
        this.cookTime = cookTime;
        this.price = setPrice();
        this.category = category;
    }
    
    /**
     *
     * @param name
     * @param rating
     * @param ingredients
     * @param price
     * @param cookTime
     * @param category
     */
    public Recipe(String name, double rating, LinkedList<Ingredient> ingredients, double price, int cookTime, Category category){
        //init variables
        this.name = name;
        this.rating = rating;
        this.ingredients = ingredients;
        this.cookTime = cookTime;
        this.price = price;
        this.category = category;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the rating
     */
    public double getRating() {
        return rating;
    }

    /**
     * @return the ingredients
     */
    public LinkedList<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     * @return the cookTime
     */
    public int getCookTime() {
        return cookTime;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    private double setPrice() {
        double price = 0;
        for(Ingredient i: ingredients){
            price += i.getPrice();
        }
        return price;
    }

    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }
    
    /**
     *
     * @return String
     */
    @Override
    public String toString(){
        String ret = name + ": " + new DecimalFormat("##.#").format(rating) + " stars, "
                + cookTime + " mins, $" + new DecimalFormat("##.##").format(price) 
                + ", " + category + ", [" + ingredients.getFirst().getName();
        boolean first = true;
        for(Ingredient i: ingredients){
            if(first){
                first = false;
            }else{
                ret += ", " + i.getName();
            }
        }
        ret += "]";
        return ret;
    }

    
}
