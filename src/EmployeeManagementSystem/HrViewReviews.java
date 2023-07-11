package EmployeeManagementSystem;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;


public class HrViewReviews extends JFrame implements ActionListener
{
    private EMSdataAccess database = new EMSdataAccess();
    private JTextField jTextName, jTextPos, jTextMan, jTextDep;
    private JComboBox employeeIdComboBox, overallResultComboBox;
    private JButton backButton;
    private JLabel NameLabel, PosLabel;
    private JCheckBox WFP, WC, QW, Comm, TakeIni, CRTVY, PRDTVY, TechSkl, Effy, TMW, Leader, IndepWk, Rlbty, Puntly;  
    private JDateChooser jTextDate;
    private JTextArea Improve, Comment;
    
    public HrViewReviews()
    {
        setTitle("View Reviews");
        setBounds(100, 100, 750, 550);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel con = new JPanel();
        con.setLayout(null);

        con.setPreferredSize(new Dimension(600, 650));

        JScrollPane scrollPane = new JScrollPane(con);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(600, 400));
        getContentPane().add(scrollPane);

        JLabel titleLabel = new JLabel("Employee Performance Review ");
        titleLabel.setFont(new Font("Open Sans", Font.BOLD, 20));
        titleLabel.setBounds(210, 0, 500, 50);
        con.add(titleLabel);

        JLabel InfoLabel1 = new JLabel();
        InfoLabel1.setBounds(260, 35, 200, 80);
        con.add(InfoLabel1);

        NameLabel = new JLabel();
        NameLabel.setText("Name:");
        NameLabel.setFont(new Font("Open Sans", Font.PLAIN, 13));
        NameLabel.setBounds(50, 100, 200, 20);
        con.add(NameLabel);

        jTextName = new JTextField();
        jTextName.setFont(new Font("Open Sans", Font.PLAIN, 13));
        jTextName.setBounds(130, 100, 180, 20);
        jTextName.setEditable(false);
        con.add(jTextName);

        PosLabel = new JLabel();
        PosLabel.setText("Position:");
        PosLabel.setFont(new Font("Open Sans", Font.PLAIN, 13));
        PosLabel.setBounds(50, 130, 220, 20);
        con.add(PosLabel);

        jTextPos = new JTextField();
        jTextPos.setFont(new Font("Open Sans", Font.PLAIN, 13));
        jTextPos.setBounds(130, 130, 180, 20);
        jTextPos.setEditable(false);
        con.add(jTextPos);

        JLabel ManLabel = new JLabel();
        ManLabel.setText("Manager:");
        ManLabel.setFont(new Font("Open Sans", Font.PLAIN, 13));
        ManLabel.setBounds(50, 160, 260, 20);
        con.add(ManLabel);

        jTextMan = new JTextField();
        jTextMan.setFont(new Font("Open Sans", Font.PLAIN, 13));
        jTextMan.setBounds(130, 160, 180, 20);
        jTextMan.setEditable(false);
        con.add(jTextMan);

        JLabel DateLabel = new JLabel();
        DateLabel.setText("Date:");
        DateLabel.setFont(new Font("Open Sans", Font.PLAIN, 13));
        DateLabel.setBounds(350, 100, 200, 20);
        con.add(DateLabel);

        jTextDate = new JDateChooser();
        jTextDate.setFont(new Font("Open Sans", Font.PLAIN, 13));
        jTextDate.setBounds(450, 100, 220, 20);
        jTextDate.setEnabled(false);
        con.add(jTextDate);

        JLabel DepLabel = new JLabel();
        DepLabel.setText("Department:");
        DepLabel.setFont(new Font("Open Sans", Font.PLAIN, 13));
        DepLabel.setBounds(350, 130, 200, 20);
        con.add(DepLabel);

        jTextDep = new JTextField();
        jTextDep.setFont(new Font("Open Sans", Font.PLAIN, 13));
        jTextDep.setBounds(450, 130, 220, 20);
        jTextDep.setEditable(false);
        con.add(jTextDep);

        JLabel jLabelSkl = new JLabel();
        jLabelSkl.setText("SKILLS");
        jLabelSkl.setFont(new Font("Open Sans", Font.BOLD, 15));
        jLabelSkl.setBounds(330, 160, 180, 100);
        con.add(jLabelSkl);

        WFP = new JCheckBox("Work to Full Potential");
        WFP.setBounds(70, 230, 180, 30);
        WFP.setEnabled(false);
        WFP.setFont(new Font("Open Sans", Font.PLAIN, 13));
        con.add(WFP);

        WC = new JCheckBox("Work Consistency");
        WC.setBounds(70, 255, 180, 30);
        WC.setEnabled(false);
        WC.setFont(new Font("Open Sans", Font.PLAIN, 13));
        con.add(WC);

        QW = new JCheckBox("Quality of Work");
        QW.setBounds(70, 280, 180, 30);
        QW.setEnabled(false);
        QW.setFont(new Font("Open Sans", Font.PLAIN, 13));
        con.add(QW);

        Comm = new JCheckBox("Good Communication");
        Comm.setBounds(70, 305, 180, 30);
        Comm.setEnabled(false);
        Comm.setFont(new Font("Open Sans", Font.PLAIN, 13));
        con.add(Comm);

        TakeIni = new JCheckBox("Takes Initiative");
        TakeIni.setBounds(70, 330, 180, 30);
        TakeIni.setEnabled(false);
        TakeIni.setFont(new Font("Open Sans", Font.PLAIN, 13));
        con.add(TakeIni);

        CRTVY = new JCheckBox("Creativity");
        CRTVY.setBounds(70, 355, 180, 30);
        CRTVY.setEnabled(false);
        CRTVY.setFont(new Font("Open Sans", Font.PLAIN, 13));
        con.add(CRTVY);

        Rlbty = new JCheckBox("Reliability");
        Rlbty.setBounds(70, 380, 180, 30);
        Rlbty.setEnabled(false);
        Rlbty.setFont(new Font("Open Sans", Font.PLAIN, 13));
        con.add(Rlbty);

        PRDTVY = new JCheckBox("Productivity");
        PRDTVY.setBounds(400, 230, 180, 30);
        PRDTVY.setEnabled(false);
        PRDTVY.setFont(new Font("Open Sans", Font.PLAIN, 13));
        con.add(PRDTVY);

        TechSkl = new JCheckBox("Technical Skills");
        TechSkl.setBounds(400, 255, 180, 30);
        TechSkl.setEnabled(false);
        TechSkl.setFont(new Font("Open Sans", Font.PLAIN, 13));
        con.add(TechSkl);

        Effy = new JCheckBox("Efficiency");
        Effy.setBounds(400, 280, 180, 30);
        Effy.setEnabled(false);
        Effy.setFont(new Font("Open Sans", Font.PLAIN, 13));
        con.add(Effy);

        TMW = new JCheckBox("Teamwork");
        TMW.setBounds(400, 305, 180, 30);
        TMW.setEnabled(false);
        TMW.setFont(new Font("Open Sans", Font.PLAIN, 13));
        con.add(TMW);

        Leader = new JCheckBox("Leadership");
        Leader.setBounds(400, 330, 180, 30);
        Leader.setEnabled(false);
        Leader.setFont(new Font("Open Sans", Font.PLAIN, 13));
        con.add(Leader);

        IndepWk = new JCheckBox("Independent Work");
        IndepWk.setBounds(400, 355, 180, 30);
        IndepWk.setEnabled(false);
        IndepWk.setFont(new Font("Open Sans", Font.PLAIN, 13));
        con.add(IndepWk);

        Puntly = new JCheckBox("Punctuality");
        Puntly.setBounds(400, 380, 180, 30);
        Puntly.setEnabled(false);
        Puntly.setFont(new Font("Open Sans", Font.PLAIN, 13));
        con.add(Puntly);

        JLabel ImproveLabel = new JLabel();
        ImproveLabel.setText("Area of Improvement");
        ImproveLabel.setFont(new Font("Open Sans", Font.BOLD, 15));
        ImproveLabel.setBounds(120, 410, 200, 50);
        con.add(ImproveLabel);

        Improve = new JTextArea();
        Improve.setFont(new Font("Open        Sans", Font.PLAIN, 13));
        Improve.setBounds(70, 450, 250, 80);
        Improve.setEditable(false);
        Improve.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        con.add(Improve);

        JLabel CommentLabel = new JLabel();
        CommentLabel.setText("Comment");
        CommentLabel.setFont(new Font("Open Sans", Font.BOLD, 15));
        CommentLabel.setBounds(490, 410, 180, 50);
        con.add(CommentLabel);

        Comment = new JTextArea();
        Comment.setFont(new Font("Open Sans", Font.PLAIN, 13));
        Comment.setBounds(400, 450, 250, 80);
        Comment.setEditable(false);
        Comment.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        con.add(Comment);

        JLabel reslbl = new JLabel();
        reslbl.setText("Overall Review:");
        reslbl.setFont(new Font("Open Sans", Font.BOLD, 13));
        reslbl.setBounds(235, 550, 220, 20);
        con.add(reslbl);

        String result[] = { "Please select...", "Excellent", "Good", "Average", "Below Average" };
        overallResultComboBox = new JComboBox(result);
        overallResultComboBox.setFont(new Font("Open Sans", Font.PLAIN, 13));
        overallResultComboBox.setBounds(335, 550, 150, 20);
        overallResultComboBox.setEnabled(false);
        overallResultComboBox.setBackground(Color.LIGHT_GRAY);
        overallResultComboBox.setFocusable(false);
        con.add(overallResultComboBox);

        employeeIdComboBox = new JComboBox();
        employeeIdComboBox.setFont(new Font("Open Sans", Font.PLAIN, 13));
        employeeIdComboBox.setBounds(315, 50, 180, 20);
        employeeIdComboBox.setBackground(Color.LIGHT_GRAY);
        employeeIdComboBox.setFocusable(false);
        employeeIdComboBox.addActionListener(this);
        con.add(employeeIdComboBox);
        
        backButton = new JButton("Back");
        backButton.setFont(new Font("Open Sans", Font.BOLD, 13));
        backButton.setBounds(315, 590, 90, 30);
        backButton.setBackground(Color.GRAY);
        backButton.setForeground(Color.WHITE);
        backButton.setFocusable(false);
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.addActionListener(this);
        con.add(backButton);

        JLabel employeeIdLabel = new JLabel("Employee ID:");
        employeeIdLabel.setFont(new Font("Open Sans", Font.PLAIN, 13));
        employeeIdLabel.setBounds(225, 50, 200, 20);
        con.add(employeeIdLabel);

        setVisible(true);
        populateRevEmployeeIds();
    }
    
    private void populateRevEmployeeIds() 
    {
        List<String> employeeIds = database.getDistinctEmployeeIds();

        if (employeeIds != null && !employeeIds.isEmpty()) 
        {
            for (String employeeId : employeeIds) 
            {
                employeeIdComboBox.addItem(employeeId);
            }
        }
    }
    
    private void displayReviewData(String employeeId) 
    {
        GetSetEmployee review = database.getEmployeeReview(employeeId);

            if (review != null) 
            {
                jTextName.setText(review.getName());
                jTextPos.setText(review.getPosition());
                jTextMan.setText(review.getManager());
                jTextDate.setDate(review.getDate());
                jTextDep.setText(review.getDepartment());
                WFP.setSelected(review.isWorkToFullPotential());
                WC.setSelected(review.isWorkConsistency());
                QW.setSelected(review.isQualityOfWork());
                Comm.setSelected(review.isGoodCommunication());
                TakeIni.setSelected(review.isTakesInitiative());
                CRTVY.setSelected(review.isCreativity());
                Rlbty.setSelected(review.isReliability());
                PRDTVY.setSelected(review.isProductivity());
                TechSkl.setSelected(review.isTechnicalSkills());
                Effy.setSelected(review.isEfficiency());
                TMW.setSelected(review.isTeamwork());
                Leader.setSelected(review.isLeadership());
                IndepWk.setSelected(review.isIndependentWork());
                Puntly.setSelected(review.isPunctuality());
                Improve.setText(review.getAreaOfImprovement());
                Comment.setText(review.getComment());

                String overallReview = review.getOverallReview();
                    if (overallReview != null && !overallReview.isEmpty()) 
                    {
                        overallResultComboBox.setSelectedItem(overallReview);
                    } 
                    else 
                    {
                        overallResultComboBox.setSelectedIndex(0);
                    }
            } 
            else 
            {
                clearReviewData();
            }
    }
    
    private void clearReviewData() 
    {
        jTextName.setText("");
        jTextPos.setText("");
        jTextMan.setText("");
        jTextDate.setDate(null);
        jTextDep.setText("");
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
        if (e.getSource() == employeeIdComboBox) 
        {
            String selectedEmployeeId = employeeIdComboBox.getSelectedItem().toString();
            displayReviewData(selectedEmployeeId);
        }
        else if (e.getSource() == backButton) 
        {
            dispose();
        }
    }
}
