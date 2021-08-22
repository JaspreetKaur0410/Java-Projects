/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.FosterAdmin;

import Business.Child.Child;
import Business.Child.ChildDirectory;
import Business.Child.ChildLabTests;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jaspr
 */
public class ListOfChildrenJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ListOfChildrenJPanel
     */
    EcoSystem business;
    JPanel userProcessContainer;
    Enterprise enterprise;
    Organization organization;
    ChildDirectory childdir;
    JPanel rightpanel1;
    UserAccount account;
    public ListOfChildrenJPanel(EcoSystem business, JPanel userProcessContainer,
            Enterprise enterprise,Organization organization,ChildDirectory childdir,
            JPanel rightpanel1,UserAccount account) {
        initComponents();
        this.business = business;
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.organization = organization;
        this.rightpanel1 = rightpanel1;
        this.childdir = organization.getChildDirectory();
        this.account = account;
        
       

        populateTable();
    }
    
    public void checkStatus(int selectedRow){
        DefaultTableModel model = (DefaultTableModel) tbl_childlist.getModel();
        String isAdopted = (String)tbl_childlist.getValueAt(selectedRow, 5);
        
        
    }
    
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel) tbl_childlist.getModel();
        model.setRowCount(0);
       
        for(Child child:childdir.getChildlist()){
            
            Object[] row = new Object[model.getColumnCount()];
            row[0] = child;
            row[1] = child.getGender();
            row[2] = child.getRace();
            row[3] = child.getReligion();
/* ************************************************************************************************* */
            
                       
            //JOptionPane.showMessageDialog(rightpanel1, child.getVitallist());
            //JOptionPane.showMessageDialog(rightpanel1, child.getLabtestlist());
            //JOptionPane.showMessageDialog(rightpanel1, child.isIsLabTestNormal());
            //JOptionPane.showMessageDialog(rightpanel1, child.isIsVitalSignNormal());
            if(!child.isIsAdopted()){
            if((child.isMedicalHelp()) && (child.getLabtestlist() == null)
                    || child.getVitallist() == null
                    || child.getPrescriptionslist() == null){
               row[4] = "HealthcareRqusted";
               row[5] = "HealthcareRqusted";
            }
            
            if((child.isMedicalHelp()) && (child.getLabtestlist() != null)
                    || child.getVitallist() != null
                    || child.getPrescriptionslist() != null){
            
          
            if(child.isIsMediacted()){
                row[4] = "MEDICATED";
                row[5] = "MEDICATED";
            }
            
            else if(child.getVitallist() != null){
                //JOptionPane.showMessageDialog(rightpanel1, "Helo1");
                if(child.isIsVitalSignNormal()){
                    //JOptionPane.showMessageDialog(rightpanel1, "Helo2");
                    row[5] = "Vitals Normal";
                    
                    if(child.getLabtestlist() != null){
                        //JOptionPane.showMessageDialog(rightpanel1, "Helo3");
                        for(ChildLabTests clt:child.getLabtestlist()){
                            //JOptionPane.showMessageDialog(rightpanel1, "Helo4");
                            if(clt.isIsBloodTestNormal() && clt.isIsUrineTestNormal()){
                                //JOptionPane.showMessageDialog(rightpanel1, "Helo5");
                                row[4] = "HEALTHY";
                                row[5] = "LabTests Normal";
                            }
                            else if(!clt.isIsBloodTestNormal() && !clt.isIsUrineTestNormal()){
                                row[4] = "NOT HEALTHY";
                                row[5] = "Tests Not Normal";
                            }
                        }
                    }
                    
                }
                else if(!child.isIsVitalSignNormal()){
                    row[5] = "Vitals Not Normal";
                    
                    if(child.getLabtestlist() != null){
                        //JOptionPane.showMessageDialog(rightpanel1, "Helo3");
                        for(ChildLabTests clt:child.getLabtestlist()){
                            //JOptionPane.showMessageDialog(rightpanel1, "Helo4");
                            if(clt.isIsBloodTestNormal() && clt.isIsUrineTestNormal()){
                                //JOptionPane.showMessageDialog(rightpanel1, "Helo5");
                                row[4] = "HEALTHY";
                                row[5] = "LabTests Normal";
                            }
                            else if(!clt.isIsBloodTestNormal() && !clt.isIsUrineTestNormal()){
                                row[4] = "NOT HEALTHY";
                                row[5] = "Tests Not Normal";
                            }
                        }
                    }
                }
                    
                
            }
            else if(child.getVitallist() == null){
                
                if(child.getLabtestlist() != null){
                        //JOptionPane.showMessageDialog(rightpanel1, "Helo3");
                        for(ChildLabTests clt:child.getLabtestlist()){
                            //JOptionPane.showMessageDialog(rightpanel1, "Helo4");
                            if(clt.isIsBloodTestNormal() && clt.isIsUrineTestNormal()){
                                //JOptionPane.showMessageDialog(rightpanel1, "Helo5");
                                row[4] = "HEALTHY";
                                row[5] = "LabTests Normal";
                            }
                            else if(!clt.isIsBloodTestNormal() && !clt.isIsUrineTestNormal()){
                                row[4] = "NOT HEALTHY";
                                row[5] = "Tests Not Normal";
                            }
                        }
                    }
    
            }
            
            else{
                JOptionPane.showMessageDialog(rightpanel1, "Helo7");
                row[4] = "NOT HEALTHY";
                row[5] = "NOT HEALTHY";
            }
            }
            }
            else{
                row[4] = "NO STATUS";
                row[5] = "NO STATUS";
            }
/* ...................................................................................................*/   
            if(child.isIsAdopted()==true){
                row[6] = "ADOPTED";
            }
            else if(child.isIsAdopted()==false){
                row[6] = "NOT ADOPTED";
            }
            if(child.isIsSpecialChild()==true){
                row[7] = "Yes";
            }
            else if(child.isIsSpecialChild()==false){
                row[7] = "NO";
            }
            model.addRow(row);
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_childlist = new javax.swing.JTable();
        btn_refresh = new javax.swing.JButton();
        btn_seeDetails = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        panel_requestmedical = new javax.swing.JPanel();
        btn_requestmedical = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 255, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 153, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_childlist.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbl_childlist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ChildName", "Gender", "Race", "Religion", "MedicalCheckStatus", "Health Status", "isAdopted", "SpecialChild"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_childlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_childlistMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_childlist);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 9, 1000, 240));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 1000, 256));

        btn_refresh.setBackground(new java.awt.Color(255, 255, 255));
        btn_refresh.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_refresh.setForeground(new java.awt.Color(255, 255, 255));
        btn_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/refresh.png"))); // NOI18N
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });
        jPanel1.add(btn_refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 80, 30, 30));

        btn_seeDetails.setBackground(new java.awt.Color(51, 51, 51));
        btn_seeDetails.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_seeDetails.setForeground(new java.awt.Color(255, 255, 255));
        btn_seeDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/seedetials.png"))); // NOI18N
        btn_seeDetails.setText("See Details");
        btn_seeDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_seeDetailsActionPerformed(evt);
            }
        });
        jPanel1.add(btn_seeDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, -1, 39));

        btn_delete.setBackground(new java.awt.Color(51, 51, 51));
        btn_delete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete.png"))); // NOI18N
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        jPanel1.add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, 139, 39));

        btn_requestmedical.setBackground(new java.awt.Color(51, 51, 51));
        btn_requestmedical.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_requestmedical.setForeground(new java.awt.Color(255, 255, 255));
        btn_requestmedical.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/medicalcheck.png"))); // NOI18N
        btn_requestmedical.setText("Request Medical Check");
        btn_requestmedical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_requestmedicalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_requestmedicalLayout = new javax.swing.GroupLayout(panel_requestmedical);
        panel_requestmedical.setLayout(panel_requestmedicalLayout);
        panel_requestmedicalLayout.setHorizontalGroup(
            panel_requestmedicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_requestmedical, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_requestmedicalLayout.setVerticalGroup(
            panel_requestmedicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_requestmedical, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(panel_requestmedical, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 400, -1, -1));

        jLabel1.setBackground(new java.awt.Color(153, 153, 0));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("CHILDREN IN OUR AGENCY");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 29, -1, -1));
        jPanel1.add(txt_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 80, 156, 28));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 80, 34, 28));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1152, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        // TODO add your handling code here:
        populateTable();
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void btn_seeDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_seeDetailsActionPerformed
        // TODO add your handling code here:
         
        DefaultTableModel model = (DefaultTableModel) tbl_childlist.getModel();
        
        int selectedrow = tbl_childlist.getSelectedRow();
        Child selected_child = (Child)model.getValueAt(selectedrow, 0);
        if(selectedrow < 0){
            JOptionPane.showMessageDialog(jPanel1, "Please selct chid");
            return;
        }
        
        for(Child child:childdir.getChildlist()){
            if(child.getUsername().equals(selected_child.getUsername())){
                SeeChildDetailsJPanel seedetails = new SeeChildDetailsJPanel(userProcessContainer,business,child,rightpanel1);
                userProcessContainer.add(seedetails);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.next(userProcessContainer);
            }
        }
        
        
        
    }//GEN-LAST:event_btn_seeDetailsActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tbl_childlist.getModel();
        
        int selectedrow = tbl_childlist.getSelectedRow();
        Child selected_child = (Child)model.getValueAt(selectedrow, 0);
        if(selectedrow < 0){
            JOptionPane.showMessageDialog(jPanel1, "Please selct chid");
            return;
        }
        for(Child child:childdir.getChildlist()){
            if(child.getUsername().equals(selected_child.getUsername())){
                childdir.removeChild(child);
                //business.getUserAccountDirectory().deleteUser(child.getUsername(), child.getPassword());
                JOptionPane.showMessageDialog(jPanel1, "Child Removed");
                populateTable();
            
        }
            
        }

    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_requestmedicalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_requestmedicalActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel model = (DefaultTableModel) tbl_childlist.getModel();
        
        int selectedrow = tbl_childlist.getSelectedRow();
        if(selectedrow<0){
            JOptionPane.showMessageDialog(rightpanel1, "Please select child");
            return;
        }
        Child selected_child = (Child)model.getValueAt(selectedrow, 0);
        if(selectedrow < 0){
            JOptionPane.showMessageDialog(jPanel1, "Please selct chid");
            return;
        }
        else if(selected_child.isMedicalHelp()){
           JOptionPane.showMessageDialog(jPanel2, "Request Already in Process");
           return;
        }
        else if(!selected_child.isIsAdopted()==true){
        RequestMedicalCheckJpanel requestmedicalcheckjpanel = new RequestMedicalCheckJpanel(business, userProcessContainer,enterprise,organization,selected_child,account,rightpanel1);
        userProcessContainer.add(requestmedicalcheckjpanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        //JOptionPane.showMessageDialog(rightpanel1, "Your request for medical check has been sent!");
        populateTable();
        }
        else if(selected_child.isIsAdopted()==true){
            JOptionPane.showMessageDialog(jPanel2, "CHILD MEDICAL REQUEST CAN'T be Processed because it's ADOPTED");
        }

    }//GEN-LAST:event_btn_requestmedicalActionPerformed

    private void tbl_childlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_childlistMouseClicked
        // TODO add your handling code here:
         tbl_childlist.addMouseListener(new MouseAdapter() {
           
            public void mousePressed(MouseEvent e) {
              int selectedRow = tbl_childlist.getSelectedRow();
              checkStatus(selectedRow);
            }
           
       });
        
    }//GEN-LAST:event_tbl_childlistMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tbl_childlist.getModel();
        model.setRowCount(0);
        for(Child child:childdir.getChildlist()){
            if(child.getFirstname().equals(txt_search.getText())){
                
            Object[] row = new Object[model.getColumnCount()];
            row[0] = child;
            row[1] = child.getGender();
            row[2] = child.getRace();
            row[3] = child.getReligion();
/* ************************************************************************************************* */
            
                       
            //JOptionPane.showMessageDialog(rightpanel1, child.getVitallist());
            //JOptionPane.showMessageDialog(rightpanel1, child.getLabtestlist());
            //JOptionPane.showMessageDialog(rightpanel1, child.isIsLabTestNormal());
            //JOptionPane.showMessageDialog(rightpanel1, child.isIsVitalSignNormal());
            
            
            if(child.isIsLabTestNormal() == true){
                //JOptionPane.showMessageDialog(rightpanel1, "Helo6");
                row[4] = "HEALTHY";
                row[5] = "MEDICATION PROVIDED";
            }
            else if(child.getVitallist() != null){
                //JOptionPane.showMessageDialog(rightpanel1, "Helo1");
                if(child.isIsVitalSignNormal()){
                    //JOptionPane.showMessageDialog(rightpanel1, "Helo2");
                    row[5] = "Vitals not Normal";
                    if(child.getLabtestlist() != null){
                        //JOptionPane.showMessageDialog(rightpanel1, "Helo3");
                        for(ChildLabTests clt:child.getLabtestlist()){
                            //JOptionPane.showMessageDialog(rightpanel1, "Helo4");
                            if(clt.isIsBloodTestNormal() && clt.isIsUrineTestNormal()){
                                //JOptionPane.showMessageDialog(rightpanel1, "Helo5");
                                row[4] = "HEALTHY";
                                row[5] = "LabTests Not Normal";
                            }
                        }
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(rightpanel1, "Helo7");
                row[4] = "NOT HEALTHY";
                row[5] = "FIT AND FINE";
            }
/* ...................................................................................................*/   
            if(child.isIsAdopted()==true){
                row[6] = "ADOPTED";
            }
            else if(child.isIsAdopted()==false){
                row[6] = "NOT ADOPTED";
            }
            if(child.isIsSpecialChild()==true){
                row[7] = "Yes";
            }
            else if(child.isIsSpecialChild()==false){
                row[7] = "NO";
            }
            model.addRow(row);
                
                
            }
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JButton btn_requestmedical;
    private javax.swing.JButton btn_seeDetails;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel_requestmedical;
    private javax.swing.JTable tbl_childlist;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
