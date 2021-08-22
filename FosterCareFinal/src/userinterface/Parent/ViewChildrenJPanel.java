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
                            || parent.getPreference_child_religion().equals(child.getReligion())
                            || (parent.getPreference_child_handicapacceptance().equals("Willing to foster handicap")
                                && child.isIsSpecialChild())){
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
                            if(child.isIsSpecialChild()== true){
                                row[5] = "Yes";
                            }
                            else if(child.isIsSpecialChild() == false){
                                row[5] = "No";
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
            Object[] row = new Object[model.getColumnCount()];
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
             if(child.isIsSpecialChild()== true){
                row[5] = "Yes";
              }
             else if(child.isIsSpecialChild() == false){
                row[5] = "No";
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(204, 255, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 153, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_childlist.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbl_childlist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ChildName", "Gender", "Race", "Religion", "IsAdopted", "SpecialChild"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_childlist);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 780, 230));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 780, 258));

        btn_viewProfile.setBackground(new java.awt.Color(51, 51, 51));
        btn_viewProfile.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_viewProfile.setForeground(new java.awt.Color(255, 255, 255));
        btn_viewProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/vieww.png"))); // NOI18N
        btn_viewProfile.setText("View Profile");
        btn_viewProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewProfileActionPerformed(evt);
            }
        });
        jPanel1.add(btn_viewProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 460, 190, 50));

        check_prefer.setText("Your Preference");
        check_prefer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_preferActionPerformed(evt);
            }
        });
        jPanel1.add(check_prefer, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 98, -1, -1));

        check_all.setText("All Children");
        check_all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_allActionPerformed(evt);
            }
        });
        jPanel1.add(check_all, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 98, 89, -1));

        jLabel1.setBackground(new java.awt.Color(153, 153, 0));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/viewchildren.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 840, 640));

        jLabel2.setBackground(new java.awt.Color(153, 153, 0));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("LIST OF CHILDREN");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_childlist;
    // End of variables declaration//GEN-END:variables
}
