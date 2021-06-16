
import java.text.DecimalFormat;

/**
 *
 * @author damianchng
 */

// Ingredient object used for storing neccessary data about ingredient. Used in recipes, analyzer, and supermarket
public class Ingredient implements Comparable<Ingredient>{
    
    private String name; //name of the ingredient
    private double price; //SGD$ 0.00
    
    /**
     *
     * @param name
     * @param price
     */
    public Ingredient(String name, double price){
        this.name = name;
        this.price = price;
    }
    
    /**
     *
     * @return
     */
    public String getName(){
        return name;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @param o
     * @return int
     * 
     * compares ingredients based on price of them(checklist).
     */
    @Override
    public int compareTo(Ingredient o) {
        if((int)(price* 100 - o.getPrice()* 100) == 0){
            //Allows for deletion in a treeset
            if(getName().equals(o.getName())){
                return 0;
            }
            //Allows "duplicates" two ingredients with same price in treeset
            return 1;
        }else{
            return (int)(price* 100 - o.getPrice()* 100);
        }
    }
    
    /**
     *
     * @return String
     */
    @Override
    public String toString(){
        return getName() + ": " + new DecimalFormat("##.##").format(price); 
    }
}
