/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.AdminRole;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import model.Business;
import model.SupplierDirectory;

/**
 *
 * @author jaspr
 */
public class AdminWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form AdminWorkArea
     */
    private JPanel userproceescontainer;
    private Business business;
    SupplierDirectory supplierdirectory;
    public AdminWorkArea(JPanel userprocessconatiner, SupplierDirectory supplierdirectory) {
        initComponents();
        this.userproceescontainer = userprocessconatiner;
        this.supplierdirectory = supplierdirectory;
        //supplierdirectory = business.getSupplierdirectory();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userprocesscontainer = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        userprocesscontainer.setText("Manage Suppliers");
        userprocesscontainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userprocesscontainerActionPerformed(evt);
            }
        });
        add(userprocesscontainer, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void userprocesscontainerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userprocesscontainerActionPerformed
        // TODO add your handling code here:
        
        ManageSupplier managesupplier = new ManageSupplier(userproceescontainer,supplierdirectory);
        userproceescontainer.add("managesupplier",managesupplier);
        CardLayout layout = (CardLayout) userproceescontainer.getLayout();
        layout.next(userproceescontainer);
    }//GEN-LAST:event_userprocesscontainerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton userprocesscontainer;
    // End of variables declaration//GEN-END:variables
}