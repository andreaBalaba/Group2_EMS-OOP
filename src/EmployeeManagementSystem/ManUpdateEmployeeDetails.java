package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class ManUpdateEmployeeDetails extends JFrame implements ActionListener 
{
    
    private EMSdataAccess database = new EMSdataAccess();
    private JLabel titleLabel, employeeIdLabel, nameLabel, ageLabel, positionLabel, salaryLabel;
    private JLabel addressLabel, emailLabel, phoneLabel, departmentLabel;
    private JTextField nameField, ageField, positionField, salaryField, departmentField;
    private JTextField addressField, emailField, phoneField;
    private JButton updateButton, cancelButton;
    private JComboBox<String> employeeIdChoice;

    public ManUpdateEmployeeDetails() 
    {
        setTitle("Update Employee Details");
        setBounds(100, 100, 400, 450);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

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

        cancelButton = new JButton("Back");
        cancelButton.setBounds(210, 355, 100, 30);
        cancelButton.setBackground(Color.GRAY);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cancelButton.setFocusable(false);
        cancelButton.addActionListener(this);

        add(titleLabel);
        add(employeeIdLabel);
        add(nameLabel);
        add(ageLabel);
        add(positionLabel);
        add(salaryLabel);
        add(addressLabel);
        add(emailLabel);
        add(phoneLabel);
        add(employeeIdChoice);
        add(nameField);
        add(ageField);
        add(positionField);
        add(salaryField);
        add(addressField);
        add(emailField);
        add(phoneField);
        add(updateButton);
        add(cancelButton);
        add(departmentLabel);
        add(departmentField);

        setVisible(true);

        populateEmployeeIds();
    }
    
    private void populateEmployeeIds() 
    {
        List<String> employeeIds = database.retrieveExistingEmployeeIds();

        employeeIdChoice.removeAllItems(); 

        for (String employeeId : employeeIds) 
        {
            employeeIdChoice.addItem(employeeId); 
        }
    }
    
    private GetSetEmployee displayEmployeeDetails(String employeeId) 
    {
        GetSetEmployee employee = database.displayEmployeeDetails(employeeId);
        
        if (employee != null) 
        {
            nameField.setText(employee.getName());
            ageField.setText(Integer.toString(employee.getAge()));
            departmentField.setText(employee.getDepartment());
            positionField.setText(employee.getPosition());
            salaryField.setText(Integer.toString(employee.getSalary()));
            addressField.setText(employee.getAddress());
            emailField.setText(employee.getEmail());
            phoneField.setText(employee.getPhone());
        } 
        else 
        {
            JOptionPane.showMessageDialog(this, "Employee not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    
        return employee;
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
      

        boolean success = database.updateEmployeeDetails(employeeId, name, age, department, position, salary, address, email, phone);
        
        if (success) 
        {
            JOptionPane.showMessageDialog(this, "Employee details updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } 
        else 
        {
            JOptionPane.showMessageDialog(this, "Failed to update employee details.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
  @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == employeeIdChoice) 
        {
            String selectedEmployeeId = employeeIdChoice.getSelectedItem().toString();
            displayEmployeeDetails(selectedEmployeeId);
        } 
        else if (e.getSource() == updateButton) 
        {
            String selectedEmployeeId =  employeeIdChoice.getSelectedItem().toString();
            updateEmployeeDetails(selectedEmployeeId);
        } 
        else if (e.getSource() == cancelButton) 
        {
            dispose();
            new ManagerPage();
        }
  }
}
