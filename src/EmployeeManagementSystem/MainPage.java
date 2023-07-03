package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MainPage implements ActionListener 
{
    
        private JFrame EMSFrame = new JFrame("G2 Computer Services");
	private JLabel TitleLabel, WelcomeText, Direction1;
	private JButton ManagerButton, HRButton;
        private EMSdatabase emsDatabase;
    
    public MainPage()
    {           
                emsDatabase = new EMSdatabase();
                
                EMSFrame.setBounds(100, 100, 450, 300);
		EMSFrame.setLocationRelativeTo(null);
		EMSFrame.setLayout(null);
                
                TitleLabel = new JLabel("G2 COMPUTER SERVICES");
		TitleLabel.setFont(new Font("Open Sans", Font.BOLD, 18));
		TitleLabel.setBounds(99, 41, 279, 35);
		
		WelcomeText = new JLabel("Employee Management System");
		WelcomeText.setFont(new Font("Open Sans", Font.PLAIN, 13));
		WelcomeText.setBounds(125, 80, 202, 18);
		
		Direction1 = new JLabel(" ↓ Please click or tap your destination.");
		Direction1.setFont(new Font("Open Sans", Font.PLAIN, 11));
		Direction1.setBounds(119, 106, 192, 18);
		
		ManagerButton = new JButton("Manager");
		ManagerButton.setFont(new Font("Open Sans", Font.BOLD, 13));
		ManagerButton.setBounds(101, 154, 95, 30);
                ManagerButton.setBackground(Color.GRAY);
                ManagerButton.setForeground(Color.WHITE);
                ManagerButton.setFocusable(false);
                ManagerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ManagerButton.addActionListener(this);
            
		HRButton = new JButton("HR Staff");
		HRButton.setFont(new Font("Open Sans", Font.BOLD, 13));
		HRButton.setBounds(239, 154, 95, 30);
                HRButton.setBackground(Color.GRAY);
                HRButton.setForeground(Color.WHITE);
                HRButton.setFocusable(false);
                HRButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		HRButton.addActionListener(this);
               
		EMSFrame.add(TitleLabel);
		EMSFrame.add(WelcomeText);
		EMSFrame.add(Direction1);
		EMSFrame.add(ManagerButton);
		EMSFrame.add(HRButton);
            
                EMSFrame.setVisible(true);
    }
  @Override
 public void actionPerformed(ActionEvent e)
 {
     Connection connection = emsDatabase.getConnection();
     
     if(e.getSource() == ManagerButton)
     {   
         EMSFrame.dispose(); 
         new LogInPage("Manager",connection);
     }
     else if(e.getSource() == HRButton)
     {   
         EMSFrame.dispose(); 
         new LogInPage("HR Staff", connection);
     }
 }

}
