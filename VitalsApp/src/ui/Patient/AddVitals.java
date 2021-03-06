/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Patient;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.City;
import model.Community;
import model.Encounter;
import model.House;
import model.Patient;
import model.Person;

/**
 *
 * @author jaspr
 */
public class AddVitals extends javax.swing.JPanel {

    /**
     * Creates new form AddVitals
     */
    
    JPanel workarea;
    Patient patient;
    Encounter encounter;
    public AddVitals(JPanel workarea, Patient patient) {
        initComponents();
        this.workarea = workarea;
        this.patient = patient;
        
        txt_person_name.setText(String.valueOf(patient.getName()));
        txt_city.setText(String.valueOf(patient.getCity()));
        txt_person_age.setText(String.valueOf(patient.getAge()));
        txt_city.setText(String.valueOf(patient.getCity()));
        txt_comm.setText(String.valueOf(patient.getCommunity()));
        txt_house.setText(String.valueOf(patient.getHouse()));
        
        //JOptionPane.showMessageDialog(combosign, person.getName() );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_city = new javax.swing.JTextField();
        txt_person_age = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_vitalsignvalue = new javax.swing.JTextField();
        combosign = new javax.swing.JComboBox<>();
        btn_add_patient = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        txt_doctor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_person_name = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_comm = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_house = new javax.swing.JTextField();
        btn_viewdetails = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Patient Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Vital Sign");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Patient Age");

        txt_city.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cityActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Vital Value");

        txt_vitalsignvalue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_vitalsignvalueActionPerformed(evt);
            }
        });

        combosign.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Sign", "BP" }));
        combosign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combosignActionPerformed(evt);
            }
        });

        btn_add_patient.setText("Add Vital");
        btn_add_patient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_patientActionPerformed(evt);
            }
        });

        back.setText("back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Doctor Name");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Date");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("City");

        txt_person_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_person_nameActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Comm");

        txt_comm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_commActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Patient House");

        txt_house.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_houseActionPerformed(evt);
            }
        });

        btn_viewdetails.setText("View Details");
        btn_viewdetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewdetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(469, 469, 469)
                        .addComponent(txt_city, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(35, 35, 35)
                                .addComponent(txt_vitalsignvalue, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_add_patient)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_viewdetails))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combosign, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_doctor, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_person_name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_comm, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_house, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(txt_person_age, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back)
                    .addComponent(jLabel1)
                    .addComponent(txt_person_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txt_person_age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txt_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_comm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txt_house, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_doctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(combosign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_vitalsignvalue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add_patient)
                    .addComponent(btn_viewdetails))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_add_patientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_patientActionPerformed
        // TODO add your handling code here:
        
        if(patient.getEncounterhistory().isEmpty()){
            Encounter encounter = patient.addencounter();
            encounter.setDate(date.getDate());
            encounter.setDoctorname(String.valueOf(txt_doctor.getText()));
            encounter.setVitalsign(String.valueOf(combosign.getSelectedItem()));
            encounter.setVitalval(Integer.parseInt(txt_vitalsignvalue.getText()));
            encounter.setPatient(patient);

            JOptionPane.showMessageDialog(combosign, "Encouter Details Added");
        }
        
        else if(!patient.getEncounterhistory().isEmpty()){
            /*for(Encounter en:patient.getEncounterhistory()){
            JOptionPane.showMessageDialog(combosign, en.getDate());
        }*/
            for(int i=0;i<patient.getEncounterhistory().size();i++){
                int j=patient.getEncounterhistory().size()-1;
                if(date.getDate().after(patient.getEncounterhistory().get(j).getDate())){
                        boolean check = checkdateexist();
                        if(check == false){
                        Encounter encounter = patient.addencounter();
                        encounter.setDate(date.getDate());
                        encounter.setDoctorname(String.valueOf(txt_doctor.getText()));
                        encounter.setVitalsign(String.valueOf(combosign.getSelectedItem()));
                        encounter.setVitalval(Integer.parseInt(txt_vitalsignvalue.getText()));
                        encounter.setPatient(patient);
                        
                        JOptionPane.showMessageDialog(combosign,
                                encounter.getDate()+ " " +" Encouter Details Added");
                        return;
                        }
                }
                
                else if(date.getDate().before(patient.getEncounterhistory().get(i).getDate()) || 
                        date.getDate().equals(patient.getEncounterhistory().get(i).getDate())){
                    JOptionPane.showMessageDialog(combosign, "Date is incorrect");
                    return;
                }
                
            }
            
        }
       
        
    }//GEN-LAST:event_btn_add_patientActionPerformed

        public boolean checkdateexist(){
            
            for(Encounter en:patient.getEncounterhistory()){
                if(en.getDate().equals(date.getDate())){
                    return true;
                }
            }
            return false;
        }
    
    private void txt_vitalsignvalueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_vitalsignvalueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_vitalsignvalueActionPerformed

    private void combosignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combosignActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combosignActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        workarea.remove(this);
        CardLayout layout = (CardLayout)workarea.getLayout();
        layout.previous(workarea);
    }//GEN-LAST:event_backActionPerformed

    private void txt_cityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cityActionPerformed

    private void btn_viewdetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewdetailsActionPerformed
        // TODO add your handling code here:
        
        ViewDetails viewdetails = new ViewDetails(workarea,patient);
        workarea.add("viewdetails",viewdetails);
        CardLayout layout = (CardLayout)workarea.getLayout();
        layout.next(workarea); 
        
    }//GEN-LAST:event_btn_viewdetailsActionPerformed

    private void txt_houseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_houseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_houseActionPerformed

    private void txt_commActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_commActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_commActionPerformed

    private void txt_person_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_person_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_person_nameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton btn_add_patient;
    private javax.swing.JButton btn_viewdetails;
    private javax.swing.JComboBox<String> combosign;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txt_city;
    private javax.swing.JTextField txt_comm;
    private javax.swing.JTextField txt_doctor;
    private javax.swing.JTextField txt_house;
    private javax.swing.JTextField txt_person_age;
    private javax.swing.JTextField txt_person_name;
    private javax.swing.JTextField txt_vitalsignvalue;
    // End of variables declaration//GEN-END:variables
}
