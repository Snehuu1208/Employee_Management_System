
package employee.management.system;

import java.awt.Choice;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;


public class ViewEmployee extends  JFrame implements ActionListener{

    JTable table;
    Choice cemployeeId;
    JButton searchB,print,update,back;
    
     ViewEmployee() {
         
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);
         
         JLabel search=new JLabel("Search by Employee Id");
         search.setBounds(80,50,150,20);
         search.setFont(new Font("TAHOMA",Font.BOLD,12));
         add(search);
         
         cemployeeId=new Choice();
         cemployeeId.setBounds(250,50,150,20);
         add(cemployeeId);
         
         try{
            Con c=new Con();
            ResultSet rs=c.s.executeQuery("select * from employee");
            
            while(rs.next()){
                cemployeeId.add(rs.getString("empId"));
            }
         }catch(Exception e){
             e.printStackTrace();
         }
         
         table=new JTable();
         try{
            Con c=new Con();
            ResultSet rs=c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
         }catch(Exception e){
             e.printStackTrace();
         }
         
         JScrollPane jsp=new JScrollPane(table);
         jsp.setBounds(0,100,1100,650);
         add(jsp);
         
         
         searchB=new JButton("Search");
         searchB.setBounds(550,50,80,20);
         searchB.setBackground(Color.GRAY);
         searchB.setForeground(Color.WHITE);
         searchB.setFont(new Font("TAHOMA",Font.BOLD,10));
         searchB.addActionListener(this);
         add(searchB);
         
         print=new JButton("Print");
         print.setBounds(650,50,80,20);
         print.setBackground(Color.GRAY);
         print.setForeground(Color.WHITE);
         print.setFont(new Font("TAHOMA",Font.BOLD,10));
         print.addActionListener(this);
         add(print);
         
         back=new JButton("Back");
         back.setBounds(850,50,80,20);
         back.setBackground(Color.GRAY);
         back.setForeground(Color.WHITE);
         back.setFont(new Font("TAHOMA",Font.BOLD,10));
         back.addActionListener(this);
         add(back);
         
         update=new JButton("Update");
         update.setBounds(750,50,80,20);
         update.setBackground(Color.GRAY);
         update.setForeground(Color.WHITE);
         update.setFont(new Font("TAHOMA",Font.BOLD,10));
         update.addActionListener(this);
         add(update);
                 
         setSize(1100,750);
         setLocation(250,30);
         setVisible(true);
    }
    
    public static void main(String[] args) {
        new ViewEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==searchB){
            String query="select * from employee where empId=  '"+cemployeeId.getSelectedItem()+"'";
            
            try{
                Con c=new Con();
                ResultSet rs=c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==print){
            
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==update){
            setVisible(false);
            new UpdateEmployee(cemployeeId.getSelectedItem());
        }
        else{
            setVisible(false);
            new Home();
        }
    }
}
