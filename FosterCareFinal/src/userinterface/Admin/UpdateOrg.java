/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Admin;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author jaspr
 */
public class UpdateOrg extends javax.swing.JPanel {

    /**
     * Creates new form UpdateOrg
     */
    EcoSystem business;
    JPanel userProcessContainer;
    Network network; 
    Enterprise enterprise;
    OrganizationDirectory orgdir;
    Organization org;
    JPanel rightpanel;
    public UpdateOrg(EcoSystem business, JPanel userProcessContainer, Network network, 
                                Enterprise enterprise,OrganizationDirectory orgdir,
                            Organization org,JPanel rightpanel) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.business = business;
        this.network = network;
        this.org = org;
        this.orgdir = orgdir;
        this.rightpanel = rightpanel;
        
        txt_org.setText(org.toString());
        txt_type.setText(org.getType().getValue());
        
        bnt_sve.setEnabled(false);
        txt_org.setEnabled(false);
        txt_type.setEnabled(false);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_org = new javax.swing.JTextField();
        txt_type = new javax.swing.JTextField();
        update_org = new javax.swing.JButton();
        bnt_sve = new javax.swing.JButton();
        back3 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 661, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 671, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 0));

        jPanel3.setBackground(new java.awt.Color(153, 153, 0));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Organisation Type");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Organisation Name");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(61, 61, 61)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_org, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_type, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_org, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(88, Short.MAX_VALUE))
        );

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

        bnt_sve.setBackground(new java.awt.Color(51, 51, 51));
        bnt_sve.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bnt_sve.setForeground(new java.awt.Color(255, 255, 255));
        bnt_sve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save.png"))); // NOI18N
        bnt_sve.setText("Save Modification");
        bnt_sve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_sveActionPerformed(evt);
            }
        });

        back3.setBackground(new java.awt.Color(204, 255, 204));
        back3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        back3.setForeground(new java.awt.Color(51, 51, 51));
        back3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BackIcon.png"))); // NOI18N
        back3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(back3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(update_org)
                        .addGap(38, 38, 38)
                        .addComponent(bnt_sve)))
                .addContainerGap(987, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(back3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bnt_sve, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update_org, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(293, Short.MAX_VALUE))
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
                    .addContainerGap(977, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(38, Short.MAX_VALUE)))
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

    private void update_orgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_orgActionPerformed
        // TODO add your handling code here:
        
        bnt_sve.setEnabled(true);
        txt_org.setEnabled(true);
        txt_type.setEnabled(false);
    }//GEN-LAST:event_update_orgActionPerformed

    private void bnt_sveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_sveActionPerformed
        // TODO add your handling code here:
        
        for(Organization o:orgdir.getOrganizationList()){
            if(o.equals(org)){
                o.setName(txt_org.getText());
                o.setType(org.getType());
                JOptionPane.showMessageDialog(rightpanel, "Organisation Updated");
            }
        }
        
       
        
        
        
    }//GEN-LAST:event_bnt_sveActionPerformed

    private void back3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back3ActionPerformed
        // TODO add your handling code here:
        //userProcessContainer.remove(this);
        //CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        //layout.previous(userProcessContainer);
        userProcessContainer.remove(this);
        rightpanel.remove(this);
        Component[] componentArray = rightpanel.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ManageOrganisation panel = (ManageOrganisation) component;
        panel.populateTable();
        CardLayout layout = (CardLayout) rightpanel.getLayout();
        layout = (CardLayout) rightpanel.getLayout();
        layout.previous(rightpanel);
    }//GEN-LAST:event_back3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back3;
    private javax.swing.JButton bnt_sve;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txt_org;
    private javax.swing.JTextField txt_type;
    private javax.swing.JButton update_org;
    // End of variables declaration//GEN-END:variables
}
