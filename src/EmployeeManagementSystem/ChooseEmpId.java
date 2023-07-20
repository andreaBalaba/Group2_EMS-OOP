package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class ChooseEmpId extends JFrame implements ActionListener {
    
    private EMSdataAccess database = new EMSdataAccess();
    private JLabel titleLabel, employeeIdLabel;
    private JTextField employeeIdField;
    private JButton searchButton;
    private JTextArea employeeListTextArea;

    public ChooseEmpId() {
        
        setTitle("Search Employee");
        setBounds(100, 100, 300, 335);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        titleLabel = new JLabel("Choose your Employee ID");
        titleLabel.setFont(new Font("Open Sans", Font.BOLD, 16));
        titleLabel.setBounds(75, 20, 200, 30);

        employeeIdLabel = new JLabel("Employee ID:");
        employeeIdLabel.setBounds(50, 200, 100, 20);

        employeeIdField = new JTextField();
        employeeIdField.setBounds(140, 200, 100, 20);

        searchButton = new JButton("Search");
        searchButton.setFont(new Font("Open Sans", Font.BOLD, 13));
        searchButton.setBackground(Color.GRAY);
        searchButton.setForeground(Color.WHITE);
        searchButton.setFocusable(false);
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setBounds(95, 235, 100, 30);
        searchButton.addActionListener(this);

        employeeListTextArea = new JTextArea();
        employeeListTextArea.setEditable(false);
        employeeListTextArea.setBounds(40, 60, 210, 130);
        JScrollPane scrollPane = new JScrollPane(employeeListTextArea);
        scrollPane.setBounds(40, 60, 210, 130);

        add(titleLabel);
        add(employeeIdLabel);
        add(employeeIdField);
        add(searchButton);
        add(scrollPane);

        setVisible(true);

        displayEmployeeList();
    }

    public void search() 
    {
        String employeeId = employeeIdField.getText();

        if (!employeeId.isEmpty()) 
        {
            GetSetEmployee employee = database.displayEmployeeDetails(employeeId);

            if (employee != null) 
            {
                dispose();
                new EmpTimeOff(employeeId);
            } 
            else 
            {
            JOptionPane.showMessageDialog(null, "No employee found with the given ID.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "Please enter an employee ID.",
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void displayEmployeeList() 
    {
        List<String> employeeList = database.getEmployeeList();
    
            if (employeeList != null && !employeeList.isEmpty()) 
            {
                StringBuilder employeeListBuilder = new StringBuilder();
                for (String employee : employeeList) 
                {
                    employeeListBuilder.append(employee).append("\n");
                }
                employeeListTextArea.setText(employeeListBuilder.toString());
            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "Error occurred while retrieving employee list.",
                "Error", JOptionPane.ERROR_MESSAGE);
            }
    }


    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == searchButton) 
        {
            search();
        }
   }
}