package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewProfile implements ActionListener
{   
    private EMSdatabase database = new EMSdatabase();
    private JFrame viewProfileFrame;
    private JLabel titleLabel, employeeIdLabel, nameLabel, ageLabel, positionLabel,depLabel;
    private JLabel salaryLabel, addressLabel, hireLabel, educationLabel, emailLabel, phoneLabel;
    private JTextField employeeIdField, nameField, ageField, positionField, salaryField, addressField;
    private JTextField hireField, educationField, emailField, phoneField, depField;
    private JButton backButton;
    private String employeeId;

    public ViewProfile(String employeeId) 
    {
        this.employeeId = employeeId;
        
        viewProfileFrame = new JFrame("View Employee Profile");
        viewProfileFrame.setBounds(100, 100, 400, 550);
        viewProfileFrame.setLocationRelativeTo(null);
        viewProfileFrame.setLayout(null);

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

        nameField = new JTextField();
        nameField.setEditable(false);
        nameField.setBounds(140, 100, 200, 20);

        ageField = new JTextField();
        ageField.setEditable(false);
        ageField.setBounds(140, 130, 200, 20);
        
        depField = new JTextField();
        depField.setEditable(false);
        depField.setBounds(140, 160, 200, 20);

        positionField = new JTextField();
        positionField.setEditable(false);
        positionField.setBounds(140, 190, 200, 20);

        salaryField = new JTextField();
        salaryField.setEditable(false);
        salaryField.setBounds(140, 220, 200, 20);
        
        hireField = new JTextField();
        hireField.setEditable(false);
        hireField.setBounds(140, 250, 200, 20);
        
        addressField = new JTextField();
        addressField.setEditable(false);
        addressField.setBounds(140, 280, 200, 20);
        
        educationField = new JTextField();
        educationField.setEditable(false);
        educationField.setBounds(140, 310, 200, 20);
        
        emailField = new JTextField();
        emailField.setEditable(false);
        emailField.setBounds(140, 340, 200, 20);
        
        phoneField = new JTextField();
        phoneField.setEditable(false);
        phoneField.setBounds(140, 370, 200, 20);

        backButton = new JButton("Back");
        backButton.setFont(new Font("Open Sans", Font.BOLD, 13));
        backButton.setBackground(Color.GRAY);
        backButton.setForeground(Color.WHITE);
        backButton.setFocusable(false);
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.setBounds(150, 425, 100, 30);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
            

        viewProfileFrame.add(titleLabel);
        viewProfileFrame.add(employeeIdLabel);
        viewProfileFrame.add(nameLabel);
        viewProfileFrame.add(ageLabel);
        viewProfileFrame.add(positionLabel);
        viewProfileFrame.add(salaryLabel);
        viewProfileFrame.add(addressLabel);
        viewProfileFrame.add(hireLabel);
        viewProfileFrame.add(educationLabel);
        viewProfileFrame.add(emailLabel);
        viewProfileFrame.add(phoneLabel);
        viewProfileFrame.add(employeeIdField);
        viewProfileFrame.add(nameField);
        viewProfileFrame.add(ageField);
        viewProfileFrame.add(positionField);
        viewProfileFrame.add(salaryField);
        viewProfileFrame.add(addressField);
        viewProfileFrame.add(hireField);
        viewProfileFrame.add(educationField);
        viewProfileFrame.add(emailField);
        viewProfileFrame.add(phoneField);
        viewProfileFrame.add(backButton);
        viewProfileFrame.add(depLabel);
        viewProfileFrame.add(depField);

        viewProfileFrame.setVisible(true);

        displayProfile();
    }
    

    public void displayProfile() 
    {
        try 
        {
            PreparedStatement preparedStatement = database.connection.prepareStatement("SELECT * FROM employeeData WHERE employeeId = ?");
            preparedStatement.setString(1, employeeId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) 
            {
                String name = resultSet.getString("name");
                String age = resultSet.getString("age");
                String department = resultSet.getString("department");
                String position = resultSet.getString("position");
                String salary = resultSet.getString("salary");
                String dateOfHired = resultSet.getString("dateOfHired");
                String address = resultSet.getString("address");
                String education = resultSet.getString("education");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");

                employeeIdField.setText(employeeId);
                nameField.setText(name);
                ageField.setText(age);
                depField.setText(department);
                positionField.setText(position);
                salaryField.setText(salary);
                hireField.setText(dateOfHired);
                addressField.setText(address);
                educationField.setText(education);
                emailField.setText(email);
                phoneField.setText(phone);
            } 
            else 
            {
                // Employee not found
                JOptionPane.showMessageDialog(viewProfileFrame, "Employee not found!", 
                        "Error", JOptionPane.ERROR_MESSAGE);
                viewProfileFrame.dispose();
            }
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(viewProfileFrame, "Error occurred while accessing the database.", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            viewProfileFrame.dispose();
        } 
        finally 
        {
            database.closeConnection();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == backButton) 
        {
            viewProfileFrame.dispose();
        }
    }   
}
