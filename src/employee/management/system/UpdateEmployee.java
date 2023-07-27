
package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;



public class UpdateEmployee extends  JFrame implements ActionListener{
    
    JButton update,back;
    JTextField tfedu,tfdesignation,tfaddress,tffname,tfsal,tfphone,tfemail;
    JLabel labelempId;
    String empId;

     UpdateEmployee(String empId){
         this.empId=empId;
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);
         
         JLabel heading=new JLabel("Updatde Employee Details");
         heading.setBounds(350,30,500,50);
         heading.setFont(new Font("TAHOMA",Font.BOLD,25));
         add(heading);
         
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
         
         tffname=new JTextField();
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
         
         tfsal=new JTextField();
         tfsal.setBounds(700,200,150,30);
         add(tfsal);
         
         JLabel lbaddress=new JLabel("Address");
         lbaddress.setBounds(100,250,150,30);
         lbaddress.setFont(new Font("serif",Font.PLAIN,20));
         add(lbaddress);
         
         tfaddress=new JTextField();
         tfaddress.setBounds(300,250,150,30);
         add(tfaddress);
         
         JLabel lbphone=new JLabel("Phone");
         lbphone.setBounds(500,250,150,30);
         lbphone.setFont(new Font("serif",Font.PLAIN,20));
         add(lbphone);
         
         tfphone=new JTextField();
         tfphone.setBounds(700,250,150,30);
         add(tfphone);
       
         JLabel lbemail=new JLabel("Email Adress");
         lbemail.setBounds(100,300,150,30);
         lbemail.setFont(new Font("serif",Font.PLAIN,20));
         add(lbemail);
         
         tfemail=new JTextField();
         tfemail.setBounds(300,300,150,30);
         add(tfemail);
         
         JLabel lbedu=new JLabel("Highest Education");
         lbedu.setBounds(500,300,150,30);
         lbedu.setFont(new Font("serif",Font.PLAIN,20));
         add(lbedu);
         
         tfedu=new JTextField();
         tfedu.setBackground(Color.WHITE);
         tfedu.setBounds(700,300,150,30);
         add(tfedu);
         
         JLabel lbdesignation=new JLabel("Designation");
         lbdesignation.setBounds(100,350,150,30);
         lbdesignation.setFont(new Font("serif",Font.PLAIN,20));
         add(lbdesignation);
         
         tfdesignation=new JTextField();
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
         
         JLabel lbempId=new JLabel("Employee ID");
         lbempId.setBounds(100,400,150,30);
         lbempId.setFont(new Font("serif",Font.PLAIN,20));
         add(lbempId);
         
         labelempId=new JLabel();
         labelempId.setBounds(300,400,150,30);
         labelempId.setFont(new Font("serif",Font.PLAIN,20));
         add(labelempId);
         
         try{
             Con c=new Con();
             String query="Select * from employee where empId='"+empId+"'";
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
         
         update=new JButton("Update Details");
         update.setBounds(320, 550, 150, 40);
         update.setBackground(Color.GRAY);
         update.setForeground(Color.WHITE);
         update.setFont(new Font("TAHOMA",Font.BOLD,12));
         update.addActionListener(this);
         add(update);
         
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
        new UpdateEmployee("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==update){
            String fname=tffname.getText();
            String salary=tfsal.getText();
            String address=tfaddress.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();
            String education=tfedu.getText();
            String designation=tfdesignation.getText();
            
            try{
                Con c=new Con();
                String query="update employee set fname = '"+fname+"',salary = '"+salary+"',address = '"+address+"',phone = '"+phone+"',email = '"+email+"',education = '"+education+"',designation = '"+designation+"'where empId = '"+empId+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
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
