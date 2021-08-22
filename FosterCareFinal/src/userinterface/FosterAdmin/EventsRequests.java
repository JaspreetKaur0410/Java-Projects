/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.FosterAdmin;

import Business.Child.Child;
import Business.Child.ChildDirectory;
import Business.EcoSystem;
import Business.Enterprise.CulturalEvents;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.CulturalEventOrganisation;
import Business.Organization.FosterOrganization;
import Business.Organization.Organization;
import Business.Parent.Parent;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.EventRequest;
import Business.WorkQueue.FosterAdminRequestEvent;
import Business.WorkQueue.ParentWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author jaspr
 */
public class EventsRequests extends javax.swing.JPanel {

    /**
     * Creates new form EventsRequests
     */
    EcoSystem business;
    JPanel userProcessContainer;
    Enterprise enterprise;
    Organization organization;
    ChildDirectory childdir;
    JPanel rightpanel1;
    ParentWorkRequest parentrequest;
    UserAccount account;
    public EventsRequests(EcoSystem business, JPanel userProcessContainer,
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
        
        btn_assign.setVisible(false);
        panel_assign.setVisible(false);
        btn_approve.setVisible(false);
        panel_approve.setVisible(false);
        btn_decline.setVisible(false);
        panel_decline.setVisible(false);
        
        populateTable();

    }
    
    private void populateTable(){
        DefaultTableModel model = (DefaultTableModel) tbl_eventsfoseradmin.getModel();
        model.setRowCount(0);
        
        for(WorkRequest workrequest:organization.getWorkQueue().getWorkRequestList()){
            //JOptionPane.showMessageDialog(panel_approve, workrequest.getSender());
            //JOptionPane.showMessageDialog(panel_approve, workrequest.getSender().getWorkQueue().getWorkRequestList());
            if(workrequest instanceof EventRequest){
                Object[] row = new Object[model.getColumnCount()];
                row[0] =  workrequest.getSender();
                row[1] = ((EventRequest) workrequest).getEventname();
                row[2] = ((EventRequest) workrequest).getEventdate();
                row[3] = ((EventRequest) workrequest).getOrganisername();
                row[4] = ((EventRequest) workrequest).getVenue();
                row[5] = workrequest;
                row[6] = workrequest.getStatus();
                row[7] = workrequest.getReceiver() == null ? null : account;
                model.addRow(row);
        }
        }
    }
    
    private void checkStatus(int selectedRow){
        DefaultTableModel model = (DefaultTableModel) tbl_eventsfoseradmin.getModel();
        Object statusval = tbl_eventsfoseradmin.getValueAt(selectedRow, 6);
    
        if(statusval.equals("Requested Event")){
            btn_assign.setVisible(true);        
            panel_assign.setVisible(true);
            btn_approve.setVisible(false);
            panel_approve.setVisible(false);
            btn_decline.setVisible(false);
            panel_decline.setVisible(false);
        }
        else if(statusval.equals("Checking")){
            btn_assign.setVisible(false);        
            panel_assign.setVisible(false);
            btn_approve.setVisible(true);
            panel_approve.setVisible(true);
            btn_decline.setVisible(true);
            panel_decline.setVisible(true);
        }
        else if(statusval.equals("EVENT APPROVED")){
            btn_assign.setVisible(false);
            panel_assign.setVisible(false);
            btn_approve.setVisible(false);
            panel_approve.setVisible(false);
            btn_decline.setVisible(false);
            panel_decline.setVisible(false);
        }
        else if(statusval.equals("EVENT DECLINED")){
            btn_assign.setVisible(false);
            panel_assign.setVisible(false);
            btn_approve.setVisible(false);
            panel_approve.setVisible(false);
            btn_decline.setVisible(false);
            panel_decline.setVisible(false);
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
        tbl_eventsfoseradmin = new javax.swing.JTable();
        panel_assign = new javax.swing.JPanel();
        btn_assign = new javax.swing.JButton();
        panel_approve = new javax.swing.JPanel();
        btn_approve = new javax.swing.JButton();
        panel_decline = new javax.swing.JPanel();
        btn_decline = new javax.swing.JButton();

        jPanel5.setBackground(new java.awt.Color(204, 255, 0));

        jPanel6.setBackground(new java.awt.Color(153, 153, 0));

        tbl_eventsfoseradmin.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbl_eventsfoseradmin.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_eventsfoseradmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_eventsfoseradminMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbl_eventsfoseradminMouseEntered(evt);
            }
        });
        tbl_eventsfoseradmin.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tbl_eventsfoseradminPropertyChange(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_eventsfoseradmin);

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

        btn_approve.setText("APPROVE");
        btn_approve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_approveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_approveLayout = new javax.swing.GroupLayout(panel_approve);
        panel_approve.setLayout(panel_approveLayout);
        panel_approveLayout.setHorizontalGroup(
            panel_approveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_approveLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_approve, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_approveLayout.setVerticalGroup(
            panel_approveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_approveLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_approve, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_decline.setText("Decline");
        btn_decline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_declineActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_declineLayout = new javax.swing.GroupLayout(panel_decline);
        panel_decline.setLayout(panel_declineLayout);
        panel_declineLayout.setHorizontalGroup(
            panel_declineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_declineLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_decline, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_declineLayout.setVerticalGroup(
            panel_declineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_declineLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_decline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(panel_assign, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_approve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panel_decline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(487, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_assign, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_decline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_approve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(457, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1486, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 827, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_assignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_assignActionPerformed
        // TODO add your handling code here:
      int selectedRow = tbl_eventsfoseradmin.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a work request");
            return;
        }
        
        Object receiverval = tbl_eventsfoseradmin.getValueAt(selectedRow, 7);
        Object statusval = tbl_eventsfoseradmin.getValueAt(selectedRow, 6);
        
        if ("Requested Event".equals(statusval) || receiverval == null) {
            WorkRequest re = (WorkRequest) tbl_eventsfoseradmin.getValueAt(selectedRow, 5);
            re.setReceiver(account);
            re.setStatus("Checking");
            re.setMessage("Checking");
            
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
                //btn_request.setVisible(false);
            }
        }

    }//GEN-LAST:event_btn_assignActionPerformed

    private void btn_approveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_approveActionPerformed
        // TODO add your handling code here:
        int selectedRow = tbl_eventsfoseradmin.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a work request");
            return;
        }
        
        Object receiverval = tbl_eventsfoseradmin.getValueAt(selectedRow, 7);
        //UserAccount sender = (UserAccount)tbl_eventsfoseradmin.getValueAt(selectedRow, 0);
        Object statusval = tbl_eventsfoseradmin.getValueAt(selectedRow, 6);
        WorkRequest wr1 = (WorkRequest) tbl_eventsfoseradmin.getValueAt(selectedRow, 5);
        
        if ("Checking".equals(statusval) || receiverval == null) {
            EventRequest re = (EventRequest) tbl_eventsfoseradmin.getValueAt(selectedRow, 5);
            re.setReceiver(account);
            re.setStatus("EVENT APPROVED");
            re.setMessage("EVENT APPROVED");
            
            populateTable();
            JOptionPane.showMessageDialog(null, "EVENT APPROVED");
            checkStatus(selectedRow);
            
            /*for(WorkRequest wrk:wr1.getOrg().getWorkQueue().getWorkRequestList()){
                if(!wrk.getSender().equals(account) && 
                        wrk.getMessage().equals("Requested Event")
                        && wr1.getMessage().equals(("EVENT APPROVED"))){
                    wrk.setStatus("EVENT APPROVED");
                    wrk.setMessage("EVENT APPROVED");
                    wrk.setSender(account);
                }
            }*/
  
           WorkRequest wr = (WorkRequest) tbl_eventsfoseradmin.getValueAt(selectedRow, 5);
           wr.setStatus("EVENT APPROVED");
           wr.setMessage("EVENT APPROVED");
           //JOptionPane.showMessageDialog(panel_approve, wr.getSender());
           //JOptionPane.showMessageDialog(panel_approve, wr.getSender().getWorkQueue().getWorkRequestList());
                
            
        }
            
            
            
        
        
       

    }//GEN-LAST:event_btn_approveActionPerformed

    private void tbl_eventsfoseradminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_eventsfoseradminMouseClicked
        // TODO add your handling code here:
        tbl_eventsfoseradmin.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                int selectedRow = tbl_eventsfoseradmin.getSelectedRow();
                checkStatus(selectedRow);
            }

        });
    }//GEN-LAST:event_tbl_eventsfoseradminMouseClicked

    private void tbl_eventsfoseradminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_eventsfoseradminMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_eventsfoseradminMouseEntered

    private void tbl_eventsfoseradminPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tbl_eventsfoseradminPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_eventsfoseradminPropertyChange

    private void btn_declineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_declineActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = tbl_eventsfoseradmin.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a work request");
            return;
        }
        
        Object receiverval = tbl_eventsfoseradmin.getValueAt(selectedRow, 7);
        //UserAccount sender = (UserAccount)tbl_eventsfoseradmin.getValueAt(selectedRow, 0);
        Object statusval = tbl_eventsfoseradmin.getValueAt(selectedRow, 6);
        //FosterAdminRequestEvent wr1 = (FosterAdminRequestEvent) tbl_eventsfoseradmin.getValueAt(selectedRow, 5);
        
        if ("Checking".equals(statusval) || receiverval == null) {
            EventRequest re = (EventRequest) tbl_eventsfoseradmin.getValueAt(selectedRow, 5);
            re.setReceiver(account);
            re.setStatus("EVENT DECLINED");
            re.setMessage("EVENT DECLINED");
            
            populateTable();
            JOptionPane.showMessageDialog(null, "EVENT DECLINED");
            checkStatus(selectedRow);
  
            WorkRequest wr = (WorkRequest) tbl_eventsfoseradmin.getValueAt(selectedRow, 5);
            wr.setStatus("EVENT DECLINED");
            wr.setMessage("EVENT DECLINED");
            //JOptionPane.showMessageDialog(panel_approve, wr.getSender());
            //JOptionPane.showMessageDialog(panel_approve, wr.getSender().getWorkQueue().getWorkRequestList());
                
            
        }
        
        
    }//GEN-LAST:event_btn_declineActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_approve;
    private javax.swing.JButton btn_assign;
    private javax.swing.JButton btn_decline;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panel_approve;
    private javax.swing.JPanel panel_assign;
    private javax.swing.JPanel panel_decline;
    private javax.swing.JTable tbl_eventsfoseradmin;
    // End of variables declaration//GEN-END:variables
}
