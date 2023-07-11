package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class HrPage extends JFrame implements ActionListener 
{
    private EMSdataAccess database = new EMSdataAccess();
    private JLabel titleLabel, welcomeLabel;
    private JTable employeeTable;
    private JScrollPane scrollPane;
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu1,menu2,menu3, menu4, menu5;
    
    public HrPage() 
    {
        setTitle("G2 Computer Services");
        setBounds(100, 100, 750, 550);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        titleLabel = new JLabel("Employee Management System");
        titleLabel.setFont(new Font("Open Sans", Font.BOLD, 25));
        titleLabel.setBounds(180, 30, 400, 35);
        
        welcomeLabel = new JLabel("Good Day!");
        welcomeLabel.setFont(new Font("Open Sans", Font.PLAIN, 16));
        welcomeLabel.setBounds(50, 80, 200, 30);

        employeeTable = new JTable();
        scrollPane = new JScrollPane(employeeTable);
        scrollPane.setBounds(50, 120, 640, 100);
        
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("EmployeeManagementSystem/Icon/ems.png"));
        Image Icon2 = icon2.getImage().getScaledInstance(640,450,Image.SCALE_DEFAULT);
        ImageIcon pic2 = new ImageIcon(Icon2);
        JLabel pics2 = new JLabel(pic2);
        pics2.setBounds(50, 225, 640, 450);
        
        menuBar.setBackground(Color.WHITE);
        
        menu1 = new JMenu("Profile");
        menu1.setFont(new Font("Open Sans", Font.PLAIN, 14));
        JMenuItem menuItem1 = new JMenuItem("Add New Employee Profile");
        JMenuItem menuItem2 = new JMenuItem("View Profile");
        menuItem1.setFont(new Font("Open Sans", Font.PLAIN, 12));
        menuItem2.setFont(new Font("Open Sans", Font.PLAIN, 12));
        menuItem1.addActionListener(this);
        menuItem2.addActionListener(this);
       
        menu2 = new JMenu("Manage");
        menu2.setFont(new Font("Open Sans", Font.PLAIN, 14));
        JMenuItem menuItem3 = new JMenuItem("Update Employee Details");
        JMenuItem menuItem4 = new JMenuItem("Delete Employee");
        menuItem3.setFont(new Font("Open Sans", Font.PLAIN, 12));
        menuItem4.setFont(new Font("Open Sans", Font.PLAIN, 12));
        menuItem3.addActionListener(this);
        menuItem4.addActionListener(this);
        
        menu3 = new JMenu("Request");
        menu3.setFont(new Font("Open Sans", Font.PLAIN, 14));
        JMenuItem menuItem5 = new JMenuItem("Time Off");
        JMenuItem menuItem6 = new JMenuItem("Expenses");
        menuItem5.setFont(new Font("Open Sans", Font.PLAIN, 12));
        menuItem6.setFont(new Font("Open Sans", Font.PLAIN, 12));
        menuItem5.addActionListener(this);
        menuItem6.addActionListener(this);
        
        menu4 = new JMenu("Review");
        menu4.setFont(new Font("Open Sans", Font.PLAIN, 14));
        JMenuItem menuItem7 = new JMenuItem("Performance Review Form");
        JMenuItem menuItem8 = new JMenuItem("View Reviews");
        menuItem7.setFont(new Font("Open Sans", Font.PLAIN, 12));
        menuItem8.setFont(new Font("Open Sans", Font.PLAIN, 12));
        menuItem7.addActionListener(this);
        menuItem8.addActionListener(this);
        
        menu5 = new JMenu("Exit");
        menu5.setFont(new Font("Open Sans", Font.PLAIN, 14));
        JMenuItem menuItem9 = new JMenuItem("Log Out");
        menuItem9.setFont(new Font("Open Sans", Font.PLAIN, 12));
        menuItem9.addActionListener(this);
        
        
        menu1.add(menuItem1);
        menu1.add(menuItem2);
        menu2.add(menuItem3);
        menu2.add(menuItem4);
        menu3.add(menuItem5);
        menu3.add(menuItem6);
        menu4.add(menuItem7);
        menu4.add(menuItem8);
        menu5.add(menuItem9);
        
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menuBar.add(menu4);
        menuBar.add(menu5);
        

        add(titleLabel);
        add(scrollPane);
        add(welcomeLabel);
        add(pics2);
        setJMenuBar(menuBar);

        setVisible(true);
        displayEmployeeList();
    }
    private void displayEmployeeList() 
    {
        DefaultTableModel model = database.getEmployeeTableModel();
        employeeTable.setModel(model);
    }
 @Override
    public void actionPerformed(ActionEvent e)
    {
     String comnd = e.getActionCommand();
        if (comnd.equals("Add New Employee Profile"))
        {   
            new AddEmployee();
        }
        else if (comnd.equals("View Profile"))
        {
            new SearchEmployee();
        }
        else if (comnd.equals("Update Employee Details"))
        {
            new UpdateEmployeeDetails();
            
        }
        else if (comnd.equals("Delete Employee"))
        {
            new DeleteEmployee();
        }
        else if (comnd.equals("Time Off"))
        {
            new TimeOff();
        }
        else if (comnd.equals("Expenses"))
        {
        
        }
        else if (comnd.equals("Performance Review Form"))
        {
            new PerformanceReview();
        }
        else if (comnd.equals("View Reviews"))
        {
            new HrViewReviews();
        }
        else if (comnd.equals("Log Out"))
        {
            dispose();
            SwingUtilities.invokeLater(new Runnable() 
            {
            @Override
                 public void run() 
                 {
                     new WelcomePage();
                }
            });
        }
     
    }
}
