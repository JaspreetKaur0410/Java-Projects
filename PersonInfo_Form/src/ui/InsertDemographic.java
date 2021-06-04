/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import javax.swing.JOptionPane;
import model.PersonInfo;

/**
 *
 * @author jaspr
 */
public class InsertDemographic extends javax.swing.JPanel {

    /**
     * Creates new form InsertDemographic
     */
    
    PersonInfo personalinfo;
            
    public InsertDemographic(PersonInfo personalinfo) {
        initComponents();
        this.personalinfo = personalinfo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalModel1 = new com.jcalendar.model.JCalModel();
        jCalModel2 = new com.jcalendar.model.JCalModel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Age = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_firstname = new javax.swing.JTextField();
        txt_phonenumber = new javax.swing.JTextField();
        txt_age = new javax.swing.JTextField();
        txt_height = new javax.swing.JTextField();
        txt_weight = new javax.swing.JTextField();
        txt_ssn = new javax.swing.JTextField();
        txt_lastname = new javax.swing.JTextField();
        btn_insert = new javax.swing.JButton();
        datechooser = new com.toedter.calendar.JDateChooser();
        btn_clear = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(773, 698));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("INSERT DEMOGRAPHIC INFORMATION");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("First Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Date Of Birth");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Height");

        Age.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Age.setText("Age");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Weight");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("SSN");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Last Name");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Phone Number");

        txt_phonenumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_phonenumberActionPerformed(evt);
            }
        });

        txt_age.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_ageMouseClicked(evt);
            }
        });
        txt_age.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ageActionPerformed(evt);
            }
        });

        txt_height.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_heightActionPerformed(evt);
            }
        });

        txt_weight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_weightActionPerformed(evt);
            }
        });

        btn_insert.setText("Click to Insert");
        btn_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertActionPerformed(evt);
            }
        });

        datechooser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datechooserMouseClicked(evt);
            }
        });
        datechooser.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                datechooserInputMethodTextChanged(evt);
            }
        });
        datechooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                datechooserPropertyChange(evt);
            }
        });

        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Age, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(199, 199, 199)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_age)
                    .addComponent(txt_lastname)
                    .addComponent(txt_firstname)
                    .addComponent(txt_phonenumber, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_height)
                    .addComponent(txt_weight, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_ssn)
                    .addComponent(datechooser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
                .addGap(68, 68, 68))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(304, 304, 304)
                        .addComponent(btn_insert)
                        .addGap(62, 62, 62)
                        .addComponent(btn_clear)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txt_firstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_phonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(datechooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Age)
                    .addComponent(txt_age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_height, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_weight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_ssn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(105, 105, 105)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_insert)
                    .addComponent(btn_clear))
                .addContainerGap(527, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_phonenumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_phonenumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_phonenumberActionPerformed

    private void btn_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertActionPerformed
        // TODO add your handling code here:
        
        //CONVERT LOCAL DATE TO DATE
        LocalDateTime now = LocalDateTime.now();
        ZoneId defaultzoneid = ZoneId.systemDefault();
        ZonedDateTime zdt = now.atZone(defaultzoneid);
        Date to_Date_now = Date.from(zdt.toInstant());
        
         String firstname = txt_firstname.getText();
         String lastname = txt_lastname.getText();
         String phone = String.valueOf(txt_phonenumber.getText());
         //Date selectDate = calendarpane.
         
         String dateofbirth = String.valueOf(datechooser.getDate());
         
         /*LocalDate today = LocalDate.now();
         Period p;
         
         ZoneId defaultzoneid = ZoneId.systemDefault();
         Instant instant = datechooser.getDate().toInstant();
         p = Period.between(instant.atZone(defaultzoneid).toLocalDate(),today);*/
         
         
         String age = String.valueOf(txt_age.getText());
         String height = String.valueOf(txt_height.getText());
         String weight = String.valueOf(txt_weight.getText());
         String ssn = String.valueOf(txt_ssn.getText());
         
         //regex
         String alphabets_regex = "^[a-zA-Z]*$";
         String digit_regex = "[0-9]+";

         
         if(firstname.equals("") || lastname.equals("") || phone.equals("")
            || age.equals("") || height.equals("") || weight.equals("") || ssn.equals("")){
             JOptionPane.showMessageDialog(datechooser, "Please Enter all information");
         }
         else if(!txt_firstname.getText().matches(alphabets_regex) || !txt_lastname.getText().matches(alphabets_regex)){
             JOptionPane.showMessageDialog(datechooser, "Please enter correct name");
         }
         
         else if(!txt_phonenumber.getText().matches(digit_regex)){
             JOptionPane.showMessageDialog(datechooser, "Please enter correct phone number");
         }
         
         else if(!txt_phonenumber.getText().matches("\\d{10}")){
             JOptionPane.showMessageDialog(datechooser, "Please enter 10-digit phone number");
         }
          else if(datechooser.getDate().after(to_Date_now)){
             JOptionPane.showMessageDialog(datechooser, "Please choose correct DOB");
         }
         
         else if(!txt_age.getText().matches(digit_regex)){
             JOptionPane.showMessageDialog(datechooser, "Please enter correct age");
         }
       
         else if(!txt_height.getText().matches(digit_regex)){
             JOptionPane.showMessageDialog(datechooser, "Please enter correct height");
             
         }
         else if(!txt_weight.getText().matches(digit_regex)){
             JOptionPane.showMessageDialog(datechooser, "Please enter correct weight");
         }
         else if(!txt_ssn.getText().matches(digit_regex)){
             JOptionPane.showMessageDialog(datechooser, "Please enter correct ssn");
         }
         
         else{
         
            personalinfo.setFirstname(firstname);
            personalinfo.setLastname(lastname);
            personalinfo.setPhone( Long.parseLong(phone));
            personalinfo.setAge(Integer.parseInt(age));
            personalinfo.setHeight(Integer.parseInt(height));
            personalinfo.setWeight(Integer.parseInt(weight));
            personalinfo.setSsn(Integer.parseInt(ssn));
            personalinfo.setDateofbirth(datechooser.getDate());
            JOptionPane.showMessageDialog(btn_insert, "Demographic information inserted");
         }
         
         
    }//GEN-LAST:event_btn_insertActionPerformed

    private void txt_weightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_weightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_weightActionPerformed

    private void txt_ageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ageActionPerformed
        // TODO add your handling code here:
        

    }//GEN-LAST:event_txt_ageActionPerformed

    private void txt_heightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_heightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_heightActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:
        
        txt_firstname.setText("");
         txt_lastname.setText("");
         txt_phonenumber.setText("");
         txt_age.setText("");
         txt_height.setText("");
         txt_weight.setText("");
         txt_ssn.setText("");
         datechooser.setCalendar(null);
    }//GEN-LAST:event_btn_clearActionPerformed

    private void datechooserInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_datechooserInputMethodTextChanged
        // TODO add your handling code here:
        
        
                
    }//GEN-LAST:event_datechooserInputMethodTextChanged

    private void datechooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_datechooserPropertyChange
        // TODO add your handling code here:
        
    
    }//GEN-LAST:event_datechooserPropertyChange

    private void datechooserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datechooserMouseClicked
       
    }//GEN-LAST:event_datechooserMouseClicked

    private void txt_ageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ageMouseClicked
        // TODO add your handling code here:
        
        //CONVERT LOCAL DATE TO DATE
        LocalDateTime now = LocalDateTime.now();
        ZoneId defaultzoneid = ZoneId.systemDefault();
        ZonedDateTime zdt = now.atZone(defaultzoneid);
        Date to_Date_now = Date.from(zdt.toInstant());
        
         String dateofbirth = String.valueOf(datechooser.getDate());
         
         LocalDate today = LocalDate.now();
         Period p;
         
         Instant instant = datechooser.getDate().toInstant();
         p = Period.between(instant.atZone(defaultzoneid).toLocalDate(),today);
         txt_age.setText(String.valueOf(p.getYears()));
         
         //CHECK IF DOB is before now()
         if(datechooser.getDate().before(to_Date_now)){
            //JOptionPane.showMessageDialog(datechooser, "Hello");
            personalinfo.setAge(p.getYears());
         }
         else{
             JOptionPane.showMessageDialog(datechooser,"ERROR! Incorrect DOB!");
         }
    }//GEN-LAST:event_txt_ageMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Age;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_insert;
    private com.toedter.calendar.JDateChooser datechooser;
    private com.jcalendar.model.JCalModel jCalModel1;
    private com.jcalendar.model.JCalModel jCalModel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txt_age;
    private javax.swing.JTextField txt_firstname;
    private javax.swing.JTextField txt_height;
    private javax.swing.JTextField txt_lastname;
    private javax.swing.JTextField txt_phonenumber;
    private javax.swing.JTextField txt_ssn;
    private javax.swing.JTextField txt_weight;
    // End of variables declaration//GEN-END:variables
}
