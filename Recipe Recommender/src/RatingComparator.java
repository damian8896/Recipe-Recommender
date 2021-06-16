
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author damianchng
 */

//Comparator used for ratings comparison in treeset
public class RatingComparator implements Comparator<Recipe>{

    /**
     *
     * @param o1
     * @param o2
     * @return int
     */
    @Override
    public int compare(Recipe o1, Recipe o2) {
        System.out.println(o1.getName() + ", " + o2.getName());
        //ensures the right recipe is deleted
        if(o1.getName().equals(o2.getName())){
            return 0;
        //allow "duplicates" in the treeset - can have same categories
        }else if((int)(o1.getRating()*10 - o2.getRating()*10) == 0){
            return 1;
        }else{
            return (int)(o2.getRating()*10 - o1.getRating()*10);
        }
    }
    
}
