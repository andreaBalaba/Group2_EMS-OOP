package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.util.Date;

public class EmpExpenses extends JFrame implements ActionListener
{       private EMSdataAccess database = new EMSdataAccess();
	private JLabel title, name, empid, email, reqdate, projname, phase, phasedate, amount, notes, summary, dept;
	private final JTextField tname, empidt, emailt, projnamet, amounts, deptField;
        private final JCheckBox phase1, phase2, phase3, phase4, phase5;
        private final JTextArea notess, tout;
	private final JButton sub, reset, back;
        private final JLabel pol1, pol2;
        private JDateChooser rqD, rqF;
        
    public EmpExpenses() 
    {
        setTitle("Employee Request Expenses");
	setBounds(100, 100, 750, 550);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

		title = new JLabel("Employee Request Expenses Form");
		title.setFont(new Font("Mistral", Font.BOLD, 50));
		title.setBounds(140, 10, 500, 50);
		add(title);

		name = new JLabel("Name:");
		name.setFont(new Font("Open Sans", Font.PLAIN, 15));
		name.setBounds(10, 80, 50, 15);
		add(name);

		tname = new JTextField();
		tname.setFont(new Font("Open Sans", Font.PLAIN, 15));
		tname.setBounds(160, 80, 200, 20);
		add(tname);

		empid = new JLabel("Employee ID:");
		empid.setFont(new Font("Open Sans", Font.PLAIN, 15));
		empid.setBounds(10, 110, 100, 15);
		add(empid);

		empidt = new JTextField();
		empidt.setFont(new Font("Open Sans", Font.PLAIN, 15));
		empidt.setBounds(160, 110, 200, 20);
		add(empidt);

		email = new JLabel("Email:");
		email.setFont(new Font("Open Sans", Font.PLAIN, 15));
		email.setBounds(10, 140, 100, 15);
		add(email);
                
                emailt = new JTextField();
		emailt.setFont(new Font("Open Sans", Font.PLAIN, 15));
		emailt.setBounds(160, 140, 200, 20);
		add(emailt);

		reqdate = new JLabel("Request Date:");
		reqdate.setFont(new Font("Arial", Font.PLAIN, 15));
		reqdate.setBounds(10, 170, 100, 15);
		add(reqdate);
                
                rqD = new JDateChooser();
                rqD.setBounds(160, 170, 200, 20);
                rqD.setBackground(Color.DARK_GRAY);
                add(rqD);
                
                dept = new JLabel("Department:");
		dept.setFont(new Font("230", Font.PLAIN, 15));
		dept.setBounds(10, 200, 100, 15);
		add(dept);
                                 
                deptField = new JTextField();
		deptField.setFont(new Font("Arial", Font.PLAIN, 15));
		deptField.setBounds(160, 200, 200, 20);
		add(deptField);

		projname = new JLabel("Project Name:");
		projname.setFont(new Font("Arial", Font.PLAIN, 15));
		projname.setBounds(10, 240, 100, 15);
		add(projname);
                                 
                projnamet = new JTextField();
		projnamet.setFont(new Font("Arial", Font.PLAIN, 15));
		projnamet.setBounds(160, 240, 200, 20);
		add(projnamet);
                
                phase = new JLabel("What is the current phase of the project?");
                phase.setFont(new Font("Arial", Font.PLAIN, 15));
                phase.setBounds(10, 270, 300, 20);
                add(phase);
                
                phase1 = new JCheckBox("Initiation");
                phase1.setFont(new Font("Arial", Font.PLAIN, 12));
                phase1.setSelected(false);
                phase1.setBounds(10, 290, 100, 15);
                add(phase1);
                
                phase2 = new JCheckBox("Planning");
                phase2.setFont(new Font("Arial", Font.PLAIN, 12));
                phase2.setSelected(false);
                phase2.setBounds(10, 310, 100, 15);
                add(phase2);
                
                phase3 = new JCheckBox("Execution");
                phase3.setFont(new Font("Arial", Font.PLAIN, 12));
                phase3.setSelected(false);
                phase3.setBounds(10, 330, 100, 15);
                add(phase3);
                
                phase4 = new JCheckBox("Performance/Monitoring");
                phase4.setFont(new Font("Arial", Font.PLAIN, 12));
                phase4.setSelected(false);
                phase4.setBounds(10, 350, 200, 15);
                add(phase4);
                
                phase5 = new JCheckBox("Closure");
                phase5.setFont(new Font("Arial", Font.PLAIN, 12));
                phase5.setSelected(false);
                phase5.setBounds(10, 370, 100, 15);
                add(phase5);
                
                phasedate = new JLabel("Phase End Date:");
		phasedate.setFont(new Font("Arial", Font.PLAIN, 15));
		phasedate.setBounds(10, 390, 200, 15);
		add(phasedate);
                
                rqF = new JDateChooser();
                rqF.setBounds(160, 390, 200, 20);
                rqF.setBackground(Color.DARK_GRAY);
                add(rqF);

                amount = new JLabel("Amount:");
		amount.setFont(new Font("Arial", Font.PLAIN, 15));
		amount.setBounds(10, 420, 200, 15);
		add(amount);
                
                amounts = new JTextField();
		amounts.setFont(new Font("Arial", Font.PLAIN, 15));
		amounts.setBounds(160, 420, 200, 20);
		add(amounts);
                
                notes = new JLabel("Any notes:");
                notes.setFont(new Font("Arial", Font.PLAIN, 15));
                notes.setBounds(10, 450, 200, 20);
                add(notes);
                
                notess = new JTextArea();
                notess.setFont(new Font("Arial", Font.PLAIN, 12));
                notess.setBounds(160, 450, 200, 20);
                notess.setLineWrap(true);
                add(notess);

		sub = new JButton("Submit");
		sub.setFont(new Font("Arial", Font.PLAIN, 15));
                sub.setBounds(300, 480, 100, 20);
		sub.addActionListener(this);
		add(sub);

		reset = new JButton("Reset");
		reset.setFont(new Font("Arial", Font.PLAIN, 15));
                reset.setBounds(450, 480, 100, 20);
		reset.addActionListener(this);
		add(reset);
                
                back = new JButton("Back");
		back.setFont(new Font("Arial", Font.PLAIN, 15));
                back.setBounds(150, 480, 100, 20);
		back.addActionListener(this);
		add(back);
                
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
 
		setVisible(true);
	}


        @Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == sub) {
			String data1 = null + "\n";
			String data     = "Name: " + tname.getText() + "\n"
					+ "Employee ID: " + empidt.getText() + "\n" 
                                        + "Email: " + emailt.getText() + "\n"
                                        + "Request Date: " + rqD.getDate() + "\n"
                                        + "Department: " + deptField.getText() + "\n"
                                        + "Project Name: " + projnamet.getText() + "\n"
                                        + "Phase End Date: " + rqF.getDate() + "\n"
                                        + "Amount: " + amounts.getText() + "\n"
                                        + "Any notes: " + notess.getText() + "\n";
                                   if (phase1.isSelected())
                                       data1 = "Current phase of the project: Initiation"+ "\n";
                                   if (phase2.isSelected())
                                       data1 = "Current phase of the project: Planing"+ "\n";
                                   if (phase3.isSelected())
                                       data1 = "Current phase of the project: Execution"+ "\n";
                                   if (phase4.isSelected())
                                       data1 = "Current phase of the project: Performance;Monitoring"+ "\n";
                                   if (phase5.isSelected())
                                       data1 = "Current phase of the project: Closure"+ "\n";
                                   
				String data2 = "Reason for Request: " + projnamet.getText() + "\n";
				tout.setText(data + data1 + data2);
				tout.setEditable(false);
				pol1.setText("Expense Requested Successfully..");
                                
                    boolean initiate = phase1.isSelected();
                    boolean planning = phase2.isSelected();
                    boolean execution = phase3.isSelected();
                    boolean perform = phase4.isSelected();
                    boolean closure = phase5.isSelected();
                    
                    if(initiate) {phase1.getText();} 
                    if(planning) {phase2.getText();}
                    if(execution) {phase3.getText();}
                    if(perform) {phase4.getText();}
                    if(closure) {phase5.getText();}                   
                    
                    String name = tname.getText();
                    String employeeId = empidt.getText();
                    String email = emailt.getText();
                    Date dateRequest = rqD.getDate(); 
                    String department = deptField.getText();
                    String projname = projnamet.getText();
                    Date dateEnd = rqF.getDate();
                    String amount = amounts.getText();
                    String anyNotes = notess.getText();
                    String summary = tout.getText();
                    
                    GetSetEmployee employee = new GetSetEmployee( name,  employeeId, email,  dateRequest, department,  projname,  dateEnd,  amount,  anyNotes,  initiate,  planning,  execution,  perform, closure, summary);
                   
                    boolean success = database.addExpense(employee); 

        if (success)
        {
           
            JOptionPane.showMessageDialog(this, "Submitted successfully");
            dispose();
            
        } 
        else 
        {
            JOptionPane.showMessageDialog(this, "Sorry, failed to submit request. Please try again.");
            
        }
                
		}

		else if (e.getSource() == reset) {
			String def = "";
			tname.setText(def);
			empidt.setText(def);
                        emailt.setText(def);
                        rqD.setCalendar(null);
			projnamet.setText(def);
                        amounts.setText(def);
                        notess.setText(def);
			tout.setText(def);
			rqF.setCalendar(null);
                        phase1.setSelected(false);
                        phase2.setSelected(false);
                        phase3.setSelected(false);
                        phase4.setSelected(false);
                        phase5.setSelected(false);
		}
                
                else if (e.getSource() == back) {
                    dispose();
                    new EmployeePage();
                }
        
	}
    }

