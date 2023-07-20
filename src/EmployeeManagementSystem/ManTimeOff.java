package EmployeeManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ManTimeOff extends JFrame implements ActionListener
{
    private EMSdataAccess database = new EMSdataAccess();
    private JLabel Title, EMPINFOTitle, Name, DPT, Man, DAF, to, TAR, RFTR, IRAE, ES, Date, employid, ToH;
    private JTextField NameLABEL, DPTLABEL, ManLABEL, DAFLABEL, toLABEL, TARLABEL, ESLABEL, DateLABEL, employidtf, ToHtf;
    private JCheckBox VCN, ML, JD, PL, FR, TV, BMT, TOWP;
    private JTextArea RFTRAREA;
    private JButton Approve, Deny, Back;
    private JScrollPane scrollPane;
    private GetSetEmployee employee;
    private String updatedStatus;
   
    
    public ManTimeOff(GetSetEmployee employee) 
    {
        this.employee = employee;
        
        
        setTitle("Employee Request Time Off");
        setBounds(100,100,750,550);
        setLocationRelativeTo(null);
        setResizable(false);
    
        JPanel con = new JPanel();
        con.setLayout(null);
        con.setPreferredSize(new Dimension(600,600));
        
        scrollPane = new JScrollPane(con);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(600,400));        
        getContentPane().add(scrollPane);
    
        Title = new JLabel();
        Title.setText("EMPLOYEE TIME OFF REQUEST FORM");
        Title.setFont(new Font("Open Sans",Font.BOLD,23));
        Title.setBounds(150,20,500,30);
        con.add(Title);
    
        EMPINFOTitle = new JLabel();
        EMPINFOTitle.setText("EMPLOYEE INFORMATION");
        EMPINFOTitle.setFont(new Font("Open Sans",Font.BOLD,14));
        EMPINFOTitle.setBounds(50,80,500,30);
        con.add(EMPINFOTitle);
   
        Name = new JLabel();
        Name.setText("Name: ");
        Name.setFont(new Font("Open Sans", Font.PLAIN,13));
        Name.setBounds(50,115,170,30);
        con.add(Name);
   
        NameLABEL = new JTextField(employee.getName());
        NameLABEL.setFont(new Font("Open Sans", Font.PLAIN,13));
        NameLABEL.setBounds(100,120,250,20);
        NameLABEL.setEditable(false);
        con.add(NameLABEL);
   
        DPT = new JLabel();
        DPT.setText("Department: ");
        DPT.setFont(new Font("Open Sans", Font.PLAIN,13));
        DPT.setBounds(50,175,520,30);
        con.add(DPT);
   
   
        DPTLABEL = new JTextField(employee.getDepartment());
        DPTLABEL.setFont(new Font("Open Sans", Font.PLAIN,13));
        DPTLABEL.setBounds(135,180,215,20);
        DPTLABEL.setEditable(false);
        con.add(DPTLABEL);
   
        Man = new JLabel();
        Man.setText("Manager: ");
        Man.setFont(new Font("Open Sans", Font.PLAIN,13));
        Man.setBounds(50,205,520,30);
        con.add(Man);
   
        ManLABEL = new JTextField(employee.getManager());
        ManLABEL.setFont(new Font("Open Sans", Font.PLAIN,13));
        ManLABEL.setBounds(120,210,230,20);
        ManLABEL.setEditable(false);
        con.add(ManLABEL);
        
        employid = new JLabel();
        employid.setText("Employee ID:");
        employid.setFont(new Font("Open Sans", Font.PLAIN,13));
        employid.setBounds(50,145,520,30);
        con.add(employid);
   
        employidtf = new JTextField(employee.getEmployeeId());
        employidtf.setFont(new Font("Open Sans", Font.PLAIN,13));
        employidtf.setBounds(140,150,210,20);
        employidtf.setEditable(false);
        con.add(employidtf);
        
        ToH = new JLabel();
        ToH.setText("Total of Hours: ");
        ToH.setFont(new Font("Open Sans", Font.PLAIN,13));
        ToH.setBounds(425,115,170,30);
        con.add(ToH);
   
        ToHtf = new JTextField();
        ToHtf.setFont(new Font("Open Sans", Font.PLAIN,13));
        ToHtf.setText(String.valueOf(employee.getTotalHours()));
        ToHtf.setBounds(520,120,100,20);
        ToHtf.setEditable(false);
        con.add(ToHtf); 
   
        JLabel DA = new JLabel();
        DA.setText("DATE OF ABSENCE");
        DA.setFont(new Font("Open Sans", Font.BOLD,13));
        DA.setBounds(425,145,520,30);
        con.add(DA);
        
        DAF = new JLabel();
        DAF.setText("From:");
        DAF.setFont(new Font("Open Sans", Font.PLAIN,13));
        DAF.setBounds(425,175,520,30);
        con.add(DAF);
   
        DAFLABEL = new JTextField();
        DAFLABEL.setFont(new Font("Open Sans", Font.PLAIN,13));
        DAFLABEL.setText(employee.getDateOfAbsenceFrom().toString());
        DAFLABEL.setEditable(false);
        DAFLABEL.setBounds(475,180,200,20);
        con.add(DAFLABEL);
   
        to = new JLabel();
        to.setText("To: ");
        to.setFont(new Font("Open Sans", Font.PLAIN,13));
        to.setBounds(425,205,90,30);
        con.add(to);
   
        toLABEL = new JTextField();
        toLABEL.setFont(new Font("Open Sans", Font.PLAIN,13));
        toLABEL.setText(employee.getDateOfAbsenceTo().toString());
        toLABEL.setBounds(460,210,215,20);
        toLABEL.setEditable(false);
        con.add(toLABEL);
   
        TAR = new JLabel();
        TAR.setText("TYPE OF ABSENCE");
        TAR.setFont(new Font("Open Sans",Font.BOLD,14));
        TAR.setBounds(50,245,500,30);
        con.add(TAR);
   
        VCN = new JCheckBox("Vacation");
        VCN.setBounds(50,275,150,30);
        VCN.setFont(new Font("Open Sans",Font.PLAIN,13));
        VCN.setSelected(employee.isVacation());
        VCN.setEnabled(false);
        con.add(VCN);
   
        ML = new JCheckBox("Medical Leave");
        ML.setBounds(50,300,150,30);
        ML.setFont(new Font("Open Sans",Font.PLAIN,13));
        ML.setSelected(employee.isMedicalLeave());
        ML.setEnabled(false);
        con.add(ML);
  
        JD = new JCheckBox("Jury Duty");
        JD.setBounds(50,325,150,30);
        JD.setFont(new Font("Open Sans",Font.PLAIN,13));
        JD.setSelected(employee.isJuryDuty());
        JD.setEnabled(false);
        con.add(JD);
          
        PL = new JCheckBox("Personal Leave");
        PL.setBounds(240,275,150,30);
        PL.setFont(new Font("Open Sans",Font.PLAIN,13));
        PL.setSelected(employee.isPersonalLeave());
        PL.setEnabled(false);
        con.add(PL); 
  
        FR = new JCheckBox("Family Reasons");
        FR.setBounds(240,300,150,30);
        FR.setFont(new Font("Open Sans",Font.PLAIN,13));
        FR.setSelected(employee.isFamilyReasons());
        FR.setEnabled(false);
        con.add(FR);    

        TV = new JCheckBox("To Vote");
        TV.setBounds(240,325,150,30);
        TV.setFont(new Font("Open Sans",Font.PLAIN,13));
        TV.setSelected(employee.isToVote());
        TV.setEnabled(false);
        con.add(TV); 
          
        BMT = new JCheckBox("Bereavement");
        BMT.setBounds(440,275,150,30);
        BMT.setFont(new Font("Open Sans",Font.PLAIN,13));
        BMT.setSelected(employee.isBereavement());
        BMT.setEnabled(false);
        con.add(BMT); 
  
        TOWP = new JCheckBox("Time off Without Pay");
        TOWP.setBounds(440,300,180,30);
        TOWP.setFont(new Font("Open Sans",Font.PLAIN,13));
        TOWP.setSelected(employee.isTimeOffWithoutPay());
        TOWP.setEnabled(false);
        con.add(TOWP);  
  
  
        RFTR = new JLabel();
        RFTR.setText("REASON FOR THE TIME OFF REQUEST  ");
        RFTR.setFont(new Font("Open Sans",Font.BOLD,14));
        RFTR.setBounds(50,360,500,30);
        con.add(RFTR);
  
        RFTRAREA = new JTextArea();
        RFTRAREA.setBounds(50,390,620,60);
        RFTRAREA.setFont(new Font("Open Sans",Font.PLAIN,13));
        RFTRAREA.setText(employee.getReasonForRequest());
        RFTRAREA.setEditable(false);
        RFTRAREA.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        con.add(RFTRAREA);
  
        IRAE = new JLabel();
        IRAE.setText("I understand that this request is subject to approval by my manager. ");
        IRAE.setFont(new Font("Open Sans",Font.ITALIC,11));
        IRAE.setBounds(50,450,500,30);
        con.add(IRAE);
   
        ES = new JLabel();
        ES.setText("Employee signature ");
        ES.setFont(new Font("Open Sans",Font.BOLD,13));
        ES.setBounds(50,476,500,30);
        con.add(ES);
   
        ESLABEL = new JTextField();
        ESLABEL.setFont(new Font("Open Sans", Font.PLAIN,13));
        ESLABEL.setText(employee.getEmployeeSignature());
        ESLABEL.setEditable(false);
        ESLABEL.setBounds(190,481,195,20);
        con.add(ESLABEL);
   
        Date = new JLabel();
        Date.setText("Date ");
        Date.setFont(new Font("Open Sans", Font.BOLD,13));
        Date.setBounds(430,475,520,30);
        con.add(Date);
   
        DateLABEL = new JTextField();
        DateLABEL.setFont(new Font("Open Sans", Font.PLAIN,13));
        DateLABEL.setText(employee.getRequestDate().toString());
        DateLABEL.setEditable(false);
        DateLABEL.setBounds(480,480,195,20);
        con.add(DateLABEL);
        
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
            database.updateTimeOffRequestStatus(employee.getRequestId(), updatedStatus);
            JOptionPane.showMessageDialog(this, "Time Off request approved.", "Approval", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to update status: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleDenial() {
        try {
            employee.setStatus("Denied");
            updatedStatus = "Denied";
            database.updateTimeOffRequestStatus(employee.getRequestId(), updatedStatus);
            JOptionPane.showMessageDialog(this, "Time Off request denied.", "Denied", JOptionPane.INFORMATION_MESSAGE);
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
            ManTimeOffRequestList timeOffRequestList = new ManTimeOffRequestList();
            timeOffRequestList.setVisible(true);
        }
    }
}
