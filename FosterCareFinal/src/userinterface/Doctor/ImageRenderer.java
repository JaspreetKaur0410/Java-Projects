/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Doctor;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author jaspr
 */
public class ImageRenderer extends DefaultTableCellRenderer{
    JLabel lbl = new JLabel();

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
        boolean hasFocus, int row, int column) {
        
        TableColumn tb = table.getColumn("Status");
        
        lbl.setText((String) value);
        JOptionPane.showMessageDialog(labelFor, new ImageIcon("icons1/cancel.png"));
        lbl.setIcon(new ImageIcon("/icons1/cancel.png"));
        this.setIcon(new ImageIcon("/icons1/cancel.png"));
        return lbl;
 
    }
    
}
