/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CulturalEventOrganiser;

import Business.Child.ChildDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseDirectory;
import Business.Network.Network;
import Business.Organization.BackgroundCheckOrganisation;
import Business.Organization.CulturalEventOrganisation;
import Business.Organization.CulturalEventOrganiser;
import Business.Organization.Organization;
import Business.Parent.ParentDirectory;
import Business.Role.CulturalEventManager;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.EventRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author jaspr
 */
public class OrganiseEventForml extends javax.swing.JPanel {

    /**
     * Creates new form OrganiseEventForml
     */
    JPanel userProcessContainer;
    EcoSystem business;
    Enterprise enterprise;
    Network network;
    UserAccount account;
    Organization organization;
    ChildDirectory childdir;
    ParentDirectory parentdir;
    EnterpriseDirectory enterpriseDirectory;
    JPanel rightpanel1;
    public OrganiseEventForml(JPanel userProcessContainer, UserAccount account,
            Network network, Organization organization, Enterprise enterprise, 
            EcoSystem business,ChildDirectory childdir,ParentDirectory parentdir, JPanel rightpanel1) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.business = business;
        this.network = network;
        this.organization = organization;
        this.childdir = childdir;
        this.parentdir = parentdir;
        this.rightpanel1 = rightpanel1;
        this.account = account;
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_organiser_name = new javax.swing.JTextField();
        txt_eventvenue = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        combo_evrntcategory = new javax.swing.JComboBox<>();
        txt_eventname = new javax.swing.JTextField();
        date_event = new com.toedter.calendar.JDateChooser();
        panel_sendrequest = new javax.swing.JPanel();
        btn_sendrequest = new javax.swing.JButton();

        jPanel5.setBackground(new java.awt.Color(204, 255, 0));

        jPanel6.setBackground(new java.awt.Color(153, 153, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Organiser Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Event Date");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Event Category");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Event Venue");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Event Name");

        combo_evrntcategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Dance and Music", "Educational", "Religious" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGap(68, 68, 68)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txt_eventvenue)
                        .addComponent(txt_eventname, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(combo_evrntcategory, javax.swing.GroupLayout.Alignment.LEADING, 0, 181, Short.MAX_VALUE)
                        .addComponent(txt_organiser_name, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(date_event, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(txt_organiser_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(combo_evrntcategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_eventname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_eventvenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(date_event, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(165, Short.MAX_VALUE))
        );

        panel_sendrequest.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_sendrequest.setText("Send Request to Manager");
        btn_sendrequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sendrequestActionPerformed(evt);
            }
        });
        panel_sendrequest.add(btn_sendrequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 13, 180, 30));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(panel_sendrequest, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(714, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_sendrequest, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1352, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 2, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 617, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_sendrequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sendrequestActionPerformed
        // TODO add your handling code here:
        if(txt_eventvenue.getText().isEmpty() || txt_organiser_name.getText().isEmpty()
                || txt_eventname.getText().isEmpty()){
            JOptionPane.showMessageDialog(date_event, "Please provide all details");
            return;
        }
        else if(combo_evrntcategory.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(date_event, "Please select category");
            return;
        }
        else if(date_event.getDate() == null){
            JOptionPane.showMessageDialog(date_event, "Please select Date");
            return;
        }
        else{
            EventRequest eventrequest = new EventRequest();
            eventrequest.setStatus("Event Requested");
            eventrequest.setMessage("Event Requested");
            eventrequest.setEventcategory(String.valueOf(combo_evrntcategory.getSelectedItem()));
            eventrequest.setEventname(txt_eventname.getText());
            eventrequest.setEventdate(date_event.getDate());
            eventrequest.setVenue(txt_eventname.getText());
            eventrequest.setOrganisername(txt_organiser_name.getText());   
            eventrequest.setSender(account);
            
            Organization org = null;
                for (Network network : business.getNetworkList()) {
                    for (Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()) {
                        for (Organization organization : ent.getOrganizationDirectory().getOrganizationList()) {
                            if (organization instanceof CulturalEventOrganisation) {

                                org = organization;
                                break;
                            }
                        }
                    }
                }

                if (org != null) {
                    org.getWorkQueue().getWorkRequestList().add(eventrequest);
                    account.getWorkQueue().getWorkRequestList().add(eventrequest);
                    business.getWorkQueue().getWorkRequestList().add(eventrequest);
                    JOptionPane.showMessageDialog(date_event, "Request sent to Manager");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Create Organisation");
                }
                
                OrganiserMAnageRequest omr = new OrganiserMAnageRequest
                                        (userProcessContainer,account,
                                        network, organization, enterprise, 
                                       business,childdir, parentdir,rightpanel1);
                rightpanel1.add(omr);
                CardLayout layout = (CardLayout) rightpanel1.getLayout();
                layout.next(rightpanel1);
            
            
        }     
    }//GEN-LAST:event_btn_sendrequestActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sendrequest;
    private javax.swing.JComboBox<String> combo_evrntcategory;
    private com.toedter.calendar.JDateChooser date_event;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel panel_sendrequest;
    private javax.swing.JTextField txt_eventname;
    private javax.swing.JTextField txt_eventvenue;
    private javax.swing.JTextField txt_organiser_name;
    // End of variables declaration//GEN-END:variables
}