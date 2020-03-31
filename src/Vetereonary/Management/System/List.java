/*
 * Created by JFormDesigner on Tue Mar 31 11:33:17 EEST 2020
 */

package Vetereonary.Management.System;

import net.miginfocom.swing.MigLayout;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Jane Doe
 */
public class List extends javax.swing.JFrame {

    static Connection c;

    public List() {
        initComponents();
        setTitle("Vetereonary Management  System");
        setResizable(false);
        setLocationRelativeTo(null);
        jTable1.setEnabled(false);

        try{
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/vetDB", "root", "");
            displaytable();
        }
        catch(Exception e){e.printStackTrace();}
    }

    private void displaytable(){

        try{
            PreparedStatement ps = c.prepareStatement("select * from govis where grupa=?;");
            ps.setInt(1,2);
            ResultSet set = ps.executeQuery();

            jTable1.setModel(DbUtils.resultSetToTableModel(set));
        }
        catch(Exception e){e.printStackTrace();}

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Jane Doe
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //======== jScrollPane1 ========
        {

            //---- jTable1 ----
            jTable1.setBorder(new TitledBorder(""));
            jTable1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                },
                new String[] {
                    "Title 1", "Title 2", "Title 3", "Title 4"
                }
            ));
            jScrollPane1.setViewportView(jTable1);
        }
        contentPane.add(jScrollPane1, "cell 0 0");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Jane Doe
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Login().setVisible(true);
//            }
//        });
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new List().setVisible(true);
            }
        });
    }
}
