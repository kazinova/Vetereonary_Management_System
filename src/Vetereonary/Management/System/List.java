/*
 * Created by JFormDesigner on Tue Mar 31 11:33:17 EEST 2020
 */

package Vetereonary.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Jane Doe
 */
public class List extends JFrame {

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
        DefaultListModel model = new DefaultListModel();

                try{
                    PreparedStatement ps = c.prepareStatement("select * from govis;");
                    ResultSet set = ps.executeQuery();

                    jTable1.setModel(DbUtils.resultSetToTableModel(set));
                }
                catch(Exception e){e.printStackTrace();}


        try{
            PreparedStatement ps = c.prepareStatement("select DISTINCT grupa from govis ORDER BY grupa;");
            ResultSet set = ps.executeQuery();

            while (set.next()) //go through each row that your query returns
            {
                String ItemList2 = set.getString("grupa"); //get the element in column "item_code"
                model.addElement(ItemList2); //add each item to the model
            }
            list1.setModel(model);
        }
        catch(Exception e){e.printStackTrace();}

    }

    private void jTextField4ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton2ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void list1ValueChanged(ListSelectionEvent e) {
        try{
            Object item= list1.getSelectedValue();
            String item2= item.toString();
            int grupa = Integer.parseInt(item2);
            PreparedStatement ps = c.prepareStatement("select * from govis where grupa=?;");
            ps.setInt(1,grupa);
            ResultSet set = ps.executeQuery();

            jTable1.setModel(DbUtils.resultSetToTableModel(set));
        }
        catch(Exception a){a.printStackTrace();}
    }

    private void button1ActionPerformed(ActionEvent e) {
        list1.clearSelection();
        displaytable();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Jane Doe
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        label1 = new JLabel();
        button1 = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();

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

        //======== scrollPane1 ========
        {

            //---- list1 ----
            list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            list1.addListSelectionListener(e -> list1ValueChanged(e));
            scrollPane1.setViewportView(list1);
        }

        //---- label1 ----
        label1.setText("Grupa");

        //---- button1 ----
        button1.setText("VISAS");
        button1.addActionListener(e -> button1ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(button1)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)))
                            .addGap(70, 70, 70)
                            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 531, GroupLayout.PREFERRED_SIZE)
                            .addGap(116, 116, 116))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(button1)
                            .addContainerGap(196, Short.MAX_VALUE))
                        .addComponent(jScrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Jane Doe
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JScrollPane scrollPane1;
    private JList list1;
    private JLabel label1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new List().setVisible(true);
            }
        });
    }
}
