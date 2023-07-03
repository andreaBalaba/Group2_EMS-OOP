package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LogInPage implements ActionListener
{  
	private JFrame Lframe = new JFrame("Log In");
	private JLabel Email, Password, WelcomeText;
	private JTextField TEmail;
	private JPasswordField passwordField;
	private JButton LogInButton, BackButton;
	private String accountType;
        private Connection connection;
	
        private boolean validateEmail(String email) 
        {
            return email.contains("@");
        }
        private boolean validateManagerCredentials(String email, String password) 
        {   
            
            try 
            {
                String query = "SELECT * FROM logIndata WHERE email = ? AND password = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, email);
                statement.setString(2,password);
                ResultSet resultSet = statement.executeQuery();
                return resultSet.next(); 
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
            return false;
         }
        private boolean validateHRStaffCredentials(String email, String password) 
        {
            
            try 
            {
                String query = "SELECT * FROM logIndata WHERE email = ? AND password = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1,email);
                statement.setString(2,password);
                ResultSet resultSet = statement.executeQuery();
                
                return resultSet.next(); 
            }
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
         return false;
       
        }
 public LogInPage(String accountType, Connection connection) 
 {
                this.accountType = accountType;
                this.connection = connection;
            
		Lframe.setBounds(100, 100, 450, 300);
		Lframe.setLocationRelativeTo(null);
		Lframe.setLayout(null);
		
                WelcomeText = new JLabel("G2 COMPUTER SERVICES");
		WelcomeText.setFont(new Font("Open Sans", Font.BOLD, 17));
		WelcomeText.setBounds(50, 40, 222, 18);
		
                ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("EmployeeManagementSystem/Icon/logIn.png"));
                Image Icon1 = icon1.getImage().getScaledInstance(125,125,Image.SCALE_DEFAULT);
                ImageIcon pic1 = new ImageIcon(Icon1);
                JLabel pics1 = new JLabel(pic1);
                pics1.setBounds(280, 70, 125, 125);
	
		TEmail = new JTextField();
		TEmail.setFont(new Font("Open Sans", Font.PLAIN, 11));
		TEmail.setBounds(130, 90, 130, 23);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Open Sans", Font.PLAIN, 11));
		passwordField.setBounds(130, 124, 130, 23);
		
		Email = new JLabel("Email:");
		Email.setFont(new Font("Open Sans", Font.PLAIN, 13));
		Email.setBounds(50, 89, 37, 23);
		
		Password = new JLabel("Password:");
		Password.setFont(new Font("Open Sans", Font.PLAIN, 13));
		Password.setBounds(50, 125, 61, 19);
		
		LogInButton = new JButton("Log In");
		LogInButton.setFont(new Font("Open Sans", Font.BOLD, 13));
		LogInButton.setBounds(50, 182, 80, 30);
                LogInButton.setBackground(Color.GRAY);
                LogInButton.setForeground(Color.WHITE);
                LogInButton.setFocusable(false);
                LogInButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                LogInButton.addActionListener(this);
		
		BackButton = new JButton("Back");
		BackButton.setFont(new Font("Open Sans", Font.BOLD, 13));
		BackButton.setBounds(178, 182, 80, 30);
                BackButton.setBackground(Color.GRAY);
                BackButton.setForeground(Color.WHITE);
                BackButton.setFocusable(false);
                BackButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BackButton.addActionListener(this);
                
		Lframe.add(WelcomeText);
		Lframe.add(TEmail);
		Lframe.add(passwordField);
		Lframe.add(Email);
		Lframe.add(Password);
		Lframe.add(LogInButton);
		Lframe.add(BackButton);
                Lframe.add(pics1);
		
		
		Lframe.setVisible(true);
                Lframe.setFocusable(false);
                
	}
 
 @Override
 public void actionPerformed(ActionEvent e) 
 {
     if (e.getSource() == LogInButton) 
     {
           String email = TEmail.getText().trim();
           String password = new String (passwordField.getPassword());

                    if (validateEmail(email)) 
                    {
                         String domain = email.substring(email.indexOf("@") + 1);
                             if (accountType.equals("Manager") && domain.equalsIgnoreCase("manager.com")) 
                             {
                                 if (validateManagerCredentials(email, password)) 
                                 {
                                        Lframe.dispose(); 
                                        new ManagerPage();
                                 } 
                                 else 
                                 {
                                    JOptionPane.showMessageDialog(Lframe, "Invalid email or password.", 
                                            "Log In Error", JOptionPane.ERROR_MESSAGE);
                                 }
                             } 
                             else if (accountType.equals("HR Staff") && domain.equalsIgnoreCase("hr.com")) 
                             {
                                 if (validateHRStaffCredentials(email, password)) 
                                 {
                                    Lframe.dispose();
                                    new HrPage();
                                 } 
                                 else 
                                 {
                                    JOptionPane.showMessageDialog(Lframe, "Invalid email or password.", 
                                            "Log In Error", JOptionPane.ERROR_MESSAGE);
                                 }
                             } 
                             else 
                             {
                                     JOptionPane.showMessageDialog(Lframe, "Invalid email or password.",
                                             "Log In Error", JOptionPane.ERROR_MESSAGE);
                             }
                    } 
                    else 
                    {
                            JOptionPane.showMessageDialog(Lframe, "Invalid email format.", 
                                    "Log In Error", JOptionPane.ERROR_MESSAGE);
                    }
     } 
     else if (e.getSource() == BackButton) 
     {
           Lframe.dispose();
           new MainPage();
     }
 }
}
