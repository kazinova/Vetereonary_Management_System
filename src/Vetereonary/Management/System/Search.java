/*
 * Created by JFormDesigner on Wed Apr 01 16:41:29 EEST 2020
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
public class Search extends javax.swing.JFrame {
    Connection c;
    public Search() {

        initComponents();
        setTitle("Vetereonary Management  System");
        setResizable(false);
        setLocationRelativeTo(null);
        jTable1.setEnabled(false);
        DefaultComboBoxModel model = new DefaultComboBoxModel();

        try{
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/vetDB", "root", "");

        }
        catch(Exception e){e.printStackTrace();}

        try{
            PreparedStatement ps = c.prepareStatement("SELECT * FROM govis;");
            ResultSet set = ps.executeQuery();
            ResultSetMetaData rsMetaData = ps.getMetaData();
            int numberOfColumns = rsMetaData.getColumnCount();
            for (int i = 1; i < numberOfColumns + 1; i++){

                String  comboBox1= rsMetaData.getColumnName(i)  ; //get the element in column "item_code"
                model.addElement(comboBox1); //add each item to the model
            }

//            }
            comboBox1.setModel(model);
        }
        catch(Exception e){e.printStackTrace();}
    }



    private void jTextField4ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton1ActionPerformed(ActionEvent e) {

        if ( jTextField2.getText().isEmpty()){
            JOptionPane.showMessageDialog(new JFrame(), "Nav aizpildīta meklēšanas aile.", "Message" , JOptionPane.INFORMATION_MESSAGE);
        }
        else{

            try {
                PreparedStatement ps = c.prepareStatement("select * from govis where "+ comboBox1.getSelectedItem().toString()+"=?");
                ps.setString(1, jTextField2.getText());
                ResultSet set = ps.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(set));
            }catch(Exception a) {
                a.printStackTrace();
                JOptionPane.showMessageDialog(new JFrame(), "Nav pareizi aizpildīti lauki!", "Message" , JOptionPane.INFORMATION_MESSAGE);
            }
        }
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
        jTextField2 = new JTextField();
        jLabel2 = new JLabel();
        comboBox1 = new JComboBox();
        jPanel2 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();

        //======== jPanel1 ========
        {
            jPanel1.setBorder(new TitledBorder(new LineBorder(Color.black, 2, true), "Mekl\u0113t govi", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                new Font("Tahoma", Font.PLAIN, 24)));
            jPanel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
            . EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax
            . swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,
            12 ), java. awt. Color. red) ,jPanel1. getBorder( )) ); jPanel1. addPropertyChangeListener (new java. beans
            . PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .
            getPropertyName () )) throw new RuntimeException( ); }} );

            //---- jButton1 ----
            jButton1.setText("MEKL\u0112T");
            jButton1.addActionListener(e -> jButton1ActionPerformed(e));

            //---- jLabel1 ----
            jLabel1.setText("Mekl\u0113t p\u0113c");

            //---- jButton2 ----
            jButton2.setText("ATPAKA\u013b");
            jButton2.addActionListener(e -> jButton2ActionPerformed(e));

            //---- jLabel2 ----
            jLabel2.setText("Atsl\u0113ga");

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
                                    .addComponent(jTextField2, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))))
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
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addContainerGap(89, Short.MAX_VALUE)
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(36, 36, 36)
                    .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(48, 48, 48)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private JTextField jTextField2;
    private JLabel jLabel2;
    private JComboBox comboBox1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Search().setVisible(true);

            }
        });
    }
}
