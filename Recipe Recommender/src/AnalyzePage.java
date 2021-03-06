
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author damianchng
 */
public class AnalyzePage extends javax.swing.JFrame {

    private TreeSet<Recipe> sortedRecipes; //
    private HashMap<Ingredient, Integer> ingQuantity;

    /**
     * Creates new form AnalyzePage
     * @param sortedRecipes
     */
    public AnalyzePage(TreeSet<Recipe> sortedRecipes) {
        initComponents();
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.sortedRecipes = sortedRecipes;
        ingQuantity = new HashMap<>();
        for(Recipe i: sortedRecipes){
            for(Ingredient j: i.getIngredients()){
                if(ingQuantity.get(j) == null){
                    ingQuantity.put(j, 1);
                }else{
                    ingQuantity.put(j, ingQuantity.get(j)+1);
                }
            }
        }
        
        
        DefaultListModel mod = new DefaultListModel();
        for (Map.Entry<Ingredient, Integer> str : ingQuantity.entrySet()) {
            mod.addElement(str.getKey().getName() + " " + str.getValue());
        }
        ingList.setModel(mod);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ingredientsList = new javax.swing.JScrollPane();
        ingList = new javax.swing.JList<>();
        btnAverage = new javax.swing.JButton();
        btnTotal = new javax.swing.JButton();
        btnPrice = new javax.swing.JButton();
        btnMost = new javax.swing.JButton();
        btnLeast = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/damianchng/Desktop/ATCS Folder/Final Project/images/Analyze.png")); // NOI18N
        jLabel1.setText("Analyze");

        ingList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ingredientsList.setViewportView(ingList);

        btnAverage.setText("Average");
        btnAverage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAverageActionPerformed(evt);
            }
        });

        btnTotal.setText("Total");
        btnTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalActionPerformed(evt);
            }
        });

        btnPrice.setText("Price");
        btnPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPriceActionPerformed(evt);
            }
        });

        btnMost.setText("Most");
        btnMost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostActionPerformed(evt);
            }
        });

        btnLeast.setText("Least");
        btnLeast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(ingredientsList, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnAverage)
                        .addGap(18, 18, 18)
                        .addComponent(btnTotal)
                        .addGap(25, 25, 25)
                        .addComponent(btnPrice))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(btnMost)
                        .addGap(27, 27, 27)
                        .addComponent(btnLeast)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ingredientsList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAverage)
                    .addComponent(btnTotal)
                    .addComponent(btnPrice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMost)
                    .addComponent(btnLeast))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAverageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAverageActionPerformed
        // TODO add your handling code here:
        double value = totalPrice()/totalNumber();
        JOptionPane.showMessageDialog(this, "The average price of your ingredients was $" + new DecimalFormat("##.##").format(value));
    }//GEN-LAST:event_btnAverageActionPerformed

    private void btnTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "The total number of ingredients you used was " + ingQuantity.size() + " ingredients");
    }//GEN-LAST:event_btnTotalActionPerformed

    private void btnPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPriceActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "The total price of your ingredients was $" + new DecimalFormat("##.##").format(totalPrice()));
    }//GEN-LAST:event_btnPriceActionPerformed

    private void btnMostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostActionPerformed
        // TODO add your handling code here:
        int max = 0;
        Ingredient mostUsed = null;
        for (Map.Entry<Ingredient, Integer> i : ingQuantity.entrySet()) {
            if(mostUsed == null || i.getValue() > max){
                max = i.getValue();
                mostUsed = i.getKey();
            }
        }
        
        JOptionPane.showMessageDialog(this, "The most used ingredients was " + mostUsed.getName());
    }//GEN-LAST:event_btnMostActionPerformed

    private void btnLeastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeastActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        int min = 0;
        Ingredient mostUsed = null;
        for (Map.Entry<Ingredient, Integer> i : ingQuantity.entrySet()) {
            if(mostUsed == null || i.getValue() < min){
                min = i.getValue();
                mostUsed = i.getKey();
            }
        }
        
        JOptionPane.showMessageDialog(this, "The least used ingredients was " + mostUsed.getName());
    }//GEN-LAST:event_btnLeastActionPerformed

    
    
    private int totalNumber(){
        int count = 0;
        for (Map.Entry<Ingredient, Integer> i : ingQuantity.entrySet()) {
            count += i.getValue();
        }
        return count;
    }
    
    private double totalPrice(){
        double count = 0;
        for (Map.Entry<Ingredient, Integer> i : ingQuantity.entrySet()) {
            count += i.getKey().getPrice() * i.getValue();
        }
        return count;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAverage;
    private javax.swing.JButton btnLeast;
    private javax.swing.JButton btnMost;
    private javax.swing.JButton btnPrice;
    private javax.swing.JButton btnTotal;
    private javax.swing.JList<String> ingList;
    private javax.swing.JScrollPane ingredientsList;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
