package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class HrPage extends JFrame implements ActionListener{
    
    private JButton emplist,reqlist, expe, update, manage, prefrv, refr, acc;
    private JLabel nemplist, nreqlist, nexpe, nupd, nman, npref ;
    
    public HrPage() {
        setTitle("HR STAFF");
        setBounds(100, 100, 750, 550);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        emplist = new JButton ( );
        emplist.setIcon(new ImageIcon(ClassLoader.getSystemResource("EmployeeManagementSystem/Icon/employ list.png")));
        emplist.setBounds(100, 80, 150, 150);
        emplist.setFocusable(false);
        emplist.setBackground(Color.white);
        emplist.addActionListener(this);
        add(emplist);
        
        reqlist = new JButton ();
        reqlist.setIcon(new ImageIcon(ClassLoader.getSystemResource("EmployeeManagementSystem/Icon/request.png")));
        reqlist.setBounds(100, 280, 150, 150);
        reqlist.setFocusable(false);
        reqlist.setBackground(Color.white);
        reqlist.addActionListener(this);
        add(reqlist);
        
        update = new JButton ();
        update.setIcon(new ImageIcon(ClassLoader.getSystemResource("EmployeeManagementSystem/Icon/update emp.png")));
        update.setBounds(300, 80, 150, 150);
        update.setFocusable(false);
        update.setBackground(Color.white);
        update.addActionListener(this);
        add(update);
  
        expe = new JButton ();
        expe.setIcon(new ImageIcon(ClassLoader.getSystemResource("EmployeeManagementSystem/Icon/expenses.png")));
        expe.setBounds(300, 280,150, 150);
        expe.setFocusable(false);
        expe.setBackground(Color.white);
        expe.addActionListener(this);
        add(expe);
        
        manage = new JButton ();
        manage.setIcon(new ImageIcon(ClassLoader.getSystemResource("EmployeeManagementSystem/Icon/manage emp.png")));
        manage.setBounds(500, 80, 150, 150);
        manage.setFocusable(false);
        manage.setBackground(Color.white);
        manage.addActionListener(this);
        add(manage);
  
        prefrv = new JButton ();
        prefrv.setIcon(new ImageIcon(ClassLoader.getSystemResource("EmployeeManagementSystem/Icon/perfor rv.png")));
        prefrv.setBounds(500, 280,150, 150);
        prefrv.setFocusable(false);
        prefrv.setBackground(Color.white);
        prefrv.addActionListener(this);
        add(prefrv);
         
        nemplist = new JLabel ("EMPLOYEE LISTS");
        nemplist.setFont(new Font("Open Sans", Font.BOLD, 20));
        nemplist.setBounds(85, 230, 250, 20);
        add(nemplist);
        
        nreqlist = new JLabel ("REQUEST LISTS");
        nreqlist.setFont(new Font("Open Sans", Font.BOLD, 20));
        nreqlist.setBounds(100, 430, 250, 20);
        add(nreqlist);
        
        nupd = new JLabel ("UPDATE");
        nupd.setFont(new Font("Open Sans", Font.BOLD, 20));
        nupd.setBounds(335, 230, 250, 20);
        add(nupd);
        
        nexpe = new JLabel ("EXPENSES");
        nexpe.setFont(new Font("Open Sans", Font.BOLD, 20));
        nexpe.setBounds(325, 430, 250, 20);
        add(nexpe);
        
        nman = new JLabel ("MANAGE");
        nman.setFont(new Font("Open Sans", Font.BOLD, 20));
        nman.setBounds(530, 230, 250, 20);
        add(nman);
        
        npref = new JLabel ("PERFORMANCE");
        npref.setFont(new Font("Open Sans", Font.BOLD, 20));
        npref.setBounds(490, 430, 250, 20);
        add(npref);
        
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
        if (e.getSource() == emplist) {
            dispose();
            new ForHrEmployList();
        }
        else if (e.getSource() == reqlist) {
            dispose();
            HrTimeOffRequestList tor = new HrTimeOffRequestList();
            tor.setVisible(true);
        }
        else if (e.getSource() == expe) {
            dispose();
            new HrExpenses();
        }
        else if (e.getSource() == update) {
            new HrUpdateEmployeeDetails();
        }
        else if (e.getSource() == manage) {
            
            new HrManageEmp();
        }
        else if (e.getSource() == prefrv) {
            dispose();
            new PerformanceReview();
        }
        
        
        else if (e.getSource() == refr) {
            dispose();
            new HrPage();
        }
        else if (e.getSource() == acc) {
          
            HrAccount hrmacc = new HrAccount();
            hrmacc.show(acc, 0, acc.getHeight());
            
        }
    }
}
