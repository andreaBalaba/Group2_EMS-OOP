package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class UpdateEmployeeDetails implements ActionListener 
{
    
    private EMSdatabase database = new EMSdatabase();
    private JFrame updateEmployeeFrame;
    private JLabel titleLabel, employeeIdLabel, nameLabel, ageLabel, positionLabel, salaryLabel;
    private JLabel addressLabel, emailLabel, phoneLabel, departmentLabel;
    private JTextField nameField, ageField, positionField, salaryField, departmentField;
    private JTextField addressField, emailField, phoneField;
    private JButton updateButton, cancelButton;
    private JComboBox<String> employeeIdChoice;

    public UpdateEmployeeDetails() 
    {
        updateEmployeeFrame = new JFrame("Update Employee Details");
        updateEmployeeFrame.setBounds(100, 100, 400, 450);
        updateEmployeeFrame.setLocationRelativeTo(null);
        updateEmployeeFrame.setLayout(null);

        titleLabel = new JLabel("Update Employee Details");
        titleLabel.setFont(new Font("Open Sans", Font.BOLD, 18));
        titleLabel.setBounds(80, 20, 250, 30);

        employeeIdLabel = new JLabel("Employee ID:");
        employeeIdLabel.setBounds(40, 70, 100, 20);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(40, 100, 100, 20);

        ageLabel = new JLabel("Age:");
        ageLabel.setBounds(40, 130, 100, 20);
        
        departmentLabel = new JLabel("Department:");
        departmentLabel.setBounds(40, 160, 100, 20);

        departmentField = new JTextField();
        departmentField.setBounds(140, 160, 200, 20);

        positionLabel = new JLabel("Position:");
        positionLabel.setBounds(40, 190, 100, 20);

        salaryLabel = new JLabel("Salary:");
        salaryLabel.setBounds(40, 220, 100, 20);

        addressLabel = new JLabel("Address:");
        addressLabel.setBounds(40, 250, 100, 20);

        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(40, 280, 100, 20);

        phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(40, 310, 100, 20);

        employeeIdChoice = new JComboBox<>();
        employeeIdChoice.setBounds(140, 70, 200, 20);
        employeeIdChoice.addActionListener(this);

        nameField = new JTextField();
        nameField.setBounds(140, 100, 200, 20);

        ageField = new JTextField();
        ageField.setBounds(140, 130, 200, 20);

        positionField = new JTextField();
        positionField.setBounds(140, 190, 200, 20);

        salaryField = new JTextField();
        salaryField.setBounds(140, 220, 200, 20);

        addressField = new JTextField();
        addressField.setBounds(140, 250, 200, 20);

        emailField = new JTextField();
        emailField.setBounds(140, 280, 200, 20);

        phoneField = new JTextField();
        phoneField.setBounds(140, 310, 200, 20);

        updateButton = new JButton("Update");
        updateButton.setBounds(80, 355, 100, 30);
        updateButton.setBackground(Color.GRAY);
        updateButton.setForeground(Color.WHITE);
        updateButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        updateButton.setFocusable(false);
        updateButton.addActionListener(this);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(210, 355, 100, 30);
        cancelButton.setBackground(Color.GRAY);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cancelButton.setFocusable(false);
        cancelButton.addActionListener(this);

        updateEmployeeFrame.add(titleLabel);
        updateEmployeeFrame.add(employeeIdLabel);
        updateEmployeeFrame.add(nameLabel);
        updateEmployeeFrame.add(ageLabel);
        updateEmployeeFrame.add(positionLabel);
        updateEmployeeFrame.add(salaryLabel);
        updateEmployeeFrame.add(addressLabel);
        updateEmployeeFrame.add(emailLabel);
        updateEmployeeFrame.add(phoneLabel);
        updateEmployeeFrame.add(employeeIdChoice);
        updateEmployeeFrame.add(nameField);
        updateEmployeeFrame.add(ageField);
        updateEmployeeFrame.add(positionField);
        updateEmployeeFrame.add(salaryField);
        updateEmployeeFrame.add(addressField);
        updateEmployeeFrame.add(emailField);
        updateEmployeeFrame.add(phoneField);
        updateEmployeeFrame.add(updateButton);
        updateEmployeeFrame.add(cancelButton);
        updateEmployeeFrame.add(departmentLabel);
        updateEmployeeFrame.add(departmentField);

        updateEmployeeFrame.setVisible(true);

        populateEmployeeIds();
    }

    private void populateEmployeeIds() 
    {
        try 
        {
            PreparedStatement preparedStatement = database.connection.prepareStatement("SELECT employeeId FROM employeeData ORDER BY employeeId");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) 
            {
                String employeeId = resultSet.getString("employeeId");
                employeeIdChoice.addItem(employeeId);
            }
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(updateEmployeeFrame, "Error occurred while accessing the database.", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            updateEmployeeFrame.dispose();
        }
    }

    private void displayEmployeeDetails(String employeeId) 
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
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");

                nameField.setText(name);
                ageField.setText(age);
                departmentField.setText(department);
                positionField.setText(position);
                salaryField.setText(salary);
                addressField.setText(address);
                emailField.setText(email);
                phoneField.setText(phone);
            } 
            else 
            {
                // Employee not found
                JOptionPane.showMessageDialog(updateEmployeeFrame, "Employee not found!", 
                        "Error", JOptionPane.ERROR_MESSAGE);
                updateEmployeeFrame.dispose();
            }
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(updateEmployeeFrame, "Error occurred while accessing the database.", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            updateEmployeeFrame.dispose();
        }
    }

    private void updateEmployeeDetails(String employeeId) 
    {
        String name = nameField.getText();
        String age = ageField.getText();
        String department = departmentField.getText();
        String position = positionField.getText();
        String salary = salaryField.getText();
        String address = addressField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();

        try 
        {
            PreparedStatement preparedStatement = database.connection.prepareStatement("UPDATE employeeData SET name = ?, age = ?, "
                    + "department = ?, position = ?, salary = ?, address = ?, email = ?, phone = ? WHERE employeeId = ?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, age);
            preparedStatement.setString(3, department);
            preparedStatement.setString(4, position);
            preparedStatement.setString(5, salary);
            preparedStatement.setString(6, address);
            preparedStatement.setString(7, email);
            preparedStatement.setString(8, phone);
            preparedStatement.setString(9, employeeId);

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) 
            {
                JOptionPane.showMessageDialog(updateEmployeeFrame, "Employee details updated successfully.", 
                        "Success", JOptionPane.INFORMATION_MESSAGE);
                updateEmployeeFrame.dispose();
            } 
            else 
            {
                JOptionPane.showMessageDialog(updateEmployeeFrame, "Failed to update employee details.", 
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(updateEmployeeFrame, "Error occurred while accessing the database.", 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

  @Override
  public void actionPerformed(ActionEvent e) 
  {
        if (e.getSource() == employeeIdChoice) 
        {
            String selectedEmployeeId = (String) employeeIdChoice.getSelectedItem();
            displayEmployeeDetails(selectedEmployeeId);
        } 
        else if (e.getSource() == updateButton) 
        {
            String selectedEmployeeId = (String) employeeIdChoice.getSelectedItem();
            updateEmployeeDetails(selectedEmployeeId);
        } 
        else if (e.getSource() == cancelButton) 
        {
            updateEmployeeFrame.dispose();
        }
  }
}
