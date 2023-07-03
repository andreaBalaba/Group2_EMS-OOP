package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ManagerPage implements ActionListener 
{
    private JFrame managerFrame = new JFrame("Employee Management System");
    private JLabel titleLabel;
    private JButton logOutButton;

    public ManagerPage() 
    {        
        managerFrame.setBounds(100, 100, 750, 550);
        managerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        managerFrame.setLocationRelativeTo(null);
        managerFrame.setLayout(null);

        titleLabel = new JLabel("Welcome to Manager Page");
        titleLabel.setFont(new Font("Open Sans", Font.BOLD, 18));
        titleLabel.setBounds(120, 120, 250, 35);
        
        logOutButton = new JButton("Log out");
        logOutButton.setFont(new Font("Open Sans", Font.BOLD, 13));
        logOutButton.setBounds(170, 90, 95, 30);
        logOutButton.addActionListener(this); 
            
        managerFrame.add(titleLabel);
        managerFrame.add(logOutButton);

        managerFrame.setVisible(true);
    }
  @Override
 public void actionPerformed(ActionEvent e) 
    {
                managerFrame.dispose(); 
                new MainPage(); 
    }
}
