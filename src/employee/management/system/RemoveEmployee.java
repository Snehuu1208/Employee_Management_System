
package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;


public class RemoveEmployee extends JFrame implements ActionListener{

    Choice cEmpId;
    JButton delete,back;
    
     RemoveEmployee() {
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);
         
         JLabel lbempId=new JLabel("Employee Id");
         lbempId.setBounds(300,50,150,30);
         lbempId.setFont(new Font("serif",Font.BOLD,20));
         add(lbempId);
         
         cEmpId=new Choice();
         cEmpId.setBounds(450,50,150,30);
         add(cEmpId);
         
         try{
             Con c=new Con();
             String query="select * from employee";
             ResultSet rs=c.s.executeQuery(query);
             while(rs.next()){
                 cEmpId.add(rs.getString("empId"));
             }
         }catch(Exception e){
             e.printStackTrace();
         }
         
         JLabel lbname=new JLabel("Employee Name");
         lbname.setBounds(100,150,150,30);
         lbname.setFont(new Font("serif",Font.PLAIN,20));
         add(lbname);
         
         JLabel labelname=new JLabel();
         labelname.setBounds(300,150,150,30);
         add(labelname);
         
         JLabel lbfname=new JLabel("Father's Name");
         lbfname.setBounds(500,150,150,30);
         lbfname.setFont(new Font("serif",Font.PLAIN,20));
         add(lbfname);
         
         JLabel tffname=new JLabel();
         tffname.setBounds(700,150,150,30);
         add(tffname);
         
         JLabel lbdob=new JLabel("Date of Birth");
         lbdob.setBounds(100,200,150,30);
         lbdob.setFont(new Font("serif",Font.PLAIN,20));
         add(lbdob);
         
         JLabel dedob=new JLabel();
         dedob.setBounds(300,200,150,30);
         add(dedob);
         
         JLabel lbsal=new JLabel("Salary");
         lbsal.setBounds(500,200,150,30);
         lbsal.setFont(new Font("serif",Font.PLAIN,20));
         add(lbsal);
         
         JLabel tfsal=new JLabel();
         tfsal.setBounds(700,200,150,30);
         add(tfsal);
         
         JLabel lbaddress=new JLabel("Address");
         lbaddress.setBounds(100,250,150,30);
         lbaddress.setFont(new Font("serif",Font.PLAIN,20));
         add(lbaddress);
         
         JLabel tfaddress=new JLabel();
         tfaddress.setBounds(300,250,150,30);
         add(tfaddress);
         
         JLabel lbphone=new JLabel("Phone");
         lbphone.setBounds(500,250,150,30);
         lbphone.setFont(new Font("serif",Font.PLAIN,20));
         add(lbphone);
         
         JLabel tfphone=new JLabel();
         tfphone.setBounds(700,250,150,30);
         add(tfphone);
       
         JLabel lbemail=new JLabel("Email Adress");
         lbemail.setBounds(100,300,150,30);
         lbemail.setFont(new Font("serif",Font.PLAIN,20));
         add(lbemail);
         
         JLabel tfemail=new JLabel();
         tfemail.setBounds(300,300,170,30);
         add(tfemail);
         
         JLabel lbedu=new JLabel("Highest Education");
         lbedu.setBounds(500,300,150,30);
         lbedu.setFont(new Font("serif",Font.PLAIN,20));
         add(lbedu);
         
         JLabel tfedu=new JLabel();
         tfedu.setBackground(Color.WHITE);
         tfedu.setBounds(700,300,150,30);
         add(tfedu);
         
         JLabel lbdesignation=new JLabel("Designation");
         lbdesignation.setBounds(100,350,150,30);
         lbdesignation.setFont(new Font("serif",Font.PLAIN,20));
         add(lbdesignation);
         
        JLabel tfdesignation=new JLabel();
         tfdesignation.setBounds(300,350,150,30);
         tfdesignation.setBackground(Color.WHITE);
         add(tfdesignation);
       
         JLabel lbaddhar=new JLabel("Addhar No");
         lbaddhar.setBounds(500,350,150,30);
         lbaddhar.setFont(new Font("serif",Font.PLAIN,20));
         add(lbaddhar);
         
          JLabel tfaddhar=new JLabel();
         tfaddhar.setBounds(700,350,150,30);
         add(tfaddhar);
         
         JLabel lempId=new JLabel("Employee ID");
         lempId.setBounds(100,400,150,30);
         lempId.setFont(new Font("serif",Font.PLAIN,20));
         add(lempId);
         
         JLabel labelempId=new JLabel();
         labelempId.setBounds(300,400,150,30);
         labelempId.setFont(new Font("serif",Font.PLAIN,20));
         add(labelempId);

         try{
             Con c=new Con();
             String query="select * from employee where empId = '"+cEmpId.getSelectedItem()+"'";
             ResultSet rs=c.s.executeQuery(query);
             while(rs.next()){
                 labelname.setText(rs.getString("name"));
                 tffname.setText(rs.getString("fname"));
                 dedob.setText(rs.getString("dob"));
                 tfsal.setText(rs.getString("salary"));
                 tfaddress.setText(rs.getString("address"));
                 tfphone.setText(rs.getString("phone"));
                 tfemail.setText(rs.getString("email"));
                 tfedu.setText(rs.getString("education"));
                 tfdesignation.setText(rs.getString("designation"));
                 tfaddhar.setText(rs.getString("addhar"));
                 labelempId.setText(rs.getString("empId"));
                 
             }
         }catch(Exception e){
             e.printStackTrace();
         }
         
         cEmpId.addItemListener(new ItemListener(){
         public void itemStateChanged(ItemEvent ie){
             
             try{
             Con c=new Con();
             String query="select * from employee where empId = '"+cEmpId.getSelectedItem()+"'";
             ResultSet rs=c.s.executeQuery(query);
             while(rs.next()){
                 labelname.setText(rs.getString("name"));
                 tffname.setText(rs.getString("fname"));
                 dedob.setText(rs.getString("dob"));
                 tfsal.setText(rs.getString("salary"));
                 tfaddress.setText(rs.getString("address"));
                 tfphone.setText(rs.getString("phone"));
                 tfemail.setText(rs.getString("email"));
                 tfedu.setText(rs.getString("education"));
                 tfdesignation.setText(rs.getString("designation"));
                 tfaddhar.setText(rs.getString("addhar"));
                 labelempId.setText(rs.getString("empId"));
                 
                }
               }catch(Exception e){
               e.printStackTrace();
                }
         }
     });
         
         delete=new JButton("Delete Details");
         delete.setBounds(320, 550, 150, 40);
         delete.setBackground(Color.GRAY);
         delete.setForeground(Color.WHITE);
         delete.setFont(new Font("TAHOMA",Font.BOLD,12));
         delete.addActionListener(this);
         add(delete);
         
         back=new JButton("Back");
         back.setBounds(520, 550, 150, 40);
         back.setBackground(Color.GRAY);
         back.setForeground(Color.WHITE);
         back.setFont(new Font("TAHOMA",Font.BOLD,12));
         back.addActionListener(this);
         add(back);
         
         setSize(1000,700);
         setLocation(300,50);
         setVisible(true);
    }
    
    
    public static void main(String[] args) {
        new RemoveEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==delete){
            try{
             Con c=new Con();
             String query="delete from employee where empId = '"+cEmpId.getSelectedItem()+"'";
             c.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null, "Employee Information Deleted Successfully");
                setVisible(false);
                new Home();
         }catch(Exception e){
             e.printStackTrace();
         }
        }
        else{
            setVisible(false);
            new Home();
        }
    }
}
