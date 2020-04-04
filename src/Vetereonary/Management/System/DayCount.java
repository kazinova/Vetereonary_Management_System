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
import java.awt.event.ItemEvent;
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
        DefaultTableModel model3 = new DefaultTableModel();
        mode2.addElement("8");
        mode2.addElement("30");
        comboBox2.setModel(mode2);
        setTitle("Vetereonary Management  System");
        setResizable(false);
        setLocationRelativeTo(null);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable3.getTableHeader().setReorderingAllowed(false);

        try{
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/vetDB", "root", "");
        }
        catch(Exception e){e.printStackTrace();}
        try{
            PreparedStatement ps = c.prepareStatement("select grupa from govis GROUP BY Grupa ORDER BY grupa;");
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
        displaytable();


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
                PreparedStatement ps = c.prepareStatement("SELECT* from govis WHERE (DATEDIFF(CURRENT_DATE,Atnešanās_datums)=6 OR DATEDIFF(CURRENT_DATE,Atnešanās_datums)=7) AND Grupa="+grupa+";");
                ResultSet set = ps.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(set));
                ps = c.prepareStatement("SELECT* from govis WHERE DATEDIFF(CURRENT_DATE,Atnešanās_datums)=8 AND Grupa="+grupa+";");
                set = ps.executeQuery();
                jTable2.setModel(DbUtils.resultSetToTableModel(set));
                ps = c.prepareStatement("SELECT* from govis WHERE (DATEDIFF(CURRENT_DATE,Atnešanās_datums)=9 OR DATEDIFF(CURRENT_DATE,Atnešanās_datums)=10) AND Grupa="+grupa+";");
                set = ps.executeQuery();
                jTable3.setModel(DbUtils.resultSetToTableModel(set));

            }
            catch(SQLException e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                PreparedStatement ps = c.prepareStatement("SELECT* from govis WHERE DATEDIFF(CURRENT_DATE,Atnešanās_datums)=28 OR DATEDIFF(CURRENT_DATE,Atnešanās_datums)=29 AND Grupa="+grupa+";");
                ResultSet set = ps.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(set));
                ps = c.prepareStatement("SELECT* from govis WHERE DATEDIFF(CURRENT_DATE,Atnešanās_datums)=30;");
                set = ps.executeQuery();
                jTable2.setModel(DbUtils.resultSetToTableModel(set));
                ps = c.prepareStatement("SELECT* from govis WHERE DATEDIFF(CURRENT_DATE,Atnešanās_datums)=31 OR DATEDIFF(CURRENT_DATE,Atnešanās_datums)=32 AND Grupa="+grupa+";");
                set = ps.executeQuery();
                jTable3.setModel(DbUtils.resultSetToTableModel(set));

            }
            catch(SQLException e) {
                e.printStackTrace();
            }
        }



    }

    private void jButton1ActionPerformed(ActionEvent e) {
        displaytable();
    }

    private void jButton2ActionPerformed(ActionEvent e) {
        HomeCow homeCow = new HomeCow();
        homeCow.setVisible(true);
        this.dispose();
    }

    private void comboBox1ItemStateChanged(ItemEvent e) {
        displaytable();
    }

    private void comboBox2ItemStateChanged(ItemEvent e) {
        displaytable();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Jane Doe
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jButton2 = new JButton();
        jLabel2 = new JLabel();
        comboBox1 = new JComboBox();
        comboBox2 = new JComboBox();
        jPanel2 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jPanel3 = new JPanel();
        jScrollPane2 = new JScrollPane();
        jTable2 = new JTable();
        jPanel4 = new JPanel();
        jScrollPane3 = new JScrollPane();
        jTable3 = new JTable();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();

        //======== jPanel1 ========
        {
            jPanel1.setBorder(new TitledBorder(new LineBorder(Color.black, 2, true), "Dienas p\u0113c atne\u0161an\u0101s", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                new Font("Tahoma", Font.PLAIN, 24)));
            jPanel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (
            new javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e"
            , javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
            , new java .awt .Font ("Dialo\u0067" ,java .awt .Font .BOLD ,12 )
            , java. awt. Color. red) ,jPanel1. getBorder( )) ); jPanel1. addPropertyChangeListener (
            new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
            ) {if ("borde\u0072" .equals (e .getPropertyName () )) throw new RuntimeException( )
            ; }} );

            //---- jLabel1 ----
            jLabel1.setText("Grupa:");

            //---- jButton2 ----
            jButton2.setText("ATPAKA\u013b");
            jButton2.addActionListener(e -> jButton2ActionPerformed(e));

            //---- jLabel2 ----
            jLabel2.setText("Dienu skaits");

            //---- comboBox1 ----
            comboBox1.addItemListener(e -> comboBox1ItemStateChanged(e));

            //---- comboBox2 ----
            comboBox2.addItemListener(e -> comboBox2ItemStateChanged(e));

            GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
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
                        .addComponent(jButton2)
                        .addContainerGap(106, Short.MAX_VALUE))
            );
        }

        //======== jPanel2 ========
        {
            jPanel2.setBorder(new TitledBorder(new LineBorder(Color.black, 2, true), "Tuvoj\u0101s", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                new Font("Tahoma", Font.PLAIN, 20)));
            jPanel2.setBackground(Color.yellow);

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
                jTable1.setRowSelectionAllowed(false);
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
                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                        .addContainerGap())
            );
        }

        //======== jPanel3 ========
        {
            jPanel3.setBorder(new TitledBorder(new LineBorder(Color.black, 2, true), "\u0160odien", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                new Font("Tahoma", Font.PLAIN, 20)));
            jPanel3.setBackground(Color.green);

            //======== jScrollPane2 ========
            {

                //---- jTable2 ----
                jTable2.setBorder(new TitledBorder(""));
                jTable2.setModel(new DefaultTableModel(
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
                jTable2.setRowSelectionAllowed(false);
                jScrollPane2.setViewportView(jTable2);
            }

            GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
            jPanel3.setLayout(jPanel3Layout);
            jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 537, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
            );
            jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
            );
        }

        //======== jPanel4 ========
        {
            jPanel4.setBorder(new TitledBorder(new LineBorder(Color.black, 2, true), "Pag\u0101jis", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                new Font("Tahoma", Font.PLAIN, 20)));
            jPanel4.setBackground(Color.red);

            //======== jScrollPane3 ========
            {

                //---- jTable3 ----
                jTable3.setBorder(new TitledBorder(""));
                jTable3.setModel(new DefaultTableModel(
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
                jTable3.setRowSelectionAllowed(false);
                jScrollPane3.setViewportView(jTable3);
            }

            GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
            jPanel4.setLayout(jPanel4Layout);
            jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup()
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 537, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
            );
            jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup()
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                        .addContainerGap())
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(21, 21, 21))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                    .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(24, 24, 24))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Jane Doe
    private JPanel jPanel1;
    private JLabel jLabel1;
    private JButton jButton2;
    private JLabel jLabel2;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JPanel jPanel3;
    private JScrollPane jScrollPane2;
    private JTable jTable2;
    private JPanel jPanel4;
    private JScrollPane jScrollPane3;
    private JTable jTable3;
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
