/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Parent;

import Business.Child.Child;
import Business.Child.ChildDirectory;
import Business.EcoSystem;
import Business.Parent.Parent;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.System.Logger;
import java.util.logging.Level;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.FosterAdmin.SeeChildDetailsJPanel;

/**
 *
 * @author jaspr
 */
public class ViewChildrenJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewChildrenJPanel
     */
    EcoSystem system;
    JPanel userProcessContainer;
    ChildDirectory childDirectory;
    UserAccount account;
    Parent parent;
    JPanel rightpanel1;

    public ViewChildrenJPanel(EcoSystem system, JPanel userProcessContainer, 
                                ChildDirectory childDirectory,UserAccount account,
                                JPanel rightpanel,Parent parent) {
        initComponents();
        this.system = system;
        this.userProcessContainer = userProcessContainer;
        this.childDirectory = childDirectory;
        this.account = account;
        rightpanel1 = rightpanel;
        this.parent = parent;
        
        populateTable();
       
        //JOptionPane.showMessageDialog(rightpanel, parent);
    }
    
    public void populatePreferenceTable(){
        DefaultTableModel model = (DefaultTableModel) tbl_childlist.getModel();
        model.setRowCount(0);
        
        for(Child child:childDirectory.getChildlist()){
            //for(Child child:c.getOrg().getChildDirectory().getChildlist()){
            for(Parent parent :system.getParentDirectory().getParentlist()){
                if(parent.getUsername().equals(account.getUsername())){
                    if(String.valueOf(parent.getPreference_child_age()).equals(child.getAge())
                            || parent.getRace().equals(child.getRace())
                            || parent.getPreference_child_religion().equals(child.getReligion())){
                            Object[] row = new Object[5];
                            row[0] = child;
                            row[1] = child.getGender();
                            row[2] = child.getRace();
                            row[3] = child.getReligion();
                           
                            if(child.isIsAdopted() == true){
                                row[4] = "Adopted";
                            }
                            else if(child.isIsAdopted() == false){
                                row[4] = "Not Adopted Yet";
                            }
                            model.addRow(row);
                    }
                }
                //}
            }
            
        }
    }
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel) tbl_childlist.getModel();
        model.setRowCount(0);
        
        for(Child child:childDirectory.getChildlist()){
            //for(Child child:c.getOrg().getChildDirectory().getChildlist()){
                //JOptionPane.showMessageDialog(rightpanel1, child.isIsAdopted());
            Object[] row = new Object[5];
            row[0] = child;
            row[1] = child.getGender();
            row[2] = child.getRace();
            row[3] = child.getReligion();
             if(child.isIsAdopted() == true){
                 row[4] = "Adopted";
             }
             else if(child.isIsAdopted() == false){
                 row[4] = "Not Adopted Yet";
             } 
            model.addRow(row);
            }
        //}
    }
    
   
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_childlist = new javax.swing.JTable();
        btn_viewProfile = new javax.swing.JButton();
        check_prefer = new javax.swing.JCheckBox();
        check_all = new javax.swing.JCheckBox();

        jPanel1.setBackground(new java.awt.Color(204, 255, 0));

        jPanel2.setBackground(new java.awt.Color(153, 153, 0));

        tbl_childlist.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbl_childlist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ChildName", "Gender", "Race", "Religion", "IsAdopted"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_childlist);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        btn_viewProfile.setBackground(new java.awt.Color(51, 51, 51));
        btn_viewProfile.setText("View Profile");
        btn_viewProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewProfileActionPerformed(evt);
            }
        });

        check_prefer.setText("Your Preference");
        check_prefer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_preferActionPerformed(evt);
            }
        });

        check_all.setText("All Children");
        check_all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_allActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(363, 363, 363)
                        .addComponent(btn_viewProfile))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(check_prefer)
                        .addGap(18, 18, 18)
                        .addComponent(check_all, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(542, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(check_prefer)
                    .addComponent(check_all))
                .addGap(35, 35, 35)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btn_viewProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(251, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1273, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 715, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_viewProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewProfileActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tbl_childlist.getModel();
        
        int selectedrow = tbl_childlist.getSelectedRow();
        Child selected_child = (Child)model.getValueAt(selectedrow, 0);
        if(selectedrow < 0){
            JOptionPane.showMessageDialog(jPanel1, "Please selct chid");
            return;
        }
        
        for(Child child:childDirectory.getChildlist()){
            if(child.getUsername().equals(selected_child.getUsername())){
                //JOptionPane.showMessageDialog(rightpanel1, child);
                //JOptionPane.showMessageDialog(rightpanel1, parent);
                SeeChildDetailsParentJPanel seedetails = new SeeChildDetailsParentJPanel(userProcessContainer,system,child,parent,rightpanel1);
                userProcessContainer.add(seedetails);
                
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.next(userProcessContainer);
            }
        }
        
        

    }//GEN-LAST:event_btn_viewProfileActionPerformed

    private void check_preferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_preferActionPerformed
        // TODO add your handling code here:
        populatePreferenceTable();
    }//GEN-LAST:event_check_preferActionPerformed

    private void check_allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_allActionPerformed
        // TODO add your handling code here:
        populateTable();
    }//GEN-LAST:event_check_allActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_viewProfile;
    private javax.swing.JCheckBox check_all;
    private javax.swing.JCheckBox check_prefer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_childlist;
    // End of variables declaration//GEN-END:variables
}
