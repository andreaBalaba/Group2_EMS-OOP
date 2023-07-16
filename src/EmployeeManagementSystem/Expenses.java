package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class Expenses extends JFrame implements ActionListener
{
       // private final Container c;
	private JLabel title, name, empid, email, reqdate, projname, phase, phasedate, expense, amount, notes;
	private final JTextField tname, empidt, emailt, projnamet, expenses, amounts;
        private final JRadioButton phase1, phase2, phase3, phase4, phase5;
        private final JTextArea notess, tout;
	private final JButton sub, reset;
        private final JLabel pol1, pol2;
        private JDateChooser rqD, rqF;
        
    public Expenses() 
    {
        setTitle("Employee Request Expenses");
	setBounds(100, 100, 750, 550);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
	setDefaultCloseOperation(EXIT_ON_CLOSE);

		title = new JLabel("Employee Request Expenses");
		title.setFont(new Font("Mistral", Font.BOLD, 50));
		title.setBounds(150, 10, 500, 50);
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

		projname = new JLabel("Project Name:");
		projname.setFont(new Font("Arial", Font.PLAIN, 15));
		projname.setBounds(10, 200, 100, 15);
		add(projname);
                                 
                projnamet = new JTextField();
		projnamet.setFont(new Font("Arial", Font.PLAIN, 15));
		projnamet.setBounds(160, 200, 200, 20);
		add(projnamet);
                
                phase = new JLabel("What is the current phase of the project?");
                phase.setFont(new Font("Arial", Font.PLAIN, 15));
                phase.setBounds(10, 230, 300, 20);
                add(phase);
                
                phase1 = new JRadioButton("Initiation");
                phase1.setFont(new Font("Arial", Font.PLAIN, 12));
                phase1.setSelected(false);
                phase1.setBounds(10, 250, 100, 15);
                add(phase1);
                
                phase2 = new JRadioButton("Planning");
                phase2.setFont(new Font("Arial", Font.PLAIN, 12));
                phase2.setSelected(false);
                phase2.setBounds(10, 270, 100, 15);
                add(phase2);
                
                phase3 = new JRadioButton("Execution");
                phase3.setFont(new Font("Arial", Font.PLAIN, 12));
                phase3.setSelected(false);
                phase3.setBounds(10, 290, 100, 15);
                add(phase3);
                
                phase4 = new JRadioButton("Performance/Monitoring");
                phase4.setFont(new Font("Arial", Font.PLAIN, 12));
                phase4.setSelected(false);
                phase4.setBounds(10, 310, 200, 15);
                add(phase4);
                
                phase5 = new JRadioButton("Closure");
                phase5.setFont(new Font("Arial", Font.PLAIN, 12));
                phase5.setSelected(false);
                phase5.setBounds(10, 330, 100, 15);
                add(phase5);
                
                phasedate = new JLabel("Phase End Date:");
		phasedate.setFont(new Font("Arial", Font.PLAIN, 15));
		phasedate.setBounds(10, 360, 200, 15);
		add(phasedate);
                
                rqF = new JDateChooser();
                rqF.setBounds(160, 360, 200, 20);
                rqF.setBackground(Color.DARK_GRAY);
                add(rqF);
                
                expense = new JLabel("What is the Expense:");
		expense.setFont(new Font("Arial", Font.PLAIN, 15));
		expense.setBounds(10, 390, 200, 15);
		add(expense);
                
                expenses = new JTextField();
		expenses.setFont(new Font("Arial", Font.PLAIN, 15));
		expenses.setBounds(160, 390, 200, 20);
		add(expenses);
                
                amount = new JLabel("Amount:");
		amount.setFont(new Font("Arial", Font.PLAIN, 15));
		amount.setBounds(10, 420, 200, 20);
		add(amount);
                
                amounts = new JTextField();
		amounts.setFont(new Font("Arial", Font.PLAIN, 15));
		amounts.setBounds(160, 420, 200, 20);
		add(amounts);
                
                notes = new JLabel("Any notes:");
                notes.setFont(new Font("Arial", Font.PLAIN, 15));
                notes.setBounds(500, 60, 100, 15);
                add(notes);
                
                notess = new JTextArea();
                notess.setFont(new Font("Arial", Font.PLAIN, 12));
                notess.setBounds(400, 80, 300, 200);
                notess.setLineWrap(true);
                add(notess);

		sub = new JButton("Submit");
		sub.setFont(new Font("Arial", Font.PLAIN, 15));
                sub.setBounds(250, 480, 100, 20);
		sub.addActionListener(this);
		add(sub);

		reset = new JButton("Reset");
		reset.setFont(new Font("Arial", Font.PLAIN, 15));
                reset.setBounds(400, 480, 100, 20);
		reset.addActionListener(this);
		add(reset);
                
                tout = new JTextArea();
                tout.setFont(new Font("Arial", Font.PLAIN, 15));
                tout.setBounds(400, 360, 300, 200);
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
			String data1 = null;
			String data
					= " Name : "
					+ tname.getText() + "\n"
					+ " Employee ID : " 
					+ empidt.getText() + "\n" 
                                        + " Email : "
                                        + emailt.getText() + "\n"
                                        + "Request Date MM-DD-YYY : "
                                        + rqD.getDate() + "\n"
                                        + "Project Name : "
                                        + projnamet.getText() + "\n"
                                        + "Phase End Date MM-DD-YYY"
                                        + rqF.getDate() + "\n"
                                        + expenses.getText() + "\n"
                                        + "Amount : "
                                        + amounts.getText() + "\n"
                                        + "Any notes"
                                        + notess.getText() + "\n";
                                   if (phase1.isSelected())
                                       data1 = " What is the current phase of the project? : Initiation";
                                   if (phase2.isSelected())
                                       data1 = "What is the current phase of the project? : Planing";
                                   if (phase3.isSelected())
                                       data1 = "What is the current phase of the project? : Execution";
                                   if (phase4.isSelected())
                                       data1 = "What is the current phase of the project? : Performance;Monitoring";
                                   if (phase5.isSelected())
                                       data1 = "What is the current phase of the project? : Closure";
                                   
				String data2 = "Reason for Request : " + projname.getText();
                                String data3 = null;
				tout.setText(data + data1 + data2 + data3);
				tout.setEditable(false);
				pol1.setText("Expense Requested Successfully..");
		}

		else if (e.getSource() == reset) {
			String def = "";
			tname.setText(def);
			empidt.setText(def);
                        emailt.setText(def);
                        rqD.setCalendar(null);
			projnamet.setText(def);
                        expenses.setText(def);
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
        
	}
    }

