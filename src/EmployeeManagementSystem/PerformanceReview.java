package EmployeeManagementSystem;

import java.awt.*;
import javax.swing.*;

public class PerformanceReview extends JFrame
{
    private JTextField jTextName, jTextPos, jTextMan, jTextDate, jTextDep, jTextID; 
    private JLabel jLabelSkl, titleLabel, InfoLabel1, NameLabel, PosLabel, ManLabel, DateLabel, DepLabel, IDLabel, ImproveLabel, CommentLabel;   
    private JCheckBox WFP, WC, QW, Comm, TakeIni, CRTVY, PRDTVY, TechSkl, Effy, TMW, Leader, IndepWk, Rlbty, Puntly;   
    private JScrollPane scrollPane;
    private JTextArea Improve,Comment;
    private JButton Submit;
    
    public PerformanceReview() 
    {
        setTitle("Performance Review");
        setBounds(100, 100, 750, 550);
        setLocationRelativeTo(null);
        setResizable(true);
    
        JPanel con = new JPanel();          
        con.setLayout(null);
    
        con.setPreferredSize(new Dimension(600,1000));
                
        JScrollPane scrollPane = new JScrollPane(con);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(640,400));        
        getContentPane().add(scrollPane);
                 
        titleLabel = new JLabel("Employee Performance Review ");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(200,0,500,50);
        con.add(titleLabel);
    
        InfoLabel1 = new JLabel();
        InfoLabel1.setText("EMPLOYEE INFORMATION");
        InfoLabel1.setFont(new Font("Open Sans", Font.BOLD, 15));
        InfoLabel1.setBounds(250,35, 200, 80);
        con.add(InfoLabel1);
    
        NameLabel = new JLabel();
        NameLabel.setText("Name:");
        NameLabel.setFont(new Font("Open Sans", Font.BOLD,13));
        NameLabel.setBounds(40, 100, 200, 20);
        con.add(NameLabel);
    
        jTextName = new JTextField();
        jTextName.setFont(new Font("Open Sans", Font.BOLD,13));
        jTextName.setBounds(90, 100, 180, 20);
        con.add(jTextName);
    
        PosLabel = new JLabel();
        PosLabel.setText("Position:");
        PosLabel.setFont(new Font("Open Sans", Font.BOLD,13));
        PosLabel.setBounds(30, 130, 220, 20);
        con.add(PosLabel);
    
        jTextPos = new JTextField();
        jTextPos.setFont(new Font("Open Sans", Font.BOLD,13));
        jTextPos.setBounds(90, 130, 180, 20);
        con.add(jTextPos);
    
        ManLabel = new JLabel();
        ManLabel.setText("Manager:");
        ManLabel.setFont(new Font("Open Sans", Font.BOLD,13));
        ManLabel.setBounds(25, 160, 260, 20);
        con.add(ManLabel);
    
        jTextMan = new JTextField();
        jTextMan.setFont(new Font("Open Sans", Font.BOLD,13));
        jTextMan.setBounds(90, 160, 180, 20);
        con.add(jTextMan);
    
        DateLabel = new JLabel();
        DateLabel.setText("Date:");
        DateLabel.setFont(new Font("Open Sans", Font.BOLD,13));
        DateLabel.setBounds(360, 100, 200, 20);
        con.add(DateLabel);
    
        jTextDate = new JTextField();
        jTextDate.setFont(new Font("Open Sans", Font.BOLD,13));
        jTextDate.setBounds(400, 100, 220, 20);
        con.add(jTextDate);
    
        DepLabel = new JLabel();
        DepLabel.setText("Department:");
        DepLabel.setFont(new Font("Open Sans", Font.BOLD,13));
        DepLabel.setBounds(315, 130, 200, 20);
        con.add(DepLabel);
    
        jTextDep = new JTextField();
        jTextDep.setFont(new Font("Open Sans", Font.BOLD,13));
        jTextDep.setBounds(400, 130, 220, 20);
        con.add(jTextDep);
    
        IDLabel = new JLabel();
        IDLabel.setText("Employee ID:");
        IDLabel.setFont(new Font("Open Sans", Font.BOLD,13));
        IDLabel.setBounds(310, 160, 200, 20);
        con.add(IDLabel);
    
        jTextID = new JTextField();
        jTextID.setFont(new Font("Open Sans", Font.BOLD,13));
        jTextID.setBounds(400, 160, 220, 20);
        con.add(jTextID);
    
        jLabelSkl = new JLabel();
        jLabelSkl.setText("SKILLS");
        jLabelSkl.setFont(new Font("Open Sans", Font.BOLD,15));
        jLabelSkl.setBounds(280, 160, 180, 100);
        con.add(jLabelSkl);
    
    
        WFP = new JCheckBox("Work to Full Potential");
        WFP.setBounds(30,230,180,30);
        con.add(WFP);
    
        WC = new JCheckBox("Work Consistency");
        WC.setBounds(30,255,180,30);
        con.add(WC);
    
        QW = new JCheckBox("Quality of Work");
        QW.setBounds(30,280,180,30);
        con.add(QW);
    
        Comm = new JCheckBox("Good Communication");
        Comm.setBounds(30,305,180,30);
        con.add(Comm);
    
        TakeIni = new JCheckBox("Takes Initiative");
        TakeIni.setBounds(30,330,180,30);
        con.add(TakeIni);
    
        CRTVY  = new JCheckBox("Creativity");
        CRTVY.setBounds(30,355,180,30);
        con.add(CRTVY);
    
        Rlbty = new JCheckBox("Reliability");
        Rlbty.setBounds(30,380,180,30);
        con.add(Rlbty);
    
        PRDTVY  = new JCheckBox("Productivity");
        PRDTVY.setBounds(370, 230, 180, 30);
        con.add(PRDTVY);
    
        TechSkl = new JCheckBox("Technical Skills");
        TechSkl.setBounds(370, 255, 180, 30);
        con.add(TechSkl);
    
        Effy = new JCheckBox("Effiency");
        Effy.setBounds(370, 280, 180, 30);
        con.add(Effy);
    
        TMW = new JCheckBox("Teamwork");
        TMW.setBounds(370, 305, 180, 30);
        con.add(TMW);
    
        Leader = new JCheckBox("Leadership");
        Leader.setBounds(370, 330, 180, 30);
        con.add(Leader);
    
        IndepWk = new JCheckBox("Independent Work");
        IndepWk.setBounds(370, 355, 180, 30);
        con.add(IndepWk);
    
        Puntly = new JCheckBox("Punctuality");
        Puntly.setBounds(370, 380, 180, 30);
        con.add(Puntly);
    
        ImproveLabel = new JLabel();
        ImproveLabel.setText("AREA OF IMPROVEMENTS");
        ImproveLabel.setFont(new Font("Open Sans", Font.BOLD,15));
        ImproveLabel.setBounds(50, 400, 200, 50);
        con.add(ImproveLabel);
    
        Improve = new JTextArea();
        Improve.setFont(new Font("Open Sans", Font.PLAIN,13));
        Improve.setBounds(10, 450, 250, 80);
        con.add(Improve);
    
        CommentLabel = new JLabel();
        CommentLabel.setText("COMMENTS");
        CommentLabel.setFont(new Font("Open Sans", Font.BOLD,15));
        CommentLabel.setBounds(400, 400, 180, 50);
        con.add(CommentLabel);
    
        Comment = new JTextArea();
        Comment.setFont(new Font("Open Sans", Font.PLAIN,13));
        Comment.setBounds(350, 450, 250, 80);
        con.add(Comment);
    
        Submit = new JButton();
        Submit.setText("SUBMIT");
        Submit.setFont(new Font("Open Sans", Font.BOLD,13));
        Submit.setBounds(255, 550, 90, 30);
        con.add(Submit);
            
        setVisible(true);
    }
    
}
