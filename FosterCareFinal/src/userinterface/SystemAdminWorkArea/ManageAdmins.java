/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.AdminRole;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jaspr
 */
public class ManageAdmins extends javax.swing.JPanel {

    /**
     * Creates new form ManageAdmins
     */
    JPanel userProcessContainer;
    EcoSystem system;
    Network network_g;
    public ManageAdmins(EcoSystem system,JPanel userProcessContainer) {
        initComponents();
        //JOptionPane.showMessageDialog(combostate, system.getEnterpriseDirectory().getEnterpriseList());
        this.system = system;
        this.userProcessContainer = userProcessContainer;
        
        populateState();
        populateTable();
        
        panel_update.setVisible(false);
        btn_save.setVisible(false);
 
    }
    
    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_admins.getModel();

        model.setRowCount(0);
        for (Network network : system.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (UserAccount userAccount : enterprise.getUserAccountDirectory().getUserAccountList()) {
                    Object[] row = new Object[4];
                    row[0] = network;
                    row[1] = enterprise.getEnterpriseType().getValue();
                    row[2] = enterprise;
                    row[3] = userAccount;
                    model.addRow(row);
                }
            }
        }
    }
    
    private void populateState(){
        combostate.removeAllItems();
        for (Network network : system.getNetworkList()) {
            combostate.addItem(network.getName());
        }
    }
    
    private void populateEnterprise(Network network){
        comboenterprise.removeAllItems();
        for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
            comboenterprise.addItem(enterprise.getName());
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_admins = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btn_addenterprise = new javax.swing.JButton();
        combostate = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        comboenterprise = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JTextField();
        brn_delete = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        panel_update = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txt_type = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_state = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_ebtname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_username1 = new javax.swing.JTextField();
        txt_password1 = new javax.swing.JTextField();
        btn_save = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(204, 255, 0));

        jPanel3.setBackground(new java.awt.Color(153, 153, 0));

        tbl_admins.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbl_admins.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "State", "EnterPrise Type", "EnterPrise Name", "UserName"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_admins);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("STATE NAME");

        btn_addenterprise.setBackground(new java.awt.Color(51, 51, 51));
        btn_addenterprise.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_addenterprise.setForeground(new java.awt.Color(255, 255, 255));
        btn_addenterprise.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        btn_addenterprise.setText("Create Admin");
        btn_addenterprise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addenterpriseActionPerformed(evt);
            }
        });

        combostate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combostate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combostateActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("ENTERPRISE");

        comboenterprise.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Username");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Password");

        brn_delete.setBackground(new java.awt.Color(51, 51, 51));
        brn_delete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        brn_delete.setForeground(new java.awt.Color(255, 255, 255));
        brn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete.png"))); // NOI18N
        brn_delete.setText("Remove Admin");
        brn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brn_deleteActionPerformed(evt);
            }
        });

        btn_update.setBackground(new java.awt.Color(51, 51, 51));
        btn_update.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/update.png"))); // NOI18N
        btn_update.setText("Update Admin");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        panel_update.setBackground(new java.awt.Color(153, 153, 0));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("STATE NAME");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Enterprise");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Enterprise Type");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Username");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Password");

        javax.swing.GroupLayout panel_updateLayout = new javax.swing.GroupLayout(panel_update);
        panel_update.setLayout(panel_updateLayout);
        panel_updateLayout.setHorizontalGroup(
            panel_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_updateLayout.createSequentialGroup()
                .addGroup(panel_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_updateLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_state)
                            .addComponent(txt_type)
                            .addComponent(txt_ebtname)))
                    .addGroup(panel_updateLayout.createSequentialGroup()
                        .addGroup(panel_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_updateLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel5))
                            .addGroup(panel_updateLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel7))
                            .addGroup(panel_updateLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel6))
                            .addGroup(panel_updateLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_username1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                    .addComponent(txt_password1))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel_updateLayout.setVerticalGroup(
            panel_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_updateLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_state, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_ebtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(panel_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(txt_username1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(txt_password1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        btn_save.setBackground(new java.awt.Color(51, 51, 51));
        btn_save.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_save.setForeground(new java.awt.Color(255, 255, 255));
        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save.png"))); // NOI18N
        btn_save.setText("Save Modification");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(153, 153, 0));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setText("MANAGE ADMINS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboenterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combostate, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btn_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(brn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_addenterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(142, 142, 142)
                        .addComponent(btn_save))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(panel_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(jLabel10)))
                .addContainerGap(427, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(combostate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(comboenterprise, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_addenterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(brn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(panel_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(374, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1383, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 890, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addenterpriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addenterpriseActionPerformed
        // TODO add your handling code here:
        
        String username = txt_username.getText();
        String password = String.valueOf(txt_password.getText());
        
        for(Network network:system.getNetworkList()){
            if(network.getName().equals(combostate.getSelectedItem())){
                for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                    if(enterprise.getName().equals(comboenterprise.getSelectedItem())){
                        if (username.isEmpty() || password.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please enter all fields", "Warning", JOptionPane.WARNING_MESSAGE);
                        } 
                        else {
                            if (system.checkIfUserIsUnique(username)) {
                                Employee employee = enterprise.getEmployeeDirectory().createEmployee(enterprise.getName());
                                UserAccount account = enterprise.getUserAccountDirectory().createUserAccount(username, password, employee, new AdminRole());
                                system.getUserAccountDirectory().createUserAccount(username, password, employee, new AdminRole());
                                txt_username.setText("");
                                txt_password.setText("");

                                JOptionPane.showMessageDialog(null, "Account created!");
                                //populateTable();
                            } else {
                                JOptionPane.showMessageDialog(null, "Please enter unique username", "Warning", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                                    }
                                }
                            }
                        }
        
        populateTable();
   
    }//GEN-LAST:event_btn_addenterpriseActionPerformed

    private void combostateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combostateActionPerformed
        // TODO add your handling code here:
        for(Network network:system.getNetworkList()){
            if(network.getName().equals(combostate.getSelectedItem())){
                network_g = network;
        }
        if (network_g != null) {
            //JOptionPane.showMessageDialog(combostate, network_g.getEnterpriseDirectory().getEnterpriseList());
            populateEnterprise(network_g);
        }
        }
    }//GEN-LAST:event_combostateActionPerformed

    private void brn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brn_deleteActionPerformed
        // TODO add your handling code here:
        
        
        DefaultTableModel model = (DefaultTableModel) tbl_admins.getModel();
         int selectedrow = tbl_admins.getSelectedRow();
         if(selectedrow < 0){
             JOptionPane.showMessageDialog(null, "Choose Admin");
             return;
         }
         else{
            Enterprise ennt = (Enterprise) model.getValueAt(selectedrow, 2);
            Network network1 = (Network) model.getValueAt(selectedrow, 0);
            UserAccount emp = (UserAccount) model.getValueAt(selectedrow, 3);
            
            for(Network network:system.getNetworkList()){
                if(network.equals(network1)){
                    for(Enterprise ent:network.getEnterpriseDirectory().getEnterpriseList()){
                        if(ent.equals(ennt)){
                            if(ent.getUserAccountDirectory().getUserAccountList().contains(emp)){
                               
                                //if(ua.equals(emp)){
                                    ennt.getUserAccountDirectory().deleteUser(emp);
                                    system.getUserAccountDirectory().deleteUser(emp);
                                    JOptionPane.showMessageDialog(combostate, "Admin Removed");
                                //}
                            }
                        }
                    }
                }
            }
            
            populateTable();
        }
        
    }//GEN-LAST:event_brn_deleteActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel model = (DefaultTableModel) tbl_admins.getModel();
        int selectedrow = tbl_admins.getSelectedRow();
        if(selectedrow < 0){
            JOptionPane.showMessageDialog(null, "Choose Admin");
            return;
        }
        else{
            btn_save.setVisible(true);
            panel_update.setVisible(true);
            Enterprise ennt = (Enterprise) model.getValueAt(selectedrow, 2);
            Network network1 = (Network) model.getValueAt(selectedrow, 0);
            UserAccount ua = (UserAccount) model.getValueAt(selectedrow, 3);
            txt_state.setText(network1.getName());
            txt_type.setText(ennt.getEnterpriseType().getValue());
            txt_ebtname.setText(ennt.getName());
            txt_username1.setText(ua.getUsername());
            txt_password1.setText(ua.getPassword());
        }
        
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:
        
        String userName = txt_username1.getText();
        String password = txt_password1.getText();
        DefaultTableModel model = (DefaultTableModel) tbl_admins.getModel();
         int selectedrow = tbl_admins.getSelectedRow();
         if(selectedrow < 0){
             JOptionPane.showMessageDialog(null, "Choose Admin");
             return;
         }
         else{
            Enterprise ennt = (Enterprise) model.getValueAt(selectedrow, 2);
            Network network1 = (Network) model.getValueAt(selectedrow, 0);
            UserAccount emp = (UserAccount) model.getValueAt(selectedrow, 3);
            
            for(Network network:system.getNetworkList()){
                if(network.equals(network1)){
                    for(Enterprise ent:network.getEnterpriseDirectory().getEnterpriseList()){
                        
                        if(ent.equals(ennt)){
                            for(Employee employee:ent.getEmployeeDirectory().getEmployeeList()){
                                if((employee).equals(emp.getEmployee())){
                                    for(UserAccount ua:ent.getUserAccountDirectory().getUserAccountList()){
                                        if(ua.equals(emp)){
                                            ent.getUserAccountDirectory().updateuseraccount(ua, userName, password, employee, new AdminRole());
                                             system.getUserAccountDirectory().updateuseraccount(ua,userName, password, employee, new AdminRole());
                                             JOptionPane.showMessageDialog(null, "User Account Updated");
                                        }
                                    }
                            }
                            }
                        }
                    }
                }
            }
            populateTable();
        }

        panel_update.setVisible(false);
        btn_save.setVisible(false);
    }//GEN-LAST:event_btn_saveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brn_delete;
    private javax.swing.JButton btn_addenterprise;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> comboenterprise;
    private javax.swing.JComboBox<String> combostate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel_update;
    private javax.swing.JTable tbl_admins;
    private javax.swing.JTextField txt_ebtname;
    private javax.swing.JTextField txt_password;
    private javax.swing.JTextField txt_password1;
    private javax.swing.JTextField txt_state;
    private javax.swing.JTextField txt_type;
    private javax.swing.JTextField txt_username;
    private javax.swing.JTextField txt_username1;
    // End of variables declaration//GEN-END:variables
}
