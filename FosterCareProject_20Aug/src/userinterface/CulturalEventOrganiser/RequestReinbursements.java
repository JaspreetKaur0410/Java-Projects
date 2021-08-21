/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CulturalEventOrganiser;

import Business.Child.ChildDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.ReinbursementsOrganisation;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.EventRequest;
import Business.WorkQueue.ReinbursementsWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import userinterface.Parent.ReinCheckStatus;

/**
 *
 * @author jaspr
 */
public class RequestReinbursements extends javax.swing.JPanel {

    /**
     * Creates new form RequestReinbursements
     */
    JPanel userProcessContainer;
    EcoSystem business;
    Organization organization;
    ChildDirectory childdir;
    EventRequest wrkreq;
    JPanel rightpanel1;
    UserAccount account;
    public RequestReinbursements(JPanel userProcessContainer,EcoSystem business,
                Organization organization,ChildDirectory childdir,EventRequest wrkreq,JPanel rightpanel1,UserAccount account) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.organization = organization;
        this.childdir = childdir;
        this.wrkreq = wrkreq;
        this.rightpanel1 = rightpanel1;
        this.account = account;
        
        populateData();
    }
    
    private void populateData(){
        
        LocalDateTime now = LocalDateTime.now();
        ZoneId defaultzoneid = ZoneId.systemDefault();
        ZonedDateTime zdt = now.atZone(defaultzoneid);
        Date to_Date_now = Date.from(zdt.toInstant());
        
        txt_eventdate.setText(String.valueOf(wrkreq.getEventdate()));
        txt_eventname.setText(wrkreq.getEventname());
        date.setText(String.valueOf(to_Date_now));
        
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_expenditure = new javax.swing.JTextField();
        txt_amount = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_note = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        txt_eventdate = new javax.swing.JTextField();
        txt_eventname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        btn_requuestrein = new javax.swing.JButton();
        back3 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 255, 0));

        jPanel2.setBackground(new java.awt.Color(153, 153, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Event Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Note");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Amount Requested");

        txt_note.setColumns(20);
        txt_note.setRows(5);
        jScrollPane1.setViewportView(txt_note);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Event Date");

        txt_eventdate.setEnabled(false);

        txt_eventname.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Expected Expenditure ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Requested Date");

        date.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_eventdate, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_expenditure, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_eventname, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_eventdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_eventname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_expenditure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(date, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        btn_requuestrein.setBackground(new java.awt.Color(51, 51, 51));
        btn_requuestrein.setText("Request To Reinbursements");
        btn_requuestrein.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_requuestreinActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(back3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addComponent(btn_requuestrein))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(682, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(back3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btn_requuestrein, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1385, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_requuestreinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_requuestreinActionPerformed
  
        LocalDateTime now = LocalDateTime.now();
        ZoneId defaultzoneid = ZoneId.systemDefault();
        ZonedDateTime zdt = now.atZone(defaultzoneid);
        Date to_Date_now = Date.from(zdt.toInstant());
        
        Double expen = 0.0;
        
        if(txt_amount.getText().isEmpty() || txt_note.getText().isEmpty()
                || txt_eventdate.getText().isEmpty() || txt_eventdate.getText().isEmpty()
                || txt_eventname.getText().isEmpty() || txt_expenditure.getText().isEmpty()){
            JOptionPane.showMessageDialog(txt_amount, "Please provide all details"); 
            return;
        }
        else{
            ReinbursementsWorkRequest rwr = new ReinbursementsWorkRequest();
            rwr.setStatus("Request Amount");
            rwr.setMessage("Request Amount");
            try{
              expen = Double.parseDouble(txt_expenditure.getText());
            }
            catch(Exception e){
               JOptionPane.showMessageDialog(txt_amount, "Enter correct expenditure");
            }
            rwr.setAmount(Double.parseDouble(txt_amount.getText()));
            rwr.setNote(txt_note.getText());
            rwr.setSender(account);
            
            rwr.setEventcategory(wrkreq.getEventcategory());
            rwr.setEventname(wrkreq.getEventname());
            rwr.setEventdate(wrkreq.getEventdate());
            rwr.setVenue(wrkreq.getVenue());
            rwr.setOrganisername(wrkreq.getOrganisername());
            rwr.setRequested(to_Date_now);
            
            Organization org = null;
                for (Network network : business.getNetworkList()) {
                    for (Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()) {
                        for (Organization organization : ent.getOrganizationDirectory().getOrganizationList()) {
                            if (organization instanceof ReinbursementsOrganisation) {

                                org = organization;
                                break;
                            }
                        }
                    }
                }

                if (org != null) {
                    org.getWorkQueue().getWorkRequestList().add(rwr);
                    business.getWorkQueue().getWorkRequestList().add(rwr);
                    account.getWorkQueue().getWorkRequestList().add(rwr);
                }
                else{
                    JOptionPane.showMessageDialog(txt_amount, "Add Organisation first");
                }
            
            JOptionPane.showMessageDialog(txt_amount, "Request Sent to Reinbursemensts");
            
            OrganiserManageReinJPanel panel = new 
           
            OrganiserManageReinJPanel(business, userProcessContainer,rightpanel1,childdir,account);
            rightpanel1.add(panel);
            CardLayout layout = (CardLayout) rightpanel1.getLayout();
            layout.next(rightpanel1);
        }

           

    }//GEN-LAST:event_btn_requuestreinActionPerformed

    private void back3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back3ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        //userProcessContainer.remove(this);
        //Component[] componentArray = rightpanel.getComponents();
        //SeeChildDetailsParentJPanel listofchildren = (SeeChildDetailsParentJPanel) component;
        //listofchildren.hiderequestrein();
        //CardLayout layout = (CardLayout) rightpanel.getLayout();
        //layout = (CardLayout) rightpanel.getLayout();
        //layout.previous(rightpanel);
    }//GEN-LAST:event_back3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back3;
    private javax.swing.JButton btn_requuestrein;
    private javax.swing.JTextField date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_amount;
    private javax.swing.JTextField txt_eventdate;
    private javax.swing.JTextField txt_eventname;
    private javax.swing.JTextField txt_expenditure;
    private javax.swing.JTextArea txt_note;
    // End of variables declaration//GEN-END:variables
}
