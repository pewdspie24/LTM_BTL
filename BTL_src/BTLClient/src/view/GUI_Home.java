/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GameClient;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
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

        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        chatField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nickName = new javax.swing.JLabel();
        cbStatus = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        chatBoxField = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        onlineList = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JPanel();
        l = new javax.swing.JLabel();
        sendBtn = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        refreshBtn = new javax.swing.JPanel();
        lblReset = new javax.swing.JLabel();
        jButton1 = new javax.swing.JPanel();
        log = new javax.swing.JLabel();
        historyBtn = new javax.swing.JPanel();
        l11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(102, 153, 255));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jPanel1.setBackground(new java.awt.Color(41, 54, 63));

        chatField.setBackground(new java.awt.Color(41, 54, 63));
        chatField.setForeground(new java.awt.Color(255, 255, 255));
        chatField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        chatField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chatFieldActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Chat Box");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Player List");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Your chat");

        jLabel3.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Player Name");

        nickName.setBackground(new java.awt.Color(102, 102, 255));
        nickName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nickName.setForeground(new java.awt.Color(153, 153, 255));
        nickName.setText("nick name");

        cbStatus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Busy", "Online" }));
        cbStatus.setBorder(null);
        cbStatus.setPreferredSize(new java.awt.Dimension(60, 25));
        cbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStatusActionPerformed(evt);
            }
        });

        chatBoxField.setEditable(false);
        chatBoxField.setBackground(new java.awt.Color(41, 54, 63));
        chatBoxField.setColumns(20);
        chatBoxField.setForeground(new java.awt.Color(255, 255, 255));
        chatBoxField.setRows(5);
        chatBoxField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        jScrollPane4.setViewportView(chatBoxField);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        onlineList.setBackground(new java.awt.Color(41, 54, 63));
        onlineList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onlineListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(onlineList);

        jLabel5.setFont(new java.awt.Font("Georgia", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 204, 204));
        jLabel5.setText("Nhóm 2");

        logoutBtn.setBackground(new java.awt.Color(204, 0, 0));
        logoutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logoutBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                logoutBtnMouseReleased(evt);
            }
        });

        l.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        l.setForeground(new java.awt.Color(255, 255, 255));
        l.setText("Logout");

        javax.swing.GroupLayout logoutBtnLayout = new javax.swing.GroupLayout(logoutBtn);
        logoutBtn.setLayout(logoutBtnLayout);
        logoutBtnLayout.setHorizontalGroup(
            logoutBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
            .addGroup(logoutBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(logoutBtnLayout.createSequentialGroup()
                    .addGap(0, 13, Short.MAX_VALUE)
                    .addComponent(l)
                    .addGap(0, 14, Short.MAX_VALUE)))
        );
        logoutBtnLayout.setVerticalGroup(
            logoutBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
            .addGroup(logoutBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(logoutBtnLayout.createSequentialGroup()
                    .addGap(0, 7, Short.MAX_VALUE)
                    .addComponent(l)
                    .addGap(0, 7, Short.MAX_VALUE)))
        );

        sendBtn.setBackground(new java.awt.Color(110, 217, 161));
        sendBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sendBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sendBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sendBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sendBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sendBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                sendBtnMouseReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Send Message");

        javax.swing.GroupLayout sendBtnLayout = new javax.swing.GroupLayout(sendBtn);
        sendBtn.setLayout(sendBtnLayout);
        sendBtnLayout.setHorizontalGroup(
            sendBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
            .addGroup(sendBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(sendBtnLayout.createSequentialGroup()
                    .addGap(0, 7, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addGap(0, 7, Short.MAX_VALUE)))
        );
        sendBtnLayout.setVerticalGroup(
            sendBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
            .addGroup(sendBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(sendBtnLayout.createSequentialGroup()
                    .addGap(0, 8, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addGap(0, 9, Short.MAX_VALUE)))
        );

        refreshBtn.setBackground(new java.awt.Color(41, 54, 63));
        refreshBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        refreshBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refreshBtn.setPreferredSize(new java.awt.Dimension(228, 46));
        refreshBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                refreshBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                refreshBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                refreshBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                refreshBtnMouseReleased(evt);
            }
        });

        lblReset.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lblReset.setForeground(new java.awt.Color(255, 255, 255));
        lblReset.setText("Refresh");
        lblReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblResetMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout refreshBtnLayout = new javax.swing.GroupLayout(refreshBtn);
        refreshBtn.setLayout(refreshBtnLayout);
        refreshBtnLayout.setHorizontalGroup(
            refreshBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 86, Short.MAX_VALUE)
            .addGroup(refreshBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(refreshBtnLayout.createSequentialGroup()
                    .addGap(0, 20, Short.MAX_VALUE)
                    .addComponent(lblReset)
                    .addGap(0, 21, Short.MAX_VALUE)))
        );
        refreshBtnLayout.setVerticalGroup(
            refreshBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
            .addGroup(refreshBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(refreshBtnLayout.createSequentialGroup()
                    .addGap(0, 4, Short.MAX_VALUE)
                    .addComponent(lblReset)
                    .addGap(0, 5, Short.MAX_VALUE)))
        );

        jButton1.setBackground(new java.awt.Color(204, 153, 0));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });

        log.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        log.setForeground(new java.awt.Color(0, 102, 102));
        log.setText("Rank");

        javax.swing.GroupLayout jButton1Layout = new javax.swing.GroupLayout(jButton1);
        jButton1.setLayout(jButton1Layout);
        jButton1Layout.setHorizontalGroup(
            jButton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
            .addGroup(jButton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jButton1Layout.createSequentialGroup()
                    .addGap(0, 13, Short.MAX_VALUE)
                    .addComponent(log)
                    .addGap(0, 13, Short.MAX_VALUE)))
        );
        jButton1Layout.setVerticalGroup(
            jButton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jButton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jButton1Layout.createSequentialGroup()
                    .addGap(0, 5, Short.MAX_VALUE)
                    .addComponent(log)
                    .addGap(0, 5, Short.MAX_VALUE)))
        );

        historyBtn.setBackground(new java.awt.Color(204, 153, 0));
        historyBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        historyBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                historyBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                historyBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                historyBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                historyBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                historyBtnMouseReleased(evt);
            }
        });

        l11.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        l11.setForeground(new java.awt.Color(0, 102, 102));
        l11.setText("History");

        javax.swing.GroupLayout historyBtnLayout = new javax.swing.GroupLayout(historyBtn);
        historyBtn.setLayout(historyBtnLayout);
        historyBtnLayout.setHorizontalGroup(
            historyBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
            .addGroup(historyBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(historyBtnLayout.createSequentialGroup()
                    .addGap(0, 13, Short.MAX_VALUE)
                    .addComponent(l11)
                    .addGap(0, 13, Short.MAX_VALUE)))
        );
        historyBtnLayout.setVerticalGroup(
            historyBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
            .addGroup(historyBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(historyBtnLayout.createSequentialGroup()
                    .addGap(0, 5, Short.MAX_VALUE)
                    .addComponent(l11)
                    .addGap(0, 5, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel1)
                                .addGap(76, 76, 76)
                                .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(108, 108, 108)
                                        .addComponent(jLabel4))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chatField, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(62, 62, 62))
                                        .addComponent(logoutBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(26, 26, 26)
                        .addComponent(nickName)
                        .addGap(62, 62, 62)
                        .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(historyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nickName)
                        .addComponent(jLabel3))
                    .addComponent(logoutBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(74, 74, 74)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chatField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sendBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(historyBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chatFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chatFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chatFieldActionPerformed

    private void logoutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMouseClicked
        try {
            // TODO add your handling code here:
            ObjectOutputStream oos = new ObjectOutputStream(GameClient.socket.getOutputStream());
            Request req = new Request(0);
            req.action = "logout";
            oos.writeObject(req);
            oos.flush();
            GameClient.isLogin = false;
        } catch (IOException ex) {
            Logger.getLogger(GUI_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_logoutBtnMouseClicked

    private void logoutBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMouseEntered
        // TODO add your handling code here:
        logoutBtn.setBackground(new Color(171,2,33));
    }//GEN-LAST:event_logoutBtnMouseEntered

    private void logoutBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMouseExited
        // TODO add your handling code here:
        logoutBtn.setBackground(new Color(204,0,0));
    }//GEN-LAST:event_logoutBtnMouseExited

    private void logoutBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMousePressed
        logoutBtn.setBackground(new Color(171,2,33));
    }//GEN-LAST:event_logoutBtnMousePressed

    private void logoutBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMouseReleased
        // TODO add your handling code here:
                logoutBtn.setBackground(new Color(204,0,0));
    }//GEN-LAST:event_logoutBtnMouseReleased

    private void sendBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendBtnMouseClicked
        // TODO add your handling code here:
         try {
            // TODO add your handling code here:
            ObjectOutputStream oos = new ObjectOutputStream(GameClient.socket.getOutputStream());
            Request req = new Request(0);
            req.action = "sendMessage";
//            req.players = this.user
            req.user = GameClient.user;
            req.message = chatField.getText();
            oos.writeObject(req);
            oos.flush();
            chatField.setText("");
        } catch (IOException ex) {
            Logger.getLogger(GUI_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_sendBtnMouseClicked

    private void sendBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendBtnMouseEntered
        logoutBtn.setBackground(new Color(97, 204, 148));
    }//GEN-LAST:event_sendBtnMouseEntered

    private void sendBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendBtnMouseExited
        // TODO add your handling code here:
        logoutBtn.setBackground(new Color(110, 217, 161));
    }//GEN-LAST:event_sendBtnMouseExited

    private void sendBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendBtnMousePressed
        // TODO add your handling code here:

        logoutBtn.setBackground(new Color(85, 192, 136));
    }//GEN-LAST:event_sendBtnMousePressed

    private void sendBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendBtnMouseReleased
        // TODO add your handling code here:

        logoutBtn.setBackground(new Color(110, 217, 161));
    }//GEN-LAST:event_sendBtnMouseReleased

    private void lblResetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResetMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblResetMouseEntered

    private void refreshBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshBtnMouseClicked
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

    }//GEN-LAST:event_refreshBtnMouseClicked

    private void refreshBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshBtnMouseEntered
        // TODO add your handling code here:
        refreshBtn.setBackground(new Color(28, 41, 50));
        lblReset.setForeground(new Color(97, 204, 148));
        refreshBtn.setBorder(BorderFactory.createBevelBorder(1, new Color(97, 204, 148), new Color(97, 204, 148), new Color(97, 204, 148), new Color(97, 204, 148)));
    }//GEN-LAST:event_refreshBtnMouseEntered

    private void refreshBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshBtnMouseExited
        // TODO add your handling code here:
        refreshBtn.setBackground(new Color(41, 54, 63));
        lblReset.setForeground(Color.WHITE);
        refreshBtn.setBorder(BorderFactory.createBevelBorder(1, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE));
    }//GEN-LAST:event_refreshBtnMouseExited

    private void refreshBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshBtnMousePressed
        // TODO add your handling code here:
        refreshBtn.setBackground(new Color(16, 29, 38));
    }//GEN-LAST:event_refreshBtnMousePressed

    private void refreshBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshBtnMouseReleased
        // TODO add your handling code here:
        refreshBtn.setBackground(new Color(41, 54, 63));
    }//GEN-LAST:event_refreshBtnMouseReleased

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
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
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseReleased

    private void historyBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyBtnMouseClicked
         try {
            // TODO add your handling code here:
            ObjectOutputStream oos = new ObjectOutputStream(GameClient.socket.getOutputStream());
            Request req = new Request(0);
            req.action = "history";
            req.user = GameClient.user;
            oos.writeObject(req);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(GUI_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_historyBtnMouseClicked

    private void historyBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyBtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_historyBtnMouseEntered

    private void historyBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyBtnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_historyBtnMouseExited

    private void historyBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyBtnMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_historyBtnMousePressed

    private void historyBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyBtnMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_historyBtnMouseReleased

    private void onlineListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onlineListMouseClicked
        if (evt.getClickCount() == 2) {
            User user = onlineList.getSelectedValue();
            if (user.getStatus() == 0) {
                JOptionPane.showMessageDialog(this, "This player is busy");
            } else {
                if (user.getStatus() == 1) {
                    int comfirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to challenge " + user.getNickname() + "?");
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
                    JOptionPane.showMessageDialog(this, "This player is busy");
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
    public void chatBoxUpdate(String chat){
        chatBoxField.append(chat+"\n");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JTextArea chatBoxField;
    private javax.swing.JTextField chatField;
    private javax.swing.JPanel historyBtn;
    private javax.swing.JPanel jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel l;
    private javax.swing.JLabel l11;
    private javax.swing.JLabel lblReset;
    private javax.swing.JLabel log;
    private javax.swing.JPanel logoutBtn;
    public javax.swing.JLabel nickName;
    public static javax.swing.JList<User> onlineList;
    private javax.swing.JPanel refreshBtn;
    private javax.swing.JPanel sendBtn;
    // End of variables declaration//GEN-END:variables
}