/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Patient;

import java.awt.CardLayout;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
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
public class ManagePatientJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManagePatientJPanel
     */
    City city;
    JPanel workarea;
    public ManagePatientJPanel(JPanel workarea,City city) {
        initComponents();
        this.city = city;
        this.workarea = workarea;
        
        loadpeople();
        loadPatients();
    }
    
    public void loadpeople(){
        DefaultTableModel model = (DefaultTableModel)tbl_persons.getModel();
        model.setRowCount(0);
        
        for(City c:city.getCitylist()){
            for(Community comm:c.getCommunitylist()){
                for(House h:comm.getHouselist()){
                    for(Person p:h.getPersonlist()){
                        Object row[]= new Object[1];
                        row[0] = p;
                        model.addRow(row);
                    }
                }
            }
        }
    }
    
    public void loadPatients(){
        //JOptionPane.showMessageDialog(tbl_patient, "h1");
        DefaultTableModel model = (DefaultTableModel)tbl_patient.getModel();
        model.setRowCount(0);
        
        for(City c:city.getCitylist()){
            //JOptionPane.showMessageDialog(tbl_patient, "h2");
            for(Community comm:c.getCommunitylist()){
                //JOptionPane.showMessageDialog(tbl_patient, "h3");
                for(House h:comm.getHouselist()){
                    //JOptionPane.showMessageDialog(tbl_patient, "h4");
                    for(Patient p1:h.getPatientlist()){
                        //JOptionPane.showMessageDialog(tbl_patient, "h5");
                        Object row[] = new Object[6];
                        row[0] = p1;
                        row[1] = p1.getAge();
                        row[2] = p1.getId();
                        row[3] = p1.getCity();
                        row[4] = p1.getCommunity();
                        row[5] = p1.getHouse();
                        model.addRow(row);
                    }
                }
            }
                
            }
        }
        
        
        
       /* DefaultTableModel model = (DefaultTableModel)tbl_patient.getModel();
        model.setRowCount(0);
        
        for(City c:city.getCitylist()){
            for(Community comm:c.getCommunitylist()){
                for(House h:comm.getHouselist()){
                    for(Person p:h.getPersonlist()){
                        for(Patient pat:p.getPatientlist()){
                            for(Encounter e:p.getEncounterhistory()){
                                JOptionPane.showMessageDialog(tbl_patient, "enc "+e.getEncounterhistory());
                                Object row[] = new Object[8];
                                row[0] = e.getDate();
                                row[1] = e.getDoctorname();
                                row[1] = comm;
                                row[2] = p.getName();
                                row[3] = p.getAge();
                                row[4] = pat.getVitalvalue();
                                row[5] = c;
                                row[6] = comm;
                                row[7] = checkbp(p.getAge(),pat.getVitalvalue());
                                
                                model.addRow(row);
                            }
                        }
                    }
                }
            }
        }
        
        
    }
    
    public String checkbp(int age, int vitalval){
      
      String status = "";
      
      if(age>=0 && age<=5){
          if(vitalval >= 70 && vitalval <=100){
            status = "normal";
            return status;
          }
      }
      else if(age>=6 && age<=12){
          if(vitalval <=80 && vitalval >= 120){
            status = "normal";
            return status;
          }
      }
      else if(age>=13 && age<=100){
          if(vitalval <=110 && vitalval >= 120){
            status = "normal";
            return status;
          }
      }
      else{
          status = "abnormal";
          return status;
      }
        
      return status;  
    }*/
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_persons = new javax.swing.JTable();
        btn_addvital1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_patient = new javax.swing.JTable();
        btn_viewpatients = new javax.swing.JButton();
        btn_addvital = new javax.swing.JButton();

        tbl_persons.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Person Name"
            }
        ));
        jScrollPane1.setViewportView(tbl_persons);

        btn_addvital1.setText("Add Patient");
        btn_addvital1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addvital1ActionPerformed(evt);
            }
        });

        tbl_patient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Age", "Id", "City", "Comm", "House"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbl_patient);

        btn_viewpatients.setText("View Patients");
        btn_viewpatients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewpatientsActionPerformed(evt);
            }
        });

        btn_addvital.setText("Add vital");
        btn_addvital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addvitalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_addvital)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btn_addvital1)
                            .addGap(18, 18, 18)
                            .addComponent(btn_viewpatients))
                        .addComponent(jScrollPane3)))
                .addContainerGap(250, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_addvital1)
                    .addComponent(btn_viewpatients))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btn_addvital)
                .addContainerGap(95, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addvital1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addvital1ActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel model = (DefaultTableModel)tbl_persons.getModel();
        int selectedrow = tbl_persons.getSelectedRow();
        //JOptionPane.showMessageDialog(jScrollPane1, selectedrow);
        if(selectedrow < 0){
            JOptionPane.showMessageDialog(jScrollPane1, "No Person Selected");
            return;
        }
        Person p = (Person) model.getValueAt(selectedrow, 0);
 
        AddPatient addPatient = new AddPatient(workarea,p.getHouse(),p);
        workarea.add("addvitals",addPatient);
        CardLayout layout = (CardLayout)workarea.getLayout();
        layout.next(workarea);
        
    }//GEN-LAST:event_btn_addvital1ActionPerformed

    private void btn_viewpatientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewpatientsActionPerformed
        // TODO add your handling code here:
        loadPatients();
    }//GEN-LAST:event_btn_viewpatientsActionPerformed

    private void btn_addvitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addvitalActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel model = (DefaultTableModel)tbl_patient.getModel();
        int selectedrow = tbl_patient.getSelectedRow();
        //JOptionPane.showMessageDialog(jScrollPane1, selectedrow);
        if(selectedrow < 0){
            JOptionPane.showMessageDialog(jScrollPane1, "No Patient Selected");
            return;
        }
        
        Patient patient = (Patient)model.getValueAt(selectedrow, 0);
 
        AddVitals addvitals = new AddVitals(workarea,patient);
        workarea.add("addvitals",addvitals);
        CardLayout layout = (CardLayout)workarea.getLayout();
        layout.next(workarea);
        
    }//GEN-LAST:event_btn_addvitalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addvital;
    private javax.swing.JButton btn_addvital1;
    private javax.swing.JButton btn_viewpatients;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbl_patient;
    private javax.swing.JTable tbl_persons;
    // End of variables declaration//GEN-END:variables
}
