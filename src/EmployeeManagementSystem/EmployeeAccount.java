package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmployeeAccount extends JPopupMenu implements ActionListener{
    
    private JMenuItem logOut;
    
    public EmployeeAccount() {
        
        logOut = new JMenuItem("Log Out");
        logOut.addActionListener(this);

        add(logOut);
        
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logOut) {
            
            JComponent invoker = (JComponent) getInvoker();
            Container topLevelContainer = invoker.getTopLevelAncestor();
            if (topLevelContainer instanceof EmployeePage) {
                ((EmployeePage) topLevelContainer).disposeFrame();
            }
            
            new WelcomePage();
            
        }

    }
    
}
