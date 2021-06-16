
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author damianchng
 */

//Schedule object used for storing all days in a week.
public class Schedule {
    
    private Day[] week; //Mon-fri

    /**
     *
     */
    public Schedule() {
        this.week = new Day[5];
    }

    /**
     * @return the week
     */
    public Day[] getWeek() {
        return week;
    }

    //Add a day to the week
    public void addDay(Day day, int i){
        week[i] = day;
    }
}
