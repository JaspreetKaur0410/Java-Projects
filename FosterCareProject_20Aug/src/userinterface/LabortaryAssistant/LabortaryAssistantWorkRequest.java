/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.LabortaryAssistant;

import Business.Child.Child;
import Business.Child.ChildDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Parent.ParentDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.LabWorkRequest;
import Business.WorkQueue.MedicalCheckRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.Doctor.DoctorCheckupJPanel;

/**
 *
 * @author jaspr
 */

public class LabortaryAssistantWorkRequest extends javax.swing.JPanel {
    EcoSystem business;
    UserAccount account;
    JPanel userProcessContainer;
    Enterprise enterprise;
    Organization organization;
    ChildDirectory childdir;
    ParentDirectory parentdir;
    JPanel rightpanel1;
    /**
     * Creates new form LabortaryAssistantWorkRequest
     */
    public LabortaryAssistantWorkRequest(EcoSystem business, UserAccount account,
                                    JPanel userProcessContainer,Enterprise enterprise,
                                    Organization organization,
                                    ChildDirectory childdir,ParentDirectory parentdir,
                                    JPanel rightpanel1) {
        initComponents();
        this.business = business;
        this.account = account;
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.organization = organization;
        this.childdir = childdir;
        this.parentdir = parentdir;
        this.rightpanel1 = rightpanel1;
        
        panel_assign.setVisible(false);
        btn_assign.setVisible(false);
        panel_checkup.setVisible(false);
        btn_checkup.setVisible(false);
        

        populateTable();
    }
    
     public void checkStatus(int selectedRow){
        DefaultTableModel model = (DefaultTableModel) tbl_lab.getModel();
        Object statusval = tbl_lab.getValueAt(selectedRow, 5);
        WorkRequest workrequest = (WorkRequest)tbl_lab.getValueAt(selectedRow, 7);
        
        if(statusval.equals("Lab Test Requested")){
            panel_assign.setVisible(true);
            btn_assign.setVisible(true);
            panel_checkup.setVisible(false);
            btn_checkup.setVisible(false); 
        }
        else if(statusval.equals("LabTest Processing")){
            panel_assign.setVisible(false);
            btn_assign.setVisible(false);
            panel_checkup.setVisible(true);
            btn_checkup.setVisible(true);
        }
        else if(statusval.equals("LabTest Done")){
           panel_assign.setVisible(false);
           btn_assign.setVisible(false);
           panel_checkup.setVisible(true);
           btn_checkup.setVisible(true);
           
           
           for(WorkRequest wr:((WorkRequest)workrequest).getSender().getWorkQueue().getWorkRequestList()){
                wr.setStatus("LabTest Done");
                wr.setMessage("LabTest Done");
                //JOptionPane.showMessageDialog(rightpanel1, wr);
               
           }

        }
               //JOptionPane.showMessageDialog(rightpanel1, 
                   //((WorkRequest)workrequest).getSender().getWorkQueue().getWorkRequestList());
        
        
     }
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel) tbl_lab.getModel();
        model.setRowCount(0);
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
            
            if (request instanceof LabWorkRequest) {
                Object[] row = new Object[model.getColumnCount()];
                row[0] = request.getSender().getUsername();
                row[1] = "DoctorOrganisation";
                row[2] = request.getMessage();
                row[3] = request.getSender();
                row[4] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
                //String result = ((MedicalCheckRequest) request).getTestResult();
                row[5] = request.getStatus();
                row[6] = request.getChild();
                row[7] = request;
                model.addRow(row);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_lab = new javax.swing.JTable();
        panel_assign = new javax.swing.JPanel();
        btn_assign = new javax.swing.JButton();
        panel_checkup = new javax.swing.JPanel();
        btn_checkup = new javax.swing.JButton();

        jPanel5.setBackground(new java.awt.Color(204, 255, 0));

        jPanel6.setBackground(new java.awt.Color(153, 153, 0));

        tbl_lab.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbl_lab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Sender UserName", "Sender Organisation", "Message", "Sender Name", "Reciever Name", "Status", "Child To Check", "WorkRequest"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, true, true, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_lab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_labMouseClicked(evt);
            }
        });
        tbl_lab.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tbl_labPropertyChange(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_lab);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 847, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        panel_assign.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_assign.setText("Assign To Me");
        btn_assign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_assignActionPerformed(evt);
            }
        });
        panel_assign.add(btn_assign, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        panel_checkup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_checkup.setText("Proceed for Checkup");
        btn_checkup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_checkupActionPerformed(evt);
            }
        });
        panel_checkup.add(btn_checkup, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(panel_assign, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panel_checkup, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(350, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_assign, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(panel_checkup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(175, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1227, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 541, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_labMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_labMouseClicked
        // TODO add your handling code here:
        tbl_lab.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                int selectedRow = tbl_lab.getSelectedRow();
                checkStatus(selectedRow);
            }

        });

    }//GEN-LAST:event_tbl_labMouseClicked

    private void tbl_labPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tbl_labPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_labPropertyChange

    private void btn_assignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_assignActionPerformed
        // TODO add your handling code here:
        int selectedRow = tbl_lab.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a work request");
            return;
        }
        
        Object receiverval = tbl_lab.getValueAt(selectedRow, 4);
        Object statusval = tbl_lab.getValueAt(selectedRow, 5);
        Child childval = (Child) tbl_lab.getValueAt(selectedRow,6);
       

        if ("Lab Test Requested".equals(statusval) || receiverval == null) {
            LabWorkRequest lwr = (LabWorkRequest) tbl_lab.getValueAt(selectedRow, 7);
            lwr.setReceiver(account);
            lwr.setStatus("LabTest Processing");
            lwr.setChild(childval);
            lwr.setMessage("LabTest Processing");
            
            populateTable();
            JOptionPane.showMessageDialog(null, "Work request is now assigned to you");
            checkStatus(selectedRow);
            populateTable();
       
        }
         else{
            if (receiverval.equals(account)) {
                JOptionPane.showMessageDialog(null, "Work request is already assigned to you");
            }
            else if (!receiverval.equals(account.getUsername())) {
                JOptionPane.showMessageDialog(null, "Work request is assigned to someone else");
                checkStatus(selectedRow);
            }
        }
    }//GEN-LAST:event_btn_assignActionPerformed

    private void btn_checkupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_checkupActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tbl_lab.getModel();
        int selectedRow = tbl_lab.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a child from table before proceeding");
            return;
        }
        LabWorkRequest lwr = (LabWorkRequest) tbl_lab.getValueAt(selectedRow, 7);
        Child childval = (Child)tbl_lab.getValueAt(selectedRow, 6);
        LabCheckUpJPanel doctorjpanel = new LabCheckUpJPanel(business, 
                                                         account,userProcessContainer,enterprise,
                                                        organization,childdir,rightpanel1,childval,lwr);
        userProcessContainer.add(doctorjpanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
     
    }//GEN-LAST:event_btn_checkupActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_assign;
    private javax.swing.JButton btn_checkup;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panel_assign;
    private javax.swing.JPanel panel_checkup;
    private javax.swing.JTable tbl_lab;
    // End of variables declaration//GEN-END:variables
}
