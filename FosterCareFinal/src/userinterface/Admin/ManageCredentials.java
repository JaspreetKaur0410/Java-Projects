/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Admin;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Employee.EmployeeDirectory;
import Business.Enterprise.Agency;
import Business.Enterprise.CulturalEvents;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HealthCare;
import Business.Enterprise.Reinbursements;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jaspr
 */
public class ManageCredentials extends javax.swing.JPanel {

    /**
     * Creates new form ManageCredentials
     */
    OrganizationDirectory organizationDir;
    JPanel userProcessContainer;
    EcoSystem business;
    Enterprise enterprise;
    Network network;
    EmployeeDirectory empdir;
    JPanel rightpanel;
    public ManageCredentials(EcoSystem business,JPanel userProcessContainer,Network network, 
            Enterprise enterprise, OrganizationDirectory organizationDir,JPanel rightpanel) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.business = business;
        this.network = network;
        this.organizationDir = organizationDir;
        this.rightpanel = rightpanel;
        
         /******************************************************************************************************/
         //populateOrgaisationType
         if(enterprise instanceof Agency){
             combo_orgtype.addItem(String.valueOf(Organization.Type.FosterOrganization));
             //combo_orgtype.addItem(String.valueOf(Organization.Type.Find_A_MatchOrganization));
             combo_orgtype.addItem(String.valueOf(Organization.Type.TrainingOrganization));
             combo_orgtype.addItem(String.valueOf(Organization.Type.BackgroundCheckOrganisation));
              
        }
        if(enterprise instanceof HealthCare){
            //JOptionPane.showMessageDialog(comboOrg, "Hello");
             combo_orgtype.addItem(String.valueOf(Organization.Type.DoctorOrganisation));
             //comboOrg.addItem(String.valueOf(Organization.Type.Find_A_MatchOrganization));
             combo_orgtype.addItem(String.valueOf(Organization.Type.LabOrganisation));
             combo_orgtype.addItem(String.valueOf(Organization.Type.PharmaOrganisation));
              
        } 
        if(enterprise instanceof Reinbursements){
            //JOptionPane.showMessageDialog(comboOrg, "Hello");
             combo_orgtype.addItem(String.valueOf(Organization.Type.ReinbursementsOrganisation));
             combo_orgtype.addItem(String.valueOf(Organization.Type.ReinbursementsFinanaceOrganisation));
        } 
        if(enterprise instanceof CulturalEvents){
            //JOptionPane.showMessageDialog(comboOrg, "Hello");
             combo_orgtype.addItem(String.valueOf(Organization.Type.CulturalEventOrganisation)); 
             combo_orgtype.addItem(String.valueOf(Organization.Type.CulturalEventOrganiser));
        } 
        /********************************************************************************************************/
         
        populateTable();
        
    }
    
    public void populateTable() {

        DefaultTableModel model = (DefaultTableModel) tbl_employee.getModel();

        model.setRowCount(0);

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                        Object row[] = new Object[4];
                        row[0] = organization.getType().getValue();
                        row[1] = organization;
                        row[2] = ua;
                        row[3] = ua.getRole();
                        model.addRow(row);
                     }
            }    
    }
    
    private void populateRoles(Organization organization){
        combo_roles.removeAllItems();
        //JOptionPane.showMessageDialog(btn_addEmployee, organization);
        for (Role role : organization.getSupportedRole()) {
            combo_roles.addItem(role.toString());
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_employee = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btn_addEmployee = new javax.swing.JButton();
        combo_orgtype = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        combo_orgname = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        combo_employee = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        combo_roles = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        txt_pwd = new javax.swing.JTextField();
        btn_update = new javax.swing.JButton();
        btn_remove = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jPanel4.setBackground(new java.awt.Color(204, 255, 0));

        jPanel5.setBackground(new java.awt.Color(153, 153, 0));

        tbl_employee.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbl_employee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Organisation Type", "Organisation Name", "Employee Name", "Employee Role"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_employee);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Organisation Type");

        btn_addEmployee.setBackground(new java.awt.Color(51, 51, 51));
        btn_addEmployee.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_addEmployee.setForeground(new java.awt.Color(255, 255, 255));
        btn_addEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        btn_addEmployee.setText("Create User");
        btn_addEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addEmployeeActionPerformed(evt);
            }
        });

        combo_orgtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_orgtypeActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Employee Name");

        combo_orgname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_orgnameActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Organisation Name");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Employee Role");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("UserName");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Password");

        btn_update.setBackground(new java.awt.Color(51, 51, 51));
        btn_update.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/update.png"))); // NOI18N
        btn_update.setText("Update Credentials");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_remove.setBackground(new java.awt.Color(51, 51, 51));
        btn_remove.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_remove.setForeground(new java.awt.Color(255, 255, 255));
        btn_remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete.png"))); // NOI18N
        btn_remove.setText("Remove User");
        btn_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(153, 153, 0));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setText("MANAGE CREDENTIALS");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(combo_orgtype, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(combo_employee, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(combo_orgname, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(combo_roles, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_pwd, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_addEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_remove, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(jLabel7))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(284, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(combo_orgtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_remove, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(btn_addEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(combo_orgname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(combo_roles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(combo_employee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txt_pwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(173, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1396, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 286, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 714, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1406, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 676, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1406, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 738, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1406, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 738, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addEmployeeActionPerformed
        // TODO add your handling code here:
        String userName = txt_username.getText();
        String password = txt_pwd.getText();
        if ("".equals(userName)) {
            JOptionPane.showMessageDialog(null, "Please enter username");
        } 
        else if (!business.checkIfUserIsUnique(userName)) {
            JOptionPane.showMessageDialog(null, "Please enter unique username");
        } 
        else if ("".equals(password)) {
            JOptionPane.showMessageDialog(null, "Please enter password");
        } 
        else 
        {
            for(Organization org:enterprise.getOrganizationDirectory().getOrganizationList()){
                if(combo_orgtype.getSelectedItem().equals(org.getType().getValue())){
                    if(combo_orgname.getSelectedItem().equals(org.getName())){
                        
                        for(Employee emp:org.getEmployeeDirectory().getEmployeeList()){
                            if(emp.getName().equals(combo_employee.getSelectedItem())){
                                for (Role role : org.getSupportedRole()) {
                                    if(role.toString().equals(combo_roles.getSelectedItem())){
                                        if(business.checkIfUserIsUnique(userName)){
                                            //JOptionPane.showMessageDialog(btn_addEmployee, role);
                                        org.getUserAccountDirectory().createUserAccount(userName, password, emp, role);
                                        business.getUserAccountDirectory().createUserAccount(userName, password, emp, role);
                                        JOptionPane.showMessageDialog(null, "User Account Created");
                                        txt_username.setText("");
                                        txt_pwd.setText("");
                                        populateTable();
                                        }
                                    }
                                }
                               
                            }
                        }
                    }
                        
                }
            }
        }
        
        txt_pwd.setText("");
        txt_username.setText("");
        
    }//GEN-LAST:event_btn_addEmployeeActionPerformed

    private void combo_orgtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_orgtypeActionPerformed
        // TODO add your handling code here:
        combo_orgname.removeAllItems();
        for(Organization org:enterprise.getOrganizationDirectory().getOrganizationList()){
            //JOptionPane.showMessageDialog(btn_addEmployee, combo_orgtype.getSelectedItem());
            //JOptionPane.showMessageDialog(combo_orgname, org.getType().getValue());
            if(combo_orgtype.getSelectedItem().equals(org.getType().getValue())){
                 combo_orgname.addItem(org.getName());
                 
                 }
            }

    }//GEN-LAST:event_combo_orgtypeActionPerformed

    private void combo_orgnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_orgnameActionPerformed
        // TODO add your handling code here:
        combo_employee.removeAllItems();
        for(Organization org:enterprise.getOrganizationDirectory().getOrganizationList()){
            if(combo_orgtype.getSelectedItem().equals(org.getType().getValue())){
               for(Employee emp:org.getEmployeeDirectory().getEmployeeList()){
                   combo_employee.addItem(emp.getName());
                   populateRoles(org);
               }
            }
        }
        
    }//GEN-LAST:event_combo_orgnameActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
         DefaultTableModel model = (DefaultTableModel) tbl_employee.getModel();
         int selectedrow = tbl_employee.getSelectedRow();
         if(selectedrow < 0){
             JOptionPane.showMessageDialog(null, "Choose Employee");
             return;
         }
         else{
        Organization org = (Organization) model.getValueAt(selectedrow, 1);
        UserAccount emp = (UserAccount) model.getValueAt(selectedrow, 2);
        Role role = (Role) model.getValueAt(selectedrow, 3);
        
        UpdateCredentials update = new UpdateCredentials(business, userProcessContainer, network, 
                                enterprise,enterprise.getOrganizationDirectory(),org,emp,rightpanel,role);
        userProcessContainer.add(update);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel model = (DefaultTableModel) tbl_employee.getModel();
         int selectedrow = tbl_employee.getSelectedRow();
         if(selectedrow < 0){
             JOptionPane.showMessageDialog(null, "Choose Employee");
             return;
         }
         else{
        Organization org = (Organization) model.getValueAt(selectedrow, 1);
        UserAccount emp = (UserAccount) model.getValueAt(selectedrow, 2);
        Role role = (Role) model.getValueAt(selectedrow, 3);
        org.getEmployeeDirectory().removeEmployee(emp.getEmployee());
        business.getUserAccountDirectory().deleteUser(emp);
        org.getUserAccountDirectory().deleteUser(emp);
        populateTable();
        }
        
    }//GEN-LAST:event_btn_removeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addEmployee;
    private javax.swing.JButton btn_remove;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> combo_employee;
    private javax.swing.JComboBox<String> combo_orgname;
    private javax.swing.JComboBox<String> combo_orgtype;
    private javax.swing.JComboBox<String> combo_roles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_employee;
    private javax.swing.JTextField txt_pwd;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}