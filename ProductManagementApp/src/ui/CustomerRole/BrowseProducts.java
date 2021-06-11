/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.CustomerRole;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Currency;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.MasterOrderList;
import model.Order;
import model.OrderItem;
import model.Product;
import model.Supplier;
import model.SupplierDirectory;

/**
 *
 * @author jaspr
 */
public class BrowseProducts extends javax.swing.JPanel {

    /** Creates new form BrowseProducts */
    private JPanel userProcessContainer;
    private SupplierDirectory supplierDirectory;
    private MasterOrderList masterorderlist;
    private Order currentorder;
    public BrowseProducts(JPanel userProcessContainer,SupplierDirectory supplierDirectory,MasterOrderList masterorderlist) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.supplierDirectory = supplierDirectory;
        this.masterorderlist = masterorderlist;
        this.currentorder = new Order();
        loadcombo();
        populateProductCatalog();
        populateCartTable();
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        combo_suppliers = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_productcatalog = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txt_saleprrice = new javax.swing.JTextField();
        lblQuantity = new javax.swing.JLabel();
        spinner_quantity = new javax.swing.JSpinner();
        btn_addtocart = new javax.swing.JButton();
        btn_viewproductcatalog = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_order = new javax.swing.JTable();
        btn_viewitem = new javax.swing.JButton();
        txt_modifyquantity = new javax.swing.JTextField();
        btn_back = new javax.swing.JButton();
        btn_remove = new javax.swing.JButton();
        btnModifyQuantity2 = new javax.swing.JButton();
        txt_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        btn_checkout = new javax.swing.JButton();

        lblTitle.setBackground(new java.awt.Color(0, 0, 0));
        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(204, 0, 0));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitle.setText("Have a wonderful shopping experience!");
        lblTitle.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblTitle.setIconTextGap(20);

        jLabel1.setText("Supplier");

        combo_suppliers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_suppliers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_suppliersActionPerformed(evt);
            }
        });

        tbl_productcatalog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ProductName", "Price", "Id", "Availability"
            }
        ));
        jScrollPane1.setViewportView(tbl_productcatalog);

        jLabel2.setText("SalePrice");

        txt_saleprrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_saleprriceActionPerformed(evt);
            }
        });

        lblQuantity.setText("Quantity:");

        spinner_quantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        btn_addtocart.setText("Add to Cart");
        btn_addtocart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addtocartActionPerformed(evt);
            }
        });

        btn_viewproductcatalog.setText("View");
        btn_viewproductcatalog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewproductcatalogActionPerformed(evt);
            }
        });

        tbl_order.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ItemName", "Price", "Quantity", "TotalAmount"
            }
        ));
        jScrollPane2.setViewportView(tbl_order);

        btn_viewitem.setText("ViewItem");
        btn_viewitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewitemActionPerformed(evt);
            }
        });

        txt_modifyquantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_modifyquantityActionPerformed(evt);
            }
        });

        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        btn_remove.setText("Remove");
        btn_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeActionPerformed(evt);
            }
        });

        btnModifyQuantity2.setText("Modify Quantity");
        btnModifyQuantity2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyQuantity2ActionPerformed(evt);
            }
        });

        txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchActionPerformed(evt);
            }
        });

        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        btn_checkout.setText("CHECKOUT");
        btn_checkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_checkoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)
                        .addComponent(combo_suppliers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_search))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btn_back)
                        .addGap(18, 18, 18)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_modifyquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModifyQuantity2)
                                .addGap(18, 18, 18)
                                .addComponent(btn_viewitem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_remove)
                                .addGap(18, 18, 18)
                                .addComponent(btn_checkout))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txt_saleprrice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(lblQuantity)
                        .addGap(18, 18, 18)
                        .addComponent(spinner_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btn_addtocart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_viewproductcatalog, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(206, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btn_back))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(combo_suppliers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_saleprrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuantity)
                    .addComponent(spinner_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_addtocart)
                    .addComponent(btn_viewproductcatalog)
                    .addComponent(jLabel2))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_modifyquantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_viewitem)
                    .addComponent(btn_remove)
                    .addComponent(btn_checkout)
                    .addComponent(btnModifyQuantity2))
                .addContainerGap(294, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_viewproductcatalogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewproductcatalogActionPerformed
        // TODO add your handling code here:
        
        int selectedrow = tbl_productcatalog.getSelectedRow();
        if(selectedrow < 0){
            JOptionPane.showMessageDialog(btn_remove, "Please select row");
        }
        Product product = (Product)tbl_productcatalog.getValueAt(selectedrow, 0);
        ViewProductDetails viewproductdetails = new ViewProductDetails(userProcessContainer,product);
        userProcessContainer.add(viewproductdetails);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_btn_viewproductcatalogActionPerformed

    private void btn_viewitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewitemActionPerformed
        // TODO add your handling code here:
        
        int selectedrow = tbl_order.getSelectedRow();
        if(selectedrow < 0){
            JOptionPane.showMessageDialog(btn_remove, "Please select orderitem");
        }
        OrderItem item = (OrderItem)tbl_order.getValueAt(selectedrow, 0);
        ViewOrderItem vieworderitem = new ViewOrderItem(userProcessContainer,item);
        userProcessContainer.add(vieworderitem);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_btn_viewitemActionPerformed

    private void btn_addtocartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addtocartActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel model = (DefaultTableModel)tbl_order.getModel();
        model.setRowCount(0);
        int selectedrow =  tbl_productcatalog.getSelectedRow();
        
        if(selectedrow<0){
            JOptionPane.showMessageDialog(btn_remove, "Please select product");
            return;
        }
        
        Product p = (Product) tbl_productcatalog.getValueAt(selectedrow, 0);
        
        double saleprice = 0.0;
        int quantity = 0;
        
        try{
            saleprice = Double.parseDouble(txt_saleprrice.getText());
            quantity = (Integer)spinner_quantity.getValue();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(btn_remove, "Please check saleprice and quantity");
            return;
        }
        
        
        if(saleprice < p.getPrice()){
            JOptionPane.showMessageDialog(btn_remove, "SalePrice can't be less than price");
            return;
        }
        
        
        OrderItem item = currentorder.findProduct(p);
        
        if(item == null){
            
            if(p.getAvail() >= quantity){
                currentorder.addorderitem(p, saleprice, quantity);
                p.setAvail(p.getAvail() - quantity);
            }
            else{
                JOptionPane.showMessageDialog(btn_remove, "Please check availability");
                return;
            }   
        }
        
        else{
            
            int oldQuantity = item.getQuantity();
            if(item.getProduct().getAvail() + oldQuantity < quantity){
                JOptionPane.showMessageDialog(btn_remove, "Please check product availability");
                return;
            }
            item.getProduct().setAvail(item.getProduct().getAvail() + oldQuantity - quantity);
            item.setQuantity(quantity);
        }
        
        populateProductCatalog();
        populateCartTable();
        
    }//GEN-LAST:event_btn_addtocartActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
        
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeActionPerformed
        // TODO add your handling code here:
        
        int selectedrow = tbl_order.getSelectedRow();
        if(selectedrow < 0){
            JOptionPane.showMessageDialog(btn_remove, "Please selct the orderitem to remove");
            return;
        }
        
        OrderItem item = (OrderItem)tbl_order.getValueAt(selectedrow,0);
        int quantity = 0;
  
        item.getProduct().setAvail(item.getProduct().getAvail()+ item.getQuantity());
        currentorder.removeitem(item);
        populateCartTable();
        populateProductCatalog();
    }//GEN-LAST:event_btn_removeActionPerformed

    private void txt_modifyquantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_modifyquantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_modifyquantityActionPerformed

    private void btnModifyQuantity2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyQuantity2ActionPerformed
        // TODO add your handling code here:
        
        int selectedrow = tbl_order.getSelectedRow();
        if(selectedrow < 0){
            JOptionPane.showMessageDialog(btn_remove, "Please selct the orderitem");
            return;
        }
        
        OrderItem item = (OrderItem)tbl_order.getValueAt(selectedrow,0);
        int quantity = 0;
        
        try{
            quantity = Integer.parseInt(txt_modifyquantity.getText());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(btn_remove, "Please check quantity");
        }
        
        int oldQuantity = item.getQuantity();
            if(item.getProduct().getAvail() + oldQuantity < quantity){
                JOptionPane.showMessageDialog(btn_remove, "Please check product availability");
                return;
            }
            item.getProduct().setAvail(item.getProduct().getAvail() + oldQuantity - quantity);
            item.setQuantity(quantity);
            
            populateCartTable();
            populateProductCatalog();
        
    }//GEN-LAST:event_btnModifyQuantity2ActionPerformed

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
        
        String prodname = txt_search.getText();
        populateProductCatalog(prodname);
        
    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_checkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_checkoutActionPerformed
        // TODO add your handling code here:
        
        masterorderlist.addNewOrder(currentorder);
        currentorder = new Order();
        
        loadcombo();
        populateProductCatalog();
        populateCartTable();
        
        txt_modifyquantity.setText("");
        txt_saleprrice.setText("");
        txt_search.setText("");
        spinner_quantity.setValue(0);
        
        JOptionPane.showMessageDialog(btn_remove, "Order is checked out!");
    }//GEN-LAST:event_btn_checkoutActionPerformed

    private void combo_suppliersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_suppliersActionPerformed
        // TODO add your handling code here:
        populateProductCatalog();
    }//GEN-LAST:event_combo_suppliersActionPerformed

    private void txt_saleprriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_saleprriceActionPerformed
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_txt_saleprriceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModifyQuantity2;
    private javax.swing.JButton btn_addtocart;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_checkout;
    private javax.swing.JButton btn_remove;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_viewitem;
    private javax.swing.JButton btn_viewproductcatalog;
    private javax.swing.JComboBox<String> combo_suppliers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JSpinner spinner_quantity;
    private javax.swing.JTable tbl_order;
    private javax.swing.JTable tbl_productcatalog;
    private javax.swing.JTextField txt_modifyquantity;
    private javax.swing.JTextField txt_saleprrice;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables

    private void loadcombo() {
        
        combo_suppliers.removeAllItems();
        for(Supplier s: supplierDirectory.getSupplierlist()){
            combo_suppliers.addItem(s.toString());
        }
        
        
    }

    private void populateProductCatalog() {
        
        DefaultTableModel model = (DefaultTableModel) tbl_productcatalog.getModel();
        model.setRowCount(0);
        
        for(Supplier s : supplierDirectory.getSupplierlist()){
            if(s.getSupplyname().equals(combo_suppliers.getSelectedItem())){
     
                for(Product p: s.getProductcatalog().getProductcatalog()){
                    //JOptionPane.showMessageDialog(btn_remove,  p.getPrice());
                    Object row[] = new Object[4];
                    row[0] = p;
                    row[1] = p.getPrice();
                    row[2] = p.getModelNumber();
                    row[3] = p.getAvail();
                    model.addRow(row);
                    }
            }
        }
         
        
        
    }
    
    private void populateCartTable() {
       
        DefaultTableModel model = (DefaultTableModel)tbl_order.getModel();
        model.setRowCount(0);
        
        for(OrderItem oi: currentorder.getOrderitemlist()){
            Object row[] = new Object[4];
            row[0] = oi;
            row[1] = oi.getSaleprice();
            row[2] = oi.getQuantity();
            row[3] = oi.getQuantity() * oi.getSaleprice();
            model.addRow(row);
        }
        
    }
    
    
     private void populateProductCatalog(String prodname) {
        
        DefaultTableModel model = (DefaultTableModel) tbl_productcatalog.getModel();
        model.setRowCount(0);
        
        for(Supplier s : supplierDirectory.getSupplierlist()){
            if(s.getSupplyname().equals(combo_suppliers.getSelectedItem())){
     
                for(Product p: s.getProductcatalog().getProductcatalog()){
                    //JOptionPane.showMessageDialog(btn_remove,  p.getPrice());
                        if(p.getProdName().equals(prodname)){
                        Object row[] = new Object[4];
                        row[0] = p;
                        row[1] = p.getPrice();
                        row[2] = p.getModelNumber();
                        row[3] = p.getAvail();
                        model.addRow(row);
                        }
                }
            }
        }
        
        
    }

}