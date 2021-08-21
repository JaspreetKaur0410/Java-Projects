/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Doctor;

import Business.Child.Child;
import Business.Child.ChildDirectory;
import Business.Child.ChildLabTests;
import Business.Child.ChildVitalSigns;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.LabWorkRequest;
import Business.WorkQueue.MedicalCheckRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jaspr
 */
public class DoctorSeeReportJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DoctorSeeReportJPanel
     */
    EcoSystem business;
    UserAccount account;
    JPanel userProcessContainer;
    Enterprise enterprise;
    Organization organization;
    ChildDirectory childdir;
    JPanel rightpanel1;
    Child childval;
    MedicalCheckRequest workRequest;
    SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yy");
    public DoctorSeeReportJPanel(EcoSystem business,UserAccount account,JPanel userProcessContainer,
                                Enterprise enterprise,
                                Organization organization,ChildDirectory childdir,
                                JPanel rightpanel1,Child childval,MedicalCheckRequest workRequest) {
        initComponents();
        
        this.business = business;
        this.account = account;
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.organization = organization;
        this.childdir = childdir;
        this.rightpanel1 = rightpanel1;
        this.childval = childval;
        this.workRequest = workRequest;
        
        populatechilddata();
        populateTables();
        
        
        checkTestTypes();
        
        if(childval.getLabtestlist()!=null){
            populatechilddata();
            populateTables();
        }
        if(childval.getVitallist() != null){
            panel_vitals.setVisible(true);
            tbl_vitalsigns.setVisible(true);
            populateVitalSignsTable();    
        }
    }
    
    
    public void populateVitalSignsTable(){
    
        DefaultTableModel model = (DefaultTableModel) tbl_vitalsigns.getModel();
        model.setRowCount(0);
        //JOptionPane.showMessageDialog(rightpanel1, childval.getVitallist());
        for(ChildVitalSigns c:childval.getVitallist()){
            if(childval.getVitallist() != null){
                
                Object[] row = new Object[model.getColumnCount()];
                Date myDate = c.getVitalSignsDate();
                String datetime = dateformat.format(myDate);
                row[0] = datetime;
                row[1] = c.getWeight();
                row[2] = c.getPulseRate();
                row[3] = c.getBodytemp();
                row[4] = c.getRespirationRate();
                row[5] = c.getBP();
                if(c.isIsVitalSignsNormal() == true){
                   row[6] = "NORMAL";            
                }
                if(c.isIsVitalSignsNormal() == false){
                   row[6] = "NOT NORMAL";  
                }
                
                model.addRow(row);
            }
        }
    }
    
    
    public void checkTestTypes(){
        if(childval.getLabtestlist() == null){
            panel_tbl_blood.setVisible(false);
            tbl_blood.setVisible(false);
            panel_tbl_urine.setVisible(false);
            tbl_urine.setVisible(false);
        }
        
        else if(childval.getLabtestlist()!=null){
            for(ChildLabTests clt:childval.getLabtestlist()){
                if(clt.isIs_bloodTestRequired() && !clt.isIs_urineTestRequired()){
                    JOptionPane.showMessageDialog(rightpanel1, "hello1");
                    panel_tbl_blood.setVisible(true);
                    tbl_blood.setVisible(true);
                    panel_tbl_urine.setVisible(false);
                    tbl_urine.setVisible(false);
                }
                else if(clt.isIs_urineTestRequired() && !clt.isIs_bloodTestRequired())
                {
                    JOptionPane.showMessageDialog(rightpanel1, "hello2");
                    panel_tbl_urine.setVisible(true);
                    tbl_urine.setVisible(true);
                    panel_tbl_blood.setVisible(false);
                    tbl_blood.setVisible(false);
                }
                else if(clt.isIs_urineTestRequired() && clt.isIs_bloodTestRequired()){
                    JOptionPane.showMessageDialog(rightpanel1, "hello3");
                    panel_tbl_urine.setVisible(true);
                    tbl_urine.setVisible(true);
                    panel_tbl_blood.setVisible(true);
                    tbl_blood.setVisible(true);
                }
                
            }

        }
        
    }
    
    public void populateTables(){
        
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yy");
        
        DefaultTableModel model_urine = (DefaultTableModel) tbl_urine.getModel();
        DefaultTableModel model_blood = (DefaultTableModel) tbl_blood.getModel();
        model_urine.setRowCount(0);
        model_blood.setRowCount(0);
        
        
        for(ChildLabTests clt:childval.getLabtestlist()){
            if(childval.getLabtestlist()!=null){
                
                if(clt.isIs_bloodTestRequired() && !clt.isIs_urineTestRequired()){
            
                    Object[] row_blood = new Object[model_blood.getColumnCount()];
                    
                    Date myDate = clt.getLabtestdate();
                    String datetime = dateformat.format(myDate);
                    row_blood[0] = datetime;
                    
                    row_blood[1] = "Blood Test";
                    row_blood[2] = clt.getBloodcount();
                    row_blood[3] = clt.getGlucose();
                    row_blood[4] = clt.getCholestrol();
                    row_blood[5] = clt.getHdl();
                    row_blood[6] = clt.getLdl();
                    if(clt.isIsBloodTestNormal()){
                        row_blood[7] = "NORMAL";
                    }
                    else{
                        row_blood[7] = "NOT NORMAL";
                    }   
                    model_blood.addRow(row_blood);
                }
                if(clt.isIs_urineTestRequired() && !clt.isIs_bloodTestRequired()){
 
                    Object[] row_urine = new Object[model_urine.getColumnCount()];
                    if(clt.isIsUrineTestNormal()){
                        Date myDate = clt.getLabtestdate();
                        String datetime = dateformat.format(myDate);
                        row_urine[0] = datetime;
                        row_urine[1] = "Urine Test";
                        row_urine[2] = clt.getDopamine();
                        row_urine[3] = clt.getMetanephrine();
                        if(clt.isIsUrineTestNormal()){
                            row_urine[4] = "Normal";
                        }
                        else{
                            row_urine[4] = "Not Normal";
                        }
                    }
                    model_urine.addRow(row_urine);
                }
                if(clt.isIs_bloodTestRequired() && clt.isIs_urineTestRequired()){
                    //panel_blood.setVisible(true);
                    //tbl_blood.setVisible(true);
                    //panel_urine.setVisible(true);
                    //tbl_urine.setVisible(true);
                    Object[] row_blood = new Object[model_blood.getColumnCount()];
                    Date myDate = clt.getLabtestdate();
                    String datetime = dateformat.format(myDate);
                    row_blood[0] = datetime;
                    row_blood[1] = "Blood Test";
                    row_blood[2] = clt.getBloodcount();
                    row_blood[3] = clt.getGlucose();
                    row_blood[4] = clt.getCholestrol();
                    row_blood[5] = clt.getHdl();
                    row_blood[6] = clt.getLdl();
                    if(clt.isIsBloodTestNormal()){
                        row_blood[7] = "NORMAL";
                    }
                    else{
                        row_blood[7] = "NOT NORMAL";
                    }   
                    model_blood.addRow(row_blood);
                    
                    Object[] row_urine = new Object[model_urine.getColumnCount()];
                    tbl_urine.setVisible(true);
                    Date myDate_urine = clt.getLabtestdate();
                    String datetime_urine = dateformat.format(myDate_urine);
                    row_urine[0] = datetime_urine;
                    row_urine[1] = "Urine Test";
                    row_urine[2] = clt.getDopamine();
                    row_urine[3] = clt.getMetanephrine();
                    if(clt.isIsUrineTestNormal()){
                        row_urine[4] = "Normal";
                    }
                    else{
                        row_urine[4] = "Not Normal";
                    }
                    
                    model_urine.addRow(row_urine);
                    
                }
            }
        }
    }
    
    public void populatechilddata(){
        txt_agency.setText(childval.getOrg().toString());
        txt_firstname.setText(childval.getFirstname());
        txt_lastname.setText(childval.getLastname());
        txt_gender.setText(childval.getGender());
        txt_city.setText(childval.getCity());
        txt_age.setText(String.valueOf(childval.getAge()));
        txt_about.setText(childval.getAbout_child());
        txt_message.setText((workRequest.getMessage()));
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
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        panel_singleparent = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txt_city = new javax.swing.JTextField();
        txt_lastname = new javax.swing.JTextField();
        txt_gender = new javax.swing.JTextField();
        txt_age = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        txt_firstname = new javax.swing.JTextField();
        txt_agency = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        txt_message = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        txt_about = new javax.swing.JTextField();
        back = new javax.swing.JButton();
        panel_tbl_blood = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_blood = new javax.swing.JTable();
        panel_tbl_urine = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_urine = new javax.swing.JTable();
        panel_vitals = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_vitalsigns = new javax.swing.JTable();

        jPanel5.setBackground(new java.awt.Color(204, 255, 0));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel28.setText("PERSONAL INFORMATION");
        jPanel2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 242, -1));

        panel_singleparent.setBackground(new java.awt.Color(204, 255, 204));
        panel_singleparent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel49.setText("Gender");
        panel_singleparent.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel54.setText("Last Name");
        panel_singleparent.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel35.setText("City");
        panel_singleparent.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel36.setText("Age");
        panel_singleparent.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));
        panel_singleparent.add(txt_city, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 130, -1));
        panel_singleparent.add(txt_lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 130, -1));
        panel_singleparent.add(txt_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 130, -1));
        panel_singleparent.add(txt_age, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 130, -1));

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel59.setText("First Name");
        panel_singleparent.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));
        panel_singleparent.add(txt_firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 130, -1));

        jPanel2.add(panel_singleparent, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 240, 240));

        txt_agency.setBackground(new java.awt.Color(102, 102, 102));
        txt_agency.setForeground(new java.awt.Color(255, 255, 255));
        txt_agency.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txt_agency.setEnabled(false);
        jPanel2.add(txt_agency, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 100, -1));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel40.setText("Organisation");
        jPanel2.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 80, -1));

        jPanel6.setBackground(new java.awt.Color(204, 255, 204));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel57.setText("Message from Organisation");
        jPanel6.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));
        jPanel6.add(txt_message, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 180, 60));

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel58.setText("ABOUT THE CHILD");
        jPanel6.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));
        jPanel6.add(txt_about, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 160, 60));

        back.setBackground(new java.awt.Color(204, 255, 204));
        back.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        back.setForeground(new java.awt.Color(51, 51, 51));
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BackIcon.png"))); // NOI18N
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(428, Short.MAX_VALUE))
        );

        panel_tbl_blood.setBackground(new java.awt.Color(204, 255, 204));
        panel_tbl_blood.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel62.setText("BLOOD TEST REPORT");
        panel_tbl_blood.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, -1));

        tbl_blood.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Date", "Test Type", "BloodCount", "Glucose", "Cholestrol", "HDl", "LDL", "Satus"
            }
        ));
        jScrollPane2.setViewportView(tbl_blood);

        panel_tbl_blood.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 790, 90));

        panel_tbl_urine.setBackground(new java.awt.Color(204, 255, 204));
        panel_tbl_urine.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel73.setText("URINE TEST REPORT");
        panel_tbl_urine.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        tbl_urine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Date", "Test Type", "Dopamine", "Metaphrine", "Satus"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_urine);

        panel_tbl_urine.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 780, 90));

        panel_vitals.setBackground(new java.awt.Color(204, 255, 204));
        panel_vitals.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel63.setText("VITAL SIGNS REPORT ");
        panel_vitals.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        tbl_vitalsigns.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Date", "Weight", "PulseRate", "Temp", "BreathingRate", "BP", "Status"
            }
        ));
        jScrollPane3.setViewportView(tbl_vitalsigns);

        panel_vitals.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 810, 110));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_tbl_blood, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_tbl_urine, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(166, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(296, 296, 296)
                    .addComponent(panel_vitals, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(160, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(panel_tbl_urine, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel_tbl_blood, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(430, 430, 430)
                    .addComponent(panel_vitals, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addGap(430, 430, 430)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panel_singleparent;
    private javax.swing.JPanel panel_tbl_blood;
    private javax.swing.JPanel panel_tbl_urine;
    private javax.swing.JPanel panel_vitals;
    private javax.swing.JTable tbl_blood;
    private javax.swing.JTable tbl_urine;
    private javax.swing.JTable tbl_vitalsigns;
    private javax.swing.JTextField txt_about;
    private javax.swing.JTextField txt_age;
    private javax.swing.JTextField txt_agency;
    private javax.swing.JTextField txt_city;
    private javax.swing.JTextField txt_firstname;
    private javax.swing.JTextField txt_gender;
    private javax.swing.JTextField txt_lastname;
    private javax.swing.JTextField txt_message;
    // End of variables declaration//GEN-END:variables
}
