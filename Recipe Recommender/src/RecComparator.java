
import java.util.Comparator;
import java.util.HashSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author damianchng
 */

//Comparator used to determine uniqueness of recipe which determines priority. More unique means more recomended
public class RecComparator implements Comparator<Recipe> {

    private HashSet<Ingredient> ingredients; //Store all ingredients in schedule

    /**
     *
     * @param schedule
     */
    public RecComparator(Schedule schedule) {
        //Init hashset
        ingredients = new HashSet<>();

        //Get week from schedule
        Day[] week = schedule.getWeek();

        //loop through every day week and add all ingredients to hashset
        for (int i = 0; i < week.length; i++) {

            //add breakfast ingredients to hashset
            if (week[i].getBreakfast() != null) {
                ingredients.addAll(week[i].getBreakfast().getIngredients());
            }

            //add lunch ingredients to hashset
            if (week[i].getLunch() != null) {
                ingredients.addAll(week[i].getLunch().getIngredients());
            }

            //add dinner ingredients to hashset
            if (week[i].getDinner() != null) {
                ingredients.addAll(week[i].getDinner().getIngredients());
            }
        }
    }

    /**
     *
     * @param o1
     * @param o2
     * @return int
     */
    @Override
    public int compare(Recipe o1, Recipe o2) {
        //check if unique index has been calculated
            int count = 0;

            //go through all ingredients in recipe & check if they are in the week
            for (Ingredient i : o1.getIngredients()) {
                if (!ingredients.contains(i)) {
                    count++;
                }
            }
            int one = count;
        
        //check if unique index has been calculated
        count = 0;

            //go through all ingredients in recipe & check if they are in the week
            for (Ingredient i : o2.getIngredients()) {
                if (!ingredients.contains(i)) {
                    count++;
                }
            }
            
        //more unique one goes on top of priorityqueue
        int two = count;
        if (one - two == 0) {
            return o1.getIngredients().size() - o2.getIngredients().size();
        } else {
            return two - one;
        }
    }

}
