/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ReinAccountant;

import Business.Child.Child;
import Business.Child.ChildDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Parent.Parent;
import Business.Parent.ParentDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ReinTransferMoneyRequest;
import Business.WorkQueue.ReinbursementsWorkRequest;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.ReinbursementsManager.*;

/**
 *
 * @author jaspr
 */
public class TransferMoneyJpanel extends javax.swing.JPanel {

    /**
     * Creates new form TransferMoneyJpanel
     */
    EcoSystem business;
    UserAccount account;
    JPanel userProcessContainer;
    Enterprise enterprise;
    Organization organization;
    ChildDirectory childdir;
    ParentDirectory parentdir;
    JPanel rightpanel1;
    public TransferMoneyJpanel(EcoSystem business, UserAccount account,
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
        panel_transfer.setVisible(false);
        btn_transfer.setVisible(false);
        panel_notify.setVisible(false);
        btn_notify.setVisible(false);
        
        populateTable();

    }
    
     public void populateTable(){
        DefaultTableModel model = (DefaultTableModel) tbl_fin.getModel();
        model.setRowCount(0);
        //JOptionPane.showMessageDialog(panel_approve, organization.getWorkQueue().getWorkRequestList());
        
        for(WorkRequest wr:organization.getWorkQueue().getWorkRequestList()){
            //JOptionPane.showMessageDialog(panel_approve, wr instanceof ReinbursementsWorkRequest);
            if(wr instanceof ReinTransferMoneyRequest ||
                    (wr instanceof ReinbursementsWorkRequest)){
                Object[] row = new Object[model.getColumnCount()];
                row[0] = wr.getSender();
                row[1] = wr.getReceiver() == null ? null : account;
                
                if(wr.getMessage().equals("Payment Recieved")){
                    row[2] = "Payment Done";
                }
                else{
                    row[2] = wr.getMessage();
                }
                
                if(wr instanceof ReinTransferMoneyRequest){
                    row[3] = ((ReinTransferMoneyRequest) wr).getAmount();
                }
                else if(wr instanceof ReinbursementsWorkRequest){
                    row[3] = ((ReinbursementsWorkRequest) wr).getAmount();
                }
                
                if(wr.getMessage().equals("Payment Recieved") && (wr instanceof ReinTransferMoneyRequest)){
                    row[4] = ((ReinTransferMoneyRequest) wr).getRequested();
                }
                else if(wr instanceof ReinbursementsWorkRequest && wr.getMessage().equals("Payment Recieved")){
                    row[4] = ((ReinbursementsWorkRequest) wr).getRequested();
                }
                
               if(wr.equals("Payment Recieved")){
                   row[5] = "Payment Done";
               }
               else{
                    row[5] = wr.getStatus();
                }
                
               
                row[6] = wr.getChild();
                
               
                
                row[7] = wr.getParent();
                
                if(wr.getMessage().equals("Payment Recieved")){
                    wr.setMessage("Payment Done");
                    row[8] = wr;
                }
                else{
                    row[8] = wr;
                }
                model.addRow(row);
            }
        }
    }
    
     private void checkStatus(int selectedRow){
         
        DefaultTableModel model = (DefaultTableModel) tbl_fin.getModel();
        Object statusval = tbl_fin.getValueAt(selectedRow, 5);
        
        Child childval = (Child) tbl_fin.getValueAt(selectedRow,6);   
        if(childval != null){
        Parent parentval = (Parent) tbl_fin.getValueAt(selectedRow,7);
        ReinTransferMoneyRequest workrequest = (ReinTransferMoneyRequest) tbl_fin.getValueAt(selectedRow, 8);
        
            
         
        //CONVERT LOCAL DATE TO DATE
        LocalDateTime now = LocalDateTime.now();
        ZoneId defaultzoneid = ZoneId.systemDefault();
        ZonedDateTime zdt = now.atZone(defaultzoneid);
        Date to_Date_now = Date.from(zdt.toInstant());
         
        if(statusval.equals("Approved for Transfer")){
            panel_assign.setVisible(true);
            btn_assign.setVisible(true);
            panel_transfer.setVisible(false);
            btn_transfer.setVisible(false);
        }
        else if(statusval.equals("Transferring")){
            panel_assign.setVisible(false);
            btn_assign.setVisible(false);
            panel_transfer.setVisible(true);
            btn_transfer.setVisible(true);
        }
        else if(statusval.equals("Payment Recieved") || statusval.equals("Payment Done")){
            if(workrequest.getChild() != null){
                panel_notify.setVisible(true);
                btn_notify.setVisible(true);
                
                 for(WorkRequest wr:parentval.getWorkQueue().getWorkRequestList()){
                //if(wr instanceof ReinTransferMoneyRequest){
                //if(wr.equals(workrequest)){
                    wr.setMessage("Payment Recieved");
                    wr.setStatus("Payment Recieved");
                    //((ReinTransferMoneyRequest)wr).setAmount(workrequest.getAmount());
                    wr.setChild(childval);
                    wr.setParent(parentval);
                    wr.setRequestDate(to_Date_now);
                    wr.setSender(account);
                //}
                //}
            }
            
            for(WorkRequest wr:workrequest.getSender().getWorkQueue().getWorkRequestList()){
                //if(wr instanceof ReinbursementsWorkRequest){
                //if(wr.equals(workrequest)){
                    wr.setMessage("Payment Done");
                    wr.setStatus("Payment Done");
                    //((ReinTransferMoneyRequest)wr).setAmount(workrequest.getAmount());
                    wr.setChild(childval);
                    wr.setParent(parentval);
                    //((ReinTransferMoneyRequest)wr).setRecieved(to_Date_now);
                    wr.setSender(account);
                //}
                //}
            }
                
            }
            else{
               panel_notify.setVisible(false);
               btn_notify.setVisible(false); 
               WorkRequest w2 = (WorkRequest) workrequest;
               for(WorkRequest wr:workrequest.getSender().getWorkQueue().getWorkRequestList()){
                JOptionPane.showMessageDialog(null, wr.equals(w2));
                w2.setMessage("Payment Done");
                w2.setStatus("Payment Done");
                //w2.setAmount(workrequest.getAmount());
                //w2.setRecieved(to_Date_now);
                //w2.setRecieved(workrequest.getRecieved());
            }
            }
        }
            
        }
        
        
        else if(childval == null){
            
            
        LocalDateTime now = LocalDateTime.now();
        ZoneId defaultzoneid = ZoneId.systemDefault();
        ZonedDateTime zdt = now.atZone(defaultzoneid);
        Date to_Date_now = Date.from(zdt.toInstant());
        ReinbursementsWorkRequest workrequest = (ReinbursementsWorkRequest) tbl_fin.getValueAt(selectedRow, 8);
        if(statusval.equals("Approved for Transfer")){
            panel_assign.setVisible(true);
            btn_assign.setVisible(true);
            panel_transfer.setVisible(false);
            btn_transfer.setVisible(false);
        }
        else if(statusval.equals("Transferring")){
            panel_assign.setVisible(false);
            btn_assign.setVisible(false);
            panel_transfer.setVisible(true);
            btn_transfer.setVisible(true);
        }
        else if(statusval.equals("Payment Recieved") || statusval.equals("Payment Done")){
            
               panel_notify.setVisible(false);
               btn_notify.setVisible(false); 
               WorkRequest w2 = (WorkRequest) workrequest;
               for(WorkRequest wr:workrequest.getSender().getWorkQueue().getWorkRequestList()){
                JOptionPane.showMessageDialog(null, wr.equals(w2));
                w2.setMessage("Payment Done");
                w2.setStatus("Payment Done");
                //w2.setAmount(workrequest.getAmount());
                //w2.setRecieved(to_Date_now);
                //w2.setRecieved(workrequest.getRecieved());
            }
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
        tbl_fin = new javax.swing.JTable();
        panel_assign = new javax.swing.JPanel();
        btn_assign = new javax.swing.JButton();
        panel_transfer = new javax.swing.JPanel();
        btn_transfer = new javax.swing.JButton();
        panel_notify = new javax.swing.JPanel();
        btn_notify = new javax.swing.JButton();

        jPanel5.setBackground(new java.awt.Color(204, 255, 0));

        jPanel6.setBackground(new java.awt.Color(153, 153, 0));

        tbl_fin.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbl_fin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Sender", "Reciever", "Message", "Amount Requested", "Date Requested", "Status", "Child", "Parent", "WorkRequest"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, true, true, true, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_fin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_finMouseClicked(evt);
            }
        });
        tbl_fin.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tbl_finPropertyChange(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_fin);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1026, Short.MAX_VALUE)
                .addContainerGap())
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
        panel_assign.add(btn_assign, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        panel_transfer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_transfer.setText("Proceed To Transfer money");
        btn_transfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transferActionPerformed(evt);
            }
        });
        panel_transfer.add(btn_transfer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        panel_notify.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_notify.setText("Notify Parent and Mangaer");
        btn_notify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_notifyActionPerformed(evt);
            }
        });
        panel_notify.add(btn_notify, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

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
                        .addComponent(panel_transfer, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panel_notify, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(446, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_assign, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(panel_transfer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_notify, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(230, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1502, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_assignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_assignActionPerformed
      int selectedRow = tbl_fin.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tbl_fin.getModel();
        WorkRequest workrequest = (WorkRequest)tbl_fin.getValueAt(selectedRow, 8);
        if(workrequest.getChild() != null){
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a work request");
            return;
        }

        Object receiverval = tbl_fin.getValueAt(selectedRow, 1);
        Object statusval = tbl_fin.getValueAt(selectedRow, 5);
        Child childval = (Child) tbl_fin.getValueAt(selectedRow,6);
        Parent parentval = (Parent) tbl_fin.getValueAt(selectedRow,7);

        if ("Approved for Transfer".equals(statusval) || receiverval == null) {
            WorkRequest pwr = (WorkRequest) tbl_fin.getValueAt(selectedRow, 8);
            pwr.setReceiver(account);
            pwr.setStatus("Transferring");
            pwr.setChild(childval);
            pwr.setMessage("Transferring");

            populateTable();
            JOptionPane.showMessageDialog(null, "Work request is now assigned to you");
            //checkStatus(selectedRow);
            populateTable();

        }
        else{
            if (receiverval.equals(account)) {
                JOptionPane.showMessageDialog(null, "Work request is already assigned to you");
            }
            else if (!receiverval.equals(account.getUsername())) {
                JOptionPane.showMessageDialog(null, "Work request is assigned to someone else");
                //checkStatus(selectedRow);
            }
        }
        }
        
        
        else if(workrequest.getChild() == null){
            
         if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a work request");
            return;
        }

        Object receiverval = tbl_fin.getValueAt(selectedRow, 1);
        Object statusval = tbl_fin.getValueAt(selectedRow, 5);
      

        if ("Approved for Transfer".equals(statusval) || receiverval == null) {
            WorkRequest pwr = (WorkRequest) tbl_fin.getValueAt(selectedRow, 8);
            pwr.setReceiver(account);
            pwr.setStatus("Transferring");
            pwr.setMessage("Transferring");

            populateTable();
            JOptionPane.showMessageDialog(null, "Work request is now assigned to you");
            //checkStatus(selectedRow);
            populateTable();

        }
        else{
            if (receiverval.equals(account)) {
                JOptionPane.showMessageDialog(null, "Work request is already assigned to you");
            }
            else if (!receiverval.equals(account.getUsername())) {
                JOptionPane.showMessageDialog(null, "Work request is assigned to someone else");
                //checkStatus(selectedRow);
            }
        }  
            
            
            
            
        }
    }//GEN-LAST:event_btn_assignActionPerformed

    private void btn_transferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transferActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = tbl_fin.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tbl_fin.getModel();
        WorkRequest workrequest = (WorkRequest)tbl_fin.getValueAt(selectedRow, 8);
        if(workrequest.getChild() != null){
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a work request");
            return;
        }
        
        Object receiverval = tbl_fin.getValueAt(selectedRow, 1);
        Object statusval = tbl_fin.getValueAt(selectedRow, 5);
        Child childval = (Child) tbl_fin.getValueAt(selectedRow,6);
        Parent parentval = (Parent) tbl_fin.getValueAt(selectedRow,7);
        ReinTransferMoneyRequest wr = (ReinTransferMoneyRequest) tbl_fin.getValueAt(selectedRow, 8);
        
        
        TransferMoneyToParent tmtp = new TransferMoneyToParent(business,
            account,userProcessContainer,enterprise,
            organization,childval,parentval,wr,rightpanel1);
        rightpanel1.add(tmtp);
        CardLayout layout = (CardLayout) rightpanel1.getLayout();
        layout.next(rightpanel1);
        }
        
        
        else if(workrequest.getChild() == null){
            
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a work request");
            return;
        }
        
        Object receiverval = tbl_fin.getValueAt(selectedRow, 1);
        Object statusval = tbl_fin.getValueAt(selectedRow, 5);
        ReinbursementsWorkRequest wr = (ReinbursementsWorkRequest)tbl_fin.getValueAt(selectedRow, 8);
      
        //ReinbursementsWorkRequest wr = (ReinTransferMoneyRequest) tbl_fin.getValueAt(selectedRow, 8);
        //JOptionPane.showMessageDialog(rightpanel1, wr.getSender());
        
        TransferMoneyToEvent tmtp = new TransferMoneyToEvent(business,
            account,userProcessContainer,enterprise,
            organization,wr,rightpanel1);
        rightpanel1.add(tmtp);
        CardLayout layout = (CardLayout) rightpanel1.getLayout();
        layout.next(rightpanel1);
            
            
        }
        

      
    }//GEN-LAST:event_btn_transferActionPerformed

    private void tbl_finMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_finMouseClicked
         tbl_fin.addMouseListener(new MouseAdapter() {
           
            public void mousePressed(MouseEvent e) {
              int selectedRow = tbl_fin.getSelectedRow();
              checkStatus(selectedRow);
            }
           
       });
    }//GEN-LAST:event_tbl_finMouseClicked

    private void tbl_finPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tbl_finPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_finPropertyChange

    private void btn_notifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_notifyActionPerformed
        // TODO add your handling code here:
        
        checkStatus(tbl_fin.getSelectedRow());
        JOptionPane.showMessageDialog(rightpanel1, "Notified");
       // panel_notify.setVisible(false);
        //btn_notify.setVisible(false);
    }//GEN-LAST:event_btn_notifyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_assign;
    private javax.swing.JButton btn_notify;
    private javax.swing.JButton btn_transfer;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panel_assign;
    private javax.swing.JPanel panel_notify;
    private javax.swing.JPanel panel_transfer;
    private javax.swing.JTable tbl_fin;
    // End of variables declaration//GEN-END:variables
}
