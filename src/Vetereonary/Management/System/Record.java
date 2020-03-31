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

public class Record extends javax.swing.JFrame {

    static Connection c;
    
    public Record() {
        initComponents();
        setTitle("Library Management System");
        setResizable(false);
        setLocationRelativeTo(null);
        jTable1.setEnabled(false);
        
        try{
            Class.forName("com.mysql.jdbc.Driver");	   
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system", "root", "root");   
        
            PreparedStatement ps = c.prepareStatement("select s.SID, s.Name, b.ISBN, b.Title, r.IssueDate, r.ReturnDate from Student s, Book b, Record r where r.SID=s.SID AND r.ISBN=b.ISBN; ");
            ResultSet set = ps.executeQuery();
            
            jTable1.setModel(DbUtils.resultSetToTableModel(set));
        }
        catch(Exception e){e.printStackTrace();}
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - Jane Doe
    private void initComponents() {
        jPanel1 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jPanel2 = new JPanel();
        jButton3 = new JButton();
        jButton2 = new JButton();
        jButton1 = new JButton();
        jButton4 = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();

        //======== jPanel1 ========
        {
            jPanel1.setBorder(new TitledBorder(new LineBorder(Color.black, 2, true), "", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                new Font("Tahoma", Font.PLAIN, 18)));
            jPanel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder (
            new javax . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion"
            , javax. swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM
            , new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 )
            ,java . awt. Color .red ) ,jPanel1. getBorder () ) ); jPanel1. addPropertyChangeListener(
            new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
            ) { if( "bord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( )
            ;} } );

            //======== jScrollPane1 ========
            {

                //---- jTable1 ----
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

            GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup()
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup()
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
            );
        }

        //======== jPanel2 ========
        {
            jPanel2.setBorder(new TitledBorder(new LineBorder(Color.black, 2, true), ""));

            //---- jButton3 ----
            jButton3.setText("Transaction Details");
            jButton3.addActionListener(e -> jButton3ActionPerformed(e));

            //---- jButton2 ----
            jButton2.setText("Book Details");
            jButton2.addActionListener(e -> jButton2ActionPerformed(e));

            //---- jButton1 ----
            jButton1.setText("Student Details");
            jButton1.addActionListener(e -> jButton1ActionPerformed(e));

            //---- jButton4 ----
            jButton4.setText("     BACK     ");
            jButton4.addActionListener(e -> jButton4ActionPerformed(e));

            GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup()
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jButton2)
                        .addGap(40, 40, 40)
                        .addComponent(jButton1)
                        .addGap(52, 52, 52)
                        .addComponent(jButton3)
                        .addGap(48, 48, 48)
                        .addComponent(jButton4)
                        .addGap(35, 35, 35))
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup()
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4))
                        .addContainerGap())
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(50, 50, 50))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30)
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(50, 50, 50))
        );
        pack();
        setLocationRelativeTo(getOwner());
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try{
            PreparedStatement ps = c.prepareStatement("select * from Book;");
            ResultSet set = ps.executeQuery();
            
            jTable1.setModel(DbUtils.resultSetToTableModel(set));
        }
        catch(Exception e){e.printStackTrace();}
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        try{
            PreparedStatement ps = c.prepareStatement("select s.SID, s.Name, b.ISBN, b.Title, r.IssueDate, r.ReturnDate from Student s, Book b, Record r where r.SID=s.SID AND r.ISBN=b.ISBN; ");
            ResultSet set = ps.executeQuery();
            
            jTable1.setModel(DbUtils.resultSetToTableModel(set));
        }
        catch(Exception e){e.printStackTrace();}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try{
            PreparedStatement ps = c.prepareStatement("select * from Student;");
            ResultSet set = ps.executeQuery();
            
            jTable1.setModel(DbUtils.resultSetToTableModel(set));
        }
        catch(Exception e){e.printStackTrace();}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        Home home = new Home();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Jane Doe
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JPanel jPanel2;
    private JButton jButton3;
    private JButton jButton2;
    private JButton jButton1;
    private JButton jButton4;
    // End of variables declaration//GEN-END:variables
}
