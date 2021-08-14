/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.FosterAdmin;

import Business.Child.Child;
import Business.Child.ChildDirectory;
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
            row[4] = child.getMedicalStatus();
            if(child.isIsAdopted()==true){
                row[5] = "ADOPTED";
            }
            else if(child.isIsAdopted()==false){
                row[5] = "NOT ADOPTED";
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

        jPanel1.setBackground(new java.awt.Color(204, 255, 0));

        jPanel2.setBackground(new java.awt.Color(153, 153, 0));

        tbl_childlist.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbl_childlist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ChildName", "Gender", "Race", "Religion", "MedicalCheckStatus", "isAdopted"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        btn_refresh.setBackground(new java.awt.Color(51, 51, 51));
        btn_refresh.setText("Refresh");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        btn_seeDetails.setBackground(new java.awt.Color(51, 51, 51));
        btn_seeDetails.setText("See Details");
        btn_seeDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_seeDetailsActionPerformed(evt);
            }
        });

        btn_delete.setBackground(new java.awt.Color(51, 51, 51));
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_requestmedical.setBackground(new java.awt.Color(51, 51, 51));
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
            .addGroup(panel_requestmedicalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_requestmedical, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_requestmedicalLayout.setVerticalGroup(
            panel_requestmedicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_requestmedicalLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_requestmedical))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_refresh)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(86, 86, 86)
                            .addComponent(btn_seeDetails)
                            .addGap(18, 18, 18)
                            .addComponent(btn_delete)
                            .addGap(18, 18, 18)
                            .addComponent(panel_requestmedical, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(627, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_requestmedical, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_seeDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(150, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        else if(!selected_child.isIsAdopted()==true){
        RequestMedicalCheckJpanel requestmedicalcheckjpanel = new RequestMedicalCheckJpanel(business, userProcessContainer,enterprise,organization,selected_child,account,rightpanel1);
        userProcessContainer.add(requestmedicalcheckjpanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        JOptionPane.showMessageDialog(rightpanel1, "Your request for medical check has been sent!");
        populateTable();
        }
        else if(selected_child.isIsAdopted()==true){
            JOptionPane.showMessageDialog(rightpanel1, "CHILD MEDICAL REQUEST CANt be Processed because it's ADOPTED");
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JButton btn_requestmedical;
    private javax.swing.JButton btn_seeDetails;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel_requestmedical;
    private javax.swing.JTable tbl_childlist;
    // End of variables declaration//GEN-END:variables
}
