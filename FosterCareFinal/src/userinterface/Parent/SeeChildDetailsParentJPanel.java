/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Parent;

import Business.Child.Child;
import Business.EcoSystem;
import Business.Organization.Organization;
import Business.Parent.Parent;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ParentWorkRequest;
import Business.WorkQueue.ReinbursementsWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import userinterface.FosterAdmin.ListOfChildrenJPanel;

/**
 *
 * @author jaspr
 */
public class SeeChildDetailsParentJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SeeChildDetailsParentJPanel
     */
    EcoSystem business;
    Child child;
    ListOfChildrenJPanel listofchildrenjpanel;
    JPanel userProcessContainer;
    Parent parent;
    JPanel rightpanel;
    
    public SeeChildDetailsParentJPanel(JPanel userProcessContainer,EcoSystem business, 
                                        Child child,Parent parent,JPanel rightpanel) {
        initComponents();
        this.business = business;
        this.child = child;
        this.userProcessContainer = userProcessContainer;
        this.parent = parent;
        this.rightpanel = rightpanel;
        //JOptionPane.showMessageDialog(combo_age, child.getGender());
        
        txt_about1.setText(child.getAbout_child());
        
        txt_firstname1.setText(child.getFirstname());
        txt_religion1.setText(child.getLastname());
        txt_city1.setText(child.getCity());
        txt_age1.setText(String.valueOf(child.getAge()));
        txt_gender1.setText(String.valueOf(child.getGender()));
        txt_race1.setText(child.getRace());
        txt_religion1.setText(child.getReligion());
        txt_lastname1.setText(child.getLastname());
        displayImage();
        
        txt_about1.setEnabled(false);
        
        txt_firstname1.setEnabled(false);
        txt_religion1.setEnabled(false);
        txt_city1.setEnabled(false);
        txt_age1.setEnabled(false);
        txt_gender1.setEnabled(false);
        txt_race1.setEnabled(false);
        txt_religion1.setEnabled(false);
        txt_lastname1.setEnabled(false);
        isadopted.setVisible(false);
        btn_requestreim.setVisible(false);
        
        txt_lastrofileupdated1.setText(String.valueOf(child.getLast_profileupdated()));
        
        lbl1.setVisible(false);
        lbl2.setVisible(false);
        
        setStatus();
        
        if(child.isIsAdopted()){
            isadopted.setVisible(true);
            btn_adopt.setVisible(false);
        }
        if(child.isIsAdopted() && child.getParent().equals(parent)){
            btn_requestreim.setVisible(true);
        }
    }
    
    public void displayImage() {
        BufferedImage image = null;
        String filename = child.getImage();
        try {
            image = ImageIO.read(new File(filename));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "File not found");
        }
        ImageIcon icon = new ImageIcon(image);
        lbl_photo.setIcon(icon);
    }
    
    
    public void hiderequestrein(){
        btn_requestreim.setEnabled(false);
    }
    
    public void setStatus(){
        if(parent.isFlag() == true){
            btn_adopt.setVisible(false);
            lbl1.setVisible(true);
            lbl2.setVisible(false);
        }
        else if(parent.isFlag() == false){
            btn_adopt.setEnabled(true);
            lbl1.setVisible(false);
            lbl2.setVisible(false);
        }
        else if(child.isIsAdopted() == true){
            parent.setFlag(false);
            isadopted.setText("Child Already Adopted");
            btn_adopt.setVisible(false);
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

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        panel_singleparent1 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        txt_firstname1 = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        lbl_photo = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txt_religion1 = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        txt_city1 = new javax.swing.JTextField();
        txt_lastname1 = new javax.swing.JTextField();
        txt_gender1 = new javax.swing.JTextField();
        txt_age1 = new javax.swing.JTextField();
        txt_race1 = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        isadopted = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btn_adopt = new javax.swing.JButton();
        jLabel61 = new javax.swing.JLabel();
        txt_lastrofileupdated1 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        txt_about1 = new javax.swing.JTextField();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        btn_requestreim = new javax.swing.JButton();
        panel_extra1 = new javax.swing.JLabel();
        back1 = new javax.swing.JButton();

        jPanel4.setBackground(new java.awt.Color(153, 153, 0));

        jPanel6.setBackground(new java.awt.Color(204, 255, 153));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(153, 153, 0));
        jLabel29.setText("PERSONAL INFORMATION");
        jPanel6.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 242, -1));

        panel_singleparent1.setBackground(new java.awt.Color(204, 255, 153));
        panel_singleparent1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel51.setText("Gender");
        panel_singleparent1.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel58.setText("Last Name");
        panel_singleparent1.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));
        panel_singleparent1.add(txt_firstname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 130, -1));

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel52.setText("Race");
        panel_singleparent1.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, -1, -1));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel37.setText("City");
        panel_singleparent1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        lbl_photo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        panel_singleparent1.add(lbl_photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 180, 190));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel38.setText("Age");
        panel_singleparent1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));
        panel_singleparent1.add(txt_religion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, 130, -1));

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel60.setText("Religion");
        panel_singleparent1.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, -1, -1));
        panel_singleparent1.add(txt_city1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, 130, -1));
        panel_singleparent1.add(txt_lastname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 130, -1));
        panel_singleparent1.add(txt_gender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 130, -1));
        panel_singleparent1.add(txt_age1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 130, -1));
        panel_singleparent1.add(txt_race1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, 130, -1));

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel63.setText("First Name");
        panel_singleparent1.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, 20));

        jPanel6.add(panel_singleparent1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 280, 540));

        isadopted.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        isadopted.setForeground(new java.awt.Color(255, 0, 0));
        isadopted.setText("CHILD ADOPTED!");
        jPanel6.add(isadopted, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 120, -1));

        jPanel8.setBackground(new java.awt.Color(204, 255, 153));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_adopt.setBackground(new java.awt.Color(51, 51, 51));
        btn_adopt.setText("Request To Adopt");
        btn_adopt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adoptActionPerformed(evt);
            }
        });
        jPanel8.add(btn_adopt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, -1, -1));

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(153, 153, 0));
        jLabel61.setText("Last Detials Updated");
        jPanel8.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, -1, -1));

        txt_lastrofileupdated1.setEnabled(false);
        jPanel8.add(txt_lastrofileupdated1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 280, -1));

        jPanel9.setBackground(new java.awt.Color(204, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel62.setText("ABOUT THE CHILD");
        jPanel9.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        txt_about1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel9.add(txt_about1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 170, 100));

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 190, 156));

        lbl1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl1.setForeground(new java.awt.Color(255, 51, 51));
        lbl1.setText("Your request for a child is already in process!");
        jPanel8.add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 260, 20));

        lbl2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl2.setForeground(new java.awt.Color(255, 51, 51));
        lbl2.setText("Please wait to adopt another child untill then!");
        jPanel8.add(lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 260, 20));

        btn_requestreim.setBackground(new java.awt.Color(51, 51, 51));
        btn_requestreim.setText("Request Reinbursemensts");
        btn_requestreim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_requestreimActionPerformed(evt);
            }
        });
        jPanel8.add(btn_requestreim, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 180, -1));

        panel_extra1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/childcare.jpg"))); // NOI18N

        back1.setBackground(new java.awt.Color(153, 153, 0));
        back1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        back1.setForeground(new java.awt.Color(51, 51, 51));
        back1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BackIcon.png"))); // NOI18N
        back1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(back1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_extra1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel_extra1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(back1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_adoptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adoptActionPerformed
        // TODO add your handling code here:
        //JOptionPane.showMessageDialog(rightpanel, parent.getRole());
        ParentWorkRequest parentrequest = new ParentWorkRequest();
        parentrequest.setChild(child);
        parentrequest.setParent(parent);
        parentrequest.setStatus("Reuest To Adopt");
        parentrequest.setMessage("I wanna adopt child");
        parentrequest.setSender(parent);
        Organization org = child.getOrg();
        parentrequest.getParent().setFlag(true);
        
        org.getWorkQueue().getWorkRequestList().add(parentrequest);
        UserAccount useraccount = (UserAccount)parent;
        useraccount.getWorkQueue().getWorkRequestList().add(parentrequest);
        business.getWorkQueue().getWorkRequestList().add(parentrequest);
        
       WorkRequest re = (WorkRequest)parentrequest;
       re.setStatus("Reuest To Adopt");
       re.setMessage("Reuest To Adopt");
       re.setParent(parent);
       re.setChild(child);
       re.setSender(useraccount);
 
        setStatus();
        
    }//GEN-LAST:event_btn_adoptActionPerformed

    private void back1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_back1ActionPerformed

    private void btn_requestreimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_requestreimActionPerformed
        // TODO add your handling code here:
        //CONVERT LOCAL DATE TO DATE
        
        RequestAmountJPanel raj = new RequestAmountJPanel(userProcessContainer,business,child,parent,rightpanel);
        
        userProcessContainer.add(raj);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
        
        
        
    }//GEN-LAST:event_btn_requestreimActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back1;
    private javax.swing.JButton btn_adopt;
    private javax.swing.JButton btn_requestreim;
    private javax.swing.JLabel isadopted;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl_photo;
    private javax.swing.JLabel panel_extra1;
    private javax.swing.JPanel panel_singleparent1;
    private javax.swing.JTextField txt_about1;
    private javax.swing.JTextField txt_age1;
    private javax.swing.JTextField txt_city1;
    private javax.swing.JTextField txt_firstname1;
    private javax.swing.JTextField txt_gender1;
    private javax.swing.JTextField txt_lastname1;
    private javax.swing.JTextField txt_lastrofileupdated1;
    private javax.swing.JTextField txt_race1;
    private javax.swing.JTextField txt_religion1;
    // End of variables declaration//GEN-END:variables
}
