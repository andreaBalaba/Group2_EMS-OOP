package EmployeeManagementSystem;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;

public class ManPerRev extends JFrame implements ActionListener
{
    private EMSdataAccess database = new EMSdataAccess();
    private JTextField jTextName, jTextPos, jTextMan, jTextDep, jTextID; 
    private JLabel jLabelSkl, titleLabel, InfoLabel1, NameLabel, PosLabel, ManLabel, DateLabel;
    private JLabel DepLabel, IDLabel, ImproveLabel, CommentLabel, reslbl;   
    private JCheckBox WFP, WC, QW, Comm, TakeIni, CRTVY, PRDTVY, TechSkl, Effy, TMW, Leader, IndepWk, Rlbty, Puntly;   
    private JScrollPane scrollPane;
    private JTextArea Improve,Comment;
    private JButton Submit, Clear, Back;
    private JDateChooser jTextDate;
    private JComboBox overallResultComboBox;
    
    public ManPerRev() 
    {
        setTitle("Performance Review");
        setBounds(100, 100, 750, 550);
        setLocationRelativeTo(null);
        setResizable(false);
    
        JPanel con = new JPanel();          
        con.setLayout(null);
    
        con.setPreferredSize(new Dimension(600,650));
                
        scrollPane = new JScrollPane(con);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(600,400));        
        getContentPane().add(scrollPane);
                 
        titleLabel = new JLabel("Employee Performance Review ");
        titleLabel.setFont(new Font("Open Sans", Font.BOLD, 20));
        titleLabel.setBounds(210,0,500,50);
        con.add(titleLabel);
    
        InfoLabel1 = new JLabel();
        InfoLabel1.setText("EMPLOYEE INFORMATION");
        InfoLabel1.setFont(new Font("Open Sans", Font.BOLD, 15));
        InfoLabel1.setBounds(260,35, 200, 80);
        con.add(InfoLabel1);
    
        NameLabel = new JLabel();
        NameLabel.setText("Name:");
        NameLabel.setFont(new Font("Open Sans", Font.PLAIN,13));
        NameLabel.setBounds(50, 100, 200, 20);
        con.add(NameLabel);
    
        jTextName = new JTextField();
        jTextName.setFont(new Font("Open Sans", Font.PLAIN,13));
        jTextName.setBounds(130, 100, 180, 20);
        con.add(jTextName);
    
        PosLabel = new JLabel();
        PosLabel.setText("Position:");
        PosLabel.setFont(new Font("Open Sans", Font.PLAIN,13));
        PosLabel.setBounds(50, 130, 220, 20);
        con.add(PosLabel);
    
        jTextPos = new JTextField();
        jTextPos.setFont(new Font("Open Sans", Font.PLAIN,13));
        jTextPos.setBounds(130, 130, 180, 20);
        con.add(jTextPos);
    
        ManLabel = new JLabel();
        ManLabel.setText("Manager:");
        ManLabel.setFont(new Font("Open Sans", Font.PLAIN,13));
        ManLabel.setBounds(50, 160, 260, 20);
        con.add(ManLabel);
    
        jTextMan = new JTextField();
        jTextMan.setFont(new Font("Open Sans", Font.PLAIN,13));
        jTextMan.setBounds(130, 160, 180, 20);
        con.add(jTextMan);
    
        DateLabel = new JLabel();
        DateLabel.setText("Date:");
        DateLabel.setFont(new Font("Open Sans", Font.PLAIN,13));
        DateLabel.setBounds(350, 100, 200, 20);
        con.add(DateLabel);
    
        jTextDate = new JDateChooser();
        jTextDate.setFont(new Font("Open Sans", Font.PLAIN,13));
        jTextDate.setBounds(450, 100, 220, 20);
        con.add(jTextDate);
    
        DepLabel = new JLabel();
        DepLabel.setText("Department:");
        DepLabel.setFont(new Font("Open Sans", Font.PLAIN,13));
        DepLabel.setBounds(350, 130, 200, 20);
        con.add(DepLabel);
    
        jTextDep = new JTextField();
        jTextDep.setFont(new Font("Open Sans", Font.PLAIN,13));
        jTextDep.setBounds(450, 130, 220, 20);
        con.add(jTextDep);
    
        IDLabel = new JLabel();
        IDLabel.setText("Employee ID:");
        IDLabel.setFont(new Font("Open Sans", Font.PLAIN,13));
        IDLabel.setBounds(350, 160, 200, 20);
        con.add(IDLabel);
    
        jTextID = new JTextField();
        jTextID.setFont(new Font("Open Sans", Font.PLAIN,13));
        jTextID.setBounds(450, 160, 220, 20);
        con.add(jTextID);
    
        jLabelSkl = new JLabel();
        jLabelSkl.setText("SKILLS");
        jLabelSkl.setFont(new Font("Open Sans", Font.BOLD,15));
        jLabelSkl.setBounds(330, 160, 180, 100);
        con.add(jLabelSkl);
    
    
        WFP = new JCheckBox("Work to Full Potential");
        WFP.setBounds(70,230,180,30);
        WFP.setFont(new Font("Open Sans", Font.PLAIN,13));
        con.add(WFP);
    
        WC = new JCheckBox("Work Consistency");
        WC.setBounds(70,255,180,30);
        WC.setFont(new Font("Open Sans", Font.PLAIN,13));
        con.add(WC);
    
        QW = new JCheckBox("Quality of Work");
        QW.setBounds(70,280,180,30);
        QW.setFont(new Font("Open Sans", Font.PLAIN,13));
        con.add(QW);
    
        Comm = new JCheckBox("Good Communication");
        Comm.setBounds(70,305,180,30);
        Comm.setFont(new Font("Open Sans", Font.PLAIN,13));
        con.add(Comm);
    
        TakeIni = new JCheckBox("Takes Initiative");
        TakeIni.setBounds(70,330,180,30);
        TakeIni.setFont(new Font("Open Sans", Font.PLAIN,13));
        con.add(TakeIni);
    
        CRTVY  = new JCheckBox("Creativity");
        CRTVY.setBounds(70,355,180,30);
        CRTVY.setFont(new Font("Open Sans", Font.PLAIN,13));
        con.add(CRTVY);
    
        Rlbty = new JCheckBox("Reliability");
        Rlbty.setBounds(70,380,180,30);
        Rlbty.setFont(new Font("Open Sans", Font.PLAIN,13));
        con.add(Rlbty);
    
        PRDTVY  = new JCheckBox("Productivity");
        PRDTVY.setBounds(400, 230, 180, 30);
        PRDTVY.setFont(new Font("Open Sans", Font.PLAIN,13));
        con.add(PRDTVY);
    
        TechSkl = new JCheckBox("Technical Skills");
        TechSkl.setBounds(400, 255, 180, 30);
        TechSkl.setFont(new Font("Open Sans", Font.PLAIN,13));
        con.add(TechSkl);
    
        Effy = new JCheckBox("Effiency");
        Effy.setBounds(400, 280, 180, 30);
        Effy.setFont(new Font("Open Sans", Font.PLAIN,13));
        con.add(Effy);
    
        TMW = new JCheckBox("Teamwork");
        TMW.setBounds(400, 305, 180, 30);
        TMW.setFont(new Font("Open Sans", Font.PLAIN,13));
        con.add(TMW);
    
        Leader = new JCheckBox("Leadership");
        Leader.setBounds(400, 330, 180, 30);
        Leader.setFont(new Font("Open Sans", Font.PLAIN,13));
        con.add(Leader);
    
        IndepWk = new JCheckBox("Independent Work");
        IndepWk.setBounds(400, 355, 180, 30);
        IndepWk.setFont(new Font("Open Sans", Font.PLAIN,13));
        con.add(IndepWk);
    
        Puntly = new JCheckBox("Punctuality");
        Puntly.setBounds(400, 380, 180, 30);
        Puntly.setFont(new Font("Open Sans", Font.PLAIN,13));
        con.add(Puntly);
    
        ImproveLabel = new JLabel();
        ImproveLabel.setText("Area of Improvement");
        ImproveLabel.setFont(new Font("Open Sans", Font.BOLD,15));
        ImproveLabel.setBounds(120, 410, 200, 50);
        con.add(ImproveLabel);
    
        Improve = new JTextArea();
        Improve.setFont(new Font("Open Sans", Font.PLAIN,13));
        Improve.setBounds(70, 450, 250, 80);
        Improve.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        con.add(Improve);
    
        CommentLabel = new JLabel();
        CommentLabel.setText("Comment");
        CommentLabel.setFont(new Font("Open Sans", Font.BOLD,15));
        CommentLabel.setBounds(490, 410, 180, 50);
        con.add(CommentLabel);
    
        Comment = new JTextArea();
        Comment.setFont(new Font("Open Sans", Font.PLAIN,13));
        Comment.setBounds(400, 450, 250, 80);
        Comment.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        con.add(Comment);
        
        reslbl = new JLabel();
        reslbl.setText("Overall Review:");
        reslbl.setFont(new Font("Open Sans", Font.BOLD,13));
        reslbl.setBounds(235, 550, 220, 20);
        con.add(reslbl);
        
        String result[] = {"Please select...","Exellent", "Good", "Average", "Below Average"};
        overallResultComboBox = new JComboBox(result);
        overallResultComboBox.setFont(new Font("Open Sans", Font.PLAIN, 13));
        overallResultComboBox.setBounds(335, 550, 150, 20);
        overallResultComboBox.setBackground(Color.LIGHT_GRAY);
        overallResultComboBox.setFocusable(false);
        con.add(overallResultComboBox);
    
        Submit = new JButton();
        Submit.setText("SUBMIT");
        Submit.setFont(new Font("Open Sans", Font.BOLD,13));
        Submit.setBounds(220, 590, 90, 30);
        Submit.setBackground(Color.GRAY);
        Submit.setForeground(Color.WHITE);
        Submit.setFocusable(false);
        Submit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Submit.addActionListener(this);
        con.add(Submit);
        
        Clear = new JButton();
        Clear.setText("CLEAR");
        Clear.setFont(new Font("Open Sans", Font.BOLD,13));
        Clear.setBounds(320, 590, 90, 30);
        Clear.setBackground(Color.GRAY);
        Clear.setForeground(Color.WHITE);
        Clear.setFocusable(false);
        Clear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Clear.addActionListener(this);
        con.add(Clear);
        
        Back = new JButton();
        Back.setText("BACK");
        Back.setFont(new Font("Open Sans", Font.BOLD,13));
        Back.setBounds(420, 590, 90, 30);
        Back.setBackground(Color.GRAY);
        Back.setForeground(Color.WHITE);
        Back.setFocusable(false);
        Back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Back.addActionListener(this);
        con.add(Back);
            
        setVisible(true);
    }
    
    private void savePerformanceReview() 
    {
        String name = jTextName.getText();
        String position = jTextPos.getText();
        String manager = jTextMan.getText();
        Date date = jTextDate.getDate();
        String department = jTextDep.getText();
        String employeeId = jTextID.getText();
        boolean workToFullPotential = WFP.isSelected();
        boolean workConsistency = WC.isSelected();
        boolean qualityOfWork = QW.isSelected();
        boolean goodCommunication = Comm.isSelected();
        boolean takesInitiative = TakeIni.isSelected();
        boolean creativity = CRTVY.isSelected();
        boolean reliability = Rlbty.isSelected();
        boolean productivity = PRDTVY.isSelected();
        boolean technicalSkills = TechSkl.isSelected();
        boolean efficiency = Effy.isSelected();
        boolean teamwork = TMW.isSelected();
        boolean leadership = Leader.isSelected();
        boolean independentWork = IndepWk.isSelected();
        boolean punctuality = Puntly.isSelected();
        String areaOfImprovement = Improve.getText();
        String comment = Comment.getText();
        String overallReview = overallResultComboBox.getSelectedItem().toString();

        GetSetEmployee employee = new GetSetEmployee(name, position, manager, date, department, employeeId, workToFullPotential, workConsistency,
                               qualityOfWork, goodCommunication, takesInitiative, creativity, reliability, productivity, technicalSkills, 
                                efficiency, teamwork, leadership, independentWork, punctuality, areaOfImprovement, comment, overallReview);
            employee.setWorkToFullPotential(workToFullPotential);
            employee.setWorkConsistency(workConsistency);
            employee.setQualityOfWork(qualityOfWork);
            employee.setGoodCommunication(goodCommunication);
            employee.setTakesInitiative(takesInitiative);
            employee.setCreativity(creativity);
            employee.setReliability(reliability);
            employee.setProductivity(productivity);
            employee.setTechnicalSkills(technicalSkills);
            employee.setEfficiency(efficiency);
            employee.setTeamwork(teamwork);
            employee.setLeadership(leadership);
            employee.setIndependentWork(independentWork);
            employee.setPunctuality(punctuality);
            employee.setAreaOfImprovement(areaOfImprovement);
            employee.setComment(comment);
            employee.setOverallReview(overallReview);

        boolean success = database.savePerformanceReview(employee);

        if (success) 
        {
            JOptionPane.showMessageDialog(null, "Performance review submitted successfully!", "Success",
                JOptionPane.INFORMATION_MESSAGE);
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "Failed to submit the performance review.", "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void clearReviewData() 
    {
        jTextName.setText("");
        jTextPos.setText("");
        jTextMan.setText("");
        jTextDate.setDate(null);
        jTextDep.setText("");
        jTextID.setText("");
        WFP.setSelected(false);
        WC.setSelected(false);
        QW.setSelected(false);
        Comm.setSelected(false);
        TakeIni.setSelected(false);
        CRTVY.setSelected(false);
        Rlbty.setSelected(false);
        PRDTVY.setSelected(false);
        TechSkl.setSelected(false);
        Effy.setSelected(false);
        TMW.setSelected(false);
        Leader.setSelected(false);
        IndepWk.setSelected(false);
        Puntly.setSelected(false);
        Improve.setText("");
        Comment.setText("");
        overallResultComboBox.setSelectedIndex(0);
    }
        
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == Submit) 
        {
            savePerformanceReview();
        }
        else if (e.getSource() == Clear) 
        {
            clearReviewData();
        }
        else if (e.getSource() == Back) {
            dispose();
        }
    }
}
