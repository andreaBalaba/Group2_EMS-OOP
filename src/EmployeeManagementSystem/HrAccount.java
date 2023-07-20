package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HrAccount extends JPopupMenu implements ActionListener{
    
    private JMenuItem logOut, searchProf, timeoff;
    
    public HrAccount() {
        searchProf = new JMenuItem("Search Profile");
        searchProf.addActionListener(this);
        
        logOut = new JMenuItem("Log Out");
        logOut.addActionListener(this);
        
        timeoff = new JMenuItem("Time Off");
        timeoff.addActionListener(this);
        
        
        add(searchProf);
        add(logOut);
        add(timeoff);
        
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
        
        else if (e.getSource() == timeoff) {
            new ChooseEmpId();
        }
    }
}
