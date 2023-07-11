package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LogInPage extends JFrame implements ActionListener
{  
    private EMSdataAccess database = new EMSdataAccess();
    private JLabel Email, Password, WelcomeText;
    private JTextField TEmail;
    private JPasswordField passwordField;
    private JButton LogInButton, BackButton;
    private String accountType;
	
    private boolean validateEmail(String email) 
    {
            return email.contains("@");
    }
        
    public LogInPage(String accountType) 
    {
                this.accountType = accountType;
                
                setTitle("Log In");
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setLayout(null);
                setResizable(false);
		
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
                
		add(WelcomeText);
		add(TEmail);
		add(passwordField);
		add(Email);
		add(Password);
		add(LogInButton);
		add(BackButton);
                add(pics1);
		
		
		setVisible(true);
                setFocusable(false);
                
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
                                 if (database.validateManagerCredentials(email, password)) 
                                 {
                                        dispose(); 
                                        new ManagerPage();
                                 } 
                                 else 
                                 {
                                    JOptionPane.showMessageDialog(null, "Invalid email or password.", 
                                            "Log In Error", JOptionPane.ERROR_MESSAGE);
                                 }
                             } 
                             else if (accountType.equals("HR Staff") && domain.equalsIgnoreCase("hr.com")) 
                             {
                                 if (database.validateHRStaffCredentials(email, password)) 
                                 {
                                    dispose();
                                    new HrPage();
                                 } 
                                 else 
                                 {
                                    JOptionPane.showMessageDialog(null, "Invalid email or password.", 
                                            "Log In Error", JOptionPane.ERROR_MESSAGE);
                                 }
                             } 
                             else 
                             {
                                     JOptionPane.showMessageDialog(null, "Invalid email or password.",
                                             "Log In Error", JOptionPane.ERROR_MESSAGE);
                             }
                    } 
                    else 
                    {
                            JOptionPane.showMessageDialog(null, "Invalid email format.", 
                                    "Log In Error", JOptionPane.ERROR_MESSAGE);
                    }
     } 
     else if (e.getSource() == BackButton) 
     {
           dispose();
           new WelcomePage();
     }
 }
}
