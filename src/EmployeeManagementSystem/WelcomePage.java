package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomePage extends JFrame implements ActionListener 
{
	private JLabel TitleLabel, WelcomeText, Direction1;
	private JButton ManagerButton, HRButton;
    
    public WelcomePage()
    {                           
                setTitle("G2 Computer Services");
                setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setLayout(null);
                setResizable(false);
                
                TitleLabel = new JLabel("G2 COMPUTER SERVICES");
		TitleLabel.setFont(new Font("Open Sans", Font.BOLD, 18));
		TitleLabel.setBounds(100, 90, 279, 35);
		
		WelcomeText = new JLabel("Employee Management System");
		WelcomeText.setFont(new Font("Open Sans", Font.PLAIN, 13));
		WelcomeText.setBounds(125, 130, 202, 18);
		
		Direction1 = new JLabel(" ↓ Please click or tap your destination.");
		Direction1.setFont(new Font("Open Sans", Font.PLAIN, 11));
		Direction1.setBounds(119, 161, 202, 18);
		
		ManagerButton = new JButton("Manager");
		ManagerButton.setFont(new Font("Open Sans", Font.BOLD, 13));
		ManagerButton.setBounds(101, 194, 95, 30);
                ManagerButton.setBackground(Color.GRAY);
                ManagerButton.setForeground(Color.WHITE);
                ManagerButton.setFocusable(false);
                ManagerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ManagerButton.addActionListener(this);
            
		HRButton = new JButton("HR Staff");
		HRButton.setFont(new Font("Open Sans", Font.BOLD, 13));
		HRButton.setBounds(239, 194, 95, 30);
                HRButton.setBackground(Color.GRAY);
                HRButton.setForeground(Color.WHITE);
                HRButton.setFocusable(false);
                HRButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		HRButton.addActionListener(this);
                
                ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("EmployeeManagementSystem/Icon/logo.png"));
                Image Icon3 = icon3.getImage().getScaledInstance(90,90,Image.SCALE_DEFAULT);
                ImageIcon pic3 = new ImageIcon(Icon3);
                JLabel pics3 = new JLabel(pic3);
                pics3.setBounds(175,10, 90, 90);
                
               
		add(TitleLabel);
		add(WelcomeText);
		add(Direction1);
		add(ManagerButton);
		add(HRButton);
                add(pics3);
                            
                setVisible(true);
    }
  @Override
    public void actionPerformed(ActionEvent e)
    {
     
     if(e.getSource() == ManagerButton)
     {   
         dispose(); 
         new LogInPage("Manager");
     }
     else if(e.getSource() == HRButton)
     {   
         dispose(); 
         new LogInPage("HR Staff");
     }
 }

}
