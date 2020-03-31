package Vetereonary.Management.System;

import javax.swing.*;
import java.awt.*;

public class Home extends javax.swing.JFrame {

    public Home() {
        initComponents();
        setTitle("Library Management System");
        setResizable(false);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - Jane Doe
    private void initComponents() {
        jLabel1 = new JLabel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jButton6 = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();

        //---- jLabel1 ----
        jLabel1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        jLabel1.setText("     Library Management System");

        //---- jButton1 ----
        jButton1.setFont(new Font("Times New Roman", Font.BOLD, 14));
        jButton1.setText("New Book");
        jButton1.addActionListener(e -> jButton1ActionPerformed(e));

        //---- jButton2 ----
        jButton2.setFont(new Font("Times New Roman", Font.BOLD, 14));
        jButton2.setText("New Student");
        jButton2.addActionListener(e -> jButton2ActionPerformed(e));

        //---- jButton3 ----
        jButton3.setFont(new Font("Times New Roman", Font.BOLD, 14));
        jButton3.setText("Statistics");
        jButton3.addActionListener(e -> jButton3ActionPerformed(e));

        //---- jButton4 ----
        jButton4.setFont(new Font("Times New Roman", Font.BOLD, 14));
        jButton4.setText("Issue Book");
        jButton4.addActionListener(e -> jButton4ActionPerformed(e));

        //---- jButton5 ----
        jButton5.setFont(new Font("Times New Roman", Font.BOLD, 14));
        jButton5.setText("Return Book");
        jButton5.addActionListener(e -> jButton5ActionPerformed(e));

        //---- jButton6 ----
        jButton6.setFont(new Font("Times New Roman", Font.BOLD, 14));
        jButton6.setText("Logout");
        jButton6.addActionListener(e -> jButton6ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
                            .addGap(60, 60, 60)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
                            .addGap(60, 60, 60)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))))
                    .addGap(100, 100, 100))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(jLabel1)
                    .addGap(70, 70, 70)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                    .addGap(70, 70, 70)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                    .addGap(85, 85, 85))
        );
        pack();
        setLocationRelativeTo(getOwner());
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        NewCow newCow = new NewCow();
        newCow.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        Record record = new Record();
        record.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        IssueBook issueBook = new IssueBook();
        issueBook.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        ReturnBook returnBook = new ReturnBook();
        returnBook.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        About about = new About();
        about.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        NewStudent newStudent = new NewStudent();
        newStudent.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Jane Doe
    private JLabel jLabel1;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    // End of variables declaration//GEN-END:variables
}
