/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Doctor;

import Business.Child.Child;
import Business.Child.ChildDirectory;
import Business.Child.ChildLabTests;
import Business.Child.ChildPrescriptions;
import Business.Child.ChildVitalSigns;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import static Business.Organization.Organization.Type.LabOrganisation;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.LabWorkRequest;
import Business.WorkQueue.MedicalCheckRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import Business.Organization.LabOrganisation;
import Business.Organization.PharmaOrganisation;
import Business.WorkQueue.PharmacyWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author jaspr
 */
public class DoctorCheckupJPanel extends javax.swing.JPanel{

    /**
     * Creates new form DoctorCheckupJPanel
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
    public DoctorCheckupJPanel(EcoSystem business,UserAccount account,JPanel userProcessContainer,
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
        
      
        lbl_underprocess.setVisible(false);
        panel_labseereport.setVisible(false);
        btn_labseereport.setVisible(false);
        
        panel_medication.setVisible(false);
        panel_prescribe.setVisible(false);
        btn_prescribe.setVisible(false);
        panel_prescriptions.setVisible(false);
        tbl_prescriptions.setVisible(false);
        btn_labseereport.setVisible(false);
        lbl_requestanother.setVisible(false);
   
        populatechilddata();
        if(childval.getVitallist() != null){
            populateVitalSignsTable();
        }
        
        checkMedicationStatus();
        
        checklabstatus();
        //JOptionPane.showMessageDialog(rightpanel1, childval.getPrescriptionslist());
        if(childval.getPrescriptionslist() != null){
            panel_prescriptions.setVisible(true);
            tbl_prescriptions.setVisible(true);
            populatePrescriptionTable();
        }
        
    }
    
   
    private void populatePrescriptionTable(){
            
        DefaultTableModel model = (DefaultTableModel) tbl_prescriptions.getModel();
        model.setRowCount(0);
        for(ChildPrescriptions cp:childval.getPrescriptionslist()){
            //JOptionPane.showMessageDialog(rightpanel1, cp.getPrescription());
            Object[] row = new Object[model.getColumnCount()];
            Date myDate = cp.getPrescriptiondate();
            String datetime = dateformat.format(myDate);
            row[0] = datetime; 
            row[1] = cp.getPrescription();
            model.addRow(row);
        }
    }
    
    
    private void checkMedicationStatus(){
        for(ChildLabTests clt:childval.getLabtestlist()){
            if(clt.isIs_bloodTestRequired() && !clt.isIs_urineTestRequired()){
                if(clt.isIsBloodTestNormal()){
                    panel_medication.setVisible(false);
                }
                else{
                    //panel_medication.setVisible(true);
                    panel_medication.setVisible(true);
                    panel_prescribe.setVisible(true);
                    btn_prescribe.setVisible(true);
                    
                }
            }
            else if(!clt.isIs_bloodTestRequired() && clt.isIs_urineTestRequired()){
                if(clt.isIsUrineTestNormal()){
                    panel_medication.setVisible(false);
                }
                else{
                    //panel_medication.setVisible(true);
                    panel_medication.setVisible(true);
                    panel_prescribe.setVisible(true);
                    btn_prescribe.setVisible(true);
                }
                
            }
            else if(clt.isIs_bloodTestRequired() && clt.isIs_urineTestRequired()){
                if(clt.isIsBloodTestNormal() && clt.isIsUrineTestNormal()){
                    panel_medication.setVisible(false);
                }
                else{
                    //panel_medication.setVisible(true);
                    panel_medication.setVisible(true);
                    panel_prescribe.setVisible(true);
                    btn_prescribe.setVisible(true);
                }
            }
        }
    }
    
    public void checklabstatus(){
        if(workRequest.getStatus().equals("Lab Test Requested")){
            lbl_done.setVisible(false);
            lbl_requestanother.setVisible(true);
            lbl_underprocess.setVisible(true);
            lbl_test.setVisible(false);
            check_blood.setVisible(false);
            check_urine.setVisible(false);
            btn_requestlab.setVisible(false);
            panel_requestlab.setVisible(false);
            lbl_done.setVisible(false);
            
            //lbl_stats.setVisible(true);
            panel_requestlab.setVisible(false);
            panel_labseereport.setVisible(false);
            btn_labseereport.setVisible(false);
            lbl_requestanother.setVisible(false);
           
        }
        else if(workRequest.getStatus().equals("LabTest Done")){
            lbl_done.setVisible(true);
            lbl_test.setVisible(false);
            check_blood.setVisible(false);
            check_urine.setVisible(false);
            
            lbl_test.setVisible(true);
            check_blood.setVisible(true);
            check_urine.setVisible(true);
            
            lbl_requestanother.setVisible(true);
            lbl_underprocess.setVisible(false);
            lbl_done.setVisible(true);
            
           
            
            btn_requestlab.setVisible(true);
            panel_requestlab.setVisible(true);
            lbl_requestanother.setVisible(true);
            
            panel_labseereport.setVisible(true);
            btn_labseereport.setVisible(true);
           
        }
        else if(workRequest.getStatus().equals("Medical Check Processing")){
   
            lbl_requestanother.setVisible(false);
            lbl_underprocess.setVisible(false);
            lbl_done.setVisible(false);
            
            lbl_test.setVisible(true);
            check_blood.setVisible(true);
            check_urine.setVisible(true);
            
            btn_requestlab.setVisible(true);
            panel_requestlab.setVisible(true);
            
            if(childval.getLabtestlist()!=null){
                panel_labseereport.setVisible(true);
                btn_labseereport.setVisible(true);
            }
            
        }
        else if(workRequest.getStatus().equals("Medication Provided")){
            lbl_requestanother.setVisible(false);
            lbl_underprocess.setVisible(false);
            lbl_done.setVisible(false);
            
            lbl_test.setVisible(true);
            check_blood.setVisible(true);
            check_urine.setVisible(true);
            
            btn_requestlab.setVisible(true);
            panel_requestlab.setVisible(true);
            
            if(childval.getLabtestlist()!=null){
                panel_labseereport.setVisible(true);
                btn_labseereport.setVisible(true);
            }
            
            childval.setIsLabTestNormal(true);
        }
    }
    
    public void changeTablecolor(){
       //tbl_vitalsigns.getDefaultRenderer(columnClass)
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
                   //tbl_vitalsigns.getColumn(6).setCellRenderer(new ImageRenderer());
                }
                if(c.isIsVitalSignsNormal() == false){
                   row[6] = "NOT NORMAL";  

                }
                
                model.addRow(row);
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
        txt_about1.setText(childval.getAbout_child());
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
        panel_seeReport = new javax.swing.JPanel();
        btn_seereport = new javax.swing.JButton();
        panel_savevitals = new javax.swing.JPanel();
        btn_svaevitals = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        txt_breathing = new javax.swing.JTextField();
        txt_bp = new javax.swing.JTextField();
        txt_temp = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        jLabel45 = new javax.swing.JLabel();
        txt_pulse = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txt_weight = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        panel_singleparent = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txt_city = new javax.swing.JTextField();
        txt_firstname = new javax.swing.JTextField();
        txt_lastname = new javax.swing.JTextField();
        txt_gender = new javax.swing.JTextField();
        txt_age = new javax.swing.JTextField();
        txt_agency = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        txt_message = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        txt_about1 = new javax.swing.JTextField();
        lab_testunder = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        check_urine = new javax.swing.JCheckBox();
        check_blood = new javax.swing.JCheckBox();
        lbl_test = new javax.swing.JLabel();
        lbl_requestanother = new javax.swing.JLabel();
        lbl_underprocess = new javax.swing.JLabel();
        lbl_done = new javax.swing.JLabel();
        panel_requestlab = new javax.swing.JPanel();
        btn_requestlab = new javax.swing.JButton();
        lbl_labtest1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_vitalsigns = new javax.swing.JTable();
        panel_medication = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        panel_prescribe = new javax.swing.JPanel();
        btn_prescribe = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        txt_prescription = new javax.swing.JTextField();
        panel_prescriptions = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_prescriptions = new javax.swing.JTable();
        panel_labseereport = new javax.swing.JPanel();
        btn_labseereport = new javax.swing.JButton();
        back = new javax.swing.JButton();

        jPanel5.setBackground(new java.awt.Color(204, 255, 0));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_seeReport.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_seereport.setBackground(new java.awt.Color(102, 102, 102));
        btn_seereport.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_seereport.setForeground(new java.awt.Color(255, 255, 255));
        btn_seereport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/seedetials.png"))); // NOI18N
        btn_seereport.setText("See Vitals  Report");
        btn_seereport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_seereportActionPerformed(evt);
            }
        });
        panel_seeReport.add(btn_seereport, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 40));

        jPanel5.add(panel_seeReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, 190, 43));

        panel_savevitals.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_svaevitals.setBackground(new java.awt.Color(102, 102, 102));
        btn_svaevitals.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_svaevitals.setForeground(new java.awt.Color(255, 255, 255));
        btn_svaevitals.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save.png"))); // NOI18N
        btn_svaevitals.setText("Save Vitals");
        btn_svaevitals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_svaevitalsActionPerformed(evt);
            }
        });
        panel_savevitals.add(btn_svaevitals, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 40));

        jPanel5.add(panel_savevitals, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, 160, 40));

        jPanel7.setBackground(new java.awt.Color(204, 255, 204));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel59.setText("VITAL SIGNS");
        jPanel7.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel42.setText("Blood Pressure");
        jPanel7.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel43.setText("Body Temperature");
        jPanel7.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));
        jPanel7.add(txt_breathing, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 130, -1));

        txt_bp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bpActionPerformed(evt);
            }
        });
        jPanel7.add(txt_bp, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 130, -1));
        jPanel7.add(txt_temp, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 130, -1));

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel44.setText("Breathing rate");
        jPanel7.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));
        jPanel7.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 160, -1));

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel45.setText("Pulse Rate");
        jPanel7.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));
        jPanel7.add(txt_pulse, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 130, -1));

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel53.setText("Date");
        jPanel7.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel46.setText("Weight");
        jPanel7.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));
        jPanel7.add(txt_weight, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 130, -1));

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 39, 370, 310));

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

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel56.setText("First Name");
        panel_singleparent.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel36.setText("Age");
        panel_singleparent.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));
        panel_singleparent.add(txt_city, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 130, -1));
        panel_singleparent.add(txt_firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 130, -1));
        panel_singleparent.add(txt_lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 130, -1));
        panel_singleparent.add(txt_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 130, -1));
        panel_singleparent.add(txt_age, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 130, -1));

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
        jPanel6.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));
        jPanel6.add(txt_message, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 180, 60));

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel58.setText("ABOUT THE CHILD");
        jPanel6.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));
        jPanel6.add(txt_about1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 160, 60));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 39, 270, 650));

        lab_testunder.setBackground(new java.awt.Color(204, 255, 204));
        lab_testunder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel61.setText("LAB TEST");
        lab_testunder.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        check_urine.setText("Urine Test");
        lab_testunder.add(check_urine, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, -1));

        check_blood.setText("Blood Test");
        lab_testunder.add(check_blood, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, -1));

        lbl_test.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_test.setText("Test Required");
        lab_testunder.add(lbl_test, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        lbl_requestanother.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_requestanother.setForeground(new java.awt.Color(51, 51, 255));
        lbl_requestanother.setText("Request Another Lab Test");
        lab_testunder.add(lbl_requestanother, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        lbl_underprocess.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_underprocess.setText("UNDER PROCESS");
        lab_testunder.add(lbl_underprocess, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 210, -1));

        lbl_done.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_done.setText("DONE");
        lab_testunder.add(lbl_done, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 70, -1));

        panel_requestlab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_requestlab.setBackground(new java.awt.Color(153, 153, 153));
        btn_requestlab.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_requestlab.setForeground(new java.awt.Color(255, 255, 255));
        btn_requestlab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/send.png"))); // NOI18N
        btn_requestlab.setText("Send for Test");
        btn_requestlab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_requestlabActionPerformed(evt);
            }
        });
        panel_requestlab.add(btn_requestlab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 40));

        lab_testunder.add(panel_requestlab, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 140, 40));

        lbl_labtest1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_labtest1.setText("LAB TEST ");
        lab_testunder.add(lbl_labtest1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jPanel5.add(lab_testunder, new org.netbeans.lib.awtextra.AbsoluteConstraints(658, 43, 263, 310));

        jPanel10.setBackground(new java.awt.Color(204, 255, 204));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel62.setText("VITAL SIGNS REPORT ");
        jPanel10.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

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
        jScrollPane1.setViewportView(tbl_vitalsigns);

        jPanel10.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 650, 110));

        jPanel5.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, 650, 171));

        panel_medication.setBackground(new java.awt.Color(204, 255, 204));
        panel_medication.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel63.setText("MEDICATION");
        panel_medication.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        panel_prescribe.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_prescribe.setBackground(new java.awt.Color(153, 153, 153));
        btn_prescribe.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_prescribe.setForeground(new java.awt.Color(255, 255, 255));
        btn_prescribe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/medicalcheck.png"))); // NOI18N
        btn_prescribe.setText("Prescribe");
        btn_prescribe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prescribeActionPerformed(evt);
            }
        });
        panel_prescribe.add(btn_prescribe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 40));

        panel_medication.add(panel_prescribe, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 140, 40));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel41.setText("Prescriptions");
        panel_medication.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));
        panel_medication.add(txt_prescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 220, 80));

        jPanel5.add(panel_medication, new org.netbeans.lib.awtextra.AbsoluteConstraints(927, 43, 244, 310));

        panel_prescriptions.setBackground(new java.awt.Color(204, 255, 204));
        panel_prescriptions.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel64.setText(" PRESCRIPTIONS REPORT");
        panel_prescriptions.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        tbl_prescriptions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Date", "Prescriptions"
            }
        ));
        jScrollPane2.setViewportView(tbl_prescriptions);

        panel_prescriptions.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 310, 100));

        jPanel5.add(panel_prescriptions, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 436, 310, 160));

        panel_labseereport.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_labseereport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/seedetials.png"))); // NOI18N
        btn_labseereport.setText("See Full Report");
        btn_labseereport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_labseereportActionPerformed(evt);
            }
        });
        panel_labseereport.add(btn_labseereport, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 40));

        jPanel5.add(panel_labseereport, new org.netbeans.lib.awtextra.AbsoluteConstraints(684, 360, 200, 40));

        back.setBackground(new java.awt.Color(204, 255, 204));
        back.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        back.setForeground(new java.awt.Color(51, 51, 51));
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BackIcon.png"))); // NOI18N
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel5.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 33, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_svaevitalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_svaevitalsActionPerformed
        // TODO add your handling code here:
        
        
        //CONVERT LOCAL DATE TO DATE
        LocalDateTime now = LocalDateTime.now();
        ZoneId defaultzoneid = ZoneId.systemDefault();
        ZonedDateTime zdt = now.atZone(defaultzoneid);
        Date to_Date_now = Date.from(zdt.toInstant());
        
        
        Double temperature;
        int breathing;
        int pulse;
        int bp;
        double weight;
        Date vitalsignsdate;
        
         if (txt_bp.getText().isEmpty() || txt_breathing.getText().isEmpty() || 
                    txt_temp.getText().isEmpty() || txt_weight.getText().isEmpty() || 
                    date.getDate() == null ) {
            JOptionPane.showMessageDialog(null, "Vital Signs cannot be empty");
            return;
        } 
         else{
             try{
                temperature = Double.parseDouble(txt_temp.getText());
                if(temperature < 0){
                    JOptionPane.showMessageDialog(rightpanel1, "Enter correct temperature");
                    return;
                }
             }
             catch(Exception e){
                 JOptionPane.showMessageDialog(rightpanel1, "Enter correct temperature");
                 return;
         }
             try{
                weight = Double.parseDouble(txt_weight.getText());
                if(weight < 0){
                    JOptionPane.showMessageDialog(rightpanel1, "Enter correct weight");
                    return;
                }
             }
             catch(Exception e){
                 JOptionPane.showMessageDialog(rightpanel1, "Enter correct weight");
                 return;
             }
         
             try{
                breathing = Integer.parseInt(txt_breathing.getText());
                if(breathing < 0){
                    JOptionPane.showMessageDialog(rightpanel1, "Enter breathing rate");
                    return;
                }
             }
             catch(Exception e){
                 JOptionPane.showMessageDialog(rightpanel1, "Enter correct breathing rate");
                 return;
             }
             try{
                bp = Integer.parseInt(txt_bp.getText());
                if(bp < 0){
                    JOptionPane.showMessageDialog(rightpanel1, "Enter correct breathing rate");
                    return;
                }
             }
             catch(Exception e){
                 JOptionPane.showMessageDialog(rightpanel1, "Enter correct breathing rate");
                 return;
             }
             try{
                pulse = Integer.parseInt(txt_pulse.getText());
                if(pulse < 0){
                    JOptionPane.showMessageDialog(rightpanel1, "Enter correct pulse rate");
                    return;
                }
             }
             catch(Exception e){
                 JOptionPane.showMessageDialog(rightpanel1, "Enter correct pulse rate");
                 return;
             }
             try{
                vitalsignsdate = date.getDate();
                if(vitalsignsdate.before(to_Date_now)){
                    JOptionPane.showMessageDialog(rightpanel1, "Enter correct date");
                    return;
                }
             }
             catch(Exception e){
                 JOptionPane.showMessageDialog(rightpanel1, "Enter correct date");
                 return;
             }
            
            int age = Integer.parseInt(txt_age.getText());
            String weight1 = String.valueOf(txt_weight.getText());
            String temp1 = String.valueOf(txt_temp.getText());
            String pulse1 = String.valueOf(txt_pulse.getText());
            String bp1 = String.valueOf(txt_bp.getText());
            String breathing1 = String.valueOf(txt_breathing.getText());
            Date vitalsignsdate1 = date.getDate();
            
            
            for(Child c1:business.getChildDirectory().getChildlist()){
                if(c1.getUsername().equals(childval.getUsername())){
                    ChildVitalSigns c = c1.addVitalSign();
                    c.setBodytemp(temperature);
                    c.setPulseRate(pulse);
                    c.setRespirationRate(breathing);
                    c.setBP(bp);
                    c.setWeight(weight);
                    c.setVitalSignsDate(vitalsignsdate);
                    
                    
                    if(age >= 0 && age < 1){
                            if(c.getWeight() >=9 && c.getWeight() <= 22){
                                c.setIsWeightNormal(true);
                            }
                            else{
                               c.setIsWeightNormal(false);
                            }
                        }
                        if(age >= 1 && age < 3){
                            if(c.getWeight() >=22 && c.getWeight() <= 31){
                                c.setIsWeightNormal(true);
                            }
                            else{
                                c.setIsWeightNormal(false);
                            }
                        }
                        if(age >= 3 && age <= 5){
                            if(c.getWeight() >=31 && c.getWeight() <= 40){
                                c.setIsWeightNormal(true);
                            }
                            else{
                               c.setIsWeightNormal(false);
                            }
                        }
                         if(age >= 6 && age <= 12){
                            if(c.getWeight() >=41 && c.getWeight() <= 92){
                                c.setIsWeightNormal(true);
                            }
                            else{
                                c.setIsWeightNormal(false);
                            }
                        }


                         if(age >= 0 && age < 1){
                            if(c.getPulseRate()>=80 && c.getPulseRate() <= 180){
                                c.setIspulserateNormal(true);
                            }
                            else{
                               c.setIspulserateNormal(false);
                            }
                        }
                         if(age >= 1 && age < 3){
                            if(c.getPulseRate()>=80 && c.getPulseRate() <= 160){
                                c.setIspulserateNormal(true);
                            }
                            else{
                               c.setIspulserateNormal(false);
                            }
                        }
                         if(age >= 3 && age <= 5){
                            if(c.getPulseRate()>=80 && c.getPulseRate() <= 110){
                                c.setIspulserateNormal(true);
                            }
                            else{
                                c.setIspulserateNormal(false);
                            }
                        }

                        if(age >= 6 && age <= 12){
                            if(c.getPulseRate()>=75 && c.getPulseRate() <= 110){
                                c.setIspulserateNormal(true);
                            }
                            else{
                               c.setIspulserateNormal(false);
                            }
                        }


                        if(age >= 0 && age < 1){
                            if(c.getBP()>=50 && c.getBP() <= 100){
                                c.setIsBpNormal(true);
                            }
                            else{
                                c.setIsBpNormal(false);
                            }
                        }

                        if(age >= 1 && age <= 5){
                            if(c.getBP()>=80 && c.getBP() <= 110){
                                c.setIsBpNormal(true);
                            }
                            else{
                               c.setIsBpNormal(false);
                            }
                        }

                        if(age >= 6 && age <= 12){
                            if(c.getBP()>=80 && c.getBP() <= 120){
                                c.setIsBpNormal(true);
                            }
                            else{
                                c.setIsBpNormal(false);
                            }
                        }

                        if(age >= 0 && age < 1){
                            if(c.getBodytemp()>=98 && c.getBodytemp() <= 100){
                                c.setIstempNormal(true);
                            }
                            else{
                                c.setIstempNormal(false);
                            }
                        }

                        if(age >= 1 && age <= 3){
                            if(c.getBodytemp()>=96.8 && c.getBodytemp() <= 99.6){
                                 c.setIstempNormal(true);
                            }
                            else{
                                c.setIstempNormal(false);
                            }
                        }
                        if(age >= 4 && age <= 12){
                            if(c.getBodytemp()==98.6){
                                c.setIstempNormal(true);
                            }
                            else{
                               c.setIstempNormal(false);
                            }
                        }

                       if(age >= 0 && age < 1){
                            if(c.getRespirationRate()>=20 && c.getBodytemp() <= 50){
                                c.setIsBreathingRateNorma(true);
                            }
                            else{
                                c.setIsBreathingRateNorma(false);
                            }
                        }

                       if(age >= 1 && age < 5){
                            if(c.getRespirationRate()>=20 && c.getRespirationRate()<= 30){
                               c.setIsBreathingRateNorma(true);
                            }
                            else{
                                c.setIsBreathingRateNorma(false);
                            }
                        }

                       if(age >= 6 && age < 12){
                            if(c.getRespirationRate()>=20 && c.getRespirationRate()<= 30){
                               c.setIsBreathingRateNorma(true);
                            }
                            else{
                                c.setIsBreathingRateNorma(false);
                            }
                        }
                       
                       if(c.isIsBpNormal() == true && c.isIsBreathingRateNorma()== true && c.isIsWeightNormal()== true &&
                               c.isIspulserateNormal()== true && c.isIstempNormal()== true){
                           c.setIsVitalSignsNormal(true);
                           c1.setIsVitalSignNormal(true);
                       }

                }
            }
            
            for(Child c1:childval.getOrg().getChildDirectory().getChildlist()){
                if(c1.getUsername().equals(childval.getUsername())){
                    ChildVitalSigns c = c1.addVitalSign();
                    c.setBodytemp(temperature);
                    c.setPulseRate(pulse);
                    c.setRespirationRate(breathing);
                    c.setBP(bp);
                    c.setWeight(weight);
                    c.setVitalSignsDate(vitalsignsdate);
                    
                    
                    if(age >= 0 && age < 1){
                            if(c.getWeight() >=9 && c.getWeight() <= 22){
                                c.setIsWeightNormal(true);
                            }
                            else{
                               c.setIsWeightNormal(false);
                            }
                        }
                        if(age >= 1 && age < 3){
                            if(c.getWeight() >=22 && c.getWeight() <= 31){
                                c.setIsWeightNormal(true);
                            }
                            else{
                                c.setIsWeightNormal(false);
                            }
                        }
                        if(age >= 3 && age <= 5){
                            if(c.getWeight() >=31 && c.getWeight() <= 40){
                                c.setIsWeightNormal(true);
                            }
                            else{
                               c.setIsWeightNormal(false);
                            }
                        }
                         if(age >= 6 && age <= 12){
                            if(c.getWeight() >=41 && c.getWeight() <= 92){
                                c.setIsWeightNormal(true);
                            }
                            else{
                                c.setIsWeightNormal(false);
                            }
                        }


                         if(age >= 0 && age < 1){
                            if(c.getPulseRate()>=80 && c.getPulseRate() <= 180){
                                c.setIspulserateNormal(true);
                            }
                            else{
                               c.setIspulserateNormal(false);
                            }
                        }
                         if(age >= 1 && age < 3){
                            if(c.getPulseRate()>=80 && c.getPulseRate() <= 160){
                                c.setIspulserateNormal(true);
                            }
                            else{
                               c.setIspulserateNormal(false);
                            }
                        }
                         if(age >= 3 && age <= 5){
                            if(c.getPulseRate()>=80 && c.getPulseRate() <= 110){
                                c.setIspulserateNormal(true);
                            }
                            else{
                                c.setIspulserateNormal(false);
                            }
                        }

                        if(age >= 6 && age <= 12){
                            if(c.getPulseRate()>=75 && c.getPulseRate() <= 110){
                                c.setIspulserateNormal(true);
                            }
                            else{
                               c.setIspulserateNormal(false);
                            }
                        }


                        if(age >= 0 && age < 1){
                            if(c.getBP()>=50 && c.getBP() <= 100){
                                c.setIsBpNormal(true);
                            }
                            else{
                                c.setIsBpNormal(false);
                            }
                        }

                        if(age >= 1 && age <= 5){
                            if(c.getBP()>=80 && c.getBP() <= 110){
                                c.setIsBpNormal(true);
                            }
                            else{
                               c.setIsBpNormal(false);
                            }
                        }

                        if(age >= 6 && age <= 12){
                            if(c.getBP()>=80 && c.getBP() <= 120){
                                c.setIsBpNormal(true);
                            }
                            else{
                                c.setIsBpNormal(false);
                            }
                        }

                        if(age >= 0 && age < 1){
                            if(c.getBodytemp()>=98 && c.getBodytemp() <= 100){
                                c.setIstempNormal(true);
                            }
                            else{
                                c.setIstempNormal(false);
                            }
                        }

                        if(age >= 1 && age <= 3){
                            if(c.getBodytemp()>=96.8 && c.getBodytemp() <= 99.6){
                                 c.setIstempNormal(true);
                            }
                            else{
                                c.setIstempNormal(false);
                            }
                        }
                        if(age >= 4 && age <= 12){
                            if(c.getBodytemp()==98.6){
                                c.setIstempNormal(true);
                            }
                            else{
                               c.setIstempNormal(false);
                            }
                        }

                       if(age >= 0 && age < 1){
                            if(c.getRespirationRate()>=20 && c.getBodytemp() <= 50){
                                c.setIsBreathingRateNorma(true);
                            }
                            else{
                                c.setIsBreathingRateNorma(false);
                            }
                        }

                       if(age >= 1 && age < 5){
                            if(c.getRespirationRate()>=20 && c.getRespirationRate()<= 30){
                               c.setIsBreathingRateNorma(true);
                            }
                            else{
                                c.setIsBreathingRateNorma(false);
                            }
                        }

                       if(age >= 6 && age < 12){
                            if(c.getRespirationRate()>=20 && c.getRespirationRate()<= 30){
                               c.setIsBreathingRateNorma(true);
                            }
                            else{
                                c.setIsBreathingRateNorma(false);
                            }
                        }
                       
                       if(c.isIsBpNormal() == true && c.isIsBreathingRateNorma()== true && c.isIsWeightNormal()== true &&
                               c.isIspulserateNormal()== true && c.isIstempNormal()== true){
                           c.setIsVitalSignsNormal(true);
                           c1.setIsVitalSignNormal(true);
                       }
                }
            }
             /*for(Child c1:business.getChildDirectory().getChildlist()){
                 JOptionPane.showMessageDialog(rightpanel1, c1.getVitallist());
             }*/
  
            JOptionPane.showMessageDialog(rightpanel1, "Vital Signs Saved");
             
         }

    }//GEN-LAST:event_btn_svaevitalsActionPerformed

    private void btn_seereportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_seereportActionPerformed
        // TODO add your handling code here:
        
        populateVitalSignsTable();
        //tbl_vitalsigns.setVisible(true);
        
        /*txt_weightr.setText(String.valueOf(childval.getWeight()));
        txt_tempr.setText(String.valueOf(childval.getBodytemp()));
        txt_pulser.setText(String.valueOf(childval.getPulseRate()));
        txt_bpr.setText(String.valueOf(childval.getBP()));
        txt_breathingr.setText(String.valueOf(childval.getRespirationRate()));
        txt_dater.setText(String.valueOf(childval.getVitalSignsDate()));
        
        String weight = String.valueOf(txt_weightr.getText());
        String temp = String.valueOf(txt_tempr.getText());
        String pulse = String.valueOf(txt_pulser.getText());
        String bp = String.valueOf(txt_bpr.getText());
        String breathing = String.valueOf(txt_breathingr.getText());
        String vitalsignsdate = String.valueOf(txt_dater.getText());
        
        int age = Integer.parseInt(txt_age.getText());
        
        if(age >= 0 && age < 1){
            if(childval.getWeight() >=9 && childval.getWeight() <= 22){
                lbl_weight.setText("Normal");
                lbl_weight.setVisible(true);
                lbl_weight.setForeground(Color.green);
            }
            else{
                lbl_weight.setText("NOT NORMAL");
                lbl_weight.setVisible(true);
                lbl_weight.setForeground(Color.red);
            }
        }
        if(age >= 1 && age < 3){
            if(childval.getWeight() >=22 && childval.getWeight() <= 31){
                lbl_weight.setText("Normal");
                lbl_weight.setVisible(true);
                lbl_weight.setForeground(Color.green);
            }
            else{
                lbl_weight.setText("NOT NORMAL");
                lbl_weight.setVisible(true);
                lbl_weight.setForeground(Color.red);
            }
        }
        if(age >= 3 && age <= 5){
            if(childval.getWeight() >=31 && childval.getWeight() <= 40){
                lbl_weight.setText("Normal");
                lbl_weight.setVisible(true);
                lbl_weight.setForeground(Color.green);
            }
            else{
                lbl_weight.setText("NOT NORMAL");
                lbl_weight.setVisible(true);
                lbl_weight.setForeground(Color.red);
            }
        }
         if(age >= 6 && age <= 12){
            if(childval.getWeight() >=41 && childval.getWeight() <= 92){
                lbl_weight.setText("Normal");
                lbl_weight.setVisible(true);
                lbl_weight.setForeground(Color.green);
            }
            else{
                lbl_weight.setText("NOT NORMAL");
                lbl_weight.setVisible(true);
                lbl_weight.setForeground(Color.red);
            }
        }
         
        
         if(age >= 0 && age < 1){
            if(childval.getPulseRate()>=80 && childval.getPulseRate() <= 180){
                lbl_pulse.setText("Normal");
                lbl_pulse.setVisible(true);
                lbl_pulse.setForeground(Color.green);
            }
            else{
                lbl_pulse.setText("NOT NORMAL");
                lbl_pulse.setVisible(true);
                lbl_pulse.setForeground(Color.red);
            }
        }
         if(age >= 1 && age < 3){
            if(childval.getPulseRate()>=80 && childval.getPulseRate() <= 160){
                lbl_pulse.setText("Normal");
                lbl_pulse.setVisible(true);
                lbl_weight.setForeground(Color.green);
            }
            else{
                lbl_pulse.setText("NOT NORMAL");
                lbl_pulse.setVisible(true);
                lbl_pulse.setForeground(Color.red);
            }
        }
         if(age >= 3 && age <= 5){
            if(childval.getPulseRate()>=80 && childval.getPulseRate() <= 110){
                lbl_pulse.setText("Normal");
                lbl_pulse.setVisible(true);
                lbl_pulse.setForeground(Color.green);
            }
            else{
                lbl_pulse.setText("NOT NORMAL");
                lbl_pulse.setVisible(true);
                lbl_pulse.setForeground(Color.red);
            }
        }
         
        if(age >= 6 && age <= 12){
            if(childval.getPulseRate()>=75 && childval.getPulseRate() <= 110){
                lbl_pulse.setText("Normal");
                lbl_pulse.setVisible(true);
                lbl_weight.setForeground(Color.green);
            }
            else{
                lbl_pulse.setText("NOT NORMAL");
                lbl_pulse.setVisible(true);
                lbl_pulse.setForeground(Color.red);
            }
        }
        
        
        if(age >= 0 && age < 1){
            if(childval.getBP()>=50 && childval.getBP() <= 100){
                lbl_bp.setText("Normal");
                lbl_bp.setVisible(true);
                lbl_bp.setForeground(Color.green);
            }
            else{
                lbl_bp.setText("NOT NORMAL");
                lbl_bp.setVisible(true);
                lbl_bp.setForeground(Color.red);
            }
        }
        
        if(age >= 1 && age <= 5){
            if(childval.getBP()>=80 && childval.getBP() <= 110){
                lbl_bp.setText("Normal");
                lbl_bp.setVisible(true);
                lbl_bp.setForeground(Color.green);
            }
            else{
                lbl_bp.setText("NOT NORMAL");
                lbl_bp.setVisible(true);
                lbl_bp.setForeground(Color.red);
            }
        }
        
        if(age >= 6 && age <= 12){
            if(childval.getBP()>=80 && childval.getBP() <= 120){
                lbl_bp.setText("Normal");
                lbl_bp.setVisible(true);
                lbl_bp.setForeground(Color.green);
            }
            else{
                lbl_bp.setText("NOT NORMAL");
                lbl_bp.setVisible(true);
                lbl_bp.setForeground(Color.red);
            }
        }
        
        if(age >= 0 && age < 1){
            if(childval.getBodytemp()>=98 && childval.getBodytemp() <= 100){
                lbl_temp.setText("Normal");
                lbl_temp.setVisible(true);
                lbl_temp.setForeground(Color.green);
            }
            else{
                lbl_temp.setText("NOT NORMAL");
                lbl_temp.setVisible(true);
                lbl_temp.setForeground(Color.red);
            }
        }
        
        if(age >= 1 && age <= 3){
            if(childval.getBodytemp()>=96.8 && childval.getBodytemp() <= 99.6){
                lbl_temp.setText("Normal");
                lbl_temp.setVisible(true);
                lbl_temp.setForeground(Color.green);
            }
            else{
                lbl_temp.setText("NOT NORMAL");
                lbl_temp.setVisible(true);
                lbl_temp.setForeground(Color.red);
            }
        }
        if(age >= 4 && age <= 12){
            if(childval.getBodytemp()==98.6){
                lbl_temp.setText("Normal");
                lbl_temp.setVisible(true);
                lbl_temp.setForeground(Color.green);
            }
            else{
                lbl_temp.setText("NOT NORMAL");
                lbl_temp.setVisible(true);
                lbl_temp.setForeground(Color.red);
            }
        }
        
       if(age >= 0 && age < 1){
            if(childval.getRespirationRate()>=20 && childval.getBodytemp() <= 50){
                lbl_breathing.setText("Normal");
                lbl_breathing.setVisible(true);
                lbl_breathing.setForeground(Color.green);
            }
            else{
                lbl_breathing.setText("NOT NORMAL");
                lbl_breathing.setVisible(true);
                lbl_breathing.setForeground(Color.red);
            }
        }
       
       if(age >= 1 && age < 5){
            if(childval.getRespirationRate()>=20 && childval.getRespirationRate()<= 30){
                lbl_breathing.setText("Normal");
                lbl_breathing.setVisible(true);
                lbl_breathing.setForeground(Color.green);
            }
            else{
                lbl_breathing.setText("NOT NORMAL");
                lbl_breathing.setVisible(true);
                lbl_breathing.setForeground(Color.red);
            }
        }
       
       if(age >= 6 && age < 12){
            if(childval.getRespirationRate()>=20 && childval.getRespirationRate()<= 30){
                lbl_breathing.setText("Normal");
                lbl_breathing.setVisible(true);
            }
            else{
                lbl_breathing.setText("NOT NORMAL");
                lbl_breathing.setVisible(true);
            }
        }
         
      if(lbl_bp.getText().equals("Normal") && lbl_breathing.getText().equals("Normal") && 
              lbl_pulse.getText().equals("Normal") && lbl_temp.getText().equals("Normal") &&
              lbl_weight.getText().equals("Normal")){
          
              for(Child c:business.getChildDirectory().getChildlist()){
                if(c.getUsername().equals(childval.getUsername())){
                   c.setIsVitalSignsNormal(true);
                }
            }
            
            for(Child c:childval.getOrg().getChildDirectory().getChildlist()){

                if(c.getUsername().equals(childval.getUsername())){
                   c.setIsVitalSignsNormal(true);
                }
            }
              
      }
      
      else{
          for(Child c:business.getChildDirectory().getChildlist()){
              JOptionPane.showMessageDialog(rightpanel1, "K"+c.equals(childval));
                if(c.getUsername().equals(childval.getUsername())){
                   c.setIsVitalSignsNormal(true);
                }
            }
            
            for(Child c:childval.getOrg().getChildDirectory().getChildlist()){
                JOptionPane.showMessageDialog(rightpanel1, "K"+c.equals(childval));
                if(c.getUsername().equals(childval.getUsername())){
                   c.setIsVitalSignsNormal(true);
                }
            }
      }
      
      for(Child c:business.getChildDirectory().getChildlist()){
              
              JOptionPane.showMessageDialog(rightpanel1, c.isIsVitalSignsNormal());
                
            }
            
            for(Child c:childval.getOrg().getChildDirectory().getChildlist()){

                JOptionPane.showMessageDialog(rightpanel1, c.isIsVitalSignsNormal());
            }*/
        
        
    }//GEN-LAST:event_btn_seereportActionPerformed

    private void txt_bpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bpActionPerformed

    private void btn_requestlabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_requestlabActionPerformed
        // TODO add your handling code here:
        
       if(!workRequest.getStatus().equals("Lab Test Requested")){
        if(check_blood.isSelected() && !check_urine.isSelected()){
            LabWorkRequest labworkrequest = new LabWorkRequest();
            labworkrequest.setIs_blood_test_required(true);
            labworkrequest.setIs_urine_test_required(false);
            
            labworkrequest.setStatus("Lab Test Requested");
            labworkrequest.setMessage("Lab Test Requested");
            labworkrequest.setChild(childval);
            labworkrequest.setSender(account);
            labworkrequest.setIsLabDone(false);
            
            workRequest.setStatus("Lab Test Requested");
            workRequest.setMessage("Lab Test Requested");
            
            assignorg(labworkrequest);
            JOptionPane.showMessageDialog(rightpanel1, "Lab Test Request Sent");
            
            goback();
   
        }
        else if(check_urine.isSelected() && !check_blood.isSelected()){
            LabWorkRequest labworkrequest = new LabWorkRequest();
            labworkrequest.setIs_urine_test_required(true);
            labworkrequest.setIs_blood_test_required(false);
            labworkrequest.setMessage("Lab Test Requested");
            labworkrequest.setStatus("Lab Test Requested");
            labworkrequest.setChild(childval);
            labworkrequest.setSender(account);
            labworkrequest.setIsLabDone(false);
            assignorg(labworkrequest);
            
            
            workRequest.setStatus("Lab Test Requested");
            workRequest.setMessage("Lab Test Requested");
            JOptionPane.showMessageDialog(rightpanel1, "Lab Test Request Sent");
            goback();
        }
        else if(check_blood.isSelected() && check_urine.isSelected()){
            
            LabWorkRequest labworkrequest = new LabWorkRequest();
            labworkrequest.setIs_blood_test_required(true);
            labworkrequest.setIs_urine_test_required(true);
            JOptionPane.showMessageDialog(rightpanel1, labworkrequest.isIs_urine_test_required());
            labworkrequest.setMessage("Lab Test Requested");
            labworkrequest.setStatus("Lab Test Requested");
            labworkrequest.setChild(childval);
            labworkrequest.setSender(account);
            labworkrequest.setIsLabDone(false);
            assignorg(labworkrequest);
            
            workRequest.setStatus("Lab Test Requested");
            workRequest.setMessage("Lab Test Requested");
            JOptionPane.showMessageDialog(rightpanel1, "Lab Test Request Sent");
            goback();
        }
        else if(!check_blood.isSelected() && !check_urine.isSelected()){
            JOptionPane.showMessageDialog(rightpanel1, "Please select Test Type");
        }
       }
       if(lbl_requestanother.isVisible()){
          lbl_requestanother.setVisible(false);
       }
       checklabstatus();
       //checkLabTestDone();
    }//GEN-LAST:event_btn_requestlabActionPerformed
    
   
    
    
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backActionPerformed

    private void btn_labseereportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_labseereportActionPerformed
        // TODO add your handling code here:
        DoctorSeeReportJPanel doctorseereportpanel = new DoctorSeeReportJPanel(business, 
                                                         account,userProcessContainer,enterprise,
                                                        organization,childdir,rightpanel1,childval,workRequest);
        userProcessContainer.add(doctorseereportpanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_btn_labseereportActionPerformed

    private void btn_prescribeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prescribeActionPerformed
        // TODO add your handling code here:
        if(txt_prescription.getText().isEmpty()){
            JOptionPane.showMessageDialog(rightpanel1, "Please enter prescription");
            return;
        }
        else if(workRequest.getStatus().equals("LabTest Done") || 
                workRequest.getStatus().equals("Medication Provided")){
            
            PharmacyWorkRequest pwr = new PharmacyWorkRequest();
            pwr.setStatus("Request for medication");
            pwr.setPrescription(txt_prescription.getText());
            pwr.setMessage("Request for medication");
            pwr.setSender(account);
            pwr.setChild(childval);
            
            
            for(WorkRequest wr:((WorkRequest)workRequest).getSender().getWorkQueue().getWorkRequestList()){
            wr.setStatus("Request for medication");
            wr.setMessage("Request for medication");
            //JOptionPane.showMessageDialog(rightpanel1, wr);
            }
            JOptionPane.showMessageDialog(rightpanel1, "Lab Test Request Sent");
            
            for(Child c:business.getChildDirectory().getChildlist()){
            if(childval.equals(c)){
                childval.setIsMediacted(false);
            }
        }
            
            for(Child c:workRequest.getSenderOrganisation().getChildDirectory().getChildlist()){
            if(childval.equals(c)){
                childval.setIsMediacted(false);
            }
        }
        
        for(Child c:childval.getOrg().getChildDirectory().getChildlist()){
            if(childval.equals(c)){
                childval.setIsMediacted(false);
            }
        }
            
            goback();

            Organization org = null;
            for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                if (organization instanceof PharmaOrganisation) {
                    org = organization;
                    break;
                }
            }
            if (org != null) {
                org.getWorkQueue().getWorkRequestList().add(pwr);               
                //JOptionPane.showMessageDialog(rightpanel1, account.getWorkQueue().getWorkRequestList());
            }
            else{
                JOptionPane.showMessageDialog(rightpanel1, "Please create organisation first");
            }
            
        }
                
        
        
  
      else{
           JOptionPane.showMessageDialog(rightpanel1, "Previous Medication in Process");
      }
        
    }//GEN-LAST:event_btn_prescribeActionPerformed
    
    public void assignorg(LabWorkRequest labworkrequest){
        Organization org = null;
            for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                if (organization instanceof LabOrganisation) {
                    org = organization;
                    break;
                }
            }
            if (org != null) {
                org.getWorkQueue().getWorkRequestList().add(labworkrequest);               
                //JOptionPane.showMessageDialog(rightpanel1, account.getWorkQueue().getWorkRequestList());
            }
      
    }
    
    public void goback(){
        userProcessContainer.remove(this);
        Component[] componentArray = rightpanel1.getComponents();
        Component component = componentArray[componentArray.length - 1];
        DoctorManageRequestJPanel panel = (DoctorManageRequestJPanel) component;
        panel.populateTable();
        CardLayout layout = (CardLayout) rightpanel1.getLayout();
        layout.previous(rightpanel1);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton btn_labseereport;
    private javax.swing.JButton btn_prescribe;
    private javax.swing.JButton btn_requestlab;
    private javax.swing.JButton btn_seereport;
    private javax.swing.JButton btn_svaevitals;
    private javax.swing.JCheckBox check_blood;
    private javax.swing.JCheckBox check_urine;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel lab_testunder;
    private javax.swing.JLabel lbl_done;
    private javax.swing.JLabel lbl_labtest1;
    private javax.swing.JLabel lbl_requestanother;
    private javax.swing.JLabel lbl_test;
    private javax.swing.JLabel lbl_underprocess;
    private javax.swing.JPanel panel_labseereport;
    private javax.swing.JPanel panel_medication;
    private javax.swing.JPanel panel_prescribe;
    private javax.swing.JPanel panel_prescriptions;
    private javax.swing.JPanel panel_requestlab;
    private javax.swing.JPanel panel_savevitals;
    private javax.swing.JPanel panel_seeReport;
    private javax.swing.JPanel panel_singleparent;
    private javax.swing.JTable tbl_prescriptions;
    private javax.swing.JTable tbl_vitalsigns;
    private javax.swing.JTextField txt_about1;
    private javax.swing.JTextField txt_age;
    private javax.swing.JTextField txt_agency;
    private javax.swing.JTextField txt_bp;
    private javax.swing.JTextField txt_breathing;
    private javax.swing.JTextField txt_city;
    private javax.swing.JTextField txt_firstname;
    private javax.swing.JTextField txt_gender;
    private javax.swing.JTextField txt_lastname;
    private javax.swing.JTextField txt_message;
    private javax.swing.JTextField txt_prescription;
    private javax.swing.JTextField txt_pulse;
    private javax.swing.JTextField txt_temp;
    private javax.swing.JTextField txt_weight;
    // End of variables declaration//GEN-END:variables
}
