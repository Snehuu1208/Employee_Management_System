
package employee.management.system;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.util.*;


public class AddEmployee extends  JFrame implements ActionListener{
    Random ran=new Random();
    int number=ran.nextInt(999999);
    JButton add,back;
    JTextField tfname,tfaddress,tffname,tfsal,tfphone,tfemail,tfaddhar;
    JDateChooser dedob;
    JComboBox tfedu,tfdesignation;
    JLabel labelempId;

     AddEmployee(){
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);
         
         JLabel heading=new JLabel("Add Employee Details");
         heading.setBounds(350,30,500,50);
         heading.setFont(new Font("TAHOMA",Font.BOLD,25));
         add(heading);
         
         JLabel lbname=new JLabel("Employee Name");
         lbname.setBounds(100,150,150,30);
         lbname.setFont(new Font("serif",Font.PLAIN,20));
         add(lbname);
         
         tfname=new JTextField();
         tfname.setBounds(300,150,150,30);
         add(tfname);
         
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
         
         dedob=new JDateChooser();
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
         
         String couses[]={"BBA","BCA","BA","B.COM","BTech","BSC","MBA","MCA","MA","MTech","M.COM","MSC","PHD"};
         tfedu=new JComboBox(couses);
         tfedu.setBackground(Color.WHITE);
         tfedu.setBounds(700,300,150,30);
         add(tfedu);
         
         JLabel lbdesignation=new JLabel("Designation");
         lbdesignation.setBounds(100,350,150,30);
         lbdesignation.setFont(new Font("serif",Font.PLAIN,20));
         add(lbdesignation);
         
         
         String jobs[]={"Software Developer","Software Architect","Web Developer","Technical writer","Software engineering"
                 ,"Product Manager","Application analyst","Java Developer","Systems analyst","Mobile Developer","Others"};
         tfdesignation=new JComboBox(jobs);
         tfdesignation.setBounds(300,350,150,30);
         tfdesignation.setBackground(Color.WHITE);
         add(tfdesignation);
       
         JLabel lbaddhar=new JLabel("Addhar No");
         lbaddhar.setBounds(500,350,150,30);
         lbaddhar.setFont(new Font("serif",Font.PLAIN,20));
         add(lbaddhar);
         
         tfaddhar=new JTextField();
         tfaddhar.setBounds(700,350,150,30);
         add(tfaddhar);
         
         JLabel lbempId=new JLabel("Employee ID");
         lbempId.setBounds(100,400,150,30);
         lbempId.setFont(new Font("serif",Font.PLAIN,20));
         add(lbempId);
         
         labelempId=new JLabel(""+number);
         labelempId.setBounds(300,400,150,30);
         labelempId.setFont(new Font("serif",Font.PLAIN,20));
         add(labelempId);
         
         add=new JButton("Add Details");
         add.setBounds(320, 550, 150, 40);
         add.setBackground(Color.GRAY);
         add.setForeground(Color.WHITE);
         add.setFont(new Font("TAHOMA",Font.BOLD,12));
         add.addActionListener(this);
         add(add);
         
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
        new AddEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==add){
            String name=tfname.getText();
            String fname=tffname.getText();
            String dob=((JTextField)dedob.getDateEditor().getUiComponent()).getText();
            String salary=tfsal.getText();
            String address=tfaddress.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();
            String education=(String)tfedu.getSelectedItem();
            String designation=(String)tfdesignation.getSelectedItem();
            String addhar=tfaddhar.getText();
            String empId=labelempId.getText();
            
            try{
                Con c=new Con();
                String query="insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+addhar+"','"+empId+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
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
