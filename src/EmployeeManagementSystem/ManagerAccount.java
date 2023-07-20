package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ManagerAccount extends JPopupMenu implements ActionListener{
    
    private JMenuItem logOut, searchProf, perfor;
    
    public ManagerAccount() {
        
        perfor = new JMenuItem("Performance");
        perfor.addActionListener(this);
        
        searchProf = new JMenuItem("Search Profile");
        searchProf.addActionListener(this);
        
        logOut = new JMenuItem("Log Out");
        logOut.addActionListener(this);
        
        add(searchProf);
        add(logOut);
        add(perfor);
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
            new PerformanceReview();
        }
    }
}
