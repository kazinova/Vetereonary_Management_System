/*
 * Created by JFormDesigner on Fri Apr 03 16:59:20 EEST 2020
 */

package Vetereonary.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Jane Doe
 */
public class Schemes extends JFrame {
    Connection c;
    public Schemes() {
        initComponents();
        setTitle("Vetereonary Management  System");
        setResizable(false);
        setLocationRelativeTo(null);
        try{

            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/vetDB", "root", "");
            dispplayList();
        }
        catch(Exception e){e.printStackTrace();}
    }
    private void dispplayList() {
        DefaultListModel model2 = new DefaultListModel();
        try{
            PreparedStatement ps = c.prepareStatement("SELECT table_name FROM information_schema.tables WHERE table_schema = 'vetdb' AND NOT TABLE_NAME='govis'");
            ResultSet set = ps.executeQuery();
            while (set.next()) //go through each row that your query returns
            {
                String comboBox2 = set.getString("table_name"); //get the element in column "item_code"
                model2.addElement(comboBox2); //add each item to the model
            }
            list1.setModel(model2);

        }
        catch(Exception e){e.printStackTrace();}

    }
    public void dispalyTable(){

    }

    private void button2ActionPerformed(ActionEvent e) {
        HomeSchemes homeSchemes = new HomeSchemes();
        homeSchemes.setVisible(true);
        this.dispose();
    }

    private void list1ValueChanged(ListSelectionEvent e) {
        if (list1.getSelectedValue().toString().isEmpty()) {
        } else {

            try {
                PreparedStatement ps = c.prepareStatement("select * from "+list1.getSelectedValue().toString()+";");
                ResultSet set = ps.executeQuery();
                set.next();
                String temp=set.getString("Nosaukums");
                set.previous();
                jTable1.setModel(DbUtils.resultSetToTableModel(set));
                PreparedStatement ps2 = c.prepareStatement("select * from govis where shēma='"+temp+"';");
                ResultSet set2 = ps2.executeQuery();
                jTable2.setModel(DbUtils.resultSetToTableModel(set2));
            } catch (Exception a) {
                a.printStackTrace();
            }
        }
    }
    private void button1ActionPerformed(ActionEvent e) {
            addCowScheme addCowScheme=new addCowScheme();
            addCowScheme.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Jane Doe
        panel2 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        panel3 = new JPanel();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        panel4 = new JPanel();
        jScrollPane2 = new JScrollPane();
        jTable2 = new JTable();
        button2 = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();

        //======== panel2 ========
        {
            panel2.setBorder(new TitledBorder(new LineBorder(Color.black, 2), "Sh\u0113ma", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                new Font("Tahoma", Font.PLAIN, 24)));
            panel2.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
            ( 0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax. swing. border. TitledBorder. CENTER, javax. swing. border
            . TitledBorder. BOTTOM, new java .awt .Font ("Dialo\u0067" ,java .awt .Font .BOLD ,12 ), java. awt
            . Color. red) ,panel2. getBorder( )) ); panel2. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
            propertyChange (java .beans .PropertyChangeEvent e) {if ("borde\u0072" .equals (e .getPropertyName () )) throw new RuntimeException( )
            ; }} );

            //======== jScrollPane1 ========
            {

                //---- jTable1 ----
                jTable1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, Color.black));
                jTable1.setModel(new DefaultTableModel(
                    new Object[][] {
                        {null, null, null, null},
                    },
                    new String[] {
                        "Title 1", null, null, null
                    }
                ));
                jTable1.setRowSelectionAllowed(false);
                jTable1.setAutoCreateRowSorter(true);
                jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                jScrollPane1.setViewportView(jTable1);
            }

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
            );
        }

        //======== panel3 ========
        {
            panel3.setBorder(new TitledBorder(new LineBorder(Color.black, 2), "Saraksts", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                new Font("Tahoma", Font.PLAIN, 24), Color.black));

            //======== scrollPane1 ========
            {

                //---- list1 ----
                list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                list1.setVisibleRowCount(2);
                list1.addListSelectionListener(e -> list1ValueChanged(e));
                scrollPane1.setViewportView(list1);
            }

            GroupLayout panel3Layout = new GroupLayout(panel3);
            panel3.setLayout(panel3Layout);
            panel3Layout.setHorizontalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(38, Short.MAX_VALUE))
            );
            panel3Layout.setVerticalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }

        //======== panel4 ========
        {
            panel4.setBorder(new LineBorder(Color.black, 2));

            //======== jScrollPane2 ========
            {

                //---- jTable2 ----
                jTable2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, null, Color.black));
                jTable2.setModel(new DefaultTableModel(
                    new Object[][] {
                        {null, null, null, null},
                    },
                    new String[] {
                        "Title 1", null, null, null
                    }
                ));
                jTable2.setAutoCreateRowSorter(true);
                jTable2.setRowSelectionAllowed(false);
                jScrollPane2.setViewportView(jTable2);
            }

            GroupLayout panel4Layout = new GroupLayout(panel4);
            panel4.setLayout(panel4Layout);
            panel4Layout.setHorizontalGroup(
                panel4Layout.createParallelGroup()
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)
                        .addGap(26, 26, 26))
            );
            panel4Layout.setVerticalGroup(
                panel4Layout.createParallelGroup()
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(31, Short.MAX_VALUE))
            );
        }

        //---- button2 ----
        button2.setText("ATPAKA\u013b");
        button2.addActionListener(e -> button2ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(button2, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)))
                    .addGap(51, 51, 51)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(6, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button2)
                            .addGap(29, 29, 29))))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Jane Doe
    private JPanel panel2;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JPanel panel3;
    private JScrollPane scrollPane1;
    private JList list1;
    private JPanel panel4;
    private JScrollPane jScrollPane2;
    private JTable jTable2;
    private JButton button2;
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
            new Schemes();
            }
        });

    }
}
