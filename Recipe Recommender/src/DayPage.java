
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author damianchng
 */

//JFrame used to edit individual day in schedule. Has the recommend and randomize functions.
public class DayPage extends javax.swing.JFrame {

    private SchedulePage schedule; //schedule needed to pass back inputed data from this screen.
    private PriorityQueue<Recipe> rec; //queue that offers recommended recipes to user
    private PriorityQueue<Recipe> temp; //extra priorityqueue needed to iterate through all recommended recipes 
    private ArrayList<Recipe> rand; //used for random function
    private Day day; //specific day being edited
    private TreeSet<Recipe> sortedRecipes; //Treeset of recipes that are sorted
    private HashMap<String, Recipe> recipeStorage; //Hashmap of recipes for retrieving recipe objects
    
    /**
     * Creates new form DayPage
     * @param schedule
     * @param rec
     * @param rand
     * @param day
     * @param recipeStorage
     * @param sortedRecipes
     */
    public DayPage(SchedulePage schedule, PriorityQueue<Recipe> rec, ArrayList<Recipe> rand, Day day, TreeSet<Recipe> sortedRecipes, HashMap<String, Recipe> recipeStorage) {
        initComponents();
        //Ensures that program doesn't end when window is closed
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //init all variables
        this.schedule = schedule;
        this.rec = rec;
        this.rand = rand;
        this.day = day;
        this.sortedRecipes = sortedRecipes;
        this.recipeStorage = recipeStorage;
        this.temp = new PriorityQueue<>(new RecComparator(schedule.getSchedule()));
        temp.addAll(rec);
        
        //update JComboBox with all the recipes
        for(Recipe i: sortedRecipes){
            recipeBox.addItem(i.getName());
        }
        
        //show the recommended recipe on top of priority queue
        recRecipe.setText(temp.peek().getName());
        
        //show the random recipe based on random index
        int randIx = (int)(Math.random()*rand.size());
        randRecipe.setText(rand.get(randIx).getName());
        
        //show day of the week being edited
        title.setText("Day " + day.getDayOfWeek());
        
        //display JTable
        display();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        daySchedule = new javax.swing.JTable();
        categoryBox = new javax.swing.JComboBox<>();
        sortBox = new javax.swing.JComboBox<>();
        recipeBox = new javax.swing.JComboBox<>();
        lblCategory = new javax.swing.JLabel();
        btnSort = new javax.swing.JButton();
        lblRecipe = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        reccomend = new javax.swing.JLabel();
        recRecipe = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        randomize = new javax.swing.JLabel();
        randRecipe = new javax.swing.JLabel();
        btnRandom = new javax.swing.JButton();
        reset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        title.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        title.setText("Day ");

        daySchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null}
            },
            new String [] {
                ""
            }
        ));
        daySchedule.setGridColor(new java.awt.Color(0, 0, 0));
        daySchedule.setRowHeight(50);
        jScrollPane1.setViewportView(daySchedule);

        categoryBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Breakfast", "Lunch", "Dinner" }));

        sortBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rating", "Ingredient", "Cook Time", "Price", "Category" }));

        lblCategory.setText("Category: ");

        btnSort.setText("Sort By");
        btnSort.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortActionPerformed(evt);
            }
        });

        lblRecipe.setText("Recipe:");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        reccomend.setText("Recommend!");

        recRecipe.setText("text");

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        randomize.setText("Randomize?");

        randRecipe.setText("jLabel7");

        btnRandom.setText("Randomize");
        btnRandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRandomActionPerformed(evt);
            }
        });

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(title)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblRecipe)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(recipeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCategory)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(categoryBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(sortBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSort)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(reccomend)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(recRecipe))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(reset)
                        .addGap(1, 1, 1)
                        .addComponent(btnNext)))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(randomize)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(randRecipe))
                    .addComponent(btnRandom)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(title)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(categoryBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCategory))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sortBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSort))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(recipeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRecipe))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnDelete))))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reccomend)
                    .addComponent(recRecipe)
                    .addComponent(randomize)
                    .addComponent(randRecipe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRandom)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNext)
                        .addComponent(reset)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        //Adds selected recipe to the day as either a breakfast, lunch, or dinner
        String choice = categoryBox.getSelectedItem().toString();
        if(choice.equals("Breakfast")){
            day.setBreakfast(recipeStorage.get(recipeBox.getSelectedItem().toString()));
        }
        if(choice.equals("Lunch")){
            day.setLunch(recipeStorage.get(recipeBox.getSelectedItem().toString()));
        }
        if(choice.equals("Dinner")){
            day.setDinner(recipeStorage.get(recipeBox.getSelectedItem().toString()));
        }
        display();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortActionPerformed
        // TODO add your handling code here:
        //Create sub treeset for new comparator
        TreeSet<Recipe> sub = new TreeSet<>(new RatingComparator());
        String choice = sortBox.getSelectedItem().toString();

        //change comparator based on choice
        if (choice.equals("Ingredient")) {
            sub = new TreeSet<>(new IngredientComparator());
        } else if (choice.equals("Cook Time")) {
            sub = new TreeSet<>(new TimeComparator());
        } else if (choice.equals("Price")) {
            sub = new TreeSet<>(new PriceComparator());
        } else if (choice.equals("Category")) {
            sub = new TreeSet<>(new CategoryComparator());
        }

        //copy all values to sub treeset
        sub.addAll(sortedRecipes);

        //set sortedRecipes to sub treeset with new comparator
        sortedRecipes = sub;

        //change recipebox
        recipeBox.removeAllItems();
        for(Recipe i: sortedRecipes){
            recipeBox.addItem(i.getName());
        }
    }//GEN-LAST:event_btnSortActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        //iterates to next recommended recipe in the priority queue
        if(temp.size() > 1){
            temp.remove();
            recRecipe.setText(temp.peek().getName());
        }else{
            recRecipe.setText("No more");
        }
        
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnRandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRandomActionPerformed
        // TODO add your handling code here:
        //chooses a random recipe from the arraylist
        int randIx = (int)(Math.random()*rand.size());
        randRecipe.setText(rand.get(randIx).getName());
    }//GEN-LAST:event_btnRandomActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        //Deletes selected breakfast, lunch, or dinner recipe
        String choice = categoryBox.getSelectedItem().toString();
        if(choice.equals("Breakfast")){
            day.setBreakfast(null);
        }
        if(choice.equals("Lunch")){
            day.setLunch(null);
        }
        if(choice.equals("Dinner")){
            day.setDinner(null);
        }
        display();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        //Pass back inputted data from this screen to schedule
        schedule.back(day);
    }//GEN-LAST:event_formWindowClosed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        //Resets the priority queue
        temp.clear();
        temp.addAll(rec);
        recRecipe.setText(temp.peek().getName());
    }//GEN-LAST:event_resetActionPerformed

    //Updates the JTable
    private void display(){
        String[][] display = new String[3][1];
        if(day.getBreakfast() != null){
            display[0][0] = day.getBreakfast().getName();
        }else{
            display[0][0] = null;
        }

        if(day.getLunch() != null){
            display[1][0] = day.getLunch().getName();
        }else{
            display[1][0] = null;
        }

        if(day.getDinner() != null){
            display[2][0] = day.getDinner().getName();
        }else{
            display[2][0] = null;
        }
         daySchedule.setModel(new javax.swing.table.DefaultTableModel(
            display,
            new String [] {
                ""
            }));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnRandom;
    private javax.swing.JButton btnSort;
    private javax.swing.JComboBox<String> categoryBox;
    private javax.swing.JTable daySchedule;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblRecipe;
    private javax.swing.JLabel randRecipe;
    private javax.swing.JLabel randomize;
    private javax.swing.JLabel recRecipe;
    private javax.swing.JLabel reccomend;
    private javax.swing.JComboBox<String> recipeBox;
    private javax.swing.JButton reset;
    private javax.swing.JComboBox<String> sortBox;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}