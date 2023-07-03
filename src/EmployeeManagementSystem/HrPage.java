package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HrPage implements ActionListener 
{
    private JFrame hrStaffFrame = new JFrame("G2 Computer Services");
    private JLabel titleLabel;
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu1,menu2,menu3, menu4, menu5, menu6;
    

    public HrPage() 
    {
        
        hrStaffFrame.setBounds(100, 100, 750, 550);
        hrStaffFrame.setLocationRelativeTo(null);
        hrStaffFrame.setLayout(null);

        titleLabel = new JLabel("Employee Management System");
        titleLabel.setFont(new Font("Open Sans", Font.BOLD, 18));
        titleLabel.setBounds(235, 225, 400, 35);
        
        menuBar.setBackground(Color.WHITE);
        
        menu1 = new JMenu("Profile");
        menu1.setFont(new Font("Open Sans", Font.PLAIN, 13));
        JMenuItem menuItem1 = new JMenuItem("Add New Employee Profile");
        JMenuItem menuItem2 = new JMenuItem("View Profile");
        menuItem1.setFont(new Font("Open Sans", Font.PLAIN, 12));
        menuItem2.setFont(new Font("Open Sans", Font.PLAIN, 12));
        menuItem1.addActionListener(this);
        menuItem2.addActionListener(this);
       
        menu2 = new JMenu("Manage");
        menu2.setFont(new Font("Open Sans", Font.PLAIN, 13));
        JMenuItem menuItem3 = new JMenuItem("Update Employee Details");
        JMenuItem menuItem4 = new JMenuItem("Delete Employee");
        menuItem3.setFont(new Font("Open Sans", Font.PLAIN, 12));
        menuItem4.setFont(new Font("Open Sans", Font.PLAIN, 12));
        menuItem3.addActionListener(this);
        menuItem4.addActionListener(this);
        
        menu3 = new JMenu("Attendance");
        menu3.setFont(new Font("Open Sans", Font.PLAIN, 13));
        JMenuItem menuItem5 = new JMenuItem("Take Attendance");
        JMenuItem menuItem6 = new JMenuItem("View Attendance");
        menuItem5.setFont(new Font("Open Sans", Font.PLAIN, 12));
        menuItem6.setFont(new Font("Open Sans", Font.PLAIN, 12));
        menuItem5.addActionListener(this);
        menuItem6.addActionListener(this);
        
        menu4 = new JMenu("Request");
        menu4.setFont(new Font("Open Sans", Font.PLAIN, 13));
        JMenuItem menuItem7 = new JMenuItem("Time Off");
        JMenuItem menuItem8 = new JMenuItem("Expenses");
        menuItem7.setFont(new Font("Open Sans", Font.PLAIN, 12));
        menuItem8.setFont(new Font("Open Sans", Font.PLAIN, 12));
        menuItem7.addActionListener(this);
        menuItem8.addActionListener(this);
        
        menu5 = new JMenu("Review");
        menu5.setFont(new Font("Open Sans", Font.PLAIN, 13));
        JMenuItem menuItem9 = new JMenuItem("Performance Review");
        menuItem9.setFont(new Font("Open Sans", Font.PLAIN, 12));
        menuItem9.addActionListener(this);
        
        menu6 = new JMenu("Exit");
        menu6.setFont(new Font("Open Sans", Font.PLAIN, 13));
        JMenuItem menuItem10 = new JMenuItem("Log Out");
        menuItem10.setFont(new Font("Open Sans", Font.PLAIN, 12));
        menuItem10.addActionListener(this);
        
        
        menu1.add(menuItem1);
        menu1.add(menuItem2);
        menu2.add(menuItem3);
        menu2.add(menuItem4);
        menu3.add(menuItem5);
        menu3.add(menuItem6);
        menu4.add(menuItem7);
        menu4.add(menuItem8);
        menu5.add(menuItem9);
        menu6.add(menuItem10);
        
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menuBar.add(menu4);
        menuBar.add(menu5);
        menuBar.add(menu6);

        hrStaffFrame.add(titleLabel);
        hrStaffFrame.setJMenuBar(menuBar);

        hrStaffFrame.setVisible(true);
    }
 @Override
 public void actionPerformed(ActionEvent e)
 {
     String comnd = e.getActionCommand();
        if (comnd.equals("Add New Employee Profile"))
        {   
            new AddEmployee();
        }
        else if (comnd.equals("View Profile"))
        {
            new SearchEmployee();
        }
        else if (comnd.equals("Update Employee Details"))
        {
            new UpdateEmployeeDetails();
            
        }
        else if (comnd.equals("Delete Employee"))
        {
            new DeleteEmployee();
        }
        else if (comnd.equals("Take Attendance"))
        {
            
        }
        else if (comnd.equals("View Attendance"))
        {
        
        }
        else if (comnd.equals("Time Off"))
        {
        
        }
        else if (comnd.equals("Expenses"))
        {
        
        }
        else if (comnd.equals("Performance Review"))
        {
        
        }
        else if (comnd.equals("Log Out"))
        {
            hrStaffFrame.dispose(); 
            new MainPage();
        }
     
 }
}
