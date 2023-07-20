package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class ManagerPage extends JFrame implements ActionListener{
    
    private JButton hrlist,emplist,reqlist, expe, refr, acc;
    private JLabel nhrlist, nemplist, nreqlist, nexpe ;
    
    public ManagerPage() {
        setTitle("MANAGER");
        setBounds(100, 100, 750, 550);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        hrlist = new JButton ( );
        hrlist.setIcon(new ImageIcon(ClassLoader.getSystemResource("EmployeeManagementSystem/Icon/hr list.png")));
        hrlist.setBounds(150, 100, 150, 150);
        hrlist.setBackground(Color.white);
        hrlist.addActionListener(this);
        add(hrlist);
        
        emplist = new JButton ();
        emplist.setIcon(new ImageIcon(ClassLoader.getSystemResource("EmployeeManagementSystem/Icon/update emp.png")));
        emplist.setBounds(440, 100, 150, 150);
        emplist.setBackground(Color.white);
        emplist.addActionListener(this);
        add(emplist);

        reqlist = new JButton ();
        reqlist.setIcon(new ImageIcon(ClassLoader.getSystemResource("EmployeeManagementSystem/Icon/request.png")));
        reqlist.setBounds(150, 300,150, 150);
        reqlist.setBackground(Color.white);
        reqlist.addActionListener(this);
        add(reqlist);
        
        expe = new JButton ();
        expe.setIcon(new ImageIcon(ClassLoader.getSystemResource("EmployeeManagementSystem/Icon/expenses.png")));
        expe.setBounds(440, 300,150, 150);
        expe.setBackground(Color.white);
        expe.addActionListener(this);
        add(expe);
        
        nhrlist = new JLabel ("EMPLOYEE LISTS");
        nhrlist.setFont(new Font("Open Sans", Font.BOLD, 20));
        nhrlist.setBounds(140, 250, 250, 20);
        add(nhrlist);
        
        nemplist = new JLabel ("UPDATE EMPLOYEE");
        nemplist.setFont(new Font("Open Sans", Font.BOLD, 20));
        nemplist.setBounds(425, 250, 250, 20);
        add(nemplist);
        
        nreqlist = new JLabel ("REQUEST LISTS");
        nreqlist.setFont(new Font("Open Sans", Font.BOLD, 20));
        nreqlist.setBounds(145, 450, 250, 20);
        add(nreqlist);
        
        nexpe = new JLabel ("EXPENSES");
        nexpe.setFont(new Font("Open Sans", Font.BOLD, 20));
        nexpe.setBounds(460, 450, 250, 20);
        add(nexpe);
        
	refr = new JButton("Refresh");
	refr.setFont(new Font("Open Sans", Font.BOLD, 15));
	refr.setBounds(10, 10, 100, 20);
        refr.setBackground(Color.DARK_GRAY);
        refr.setForeground(Color.WHITE);
        refr.setFocusable(false);
        refr.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        refr.addActionListener(this);
        add(refr);
        
        acc = new JButton("Account");
	acc.setFont(new Font("Open Sans", Font.BOLD, 15));
	acc.setBounds(620, 10, 100, 20);
        acc.setBackground(Color.DARK_GRAY);
        acc.setForeground(Color.WHITE);
        acc.setFocusable(false);
        acc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        acc.addActionListener(this);
        add(acc);
        
        validate();
        
    }
    
    public void disposeFrame() {
        dispose();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == hrlist) {
            dispose();
            new ForManagerHrLists();
        }
        else if (e.getSource() == emplist) {
            new ManUpdateEmployeeDetails();
        }
        else if (e.getSource() == reqlist) {
            dispose();
            new ManTimeOffRequestList();
        }
        else if(e.getSource() == expe) {
            dispose();
            new ManagerExpView();
        }
        else if (e.getSource() == refr) {
            dispose();
            new ManagerPage();
        }
        else if (e.getSource() == acc) {
          
            ManagerAccount macc = new ManagerAccount();
            macc.show(acc, 0, acc.getHeight());
            
        }
    }
}
