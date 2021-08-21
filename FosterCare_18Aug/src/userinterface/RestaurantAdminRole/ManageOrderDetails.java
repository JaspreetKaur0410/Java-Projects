/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.RestaurantAdminRole;

import Business.DeliveryMan.DeliveryMan;
import Business.EcoSystem;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.Order;
import Business.WorkQueue.OrderItems;
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
public class ManageOrderDetails extends javax.swing.JPanel {

    /**
     * Creates new form ManageOrderDetails
     */
    JPanel userProcessContainer;
    EcoSystem system;
    UserAccount userAccount;
    Order workrequest;
    
    public ManageOrderDetails(JPanel userProcessContainer,EcoSystem system,UserAccount userAccount,Order workrequest) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.userAccount = userAccount;
        this.workrequest = workrequest;
        feedback_panel.setVisible(false);
        btn_acceptOrder.setVisible(false);
        btn_DeclineOrder.setVisible(false);
        btn_extra.setVisible(false);
        
        
        checkStatus();
        combo_delPerson.setEnabled(false);
        btn_assidel.setEnabled(false);
        
        if(workrequest.getStatus().equals("Delivered") && workrequest.getCustomerfeedback()!=null){
            feedback_panel.setVisible(true);
            txt_feedback.setText(workrequest.getCustomerfeedback());
        }
        
        displayAll();
        populateDelPersons();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void populateDelPersons(){
        combo_delPerson.removeAllItems();
        for(DeliveryMan dm:system.getDeliveryManDirectory().getDelmanlist()){
            combo_delPerson.addItem(dm.toString());
        }
    }
    
    public void checkStatus(){
        switch(workrequest.getStatus()){
            case "Order Placed":
                btn_acceptOrder.setVisible(true);
                btn_DeclineOrder.setVisible(true);
                break;
             case "Preparing":
               btn_acceptOrder.setVisible(false);
               btn_DeclineOrder.setVisible(false);
               btn_extra.setVisible(true);
               btn_extra.setText("Ready To Deliever");
               break;
             case "Ready To Deliever":
               btn_acceptOrder.setVisible(false);
               btn_DeclineOrder.setVisible(false);
               btn_extra.setVisible(true);
               break;
        }
       
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_delname = new javax.swing.JTextField();
        btn_assidel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_customername = new javax.swing.JTextField();
        txt_requestdate = new javax.swing.JTextField();
        txt_customeradd = new javax.swing.JTextField();
        txt_customermessage = new javax.swing.JTextField();
        combo_delPerson = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_status = new javax.swing.JTextField();
        btn_acceptOrder = new javax.swing.JButton();
        btn_DeclineOrder = new javax.swing.JButton();
        btn_extra = new javax.swing.JButton();
        btn_add3 = new javax.swing.JButton();
        feedback_panel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txt_feedback = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_items = new javax.swing.JTable();

        jPanel4.setBackground(new java.awt.Color(204, 255, 102));

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));
        jPanel5.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Assign DelieveryPerson");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("DelieveryPerson Name");

        btn_assidel.setBackground(new java.awt.Color(51, 51, 51));
        btn_assidel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_assidel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons1/user (3).png"))); // NOI18N
        btn_assidel.setText("ADD");
        btn_assidel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_assidelActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Customer Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Customer Address");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Request Date");

        txt_customername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_customernameActionPerformed(evt);
            }
        });

        txt_requestdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_requestdateActionPerformed(evt);
            }
        });

        txt_customeradd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_customeraddActionPerformed(evt);
            }
        });

        txt_customermessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_customermessageActionPerformed(evt);
            }
        });

        combo_delPerson.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_delPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_delPersonActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Special  Instructions");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo_delPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_assidel))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_customername, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(txt_customeradd)
                            .addComponent(txt_requestdate)
                            .addComponent(txt_customermessage)
                            .addComponent(txt_delname))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btn_assidel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_delPerson, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_delname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_customername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_customeradd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_requestdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txt_customermessage))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(204, 255, 204));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("                                                                        MANAGE ORDER DETAILS");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 958, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1284, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(204, 255, 204));
        jPanel7.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Total");

        txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Status");

        txt_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_statusActionPerformed(evt);
            }
        });

        btn_acceptOrder.setBackground(new java.awt.Color(51, 51, 51));
        btn_acceptOrder.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_acceptOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons1/login.png"))); // NOI18N
        btn_acceptOrder.setText("Accept Order");
        btn_acceptOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_acceptOrderActionPerformed(evt);
            }
        });

        btn_DeclineOrder.setBackground(new java.awt.Color(51, 51, 51));
        btn_DeclineOrder.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_DeclineOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons1/cancel.png"))); // NOI18N
        btn_DeclineOrder.setText("Decline Order");
        btn_DeclineOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeclineOrderActionPerformed(evt);
            }
        });

        btn_extra.setBackground(new java.awt.Color(51, 51, 51));
        btn_extra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_extra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons1/user (3).png"))); // NOI18N
        btn_extra.setText("Ready to Deliever");
        btn_extra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_extraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_total, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(txt_status))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 61, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_extra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_DeclineOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_acceptOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(80, 80, 80))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(btn_acceptOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_DeclineOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_extra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btn_add3.setBackground(new java.awt.Color(51, 51, 51));
        btn_add3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_add3.setForeground(new java.awt.Color(204, 255, 204));
        btn_add3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons1/user (3).png"))); // NOI18N
        btn_add3.setText("Back");
        btn_add3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add3ActionPerformed(evt);
            }
        });

        feedback_panel.setBackground(new java.awt.Color(204, 255, 204));
        feedback_panel.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Feedback");

        txt_feedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_feedbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout feedback_panelLayout = new javax.swing.GroupLayout(feedback_panel);
        feedback_panel.setLayout(feedback_panelLayout);
        feedback_panelLayout.setHorizontalGroup(
            feedback_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(feedback_panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(feedback_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedback_panelLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(113, 113, 113))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, feedback_panelLayout.createSequentialGroup()
                        .addComponent(txt_feedback, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
        );
        feedback_panelLayout.setVerticalGroup(
            feedback_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(feedback_panelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_feedback, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        tbl_items.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Item Name", "Item Quantity", "Item Size", "Price"
            }
        ));
        jScrollPane1.setViewportView(tbl_items);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_add3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(feedback_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_add3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(feedback_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_feedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_feedbackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_feedbackActionPerformed

    private void btn_add3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add3ActionPerformed
        // TODO add your handling code here:

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btn_add3ActionPerformed

    private void btn_extraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_extraActionPerformed
        // TODO add your handling code here:
        if(workrequest.getStatus().equals("Preparing")){
            checkStatus();
            workrequest.setStatus("Ready To Deliever");
            txt_status.setText(workrequest.getStatus());
            checkStatus();
        }
        if(workrequest.getStatus().equals("Ready To Deliever")){
            checkStatus();
            JOptionPane.showMessageDialog(feedback_panel, "Driver will pick up the order");
            btn_extra.setVisible(false);
        }
    }//GEN-LAST:event_btn_extraActionPerformed

    private void btn_DeclineOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeclineOrderActionPerformed
        // TODO add your handling code here:
        workrequest.setStatus("Declined");
        JOptionPane.showMessageDialog(jLabel8, "Order declined! Customer will be informed!");
        txt_customermessage.setText(workrequest.getStatus());
        btn_acceptOrder.setVisible(false);
        btn_DeclineOrder.setVisible(false);
    }//GEN-LAST:event_btn_DeclineOrderActionPerformed

    private void btn_acceptOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_acceptOrderActionPerformed
        // TODO add your handling code here:
        if(workrequest.getDeliveryMan() == null){
            JOptionPane.showMessageDialog(feedback_panel, "You can now assign Delievery person");
            btn_assidel.setEnabled(true);
            combo_delPerson.setEnabled(true);
        }
        else if(workrequest.getDeliveryMan() != null){
            btn_assidel.setEnabled(false);
            combo_delPerson.setEnabled(false);
        }
       
        if(workrequest.getStatus().equalsIgnoreCase("Order Placed")){
            checkStatus();
            workrequest.setStatus("Preparing");
            txt_status.setText(workrequest.getStatus());
            //btn_assidel.setEnabled(true);
            for(DeliveryMan dm:system.getDeliveryManDirectory().getDelmanlist()){
                workrequest.setDeliveryMan(dm);
            }
            checkStatus();
        }
        else if(workrequest.getStatus().equals("Preparing")){
            checkStatus();
            workrequest.setStatus("Ready To Deliever");
            txt_status.setText(workrequest.getStatus());
            checkStatus();
        }
        
        else if(workrequest.getStatus().equals("Ready To Deliever")){
            checkStatus();
            workrequest.setStatus("Ready To Deliever");
            txt_status.setText(workrequest.getStatus());
            checkStatus();
        }
       
        else if(workrequest.getStatus().equals("Delivered")){
            btn_DeclineOrder.setVisible(false);
            btn_acceptOrder.setVisible(false);
            //workrequest.setStatus("Delievered");
            txt_customermessage.setText(workrequest.getStatus());
            feedback_panel.setVisible(true);
            txt_feedback.setText(workrequest.getCustomerfeedback());
        }
        

    }//GEN-LAST:event_btn_acceptOrderActionPerformed

    private void txt_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_statusActionPerformed

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalActionPerformed

    private void combo_delPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_delPersonActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_combo_delPersonActionPerformed

    private void txt_customermessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_customermessageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_customermessageActionPerformed

    private void txt_customeraddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_customeraddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_customeraddActionPerformed

    private void txt_requestdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_requestdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_requestdateActionPerformed

    private void txt_customernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_customernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_customernameActionPerformed

    private void btn_assidelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_assidelActionPerformed
        // TODO add your handling code here:
        for(DeliveryMan dm:system.getDeliveryManDirectory().getDelmanlist()){
            if(String.valueOf(dm.getUsername()).equals(String.valueOf(combo_delPerson.getSelectedItem())))
            {
                workrequest.setDeliveryMan(dm);
                JOptionPane.showMessageDialog(null, "Delivery person assigned successfully!!!");
                displayAll();
            }
        }

    }//GEN-LAST:event_btn_assidelActionPerformed
    
    public void displayAll(){
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
        Date myDate = workrequest.getRequestDate();
        String datetime = dateformat.format(myDate);
        
        txt_delname.setText(String.valueOf(workrequest.getDeliveryMan()));
        txt_customername.setText(String.valueOf(workrequest.getCustomer().getName()));
        txt_customermessage.setText(String.valueOf(workrequest.getMessage()));
        txt_customeradd.setText(String.valueOf(workrequest.getCustomer().getAddress()));
        txt_requestdate.setText(String.valueOf(workrequest.getRequestDate()));
        txt_customermessage.setText(workrequest.getMessage());
        txt_status.setText(workrequest.getStatus());
        displayTable();
        
    }
    public void displayTable(){
        Double total = 0.0;
        DefaultTableModel model = (DefaultTableModel)tbl_items.getModel();
        model.setRowCount(0);
        //SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");
   
         for(OrderItems oi:workrequest.getOrderitemlist()){
             Object[] row = new Object[tbl_items.getColumnCount()];
             row[0] = oi.getItem().getItemname();
             row[1] = oi.getQuantity();
             row[2] = oi.getSize();
             row[3] = oi.getItem().getItemprice() * oi.getQuantity();
             total += oi.getItem().getItemprice() * oi.getQuantity();
             model.addRow(row);
         }
         txt_total.setText(String.valueOf(total));
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_DeclineOrder;
    private javax.swing.JButton btn_acceptOrder;
    private javax.swing.JButton btn_add3;
    private javax.swing.JButton btn_assidel;
    private javax.swing.JButton btn_extra;
    private javax.swing.JComboBox<String> combo_delPerson;
    private javax.swing.JPanel feedback_panel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_items;
    private javax.swing.JTextField txt_customeradd;
    private javax.swing.JTextField txt_customermessage;
    private javax.swing.JTextField txt_customername;
    private javax.swing.JTextField txt_delname;
    private javax.swing.JTextField txt_feedback;
    private javax.swing.JTextField txt_requestdate;
    private javax.swing.JTextField txt_status;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}