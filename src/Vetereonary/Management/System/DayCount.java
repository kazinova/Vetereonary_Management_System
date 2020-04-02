/*
 * Created by JFormDesigner on Thu Apr 02 13:38:18 EEST 2020
 */

package Vetereonary.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;

/**
 * @author Jane Doe
 */
public class DayCount extends JFrame {
    static Connection c;
    public DayCount() {
        initComponents();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        DefaultComboBoxModel mode2 = new DefaultComboBoxModel();
        mode2.addElement("8");
        mode2.addElement("30");
        comboBox2.setModel(mode2);
        setTitle("Vetereonary Management  System");
        setResizable(false);
        setLocationRelativeTo(null);

        try{
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/vetDB", "root", "");
        }
        catch(Exception e){e.printStackTrace();}
        try{
            PreparedStatement ps = c.prepareStatement("select DISTINCT grupa from govis ORDER BY grupa;");
            ResultSet set = ps.executeQuery();
            model.addElement("Visas");
            while (set.next()) //go through each row that your query returns
            {
                String ItemList2 = set.getString("grupa"); //get the element in column "item_code"
                model.addElement(ItemList2); //add each item to the model
            }
            comboBox1.setModel(model);
        }
        catch(Exception e){e.printStackTrace();}


    }
    private void displaytable(){

        String grupa;
        if(comboBox1.getSelectedItem().toString()=="Visas") {
            grupa="Grupa";
        }
        else{
            grupa=comboBox1.getSelectedItem().toString();
        }
        if(comboBox2.getSelectedItem().toString()=="8"){
            try {
                PreparedStatement ps = c.prepareStatement("SELECT* from govis WHERE DATEDIFF(CURRENT_DATE,Atnešanās_datums)>=6 AND DATEDIFF(CURRENT_DATE,Atnešanās_datums)<=10 AND Grupa="+grupa+";");
                ResultSet set = ps.executeQuery();

                jTable1.setModel(DbUtils.resultSetToTableModel(set));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                PreparedStatement ps = c.prepareStatement("SELECT* from govis WHERE DATEDIFF(CURRENT_DATE,Atnešanās_datums)>=28 AND DATEDIFF(CURRENT_DATE,Atnešanās_datums)<=32 AND Grupa="+grupa+";");
                ResultSet set = ps.executeQuery();

                jTable1.setModel(DbUtils.resultSetToTableModel(set));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }

    private void jButton1ActionPerformed(ActionEvent e) {
        displaytable();
    }

    private void jButton2ActionPerformed(ActionEvent e) {
        Home home = new Home();
        home.setVisible(true);
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Jane Doe
        jPanel1 = new JPanel();
        jButton1 = new JButton();
        jLabel1 = new JLabel();
        jButton2 = new JButton();
        jLabel2 = new JLabel();
        comboBox1 = new JComboBox();
        comboBox2 = new JComboBox();
        jPanel2 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();

        //======== jPanel1 ========
        {
            jPanel1.setBorder(new TitledBorder(new LineBorder(Color.black, 2, true), "Dienas p\u0113c atne\u0161an\u0101s", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                new Font("Tahoma", Font.PLAIN, 24)));
            jPanel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax.
            swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border
            . TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog"
            ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,jPanel1. getBorder
            ( )) ); jPanel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java
            .beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException
            ( ); }} );

            //---- jButton1 ----
            jButton1.setText("MEKL\u0112T");
            jButton1.addActionListener(e -> jButton1ActionPerformed(e));

            //---- jLabel1 ----
            jLabel1.setText("Grupa:");

            //---- jButton2 ----
            jButton2.setText("ATPAKA\u013b");
            jButton2.addActionListener(e -> jButton2ActionPerformed(e));

            //---- jLabel2 ----
            jLabel2.setText("Dienu skaits");

            GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(62, 62, 62)
                                .addComponent(jButton2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup()
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboBox1, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                    .addComponent(comboBox2, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))))
                        .addGap(27, 27, 27))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup()
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup()
                            .addComponent(jLabel1)
                            .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup()
                            .addComponent(jLabel2)
                            .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addContainerGap(96, Short.MAX_VALUE))
            );
        }

        //======== jPanel2 ========
        {
            jPanel2.setBorder(new TitledBorder(new LineBorder(Color.black, 2, true), ""));

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

            GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup()
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 537, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup()
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                        .addContainerGap())
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(82, Short.MAX_VALUE)
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(37, 37, 37)
                    .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(48, 48, 48)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(107, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Jane Doe
    private JPanel jPanel1;
    private JButton jButton1;
    private JLabel jLabel1;
    private JButton jButton2;
    private JLabel jLabel2;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JPanel jPanel2;
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DayCount().setVisible(true);
            }
        });

    }

}
