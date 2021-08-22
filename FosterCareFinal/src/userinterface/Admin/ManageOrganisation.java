/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Admin;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Agency;
import Business.Enterprise.CulturalEvents;
import Business.Enterprise.HealthCare;
import Business.Enterprise.Reinbursements;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jaspr
 */
public class ManageOrganisation extends javax.swing.JPanel {

    /**
     * Creates new form ManageOrganisation
     */
    JPanel userProcessContainer;
    EcoSystem business;
    Enterprise enterprise;
    Network network;
    OrganizationDirectory organisationDir;
    JPanel rightpanel;
    
    public ManageOrganisation(EcoSystem business,JPanel userProcessContainer,Network network, 
            Enterprise enterprise,OrganizationDirectory organisationDir,JPanel rightpanel) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.business = business;
        this.network = network;
        this.organisationDir = organisationDir;
        this.rightpanel = rightpanel;
        //JOptionPane.showMessageDialog(comboOrg,organisationDir);
        
        comboOrg.removeAllItems();
        if(enterprise instanceof Agency){
            //JOptionPane.showMessageDialog(comboOrg, "Hello");
             comboOrg.addItem(String.valueOf(Organization.Type.FosterOrganization));
             //comboOrg.addItem(String.valueOf(Organization.Type.Find_A_MatchOrganization));
             comboOrg.addItem(String.valueOf(Organization.Type.TrainingOrganization));
             comboOrg.addItem(String.valueOf(Organization.Type.BackgroundCheckOrganisation));
              
        }  
        if(enterprise instanceof HealthCare){
            //JOptionPane.showMessageDialog(comboOrg, "Hello");
             comboOrg.addItem(String.valueOf(Organization.Type.DoctorOrganisation));
             //comboOrg.addItem(String.valueOf(Organization.Type.Find_A_MatchOrganization));
             comboOrg.addItem(String.valueOf(Organization.Type.LabOrganisation));
             comboOrg.addItem(String.valueOf(Organization.Type.PharmaOrganisation));
              
        } 
        if(enterprise instanceof Reinbursements){
            //JOptionPane.showMessageDialog(comboOrg, "Hello");
             comboOrg.addItem(String.valueOf(Organization.Type.ReinbursementsOrganisation));
             comboOrg.addItem(String.valueOf(Organization.Type.ReinbursementsFinanaceOrganisation));
  
        } 
        if(enterprise instanceof CulturalEvents){
            //JOptionPane.showMessageDialog(comboOrg, "Hello");
             comboOrg.addItem(String.valueOf(Organization.Type.CulturalEventOrganisation));
             comboOrg.addItem(String.valueOf(Organization.Type.CulturalEventOrganiser));
        } 
       
        populateTable();
        //JOptionPane.showMessageDialog(comboOrg, organisationDir.getOrganizationList());
    }
    
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel) tbl_org.getModel();
        model.setRowCount(0);
        //JOptionPane.showMessageDialog(comboOrg, organisationdir.getOrganizationList());
       
        for (Organization organization : organisationDir.getOrganizationList()){
            //JOptionPane.showMessageDialog(comboOrg, organization.getName());
            Object[] row = new Object[2];
            row[0] = organization.getType().getValue();
            row[1] = organization;
            
            model.addRow(row);
        }
    }
    public void populateOrg(){
        comboOrg.removeAllItems();
        if(enterprise instanceof Agency){
             comboOrg.addItem(String.valueOf(Organization.Type.FosterOrganization));
             //comboOrg.addItem(String.valueOf(Organization.Type.Find_A_MatchOrganization));
             comboOrg.addItem(String.valueOf(Organization.Type.TrainingOrganization));
             comboOrg.addItem(String.valueOf(Organization.Type.BackgroundCheckOrganisation));
              
        }
        if(enterprise instanceof HealthCare){
             comboOrg.addItem(String.valueOf(Organization.Type.DoctorOrganisation));
             //comboOrg.addItem(String.valueOf(Organization.Type.Find_A_MatchOrganization));
             comboOrg.addItem(String.valueOf(Organization.Type.LabOrganisation));
             comboOrg.addItem(String.valueOf(Organization.Type.PharmaOrganisation));
              
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
        tbl_org = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btn_addenterprise = new javax.swing.JButton();
        comboOrg = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txt_org = new javax.swing.JTextField();
        delete_org = new javax.swing.JButton();
        update_org = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 386, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 667, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 0));

        jPanel3.setBackground(new java.awt.Color(153, 153, 0));

        tbl_org.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tbl_org.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Organisation Type", "Organisation NAme"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_org);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Organisation Type");

        btn_addenterprise.setBackground(new java.awt.Color(51, 51, 51));
        btn_addenterprise.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_addenterprise.setForeground(new java.awt.Color(255, 255, 255));
        btn_addenterprise.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        btn_addenterprise.setText("ADD Organisation");
        btn_addenterprise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addenterpriseActionPerformed(evt);
            }
        });

        comboOrg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboOrgActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Organisation Name");

        delete_org.setBackground(new java.awt.Color(51, 51, 51));
        delete_org.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        delete_org.setForeground(new java.awt.Color(255, 255, 255));
        delete_org.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete.png"))); // NOI18N
        delete_org.setText("Delete Organisation");
        delete_org.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_orgActionPerformed(evt);
            }
        });

        update_org.setBackground(new java.awt.Color(51, 51, 51));
        update_org.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        update_org.setForeground(new java.awt.Color(255, 255, 255));
        update_org.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/update.png"))); // NOI18N
        update_org.setText("Update Organisation");
        update_org.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_orgActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(153, 153, 0));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("MANAGE ORGANISATIONS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(326, 326, 326)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(delete_org)
                                .addGap(29, 29, 29)
                                .addComponent(update_org))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(48, 48, 48)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboOrg, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_org, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_addenterprise)))))
                .addContainerGap(688, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboOrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_org, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_addenterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delete_org, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update_org, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(182, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(1019, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addenterpriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addenterpriseActionPerformed
        // TODO add your handling code here:
        
       /* if ("".equals(txt_org.getText())) {
            JOptionPane.showMessageDialog(null, "Enter organization name!");
        } 
        else {
            for (Organization.Type type : Organization.Type.values()){
           
            if(comboOrg.getSelectedItem().equals(type.getValue())){
                Organization.Type type_g = type;
                //JOptionPane.showMessageDialog(comboOrg, organisationDir);
            //if (organisationDir.isUnique(txt_org.getText())) {
                //JOptionPane.showMessageDialog(comboOrg, type_g);
                organisationDir.createOrganization(txt_org.getText(), type_g);
                business.getOrganizationDirectory().createOrganization(txt_org.getText(), type_g);
                JOptionPane.showMessageDialog(null, "Organisation Created");
                txt_org.setText("");
                populateTable();
            //} 
            //else {
            //    JOptionPane.showMessageDialog(null, "Organization name already exists!");
            //}
                
            }
        
    
        }*/
       
       
        if ("".equals(txt_org.getText())) {
            JOptionPane.showMessageDialog(null, "Enter organization name!");
        } else {
            if (organisationDir.isUnique(txt_org.getText())) {
                for (Organization.Type type : Organization.Type.values()){
           
                    if(comboOrg.getSelectedItem().equals(type.getValue())){
                        Organization.Type type_g = type;
                        organisationDir.createOrganization(txt_org.getText(), type_g);
                        JOptionPane.showMessageDialog(null, "Organization Successfully Created");
                        txt_org.setText("");
                        populateTable();
                    } 
                }
            }
            else {
                   JOptionPane.showMessageDialog(null, "Organization name already exists!");
                 }

        }
        
        txt_org.setText("");
 
       
    }//GEN-LAST:event_btn_addenterpriseActionPerformed

    private void comboOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboOrgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboOrgActionPerformed

    private void delete_orgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_orgActionPerformed
        // TODO add your handling code here:
         DefaultTableModel model = (DefaultTableModel) tbl_org.getModel();
         int selectedrow = tbl_org.getSelectedRow();
         if(selectedrow < 0){
             JOptionPane.showMessageDialog(comboOrg, "Choose Organisation");
             return;
         }
         else{
             Organization org = (Organization) model.getValueAt(selectedrow, 1);
             organisationDir.deleteOrg(org);
             populateTable();
             JOptionPane.showMessageDialog(rightpanel, "Organisation Deleted");
         }
        
    }//GEN-LAST:event_delete_orgActionPerformed

    private void update_orgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_orgActionPerformed
        // TODO add your handling code here:
        
         DefaultTableModel model = (DefaultTableModel) tbl_org.getModel();
         int selectedrow = tbl_org.getSelectedRow();
         if(selectedrow < 0){
             JOptionPane.showMessageDialog(comboOrg, "Choose Organisation");
             return;
         }
         else{
        Organization org = (Organization) model.getValueAt(selectedrow, 1);
        
        UpdateOrg update = new UpdateOrg(business, userProcessContainer, network, 
                                enterprise,enterprise.getOrganizationDirectory(),org,rightpanel);
        userProcessContainer.add(update);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
             
             
         }
        
        
        
    }//GEN-LAST:event_update_orgActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addenterprise;
    private javax.swing.JComboBox<String> comboOrg;
    private javax.swing.JButton delete_org;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_org;
    private javax.swing.JTextField txt_org;
    private javax.swing.JButton update_org;
    // End of variables declaration//GEN-END:variables
}
