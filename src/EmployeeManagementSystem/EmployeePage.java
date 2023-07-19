package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class EmployeePage extends JFrame implements ActionListener{
    
    private JButton vprof, req, exps, refr, acc;
    private JLabel vwprof, vreq, vexps;
    
    public EmployeePage() {
        setTitle("EMPLOYEE");
        setBounds(100, 100, 750, 550);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        vprof = new JButton ( );
        vprof.setIcon(new ImageIcon(ClassLoader.getSystemResource("EmployeeManagementSystem/Icon/view profile.png")));
        vprof.setBounds(100, 150, 150, 150);
        vprof.setBackground(Color.white);
        vprof.addActionListener(this);
        add(vprof);
        
        req = new JButton ();
        req.setIcon(new ImageIcon(ClassLoader.getSystemResource("EmployeeManagementSystem/Icon/request.png")));
        req.setBounds(300, 150, 150, 150);
        req.setBackground(Color.white);
        req.addActionListener(this);
        add(req);

        exps = new JButton ();
        exps.setIcon(new ImageIcon(ClassLoader.getSystemResource("EmployeeManagementSystem/Icon/expenses.png")));
        exps.setBounds(500, 150, 150, 150);
        exps.setBackground(Color.white);
        exps.addActionListener(this);
        add(exps);
        
        vwprof = new JLabel ("VIEW PROFILE");
        vwprof.setFont(new Font("Mistral", Font.BOLD, 30));
        vwprof.setBounds(100, 300, 200, 30);
        add(vwprof);
        
        vreq = new JLabel ("REQUEST");
        vreq.setFont(new Font("Mistral", Font.BOLD, 30));
        vreq.setBounds(330, 300, 200, 30);
        add(vreq);
        
        vexps = new JLabel ("EXPENSES");
        vexps.setFont(new Font("Mistral", Font.BOLD, 30));
        vexps.setBounds(520, 300, 200, 30);
        add(vexps);
        
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
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vprof) {
            
        }
        else if (e.getSource() == req) {
            
        }
        else if (e.getSource() == exps) {
            new Expenses();
        }
        else if (e.getSource() == refr) {
            dispose();
            new EmployeePage();
        }
        else if (e.getSource() == acc) {
          
            EmployeeAccount empacc = new EmployeeAccount();
            empacc.show(acc, 0, acc.getHeight());
            
        }
    }
}
