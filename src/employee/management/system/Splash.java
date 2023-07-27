
package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;

public class Splash extends JFrame implements ActionListener{
    
    Splash(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(80, 30, 1200, 60);
        heading.setFont(new Font("serif",Font.BOLD,58));
        heading.setForeground(new Color(216, 83, 6));
        add(heading);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/employment.jpg"));
        Image i2=i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(50, 100, 1050, 500);
        add(image);
        
        JButton clickhere=new JButton("Click Here To Continue");
        clickhere.setBounds(850, 120, 180, 50);
        clickhere.setBackground(new Color(160,160,160));
        clickhere.setForeground(Color.WHITE);
        clickhere.setFont(new Font("serif",Font.BOLD,12));
        clickhere.addActionListener(this);
        add(clickhere);
        
        setSize(1170, 650);
        setLocation(200, 50);
        setVisible(true);
        
        while (true) {            
          heading.setVisible(false);
          try{
              Thread.sleep(500);
          }catch(InterruptedException e){
              
          }
           heading.setVisible(true);
          try{
              Thread.sleep(500);
          }catch(InterruptedException e){
              
          }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }
  
    public static void main(String args[]){
        new Splash();
    }
}
