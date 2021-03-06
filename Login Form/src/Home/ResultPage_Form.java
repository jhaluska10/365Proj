/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Home;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bryce
 */
public class ResultPage_Form extends javax.swing.JFrame {
    
    private int uid;
    private String category;

    /**
     * Creates new form ResultPage_Form
     */
    public ResultPage_Form(int uid, String category) {
        initComponents();
        this.uid = uid;
        this.category = category;
        tableLabel.setText(category);
        tableLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tableLabel.setVerticalAlignment(SwingConstants.CENTER);
        // Hide the id column
        viewTable.getColumnModel().getColumn(4).setMinWidth(0);
        viewTable.getColumnModel().getColumn(4).setMaxWidth(0);
        setupTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        viewTable = new javax.swing.JTable();
        tableLabel = new javax.swing.JLabel();
        refreshButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        viewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Quantity", "Added By", "Date Modified", "id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        viewTable.getTableHeader().setReorderingAllowed(false);
        scrollPane.setViewportView(viewTable);
        if (viewTable.getColumnModel().getColumnCount() > 0) {
            viewTable.getColumnModel().getColumn(1).setPreferredWidth(1);
            viewTable.getColumnModel().getColumn(4).setResizable(false);
            viewTable.getColumnModel().getColumn(4).setPreferredWidth(0);
        }

        tableLabel.setFont(new java.awt.Font("Cantarell", 1, 20)); // NOI18N
        tableLabel.setText("Text");

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(refreshButton)
                        .addGap(51, 51, 51)
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(updateButton)
                        .addGap(61, 61, 61)
                        .addComponent(removeButton)
                        .addGap(63, 63, 63)
                        .addComponent(backButton))
                    .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
                    .addComponent(tableLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(tableLabel)
                .addGap(34, 34, 34)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshButton)
                    .addComponent(addButton)
                    .addComponent(updateButton)
                    .addComponent(removeButton)
                    .addComponent(backButton))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        setupTable();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        if (viewTable.getSelectedRowCount() != 1)
            return;
        
        int itemid = (int) viewTable.getValueAt(viewTable.getSelectedRow(), 4);
        
        Connection c = Connector.getInstance();
        try {
            PreparedStatement remove = c.prepareStatement("DELETE FROM Items WHERE id=?;");
            remove.setInt(1, itemid);
            remove.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ResultPage_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JOptionPane.showMessageDialog(null, "Item deleted");
        
        setupTable();
    }//GEN-LAST:event_removeButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        Home  hm = new Home(uid);
        hm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        AddItem ai = new AddItem(this, true, uid, category);
        ai.setVisible(true);
        setupTable();
    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        if (viewTable.getSelectedRowCount() != 1)
            return;
        
        int itemID = (int) viewTable.getValueAt(viewTable.getSelectedRow(), 4);
        
        UpdateItem ai = new UpdateItem(this, true, uid, category, itemID);
        ai.setVisible(true);
        setupTable();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void setupTable() {
        DefaultTableModel m = (DefaultTableModel) viewTable.getModel();
        
        m.setRowCount(0);
        
        Connection c = Connector.getInstance();
        ResultSet rs;
        try {
            String qString = "SELECT I.item, I.quantity, L2.uname, I.dateAdd, I.id "+
                             "FROM Logins as L1, Items as I, Logins as L2 "+
                             "WHERE L1.uid=I.ownedBy and I.ownedBy=? and I.category=? and L2.uid=I.addedBy "+
                             "ORDER BY I.dateAdd desc;";
            PreparedStatement query = c.prepareStatement(qString);
            query.setInt(1, uid);
            query.setString(2, category);
            
            System.out.println(query.toString());
            rs = query.executeQuery();
            while (rs.next()) {
                m.addRow(new Object[] {
                    rs.getString(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getDate(4),
                    rs.getInt(5)
                });
            }            
        } catch (SQLException ex) {
            Logger.getLogger(Login_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JLabel tableLabel;
    private javax.swing.JButton updateButton;
    private javax.swing.JTable viewTable;
    // End of variables declaration//GEN-END:variables
}
