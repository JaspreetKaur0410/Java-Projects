/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.LabortaryAssistant;

import Business.Child.Child;
import Business.Child.ChildDirectory;
import Business.Child.ChildLabTests;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.LabWorkRequest;
import Business.WorkQueue.MedicalCheckRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.Doctor.DoctorManageRequestJPanel;

/**
 *
 * @author jaspr
 */
public class LabCheckUpJPanel extends javax.swing.JPanel {

    /**
     * Creates new form LabCheckUpJPanel
     */
    EcoSystem business;
    UserAccount account;
    JPanel userProcessContainer;
    Enterprise enterprise;
    Organization organization;
    ChildDirectory childdir;
    JPanel rightpanel1;
    Child childval;
    LabWorkRequest workRequest;
    
    int bloodcount;
    double haemoglobin;
    double cholestrol;
    double hdl;
    double ldl;
    double glucose;
    int dopamine;
    double metanephrine;
       
    public LabCheckUpJPanel(EcoSystem business,UserAccount account,JPanel userProcessContainer,
                                Enterprise enterprise,
                                Organization organization,ChildDirectory childdir,
                                JPanel rightpanel1,Child childval,LabWorkRequest workRequest) {
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
        
        //JOptionPane.showMessageDialog(rightpanel1, workRequest.isIs_urine_test_required());
        
        panel_blood.setVisible(false);
        panel_urine.setVisible(false);

        populatechilddata();
        
        panel_tbl_blood.setVisible(false);
        tbl_blood.setVisible(false);
        panel_tbl_urine.setVisible(false);
        tbl_urine.setVisible(false);
        
        panel_seeReport.setVisible(false);
        btn_seereport.setVisible(false);
        
        if(workRequest.isIs_blood_test_required() && !workRequest.isIs_urine_test_required()){
            txt_testname.setText("Blood Test");
            panel_blood.setVisible(true);
            panel_tbl_blood.setVisible(true);
            tbl_blood.setVisible(true);
            panel_tbl_urine.setVisible(false);
            tbl_urine.setVisible(false);
        }
        else if(workRequest.isIs_urine_test_required() &&!workRequest.isIs_blood_test_required()){
            txt_testname.setText("Urine Test");
            panel_urine.setVisible(true);
            panel_tbl_urine.setVisible(true);
            tbl_urine.setVisible(true);
            panel_tbl_blood.setVisible(false);
            tbl_blood.setVisible(false);
        }
        else if(workRequest.isIs_blood_test_required() && workRequest.isIs_urine_test_required()){
            txt_testname.setText("Blood" + " AND " + "URINE TEST");
            panel_blood.setVisible(true);
            panel_urine.setVisible(true);
            panel_tbl_urine.setVisible(true);
            tbl_urine.setVisible(true);
            panel_tbl_blood.setVisible(true);
            tbl_blood.setVisible(true);
        }
        if(childval.getLabtestlist()!=null){
            populatechilddata();
        }
        
        if(childval.getLabtestlist()!=null){
            populateTables();
        }
        
        //checkTableVisisbility();
        if(!childval.getLabtestlist().isEmpty()){
            //JOptionPane.showMessageDialog(panel_savetest, childval.getLabtestlist());
            checkLabTestDone();
        }
 
    }
    
   public void checkLabTestDone(){
       if(childval.getLabtestlist() != null){ 
          
            Collections.sort(childval.getLabtestlist());
            List<Date> dates = new ArrayList<Date>();
            for(ChildLabTests clt:childval.getLabtestlist()){
                dates.add(clt.getLabtestdate());
            }
            Date recentdate = Collections.max(dates);
            for(ChildLabTests clt:childval.getLabtestlist()){
                //JOptionPane.showMessageDialog(panel_savetest, "Hello1");
                //JOptionPane.showMessageDialog(panel_savetest, clt.getLabtestdate().equals(recentdate));
               if(clt.getLabtestdate().equals(recentdate)){
                   //JOptionPane.showMessageDialog(panel_savetest, "Hello2");
                   
                   for(WorkRequest wr:((WorkRequest)workRequest).getSender().getWorkQueue().getWorkRequestList()){
                    wr.setStatus("LabTest Done");
                    wr.setMessage("LabTest Done");
                    JOptionPane.showMessageDialog(rightpanel1, wr);
               
           }
               }
            }
            
            
            
       }
   }
    
    /*public void checkTableVisisbility(){
        
        if(childval.getLabtestlist() == null){
            panel_tbl_blood.setVisible(false);
            tbl_blood.setVisible(false);
            panel_tbl_urine.setVisible(false);
            tbl_urine.setVisible(false);
        }
        
        else if(childval.getLabtestlist()!=null){
            for(ChildLabTests clt:childval.getLabtestlist()){
                if(clt.isIs_bloodTestRequired() && !clt.isIs_urineTestRequired()){
                    JOptionPane.showMessageDialog(panel_savetest, clt.isIs_urineTestRequired());
                    panel_tbl_blood.setVisible(true);
                    tbl_blood.setVisible(true);
                    panel_tbl_urine.setVisible(false);
                    tbl_urine.setVisible(false);
                }
                else if(clt.isIs_urineTestRequired() && !clt.isIs_bloodTestRequired()){
                    panel_tbl_urine.setVisible(true);
                    tbl_urine.setVisible(true);
                    panel_tbl_blood.setVisible(false);
                    tbl_blood.setVisible(false);
                }
                else if(clt.isIs_urineTestRequired() && clt.isIs_bloodTestRequired()){
                    JOptionPane.showMessageDialog(panel_savetest, clt.isIs_urineTestRequired());
                    panel_tbl_urine.setVisible(true);
                    tbl_urine.setVisible(true);
                    panel_tbl_blood.setVisible(true);
                    tbl_blood.setVisible(true);
                }
            }
        }
    }*/
    
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
    
    public void populateTables(){
        
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yy");
        
        DefaultTableModel model_urine = (DefaultTableModel) tbl_urine.getModel();
        DefaultTableModel model_blood = (DefaultTableModel) tbl_blood.getModel();
        model_urine.setRowCount(0);
        model_blood.setRowCount(0);
        
        
        for(ChildLabTests clt:childval.getLabtestlist()){
            if(childval.getLabtestlist()!=null){
                
                if(workRequest.isIs_blood_test_required() && !workRequest.isIs_urine_test_required()){
   
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
                else if(workRequest.isIs_urine_test_required()&& !workRequest.isIs_blood_test_required()){
 
                    Object[] row_urine = new Object[model_urine.getColumnCount()];
                    if(clt.isIs_urineTestRequired()){
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
                else if(workRequest.isIs_blood_test_required() && workRequest.isIs_urine_test_required()){
                   
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
        panel_savetest = new javax.swing.JPanel();
        btn_svaetest = new javax.swing.JButton();
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
        lab_testunder = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        panel_blood = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        txt_bloodcount = new javax.swing.JTextField();
        txt_haemoglobin = new javax.swing.JTextField();
        txt_chol = new javax.swing.JTextField();
        txt_ldl = new javax.swing.JTextField();
        txt_hdl = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        txt_glucose = new javax.swing.JTextField();
        panel_urine = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        txt_dopamine = new javax.swing.JTextField();
        txt_meta = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        txt_testname = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        panel_tbl_blood = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_blood = new javax.swing.JTable();
        panel_tbl_urine = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_urine = new javax.swing.JTable();

        jPanel5.setBackground(new java.awt.Color(204, 255, 0));

        panel_seeReport.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_seereport.setText("See Report");
        btn_seereport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_seereportActionPerformed(evt);
            }
        });
        panel_seeReport.add(btn_seereport, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        panel_savetest.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_svaetest.setText("SAVE TEST");
        btn_svaetest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_svaetestActionPerformed(evt);
            }
        });
        panel_savetest.add(btn_svaetest, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3, -1, 30));

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

        lab_testunder.setBackground(new java.awt.Color(204, 255, 204));
        lab_testunder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel61.setText("LAB TEST");
        lab_testunder.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel56.setText("BLOOD TEST");

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel64.setText("HAEMOGLOBIN");

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel65.setText("BLOOD COUNT");

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel66.setText("CHOLESTROL");

        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel67.setText("LDL");

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel68.setText("HDL");

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel71.setText("Glucose");

        javax.swing.GroupLayout panel_bloodLayout = new javax.swing.GroupLayout(panel_blood);
        panel_blood.setLayout(panel_bloodLayout);
        panel_bloodLayout.setHorizontalGroup(
            panel_bloodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_bloodLayout.createSequentialGroup()
                .addGroup(panel_bloodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_bloodLayout.createSequentialGroup()
                        .addGroup(panel_bloodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_bloodLayout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel56))
                            .addGroup(panel_bloodLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel67)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panel_bloodLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel_bloodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel65)
                            .addComponent(jLabel64)
                            .addComponent(jLabel66)
                            .addComponent(jLabel68)
                            .addComponent(jLabel71))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addGroup(panel_bloodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_bloodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_glucose)
                                .addComponent(txt_hdl)
                                .addComponent(txt_chol)
                                .addComponent(txt_haemoglobin, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txt_ldl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_bloodcount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        panel_bloodLayout.setVerticalGroup(
            panel_bloodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_bloodLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel56)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_bloodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_bloodcount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_bloodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_haemoglobin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_bloodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_chol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_bloodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_hdl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panel_bloodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ldl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_bloodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_glucose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 41, Short.MAX_VALUE))
        );

        lab_testunder.add(panel_blood, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 260, 260));

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel63.setText("URINE TEST");

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel69.setText("Dopamine");

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel70.setText("Metanephrine");

        javax.swing.GroupLayout panel_urineLayout = new javax.swing.GroupLayout(panel_urine);
        panel_urine.setLayout(panel_urineLayout);
        panel_urineLayout.setHorizontalGroup(
            panel_urineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_urineLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel63)
                .addGap(60, 60, 60))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_urineLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_urineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel69)
                    .addComponent(jLabel70))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(panel_urineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_meta, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dopamine, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        panel_urineLayout.setVerticalGroup(
            panel_urineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_urineLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel63)
                .addGap(32, 32, 32)
                .addGroup(panel_urineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dopamine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_urineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_meta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(138, Short.MAX_VALUE))
        );

        lab_testunder.add(panel_urine, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, -1, 260));

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel60.setText("DATE");
        lab_testunder.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, -1));
        lab_testunder.add(txt_testname, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 150, -1));

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel72.setText("TEST NAME");
        lab_testunder.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));
        lab_testunder.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 170, -1));

        panel_tbl_blood.setBackground(new java.awt.Color(204, 255, 204));
        panel_tbl_blood.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel62.setText("BLOOD TEST REPORT");
        panel_tbl_blood.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

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
        panel_tbl_urine.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

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

        panel_tbl_urine.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 450, 90));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lab_testunder, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel_seeReport, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel_savetest, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel_tbl_urine, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panel_tbl_blood, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(186, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(panel_savetest, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_seeReport, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(panel_tbl_urine, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lab_testunder, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panel_tbl_blood, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btn_seereportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_seereportActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(panel_savetest, childval.getLabtestlist());
        if(childval.getLabtestlist()!=null){
            populateTables();
        }
    }//GEN-LAST:event_btn_seereportActionPerformed

    private void btn_svaetestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_svaetestActionPerformed
        // TODO add your handling code here:

       LocalDateTime now = LocalDateTime.now();
       ZoneId defaultzoneid = ZoneId.systemDefault();
       ZonedDateTime zdt = now.atZone(defaultzoneid);
       Date to_Date_now = Date.from(zdt.toInstant());
   
       if(txt_testname.getText().equals("Blood Test")){
           
           if(txt_bloodcount.getText().isEmpty() || txt_haemoglobin.getText().isEmpty() || 
                   txt_chol.getText().isEmpty() || txt_hdl.getText().isEmpty() ||
                   txt_ldl.getText().isEmpty() || txt_glucose.getText().isEmpty()
                   || date.getDate() == null){
               JOptionPane.showMessageDialog(panel_savetest, "Provide All Details");
               return;
           }
           else{
               try{
                   bloodcount = Integer.parseInt(txt_bloodcount.getText());
                   if(bloodcount < 4500){
                       JOptionPane.showMessageDialog(panel_savetest, "Bllod count should be more than 4500");
                       return;
                   }
               }
               catch(Exception e){
                   JOptionPane.showMessageDialog(panel_savetest, "Enter Correct Blood Count");
                   return;
               }
               try{
                   haemoglobin = Double.parseDouble(txt_haemoglobin.getText());
                   
               }
               catch(Exception e){
                   JOptionPane.showMessageDialog(panel_savetest, "Enter Correct haemoglobint");
                   return;
               }
                try{
                   cholestrol = Double.parseDouble(txt_chol.getText());  
               }
               catch(Exception e){
                   JOptionPane.showMessageDialog(panel_savetest, "Enter Correct cholestrol");
                   return;
               }
               try{
                   hdl = Double.parseDouble(txt_hdl.getText());  
               }
               catch(Exception e){
                   JOptionPane.showMessageDialog(panel_savetest, "Enter Correct HDL");
                   return;
               }
               try{
                   ldl = Double.parseDouble(txt_ldl.getText());  
               }
               catch(Exception e){
                   JOptionPane.showMessageDialog(panel_savetest, "Enter Correct LDl");
                   return;
               }
               try{
                   glucose = Double.parseDouble(txt_glucose.getText());  
               }
               catch(Exception e){
                   JOptionPane.showMessageDialog(panel_savetest, "Enter Correct glucose");
                   return;
               }
               
               for(Child c:business.getChildDirectory().getChildlist()){
                    if(c.getUsername().equals(childval.getUsername())){
                        ChildLabTests clt = c.addChildLabTest();
                        clt.setBloodcount(bloodcount);
                        clt.setHaemoglobin(haemoglobin);
                        clt.setCholestrol(cholestrol);
                        clt.setHdl(hdl);
                        clt.setLdl(ldl);
                        clt.setGlucose(glucose);
                        clt.setLabtestdate(date.getDate());
                        clt.setIs_bloodTestRequired(true);
                        clt.setIs_urineTestRequired(false);
                        labTest(c,clt);
                        
                }
               }
               
               for(Child c:childval.getOrg().getChildDirectory().getChildlist()){
                    if(c.getUsername().equals(childval.getUsername())){
                        ChildLabTests clt = c.addChildLabTest();
                        clt.setBloodcount(bloodcount);
                        clt.setHaemoglobin(haemoglobin);
                        clt.setCholestrol(cholestrol);
                        clt.setHdl(hdl);
                        clt.setLdl(ldl);
                        clt.setGlucose(glucose);
                        clt.setLabtestdate(date.getDate());
                        clt.setIs_bloodTestRequired(true);
                        clt.setIs_urineTestRequired(false);
                        labTest(c,clt);
                        
                }
               }        
           }
           JOptionPane.showMessageDialog(panel_savetest, "Test Saved");
           populateTables();
           //checkTableVisisbility();
           
           workRequest.setReceiver(account);
           workRequest.setStatus("LabTest Done");
           workRequest.setChild(childval);
           workRequest.setMessage("LabTest Done");
        
           txt_bloodcount.setText("");
           txt_haemoglobin.setText("");
           txt_chol.setText("");
           txt_hdl.setText("");
           txt_ldl.setText("");
           txt_glucose.setText("");
           date.setDate(null);
       }
  
       else if(txt_testname.getText().equals("Urine Test")){
           
           if(txt_dopamine.getText().isEmpty() || txt_meta.getText().isEmpty()  || date.getDate() == null){
               JOptionPane.showMessageDialog(panel_savetest, "Provide All Details");
               return;
           }
           else{
               try{
                   dopamine = Integer.parseInt(txt_dopamine.getText());
                  
               }
               catch(Exception e){
                   JOptionPane.showMessageDialog(panel_savetest, "Enter Correct Dopamine Value");
                   return;
               }
               try{
                   metanephrine = Double.parseDouble(txt_meta.getText());
                   
               }
               catch(Exception e){
                   JOptionPane.showMessageDialog(panel_savetest, "Enter Correct Metanephrine Value");
                   return;
               }
                
               
               for(Child c:business.getChildDirectory().getChildlist()){
                    if(c.getUsername().equals(childval.getUsername())){
                        ChildLabTests clt = c.addChildLabTest();
                        clt.setDopamine(dopamine);
                        clt.setMetanephrine(metanephrine);
                        clt.setLabtestdate(date.getDate());
                        clt.setIs_bloodTestRequired(false);
                        clt.setIs_urineTestRequired(true);
                        labTest(c,clt);
                        
                }
               }
               for(Child c:childval.getOrg().getChildDirectory().getChildlist()){
                    if(c.getUsername().equals(childval.getUsername())){
                        ChildLabTests clt = c.addChildLabTest();
                        clt.setDopamine(dopamine);
                        clt.setMetanephrine(metanephrine);
                        clt.setLabtestdate(date.getDate());
                        clt.setIs_bloodTestRequired(false);
                        clt.setIs_urineTestRequired(true);
                        labTest(c,clt);
                        
                }
               }
           }
           JOptionPane.showMessageDialog(panel_savetest, "Test Saved");
           populateTables();
           //checkTableVisisbility();
           
           workRequest.setReceiver(account);
           workRequest.setStatus("LabTest Done");
           workRequest.setChild(childval);
           workRequest.setMessage("LabTest Done");
       
           txt_bloodcount.setText("");
           txt_haemoglobin.setText("");
           txt_chol.setText("");
           txt_hdl.setText("");
           txt_ldl.setText("");
           txt_glucose.setText("");
           date.setDate(null);
       }
       else if(txt_testname.getText().equals("Blood" + " AND " + "URINE TEST")){
           if(txt_bloodcount.getText().isEmpty() || txt_haemoglobin.getText().isEmpty() || 
                   txt_chol.getText().isEmpty() || txt_hdl.getText().isEmpty() ||
                   txt_ldl.getText().isEmpty() || txt_glucose.getText().isEmpty()
                   || txt_dopamine.getText().isEmpty() || txt_meta.getText().isEmpty()
                   || date.getDate() == null){
               JOptionPane.showMessageDialog(panel_savetest, "Provide All Details");
               return;
           }
           else{
               try{
                   bloodcount = Integer.parseInt(txt_bloodcount.getText());
                   if(bloodcount < 4500){
                       JOptionPane.showMessageDialog(panel_savetest, "Bllod count should be more than 4500");
                       return;
                   }
               }
               catch(Exception e){
                   JOptionPane.showMessageDialog(panel_savetest, "Enter Correct Blood Count");
                   return;
               }
               try{
                   haemoglobin = Double.parseDouble(txt_haemoglobin.getText());
                   
               }
               catch(Exception e){
                   JOptionPane.showMessageDialog(panel_savetest, "Enter Correct haemoglobint");
                   return;
               }
                try{
                   cholestrol = Double.parseDouble(txt_chol.getText());  
               }
               catch(Exception e){
                   JOptionPane.showMessageDialog(panel_savetest, "Enter Correct cholestrol");
                   return;
               }
               try{
                   hdl = Double.parseDouble(txt_hdl.getText());  
               }
               catch(Exception e){
                   JOptionPane.showMessageDialog(panel_savetest, "Enter Correct HDL");
                   return;
               }
               try{
                   ldl = Double.parseDouble(txt_ldl.getText());  
               }
               catch(Exception e){
                   JOptionPane.showMessageDialog(panel_savetest, "Enter Correct LDl");
                   return;
               }
               try{
                   dopamine = Integer.parseInt(txt_dopamine.getText());
                  
               }
               catch(Exception e){
                   JOptionPane.showMessageDialog(panel_savetest, "Enter Correct Dopamine Value");
                   return;
               }
               try{
                   metanephrine = Double.parseDouble(txt_meta.getText());
                   
               }
               catch(Exception e){
                   JOptionPane.showMessageDialog(panel_savetest, "Enter Correct Metanephrine Value");
                   return;
               }
               
               for(Child c:business.getChildDirectory().getChildlist()){
                    if(c.getUsername().equals(childval.getUsername())){
                        ChildLabTests clt = c.addChildLabTest();
                        clt.setBloodcount(bloodcount);
                        clt.setHaemoglobin(haemoglobin);
                        clt.setCholestrol(cholestrol);
                        clt.setHdl(hdl);
                        clt.setLdl(ldl);
                        clt.setGlucose(glucose);
                        clt.setLabtestdate(date.getDate());
                        clt.setIs_bloodTestRequired(true);
                        clt.setIs_urineTestRequired(true);
                        labTest(c,clt);
                        
                }
               }
               
               for(Child c:childval.getOrg().getChildDirectory().getChildlist()){
                    if(c.getUsername().equals(childval.getUsername())){
                        ChildLabTests clt = c.addChildLabTest();
                        clt.setBloodcount(bloodcount);
                        clt.setHaemoglobin(haemoglobin);
                        clt.setCholestrol(cholestrol);
                        clt.setHdl(hdl);
                        clt.setLdl(ldl);
                        clt.setGlucose(glucose);
                        clt.setDopamine(dopamine);
                        clt.setMetanephrine(metanephrine);
                        clt.setLabtestdate(date.getDate());
                        clt.setIs_bloodTestRequired(true);
                        clt.setIs_urineTestRequired(true);
                        labTest(c,clt);
                        
                }
               }

           }
           JOptionPane.showMessageDialog(panel_savetest, "Test Saved");
           populateTables();
           //checkTableVisisbility();
           
           workRequest.setReceiver(account);
           workRequest.setStatus("LabTest Done");
           workRequest.setChild(childval);
           workRequest.setMessage("LabTest Done");

           txt_bloodcount.setText("");
           txt_haemoglobin.setText("");
           txt_chol.setText("");
           txt_hdl.setText("");
           txt_ldl.setText("");
           txt_glucose.setText("");
           date.setDate(null);
           txt_dopamine.setText("");
           txt_meta.setText("");
       }
       checkLabTestDone();
    }//GEN-LAST:event_btn_svaetestActionPerformed
    
    public void labTest(Child child,ChildLabTests clt){
        int age = child.getAge();
 
        if(txt_testname.getText().equals("Blood Test")){
            if(age > 0 && age <= 3){
            if(bloodcount >= 10000 && bloodcount <= 15000){
                clt.setIsbloodcountnormal(true);
            }
            else{
                clt.setIsbloodcountnormal(false);
            }
        }
        if(age >= 4 && age <= 7){
            if(bloodcount >= 6000 && bloodcount <= 15000){
                clt.setIsbloodcountnormal(true);
            }
            else{
                clt.setIsbloodcountnormal(false);
            }
        }
        if(age > 8 && age < 12){
            if(bloodcount >= 4500 && bloodcount <= 13500){
                clt.setIsbloodcountnormal(true);
            }
            else{
                clt.setIsbloodcountnormal(false);
            }
        }
        
        if(age >= 0 && age < 1){
            if(haemoglobin >= 13.5 && haemoglobin <= 20){
                clt.setIshaemoglobinNormal(true);
            }
            else{
                clt.setIshaemoglobinNormal(false);
            }
        }
        
        if(age >= 0 && age < 2){
            if(haemoglobin >= 10.5 && haemoglobin <= 13.5){
                clt.setIshaemoglobinNormal(true);
            }
            else{
                clt.setIshaemoglobinNormal(false);
            }
        }
        if(age >= 2 && age < 6){
            if(haemoglobin >= 11.5 && haemoglobin <= 13.5){
                clt.setIshaemoglobinNormal(true);
            }
            else{
                clt.setIshaemoglobinNormal(false);
            }
        }
        
        if(age >= 6 && age < 12){
            if(haemoglobin >= 11.5 && haemoglobin <= 13.5){
                clt.setIshaemoglobinNormal(true);
            }
            else{
                clt.setIshaemoglobinNormal(false);
            }
        }
        
        if(age >= 0 && age <= 12){
            if(cholestrol < 170){
                clt.setIscholnormal(true);
            }
            else{
                clt.setIscholnormal(false);
            }
        }
        if(age >= 0 && age <= 12){
            if(hdl > 45){
                clt.setIshdlnormal(true);
            }
            else{
                clt.setIshdlnormal(false);
            }
        }
        
        if(age >= 0 && age <= 12){
            if(ldl < 100){
                clt.setIsldlnormal(true);
            }
            else{
                clt.setIsldlnormal(false);
            }
        }
        
        if(age >= 0 && age < 6){
            if(glucose < 100 && glucose > 180){
                clt.setIsglucosenormal(true);
            }
            else{
                clt.setIsglucosenormal(false);
            }
        }
        if(age >= 6 && age <= 12){
            if(glucose < 90 && glucose > 180){
                clt.setIsglucosenormal(true);
            }
            else{
                clt.setIsglucosenormal(false);
            }
        }
        
        if(clt.isIsglucosenormal() && clt.isIshdlnormal() && clt.isIsldlnormal()
                && clt.isIsbloodcountnormal() && clt.isIscholnormal()){
            clt.setIsBloodTestNormal(true);
        }
        }
        
        else if(txt_testname.getText().equals("Urine Test")){
            if(age >= 0 && age <= 12){
            if(dopamine < 65 && dopamine > 610){
                clt.setIsdopaminenormal(true);
            }
            else{
                clt.setIsdopaminenormal(false);
            }
        }
        
        if(age >= 0 && age <= 12){
            if(dopamine < 35 && dopamine > 460){
                clt.setIsmetnormal(true);
            }
            else{
                clt.setIsmetnormal(false);
            }
        }
 
        if(clt.isIsdopaminenormal() && clt.isIsmetnormal()){
              clt.setIsUrineTestNormal(true);
        }
        }
        else if(txt_testname.getText().equals("Blood" + " AND " + "URINE TEST")){
            if(age > 0 && age <= 3){
            if(bloodcount >= 10000 && bloodcount <= 15000){
                clt.setIsbloodcountnormal(true);
            }
            else{
                clt.setIsbloodcountnormal(false);
            }
        }
        if(age >= 4 && age <= 7){
            if(bloodcount >= 6000 && bloodcount <= 15000){
                clt.setIsbloodcountnormal(true);
            }
            else{
                clt.setIsbloodcountnormal(false);
            }
        }
        if(age > 8 && age < 12){
            if(bloodcount >= 4500 && bloodcount <= 13500){
                clt.setIsbloodcountnormal(true);
            }
            else{
                clt.setIsbloodcountnormal(false);
            }
        }
        
        if(age >= 0 && age < 1){
            if(haemoglobin >= 13.5 && haemoglobin <= 20){
                clt.setIshaemoglobinNormal(true);
            }
            else{
                clt.setIshaemoglobinNormal(false);
            }
        }
        
        if(age >= 0 && age < 2){
            if(haemoglobin >= 10.5 && haemoglobin <= 13.5){
                clt.setIshaemoglobinNormal(true);
            }
            else{
                clt.setIshaemoglobinNormal(false);
            }
        }
        if(age >= 2 && age < 6){
            if(haemoglobin >= 11.5 && haemoglobin <= 13.5){
                clt.setIshaemoglobinNormal(true);
            }
            else{
                clt.setIshaemoglobinNormal(false);
            }
        }
        
        if(age >= 6 && age < 12){
            if(haemoglobin >= 11.5 && haemoglobin <= 13.5){
                clt.setIshaemoglobinNormal(true);
            }
            else{
                clt.setIshaemoglobinNormal(false);
            }
        }
        
        if(age >= 0 && age <= 12){
            if(cholestrol < 170){
                clt.setIscholnormal(true);
            }
            else{
                clt.setIscholnormal(false);
            }
        }
        if(age >= 0 && age <= 12){
            if(hdl > 45){
                clt.setIshdlnormal(true);
            }
            else{
                clt.setIshdlnormal(false);
            }
        }
        
        if(age >= 0 && age <= 12){
            if(ldl < 100){
                clt.setIsldlnormal(true);
            }
            else{
                clt.setIsldlnormal(false);
            }
        }
        if(age >= 0 && age <= 12){
            if(dopamine < 65 && dopamine > 610){
                clt.setIsdopaminenormal(true);
            }
            else{
                clt.setIsdopaminenormal(false);
            }
        }
        
        if(age >= 0 && age <= 12){
            if(dopamine < 35 && dopamine > 460){
                clt.setIsmetnormal(true);
            }
            else{
                clt.setIsmetnormal(false);
            }
        }
        if(age >= 0 && age < 6){
            if(glucose < 100 && glucose > 180){
                clt.setIsglucosenormal(true);
            }
            else{
                clt.setIsglucosenormal(false);
            }
        }
        if(age >= 6 && age <= 12){
            if(glucose < 90 && glucose > 180){
                clt.setIsglucosenormal(true);
            }
            else{
                clt.setIsglucosenormal(false);
            }
        }
        if(clt.isIsglucosenormal() && clt.isIshdlnormal() && clt.isIsldlnormal()
                 && clt.isIsbloodcountnormal() && clt.isIscholnormal()
                 && clt.isIsdopaminenormal() && clt.isIsmetnormal()){
            clt.setIsBloodTestNormal(true);
            clt.setIsUrineTestNormal(true);
            }
        }
        
    }
    
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        goback();
    }//GEN-LAST:event_backActionPerformed
    public void goback(){
        userProcessContainer.remove(this);
        Component[] componentArray = rightpanel1.getComponents();
        Component component = componentArray[componentArray.length - 1];
        LabortaryAssistantWorkRequest panel = (LabortaryAssistantWorkRequest) component;
        panel.populateTable();
        CardLayout layout = (CardLayout) rightpanel1.getLayout();
        layout.previous(rightpanel1);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton btn_seereport;
    private javax.swing.JButton btn_svaetest;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel lab_testunder;
    private javax.swing.JPanel panel_blood;
    private javax.swing.JPanel panel_savetest;
    private javax.swing.JPanel panel_seeReport;
    private javax.swing.JPanel panel_singleparent;
    private javax.swing.JPanel panel_tbl_blood;
    private javax.swing.JPanel panel_tbl_urine;
    private javax.swing.JPanel panel_urine;
    private javax.swing.JTable tbl_blood;
    private javax.swing.JTable tbl_urine;
    private javax.swing.JTextField txt_about;
    private javax.swing.JTextField txt_age;
    private javax.swing.JTextField txt_agency;
    private javax.swing.JTextField txt_bloodcount;
    private javax.swing.JTextField txt_chol;
    private javax.swing.JTextField txt_city;
    private javax.swing.JTextField txt_dopamine;
    private javax.swing.JTextField txt_firstname;
    private javax.swing.JTextField txt_gender;
    private javax.swing.JTextField txt_glucose;
    private javax.swing.JTextField txt_haemoglobin;
    private javax.swing.JTextField txt_hdl;
    private javax.swing.JTextField txt_lastname;
    private javax.swing.JTextField txt_ldl;
    private javax.swing.JTextField txt_message;
    private javax.swing.JTextField txt_meta;
    private javax.swing.JTextField txt_testname;
    // End of variables declaration//GEN-END:variables
}
