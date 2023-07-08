package EmployeeManagementSystem;

import java.awt.*;
import javax.swing.*;

public class TimeOff extends JFrame
{
    private JLabel Title, EMPINFOTitle, Name, DPT, TOR, DAF, to, TAR, RFTR, IRAE, ES, Date;
    private JTextField NameLABEL, DPTLABEL, TORLABEL, DAFLABEL, toLABEL, TARLABEL, ESLABEL, DateLABEL;
    private JCheckBox VCN, ML, JD, PL, FR, TV, BMT, TOWP;
    private JTextArea RFTRAREA;        
    
    public TimeOff() 
    {
        setTitle("Employee Request Time Off Page");
        setBounds(100,100,750,550);
        setLocationRelativeTo(null);
        setResizable(true);
    
        JPanel con = new JPanel();
        con.setLayout(null);
    
        Title = new JLabel();
        Title.setText("EMPLOYEE TIME OFF REQUEST FORM");
        Title.setFont(new Font("Times new Roman",Font.BOLD,23));
        Title.setBounds(150,20,500,30);
        con.add(Title);
    
    
        EMPINFOTitle = new JLabel();
        EMPINFOTitle.setText("EMPLOYEE INFORMATION");
        EMPINFOTitle.setFont(new Font("Times new Roman",Font.BOLD,13));
        EMPINFOTitle.setBounds(10,80,500,30);
        con.add(EMPINFOTitle);
   
        Name = new JLabel();
        Name.setText("Name: ");
        Name.setFont(new Font("Times new Roman", Font.BOLD,13));
        Name.setBounds(10,130,500,30);
        con.add(Name);
   
        NameLABEL = new JTextField();
        NameLABEL.setFont(new Font("Times new Roman", Font.BOLD,13));
        NameLABEL.setBounds(50,135,280,20);
        con.add(NameLABEL);
   
        DPT = new JLabel();
        DPT.setText("Department: ");
        DPT.setFont(new Font("Times new Roman", Font.BOLD,13));
        DPT.setBounds(10,155,520,30);
        con.add(DPT);
   
   
        DPTLABEL = new JTextField();
        DPTLABEL.setFont(new Font("Times new Roman", Font.BOLD,13));
        DPTLABEL.setBounds(90,160,240,20);
        con.add(DPTLABEL);
   
        TOR = new JLabel();
        TOR.setText("Time off request: ");
        TOR.setFont(new Font("Times new Roman", Font.BOLD,13));
        TOR.setBounds(10,180,520,30);
        con.add(TOR);
   
        TORLABEL = new JTextField();
        TORLABEL.setText("(E.g. 3 days or 3 hours)");
        TORLABEL.setFont(new Font("Times new Roman", Font.BOLD,13));
        TORLABEL.setBounds(110,185,220,20);
        con.add(TORLABEL);
   
        DAF = new JLabel();
        DAF.setText("Date of absence From: ");
        DAF.setFont(new Font("Times new Roman", Font.BOLD,13));
        DAF.setBounds(10,205,520,30);
        con.add(DAF);
   
        DAFLABEL = new JTextField();
        DAFLABEL.setFont(new Font("Times new Roman", Font.BOLD,13));
        DAFLABEL.setBounds(135,210,195,20);
        con.add(DAFLABEL);
   
        to = new JLabel();
        to.setText("To: ");
        to.setFont(new Font("Times new Roman", Font.BOLD,13));
        to.setBounds(400,205,520,30);
        con.add(to);
   
        toLABEL = new JTextField();
        toLABEL.setFont(new Font("Times new Roman", Font.BOLD,13));
        toLABEL.setBounds(420,210,195,20);
        con.add(toLABEL);
   
   
        TAR = new JLabel();
        TAR.setText("TYPE OF ABSENCE FORM");
        TAR.setFont(new Font("Times new Roman",Font.BOLD,13));
        TAR.setBounds(10,250,500,30);
        con.add(TAR);
   
        VCN = new JCheckBox("Vacation");
        VCN.setBounds(10,275,150,30);
        con.add(VCN);
   
        ML = new JCheckBox("Medical Leave");
        ML.setBounds(10,300,150,30);
        con.add(ML);
  
        JD = new JCheckBox("Jury Duty");
        JD.setBounds(10,325,150,30);
        con.add(JD);
          
        PL = new JCheckBox("Personal Leave");
        PL.setBounds(200,275,150,30);
        con.add(PL); 
  
        FR = new JCheckBox("Family Reasons");
        FR.setBounds(200,300,150,30);
        con.add(FR);    

        TV = new JCheckBox("To Vote");
        TV.setBounds(200,325,150,30);
        con.add(TV); 
          
        BMT = new JCheckBox("Bereavement");
        BMT.setBounds(400,275,150,30);
        con.add(BMT); 
  
        TOWP = new JCheckBox("Time off Without Pay");
        TOWP.setBounds(400,300,150,30);
        con.add(TOWP);  
  
  
        RFTR = new JLabel();
        RFTR.setText("REASON FOR THE TIME OFF REQUEST  ");
        RFTR.setFont(new Font("Times new Roman",Font.BOLD,13));
        RFTR.setBounds(10,360,500,30);
        con.add(RFTR);
  
        RFTRAREA = new JTextArea();
        RFTRAREA.setBounds(10,390,700,60);
        con.add(RFTRAREA);
  
        IRAE = new JLabel();
        IRAE.setText("I understand that this request is subject to approval by my employer ");
        IRAE.setFont(new Font("Times new Roman",Font.ITALIC,13));
        IRAE.setBounds(10,450,500,30);
        con.add(IRAE);
   
        ES = new JLabel();
        ES.setText("Employee signature ");
        ES.setFont(new Font("Times new Roman",Font.BOLD,13));
        ES.setBounds(10,476,500,30);
        con.add(ES);
   
        ESLABEL = new JTextField();
        ESLABEL.setFont(new Font("Times new Roman", Font.BOLD,13));
        ESLABEL.setBounds(120,481,195,20);
        con.add(ESLABEL);
   
        Date = new JLabel();
        Date.setText("Date ");
        Date.setFont(new Font("Times new Roman", Font.BOLD,13));
        Date.setBounds(390,475,520,30);
        con.add(Date);
   
        DateLABEL = new JTextField();
        DateLABEL.setFont(new Font("Times new Roman", Font.BOLD,13));
        DateLABEL.setBounds(420,480,195,20);
        con.add(DateLABEL);
   
        add(con);
        setVisible(true);
    }
}
