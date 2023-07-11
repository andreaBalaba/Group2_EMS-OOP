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
        setTitle("Employee Request Time Off");
        setBounds(100,100,750,550);
        setLocationRelativeTo(null);
        setResizable(false);
    
        JPanel con = new JPanel();
        con.setLayout(null);
    
        Title = new JLabel();
        Title.setText("EMPLOYEE TIME OFF REQUEST FORM");
        Title.setFont(new Font("Open Sans",Font.BOLD,23));
        Title.setBounds(150,20,500,30);
        con.add(Title);
    
    
        EMPINFOTitle = new JLabel();
        EMPINFOTitle.setText("EMPLOYEE INFORMATION");
        EMPINFOTitle.setFont(new Font("Open Sans",Font.BOLD,14));
        EMPINFOTitle.setBounds(10,80,500,30);
        con.add(EMPINFOTitle);
   
        Name = new JLabel();
        Name.setText("Name: ");
        Name.setFont(new Font("Open Sans", Font.PLAIN,13));
        Name.setBounds(10,130,500,30);
        con.add(Name);
   
        NameLABEL = new JTextField();
        NameLABEL.setFont(new Font("Open Sans", Font.PLAIN,13));
        NameLABEL.setBounds(70,135,280,20);
        con.add(NameLABEL);
   
        DPT = new JLabel();
        DPT.setText("Department: ");
        DPT.setFont(new Font("Open Sans", Font.PLAIN,13));
        DPT.setBounds(10,155,520,30);
        con.add(DPT);
   
   
        DPTLABEL = new JTextField();
        DPTLABEL.setFont(new Font("Open Sans", Font.PLAIN,13));
        DPTLABEL.setBounds(110,160,240,20);
        con.add(DPTLABEL);
   
        TOR = new JLabel();
        TOR.setText("Time off request: ");
        TOR.setFont(new Font("Open Sans", Font.PLAIN,13));
        TOR.setBounds(10,180,520,30);
        con.add(TOR);
   
        TORLABEL = new JTextField();
        TORLABEL.setFont(new Font("Open Sans", Font.PLAIN,13));
        TORLABEL.setBounds(130,185,220,20);
        con.add(TORLABEL);
   
        DAF = new JLabel();
        DAF.setText("Date of absence From: ");
        DAF.setFont(new Font("Open Sans", Font.PLAIN,13));
        DAF.setBounds(10,205,520,30);
        con.add(DAF);
   
        DAFLABEL = new JTextField();
        DAFLABEL.setFont(new Font("Open Sans", Font.PLAIN,13));
        DAFLABEL.setBounds(155,210,195,20);
        con.add(DAFLABEL);
   
        to = new JLabel();
        to.setText("To: ");
        to.setFont(new Font("Open Sans", Font.PLAIN,13));
        to.setBounds(400,205,520,30);
        con.add(to);
   
        toLABEL = new JTextField();
        toLABEL.setFont(new Font("Open Sans", Font.PLAIN,13));
        toLABEL.setBounds(440,210,195,20);
        con.add(toLABEL);
   
   
        TAR = new JLabel();
        TAR.setText("TYPE OF ABSENCE");
        TAR.setFont(new Font("Open Sans",Font.BOLD,14));
        TAR.setBounds(10,250,500,30);
        con.add(TAR);
   
        VCN = new JCheckBox("Vacation");
        VCN.setBounds(10,275,150,30);
        VCN.setFont(new Font("Open Sans",Font.PLAIN,13));
        con.add(VCN);
   
        ML = new JCheckBox("Medical Leave");
        ML.setBounds(10,300,150,30);
        ML.setFont(new Font("Open Sans",Font.PLAIN,13));
        con.add(ML);
  
        JD = new JCheckBox("Jury Duty");
        JD.setBounds(10,325,150,30);
        JD.setFont(new Font("Open Sans",Font.PLAIN,13));
        con.add(JD);
          
        PL = new JCheckBox("Personal Leave");
        PL.setBounds(200,275,150,30);
        PL.setFont(new Font("Open Sans",Font.PLAIN,13));
        con.add(PL); 
  
        FR = new JCheckBox("Family Reasons");
        FR.setBounds(200,300,150,30);
        FR.setFont(new Font("Open Sans",Font.PLAIN,13));
        con.add(FR);    

        TV = new JCheckBox("To Vote");
        TV.setBounds(200,325,150,30);
        TV.setFont(new Font("Open Sans",Font.PLAIN,13));
        con.add(TV); 
          
        BMT = new JCheckBox("Bereavement");
        BMT.setBounds(400,275,150,30);
        BMT.setFont(new Font("Open Sans",Font.PLAIN,13));
        con.add(BMT); 
  
        TOWP = new JCheckBox("Time off Without Pay");
        TOWP.setBounds(400,300,180,30);
        TOWP.setFont(new Font("Open Sans",Font.PLAIN,13));
        con.add(TOWP);  
  
  
        RFTR = new JLabel();
        RFTR.setText("REASON FOR THE TIME OFF REQUEST  ");
        RFTR.setFont(new Font("Open Sans",Font.BOLD,14));
        RFTR.setBounds(10,360,500,30);
        con.add(RFTR);
  
        RFTRAREA = new JTextArea();
        RFTRAREA.setBounds(10,390,700,60);
        RFTRAREA.setFont(new Font("Open Sans",Font.PLAIN,13));
        con.add(RFTRAREA);
  
        IRAE = new JLabel();
        IRAE.setText("I understand that this request is subject to approval by my employer ");
        IRAE.setFont(new Font("Open Sans",Font.ITALIC,13));
        IRAE.setBounds(10,450,500,30);
        con.add(IRAE);
   
        ES = new JLabel();
        ES.setText("Employee signature ");
        ES.setFont(new Font("Open Sans",Font.BOLD,13));
        ES.setBounds(10,476,500,30);
        con.add(ES);
   
        ESLABEL = new JTextField();
        ESLABEL.setFont(new Font("Open Sans", Font.PLAIN,13));
        ESLABEL.setBounds(140,481,195,20);
        con.add(ESLABEL);
   
        Date = new JLabel();
        Date.setText("Date ");
        Date.setFont(new Font("Open Sans", Font.BOLD,13));
        Date.setBounds(390,475,520,30);
        con.add(Date);
   
        DateLABEL = new JTextField();
        DateLABEL.setFont(new Font("Open Sans", Font.PLAIN,13));
        DateLABEL.setBounds(440,480,195,20);
        con.add(DateLABEL);
   
        add(con);
        setVisible(true);
    }
}
