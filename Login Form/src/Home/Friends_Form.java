/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Home;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bryce
 */
public class Friends_Form extends javax.swing.JFrame {
    
    private int uid;

    /**
     * Creates new form Friends_Form
     */
    public Friends_Form(int uid) {
        initComponents();
        this.uid = uid;
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

        scrollPane1 = new javax.swing.JScrollPane();
        friendTable = new javax.swing.JTable();
        acceptButton = new javax.swing.JButton();
        rejectButton = new javax.swing.JButton();
        newReqButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        friendTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Username", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scrollPane1.setViewportView(friendTable);

        acceptButton.setText("Accept");
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });

        rejectButton.setText("Reject");
        rejectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectButtonActionPerformed(evt);
            }
        });

        newReqButton.setText("New Request");
        newReqButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newReqButtonActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(acceptButton)
                                .addGap(74, 74, 74)
                                .addComponent(newReqButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rejectButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(backButton)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acceptButton)
                    .addComponent(rejectButton)
                    .addComponent(newReqButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(backButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        Home  hm = new Home(uid);
        hm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButtonActionPerformed
        if (friendTable.getSelectedRowCount() != 1)
            return;
        
        int uid2 = (int) friendTable.getValueAt(friendTable.getSelectedRow(), 1);
        Connection c = Connector.getInstance();
        
        PreparedStatement statement;
        try {
            statement = c.prepareStatement("UPDATE Friends "+
                    "SET u2Accept=true "+
                    "WHERE uid1=? and uid2=?;");
            statement.setInt(1, uid2);
            statement.setInt(2, uid);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Friends_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        setupTable();
    }//GEN-LAST:event_acceptButtonActionPerformed

    private void rejectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectButtonActionPerformed
        if (friendTable.getSelectedRowCount() != 1)
            return;
        
        int uid2 = (int) friendTable.getValueAt(friendTable.getSelectedRow(), 1);
        Connection c = Connector.getInstance();
        
        PreparedStatement statement;
        try {
            statement = c.prepareStatement("DELETE FROM Friends "+
                    "WHERE uid1=? and uid2=?;");
            statement.setInt(1, uid2);
            statement.setInt(2, uid);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Friends_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        setupTable();
    }//GEN-LAST:event_rejectButtonActionPerformed

    private void newReqButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newReqButtonActionPerformed
        AddFriend af = new AddFriend(this, true, uid);
        af.setVisible(true);
    }//GEN-LAST:event_newReqButtonActionPerformed

    private void setupTable() {
        DefaultTableModel m = (DefaultTableModel) friendTable.getModel();
        
        m.setRowCount(0);
        
        Connection c = Connector.getInstance();
        ResultSet rs;
        try {
            String qString = "SELECT L.uname, L.uid "+
                             "FROM  Friends as F, Logins as L "+
                             "WHERE F.uid2=? and L.uid=F.uid1 and F.u2Accept=false "+
                             "ORDER BY L.uname;";
            PreparedStatement query = c.prepareStatement(qString);
            query.setInt(1, uid);
            
            System.out.println(query.toString());
            rs = query.executeQuery();
            while (rs.next()) {
                m.addRow(new Object[] {
                    rs.getString(1),
                    rs.getInt(2)
                });
            }            
        } catch (SQLException ex) {
            Logger.getLogger(Login_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptButton;
    private javax.swing.JButton backButton;
    private javax.swing.JTable friendTable;
    private javax.swing.JButton newReqButton;
    private javax.swing.JButton rejectButton;
    private javax.swing.JScrollPane scrollPane1;
    // End of variables declaration//GEN-END:variables
}
