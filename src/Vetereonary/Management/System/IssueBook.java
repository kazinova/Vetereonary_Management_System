package Vetereonary.Management.System;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IssueBook extends javax.swing.JFrame {

    static Connection c;
    static String ISBN, SID;
    
    public IssueBook() {
        initComponents();
        setTitle("Library Management System");
        setResizable(false);
        setLocationRelativeTo(null);
        
        ISBN = "";
        SID = "";
        
        jLabel20.setText( new SimpleDateFormat("dd / MM / yyyy").format(new Date()) );
        
        try{
            Class.forName("com.mysql.jdbc.Driver");	   
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system", "root", "root");
        }
        catch(Exception e){e.printStackTrace();}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - Jane Doe
    private void initComponents() {
        jPanel3 = new JPanel();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jPanel5 = new JPanel();
        jLabel8 = new JLabel();
        jLabel3 = new JLabel();
        jLabel1 = new JLabel();
        jLabel7 = new JLabel();
        jButton1 = new JButton();
        jLabel6 = new JLabel();
        jLabel2 = new JLabel();
        jTextField1 = new JTextField();
        jLabel5 = new JLabel();
        jLabel4 = new JLabel();
        jLabel9 = new JLabel();
        jLabel19 = new JLabel();
        jPanel2 = new JPanel();
        jTextField2 = new JTextField();
        jLabel10 = new JLabel();
        jLabel17 = new JLabel();
        jLabel13 = new JLabel();
        jLabel18 = new JLabel();
        jLabel12 = new JLabel();
        jLabel16 = new JLabel();
        jLabel11 = new JLabel();
        jLabel14 = new JLabel();
        jButton2 = new JButton();
        jLabel15 = new JLabel();
        jLabel20 = new JLabel();
        jButton5 = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();

        //======== jPanel3 ========
        {
            jPanel3.setBorder(new TitledBorder(new LineBorder(Color.black, 2, true), "Issue Book", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                new Font("Tahoma", Font.PLAIN, 24)));
            jPanel3.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.
            EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border.TitledBorder.CENTER,javax.swing
            .border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog",java.awt.Font.BOLD,12),
            java.awt.Color.red),jPanel3. getBorder()));jPanel3. addPropertyChangeListener(new java.beans.PropertyChangeListener()
            {@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062order".equals(e.getPropertyName()))
            throw new RuntimeException();}});

            //---- jButton3 ----
            jButton3.setText("BACK");
            jButton3.addActionListener(e -> jButton3ActionPerformed(e));

            //---- jButton4 ----
            jButton4.setText("ISSUE BOOK");
            jButton4.addActionListener(e -> jButton4ActionPerformed(e));

            //======== jPanel5 ========
            {
                jPanel5.setBorder(new TitledBorder(new LineBorder(Color.black, 2), "Book Details", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                    new Font("Tahoma", Font.PLAIN, 18)));

                //---- jLabel8 ----
                jLabel8.setText("---");

                //---- jLabel3 ----
                jLabel3.setText("Author");

                //---- jLabel1 ----
                jLabel1.setText("ISBN ");

                //---- jLabel7 ----
                jLabel7.setText("---");

                //---- jButton1 ----
                jButton1.setText("Search");
                jButton1.addActionListener(e -> jButton1ActionPerformed(e));

                //---- jLabel6 ----
                jLabel6.setText("---");

                //---- jLabel2 ----
                jLabel2.setText("Title");

                //---- jLabel5 ----
                jLabel5.setText("Quantity");

                //---- jLabel4 ----
                jLabel4.setText("Price");

                //---- jLabel9 ----
                jLabel9.setText("---");

                GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
                jPanel5.setLayout(jPanel5Layout);
                jPanel5Layout.setHorizontalGroup(
                    jPanel5Layout.createParallelGroup()
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel5Layout.createParallelGroup()
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton1))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup()
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                    .addGap(32, 32, 32)
                                    .addGroup(jPanel5Layout.createParallelGroup()
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel6))))
                            .addContainerGap(42, Short.MAX_VALUE))
                );
                jPanel5Layout.setVerticalGroup(
                    jPanel5Layout.createParallelGroup()
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel6))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel7))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel8))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel9))
                            .addContainerGap())
                );
            }

            //---- jLabel19 ----
            jLabel19.setText("Date");

            //======== jPanel2 ========
            {
                jPanel2.setBorder(new TitledBorder(new LineBorder(Color.black, 2), "Student Details", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                    new Font("Tahoma", Font.PLAIN, 18)));

                //---- jLabel10 ----
                jLabel10.setText("Name");

                //---- jLabel17 ----
                jLabel17.setText("---");

                //---- jLabel13 ----
                jLabel13.setText("Email");

                //---- jLabel18 ----
                jLabel18.setText("---");

                //---- jLabel12 ----
                jLabel12.setText("Branch");

                //---- jLabel16 ----
                jLabel16.setText("---");

                //---- jLabel11 ----
                jLabel11.setText("Course");

                //---- jLabel14 ----
                jLabel14.setText("Student ID");

                //---- jButton2 ----
                jButton2.setText("Search");
                jButton2.addActionListener(e -> jButton2ActionPerformed(e));

                //---- jLabel15 ----
                jLabel15.setText("---");

                GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                    jPanel2Layout.createParallelGroup()
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel2Layout.createParallelGroup()
                                .addComponent(jLabel14)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11)
                                .addComponent(jLabel12)
                                .addComponent(jLabel13))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup()
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton2))
                                .addComponent(jLabel18)
                                .addComponent(jLabel17)
                                .addComponent(jLabel16)
                                .addComponent(jLabel15))
                            .addContainerGap(34, Short.MAX_VALUE))
                );
                jPanel2Layout.setVerticalGroup(
                    jPanel2Layout.createParallelGroup()
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14)
                                .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup()
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel11)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel12)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel13))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel16)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel17)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel18)))
                            .addContainerGap())
                );
            }

            //---- jLabel20 ----
            jLabel20.setText("current_date_here");

            //---- jButton5 ----
            jButton5.setText("STATISTICS");
            jButton5.addActionListener(e -> jButton5ActionPerformed(e));

            GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
            jPanel3.setLayout(jPanel3Layout);
            jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup()
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(jPanel3Layout.createParallelGroup()
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(56, 56, 56)
                                        .addComponent(jLabel20)
                                        .addGap(72, 72, 72))
                                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jButton5)
                                        .addGap(35, 35, 35)
                                        .addComponent(jButton4)
                                        .addGap(35, 35, 35)
                                        .addComponent(jButton3)))))
                        .addContainerGap(30, Short.MAX_VALUE))
            );
            jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup()
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup()
                            .addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton4)
                            .addComponent(jButton5))
                        .addContainerGap())
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(50, 50, 50))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        if ( jTextField2.getText().isEmpty() ){
            jLabel15.setText( "---" );
            jLabel16.setText( "---" );
            jLabel17.setText( "---" );
            jLabel18.setText( "---" );
            JOptionPane.showMessageDialog(new JFrame(), "The fields cannot be left blank.", "Message" , JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            
            try{
                ResultSet rs;
                PreparedStatement ps = c.prepareStatement("select * from Student where SID = ?; ");
                ps.setString(1,jTextField2.getText());
                rs = ps.executeQuery();
                
                while(true){
                    if (rs.next()){
                        SID = rs.getString("SID");
                        jLabel15.setText( rs.getString("Name") );
                        jLabel16.setText( rs.getString("Course") );
                        jLabel17.setText( rs.getString("Branch") );
                        jLabel18.setText( rs.getString("Email") );
                        break;    
                    }
                    else{
                        jLabel15.setText( "---" );
                        jLabel16.setText( "---" );
                        jLabel17.setText( "---" );
                        jLabel18.setText( "---" );
                        JOptionPane.showMessageDialog(new JFrame(), "Student Not Found in Database.", "Message" , JOptionPane.INFORMATION_MESSAGE);
                        jTextField2.setText("");
                        break;
                    }
                }
           
            } catch(Exception e) {e.printStackTrace();}
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        if ( jTextField1.getText().isEmpty() || jTextField2.getText().isEmpty() ){
            JOptionPane.showMessageDialog(new JFrame(), "The fields cannot be left blank.", "Message" , JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            
            try{
            
                String date = new SimpleDateFormat("yyMMdd").format(new Date());
                
                PreparedStatement ps = c.prepareStatement("insert into Record values(?,?,?,null); ");
                ps.setString(1, SID);
                ps.setString(2, ISBN);
                ps.setString(3, date);
                ps.execute();
                
                ps = c.prepareStatement("update Book set Quantity = Quantity-1 where ISBN = ?; ");
                ps.setString(1, ISBN);
                ps.execute();
                
                JOptionPane.showMessageDialog(new JFrame(), "Book Issued Successfully.", "Message" , JOptionPane.INFORMATION_MESSAGE);
                
            }
            catch(Exception e) { 
                e.printStackTrace(); 
                JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Message" , JOptionPane.INFORMATION_MESSAGE);
            }
            
            
            
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        Home home = new Home();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if ( jTextField1.getText().isEmpty() ){
            jLabel6.setText( "---" );
            jLabel7.setText( "---" );
            jLabel8.setText( "---" );
            jLabel9.setText( "---" );
            JOptionPane.showMessageDialog(new JFrame(), "The fields cannot be left blank.", "Message" , JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            
            try{
                ResultSet rs;
                PreparedStatement ps = c.prepareStatement("select * from Book where ISBN = ?; ");
                ps.setString(1,jTextField1.getText());
                rs = ps.executeQuery();

                while(true){
                    if (rs.next()){
                        ISBN = rs.getString("ISBN");
                        jLabel6.setText( rs.getString("Title") );
                        jLabel7.setText( rs.getString("Author") );
                        jLabel8.setText( rs.getString("Price") );
                        jLabel9.setText( rs.getString("Quantity") );
                        break;    
                    }
                    else{
                        jLabel6.setText( "---" );
                        jLabel7.setText( "---" );
                        jLabel8.setText( "---" );
                        jLabel9.setText( "---" );
                        JOptionPane.showMessageDialog(new JFrame(), "Book Not Found in Database.", "Message" , JOptionPane.INFORMATION_MESSAGE);
                        jTextField1.setText("");
                        break;
                    }
                }
           
            } catch(Exception e) {e.printStackTrace();}
           
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        Record record = new Record();
        record.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Jane Doe
    private JPanel jPanel3;
    private JButton jButton3;
    private JButton jButton4;
    private JPanel jPanel5;
    private JLabel jLabel8;
    private JLabel jLabel3;
    private JLabel jLabel1;
    private JLabel jLabel7;
    private JButton jButton1;
    private JLabel jLabel6;
    private JLabel jLabel2;
    private JTextField jTextField1;
    private JLabel jLabel5;
    private JLabel jLabel4;
    private JLabel jLabel9;
    private JLabel jLabel19;
    private JPanel jPanel2;
    private JTextField jTextField2;
    private JLabel jLabel10;
    private JLabel jLabel17;
    private JLabel jLabel13;
    private JLabel jLabel18;
    private JLabel jLabel12;
    private JLabel jLabel16;
    private JLabel jLabel11;
    private JLabel jLabel14;
    private JButton jButton2;
    private JLabel jLabel15;
    private JLabel jLabel20;
    private JButton jButton5;
    // End of variables declaration//GEN-END:variables
}
