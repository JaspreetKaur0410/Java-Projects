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
import Business.Network.Network;
import Business.Organization.BackgroundCheckOrganisation;
import Business.Organization.Organization;
import Business.Organization.TrainingOrganization;
import Business.Parent.Parent;
import Business.UserAccount.UserAccount;
import Business.Utils.CommonMail;
import Business.WorkQueue.BackgroundCheckWorkRequest;
import Business.WorkQueue.ParentWorkRequest;
import Business.WorkQueue.TrainingWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jaspr
 */
public class FosterAdminWorkRequest extends javax.swing.JPanel implements ListSelectionListener{

    /**
     * Creates new form FosterAdminWorkRequest
     */
    EcoSystem business;
    JPanel userProcessContainer;
    Enterprise enterprise;
    Organization organization;
    ChildDirectory childdir;
    JPanel rightpanel1;
    ParentWorkRequest parentrequest;
    UserAccount account;
    

    public FosterAdminWorkRequest(EcoSystem business, JPanel userProcessContainer,
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
    
        btn_request.setVisible(false);
        btn_assign.setVisible(false);
        panel_assign.setVisible(false);
        panel_request.setVisible(false);
        panel_training.setVisible(false);
        btn_training.setVisible(false);
        panel_approve.setVisible(false);
        btn_approve.setVisible(false);
        
        populateTable();
        
    }
    
    
    
   
    
    public void checkStatus(int selectedRow){
        DefaultTableModel model = (DefaultTableModel) tbl_fosterCheckStatus.getModel();
        Object statusval = tbl_fosterCheckStatus.getValueAt(selectedRow, 5);
    
        if(statusval.equals("Check Requested")){
            btn_assign.setVisible(false);
            btn_request.setVisible(true);
            panel_assign.setVisible(false);
            panel_request.setVisible(true);
        }
        else if(statusval.equals("Requested to Adopt")){
            panel_assign.setVisible(true);
            btn_assign.setVisible(true);
            btn_request.setVisible(false);
            panel_request.setVisible(false);
        }
        else if(statusval.equals("Check Pending")){
            btn_assign.setVisible(false);
            btn_request.setVisible(false);
            panel_assign.setVisible(false);
            panel_request.setVisible(false);
        }
        else if(statusval.equals("BACKGROUND CHECK APPROVED")){
            btn_assign.setVisible(false);
            btn_request.setVisible(false);
            panel_assign.setVisible(false);
            panel_request.setVisible(false);
            panel_training.setVisible(true);
            btn_training.setVisible(true);
        }
        else if(statusval.equals("Training Completed")){
            btn_assign.setVisible(false);
            btn_request.setVisible(false);
            panel_assign.setVisible(false);
            panel_request.setVisible(false);
            panel_training.setVisible(false);
            btn_training.setVisible(false);
            panel_approve.setVisible(true);
            btn_approve.setVisible(true);
        }
        else if(statusval.equals("APPROVED TO ADOPT")){
            btn_assign.setVisible(false);
            btn_request.setVisible(false);
            panel_assign.setVisible(false);
            panel_request.setVisible(false);
            panel_training.setVisible(false);
            btn_training.setVisible(false);
            panel_approve.setVisible(false);
            btn_approve.setVisible(false);
        }
        else if (statusval.equals("Requested For Training")){
            btn_assign.setVisible(false);
            btn_request.setVisible(false);
            panel_assign.setVisible(false);
            panel_request.setVisible(false);
            panel_training.setVisible(false);
            btn_training.setVisible(false);
            panel_approve.setVisible(false);
            btn_approve.setVisible(false);
        }
    }
    
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel) tbl_fosterCheckStatus.getModel();
        model.setRowCount(0);
        for(WorkRequest workrequest:organization.getWorkQueue().getWorkRequestList()){
            if(workrequest instanceof ParentWorkRequest){
                Object[] row = new Object[model.getColumnCount()];
                
                    if(workrequest.getSender().equals("")){
                        row[0] = "My Request in Process";
                    }
                    else{
                        row[0] = workrequest.getSender().getUsername();
                    }
                    row[1] =  workrequest;
                    row[2] = ((ParentWorkRequest) workrequest).getChild();
                    row[3] = ((ParentWorkRequest) workrequest).getSender();
                    row[4] = workrequest.getReceiver() == null ? null : account;
                    //row[5] = ((ParentWorkRequest) workrequest).getParent().getIncome();
                    if(workrequest.getStatus().equals("Reuest To Adopt")){
                        row[5] = "Requested to Adopt";
                    }
                    else if(workrequest.getStatus().equals("Check Requested")){
                        row[5] = "Check Requested";
                    }
                   else if(workrequest.getStatus().equals("Check Pending")){
                        row[5] = "Check Pending";
                    }
                   else{
                       row[5] = workrequest.getStatus();
                   }
                    row[6] = ((ParentWorkRequest) workrequest).getParent();
                   
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
        tbl_fosterCheckStatus = new javax.swing.JTable();
        panel_assign = new javax.swing.JPanel();
        btn_assign = new javax.swing.JButton();
        panel_request = new javax.swing.JPanel();
        btn_request = new javax.swing.JButton();
        panel_training = new javax.swing.JPanel();
        btn_training = new javax.swing.JButton();
        panel_approve = new javax.swing.JPanel();
        btn_approve = new javax.swing.JButton();

        jPanel5.setBackground(new java.awt.Color(204, 255, 0));

        jPanel6.setBackground(new java.awt.Color(153, 153, 0));

        tbl_fosterCheckStatus.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbl_fosterCheckStatus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Sender Username", "Message", "Child Name", "Sender Name", "Reciever Name", "Status", "Parent"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_fosterCheckStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_fosterCheckStatusMouseClicked(evt);
            }
        });
        tbl_fosterCheckStatus.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tbl_fosterCheckStatusPropertyChange(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_fosterCheckStatus);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
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

        panel_request.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_request.setBackground(new java.awt.Color(51, 51, 51));
        btn_request.setText("Request Background Check");
        btn_request.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_requestActionPerformed(evt);
            }
        });
        panel_request.add(btn_request, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 12, 208, 34));

        btn_training.setText("Process for Training");
        btn_training.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_trainingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_trainingLayout = new javax.swing.GroupLayout(panel_training);
        panel_training.setLayout(panel_trainingLayout);
        panel_trainingLayout.setHorizontalGroup(
            panel_trainingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_trainingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_training, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_trainingLayout.setVerticalGroup(
            panel_trainingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_trainingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_training, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

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
                .addComponent(btn_approve, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_approveLayout.setVerticalGroup(
            panel_approveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_approveLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_approve, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(panel_assign, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_request, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panel_training, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_approve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(546, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(panel_request, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(panel_assign, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel_training, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_approve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(447, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1273, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 805, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_assignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_assignActionPerformed
        // TODO add your handling code here:
        int selectedRow = tbl_fosterCheckStatus.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a work request");
            return;
        }
        
        Object receiverval = tbl_fosterCheckStatus.getValueAt(selectedRow, 4);
        Object statusval = tbl_fosterCheckStatus.getValueAt(selectedRow, 5);
        Parent parentval = (Parent) tbl_fosterCheckStatus.getValueAt(selectedRow,6 );
        Child childval = (Child) tbl_fosterCheckStatus.getValueAt(selectedRow,2 );

        if ("Requested to Adopt".equals(statusval) || receiverval == null) {
            WorkRequest re = (WorkRequest) tbl_fosterCheckStatus.getValueAt(selectedRow, 1);
            re.setReceiver(account);
            re.setStatus("Check Requested");
            re.setParent(parentval);
            re.setChild(childval);
            
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
                btn_request.setVisible(false);
            }
        }
       
    }//GEN-LAST:event_btn_assignActionPerformed

    private void btn_requestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_requestActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel model = (DefaultTableModel) tbl_fosterCheckStatus.getModel();
     
        int selectedRow = tbl_fosterCheckStatus.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a workrequest");
            return;
        }
        
        Object receiverval = tbl_fosterCheckStatus.getValueAt(selectedRow, 4);
        Object statusval = tbl_fosterCheckStatus.getValueAt(selectedRow, 5);
        Object childval = tbl_fosterCheckStatus.getValueAt(selectedRow, 2);
        Object parentval = tbl_fosterCheckStatus.getValueAt(selectedRow, 3);
        Parent parentval1 = (Parent) tbl_fosterCheckStatus.getValueAt(selectedRow,6 );
        Child childval1 = (Child) tbl_fosterCheckStatus.getValueAt(selectedRow,2 );
      
        if(String.valueOf(statusval).equals("Check Requested")){
            if(receiverval.equals(account)){
            BackgroundCheckWorkRequest backgroundrequest = new BackgroundCheckWorkRequest();
            backgroundrequest.setMessage("Check Pending");
            backgroundrequest.setStatus("Check Pending");
            backgroundrequest.setSender(account);
            backgroundrequest.setSender(account);
            backgroundrequest.setComment("Check Pending");
            backgroundrequest.setBgcStatus("Check Pending");
            backgroundrequest.setParent((Parent)(UserAccount)parentval);
            //backgroundrequest.setChild((Child)(UserAccount)childval);
  
            WorkRequest re = (WorkRequest) tbl_fosterCheckStatus.getValueAt(selectedRow, 1);
            re.setStatus("Check Pending");
            re.setMessage("Checking Bckground");
            re.setParent(parentval1);
            re.setChild(childval1);
            populateTable();
            checkStatus(selectedRow);
            
            Organization org = null;
                for (Network network : business.getNetworkList()) {
                    for (Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()) {
                        for (Organization organization : ent.getOrganizationDirectory().getOrganizationList()) {
                            if (organization instanceof BackgroundCheckOrganisation) {

                                org = organization;
                                break;
                            }
                        }
                    }
                }

                if (org != null) {
                    org.getWorkQueue().getWorkRequestList().add(backgroundrequest);
                    account.getWorkQueue().getWorkRequestList().add(backgroundrequest);
                    business.getWorkQueue().getWorkRequestList().add(backgroundrequest);
                }
                else{
                    JOptionPane.showMessageDialog(panel_approve, "Create Organisation");
                }
            //JOptionPane.showMessageDialog(rightpanel1,org.getWorkQueue().getWorkRequestList());
        }
        }
   
    
        
    }//GEN-LAST:event_btn_requestActionPerformed

    private void tbl_fosterCheckStatusPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tbl_fosterCheckStatusPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_fosterCheckStatusPropertyChange

    private void tbl_fosterCheckStatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_fosterCheckStatusMouseClicked
        // TODO add your handling code here:
       tbl_fosterCheckStatus.addMouseListener(new MouseAdapter() {
           
            public void mousePressed(MouseEvent e) {
              int selectedRow = tbl_fosterCheckStatus.getSelectedRow();
              checkStatus(selectedRow);
            }
           
       });
        
        
    }//GEN-LAST:event_tbl_fosterCheckStatusMouseClicked

    private void btn_trainingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_trainingActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel model = (DefaultTableModel) tbl_fosterCheckStatus.getModel();
     
        int selectedRow = tbl_fosterCheckStatus.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a workrequest");
            return;
        }
        
        Object receiverval = tbl_fosterCheckStatus.getValueAt(selectedRow, 4);
        Object statusval = tbl_fosterCheckStatus.getValueAt(selectedRow, 5);
        Object childval = tbl_fosterCheckStatus.getValueAt(selectedRow, 2);
        Object parentval = tbl_fosterCheckStatus.getValueAt(selectedRow, 6);
        Parent parentval1 = (Parent) tbl_fosterCheckStatus.getValueAt(selectedRow,6 );
        Child childval1 = (Child) tbl_fosterCheckStatus.getValueAt(selectedRow,2 );
   
      
        if(String.valueOf(statusval).equals("BACKGROUND CHECK APPROVED")){
            if(receiverval.equals(account)){
            TrainingWorkRequest trainingrequest = new TrainingWorkRequest();
            trainingrequest.setMessage("Requested For Training");
            trainingrequest.setStatus("Requested For Training");
            trainingrequest.setSender(account);
            trainingrequest.setSender(account);
            trainingrequest.setParent((Parent)(UserAccount)parentval);
            //backgroundrequest.setChild((Child)(UserAccount)childval);
  
            WorkRequest re = (WorkRequest) tbl_fosterCheckStatus.getValueAt(selectedRow, 1);
            re.setStatus("Requested For Training");
            re.setMessage("Requested For Training");
            re.setParent(parentval1);
            re.setChild(childval1);
            populateTable();
            checkStatus(selectedRow);
            
            Organization org = null;
                for (Network network : business.getNetworkList()) {
                    for (Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()) {
                        for (Organization organization : ent.getOrganizationDirectory().getOrganizationList()) {
                            if (organization instanceof TrainingOrganization) {
                                org = organization;
                                break;
                            }
                        }
                    }
                }

                if (org != null) {
                    org.getWorkQueue().getWorkRequestList().add(trainingrequest);
                    account.getWorkQueue().getWorkRequestList().add(trainingrequest);
                    business.getWorkQueue().getWorkRequestList().add(trainingrequest);
                }
                else{
                    JOptionPane.showMessageDialog(panel_approve, "Create Organisation");
                }
            JOptionPane.showMessageDialog(rightpanel1,org.getWorkQueue().getWorkRequestList());
        }
        }
   
        
    }//GEN-LAST:event_btn_trainingActionPerformed

    private void btn_approveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_approveActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = tbl_fosterCheckStatus.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a work request");
            return;
        }
       
        
        Object receiverval = tbl_fosterCheckStatus.getValueAt(selectedRow, 4);
        Object statusval = tbl_fosterCheckStatus.getValueAt(selectedRow, 5);
        Parent parentval = (Parent)(UserAccount)tbl_fosterCheckStatus.getValueAt(selectedRow, 6);
        Child childval = (Child)(UserAccount)tbl_fosterCheckStatus.getValueAt(selectedRow, 2);
        Parent parentval1 = (Parent) tbl_fosterCheckStatus.getValueAt(selectedRow,6 );
        //Child childval1 = (Child) tbl_fosterCheckStatus.getValueAt(selectedRow,2 );
        
        if ("Training Completed".equals(statusval)) {
         
            WorkRequest re = (WorkRequest) tbl_fosterCheckStatus.getValueAt(selectedRow, 1);
         
            re.setReceiver(account);
            re.setChild(childval);
            re.setParent(parentval1);
            re.setMessage("APPROVED TO ADOPT");
            re.setStatus("APPROVED TO ADOPT");
            re.getChild().setIsAdopted(true);
         
        
            populateTable();
            JOptionPane.showMessageDialog(null, "APPROVED");
            
            for(WorkRequest wr:parentval.getWorkQueue().getWorkRequestList()){
                wr.setSender(account);
                wr.getParent().setFlag(false);               
                wr.getChild().setIsAdopted(true);
                wr.setMessage("APPROVED TO ADOPT");
                wr.setStatus("APPROVED TO ADOPT");
            }
            
            populateTable();
            checkStatus(selectedRow);
            
            for(Child c:organization.getChildDirectory().getChildlist()){
                if(c.getUsername().equals(childval.getUsername())){
                    //JOptionPane.showMessageDialog(panel_approve, c.isIsAdopted());
                    c.setIsAdopted(true);
                    c.setParent(parentval);
                    //JOptionPane.showMessageDialog(panel_approve, c.isIsAdopted());
                }
            }
            
            
            for(Child c:business.getChildDirectory().getChildlist()){
                if(c.getUsername().equals(childval.getUsername())){
                    //JOptionPane.showMessageDialog(panel_approve, c.isIsAdopted());
                    c.setIsAdopted(true);
                    c.setParent(parentval);
                    //JOptionPane.showMessageDialog(panel_approve, c.isIsAdopted());
                }
            }
            
            String subject = "Account activation";
            String content = "Dear"+" "+parentval.getFirstname()+" "+"Congratulations on adopting a child";
            
            //CommonMail.sendEmailMessage(parentval.getEmail(), subject, content);
            //JOptionPane.showMessageDialog(null, "CONGRATULATIONS! ADOPTION PROCESS COMPLETED");
        }
        
        
    }//GEN-LAST:event_btn_approveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_approve;
    private javax.swing.JButton btn_assign;
    private javax.swing.JButton btn_request;
    private javax.swing.JButton btn_training;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panel_approve;
    private javax.swing.JPanel panel_assign;
    private javax.swing.JPanel panel_request;
    private javax.swing.JPanel panel_training;
    private javax.swing.JTable tbl_fosterCheckStatus;
    // End of variables declaration//GEN-END:variables

    @Override
    public void valueChanged(ListSelectionEvent e) {
        
      JOptionPane.showMessageDialog(rightpanel1, "Hello");
  
    }
    
}
