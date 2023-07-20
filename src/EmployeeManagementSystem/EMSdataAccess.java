package EmployeeManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
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
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/group2_ems", "root", "Miyu@ki29");
            
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

    public boolean addEmployee(GetSetEmployee employee) 
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
    
    public boolean addEmployeelogin(GetSetEmployee employeelogin) 
    {
        try 
        {
            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO logIndata (email, password) " +
                "VALUES (?, ?)");
            
            statement.setString(1, employeelogin.getLogIn());
            statement.setString(2, employeelogin.getPass());
           

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
    
    public boolean addEmployeeTime(GetSetEmployee employee) 
    {
        try 
        {
            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO time_off_request (employee_name, department, manager, employee_id, total_hours, date_of_absence_from, date_of_absence_to, vacation, medical_leave, \n" +
"              jury_duty, personal_leave, family_reasons, to_vote, bereavement, time_off_without_pay, reason_for_request, employee_signature, request_date, status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'Pending')");
            
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getDepartment());
            statement.setString(3, employee.getManager());
            statement.setString(4, employee.getEmployeeId());
            statement.setInt(5, employee.getTotalHours());
            statement.setDate(6, new java.sql.Date(employee.getDateOfAbsenceFrom().getTime()));
            statement.setDate(7, new java.sql.Date(employee.getDateOfAbsenceTo().getTime()));
            statement.setBoolean(8, employee.isVacation());
            statement.setBoolean(9, employee.isMedicalLeave());
            statement.setBoolean(10, employee.isJuryDuty());
            statement.setBoolean(11, employee.isPersonalLeave());
            statement.setBoolean(12, employee.isFamilyReasons());
            statement.setBoolean(13, employee.isToVote());
            statement.setBoolean(14, employee.isBereavement());
            statement.setBoolean(15, employee.isTimeOffWithoutPay());
            statement.setString(16, employee.getReasonForRequest());
            statement.setString(17, employee.getEmployeeSignature());
            statement.setDate(18, new java.sql.Date(employee.getRequestDate().getTime()));
            
            
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
    
    public boolean addExpense(GetSetEmployee employee) 
    {
        try 
        {
            PreparedStatement statement = connection.prepareStatement(
                " INSERT INTO expense_request (name, employeeId, email, department, reqDate, projName, reqEndDate, amount, notes, inititate, planning, execution, perform, closure, summary )" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'Pending')");
            
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getEmployeeId());
            statement.setString(3, employee.getEmail());
            statement.setString(4, employee.getDepartment());
            statement.setDate(5, new java.sql.Date(employee.getdateRequest().getTime()));
            statement.setString(6, employee.getProjName());
            statement.setDate(7, new java.sql.Date(employee.getdateEnd().getTime()));
            statement.setInt(8, employee.getAmount());
            statement.setString(9, employee.getNotes());
            statement.setBoolean(8, employee.isInitiation());
            statement.setBoolean(9, employee.isPlanning());
            statement.setBoolean(10, employee.isExecution());
            statement.setBoolean(11, employee.isPerform());
            statement.setBoolean(12, employee.isClosure());
            statement.setString(16, employee.getSummary());
 
            
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

    public List<String> getDistinctEmployeeIds() 
    {
        List<String> employeeIds = new ArrayList<>();

        try 
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT DISTINCT employee_id FROM performance_review;");

            while (resultSet.next()) 
            {
                String employeeId = resultSet.getString("employee_id");
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
    
    public GetSetEmployee getEmployeeReview(String employeeId) 
    {
        GetSetEmployee review = null;

        try 
        {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM performance_review WHERE employee_id = ?");
            statement.setString(1, employeeId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) 
            {
                String name = resultSet.getString("name");
                String position = resultSet.getString("position");
                String manager = resultSet.getString("manager");
                Date date = resultSet.getDate("date");
                String department = resultSet.getString("department");
                boolean workToFullPotential = resultSet.getBoolean("work_to_full_potential");
                boolean workConsistency = resultSet.getBoolean("work_consistency");
                boolean qualityOfWork = resultSet.getBoolean("quality_of_work");
                boolean goodCommunication = resultSet.getBoolean("good_communication");
                boolean takesInitiative = resultSet.getBoolean("takes_initiative");
                boolean creativity = resultSet.getBoolean("creativity");
                boolean reliability = resultSet.getBoolean("reliability");
                boolean productivity = resultSet.getBoolean("productivity");
                boolean technicalSkills = resultSet.getBoolean("technical_skills");
                boolean efficiency = resultSet.getBoolean("efficiency");
                boolean teamwork = resultSet.getBoolean("teamwork");
                boolean leadership = resultSet.getBoolean("leadership");
                boolean independentWork = resultSet.getBoolean("independent_work");
                boolean punctuality = resultSet.getBoolean("punctuality");
                String areaOfImprovement = resultSet.getString("area_of_improvement");
                String comment = resultSet.getString("comment");
                String overallReview = resultSet.getString("overall_review");

                review = new GetSetEmployee(employeeId, name, position, manager, date, department, workToFullPotential,
                    workConsistency, qualityOfWork, goodCommunication, takesInitiative, creativity, reliability,
                    productivity, technicalSkills, efficiency, teamwork, leadership, independentWork, punctuality,
                    areaOfImprovement, comment, overallReview);
            }

            resultSet.close();
            statement.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return review;
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

    public GetSetEmployee displayEmployeeDetails(String employeeId) 
    {
        GetSetEmployee employee = null;
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

                    GetSetEmployee review = getEmployeeReview(employeeId);
                    String overallReview = (review != null) ? review.getOverallReview() : "";

                    
                    employee = new GetSetEmployee(name, age, department, position, salary, address, email, phone);
                    employee.setEducation(education);
                    employee.setDateOfHired(dateOfHired);
                    employee.setOverallReview(overallReview);

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
    
    public boolean savePerformanceReview(GetSetEmployee employee) 
    {
        try 
        {
        
            String sql = "INSERT INTO performance_review (name, position, manager, date, department, employee_id, " +
                "work_to_full_potential, work_consistency, quality_of_work, good_communication, " +
                "takes_initiative, creativity, reliability, productivity, technical_skills, efficiency, " +
                "teamwork, leadership, independent_work, punctuality, area_of_improvement, comment, overall_review) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, employee.getName());
            statement.setString(2, employee.getPosition());
            statement.setString(3, employee.getManager());
            statement.setDate(4, new java.sql.Date(employee.getDate().getTime()));
            statement.setString(5, employee.getDepartment());
            statement.setString(6, employee.getEmployeeId());
            statement.setBoolean(7, employee.isWorkToFullPotential());
            statement.setBoolean(8, employee.isWorkConsistency());
            statement.setBoolean(9, employee.isQualityOfWork());
            statement.setBoolean(10, employee.isGoodCommunication());
            statement.setBoolean(11, employee.isTakesInitiative());
            statement.setBoolean(12, employee.isCreativity());
            statement.setBoolean(13, employee.isReliability());
            statement.setBoolean(14, employee.isProductivity());
            statement.setBoolean(15, employee.isTechnicalSkills());
            statement.setBoolean(16, employee.isEfficiency());
            statement.setBoolean(17, employee.isTeamwork());
            statement.setBoolean(18, employee.isLeadership());
            statement.setBoolean(19, employee.isIndependentWork());
            statement.setBoolean(20, employee.isPunctuality());
            statement.setString(21, employee.getAreaOfImprovement());
            statement.setString(22, employee.getComment());
            statement.setString(23, employee.getOverallReview());

            statement.executeUpdate();

            statement.close();

            return true;
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            return false;
        }
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
   
    public boolean updateReviewData(GetSetEmployee review) 
    {
        try 
        {
            PreparedStatement updateStatement = connection.prepareStatement(
                "UPDATE performance_review SET name = ?, position = ?, manager = ?, date = ?, department = ?, " +
                "work_to_full_potential = ?, work_consistency = ?, quality_of_work = ?, good_communication = ?, " +
                "takes_initiative = ?, creativity = ?, reliability = ?, productivity = ?, " +
                "technical_skills = ?, efficiency = ?, teamwork = ?, leadership = ?, " +
                "independent_work = ?, punctuality = ?, area_of_improvement = ?, comment = ?, overall_review = ? " +
                "WHERE employee_id = ?");

            updateStatement.setString(1, review.getName());
            updateStatement.setString(2, review.getPosition());
            updateStatement.setString(3, review.getManager());
            updateStatement.setDate(4, new java.sql.Date(review.getDate().getTime()));
            updateStatement.setString(5, review.getDepartment());
            updateStatement.setBoolean(6, review.isWorkToFullPotential());
            updateStatement.setBoolean(7, review.isWorkConsistency());
            updateStatement.setBoolean(8, review.isQualityOfWork());
            updateStatement.setBoolean(9, review.isGoodCommunication());
            updateStatement.setBoolean(10, review.isTakesInitiative());
            updateStatement.setBoolean(11, review.isCreativity());
            updateStatement.setBoolean(12, review.isReliability());
            updateStatement.setBoolean(13, review.isProductivity());
            updateStatement.setBoolean(14, review.isTechnicalSkills());
            updateStatement.setBoolean(15, review.isEfficiency());
            updateStatement.setBoolean(16, review.isTeamwork());
            updateStatement.setBoolean(17, review.isLeadership());
            updateStatement.setBoolean(18, review.isIndependentWork());
            updateStatement.setBoolean(19, review.isPunctuality());
            updateStatement.setString(20, review.getAreaOfImprovement());
            updateStatement.setString(21, review.getComment());
            updateStatement.setString(22, review.getOverallReview());
            updateStatement.setString(23, review.getEmployeeId());

            int rowsAffected = updateStatement.executeUpdate();

            if (rowsAffected > 0) 
            {
                return true; 
            } 
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return false; 

    }

    public boolean deleteReviewData(String employeeId) 
    {
        try 
        {
            PreparedStatement deleteStatement = connection.prepareStatement(
                "DELETE FROM performance_review WHERE employee_id = ?");
            deleteStatement.setString(1, employeeId);
            int rowsAffected = deleteStatement.executeUpdate();

                if (rowsAffected > 0) 
                {
                    return true; 
                
                }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return false; 
    }
    
    public Vector<Vector<Object>> getTimeOffRequests() 
    {
        Vector<Vector<Object>> data = new Vector<>();

        try 
        {
            Statement stmt = connection.createStatement();
            String query = "SELECT request_id, employee_name, department, request_date, status FROM time_off_request";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) 
            {
                Vector<Object> row = new Vector<>();
                row.add(rs.getInt("request_id"));
                row.add(rs.getString("employee_name"));
                row.add(rs.getString("department"));
                row.add(rs.getDate("request_date"));
                row.add(rs.getString("status"));
                data.add(row);
            }

        rs.close();
        stmt.close();

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return data;
    }
    
        public Vector<Vector<Object>> getExpenseRequests() 
    {
        Vector<Vector<Object>> data = new Vector<>();

        try 
        {
            Statement stmt = connection.createStatement();
            String query = "SELECT request_id, name, reqdate, status FROM expense_request";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) 
            {
                Vector<Object> row = new Vector<>();
                row.add(rs.getInt("request_id"));
                row.add(rs.getString("name"));
                row.add(rs.getString("department"));
                row.add(rs.getDate("reqdate"));
                row.add(rs.getString("status"));
                data.add(row);
            }

        rs.close();
        stmt.close();

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return data;
    }

    public Vector<Object> getTimeOffRequestById(int requestId) 
    {
        Vector<Object> rowData = new Vector<>();

        try 
        {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM time_off_request WHERE request_id = ?");
            statement.setInt(1, requestId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) 
            {
                rowData.add(resultSet.getInt("request_id"));
                rowData.add(resultSet.getString("employee_name"));
                rowData.add(resultSet.getString("department"));
                rowData.add(resultSet.getString("manager"));
                rowData.add(resultSet.getString("employee_id"));
                rowData.add(resultSet.getInt("total_hours"));
                rowData.add(resultSet.getDate("date_of_absence_from"));
                rowData.add(resultSet.getDate("date_of_absence_to"));
                rowData.add(resultSet.getBoolean("vacation"));
                rowData.add(resultSet.getBoolean("medical_leave"));
                rowData.add(resultSet.getBoolean("jury_duty"));
                rowData.add(resultSet.getBoolean("personal_leave"));
                rowData.add(resultSet.getBoolean("family_reasons"));
                rowData.add(resultSet.getBoolean("to_vote"));
                rowData.add(resultSet.getBoolean("bereavement"));
                rowData.add(resultSet.getBoolean("time_off_without_pay"));
                rowData.add(resultSet.getString("reason_for_request"));
                rowData.add(resultSet.getString("employee_signature"));
                rowData.add(resultSet.getDate("request_date"));
                rowData.add(resultSet.getString("status"));
            }
            resultSet.close();
            statement.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return rowData;
    }
    
    public Vector<Object> getExpenseRequestById(int requestId) 
    {
        Vector<Object> rowData = new Vector<>();

        try 
        {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM expense_request WHERE request_id = ?");
            statement.setInt(1, requestId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) 
            {
                rowData.add(resultSet.getInt("request_id"));
                rowData.add(resultSet.getString("name"));
                rowData.add(resultSet.getString("employeeId"));
                rowData.add(resultSet.getInt("email"));
                rowData.add(resultSet.getDate("reqDate"));
                rowData.add(resultSet.getString("projName"));
                rowData.add(resultSet.getString("department"));
                rowData.add(resultSet.getDate("reqEndDate"));
                rowData.add(resultSet.getString("amount"));
                rowData.add(resultSet.getString("notes"));
                rowData.add(resultSet.getBoolean("initiate"));
                rowData.add(resultSet.getBoolean("planning"));
                rowData.add(resultSet.getBoolean("execution"));
                rowData.add(resultSet.getBoolean("perform"));
                rowData.add(resultSet.getBoolean("closure"));
                rowData.add(resultSet.getString("summary"));
                rowData.add(resultSet.getString("status"));
            }
            resultSet.close();
            statement.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return rowData;
    }

    public boolean updateTimeOffRequestStatus(int requestId, String status) 
    {
        try 
        {
            String query = "UPDATE time_off_request SET status = ? WHERE request_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, status);
            statement.setInt(2, requestId);
        
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
    public boolean updateExpenseRequestStatus(int requestId, String status) 
    {
        try 
        {
            String query = "UPDATE expense_request SET status = ? WHERE request_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, status);
            statement.setInt(2, requestId);
        
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

