package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class WelcomePage extends JFrame implements ActionListener 
{
	private JLabel TitleLabel, WelcomeText, Direction1;
	private JButton ManagerButton, HRButton;
    
    public WelcomePage()
    {                           
                setTitle("Global 2taff");
                setBounds(500, 100, 750, 550);
		setLocationRelativeTo(null);
		setLayout(null);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                
                
                
                TitleLabel = new JLabel("GLOBAL 2TAFF");
		TitleLabel.setFont(new Font("Mistral", Font.BOLD, 40));
		TitleLabel.setBounds(520, 90, 279, 35);
		
		WelcomeText = new JLabel("Employee Management System");
		WelcomeText.setFont(new Font("Open Sans", Font.PLAIN, 13));
		WelcomeText.setBounds(530, 130, 202, 18);
		
		Direction1 = new JLabel(" ↓ Please click or tap your destination.");
		Direction1.setFont(new Font("Open Sans", Font.PLAIN, 11));
		Direction1.setBounds(530, 210, 202, 18);
		
		ManagerButton = new JButton("Manager");
		ManagerButton.setFont(new Font("Georgia", Font.BOLD, 13));
		ManagerButton.setBounds(570, 250, 110, 30);
                ManagerButton.setBackground(Color.DARK_GRAY);
                ManagerButton.setForeground(Color.WHITE);
                ManagerButton.setFocusable(false);
                ManagerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ManagerButton.addActionListener(this);
            
		HRButton = new JButton("HR Staff");
		HRButton.setFont(new Font("Georgia", Font.BOLD, 13));
		HRButton.setBounds(570, 300, 110, 30);
                HRButton.setBackground(Color.DARK_GRAY);
                HRButton.setForeground(Color.WHITE);
                HRButton.setFocusable(false);
                HRButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		HRButton.addActionListener(this);               
                
                ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("EmployeeManagementSystem/Icon/g2logo.png"));
                Image Icon3 = icon3.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
                ImageIcon pic3 = new ImageIcon(Icon3);
                JLabel pics3 = new JLabel(pic3);
                pics3.setBounds(10,10, 500, 500);
                
               
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
