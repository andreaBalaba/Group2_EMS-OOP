package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SearchEmployee implements ActionListener {
    
        private EMSdatabase database = new EMSdatabase();
        private JFrame searchFrame;
        private JLabel titleLabel, employeeIdLabel;
        private JTextField employeeIdField;
        private JButton searchButton;
        private JTextArea employeeListTextArea;

    public SearchEmployee() {
        
        searchFrame = new JFrame("Search Employee");
        searchFrame.setBounds(100, 100, 300, 335);
        searchFrame.setLocationRelativeTo(null);
        searchFrame.setLayout(null);

        titleLabel = new JLabel("Search Employee");
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

        searchFrame.add(titleLabel);
        searchFrame.add(employeeIdLabel);
        searchFrame.add(employeeIdField);
        searchFrame.add(searchButton);
        searchFrame.add(scrollPane);

        searchFrame.setVisible(true);

        displayEmployeeList();
    }

    public void search() 
    {
        String employeeId = employeeIdField.getText();
    
        if (!employeeId.isEmpty()) 
        {
             try 
             {
                  PreparedStatement preparedStatement = database.getConnection().prepareStatement("SELECT * FROM employeeData WHERE employeeId = ?");
                  preparedStatement.setString(1, employeeId);
                  ResultSet resultSet = preparedStatement.executeQuery();

                  if (resultSet.next()) 
                  {
                     searchFrame.dispose();
                     new ViewProfile(employeeId);
                  } 
                  else 
                  {
                     JOptionPane.showMessageDialog(searchFrame, "No employee found with the given ID.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                  }
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(searchFrame, "Error occurred while accessing the database.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    else 
      {
        JOptionPane.showMessageDialog(searchFrame, "Please enter an employee ID.",
                "Error", JOptionPane.ERROR_MESSAGE);
      }
    }

    public void displayEmployeeList() 
    {
        try 
        {
             PreparedStatement preparedStatement = database.getConnection().prepareStatement("SELECT employeeId, name, position FROM employeeData");
             ResultSet resultSet = preparedStatement.executeQuery();

             StringBuilder employeeList = new StringBuilder();
               while (resultSet.next()) 
                {
                     String employeeId = resultSet.getString("employeeId");
                     String name = resultSet.getString("name");
                     String position = resultSet.getString("position");
                     employeeList.append(employeeId).append("  ").append(name).append(" (").append(position).append(")").append("\n");
                }

        employeeListTextArea.setText(employeeList.toString());
        } 
        catch (SQLException exp) 
        {
             exp.printStackTrace();
             JOptionPane.showMessageDialog(searchFrame, "Error occurred while accessing the database.",
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