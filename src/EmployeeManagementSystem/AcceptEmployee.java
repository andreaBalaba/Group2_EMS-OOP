package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class AcceptEmployee extends JFrame{
    private JComboBox sAcc;
    
    
    public AcceptEmployee() {
        setTitle("Confirm Employment");
        setBounds(100, 100, 750, 550);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);

        String acc[] = {"Please select...","@hr.com", "@employee.com"};
        sAcc = new JComboBox(acc);
	sAcc.setFont(new Font("Open Sans", Font.PLAIN, 12));
	sAcc.setBounds(530, 300, 150, 28);
        sAcc.setBackground(Color.LIGHT_GRAY);
        sAcc.setFocusable(false);
        
        add(sAcc);
    }
}
