
import java.util.TreeSet;

/**
 *
 * @author damianchng
 */

//Day Object used for storing all necessary information per day in schedule.
public class Day {
    
    private String dayOfWeek; //The day of the week ie. Monday
    private Recipe breakfast; //Recipe for breakfast
    private Recipe lunch; //Recipe for lunch
    private Recipe dinner; //Recipe for dinner
    
    /**
     *
     * @param dayOfWeek
     * @param breakfast
     * @param lunch
     * @param dinner
     */
    public Day(String dayOfWeek, Recipe breakfast, Recipe lunch, Recipe dinner){
        this.dayOfWeek = dayOfWeek;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
    }

    /**
     * @return the dayOfWeek
     */
    public String getDayOfWeek() {
        return dayOfWeek;
    }

    /**
     * @return the breakfast
     */
    public Recipe getBreakfast() {
        return breakfast;
    }

    /**
     * @param breakfast the breakfast to set
     */
    public void setBreakfast(Recipe breakfast) {
        this.breakfast = breakfast;
    }

    /**
     * @return the lunch
     */
    public Recipe getLunch() {
        return lunch;
    }

    /**
     * @param lunch the lunch to set
     */
    public void setLunch(Recipe lunch) {
        this.lunch = lunch;
    }

    /**
     * @return the dinner
     */
    public Recipe getDinner() {
        return dinner;
    }

    /**
     * @param dinner the dinner to set
     */
    public void setDinner(Recipe dinner) {
        this.dinner = dinner;
    }
    
    /**
     *
     * @return String
     */
    @Override
    public String toString() {
        String ret = dayOfWeek + ": ";
        if(breakfast == null){
            ret += "null, ";
        }else{
            ret += breakfast.getName() + ", ";
        }
        
        if(lunch == null){
            ret += "null, ";
        }else{
            ret += lunch.getName() + ", ";
        }
        
        if(dinner == null){
            ret += "null";
        }else{
            ret += dinner.getName();
        }
        return ret;
    }
    
}
