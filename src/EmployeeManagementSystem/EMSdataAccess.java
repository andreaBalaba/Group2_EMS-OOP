package EmployeeManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class EMSdataAccess 
{
    private Connection connection;

    public EMSdataAccess() 
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/group2_ems", "root", "balaba");
            
        } 
        catch (ClassNotFoundException | SQLException e) 
        {
            e.printStackTrace();
        }
    }
    
    public Connection getConnection() 
    {
        return connection;
    }

    public boolean validateManagerCredentials(String email, String password) 
    {
        try 
        {
            String query = "SELECT * FROM logIndata WHERE email = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return false;
    }

    public boolean validateHRStaffCredentials(String email, String password) 
    {
        try 
        {
            String query = "SELECT * FROM logIndata WHERE email = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return false;
    }
    
    public List<String> retrieveExistingEmployeeIds() 
    {
        List<String> employeeIds = new ArrayList<>();

        try 
        {
            PreparedStatement statement = connection.prepareStatement("SELECT employeeId FROM employeeData");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) 
            {
                String employeeId = resultSet.getString("employeeId");
                employeeIds.add(employeeId);
            }

            resultSet.close();
            statement.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return employeeIds;
    }

    public String getNextEmployeeId() 
    {
        String nextEmployeeId = null;

        try 
        {
            String query = "SELECT MAX(employeeId) FROM employeeData";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) 
            {
                String lastEmployeeId = resultSet.getString(1);
                int lastNumber = Integer.parseInt(lastEmployeeId.substring(3));
                int nextNumber = lastNumber + 1;
                nextEmployeeId = String.format("%04d", nextNumber);
            }

            resultSet.close();
            statement.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return nextEmployeeId;
    }

    public boolean addEmployee(Employee employee) 
    {
        try 
        {
            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO employeeData (name, age, dateOfHired, email, address, phone, employeeId, education, position, salary, department) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            statement.setString(1, employee.getName());
            statement.setInt(2, employee.getAge());
            statement.setDate(3, new java.sql.Date(employee.getDateOfHired().getTime()));
            statement.setString(4, employee.getEmail());
            statement.setString(5, employee.getAddress());
            statement.setString(6, employee.getPhone());
            statement.setString(7, employee.getEmployeeId());
            statement.setString(8, employee.getEducation());
            statement.setString(9, employee.getPosition());
            statement.setInt(10, employee.getSalary());
            statement.setString(11, employee.getDepartment());

            int rowsAffected = statement.executeUpdate();
            statement.close();
            
            return rowsAffected > 0;
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<String> populateEmployeeIds() 
    {
        List<String> employeeIds = new ArrayList<>();

        try 
        {
            PreparedStatement statement = connection.prepareStatement("SELECT employeeId FROM employeeData");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) 
            {
                String employeeId = resultSet.getString("employeeId");
                employeeIds.add(employeeId);
            }

            resultSet.close();
            statement.close();
        
        
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return employeeIds;
    }
    
    public List<String> getEmployeeList() 
    {
        List<String> employeeList = new ArrayList<>();

            try {
                PreparedStatement statement = connection.prepareStatement("SELECT employeeId, name, position FROM employeeData");
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) 
                {
                    String employeeId = resultSet.getString("employeeId");
                    String name = resultSet.getString("name");
                    String position = resultSet.getString("position");
                    String employeeInfo = employeeId + "  " + name + " (" + position + ")";
                    employeeList.add(employeeInfo);
                }

                resultSet.close();
                statement.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
    }

    return employeeList;
    }

   
    public Employee displayEmployeeDetails(String employeeId) 
    {
        Employee employee = null;
            try 
            {
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM employeeData WHERE employeeId = ?");
                statement.setString(1, employeeId);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) 
                {
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    String department = resultSet.getString("department");
                    String position = resultSet.getString("position");
                    int salary = resultSet.getInt("salary");
                    String address = resultSet.getString("address");
                    String email = resultSet.getString("email");
                    String phone = resultSet.getString("phone");
                    String education = resultSet.getString("education");
                    Date dateOfHired = resultSet.getDate("dateOfHired");

                    employee = new Employee(name, age, department, position, salary, address, email, phone);
                    employee.setEducation(education);
                    employee.setDateOfHired(dateOfHired);

                } 
                else 
                {
                    System.out.println("Employee not found.");
                }

            resultSet.close();
            statement.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
            
        return employee;
    }

    public boolean updateEmployeeDetails(String employeeId, String name, String age, String department, String position,
                                         String salary, String address, String email, String phone) 
    {
        try 
        {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE employeeData SET name = ?, age = ?, department = ?, position = ?, salary = ?, address = ?, email = ?, phone = ? WHERE employeeId = ?");
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

            return rowsUpdated > 0;
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            return false;
        }
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
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM employeeData ORDER BY employeeId");
            ResultSet resultSet = statement.executeQuery();

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

            resultSet.close();
            statement.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return model;
    }
    
    public boolean deleteEmployee(String employeeId) 
    {
           
        try 
        {
            
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employeeData WHERE employeeId = ?");
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
    
    public void closeConnection() 
    {
        try 
        {
            connection.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

}

