/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CulturalManager;

import Business.Child.Child;
import Business.Child.ChildDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.CulturalEventOrganiser;
import Business.Organization.FosterOrganization;
import Business.Organization.Organization;
import Business.Parent.Parent;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.EventRequest;
import Business.WorkQueue.FosterAdminRequestEvent;
import Business.WorkQueue.WorkRequest;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.FosterAdmin.FosterAdminWorkRequest;

/**
 *
 * @author jaspr
 */
public class CulturalManagerWorkRequest extends javax.swing.JPanel {

    /**
     * Creates new form CulturalManagerWorkRequest
     */
    EcoSystem business;
    JPanel userProcessContainer;
    Enterprise enterprise;
    Organization organization;
    ChildDirectory childdir;
    UserAccount account;
    JPanel rightpanel1;
    public CulturalManagerWorkRequest(EcoSystem business,JPanel userProcessContainer,
                           Enterprise enterprise,Organization organization,ChildDirectory childdir,
                           UserAccount account, JPanel rightpanel1) {
        initComponents();
        this.business = business;
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.organization = organization;
        this.childdir = childdir;
        this.account = account;
        this.rightpanel1 = rightpanel1;
        
        panel_approve.setVisible(false);
        btn_approve.setVisible(false);
        panel_decline.setVisible(false);
        btn_decline.setVisible(false);
        panel_assign.setVisible(false);
        btn_assign.setVisible(false);
        panel_sendrequest.setVisible(false);
        btn_sendrequest.setVisible(false);
        
        populateTable();
        
    }
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel) tbl_manager.getModel();
        model.setRowCount(0);
        //if(!organization.getWorkQueue().getWorkRequestList().isEmpty()){
        for(WorkRequest workrequest:organization.getWorkQueue().getWorkRequestList()){
            if((workrequest instanceof EventRequest) || (workrequest instanceof FosterAdminRequestEvent)){
                //JOptionPane.showMessageDialog(panel_approve, workrequest instanceof FosterAdminRequestEvent);
                Object[] row = new Object[model.getColumnCount()];
                row[0] = workrequest.getSender();
                if(workrequest instanceof EventRequest){
                    row[1] = ((EventRequest) workrequest).getEventname();
                }
                else if(workrequest instanceof FosterAdminRequestEvent){
                    row[1] = ((FosterAdminRequestEvent) workrequest).getEventname();
                }
                if(workrequest instanceof EventRequest){
                    row[2] = ((EventRequest) workrequest).getEventdate();
                }
                else if(workrequest instanceof FosterAdminRequestEvent){
                    row[2] = ((FosterAdminRequestEvent) workrequest).getEventdate();
                }
                if(workrequest instanceof EventRequest){
                    row[3] = ((EventRequest) workrequest).getOrganisername();
                }
                else if(workrequest instanceof FosterAdminRequestEvent){
                    row[3] = ((FosterAdminRequestEvent) workrequest).getOrganisername();
                }
                if(workrequest instanceof EventRequest){
                    row[4] = ((EventRequest) workrequest).getVenue();
                }
                else if(workrequest instanceof FosterAdminRequestEvent){
                    row[4] = ((FosterAdminRequestEvent) workrequest).getVenue();
                }
                row[5] = workrequest;
                row[6] = workrequest.getStatus();
                row[7] = workrequest.getReceiver() == null ? null : account;
                model.addRow(row);
            }
        }
        //}
        
    }
    
    public void checkStatus(int selectedRow){
        DefaultTableModel model = (DefaultTableModel) tbl_manager.getModel();
        Object statusval = tbl_manager.getValueAt(selectedRow, 6);
        
        if(statusval.equals("Event Requested")){
            btn_assign.setVisible(true);
            panel_assign.setVisible(true);
            panel_approve.setVisible(false);
            btn_approve.setVisible(false);
            panel_decline.setVisible(false);
            btn_decline.setVisible(false);
        }
        else if(statusval.equals("Under Process")){
            panel_sendrequest.setVisible(true);
            btn_sendrequest.setVisible(true);
            btn_assign.setVisible(false);
            panel_assign.setVisible(false);
            panel_approve.setVisible(false);
            btn_approve.setVisible(false);
            panel_decline.setVisible(false);
            btn_decline.setVisible(false);
        }
        else if(statusval.equals("Requested Event")){
            panel_sendrequest.setVisible(false);
            btn_sendrequest.setVisible(false);
            btn_assign.setVisible(false);
            panel_assign.setVisible(false);
            panel_approve.setVisible(false);
            btn_approve.setVisible(false);
            panel_decline.setVisible(false);
            btn_decline.setVisible(false);
       
        }
        else if(statusval.equals("EVENT APPROVED")){
            panel_sendrequest.setVisible(false);
            btn_sendrequest.setVisible(false);
            btn_assign.setVisible(false);
            panel_assign.setVisible(false);
            panel_approve.setVisible(false);
            btn_approve.setVisible(false);
            panel_decline.setVisible(false);
            btn_decline.setVisible(false);
       
        }
        else if(statusval.equals("EVENT DECLINED")){
            panel_sendrequest.setVisible(false);
            btn_sendrequest.setVisible(false);
            btn_assign.setVisible(false);
            panel_assign.setVisible(false);
            panel_approve.setVisible(false);
            btn_approve.setVisible(false);
            panel_decline.setVisible(false);
            btn_decline.setVisible(false);
       
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
        tbl_manager = new javax.swing.JTable();
        panel_assign = new javax.swing.JPanel();
        btn_assign = new javax.swing.JButton();
        panel_approve = new javax.swing.JPanel();
        btn_approve = new javax.swing.JButton();
        panel_decline = new javax.swing.JPanel();
        btn_decline = new javax.swing.JButton();
        panel_sendrequest = new javax.swing.JPanel();
        btn_sendrequest = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(204, 255, 0));

        jPanel6.setBackground(new java.awt.Color(153, 153, 0));

        tbl_manager.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbl_manager.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Sender", "Event Name", "Event Date", "Organiser", "Event Venue", "Message", "Status", "Reciver"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_manager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_managerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbl_managerMouseEntered(evt);
            }
        });
        tbl_manager.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tbl_managerPropertyChange(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_manager);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 971, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        panel_assign.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_assign.setBackground(new java.awt.Color(51, 51, 51));
        btn_assign.setText("Assign To Me");
        btn_assign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_assignActionPerformed(evt);
            }
        });
        panel_assign.add(btn_assign, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 34));

        panel_approve.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_approve.setBackground(new java.awt.Color(51, 51, 51));
        btn_approve.setText("Approve");
        btn_approve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_approveActionPerformed(evt);
            }
        });
        panel_approve.add(btn_approve, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 34));

        panel_decline.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_decline.setBackground(new java.awt.Color(51, 51, 51));
        btn_decline.setText("Decline");
        btn_decline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_declineActionPerformed(evt);
            }
        });
        panel_decline.add(btn_decline, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 34));

        panel_sendrequest.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_sendrequest.setBackground(new java.awt.Color(51, 51, 51));
        btn_sendrequest.setText("Request Foster Admin");
        btn_sendrequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sendrequestActionPerformed(evt);
            }
        });
        panel_sendrequest.add(btn_sendrequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 150, 34));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(panel_assign, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_sendrequest, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_approve, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel_decline, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel_assign, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_approve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_decline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_sendrequest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(222, Short.MAX_VALUE))
        );

        add(jPanel5, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_managerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_managerMouseClicked
        // TODO add your handling code here:
         tbl_manager.addMouseListener(new MouseAdapter() {
           
            public void mousePressed(MouseEvent e) {
              int selectedRow = tbl_manager.getSelectedRow();
              checkStatus(selectedRow);
            }
           
       });

    }//GEN-LAST:event_tbl_managerMouseClicked

    private void tbl_managerPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tbl_managerPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_managerPropertyChange

    private void btn_assignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_assignActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = tbl_manager.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a work request");
            return;
        }
        Object receiverval = tbl_manager.getValueAt(selectedRow, 7);
        Object statusval = tbl_manager.getValueAt(selectedRow, 6);
        
        if ("Event Requested".equals(statusval) || receiverval == null) {
            WorkRequest re = (WorkRequest) tbl_manager.getValueAt(selectedRow, 5);
            re.setReceiver(account);
            re.setStatus("Under Process");
            re.setMessage("Under Process");
            
            populateTable();
            JOptionPane.showMessageDialog(null, "Work request has been assigned to you");
            checkStatus(selectedRow);
            populateTable();
 
        }
        else{
            JOptionPane.showMessageDialog(rightpanel1, receiverval);
            JOptionPane.showMessageDialog(rightpanel1, account.getUsername());
            if (receiverval.equals(account)) {
                JOptionPane.showMessageDialog(null, "Work request is already assigned to you");
            }
            else if (!receiverval.equals(account.getUsername())) {
                JOptionPane.showMessageDialog(null, "Work request is assigned to someone else");
                panel_sendrequest.setVisible(false);
                btn_sendrequest.setVisible(false);
            }
        }
        

    }//GEN-LAST:event_btn_assignActionPerformed

    private void btn_approveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_approveActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = tbl_manager.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a work request");
            return;
        }
        
        Object receiverval = tbl_manager.getValueAt(selectedRow, 7);
        //UserAccount sender = (UserAccount)tbl_eventsfoseradmin.getValueAt(selectedRow, 0);
        Object statusval = tbl_manager.getValueAt(selectedRow, 6);
        //FosterAdminRequestEvent wr1 = (FosterAdminRequestEvent) tbl_eventsfoseradmin.getValueAt(selectedRow, 5);
        
        if ("EVENT APPROVED".equals(statusval) || receiverval == null) {
            FosterAdminRequestEvent re = (FosterAdminRequestEvent) tbl_manager.getValueAt(selectedRow, 5);
            re.setReceiver(account);
            re.setStatus("EVENT IS APPROVED");
            re.setMessage("EVENT IS APPROVED");
            
            populateTable();
            JOptionPane.showMessageDialog(null, "EVENT APPROVED");
            checkStatus(selectedRow);
  
            WorkRequest wr = (WorkRequest) tbl_manager.getValueAt(selectedRow, 5);
            wr.setStatus("EVENT IS APPROVED");
            wr.setMessage("EVENT IS APPROVED");
            JOptionPane.showMessageDialog(panel_approve, wr.getSender());
            JOptionPane.showMessageDialog(panel_approve, wr.getSender().getWorkQueue().getWorkRequestList());
                
            
        }
        
        
        
        
    }//GEN-LAST:event_btn_approveActionPerformed

    private void btn_declineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_declineActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = tbl_manager.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a work request");
            return;
        }
        
        Object receiverval = tbl_manager.getValueAt(selectedRow, 7);
        //UserAccount sender = (UserAccount)tbl_eventsfoseradmin.getValueAt(selectedRow, 0);
        Object statusval = tbl_manager.getValueAt(selectedRow, 6);
        //FosterAdminRequestEvent wr1 = (FosterAdminRequestEvent) tbl_eventsfoseradmin.getValueAt(selectedRow, 5);
        
        if ("EVENT DECLINED".equals(statusval) || receiverval == null) {
            FosterAdminRequestEvent re = (FosterAdminRequestEvent) tbl_manager.getValueAt(selectedRow, 5);
            re.setReceiver(account);
            re.setStatus("EVENT IS DECLINED");
            re.setMessage("EVENT IS DECLINED");
            
            populateTable();
            JOptionPane.showMessageDialog(null, "EVENT APPROVED");
            checkStatus(selectedRow);
  
            WorkRequest wr = (WorkRequest) tbl_manager.getValueAt(selectedRow, 5);
            wr.setStatus("EVENT IS DECLINED");
            wr.setMessage("EVENT IS DECLINED");
            JOptionPane.showMessageDialog(panel_approve, wr.getSender());
            JOptionPane.showMessageDialog(panel_approve, wr.getSender().getWorkQueue().getWorkRequestList());
                
            
        }
    }//GEN-LAST:event_btn_declineActionPerformed

    private void btn_sendrequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sendrequestActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel model = (DefaultTableModel) tbl_manager.getModel();
     
        int selectedRow = tbl_manager.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a workrequest");
            return;
        }
        Object statusval = tbl_manager.getValueAt(selectedRow, 6);
        EventRequest workrequest = (EventRequest)tbl_manager.getValueAt(selectedRow, 5);
        
        if(statusval.equals("Under Process")){
            /*Business.WorkQueue.FosterAdminRequestEvent fawr = new Business.WorkQueue.FosterAdminRequestEvent();
            fawr.setSender(account);
            fawr.setStatus("Requested Event");
            fawr.setMessage("Requested Event");
            fawr.setEventcategory(workrequest.getEventcategory());
            fawr.setEventname(workrequest.getEventname());
            fawr.setEventdate(workrequest.getEventdate());
            fawr.setVenue(workrequest.getVenue());
            fawr.setOrganisername(workrequest.getOrganisername());
            fawr.setOrg(organization);
            fawr.setId(workrequest.getId());*/
            
            workrequest.setMessage("Requested Event");
            workrequest.setStatus("Requested Event");

            populateTable();
            checkStatus(selectedRow);
            
            Organization org = null;
                for (Network network : business.getNetworkList()) {
                    for (Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()) {
                        for (Organization organization : ent.getOrganizationDirectory().getOrganizationList()) {
                            if (organization instanceof FosterOrganization) {
                                org = organization;
                                break;
                            }
                        }
                    }
                }

                if (org != null) {
                    org.getWorkQueue().getWorkRequestList().add(workrequest);
                    account.getWorkQueue().getWorkRequestList().add(workrequest);
                    business.getWorkQueue().getWorkRequestList().add(workrequest);
                    JOptionPane.showMessageDialog(null, "Request sent to Foster Admin");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Create Organisation");
                }
            
        }
        
        
    }//GEN-LAST:event_btn_sendrequestActionPerformed

    private void tbl_managerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_managerMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_managerMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_approve;
    private javax.swing.JButton btn_assign;
    private javax.swing.JButton btn_decline;
    private javax.swing.JButton btn_sendrequest;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panel_approve;
    private javax.swing.JPanel panel_assign;
    private javax.swing.JPanel panel_decline;
    private javax.swing.JPanel panel_sendrequest;
    private javax.swing.JTable tbl_manager;
    // End of variables declaration//GEN-END:variables
}
