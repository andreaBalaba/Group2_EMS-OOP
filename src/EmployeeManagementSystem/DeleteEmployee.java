package EmployeeManagementSystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Vector;

public class DeleteEmployee implements ActionListener 
{
    private EMSdatabase database = new EMSdatabase();
    private JFrame deleteEmpFrame;
    private JLabel deleteEmpHeader, employeeListLabel, empIdLabel;
    private JTable employeeTable;
    private JScrollPane scrollPane;
    private JTextField empIdField;
    private JButton deleteButton, backButton;
    
    private boolean deleteEmployee(String employeeId) {
           
        try 
        {
            
            PreparedStatement preparedStatement = database.connection.prepareStatement("DELETE FROM employeeData WHERE employeeId = ?");
            preparedStatement.setString(1, employeeId);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            return false;
        }
    }

    public DeleteEmployee() 
    {
        deleteEmpFrame = new JFrame("Delete Employee");
        deleteEmpFrame.setBounds(100, 100, 750, 550);
        deleteEmpFrame.setLocationRelativeTo(null);
        deleteEmpFrame.setLayout(null);

        deleteEmpHeader = new JLabel("Delete Employee Information");
        deleteEmpHeader.setFont(new Font("Open Sans", Font.BOLD, 25));
        deleteEmpHeader.setBounds(210, 50, 500, 50);
        
        employeeListLabel = new JLabel("List of Employees:");
        employeeListLabel.setBounds(50, 120, 150, 30);
        employeeListLabel.setFont(new Font("Open Sans", Font.PLAIN, 16));

        employeeTable = new JTable();
        scrollPane = new JScrollPane(employeeTable);
        scrollPane.setBounds(50, 160, 640, 250);

        empIdLabel = new JLabel("Employee ID:");
        empIdLabel.setFont(new Font("Open Sans", Font.BOLD, 13));
        empIdLabel.setBounds(280, 420, 120, 30);

        empIdField = new JTextField();
        empIdField.setFont(new Font("Open Sans", Font.PLAIN, 12));
        empIdField.setBounds(380, 420, 100, 26);

        deleteButton = new JButton("Delete");
        deleteButton.setFont(new Font("Open Sans", Font.BOLD, 13));
        deleteButton.setBounds(250, 455, 95, 30);
        deleteButton.setBackground(Color.GRAY);
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFocusable(false);
        deleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        deleteButton.addActionListener(this);

        backButton = new JButton("Back");
        backButton.setFont(new Font("Open Sans", Font.BOLD, 13));
        backButton.setBounds(420, 455, 95, 30);
        backButton.setBackground(Color.GRAY);
        backButton.setForeground(Color.WHITE);
        backButton.setFocusable(false);
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.addActionListener(this);
        
        deleteEmpFrame.add(deleteEmpHeader);
        deleteEmpFrame.add(empIdField);
        deleteEmpFrame.add(deleteButton);
        deleteEmpFrame.add(backButton);
        deleteEmpFrame.add(employeeListLabel);
        deleteEmpFrame.add(scrollPane);
        deleteEmpFrame.add(empIdLabel);

        deleteEmpFrame.setVisible(true);
        displayEmployeeList();
    }
    
    private void displayEmployeeList() 
    {
        DefaultTableModel model = getEmployeeTableModel();
        employeeTable.setModel(model);
    }
    
    public DefaultTableModel getEmployeeTableModel() 
    {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Employee ID");
        model.addColumn("Name");
        model.addColumn("Department");
        model.addColumn("Date of Hired");
        model.addColumn("Position");
        model.addColumn("Salary");

        try 
        {
            ResultSet resultSet = database.statement.executeQuery("SELECT * FROM employeeData ORDER BY employeeId");

            while (resultSet.next()) 
            {
                String employeeId = resultSet.getString("employeeId");
                String name = resultSet.getString("name");
                String department = resultSet.getString("department");
                String dateOfHired = resultSet.getString("dateOfHired");
                String position = resultSet.getString("position");
                String salary = resultSet.getString("salary");

                Vector<String> rowData = new Vector<>();
                rowData.add(employeeId);
                rowData.add(name);
                rowData.add(department);
                rowData.add(dateOfHired);
                rowData.add(position);
                rowData.add(salary);

                model.addRow(rowData);
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return model;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == deleteButton) 
        {
            String employeeId = empIdField.getText();
            boolean success = deleteEmployee(employeeId);

            if (success) 
            {
                JOptionPane.showMessageDialog(deleteEmpFrame, "Employee deleted successfully.");
                displayEmployeeList();
            } 
            else 
            {
                JOptionPane.showMessageDialog(deleteEmpFrame, "Failed to delete the employee.");
            }
        }
        else if (e.getSource() == backButton) 
        {
            deleteEmpFrame.dispose();
        }
    }
}

