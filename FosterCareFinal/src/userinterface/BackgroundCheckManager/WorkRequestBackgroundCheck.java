/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.BackgroundCheckManager;

import Business.Child.Child;
import Business.Child.ChildDirectory;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Parent.Parent;
import Business.Role.FosterAdminRole;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.BackgroundCheckWorkRequest;
import Business.WorkQueue.ParentWorkRequest;
import Business.WorkQueue.WorkRequest;
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
public class WorkRequestBackgroundCheck extends javax.swing.JPanel {

    /**
     * Creates new form WorkRequestBackgroundCheck
     */
    
    EcoSystem business;
    JPanel userProcessContainer;
    Enterprise enterprise;
    Organization organization;
    ChildDirectory childdir;
    JPanel rightpanel1;
    ParentWorkRequest parentrequest;
    UserAccount account;
    BackgroundCheckWorkRequest backgroundrequest;
    
    public WorkRequestBackgroundCheck(EcoSystem business, JPanel userProcessContainer,
            Enterprise enterprise,Organization organization,
            JPanel rightpanel1,UserAccount account) {
        initComponents();
        this.business = business;
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.organization = organization;
        this.rightpanel1 = rightpanel1;
        this.account = account;
        //JOptionPane.showMessageDialog(panel_appointment, account);

        populateTable();
        
        panel_assign.setVisible(false);
        btn_assign.setVisible(false);
        btn_appointment.setVisible(false);
        btn_viewAppointmnet.setVisible(false);
        panel_viewAppointment.setVisible(false);
        panel_appointment.setVisible(false);
        btn_appointment.setVisible(false);
        panel_accept.setVisible(false);
        btn_accept.setVisible(false);
        panel_decline.setVisible(false);
        btn_decline.setVisible(false);
        panel_meetingcompleted.setVisible(false);
        btn_meetingcompleted.setVisible(false);
    }
    
    public void hide(){
        panel_assign.setVisible(false);
        btn_assign.setVisible(false);
        btn_appointment.setVisible(false);
        btn_viewAppointmnet.setVisible(false);
        panel_viewAppointment.setVisible(false);
        panel_appointment.setVisible(false);
        btn_appointment.setVisible(false);
        panel_accept.setVisible(false);
        btn_accept.setVisible(false);
        panel_decline.setVisible(false);
        btn_decline.setVisible(false);
        panel_meetingcompleted.setVisible(false);
        btn_meetingcompleted.setVisible(false);
    }
    
     public void checkStatus(int selectedRow){
        DefaultTableModel model = (DefaultTableModel) tbl_backgroundcheck.getModel();
        Object statusval = tbl_backgroundcheck.getValueAt(selectedRow, 4);
    
        if(statusval.equals("Check Requested")){
            btn_assign.setVisible(true);
            panel_assign.setVisible(true);
            panel_viewAppointment.setVisible(false);
            panel_appointment.setVisible(false);
        }
        else if(statusval.equals("Requested to Adopt")){
            btn_assign.setVisible(false);
            panel_assign.setVisible(false);
            panel_viewAppointment.setVisible(true);
            panel_appointment.setVisible(false);
        }
        else if(statusval.equals("Check Pending")){
            panel_assign.setVisible(true);
            btn_assign.setVisible(true);
            
            panel_appointment.setVisible(false);
            btn_appointment.setVisible(false);
            
            panel_viewAppointment.setVisible(false);
            btn_viewAppointmnet.setVisible(false);
        }
        else if(statusval.equals("Bckground check Processing")){
            panel_assign.setVisible(false);
            btn_assign.setVisible(false);
            
            panel_appointment.setVisible(true);
            btn_appointment.setVisible(true);
            
            panel_viewAppointment.setVisible(false);
            btn_viewAppointmnet.setVisible(false);
        }
        else if(statusval.equals("Appointment Scheduled")){
            panel_assign.setVisible(false);
            btn_assign.setVisible(false);
            
            panel_appointment.setVisible(false);
            btn_appointment.setVisible(false);
            
            panel_viewAppointment.setVisible(true);
            btn_viewAppointmnet.setVisible(true);
            
            panel_meetingcompleted.setVisible(true);
            btn_meetingcompleted.setVisible(true);
        }
        else if(statusval.equals("Meeting Completed")){
            panel_assign.setVisible(false);
            btn_assign.setVisible(false);
            
            panel_appointment.setVisible(false);
            btn_appointment.setVisible(false);
            
            panel_viewAppointment.setVisible(false);
            btn_viewAppointmnet.setVisible(false);
            
            panel_meetingcompleted.setVisible(false);
            btn_viewAppointmnet.setVisible(false);
            
            panel_accept.setVisible(true);
            btn_accept.setVisible(true);
            
            panel_decline.setVisible(true);
            btn_decline.setVisible(true);
        }
        else if(statusval.equals("APPROVED")){
            panel_assign.setVisible(false);
            btn_assign.setVisible(false);
            
            panel_appointment.setVisible(false);
            btn_appointment.setVisible(false);
            
            panel_viewAppointment.setVisible(false);
            btn_viewAppointmnet.setVisible(false);
            
            panel_meetingcompleted.setVisible(false);
            btn_viewAppointmnet.setVisible(false);
            
            panel_accept.setVisible(false);
            btn_accept.setVisible(false);
            
            panel_decline.setVisible(false);
            btn_decline.setVisible(false);
        }
        else if(statusval.equals("DECLINED")){
            panel_assign.setVisible(false);
            btn_assign.setVisible(false);
            
            panel_appointment.setVisible(false);
            btn_appointment.setVisible(false);
            
            panel_viewAppointment.setVisible(false);
            btn_viewAppointmnet.setVisible(false);
            
            panel_meetingcompleted.setVisible(false);
            btn_viewAppointmnet.setVisible(false);
            
            panel_accept.setVisible(false);
            btn_accept.setVisible(false);
            
            panel_decline.setVisible(false);
            btn_decline.setVisible(false);
        }
       
    }
    
     public void hidescheduleappointtment(){
         panel_appointment.setVisible(false);
         btn_appointment.setVisible(false);
         
         panel_assign.setVisible(false);
         btn_assign.setVisible(false);
      
         panel_viewAppointment.setVisible(true);
         btn_viewAppointmnet.setVisible(true);
            
         panel_meetingcompleted.setVisible(true);
         btn_meetingcompleted.setVisible(true);
     }
     
     public void populateTable(){
        DefaultTableModel model = (DefaultTableModel) tbl_backgroundcheck.getModel();
        model.setRowCount(0);
        for(WorkRequest workrequest:organization.getWorkQueue().getWorkRequestList()){
            if(workrequest instanceof BackgroundCheckWorkRequest){
                Object[] row = new Object[6];
                   //JOptionPane.showMessageDialog(panel_request, workrequest.getStatus());
                   row[0] = workrequest.getSender().getRole();
                   row[1] =  workrequest;
                   row[2] = ((BackgroundCheckWorkRequest) workrequest).getSender();
                   row[3] = workrequest.getReceiver() == null ? null : account;
                    if(workrequest.getStatus().equals("Reuest To Adopt")){
                        row[4] = "Requested to Adopt";
                    }
                    else if(workrequest.getStatus().equals("Check Requested")){
                        row[4] = "Check Requested";
                    }
                   else if(workrequest.getStatus().equals("Check Pending")){
                        row[4] = "Check Pending";
                    }
                    else if(workrequest.getStatus().equals("Bckground check Processing")){
                        row[4] = "Bckground check Processing";
                    }
                    else if(workrequest.getStatus().equals("Appointment Scheduled")){
                        row[4] = "Appointment Scheduled";
                    }
                    else if(workrequest.getStatus().equals("Meeting Completed")){
                        row[4] = "Meeting Completed";
                    }
                    else if(workrequest.getStatus().equals("APPROVED")){
                        row[4] = "APPROVED";
                    }
                    else if(workrequest.getStatus().equals("DECLINED")){
                        row[4] = "DECLINED";
                    }
                    else{
                        row[4] = workrequest.getStatus();
                    }
                   row[5] = ((BackgroundCheckWorkRequest) workrequest).getParent();
                   //row[6] = ((BackgroundCheckWorkRequest) workrequest).getParent().getParentid();
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
        tbl_backgroundcheck = new javax.swing.JTable();
        panel_viewAppointment = new javax.swing.JPanel();
        panel_assign1 = new javax.swing.JPanel();
        panel_viewAppointment1 = new javax.swing.JPanel();
        panel_assign2 = new javax.swing.JPanel();
        btn_viewAppointmnet = new javax.swing.JButton();
        panel_appointment = new javax.swing.JPanel();
        btn_appointment = new javax.swing.JButton();
        panel_assign = new javax.swing.JPanel();
        panel_accept = new javax.swing.JPanel();
        btn_accept = new javax.swing.JButton();
        panel_decline = new javax.swing.JPanel();
        btn_decline = new javax.swing.JButton();
        panel_meetingcompleted = new javax.swing.JPanel();
        btn_meetingcompleted = new javax.swing.JButton();
        btn_assign = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jPanel5.setBackground(new java.awt.Color(204, 255, 0));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(153, 153, 0));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_backgroundcheck.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbl_backgroundcheck.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Sender Role", "Message", "Sender Name", "Reciever Name", "Status", "Parent to Check"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_backgroundcheck.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_backgroundcheckMouseClicked(evt);
            }
        });
        tbl_backgroundcheck.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tbl_backgroundcheckPropertyChange(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_backgroundcheck);

        jPanel6.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 990, 239));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 990, 266));

        panel_viewAppointment.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_assign1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel_viewAppointment.add(panel_assign1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panel_viewAppointment1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_assign2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel_viewAppointment1.add(panel_assign2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panel_viewAppointment.add(panel_viewAppointment1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btn_viewAppointmnet.setBackground(new java.awt.Color(102, 102, 102));
        btn_viewAppointmnet.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_viewAppointmnet.setForeground(new java.awt.Color(255, 255, 255));
        btn_viewAppointmnet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/appointment.png"))); // NOI18N
        btn_viewAppointmnet.setText("View Appointment");
        btn_viewAppointmnet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewAppointmnetActionPerformed(evt);
            }
        });
        panel_viewAppointment.add(btn_viewAppointmnet, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 50));

        jPanel5.add(panel_viewAppointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, 180, 50));

        panel_appointment.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_appointment.setBackground(new java.awt.Color(102, 102, 102));
        btn_appointment.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_appointment.setForeground(new java.awt.Color(255, 255, 255));
        btn_appointment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/appointment.png"))); // NOI18N
        btn_appointment.setText("Schedule Appointment");
        btn_appointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_appointmentActionPerformed(evt);
            }
        });
        panel_appointment.add(btn_appointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 50));

        jPanel5.add(panel_appointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 240, -1));

        panel_assign.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(panel_assign, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 470, 20, -1));

        panel_accept.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_accept.setBackground(new java.awt.Color(102, 102, 102));
        btn_accept.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_accept.setForeground(new java.awt.Color(255, 255, 255));
        btn_accept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/approvee.png"))); // NOI18N
        btn_accept.setText("APPROVE");
        btn_accept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_acceptActionPerformed(evt);
            }
        });
        panel_accept.add(btn_accept, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 50));

        jPanel5.add(panel_accept, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 400, 120, 50));

        panel_decline.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_decline.setBackground(new java.awt.Color(102, 102, 102));
        btn_decline.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_decline.setForeground(new java.awt.Color(255, 255, 255));
        btn_decline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/decline.pn.png"))); // NOI18N
        btn_decline.setText("DECLINE");
        btn_decline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_declineActionPerformed(evt);
            }
        });
        panel_decline.add(btn_decline, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 50));

        jPanel5.add(panel_decline, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 400, 160, 50));

        panel_meetingcompleted.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_meetingcompleted.setBackground(new java.awt.Color(102, 102, 102));
        btn_meetingcompleted.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_meetingcompleted.setForeground(new java.awt.Color(255, 255, 255));
        btn_meetingcompleted.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/meeting.png"))); // NOI18N
        btn_meetingcompleted.setText("Meeting Completed");
        btn_meetingcompleted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_meetingcompletedActionPerformed(evt);
            }
        });
        panel_meetingcompleted.add(btn_meetingcompleted, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 50));

        jPanel5.add(panel_meetingcompleted, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 350, 220, 50));

        btn_assign.setBackground(new java.awt.Color(102, 102, 102));
        btn_assign.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_assign.setForeground(new java.awt.Color(255, 255, 255));
        btn_assign.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/assign.png"))); // NOI18N
        btn_assign.setText("Assign To Me");
        btn_assign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_assignActionPerformed(evt);
            }
        });
        jPanel5.add(btn_assign, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 200, 40));

        jLabel2.setBackground(new java.awt.Color(153, 153, 0));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 940, 300));

        jLabel3.setBackground(new java.awt.Color(153, 153, 0));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("CHECKING BACKGROUND");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1303, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1303, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 883, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_backgroundcheckMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_backgroundcheckMouseClicked
        // TODO add your handling code here:
       tbl_backgroundcheck.addMouseListener(new MouseAdapter() {
           
            public void mousePressed(MouseEvent e) {
              int selectedRow = tbl_backgroundcheck.getSelectedRow();
              checkStatus(selectedRow);
            }
           
       });

    }//GEN-LAST:event_tbl_backgroundcheckMouseClicked

    private void tbl_backgroundcheckPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tbl_backgroundcheckPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_backgroundcheckPropertyChange

    private void btn_viewAppointmnetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewAppointmnetActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tbl_backgroundcheck.getModel();
        int selectedRow = tbl_backgroundcheck.getSelectedRow();
        WorkRequest workrequest = (WorkRequest) tbl_backgroundcheck.getValueAt(selectedRow, 1);
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a work request");
            return;
        }
        Object parentval = (Parent)(UserAccount)tbl_backgroundcheck.getValueAt(selectedRow, 5);
        JOptionPane.showMessageDialog(panel_appointment, workrequest.getStatus());
        ViewAppointment appointment = new 
        ViewAppointment(userProcessContainer,organization,account, (Parent) parentval,rightpanel1, (BackgroundCheckWorkRequest) workrequest);
        userProcessContainer.add(appointment);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        checkStatus(selectedRow);
    }//GEN-LAST:event_btn_viewAppointmnetActionPerformed

    private void btn_appointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_appointmentActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tbl_backgroundcheck.getModel();
        int selectedRow = tbl_backgroundcheck.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a work request");
            return;
        }
        else{
        WorkRequest workrequest = (BackgroundCheckWorkRequest)(WorkRequest) tbl_backgroundcheck.getValueAt(selectedRow, 1);
        
        Parent parentval = (Parent)(UserAccount)tbl_backgroundcheck.getValueAt(selectedRow, 5);
        //UserAccount userAccount = (UserAccount)tbl_backgroundcheck.getValueAt(selectedRow, 2);
        BackgroundCheckScheduleAppointment appointment = new 
        BackgroundCheckScheduleAppointment(userProcessContainer,organization,account, (Parent) parentval,rightpanel1, (BackgroundCheckWorkRequest) workrequest);
        userProcessContainer.add(appointment);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
        populateTable();
        checkStatus(selectedRow);
        
        for(WorkRequest wr:parentval.getWorkQueue().getWorkRequestList()){
            wr.setSender(account);
            wr.setMessage("Appointment Scheduled");
            wr.setStatus("Appointment Scheduled");
         }
        }
       

    }//GEN-LAST:event_btn_appointmentActionPerformed

    private void btn_assignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_assignActionPerformed
        // TODO add your handling code here:
        int selectedRow = tbl_backgroundcheck.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a work request");
            return;
        }
        
        Object receiverval = tbl_backgroundcheck.getValueAt(selectedRow, 3);
        
        Object statusval = tbl_backgroundcheck.getValueAt(selectedRow, 4);
        UserAccount userAccount = (UserAccount)tbl_backgroundcheck.getValueAt(selectedRow, 2);
        WorkRequest work = (WorkRequest)tbl_backgroundcheck.getValueAt(selectedRow, 1);
       
        if ("Check Requested".equals(statusval) || receiverval == null) {
            WorkRequest re = (WorkRequest) tbl_backgroundcheck.getValueAt(selectedRow, 1);
            re.setReceiver(account);
            re.setMessage("Bckground check Processing");
            re.setStatus("Bckground check Processing");
            populateTable();
            JOptionPane.showMessageDialog(null, "Work request has been assigned to you");
 
            populateTable();
            checkStatus(selectedRow);
            
           
        }
     
        else{
            
            if (receiverval.equals(account)) {
                JOptionPane.showMessageDialog(null, "Work request is already assigned to you");
            }
            else if (!receiverval.equals(account.getUsername())) {
                JOptionPane.showMessageDialog(null, "Work request is assigned to someone else");
                btn_appointment.setVisible(false);
            }
        }
    }//GEN-LAST:event_btn_assignActionPerformed

    private void btn_acceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_acceptActionPerformed
        // TODO add your handling code here:
        int selectedRow = tbl_backgroundcheck.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a work request");
            return;
        }
       
        
        Object receiverval = tbl_backgroundcheck.getValueAt(selectedRow, 3);
        Object statusval = tbl_backgroundcheck.getValueAt(selectedRow, 4);
        Parent parentval = (Parent)(UserAccount)tbl_backgroundcheck.getValueAt(selectedRow, 5);
        //UserAccount userAccount = (UserAccount)tbl_backgroundcheck.getValueAt(selectedRow, 2);
        //WorkRequest wr = (WorkRequest)tbl_backgroundcheck.getValueAt(selectedRow, 1);
        
        if ("Meeting Completed".equals(statusval)) {
         
            WorkRequest re = (WorkRequest) tbl_backgroundcheck.getValueAt(selectedRow, 1);
            JOptionPane.showMessageDialog(panel_appointment, re.getStatus());
            re.setReceiver(account);
            re.setMessage("APPROVED");
            re.setStatus("APPROVED");
            populateTable();
            JOptionPane.showMessageDialog(panel_appointment, "APPROVED");
            
            for(WorkRequest wr:parentval.getWorkQueue().getWorkRequestList()){
                wr.setSender(account);
                wr.setMessage("BACKGROUND CHECK APPROVED");
                wr.setStatus("BACKGROUND CHECK APPROVED");
            }
            
            populateTable();
            checkStatus(selectedRow);
            
            
          
        
        }

    }//GEN-LAST:event_btn_acceptActionPerformed

    private void btn_meetingcompletedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_meetingcompletedActionPerformed
        // TODO add your handling code here:
        int selectedRow = tbl_backgroundcheck.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a work request");
            return;
        }
        
        Object receiverval = tbl_backgroundcheck.getValueAt(selectedRow, 3);
        Object statusval = tbl_backgroundcheck.getValueAt(selectedRow, 4);
        Parent parentval = (Parent)(UserAccount)tbl_backgroundcheck.getValueAt(selectedRow, 5);
        
        
        if(statusval.equals("Appointment Scheduled")){
            WorkRequest re = (WorkRequest) tbl_backgroundcheck.getValueAt(selectedRow, 1);
            //BackgroundCheckWorkRequest bw = (BackgroundCheckWorkRequest) tbl_backgroundcheck.getValueAt(selectedRow, 1);
            re.setReceiver(account);
            re.setMessage("Meeting Completed");
            re.setStatus("Meeting Completed");
            //bw.setStatus("Meeting Completed");
            populateTable();
            JOptionPane.showMessageDialog(null, "Meeting Completed!");
            for(WorkRequest wr:parentval.getWorkQueue().getWorkRequestList()){
                wr.setSender(account);
                wr.setMessage("Meeting Scheduled");
                wr.setStatus("Meeting Completed");
            }
            
            checkStatus(selectedRow);
        }
        
    }//GEN-LAST:event_btn_meetingcompletedActionPerformed

    private void btn_declineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_declineActionPerformed
        // TODO add your handling code here:
        int selectedRow = tbl_backgroundcheck.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a work request");
            return;
        }
        
        Object receiverval = tbl_backgroundcheck.getValueAt(selectedRow, 3);
        Object statusval = tbl_backgroundcheck.getValueAt(selectedRow, 4);
        Parent parentval = (Parent)(UserAccount)tbl_backgroundcheck.getValueAt(selectedRow, 5);
        //UserAccount userAccount = (UserAccount)tbl_backgroundcheck.getValueAt(selectedRow, 2);
        
        if ("Meeting Completed".equals(statusval)) {
           WorkRequest re = (WorkRequest) tbl_backgroundcheck.getValueAt(selectedRow, 1);
            re.setReceiver(account);
            re.setMessage("DECLINED");
            re.setStatus("DECLINED");
            populateTable();
            JOptionPane.showMessageDialog(panel_appointment, "DECLINED");
            
            for(WorkRequest wr:parentval.getWorkQueue().getWorkRequestList()){
                wr.setSender(account);
                wr.setMessage("BACKGROUND CHECK DECLINED");
                wr.setStatus("BACKGROUND CHECK DECLINED");
            }
            
            populateTable();
            checkStatus(selectedRow);
          
        }
    }//GEN-LAST:event_btn_declineActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_accept;
    private javax.swing.JButton btn_appointment;
    private javax.swing.JButton btn_assign;
    private javax.swing.JButton btn_decline;
    private javax.swing.JButton btn_meetingcompleted;
    private javax.swing.JButton btn_viewAppointmnet;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panel_accept;
    private javax.swing.JPanel panel_appointment;
    private javax.swing.JPanel panel_assign;
    private javax.swing.JPanel panel_assign1;
    private javax.swing.JPanel panel_assign2;
    private javax.swing.JPanel panel_decline;
    private javax.swing.JPanel panel_meetingcompleted;
    private javax.swing.JPanel panel_viewAppointment;
    private javax.swing.JPanel panel_viewAppointment1;
    private javax.swing.JTable tbl_backgroundcheck;
    // End of variables declaration//GEN-END:variables
}
