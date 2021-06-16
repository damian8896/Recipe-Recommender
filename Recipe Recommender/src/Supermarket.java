 
import java.util.HashSet;

/**
 *
 * @author damianchng
 */

//Supermarket object used for storing name of supermarket and products inside
public class Supermarket {
    
    private String name; //name of supermarket
    private HashSet<Ingredient> products; //all products
    
    /**
     *
     * @param name
     * @param products
     */
    public Supermarket(String name, HashSet<Ingredient> products){
        //init variables
        this.name = name;
        this.products = products;
    }

    /**
     * @return the products
     */
    public HashSet<Ingredient> getProducts() {
        return products;
    }
    
    /**
     *
     * @return String
     */
    @Override
    public String toString(){
        String ret = getName() + "[";
        boolean first = true;
        for(Ingredient i: products){
            if(first){
                ret += i.getName();
                first = false;
            }else{
                ret += ", " + i.getName();
            }
        }
        ret += "]";
        return ret;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
}
