package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class HrManageEmp extends JFrame implements ActionListener{
    
    private JButton addEmp, delEmp;
    
    public HrManageEmp(){
        setTitle("Manage Employee");
        setBounds(100, 100, 300, 200);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        
        addEmp = new JButton("Add Employee");
        addEmp.setFont(new Font("Open Sans", Font.BOLD, 15));
	addEmp.setBounds(45, 40, 200, 20);
        addEmp.setBackground(Color.GRAY);
        addEmp.setForeground(Color.WHITE);
        addEmp.setFocusable(false);
        addEmp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addEmp.addActionListener(this);
        
        delEmp = new JButton("Delete Employee");
        delEmp.setFont(new Font("Open Sans", Font.BOLD, 15));
	delEmp.setBounds(45, 90, 200, 20);
        delEmp.setBackground(Color.GRAY);
        delEmp.setForeground(Color.WHITE);
        delEmp.setFocusable(false);
        delEmp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        delEmp.addActionListener(this);
        
        add(addEmp);
        add(delEmp);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addEmp) {
            dispose();
            new AddEmployee();
        }
        else if (e.getSource() == delEmp) {
            dispose();
            new DeleteEmployee();
        }
    }
}
