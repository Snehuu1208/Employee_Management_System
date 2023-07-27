/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;

/**
 *
 * @author Dell
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements  ActionListener{

    JTextField tfuser,tfpass;
     Login() {
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);
         
         JLabel lblusername=new JLabel("Username");
         lblusername.setBounds(40, 35, 100, 30);
         add(lblusername);
         
           tfuser=new JTextField();
         tfuser.setBounds(150,35,150,30);
         add(tfuser);
         
           tfpass=new JTextField();
         tfpass.setBounds(150,90,150,30);
         add(tfpass);
         
         JLabel lblpass=new JLabel("Password");
         lblpass.setBounds(40, 90, 100, 30);
         add(lblpass);
         
         JButton login=new JButton("Login");
        login.setBounds(150, 160, 150, 30);
        login.setBackground(new Color(100,149,237));
        login.setForeground(Color.WHITE);
        login.setFont(new Font("serif",Font.BOLD,12));
        login.addActionListener(this);
        add(login);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        Image i2=i1.getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350, 30, 180, 180);
        add(image);
        
         setSize(600,350);
         setLocation(450,200);
         setVisible(true);
    }
     public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent ac) {
        try{
            String username=tfuser.getText();
            String password=tfpass.getText();
            
            String query="select * from login where username = '"+username+"' and password = '"+password+"'";
            Con c=new Con();
            ResultSet rs=c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Home();
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);
                new Login();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
    
}
