
package EmployeeManagementSystem;

import java.sql.*;

public class EMSdatabase 
{
    Connection connection;
    Statement statement;
           
   public EMSdatabase()
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/group2_ems","root","balaba");
            statement = connection.createStatement();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
       
    }
  public Connection getConnection() 
    {
        return connection;
    }
  
  public void closeConnection() 
  {
        try 
        {
            if (connection != null && !connection.isClosed()) 
            {
                connection.close();
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
  
  public static void main(String[] args) 
    {
        new EMSdatabase();
        new MainPage();
    }
}

