package Vetereonary.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class NewStudent extends javax.swing.JFrame {

    static Connection c;
    
    public NewStudent() {
        initComponents();
        setTitle("Library Management System");
        setResizable(false);
        setLocationRelativeTo(null);
        jTable1.setEnabled(false);
        
        try{
            Class.forName("com.mysql.jdbc.Driver");	   
            c = DriverManager.getConnection("jdbc:mysql://db_ip:3306/users/login-users", "root", "");
        
            displaytable();
        }
        catch(Exception e){e.printStackTrace();}
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - Jane Doe
    private void initComponents() {
        jPanel1 = new JPanel();
        jLabel4 = new JLabel();
        jLabel3 = new JLabel();
        jTextField1 = new JTextField();
        jLabel5 = new JLabel();
        jTextField3 = new JTextField();
        jButton2 = new JButton();
        jComboBox1 = new JComboBox<>();
        jButton1 = new JButton();
        jTextField2 = new JTextField();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jTextField4 = new JTextField();
        jPanel2 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();

        //======== jPanel1 ========
        {
            jPanel1.setBorder(new TitledBorder(new LineBorder(Color.black, 2), "New Student", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                new Font("Tahoma", Font.PLAIN, 24)));
            jPanel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new
            javax . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax
            . swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java
            . awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt
            . Color .red ) ,jPanel1. getBorder () ) ); jPanel1. addPropertyChangeListener( new java. beans .
            PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "bord\u0065r" .
            equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );

            //---- jLabel4 ----
            jLabel4.setText("Branch");

            //---- jLabel3 ----
            jLabel3.setText("Course");

            //---- jLabel5 ----
            jLabel5.setText("Email");

            //---- jButton2 ----
            jButton2.setText("BACK");
            jButton2.addActionListener(e -> jButton2ActionPerformed(e));

            //---- jComboBox1 ----
            jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                "F.Y.B tech",
                "S.Y.B tech",
                "T.Y.B tech",
                "B.E"
            }));

            //---- jButton1 ----
            jButton1.setText("ADD STUDENT");
            jButton1.addActionListener(e -> jButton1ActionPerformed(e));

            //---- jLabel1 ----
            jLabel1.setText("Student ID");

            //---- jLabel2 ----
            jLabel2.setText("Name");

            GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup()
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(43, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(52, 52, 52)
                        .addComponent(jButton2)
                        .addGap(54, 54, 54))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup()
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField3)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)
                            .addComponent(jComboBox1, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                            .addComponent(jTextField4))
                        .addGap(30, 30, 30))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup()
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addContainerGap(31, Short.MAX_VALUE))
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
                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                        .addContainerGap())
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(45, 45, 45)
                    .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(35, 35, 35))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(35, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
    }// </editor-fold>//GEN-END:initComponents

    private void displaytable(){
        
        try{
            PreparedStatement ps = c.prepareStatement("select * from Student;");
            ResultSet set = ps.executeQuery();
            
            jTable1.setModel(DbUtils.resultSetToTableModel(set));
        }
        catch(Exception e){e.printStackTrace();}
        
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        Home home = new Home();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if ( jTextField1.getText().isEmpty() || jTextField2.getText().isEmpty() || jTextField3.getText().isEmpty() || jTextField4.getText().isEmpty() ){
            JOptionPane.showMessageDialog(new JFrame(), "The fields cannot be left blank.", "Message" , JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            try{
                int SID = Integer.parseInt( jTextField1.getText() );
                String Name = jTextField2.getText();
                String Course = jComboBox1.getSelectedItem().toString();
                String Branch = jTextField3.getText();
                String Email = jTextField4.getText();

                PreparedStatement stmt = c.prepareStatement("insert into Student values('"+SID+"','"+Name+"','"+Course+"','"+Branch+"','"+Email+"') ");
                stmt.execute();
                displaytable();
                JOptionPane.showMessageDialog(new JFrame(), "Student Added Successfully !", "Message" , JOptionPane.INFORMATION_MESSAGE);
                
                jTextField1.setText("");
                jTextField2.setText("");
                jComboBox1.setSelectedIndex(0);
                jTextField3.setText("");
                jTextField4.setText("");
            }
            catch(Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Message" , JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Jane Doe
    private JPanel jPanel1;
    private JLabel jLabel4;
    private JLabel jLabel3;
    private JTextField jTextField1;
    private JLabel jLabel5;
    private JTextField jTextField3;
    private JButton jButton2;
    private JComboBox<String> jComboBox1;
    private JButton jButton1;
    private JTextField jTextField2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JTextField jTextField4;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
