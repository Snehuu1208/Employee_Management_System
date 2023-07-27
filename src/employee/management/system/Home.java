
package employee.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

public class Home extends JFrame implements ActionListener{

    JButton view,add,update,remove;
     Home() {
         
         setLayout(null);
         
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/employee.png"));
        Image i2=i1.getImage().getScaledInstance(1180, 680, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 1180, 680);
        add(image);
        
        JLabel heading=new JLabel("Employee Management System");
        heading.setBounds(720,20,400,40);
        heading.setFont(new Font("TAHOMA",Font.BOLD,25));
         image.add(heading);
         
          add=new JButton("Add");
         add.setBounds(850, 120, 100, 40);
         add.setBackground(new Color(255,69,0));
         add.setForeground(Color.WHITE);
         add.setFont(new Font("TAHOMA",Font.BOLD,12));
         add.addActionListener(this);
         image.add(add);
         
          view=new JButton("View");
         view.setBounds(970, 120, 100, 40);
         view.setBackground(new Color(255,69,0));
         view.setForeground(Color.WHITE);
         view.setFont(new Font("TAHOMA",Font.BOLD,12));
         view.addActionListener(this);
         image.add(view);
         
          update=new JButton("Update");
         update.setBounds(970, 180, 100, 40);
         update.setBackground(new Color(255,69,0));
         update.setForeground(Color.WHITE);
         update.setFont(new Font("TAHOMA",Font.BOLD,12));
         update.addActionListener(this);
         image.add(update);
         
          remove=new JButton("Remove");
         remove.setBounds(850, 180, 100, 40);
         remove.setBackground(new Color(255,69,0));
         remove.setForeground(Color.WHITE);
         remove.setFont(new Font("TAHOMA",Font.BOLD,12));
         remove.addActionListener(this);
         image.add(remove);
        
        
         setSize(1180, 680);
         setLocation(200, 80);
         setVisible(true);
         
     }
    public static void main(String[] args) {
        new Home();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==add){
            setVisible(false);
            new AddEmployee();
        }
        else if(ae.getSource()==view){
            setVisible(false);
            new ViewEmployee();
        }
        else if(ae.getSource()==update){
            setVisible(false);
            new ViewEmployee();
        }
        else if(ae.getSource()==remove){
            setVisible(false);
            new RemoveEmployee();
        }
    }
}
