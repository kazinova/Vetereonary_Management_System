package Vetereonary.Management.System;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class About extends javax.swing.JFrame {

    public About() {
        initComponents();
        setTitle("Library Managent System");
        setResizable(false);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - Jane Doe
    private void initComponents() {
        jLabel1 = new JLabel();
        jButton1 = new JButton();
        jPanel1 = new JPanel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel7 = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();

        //---- jLabel1 ----
        jLabel1.setFont(new Font("Times New Roman", Font.BOLD, 24));
        jLabel1.setText("Library Management System");

        //---- jButton1 ----
        jButton1.setFont(new Font("Tahoma", Font.BOLD, 11));
        jButton1.setText("BACK TO LOGIN");
        jButton1.addActionListener(e -> jButton1ActionPerformed(e));

        //======== jPanel1 ========
        {
            jPanel1.setBorder(new TitledBorder(new LineBorder(Color.black, 2, true), "CREATED BY :-", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                new Font("Times New Roman", Font.BOLD, 18)));
            jPanel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
            ( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder. CENTER, javax. swing. border
            . TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt
            . Color. red) ,jPanel1. getBorder( )) ); jPanel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
            propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException( )
            ; }} );

            //---- jLabel8 ----
            jLabel8.setFont(new Font("Arial", Font.PLAIN, 12));
            jLabel8.setText("~  JAY PATIL                               PC  20");

            //---- jLabel9 ----
            jLabel9.setFont(new Font("Arial", Font.PLAIN, 12));
            jLabel9.setText("~  KARON SHAH                       PC  31");

            //---- jLabel5 ----
            jLabel5.setFont(new Font("Arial", Font.PLAIN, 12));
            jLabel5.setText("~  MOHIT GARG                         PC  37");

            //---- jLabel6 ----
            jLabel6.setFont(new Font("Arial", Font.PLAIN, 12));
            jLabel6.setText("~  MAITREYA DAROKAR          PC  04");

            //---- jLabel3 ----
            jLabel3.setFont(new Font("Arial", Font.PLAIN, 12));
            jLabel3.setText("~  KRISHNA PATIL                     PC  59");

            //---- jLabel4 ----
            jLabel4.setFont(new Font("Arial", Font.PLAIN, 12));
            jLabel4.setText("~  KARTIKEYA PANDE              PC  13 ");

            //---- jLabel7 ----
            jLabel7.setFont(new Font("Arial", Font.PLAIN, 12));
            jLabel7.setText("~  JENIL JAIN                             PC  46");

            GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup()
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup()
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(45, 45, 45))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup()
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel3)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addGap(20, 20, 20))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(130, 130, 130)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(223, 223, 223)
                            .addComponent(jButton1)))
                    .addGap(130, 130, 130))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(jLabel1)
                    .addGap(40, 40, 40)
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(42, 42, 42)
                    .addComponent(jButton1)
                    .addGap(40, 40, 40))
        );
        pack();
        setLocationRelativeTo(getOwner());
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Jane Doe
    private JLabel jLabel1;
    private JButton jButton1;
    private JPanel jPanel1;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
