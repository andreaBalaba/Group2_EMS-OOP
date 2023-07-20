package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ManagerAccount extends JPopupMenu implements ActionListener{
    
    private JMenuItem logOut, searchProf, perfor, perfor1;
    
    public ManagerAccount() {
        
        perfor = new JMenuItem("Performance");
        perfor.addActionListener(this);
        
        perfor1 = new JMenuItem("Rate");
        perfor1.addActionListener(this);
        
        
        searchProf = new JMenuItem("Search Profile");
        searchProf.addActionListener(this);
        
        logOut = new JMenuItem("Log Out");
        logOut.addActionListener(this);
        
        
        add(searchProf);
        add(perfor);
        add(perfor1);
        add(logOut);
        
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logOut) {
            
            JComponent invoker = (JComponent) getInvoker();
            Container topLevelContainer = invoker.getTopLevelAncestor();
            
             if (topLevelContainer instanceof ManagerPage) {
                ((ManagerPage) topLevelContainer).disposeFrame();
            }
            else if (topLevelContainer instanceof HrPage) {
                ((HrPage) topLevelContainer).disposeFrame();
            }
             else if (topLevelContainer instanceof ForHrEmployList) {
                ((ForHrEmployList) topLevelContainer).dispose();
            }
            
            new WelcomePage();
            
        }
        
        else if (e.getSource() == searchProf) {
            new SearchEmployee();
        }
        else if (e.getSource() == perfor) {
            new ManagerVUDReview();
        }
        else if (e.getSource() == perfor1) {
            new PerformanceReview();
        }
    }
}
