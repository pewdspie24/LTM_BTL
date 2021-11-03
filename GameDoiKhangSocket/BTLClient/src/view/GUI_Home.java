/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GameClient;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Request;
import model.User;

/**
 *
 * @author nguye
 */
public class GUI_Home extends javax.swing.JFrame {


    public GUI_Home() {
        initComponents();
        //Set frame location         
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        onlineList.requestFocus();
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
        jLabel3 = new javax.swing.JLabel();
        nickName = new javax.swing.JLabel();
        cbStatus = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        onlineList = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("PLAYER LIST");

        jLabel3.setText("Player Name");

        nickName.setBackground(new java.awt.Color(102, 102, 255));
        nickName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nickName.setForeground(new java.awt.Color(0, 0, 255));
        nickName.setText("nick name");

        cbStatus.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Busy", "Online" }));
        cbStatus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cbStatus.setPreferredSize(new java.awt.Dimension(60, 25));
        cbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStatusActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        onlineList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onlineListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(onlineList);

        jScrollPane2.setViewportView(jScrollPane1);

        jButton1.setText("RANK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(nickName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(cbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nickName)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onlineListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onlineListMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            User user = onlineList.getSelectedValue();
            if (user.getStatus() == 0) {
                JOptionPane.showMessageDialog(this, "Player is offline");
            } else {
                if (user.getStatus() == 1) {
                    int comfirm = JOptionPane.showConfirmDialog(this, "Do you want to challenge " + user.getNickname().toUpperCase() + "?");
                    // send invitation
                    if (comfirm == 0) {
                        try {
                            ObjectOutputStream oos = new ObjectOutputStream(GameClient.socket.getOutputStream());
                            Request req = new Request(0);
                            req.action = "challenge";
                            req.user = user;
                            oos.writeObject(req);
                            oos.flush();
                        } catch (IOException ex) {
                            Logger.getLogger(GUI_Home.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Player is busy");
                }
            }
        }
    }//GEN-LAST:event_onlineListMouseClicked

    private void cbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStatusActionPerformed
        try {
            // TODO add your handling code here:
            ObjectOutputStream oos = new ObjectOutputStream(GameClient.socket.getOutputStream());
            Request req = new Request(1);
            req.action = "updateStatus";
            req.message = cbStatus.getSelectedItem() + "";
            oos.writeObject(req);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(GUI_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbStatusActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         try {
            // TODO add your handling code here:
            ObjectOutputStream oos = new ObjectOutputStream(GameClient.socket.getOutputStream());
            Request req = new Request(0);
            req.action = "rank";
            req.message = "scores";
            oos.writeObject(req);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(GUI_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel nickName;
    public static javax.swing.JList<User> onlineList;
    // End of variables declaration//GEN-END:variables
}