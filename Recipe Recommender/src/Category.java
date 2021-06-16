/**
 *
 * @author damianchng
 */

//Enum is meant for categories used in Recipe
public enum Category {
    
    //Category constants
    STARTER(1), MAIN(2), DESERT(0);
    
    //Value used in CategoryComparator
    private int value;
            
    //Constructor
    private Category(int value){
        this.value = value;
    }
    
    /**
     *
     * @return value
     */
    public int getValue(){
        return value;
    }
    
    /**
     *
     * @param s
     * @return Category constant
     */
    public static Category getCategory(String s){
        if(s.equals("STARTER")){
            return STARTER;
        }else if(s.equals("MAIN")){
            return MAIN;
        }else if(s.equals("DESERT")){
            return DESERT;
        }else{
            return null;
        }
    }
}
