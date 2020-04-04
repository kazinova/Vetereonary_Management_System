/*
 * Created by JFormDesigner on Thu Apr 02 18:08:23 EEST 2020
 */

package Vetereonary.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Jane Doe
 */
public class AddScheme extends JFrame {
    static Connection c;
    public AddScheme() {
        initComponents();
        setTitle("Vetereonary Management  System");
        setResizable(false);
        setLocationRelativeTo(null);
        try{

            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/vetDB", "root", "");
            displaytable();
        }
        catch(Exception e){e.printStackTrace();}

    }
    private void displaytable(){
            if(!TextField1.getText().isEmpty()) {
                try {
                    PreparedStatement ps = c.prepareStatement("select * from "+TextField1.getText()+";");
                    ResultSet set = ps.executeQuery();

                    jTable1.setModel(DbUtils.resultSetToTableModel(set));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


    }
    private void jTextField4ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton1ActionPerformed(ActionEvent e) {
    if (TextField1.getText().isEmpty() || TextField2.getText().isEmpty() || TextField3.getText().isEmpty() ||TextField4.getText().isEmpty() || TextField5.getText().isEmpty()) {
        JOptionPane.showMessageDialog(new JFrame(), "Nav pareizi aizpildīti lauki!", "Message", JOptionPane.INFORMATION_MESSAGE);
    } else {
        try {
        Date birth = new SimpleDateFormat("yyyy-mm-dd").parse(TextField3.getText());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        Calendar a = Calendar.getInstance();
        a.setTime(birth);
        a.add(Calendar.DATE, Integer.parseInt(TextField5.getText()));
        Date birth2 = a.getTime();
        PreparedStatement ps = c.prepareStatement("ALTER TABLE " + TextField1.getText() + " add " + TextField4.getText() + " Date");
        ps.executeUpdate();
        ps = c.prepareStatement("UPDATE " + TextField1.getText() + " SET " + TextField4.getText() + "='" + format.format(birth2) + "' WHERE Nosaukums='"+TextField1.getText()+"';");
        ps.executeUpdate();
        displaytable();
    } catch (Exception a) {
        a.printStackTrace();
    }
        }
    }

    private void jButton2ActionPerformed(ActionEvent e) {
        HomeSchemes homeSchemes = new HomeSchemes();
        homeSchemes.setVisible(true);
        this.dispose();
    }

    private void jButton3ActionPerformed(ActionEvent e) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        df.setLenient(false);
        boolean date=true;
        try{
            df.setLenient(false);
            df.parse(TextField3.getText());
            date=false;
        }
        catch (ParseException v){
            date=true;
        }

        if (TextField1.getText().isEmpty() || TextField2.getText().isEmpty() || TextField3.getText().isEmpty() || date) {
            JOptionPane.showMessageDialog(new JFrame(), "Nav pareizi aizpildīti lauki!", "Message", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                PreparedStatement ps = c.prepareStatement("CREATE TABLE " + TextField1.getText() + "(Nosaukums varchar(20), " + TextField2.getText() + " Date);");
                ps.executeUpdate();
                ps = c.prepareStatement("INSERT INTO " + TextField1.getText() + "(" + TextField2.getText() + ", Nosaukums) VALUES('" + TextField3.getText() + "', '"+TextField1.getText()+"');");
                ps.executeUpdate();
                TextField1.setEditable(false);
                TextField2.setEditable(false);
                TextField3.setEditable(false);
                displaytable();
            } catch (Exception a) {
                a.printStackTrace();
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Jane Doe
        jPanel1 = new JPanel();
        TextField4 = new JTextField();
        TextField1 = new JTextField();
        jButton1 = new JButton();
        jLabel1 = new JLabel();
        TextField2 = new JTextField();
        jLabel4 = new JLabel();
        jLabel2 = new JLabel();
        jButton3 = new JButton();
        label1 = new JLabel();
        TextField5 = new JTextField();
        label2 = new JLabel();
        TextField3 = new JTextField();
        jPanel2 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jButton2 = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();

        //======== jPanel1 ========
        {
            jPanel1.setBorder(new TitledBorder(new LineBorder(Color.black, 2, true), "Pievienot sh\u0113mu", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                new Font("Tahoma", Font.PLAIN, 24)));
            jPanel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing
            .border.EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing.border.TitledBorder
            .CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.
            awt.Font.BOLD,12),java.awt.Color.red),jPanel1. getBorder()))
            ;jPanel1. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
            ){if("\u0062ord\u0065r".equals(e.getPropertyName()))throw new RuntimeException();}})
            ;

            //---- TextField4 ----
            TextField4.addActionListener(e -> jTextField4ActionPerformed(e));

            //---- jButton1 ----
            jButton1.setText("PIEVIENOT");
            jButton1.addActionListener(e -> jButton1ActionPerformed(e));

            //---- jLabel1 ----
            jLabel1.setText("Sh\u0113mas nosaukums");

            //---- jLabel4 ----
            jLabel4.setText("Medikamenta nosaukums");

            //---- jLabel2 ----
            jLabel2.setText("Pirm\u0101 medikamenta nosaukums");

            //---- jButton3 ----
            jButton3.setText("IZVEIDOT");
            jButton3.addActionListener(e -> {
                try {
                    jButton3ActionPerformed(e);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
            });

            //---- label1 ----
            label1.setText("Dienu skaits no s\u0101kuma datuma");

            //---- label2 ----
            label2.setText("Atskaites s\u0101kuma datums  (\"yyyy-mm-dd\")");

            GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup()
                                    .addComponent(jLabel1)
                                    .addComponent(label2)
                                    .addComponent(jLabel2))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TextField2, GroupLayout.Alignment.TRAILING)
                                    .addComponent(TextField1, GroupLayout.Alignment.TRAILING)
                                    .addComponent(TextField3, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(39, 39, 39)
                                .addComponent(TextField5, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 244, Short.MAX_VALUE)
                                .addComponent(TextField4, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 500, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton1)
                                    .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))))
                        .addGap(29, 29, 29))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup()
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup()
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(TextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label2)))
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(TextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(TextField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label1))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }

        //======== jPanel2 ========
        {
            jPanel2.setBorder(new TitledBorder(new LineBorder(Color.black, 2, true), "Sh\u0113ma", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                new Font("Tahoma", Font.PLAIN, 24)));

            //======== jScrollPane1 ========
            {

                //---- jTable1 ----
                jTable1.setBorder(new TitledBorder(""));
                jTable1.setModel(new DefaultTableModel(
                    new Object[][] {
                        {null, null, null, null},
                    },
                    new String[] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                    }
                ));
                jScrollPane1.setViewportView(jTable1);
            }

            GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup()
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 537, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(80, Short.MAX_VALUE))
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup()
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
            );
        }

        //---- jButton2 ----
        jButton2.setText("ATPAKA\u013b");
        jButton2.addActionListener(e -> jButton2ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap(591, Short.MAX_VALUE)
                            .addComponent(jButton2))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGap(125, 125, 125))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jButton2)
                    .addContainerGap(25, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Jane Doe
    private JPanel jPanel1;
    private JTextField TextField4;
    private JTextField TextField1;
    private JButton jButton1;
    private JLabel jLabel1;
    private JTextField TextField2;
    private JLabel jLabel4;
    private JLabel jLabel2;
    private JButton jButton3;
    private JLabel label1;
    private JTextField TextField5;
    private JLabel label2;
    private JTextField TextField3;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JButton jButton2;
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addCowScheme().setVisible(true);
            }
        });

    }
}
