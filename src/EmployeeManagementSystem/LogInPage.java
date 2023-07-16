package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LogInPage extends JFrame implements ActionListener
{  
    private EMSdataAccess database = new EMSdataAccess();
    private JLabel Email, Password, QuoteText;;
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
		setBounds(100, 100, 750, 550);
		setLocationRelativeTo(null);
		setLayout(null);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
                QuoteText = new JLabel();
		QuoteText.setFont(new Font("Courier New", Font.PLAIN, 20));
		QuoteText.setBounds(20, 250  , 400, 200);
                QuoteText.setText("<HTML>\"True leadership lies in guiding others to success. In ensuring that everyone is performing at their best, doing the work they are pledged to do, and doing it well. \" - Bill Owens</HTML>");
		
                ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("EmployeeManagementSystem/Icon/g2TAFF.png"));
                Image Icon1 = icon1.getImage().getScaledInstance(700,150,Image.SCALE_DEFAULT);
                ImageIcon pic1 = new ImageIcon(Icon1);
                JLabel pics1 = new JLabel(pic1);
                pics1.setBounds(10, 10, 700, 150);
	
		TEmail = new JTextField();
		TEmail.setFont(new Font("Open Sans", Font.PLAIN, 11));
		TEmail.setBounds(550, 250, 130, 23);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Open Sans", Font.PLAIN, 11));
		passwordField.setBounds(550, 300, 130, 23);
		
		Email = new JLabel("Email:");
		Email.setFont(new Font("Open Sans", Font.BOLD, 13));
		Email.setBounds(500, 250, 50, 23);
		
		Password = new JLabel("Password:");
		Password.setFont(new Font("Open Sans", Font.BOLD, 13));
		Password.setBounds(470, 300, 100, 19);
		
		LogInButton = new JButton("Log In");
		LogInButton.setFont(new Font("Open Sans", Font.BOLD, 13));
		LogInButton.setBounds(470, 350, 210, 30);
                LogInButton.setBackground(Color.DARK_GRAY);
                LogInButton.setForeground(Color.WHITE);
                LogInButton.setFocusable(false);
                LogInButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                LogInButton.addActionListener(this);
		
		BackButton = new JButton("Back");
		BackButton.setFont(new Font("Open Sans", Font.BOLD, 13));
		BackButton.setBounds(503, 400, 150, 30);
                BackButton.setBackground(Color.DARK_GRAY);
                BackButton.setForeground(Color.WHITE);
                BackButton.setFocusable(false);
                BackButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BackButton.addActionListener(this);
                
		add(QuoteText);
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
                             else if (accountType.equals("Employee") && domain.equalsIgnoreCase("employee.com")) 
                             {
                                 if (database.validateHRStaffCredentials(email, password)) 
                                 {
                                    dispose();
                                    new EmployeePage();
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
