/*
 * Created by JFormDesigner on Tue Mar 31 16:02:37 EEST 2020
 */

package Vetereonary.Management.System;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;

/**
 * @author Jane Doe
 */
public class Edit extends JFrame {
    static Connection c;
    public Edit() {
        initComponents();
        setTitle("Vetereonary Management  System");
        setResizable(false);
        setLocationRelativeTo(null);
        try{
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/vetDB", "root", "");
        }
        catch(Exception e){e.printStackTrace();}

    }

    private void jTextField4ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton1ActionPerformed(ActionEvent e) {
        if ( textField1.getText().isEmpty()){
            JOptionPane.showMessageDialog(new JFrame(), "Nav aizpildīta meklēšanas aile.", "Message" , JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            if ( jTextField2.getText().length()!=4){
                JOptionPane.showMessageDialog(new JFrame(), "Nav pareizi aipildiīt lauki.", "Message" , JOptionPane.INFORMATION_MESSAGE);
            }
            else{
            try {
                PreparedStatement ps = c.prepareStatement("update govis set Vārds=?, Numurs=?, Atnešanās_datums=?, Grupa=? where Numurs=?; ");
                ps.setString(1, jTextField1.getText());
                ps.setInt(2, Integer.parseInt(jTextField2.getText()));
                ps.setDate(3, java.sql.Date.valueOf(jTextField4.getText()));
                ps.setInt(4, Integer.parseInt(jTextField3.getText()));
                ps.setInt(5, Integer.parseInt(textField1.getText()));
                ps.execute();
                JOptionPane.showMessageDialog(new JFrame(), "Lauki ir rediģēti!", "Message" , JOptionPane.INFORMATION_MESSAGE);
            }catch(Exception a) {
                a.printStackTrace();
                JOptionPane.showMessageDialog(new JFrame(), "Nav pareizi aizpildīti lauki!", "Message" , JOptionPane.INFORMATION_MESSAGE);
            }}
        }
    }

    private void jButton2ActionPerformed(ActionEvent e)  {
        if ( textField1.getText().isEmpty()){
            JOptionPane.showMessageDialog(new JFrame(), "Nav aizpildīta meklēšanas aile.", "Message" , JOptionPane.INFORMATION_MESSAGE);
        }
        else{

            try {
                PreparedStatement ps = c.prepareStatement("delete from govis where Numurs=? ");
                ps.setString(1, textField1.getText());
                ps.execute();
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                jTextField4.setText("");
            }catch(Exception a) {
                a.printStackTrace();
                JOptionPane.showMessageDialog(new JFrame(), "Nav izdevies izdzēst ierakstu!", "Message" , JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

    private void button1ActionPerformed(ActionEvent e) {
        if ( textField1.getText().isEmpty()){
            JOptionPane.showMessageDialog(new JFrame(), "Nav aizpildīta meklēšanas aile", "Message" , JOptionPane.INFORMATION_MESSAGE);
        }
        else{

            try{
                ResultSet rs;
                PreparedStatement ps = c.prepareStatement("select * from govis where Numurs = ?; ");
                ps.setString(1,textField1.getText());
                rs = ps.executeQuery();

                while(true){
                    if (rs.next()){
                        jTextField1.setText(rs.getString("Vārds"));
                        jTextField2.setText(rs.getString("Numurs"));
                        jTextField4.setText(rs.getString("Atnešanās_datums"));
                        jTextField3.setText(rs.getString("Grupa"));
                        System.out.println(jTextField1.getText());

                        break;
                    }
                    else{
                        jTextField1.setText( "" );
                        jTextField2.setText( "" );
                        jTextField3.setText( "" );
                        jTextField4.setText( "" );
                        JOptionPane.showMessageDialog(new JFrame(), "Govs nav atrasta", "Message" , JOptionPane.INFORMATION_MESSAGE);
                        textField1.setText("");
                        break;
                    }
                }

            } catch(Exception a) {a.printStackTrace();}
        }
    }

    private void button2ActionPerformed(ActionEvent e) {
        Home home = new Home();
        home.setVisible(true);
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Jane Doe
        jPanel1 = new JPanel();
        jTextField4 = new JTextField();
        jTextField1 = new JTextField();
        jButton1 = new JButton();
        jLabel1 = new JLabel();
        jButton2 = new JButton();
        jTextField2 = new JTextField();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jTextField3 = new JTextField();
        jLabel2 = new JLabel();
        jLabel5 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]"));

        //======== jPanel1 ========
        {
            jPanel1.setBorder(new TitledBorder(new LineBorder(Color.black, 2, true), "Redi\u0123\u0113t govi", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                new Font("Tahoma", Font.PLAIN, 24)));
            jPanel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax
            . swing. border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing
            . border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .
            Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red
            ) ,jPanel1. getBorder( )) ); jPanel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override
            public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName (
            ) )) throw new RuntimeException( ); }} );

            //---- jTextField4 ----
            jTextField4.addActionListener(e -> jTextField4ActionPerformed(e));

            //---- jButton1 ----
            jButton1.setText("REDI\u0122\u0112T");
            jButton1.addActionListener(e -> jButton1ActionPerformed(e));

            //---- jLabel1 ----
            jLabel1.setText("V\u0101rds");

            //---- jButton2 ----
            jButton2.setText("DZ\u0112ST");
            jButton2.addActionListener(e -> jButton2ActionPerformed(e));

            //---- jLabel3 ----
            jLabel3.setText("Grupa");

            //---- jLabel4 ----
            jLabel4.setText("Dzim\u0161anas datums (\"yyyy-mm-dd\")");

            //---- jLabel2 ----
            jLabel2.setText("Numurs (\"####\")");

            //---- jLabel5 ----
            jLabel5.setText("Mekl\u0113jamais numurs");

            //---- button1 ----
            button1.setText("ATRAST");
            button1.addActionListener(e -> button1ActionPerformed(e));

            //---- button2 ----
            button2.setText("ATPAKA\u013b");
            button2.addActionListener(e -> button2ActionPerformed(e));

            GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup()
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup()
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(button2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup()
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))))
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup()
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField1, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                                    .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)))
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup()
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup()
                            .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(button2)
                            .addComponent(jButton2))
                        .addContainerGap())
            );
        }
        contentPane.add(jPanel1, "cell 0 0");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Jane Doe
    private JPanel jPanel1;
    private JTextField jTextField4;
    private JTextField jTextField1;
    private JButton jButton1;
    private JLabel jLabel1;
    private JButton jButton2;
    private JTextField jTextField2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JTextField jTextField3;
    private JLabel jLabel2;
    private JLabel jLabel5;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String args[]) throws SQLException {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Edit().setVisible(true);
            }
        });

    }
}
