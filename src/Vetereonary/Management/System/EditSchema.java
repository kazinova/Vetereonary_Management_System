/*
 * Created by JFormDesigner on Fri Apr 03 13:16:36 EEST 2020
 */

package Vetereonary.Management.System;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Jane Doe
 */
public class EditSchema extends JFrame {
    Connection c;
    public EditSchema() {

        initComponents();
        setTitle("Vetereonary Management  System");
        setResizable(false);
        setLocationRelativeTo(null);
        try{
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/vetDB", "root", "");
            displayBox1();
            displayBox2();
            displayFiels();
        }
        catch(Exception e){e.printStackTrace();}
    }

    private void displayBox1(){
        DefaultComboBoxModel model = new DefaultComboBoxModel();

        try{
            PreparedStatement ps = c.prepareStatement("SELECT table_name FROM information_schema.tables WHERE table_schema = 'vetdb' AND NOT TABLE_NAME='govis'");
            ResultSet set = ps.executeQuery();
            while (set.next()) //go through each row that your query returns
            {
                String comboBox2 = set.getString("table_name"); //get the element in column "item_code"
                model.addElement(comboBox2); //add each item to the model
            }
            comboBox2.setModel(model);
        }
        catch(Exception e){e.printStackTrace();}

    }
    private void displayBox2(){
        DefaultComboBoxModel mode2 = new DefaultComboBoxModel();

        try{
            PreparedStatement ps = c.prepareStatement("SELECT * FROM "+comboBox2.getSelectedItem().toString()+";");
            ResultSetMetaData rsMetaData = ps.getMetaData();
            int numberOfColumns = rsMetaData.getColumnCount();
            for (int i = 2; i < numberOfColumns + 1; i++){

                String  comboBox1= rsMetaData.getColumnName(i)  ; //get the element in column "item_code"
                mode2.addElement(comboBox1); //add each item to the model
            }

//            }
            comboBox3.setModel(mode2);
        }
        catch(Exception e){e.printStackTrace();}

    }

    private void displayFiels(){
        try{
            ResultSet rs;
            PreparedStatement ps = c.prepareStatement("select "+comboBox3.getSelectedItem().toString()+" from "+comboBox2.getSelectedItem().toString()+" where Numurs = 1; ");
            rs = ps.executeQuery();

            while(true){
                if (rs.next()){
                    jTextField2.setText(comboBox2.getSelectedItem().toString());
                    jTextField3.setText(comboBox3.getSelectedItem().toString());
                    jTextField4.setText(rs.getString(comboBox3.getSelectedItem().toString()));
                    break;
                }

            }

        } catch(Exception a) {a.printStackTrace();}
    }
    private void jTextField4ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void jButton1ActionPerformed(ActionEvent e) {
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        df.setLenient(false);
        boolean date;
        try{
            df.setLenient(false);
            df.parse(jTextField4.getText());
            date=false;
        }
        catch (ParseException v){
            date=true;
        }

        if (jTextField2.getText().isEmpty() || jTextField3.getText().isEmpty() || jTextField4.getText().isEmpty() || date) {
            JOptionPane.showMessageDialog(new JFrame(), "Nav pareizi aizpildīti lauki!", "Message", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                PreparedStatement ps = c.prepareStatement("UPDATE "+comboBox2.getSelectedItem().toString()+" SET "+comboBox3.getSelectedItem().toString()+"='"+jTextField4.getText()+"' where Numurs=1;");
                ps.execute();
                ps = c.prepareStatement("ALTER TABLE "+comboBox2.getSelectedItem().toString()+" CHANGE COLUMN "+comboBox3.getSelectedItem().toString()+" "+jTextField3.getText()+" Date;");
                ps.execute();
                ps = c.prepareStatement("ALTER TABLE "+comboBox2.getSelectedItem().toString()+" RENAME TO "+jTextField2.getText()+"; ");
                ps.execute();
                JOptionPane.showMessageDialog(new JFrame(), "Lauki ir rediģēti!", "Message" , JOptionPane.INFORMATION_MESSAGE);
                jTextField2.setText("");
                jTextField3.setText("");
                jTextField4.setText("");
                displayBox1();
                displayBox2();
            }catch(Exception a) {
                a.printStackTrace();
                JOptionPane.showMessageDialog(new JFrame(), "Nav pareizi aizpildīti lauki!", "Message" , JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private void jButton2ActionPerformed(ActionEvent e) {
        try {
            PreparedStatement ps = c.prepareStatement("DROP TABLE "+comboBox2.getSelectedItem().toString()+";");
            ps.executeUpdate();
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            displayBox1();
            displayBox2();
        }
        catch (Exception a){a.printStackTrace();}
    }

    private void button1ActionPerformed(ActionEvent e) {
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void comboBox2ItemStateChanged(ItemEvent e) {
        displayBox2();
        displayFiels();
    }

    private void button3ActionPerformed(ActionEvent e) {
        try {
            PreparedStatement ps = c.prepareStatement("ALTER TABLE " + comboBox2.getSelectedItem().toString() + " drop column " + comboBox3.getSelectedItem().toString() + ";");
            ps.executeUpdate();
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            displayBox2();
        }
        catch (Exception a){a.printStackTrace();}

    }

    private void comboBox3ItemStateChanged(ItemEvent e) {
        displayFiels();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Jane Doe
        jPanel1 = new JPanel();
        jTextField4 = new JTextField();
        jButton1 = new JButton();
        jLabel1 = new JLabel();
        jButton2 = new JButton();
        jTextField2 = new JTextField();
        jLabel3 = new JLabel();
        jTextField3 = new JTextField();
        jLabel2 = new JLabel();
        jLabel5 = new JLabel();
        comboBox2 = new JComboBox();
        comboBox3 = new JComboBox();
        label1 = new JLabel();
        button1 = new JButton();
        button3 = new JButton();
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
            "[]" +
            "[]"));

        //======== jPanel1 ========
        {
            jPanel1.setBorder(new TitledBorder(new LineBorder(Color.black, 2, true), "Redi\u0123\u0113t sh\u0113mu", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                new Font("Tahoma", Font.PLAIN, 24)));
            jPanel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new
            javax.swing.border.EmptyBorder(0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax
            .swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java
            .awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt
            .Color.red),jPanel1. getBorder()));jPanel1. addPropertyChangeListener(new java.beans.
            PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("bord\u0065r".
            equals(e.getPropertyName()))throw new RuntimeException();}});

            //---- jTextField4 ----
            jTextField4.addActionListener(e -> jTextField4ActionPerformed(e));

            //---- jButton1 ----
            jButton1.setText("REDI\u0122\u0112T");
            jButton1.addActionListener(e -> jButton1ActionPerformed(e));

            //---- jLabel1 ----
            jLabel1.setText("Medikaments");

            //---- jButton2 ----
            jButton2.setText("DZ\u0112ST SH\u0112MU");
            jButton2.addActionListener(e -> jButton2ActionPerformed(e));

            //---- jLabel3 ----
            jLabel3.setText("Labot medikamentu");

            //---- jLabel2 ----
            jLabel2.setText("Labot nosaukumu");

            //---- jLabel5 ----
            jLabel5.setText("Nosaukums");

            //---- comboBox2 ----
            comboBox2.addItemListener(e -> comboBox2ItemStateChanged(e));

            //---- comboBox3 ----
            comboBox3.addItemListener(e -> comboBox3ItemStateChanged(e));

            //---- label1 ----
            label1.setText("Labot datumu");

            //---- button1 ----
            button1.setText("ATRAST");
            button1.addActionListener(e -> button1ActionPerformed(e));

            //---- button3 ----
            button3.setText("DZ\u0112ST MEDIKAMENTU");
            button3.addActionListener(e -> button3ActionPerformed(e));

            GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup()
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup()
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup()
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1))
                                .addGap(127, 127, 127)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboBox3)
                                    .addComponent(comboBox2)
                                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(button3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup()
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(label1)
                                    .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
                                .addGap(52, 52, 52)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField4)
                                    .addComponent(jTextField3)
                                    .addComponent(jTextField2, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup()
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(comboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button1)
                            .addComponent(button3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label1))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }
        contentPane.add(jPanel1, "cell 0 0 1 3");

        //---- button2 ----
        button2.setText("ATPAKA\u013b");
        button2.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(button2, "cell 0 3");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Jane Doe
    private JPanel jPanel1;
    private JTextField jTextField4;
    private JButton jButton1;
    private JLabel jLabel1;
    private JButton jButton2;
    private JTextField jTextField2;
    private JLabel jLabel3;
    private JTextField jTextField3;
    private JLabel jLabel2;
    private JLabel jLabel5;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JLabel label1;
    private JButton button1;
    private JButton button3;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String args[]) throws SQLException {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditSchema().setVisible(true);
            }
        });

    }
}
