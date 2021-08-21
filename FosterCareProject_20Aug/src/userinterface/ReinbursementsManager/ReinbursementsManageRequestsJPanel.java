/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ReinbursementsManager;

import Business.Child.Child;
import Business.Child.ChildDirectory;
import Business.Child.ChildVitalSigns;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.DoctorOrganisation;
import Business.Organization.Organization;
import Business.Organization.ReinbursementsFinanaceOrganisation;
import Business.Parent.Parent;
import Business.Parent.ParentDirectory;
import Business.Role.ReinAccountant;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ReinTransferMoneyRequest;
import Business.WorkQueue.ReinbursementsWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jaspr
 */

public class ReinbursementsManageRequestsJPanel extends javax.swing.JPanel {
    EcoSystem business;
    UserAccount account;
    JPanel userProcessContainer;
    Enterprise enterprise;
    Organization organization;
    ChildDirectory childdir;
    ParentDirectory parentdir;
    JPanel rightpanel1;

    /**
     * Creates new form ReinbursementsManageRequestsJPanel
     */
    public ReinbursementsManageRequestsJPanel(EcoSystem business, UserAccount account,
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
        panel_approve.setVisible(false);
        btn_approve.setVisible(false);
        panel_decline.setVisible(false);
        btn_decline.setVisible(false);
        panel_doc.setVisible(false);
        btn_doc.setVisible(false);
        //panel_notifyorganiser.setVisible(false);
        //btn_notify_organiser.setVisible(false);
        
        populateTable();
    }
    
     private void checkStatus(int selectedRow){
        DefaultTableModel model = (DefaultTableModel) tbl_reinmanager.getModel();
        Object statusval = tbl_reinmanager.getValueAt(selectedRow, 5);
        WorkRequest workrequest = (WorkRequest)tbl_reinmanager.getValueAt(selectedRow, 8);
        Object ob = tbl_reinmanager.getValueAt(selectedRow, 6);
        
        if(statusval.equals("Request Amount")){
            panel_assign.setVisible(true);
            btn_assign.setVisible(true);
            panel_approve.setVisible(false);
            btn_approve.setVisible(false); 
            panel_decline.setVisible(false);
            btn_decline.setVisible(false);
        }
        else if(statusval.equals("Under process")){
            panel_assign.setVisible(false);
            btn_assign.setVisible(false);
            if(workrequest.getChild() == null){
                panel_doc.setVisible(false);
                btn_doc.setVisible(false);
            }
            else{
                panel_doc.setVisible(true);
                btn_doc.setVisible(true);
            }
            panel_approve.setVisible(true);
            btn_approve.setVisible(true); 
            panel_decline.setVisible(true);
            btn_decline.setVisible(true);
        }
        else if(statusval.equals("Approved for Transfer")){
            panel_assign.setVisible(false);
            btn_assign.setVisible(false);
            panel_doc.setVisible(false);
            btn_doc.setVisible(false);
            panel_approve.setVisible(false);
            btn_approve.setVisible(false); 
            panel_decline.setVisible(false);
            btn_decline.setVisible(false);
        }
        
        else if(statusval.equals("Payment Done")){
           
            panel_assign.setVisible(false);
            btn_assign.setVisible(false);
            panel_doc.setVisible(false);
            btn_doc.setVisible(false);
            panel_approve.setVisible(false);
            btn_approve.setVisible(false); 
            panel_decline.setVisible(false);
            btn_decline.setVisible(false);
        }
           
        
     }
    
    private void populateTable(){
        DefaultTableModel model = (DefaultTableModel) tbl_reinmanager.getModel();
        model.setRowCount(0);
        //JOptionPane.showMessageDialog(panel_approve, organization.getWorkQueue().getWorkRequestList());
        
        for(WorkRequest wr:organization.getWorkQueue().getWorkRequestList()){
            //JOptionPane.showMessageDialog(panel_approve, wr instanceof ReinbursementsWorkRequest);
            if(wr instanceof ReinbursementsWorkRequest){
                Object[] row = new Object[model.getColumnCount()];
                row[0] = wr.getSender();
                row[1] = wr.getReceiver() == null ? null : account;
                if(wr.getMessage().equals("Payment Recieved")){
                    row[2] = "Payment Done";
                }
                else{
                    row[2] = wr.getMessage();
                }
                row[3] = ((ReinbursementsWorkRequest) wr).getAmount();
                row[4] = ((ReinbursementsWorkRequest) wr).getRequested();
               if(wr.getMessage().equals("Payment Recieved")){
                   row[5] = "Payment Done";
               }
               else{
                    row[5] = wr.getStatus();
                }
                if(wr.getChild() == null){
                row[6] = ""; 
                }
                else{
                row[6] = wr.getChild();
                }
                if(wr.getParent()== null){
                row[7] = ""; 
                }
                else{
                row[7] = wr.getParent();
                }
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
        tbl_reinmanager = new javax.swing.JTable();
        panel_assign = new javax.swing.JPanel();
        btn_assign = new javax.swing.JButton();
        panel_approve = new javax.swing.JPanel();
        btn_approve = new javax.swing.JButton();
        panel_decline = new javax.swing.JPanel();
        btn_decline = new javax.swing.JButton();
        panel_doc = new javax.swing.JPanel();
        btn_doc = new javax.swing.JButton();

        jPanel5.setBackground(new java.awt.Color(204, 255, 0));

        jPanel6.setBackground(new java.awt.Color(153, 153, 0));

        tbl_reinmanager.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbl_reinmanager.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_reinmanager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_reinmanagerMouseClicked(evt);
            }
        });
        tbl_reinmanager.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tbl_reinmanagerPropertyChange(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_reinmanager);

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

        panel_approve.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_approve.setText("Approve");
        btn_approve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_approveActionPerformed(evt);
            }
        });
        panel_approve.add(btn_approve, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        panel_decline.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_decline.setText("Decline");
        btn_decline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_declineActionPerformed(evt);
            }
        });
        panel_decline.add(btn_decline, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        panel_doc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_doc.setText("Check Document");
        btn_doc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_docActionPerformed(evt);
            }
        });
        panel_doc.add(btn_doc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(panel_assign, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panel_approve, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panel_decline, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panel_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(283, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_assign, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(panel_approve, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_decline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_doc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(361, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 82, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_reinmanagerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_reinmanagerMouseClicked
        // TODO add your handling code here:
        tbl_reinmanager.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                int selectedRow = tbl_reinmanager.getSelectedRow();
                checkStatus(selectedRow);
            }

        });
    }//GEN-LAST:event_tbl_reinmanagerMouseClicked

    private void tbl_reinmanagerPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tbl_reinmanagerPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_reinmanagerPropertyChange

    private void btn_assignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_assignActionPerformed
        // TODO add your handling code here:
        int selectedRow = tbl_reinmanager.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tbl_reinmanager.getModel();
        WorkRequest workrequest = (WorkRequest)tbl_reinmanager.getValueAt(selectedRow, 8);
        if(workrequest.getChild() != null){
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a work request");
            return;
        }

        Object receiverval = tbl_reinmanager.getValueAt(selectedRow, 1);
        Object statusval = tbl_reinmanager.getValueAt(selectedRow, 5);
        Child childval = (Child) tbl_reinmanager.getValueAt(selectedRow,6);
        Parent parentval = (Parent) tbl_reinmanager.getValueAt(selectedRow,7);

        if ("Request Amount".equals(statusval) || receiverval == null) {
            ReinbursementsWorkRequest pwr = (ReinbursementsWorkRequest) tbl_reinmanager.getValueAt(selectedRow, 8);
            pwr.setReceiver(account);
            pwr.setStatus("Under process");
            pwr.setChild(childval);
            pwr.setMessage("Under process");

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
        }
        else if(workrequest.getChild() == null){
            
            Object receiverval = tbl_reinmanager.getValueAt(selectedRow, 1);
            Object statusval = tbl_reinmanager.getValueAt(selectedRow, 5);
            if ("Request Amount".equals(statusval) || receiverval == null) {
            ReinbursementsWorkRequest pwr = (ReinbursementsWorkRequest) tbl_reinmanager.getValueAt(selectedRow, 8);
            pwr.setReceiver(account);
            pwr.setStatus("Under process");
            pwr.setMessage("Under process");

            populateTable();
            JOptionPane.showMessageDialog(null, "Work request is now assigned to you");
            account.getWorkQueue().getWorkRequestList().add(pwr);
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
            
            
        }
    }//GEN-LAST:event_btn_assignActionPerformed

    private void btn_approveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_approveActionPerformed
        // TODO add your handling code here:
        
        //CONVERT LOCAL DATE TO DATE
        LocalDateTime now = LocalDateTime.now();
        ZoneId defaultzoneid = ZoneId.systemDefault();
        ZonedDateTime zdt = now.atZone(defaultzoneid);
        Date to_Date_now = Date.from(zdt.toInstant());
        int selectedRow = tbl_reinmanager.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tbl_reinmanager.getModel();
        WorkRequest workrequest = (WorkRequest)tbl_reinmanager.getValueAt(selectedRow, 8);
        if(workrequest.getChild() != null){
        
        
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a work request");
            return;
        }
        
        Object receiverval = tbl_reinmanager.getValueAt(selectedRow, 1);
        Object statusval = tbl_reinmanager.getValueAt(selectedRow, 5);
        Child childval = (Child) tbl_reinmanager.getValueAt(selectedRow,6);
        Parent parentval = (Parent) tbl_reinmanager.getValueAt(selectedRow,7);
        
       ReinbursementsWorkRequest rwrval = (ReinbursementsWorkRequest) tbl_reinmanager.getValueAt(selectedRow,8);
        
        if ("Under process".equals(statusval)) {
            WorkRequest re = (WorkRequest) tbl_reinmanager.getValueAt(selectedRow, 8);
            
            re.setStatus("Approved for Transfer");
            re.setMessage("Approved for Transfer");
            re.setChild(childval);
            re.setParent(parentval);
            re.setReceiver(account);
            re.setSender(account);
            
            populateTable();
            
            JOptionPane.showMessageDialog(null, "APPROVED To Transfer Money");
            
            for(WorkRequest wr:parentval.getWorkQueue().getWorkRequestList()){
                wr.setStatus("Approved for Transfer");
                wr.setMessage("Approved for Transfer");
                wr.setChild(childval);
                wr.setParent(parentval);
                wr.setReceiver(account);
                wr.setSender(account);
            }
        
            
        ReinTransferMoneyRequest rfm = new ReinTransferMoneyRequest();
        rfm.setStatus("Approved for Transfer");
        rfm.setMessage("Approved for Transfer");
        rfm.setChild(childval);
        rfm.setParent(parentval);
        rfm.setSender(account);
        rfm.setRequested(rwrval.getRequested());
        rfm.setAmount(rwrval.getAmount());

        Organization org = null;
        for (Network network : business.getNetworkList()) {
            for (Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization organization : ent.getOrganizationDirectory().getOrganizationList()) {
                    if (organization instanceof ReinbursementsFinanaceOrganisation) {
                        org = organization;
                        break;
                    }
                }
            }
        }
        if (org != null) {
            org.getWorkQueue().getWorkRequestList().add(rfm);
            business.getWorkQueue().getWorkRequestList().add(rfm);
            JOptionPane.showMessageDialog(null, "Your request sent to Finance Department");
        }
        else{
            JOptionPane.showMessageDialog(null, "Please create organsation first");
        }
            
        }
        }
        
        else if(workrequest.getChild() == null){
        Object receiverval = tbl_reinmanager.getValueAt(selectedRow, 1);
        Object statusval = tbl_reinmanager.getValueAt(selectedRow, 5);
        
        if ("Under process".equals(statusval)) {
            WorkRequest re = (WorkRequest) tbl_reinmanager.getValueAt(selectedRow, 8);
            
            re.setStatus("Approved for Transfer");
            re.setMessage("Approved for Transfer");
            
            re.setReceiver(account);
            re.setSender(account);
            
            populateTable();
            
            JOptionPane.showMessageDialog(null, "APPROVED To Transfer Money");
            
           
        ReinbursementsWorkRequest rwrval = (ReinbursementsWorkRequest) tbl_reinmanager.getValueAt(selectedRow,8);
        //ReinTransferMoneyRequest rfm = new ReinTransferMoneyRequest();
        rwrval.setStatus("Approved for Transfer");
        rwrval.setMessage("Approved for Transfer");      
        rwrval.setSender(account);
        rwrval.setRequested(rwrval.getRequested());
        rwrval.setAmount(rwrval.getAmount());
        
        
        

        Organization org = null;
        for (Network network : business.getNetworkList()) {
            for (Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization organization : ent.getOrganizationDirectory().getOrganizationList()) {
                    if (organization instanceof ReinbursementsFinanaceOrganisation) {
                        org = organization;
                        break;
                    }
                }
            }
        }
        if (org != null) {
            org.getWorkQueue().getWorkRequestList().add(rwrval);
            business.getWorkQueue().getWorkRequestList().add(rwrval);
            JOptionPane.showMessageDialog(null, "Your request sent to Finance Department");
        }
        else{
            JOptionPane.showMessageDialog(null, "Please create organsation first");
        }
        }
        }
        
        

    }//GEN-LAST:event_btn_approveActionPerformed

    private void btn_declineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_declineActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = tbl_reinmanager.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tbl_reinmanager.getModel();
        WorkRequest workrequest = (WorkRequest)tbl_reinmanager.getValueAt(selectedRow, 8);
        if(workrequest.getChild() != null){
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a work request");
            return;
        }
        
        Object receiverval = tbl_reinmanager.getValueAt(selectedRow, 1);
        Object statusval = tbl_reinmanager.getValueAt(selectedRow, 5);
        Child childval = (Child) tbl_reinmanager.getValueAt(selectedRow,6);
        Parent parentval = (Parent) tbl_reinmanager.getValueAt(selectedRow,7);
        WorkRequest workrequestval = (WorkRequest) tbl_reinmanager.getValueAt(selectedRow,8);
        
        if ("Under process".equals(statusval)) {
           WorkRequest re = (WorkRequest) tbl_reinmanager.getValueAt(selectedRow, 8);
           re.setReceiver(account);
            re.setMessage("DECLINED");
            re.setStatus("DECLINED");
            populateTable();
            JOptionPane.showMessageDialog(null, "DECLINED");
            
            for(WorkRequest wr:parentval.getWorkQueue().getWorkRequestList()){
                if(wr.equals(workrequestval)){
                wr.setSender(account);
                wr.setMessage("DECLINED Transfer");
                wr.setStatus("DECLINED Transfer");}
            }
            
            populateTable();
            checkStatus(selectedRow);
          
        }
        }
        
        else if(workrequest.getChild() == null){
            
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a work request");
            return;
        }
        
        Object receiverval = tbl_reinmanager.getValueAt(selectedRow, 1);
        Object statusval = tbl_reinmanager.getValueAt(selectedRow, 5);
        ReinbursementsWorkRequest rwrval = (ReinbursementsWorkRequest) tbl_reinmanager.getValueAt(selectedRow,8);
        
        if ("Under process".equals(statusval)) {
           WorkRequest re = (WorkRequest) tbl_reinmanager.getValueAt(selectedRow, 8);
           re.setReceiver(account);
            re.setMessage("DECLINED");
            re.setStatus("DECLINED");
            populateTable();
            JOptionPane.showMessageDialog(null, "DECLINED");
            
            for(WorkRequest wrk:workrequest.getSender().getWorkQueue().getWorkRequestList()){
                if(wrk.equals(workrequest)){
                    wrk.setMessage("DECLINED");
                    wrk.setStatus("DECLINED");
                    wrk.setSender(account);
                }
            }
            
            
            populateTable();
            checkStatus(selectedRow);
          
        }
            
        }
        
        
    }//GEN-LAST:event_btn_declineActionPerformed

    private void btn_docActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_docActionPerformed
        // TODO add your handling code here:
    
    int selectedrow = tbl_reinmanager.getSelectedRow();
    if(selectedrow < 0){
        JOptionPane.showMessageDialog(panel_approve, "Select row");
    }
    DefaultTableModel model = (DefaultTableModel) tbl_reinmanager.getModel();
    
    ReinbursementsWorkRequest workrequest = (ReinbursementsWorkRequest)tbl_reinmanager.getValueAt(selectedrow, 8);
    //JOptionPane.showMessageDialog(panel_approve, workrequest.getDocimage());
    
    JFrame f = new JFrame(); //creates jframe f

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //this is your screen size

    //f.setUndecorated(true); //removes the surrounding border
    
     BufferedImage image = null;
        String filename = workrequest.getDocimage();
        try {
            image = ImageIO.read(new File(filename));
            JOptionPane.showMessageDialog(panel_approve, image);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "File not found");
        }
     //JOptionPane.showMessageDialog(panel_approve, image);
     ImageIcon icon = new ImageIcon(image);

     JLabel lbl = new JLabel(icon); //puts the image into a jlabel

    f.getContentPane().add(lbl); //puts label inside the jframe

    f.setSize(icon.getIconWidth(), icon.getIconHeight()); //gets h and w of image and sets jframe to the size

    int x = (screenSize.width - f.getSize().width)/2; //These two lines are the dimensions
    int y = (screenSize.height - f.getSize().height)/2;//of the center of the screen

    f.setLocation(x, y); //sets the location of the jframe
    f.setVisible(true); //makes the jframe visible

        
    }//GEN-LAST:event_btn_docActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_approve;
    private javax.swing.JButton btn_assign;
    private javax.swing.JButton btn_decline;
    private javax.swing.JButton btn_doc;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panel_approve;
    private javax.swing.JPanel panel_assign;
    private javax.swing.JPanel panel_decline;
    private javax.swing.JPanel panel_doc;
    private javax.swing.JTable tbl_reinmanager;
    // End of variables declaration//GEN-END:variables
}
