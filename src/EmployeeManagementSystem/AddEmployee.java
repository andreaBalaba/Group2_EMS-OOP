package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.util.List;

public class AddEmployee extends JFrame implements ActionListener
{       
    private EMSdataAccess database = new EMSdataAccess();
    private JLabel addEmpHeader, newEmpName, newEmpAge, newEmpDoH, newEmpSalary, newEmpDep;
    private JLabel newEmpAddress, newEmppn, newEmpEmail, newEmpHE, newEmpID, newEmpPos, subResult;
    private JTextField tfname, tfage, tfSalary, tfAddress, tfpn, tfEmail, tfID, tfPos, tfDep;
    private JComboBox tfHE;
    private JButton SubmitButton, BackButton;
    private JDateChooser dcDoH;
    private List<String> existingEmployeeIds;
        
    public AddEmployee () 
    {
        setTitle("Add Employee");
        setBounds(100, 100, 750, 550);
        setLocationRelativeTo(null);
        setLayout(null);
        
        
        addEmpHeader = new JLabel("New Employee Details");
        addEmpHeader.setFont(new Font("Open Sans", Font.BOLD, 25));
        addEmpHeader.setBounds(250, 30, 500, 50);
        
        newEmpDep = new JLabel("Department:");
        newEmpDep.setFont(new Font("Open Sans", Font.PLAIN, 16));
        newEmpDep.setBounds(250, 90, 150, 30);
        
        tfDep = new JTextField();
	tfDep.setFont(new Font("Open Sans", Font.PLAIN, 12));
	tfDep.setBounds(360, 90, 150, 28);
        
        newEmpName = new JLabel("Name: ");
        newEmpName.setBounds(50, 147, 150, 30);
        newEmpName.setFont(new Font("Open Sans", Font.PLAIN, 16));
        
        tfname = new JTextField();
	tfname.setFont(new Font("Open Sans", Font.PLAIN, 12));
	tfname.setBounds(150, 150, 150, 28);
        
        newEmpAge = new JLabel("Age: ");
        newEmpAge.setBounds(370, 147, 150, 30);
        newEmpAge.setFont(new Font("Open Sans", Font.PLAIN, 16));
        
        tfage = new JTextField();
	tfage.setFont(new Font("Open Sans", Font.PLAIN, 12));
	tfage.setBounds(530, 150, 150, 28);
        
        newEmpDoH = new JLabel("Date of Hired: ");
        newEmpDoH.setBounds(50, 197, 150, 30);
        newEmpDoH.setFont(new Font("Open Sans", Font.PLAIN, 16));
        
        dcDoH = new JDateChooser();
        dcDoH.setBounds(150, 200, 150, 28);
        dcDoH.setBackground(Color.DARK_GRAY);
        
        newEmpEmail = new JLabel("Email: ");
        newEmpEmail.setBounds(370, 197, 150, 30);
        newEmpEmail.setFont(new Font("Open Sans", Font.PLAIN, 16));
        
        tfEmail = new JTextField();
	tfEmail.setFont(new Font("Open Sans", Font.PLAIN, 12));
	tfEmail.setBounds(530, 200, 150, 28);
        
        newEmpAddress = new JLabel("Address: ");
        newEmpAddress.setBounds(50, 247, 150, 30);
        newEmpAddress.setFont(new Font("Open Sans", Font.PLAIN, 16));
        
        tfAddress = new JTextField();
	tfAddress.setFont(new Font("Open Sans", Font.PLAIN, 12));
	tfAddress.setBounds(150, 250, 150, 28);
        
        newEmppn = new JLabel("Phone No.: ");
        newEmppn.setBounds(370, 247, 150, 30);
        newEmppn.setFont(new Font("Open Sans", Font.PLAIN, 16));
        
        tfpn = new JTextField();
	tfpn.setFont(new Font("Open Sans", Font.PLAIN, 12));
	tfpn.setBounds(530, 250, 150, 28);
        
        newEmpID = new JLabel("Employee ID: ");
        newEmpID.setBounds(50, 297, 150, 30);
        newEmpID.setFont(new Font("Open Sans", Font.PLAIN, 16));
        
        String newEmployeeId = database.getNextEmployeeId();
        tfID = new JTextField(newEmployeeId);
	tfID.setFont(new Font("Open Sans", Font.PLAIN, 12));
	tfID.setBounds(150, 300, 150, 28);
        tfID.setEditable(false);
        
        newEmpHE = new JLabel("Education Attainment: ");
        newEmpHE.setBounds(370, 297, 170, 30);
        newEmpHE.setFont(new Font("Open Sans", Font.PLAIN, 16));
        
        String eduAt[] = {"Please select...","Elementary", "High School Undergraduate", "High School Graduate", 
            "College Undergraduate","College Graduate", "Vocational Education"};
        tfHE = new JComboBox(eduAt);
	tfHE.setFont(new Font("Open Sans", Font.PLAIN, 12));
	tfHE.setBounds(530, 300, 150, 28);
        tfHE.setBackground(Color.LIGHT_GRAY);
        tfHE.setFocusable(false);

        newEmpPos = new JLabel("Position: ");
        newEmpPos.setBounds(50, 347, 150, 30);
        newEmpPos.setFont(new Font("Open Sans", Font.PLAIN, 16));
        
        tfPos = new JTextField();
	tfPos.setFont(new Font("Open Sans", Font.PLAIN, 12));
	tfPos.setBounds(150, 350, 150, 28);
        
        newEmpSalary = new JLabel("Salary: ");
        newEmpSalary.setBounds(370, 347, 150, 30);
        newEmpSalary.setFont(new Font("Open Sans", Font.PLAIN, 16));
        
        tfSalary = new JTextField();
	tfSalary.setFont(new Font("Open Sans", Font.PLAIN, 12));
	tfSalary.setBounds(530, 350, 150, 28);
        
        subResult = new JLabel("");
        subResult.setFont(new Font("Open Sans", Font.PLAIN, 15));
        subResult.setBounds(250, 377, 300, 40);
        subResult.setForeground(Color.LIGHT_GRAY);
        
        SubmitButton = new JButton("Submit");
	SubmitButton.setFont(new Font("Open Sans", Font.BOLD, 18));
	SubmitButton.setBounds(250, 425, 100, 40);
        SubmitButton.setBackground(Color.GRAY);
        SubmitButton.setForeground(Color.WHITE);
        SubmitButton.setFocusable(false);
        SubmitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        SubmitButton.addActionListener(this);
		
	BackButton = new JButton("Back");
	BackButton.setFont(new Font("Open Sans", Font.BOLD, 18));
	BackButton.setBounds(420, 425, 100, 40);
        BackButton.setBackground(Color.GRAY);
        BackButton.setForeground(Color.WHITE);
        BackButton.setFocusable(false);
        BackButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	BackButton.addActionListener(this);
        
        add(addEmpHeader);
        add(newEmpName);
        add(tfname);
        add(newEmpAge);
        add(tfage);
        add(newEmpDoH);
        add(dcDoH);
        add(newEmpSalary);
        add(tfSalary);
        add(newEmpAddress);
        add(tfAddress);
        add(newEmppn);
        add(tfpn);
        add(newEmpEmail);
        add(tfEmail);
        add(newEmpHE);
        add(tfHE);
        add(newEmpID);
        add(tfID);
        add(newEmpPos);
        add(tfPos);
        add(subResult);
        add(SubmitButton);
        add(BackButton);
        add(newEmpDep);
        add(tfDep);
        
        setVisible(true);
        
        existingEmployeeIds = database.retrieveExistingEmployeeIds();
        
    }

   
  @Override
    public void actionPerformed(ActionEvent e)
    {
     
     if (e.getSource() == SubmitButton) 
     { 
        String name = tfname.getText();
        int age = Integer.parseInt(tfage.getText());
        Date dateOfHired = dcDoH.getDate();
        String email = tfEmail.getText();
        String address = tfAddress.getText();
        String phone = tfpn.getText();
        String employeeId = tfID.getText();
        String education = (String) tfHE.getSelectedItem();
        String position = tfPos.getText();
        int salary = Integer.parseInt(tfSalary.getText());
        String department = tfDep.getText();

        Employee employee = new Employee(name, age, dateOfHired, email, address, phone, employeeId, education, position, salary, department);

        boolean success = database.addEmployee(employee);

        if (success)
        {
            subResult.setText("New Employee is successfully added!");
        } 
        else 
        {
            subResult.setText("Sorry, failed to add new employee.");
            
        }
    } 
    else if (e.getSource() == BackButton) 
    {
        dispose();
    }
 }   

    
}
