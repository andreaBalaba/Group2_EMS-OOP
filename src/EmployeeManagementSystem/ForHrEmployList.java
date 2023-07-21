package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class ForHrEmployList extends JFrame implements ActionListener {
    
    private EMSdataAccess database = new EMSdataAccess();
    private JTable employeeTable;
    private JScrollPane scrollPane;
    private JButton back, refr, acc;
    
    public ForHrEmployList ()
    {
        setTitle("EMPLOYEE");
        setBounds(100, 100, 750, 550);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        employeeTable = new JTable();
        scrollPane = new JScrollPane(employeeTable);
        scrollPane.setBounds(50, 120, 640, 100);        
        
        refr = new JButton("Refresh");
	refr.setFont(new Font("Open Sans", Font.BOLD, 15));
	refr.setBounds(150, 10, 100, 20);
        refr.setBackground(Color.DARK_GRAY);
        refr.setForeground(Color.WHITE);
        refr.setFocusable(false);
        refr.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        refr.addActionListener(this);
        add(refr);
        
        back = new JButton("Back");
	back.setFont(new Font("Open Sans", Font.BOLD, 15));
	back.setBounds(10, 10, 100, 20);
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        back.setFocusable(false);
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        back.addActionListener(this);
        add(back);
        
        acc = new JButton("Account");
	acc.setFont(new Font("Open Sans", Font.BOLD, 15));
	acc.setBounds(620, 10, 100, 20);
        acc.setBackground(Color.DARK_GRAY);
        acc.setForeground(Color.WHITE);
        acc.setFocusable(false);
        acc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        acc.addActionListener(this);
        add(acc);
        
        add(scrollPane);
        
        displayEmployeeList();
        
        
        
        
    }   
    
    private void displayEmployeeList() 
    {
        DefaultTableModel model = database.getEmployeeTableModel();
        employeeTable.setModel(model);
        employeeTable.setEnabled(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if (e.getSource() == refr) {
            dispose();
            //new HrLists();
        }
        else if (e.getSource() == acc) {
          
            HrAccount hracc = new HrAccount();
            hracc.show(acc, 0, acc.getHeight());
            
        }
        else if (e.getSource() == back) {

                dispose();
                new HrPage();
            
            
        }
    }
}
