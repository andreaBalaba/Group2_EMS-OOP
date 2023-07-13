package EmployeeManagementSystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class DeleteEmployee extends JFrame implements ActionListener 
{
    private EMSdataAccess database = new EMSdataAccess();
    private JLabel deleteEmpHeader, employeeListLabel, empIdLabel;
    private JTable employeeTable;
    private JScrollPane scrollPane;
    private JTextField empIdField;
    private JButton deleteButton, backButton;
    

    public DeleteEmployee() 
    {
        setTitle("Delete Employee");
        setBounds(100, 100, 750, 550);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

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
        
        add(deleteEmpHeader);
        add(empIdField);
        add(deleteButton);
        add(backButton);
        add(employeeListLabel);
        add(scrollPane);
        add(empIdLabel);

        setVisible(true);
        displayEmployeeList();
    }
    
    private void displayEmployeeList() 
    {
        DefaultTableModel model = database.getEmployeeTableModel();
        employeeTable.setModel(model);
        employeeTable.setEnabled(false);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == deleteButton) 
        {
            String employeeId = empIdField.getText();
            boolean success = database.deleteEmployee(employeeId);

            if (success) 
            {
                JOptionPane.showMessageDialog(null, "Employee deleted successfully.");
                displayEmployeeList();
            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "Failed to delete the employee.");
            }
        }
        else if (e.getSource() == backButton) 
        {
            dispose();
        }
    }
}

