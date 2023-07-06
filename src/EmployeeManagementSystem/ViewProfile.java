package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ViewProfile extends JFrame implements ActionListener
{   
    private EMSdataAccess database = new EMSdataAccess();
    private JLabel titleLabel, employeeIdLabel, nameLabel, ageLabel, positionLabel,depLabel;
    private JLabel salaryLabel, addressLabel, hireLabel, educationLabel, emailLabel, phoneLabel;
    private JTextField employeeIdField, nameField, ageField, positionField, salaryField, addressField;
    private JTextField hireField, educationField, emailField, phoneField, depField;
    private JButton backButton;
    private String employeeId;

    public ViewProfile(String employeeId) 
    {
        this.employeeId = employeeId;
        
        setTitle("View Employee Profile");
        setBounds(100, 100, 400, 550);
        setLocationRelativeTo(null);
        setLayout(null);

        titleLabel = new JLabel("Employee Profile");
        titleLabel.setFont(new Font("Open Sans", Font.BOLD, 18));
        titleLabel.setBounds(130, 20, 200, 30);

        employeeIdLabel = new JLabel("Employee ID:");
        employeeIdLabel.setBounds(40, 70, 100, 20);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(40, 100, 100, 20);

        ageLabel = new JLabel("Age:");
        ageLabel.setBounds(40, 130, 100, 20);
        
        depLabel = new JLabel("Department:");
        depLabel.setBounds(40, 160, 100, 20);

        positionLabel = new JLabel("Position:");
        positionLabel.setBounds(40, 190, 100, 20);

        salaryLabel = new JLabel("Salary:");
        salaryLabel.setBounds(40, 220, 100, 20);
        
        hireLabel = new JLabel("Date of Hired:");
        hireLabel.setBounds(40, 250, 100, 20);
        
        addressLabel = new JLabel("Address:");
        addressLabel.setBounds(40, 280, 100, 20);
        
        educationLabel = new JLabel("Education:");
        educationLabel.setBounds(40, 310, 100, 20);
        
        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(40, 340, 100, 20);
        
        phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(40, 370, 100, 20);

        employeeIdField = new JTextField();
        employeeIdField.setEditable(false);
        employeeIdField.setBounds(140, 70, 200, 20);
        employeeIdField.setBorder(null);

        nameField = new JTextField();
        nameField.setEditable(false);
        nameField.setBounds(140, 100, 200, 20);
        nameField.setBorder(null);

        ageField = new JTextField();
        ageField.setEditable(false);
        ageField.setBounds(140, 130, 200, 20);
        ageField.setBorder(null);
        
        depField = new JTextField();
        depField.setEditable(false);
        depField.setBounds(140, 160, 200, 20);
        depField.setBorder(null);

        positionField = new JTextField();
        positionField.setEditable(false);
        positionField.setBounds(140, 190, 200, 20);
        positionField.setBorder(null);

        salaryField = new JTextField();
        salaryField.setEditable(false);
        salaryField.setBounds(140, 220, 200, 20);
        salaryField.setBorder(null);
        
        hireField = new JTextField();
        hireField.setEditable(false);
        hireField.setBounds(140, 250, 200, 20);
        hireField.setBorder(null);
        
        addressField = new JTextField();
        addressField.setEditable(false);
        addressField.setBounds(140, 280, 200, 20);
        addressField.setBorder(null);
        
        educationField = new JTextField();
        educationField.setEditable(false);
        educationField.setBounds(140, 310, 200, 20);
        educationField.setBorder(null);
        
        emailField = new JTextField();
        emailField.setEditable(false);
        emailField.setBounds(140, 340, 200, 20);
        emailField.setBorder(null);
        
        phoneField = new JTextField();
        phoneField.setEditable(false);
        phoneField.setBounds(140, 370, 200, 20);
        phoneField.setBorder(null);

        backButton = new JButton("Back");
        backButton.setFont(new Font("Open Sans", Font.BOLD, 13));
        backButton.setBackground(Color.GRAY);
        backButton.setForeground(Color.WHITE);
        backButton.setFocusable(false);
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.setBounds(150, 425, 100, 30);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        
        add(titleLabel);
        add(employeeIdLabel);
        add(nameLabel);
        add(ageLabel);
        add(positionLabel);
        add(salaryLabel);
        add(addressLabel);
        add(hireLabel);
        add(educationLabel);
        add(emailLabel);
        add(phoneLabel);
        add(employeeIdField);
        add(nameField);
        add(ageField);
        add(positionField);
        add(salaryField);
        add(addressField);
        add(hireField);
        add(educationField);
        add(emailField);
        add(phoneField);
        add(backButton);
        add(depLabel);
        add(depField);

        setVisible(true);
        
        displayProfile();
    }
    
    private void displayProfile() 
    {
    
        Employee employee = database.displayEmployeeDetails(employeeId);

        if (employee != null) 
        {
            employeeIdField.setText(employeeId);
            nameField.setText(employee.getName());
            ageField.setText(Integer.toString(employee.getAge()));
            depField.setText(employee.getDepartment());
            positionField.setText(employee.getPosition());
            salaryField.setText(Integer.toString(employee.getSalary()));
            hireField.setText(employee.getDateOfHired().toString());
            addressField.setText(employee.getAddress());
            educationField.setText(employee.getEducation());
            emailField.setText(employee.getEmail());
            phoneField.setText(employee.getPhone());
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "Employee not found!", "Error", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == backButton) 
        {
            dispose();
        }
    }   
}
