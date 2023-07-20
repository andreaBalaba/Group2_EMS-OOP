package EmployeeManagementSystem;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ManConfirmExp extends JFrame implements ActionListener
{
    private EMSdataAccess database = new EMSdataAccess();
    private JButton Approve, Deny, Back;
    private GetSetEmployee employee;
    private String updatedStatus;
    private JLabel title, name, empid, email, reqdate, projname, phase, phasedate, amount, notes, summary;
    private final JTextField tname, empidt, emailt, projnamet, amounts, rqdN, rqfN;
    private final JCheckBox phase1, phase2, phase3, phase4, phase5;
    private final JTextArea notess, tout;
    //private final JButton sub, reset, back;
    private final JLabel pol1, pol2;
    
   
    
    public ManConfirmExp(GetSetEmployee employee) 
    {
        this.employee = employee;
        
        setTitle("Employee Request Time Off");
        setBounds(100,100,750,550);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    
        JPanel con = new JPanel();
        con.setLayout(null);
        con.setPreferredSize(new Dimension(600,600));

        title = new JLabel("Employee Request Expenses");
		title.setFont(new Font("Mistral", Font.BOLD, 50));
		title.setBounds(140, 10, 500, 50);
		add(title);

		name = new JLabel("Name:");
		name.setFont(new Font("Open Sans", Font.PLAIN, 15));
		name.setBounds(10, 80, 50, 15);
		add(name);

		tname = new JTextField(employee.getName());
		tname.setFont(new Font("Open Sans", Font.PLAIN, 15));
		tname.setBounds(160, 80, 200, 20);
                tname.setEditable(false);
		add(tname);

		empid = new JLabel("Employee ID:");
		empid.setFont(new Font("Open Sans", Font.PLAIN, 15));
		empid.setBounds(10, 110, 100, 15);
		add(empid);

		empidt = new JTextField(employee.getEmployeeId());
		empidt.setFont(new Font("Open Sans", Font.PLAIN, 15));
		empidt.setBounds(160, 110, 200, 20);
                empidt.setEditable(false);
		add(empidt);

		email = new JLabel("Email:");
		email.setFont(new Font("Open Sans", Font.PLAIN, 15));
		email.setBounds(10, 140, 100, 15);
		add(email);
                
                emailt = new JTextField(employee.getEmail());
		emailt.setFont(new Font("Open Sans", Font.PLAIN, 15));
		emailt.setBounds(160, 140, 200, 20);
                emailt.setEditable(false);
		add(emailt);

		reqdate = new JLabel("Request Date:");
		reqdate.setFont(new Font("Arial", Font.PLAIN, 15));
		reqdate.setBounds(10, 170, 100, 15);
		add(reqdate);
                
                rqdN = new JTextField();
                rqdN.setFont(new Font("Open Sans", Font.PLAIN,13));
                rqdN.setText(employee.getdateRequest().toString());
                //employee.getdateRequest().getTime())
                rqdN.setEditable(false);
                rqdN.setBounds(160, 170, 200, 20);
                add(rqdN);
        
		projname = new JLabel("Project Name:");
		projname.setFont(new Font("Arial", Font.PLAIN, 15));
		projname.setBounds(10, 200, 100, 15);
		add(projname);
                                 
                projnamet = new JTextField(employee.getProjName());
		projnamet.setFont(new Font("Arial", Font.PLAIN, 15));
		projnamet.setBounds(160, 200, 200, 20);
                projname.setEnabled(false);
		add(projnamet);
                
                phase = new JLabel("What is the current phase of the project?");
                phase.setFont(new Font("Arial", Font.PLAIN, 15));
                phase.setBounds(10, 230, 300, 20);
                add(phase);
                
                phase1 = new JCheckBox("Initiation");
                phase1.setFont(new Font("Arial", Font.PLAIN, 12));
                phase1.setSelected(false);
                phase1.setBounds(10, 250, 100, 15);
                phase1.setSelected(employee.isInitiation());
                phase1.setEnabled(false);
                add(phase1);
                
                phase2 = new JCheckBox("Planning");
                phase2.setFont(new Font("Arial", Font.PLAIN, 12));
                phase2.setSelected(false);
                phase2.setBounds(10, 270, 100, 15);
                phase2.setSelected(employee.isPlanning());
                phase2.setEnabled(false);
                add(phase2);
                
                phase3 = new JCheckBox("Execution");
                phase3.setFont(new Font("Arial", Font.PLAIN, 12));
                phase3.setSelected(false);
                phase3.setBounds(10, 290, 100, 15);
                phase3.setSelected(employee.isExecution());
                phase3.setEnabled(false);
                add(phase3);
                
                phase4 = new JCheckBox("Performance/Monitoring");
                phase4.setFont(new Font("Arial", Font.PLAIN, 12));
                phase4.setSelected(false);
                phase4.setBounds(10, 310, 200, 15);
                phase4.setSelected(employee.isPerform());
                phase4.setEnabled(false);
                add(phase4);
                
                phase5 = new JCheckBox("Closure");
                phase5.setFont(new Font("Arial", Font.PLAIN, 12));
                phase5.setSelected(false);
                phase5.setBounds(10, 330, 100, 15);
                phase5.setSelected(employee.isClosure());
                phase5.setEnabled(false);
                add(phase5);
                
                phasedate = new JLabel("Phase End Date:");
		phasedate.setFont(new Font("Arial", Font.PLAIN, 15));
		phasedate.setBounds(10, 360, 200, 15);
		add(phasedate);
                
                rqfN = new JTextField();
                rqfN.setFont(new Font("Open Sans", Font.PLAIN,13));
                rqfN.setText(employee.getdateEnd().toString());
                rqfN.setEditable(false);
                rqfN.setBounds(160, 360, 200, 20);
                add(rqfN);

                amount = new JLabel("Amount:");
		amount.setFont(new Font("Arial", Font.PLAIN, 15));
		amount.setBounds(10, 390, 200, 15);
		add(amount);
                
                amounts = new JTextField();
		amounts.setFont(new Font("Arial", Font.PLAIN, 15));
		amounts.setBounds(160, 390, 200, 20);
                amounts.setText(employee.getAmount());
                amounts.setEditable(false);
		add(amounts);
                
                notes = new JLabel("Any notes:");
                notes.setFont(new Font("Arial", Font.PLAIN, 15));
                notes.setBounds(10, 420, 200, 20);
                add(notes);
                
                notess = new JTextArea();
                notess.setFont(new Font("Arial", Font.PLAIN, 12));
                notess.setBounds(160, 420, 200, 40);
                notess.setLineWrap(true);
                notess.setText(employee.getNotes());
                notess.setEditable(false);
                add(notess);
                
                summary = new JLabel("Summary:");
                summary.setFont(new Font("Arial", Font.PLAIN, 15));
                summary.setBounds(520, 60, 200, 20);
                add(summary);
                
                tout = new JTextArea();
                tout.setFont(new Font("Arial", Font.PLAIN, 15));
                tout.setBounds(400, 80, 300, 350);
                tout.setLineWrap(true);
                tout.setEditable(false);
                add(tout);
             
                pol1 = new JLabel("");
                pol1.setFont(new Font("Arial", Font.PLAIN, 15));
                pol1.setSize(400, 20);
                pol1.setLocation(240, 700);
                add(pol1);
                
                pol2 = new JLabel("");
                pol2.setFont(new Font("Arial", Font.PLAIN, 15));
                pol2.setSize(400, 20);
                pol2.setLocation(330, 500);
                add(pol2);
 
		
        
        Approve = new JButton("Approve");
        Approve.setFont(new Font("Open Sans", Font.BOLD, 12));
        Approve.setBounds(195, 540, 90, 30);
        Approve.setBackground(Color.GRAY);
        Approve.setForeground(Color.WHITE);
        Approve.setFocusable(false);
        Approve.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Approve.addActionListener(this);
        con.add(Approve);
        
        Deny = new JButton("Deny");
        Deny.setFont(new Font("Open Sans", Font.BOLD, 12));
        Deny.setBounds(315, 540, 90, 30);
        Deny.setBackground(Color.GRAY);
        Deny.setForeground(Color.WHITE);
        Deny.setFocusable(false);
        Deny.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Deny.addActionListener(this);
        con.add(Deny);
        
        Back = new JButton("Back");
        Back.setFont(new Font("Open Sans", Font.BOLD, 13));
        Back.setBounds(435, 540, 90, 30);
        Back.setBackground(Color.GRAY);
        Back.setForeground(Color.WHITE);
        Back.setFocusable(false);
        Back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Back.addActionListener(this);
        con.add(Back);
   
    }
    public String getUpdatedStatus() {
    return updatedStatus;
    }
    
    private void handleApproval() {
        try {
            employee.setStatus("Approved");
            updatedStatus = "Approved";
            database.updateExpenseRequestStatus(employee.getRequestId(), updatedStatus);
            JOptionPane.showMessageDialog(this, "Expense has been approved.", "Approval", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to update status: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleDenial() {
        try {
            employee.setStatus("Denied");
            updatedStatus = "Denied";
            database.updateExpenseRequestStatus(employee.getRequestId(), updatedStatus);
            JOptionPane.showMessageDialog(this, "Expense has been denied.", "Denied", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to update status: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {  if (e.getSource() == Approve) {
            handleApproval();
        } else if (e.getSource() == Deny) {
            handleDenial();
        } else if (e.getSource() == Back) {
            dispose();
            ManagerExpView mevw = new ManagerExpView();
            mevw.setVisible(true);
        }
    }
}
