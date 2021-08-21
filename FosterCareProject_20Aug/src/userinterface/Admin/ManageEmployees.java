/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Admin;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Agency;
import Business.Enterprise.CulturalEvents;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HealthCare;
import Business.Enterprise.Reinbursements;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jaspr
 */
public class ManageEmployees extends javax.swing.JPanel {

    /**
     * Creates new form ManageEmployees
     */
   
    JPanel userProcessContainer;
    EcoSystem business;
    Enterprise enterprise;
    Network network;
    OrganizationDirectory orgdir;
    
    public ManageEmployees(EcoSystem business,JPanel userProcessContainer,Network network, 
            Enterprise enterprise,OrganizationDirectory orgdir) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.business = business;
        this.network = network;
        this.orgdir = orgdir;
        //JOptionPane.showMessageDialog(btn_addEmployee, enterprise.getOrganizationDirectory().getOrganizationList());
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
        populateTable();
    }
    
    private void populateTable(){
        DefaultTableModel model = (DefaultTableModel) tbl_employee.getModel();
        model.setRowCount(0);
        
        for(Organization org:orgdir.getOrganizationList()){
            for(Employee emp:org.getEmployeeDirectory().getEmployeeList()){
                Object[] row = new Object[3];
                row[0] = org.getType().getValue();
                row[1] = org.getName();
                row[2] = emp.getName();
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_employee = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btn_addEmployee = new javax.swing.JButton();
        combo_orgtype = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txt_employeename = new javax.swing.JTextField();
        combo_orgname = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        jPanel3.setBackground(new java.awt.Color(204, 255, 0));

        jPanel4.setBackground(new java.awt.Color(153, 153, 0));

        tbl_employee.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbl_employee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Organisation Type", "Organisation Name", "Employee Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_employee);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Organisation Type");

        btn_addEmployee.setBackground(new java.awt.Color(51, 51, 51));
        btn_addEmployee.setText("ADD Employee");
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(combo_orgtype, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_employeename, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(combo_orgname, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 34, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(397, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(btn_addEmployee)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(combo_orgtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combo_orgname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_employeename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(btn_addEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(324, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1396, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 68, Short.MAX_VALUE)))
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 676, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGap(0, 676, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addEmployeeActionPerformed
        // TODO add your handling code here:
        
      for (Organization.Type type : Organization.Type.values()){
            if(combo_orgtype.getSelectedItem().equals(type.getValue())){
                for(Organization org:orgdir.getOrganizationList()){
                    if(org.getName().equals(combo_orgname.getSelectedItem())){
                        if(!txt_employeename.getText().isEmpty()){
                            org.getEmployeeDirectory().createEmployee(txt_employeename.getText());
                            JOptionPane.showMessageDialog(null,"Employee Added");
                            populateTable();
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Enter value", "Warning", JOptionPane.WARNING_MESSAGE);
                    }    
                    }
                }
            }
      }

    }//GEN-LAST:event_btn_addEmployeeActionPerformed

    private void combo_orgtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_orgtypeActionPerformed
        // TODO add your handling code here:
        //combo_orgname.removeAllItems();
        //JOptionPane.showMessageDialog(btn_addEmployee, enterprise.getOrganizationDirectory().getOrganizationList());
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
    }//GEN-LAST:event_combo_orgnameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addEmployee;
    private javax.swing.JComboBox<String> combo_orgname;
    private javax.swing.JComboBox<String> combo_orgtype;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_employee;
    private javax.swing.JTextField txt_employeename;
    // End of variables declaration//GEN-END:variables
}
