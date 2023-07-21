package EmployeeManagementSystem;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;



public class ManagerVUDReview extends JFrame implements ActionListener
{
    private EMSdataAccess database = new EMSdataAccess();
    private JTextField jTextName, jTextPos, jTextMan, jTextDep;
    private JComboBox employeeIdComboBox, overallResultComboBox;
    private JButton updateButton, deleteButton;
    private JLabel NameLabel, PosLabel;
    private JCheckBox WFP, WC, QW, Comm, TakeIni, CRTVY, PRDTVY, TechSkl, Effy, TMW, Leader, IndepWk, Rlbty, Puntly;  
    private JDateChooser jTextDate;
    private JTextArea Improve, Comment;
    
    public ManagerVUDReview() 
    {
        setTitle("Reviews");
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
        con.add(jTextName);

        PosLabel = new JLabel();
        PosLabel.setText("Position:");
        PosLabel.setFont(new Font("Open Sans", Font.PLAIN, 13));
        PosLabel.setBounds(50, 130, 220, 20);
        con.add(PosLabel);

        jTextPos = new JTextField();
        jTextPos.setFont(new Font("Open Sans", Font.PLAIN, 13));
        jTextPos.setBounds(130, 130, 180, 20);
        con.add(jTextPos);

        JLabel ManLabel = new JLabel();
        ManLabel.setText("Manager:");
        ManLabel.setFont(new Font("Open Sans", Font.PLAIN, 13));
        ManLabel.setBounds(50, 160, 260, 20);
        con.add(ManLabel);

        jTextMan = new JTextField();
        jTextMan.setFont(new Font("Open Sans", Font.PLAIN, 13));
        jTextMan.setBounds(130, 160, 180, 20);
        con.add(jTextMan);

        JLabel DateLabel = new JLabel();
        DateLabel.setText("Date:");
        DateLabel.setFont(new Font("Open Sans", Font.PLAIN, 13));
        DateLabel.setBounds(350, 100, 200, 20);
        con.add(DateLabel);

        jTextDate = new JDateChooser();
        jTextDate.setFont(new Font("Open Sans", Font.PLAIN, 13));
        jTextDate.setBounds(450, 100, 220, 20);
        con.add(jTextDate);

        JLabel DepLabel = new JLabel();
        DepLabel.setText("Department:");
        DepLabel.setFont(new Font("Open Sans", Font.PLAIN, 13));
        DepLabel.setBounds(350, 130, 200, 20);
        con.add(DepLabel);

        jTextDep = new JTextField();
        jTextDep.setFont(new Font("Open Sans", Font.PLAIN, 13));
        jTextDep.setBounds(450, 130, 220, 20);
        con.add(jTextDep);

        JLabel jLabelSkl = new JLabel();
        jLabelSkl.setText("SKILLS");
        jLabelSkl.setFont(new Font("Open Sans", Font.BOLD, 15));
        jLabelSkl.setBounds(330, 160, 180, 100);
        con.add(jLabelSkl);

        WFP = new JCheckBox("Work to Full Potential");
        WFP.setBounds(70, 230, 180, 30);
        WFP.setFont(new Font("Open Sans", Font.PLAIN, 13));
        con.add(WFP);

        WC = new JCheckBox("Work Consistency");
        WC.setBounds(70, 255, 180, 30);
        WC.setFont(new Font("Open Sans", Font.PLAIN, 13));
        con.add(WC);

        QW = new JCheckBox("Quality of Work");
        QW.setBounds(70, 280, 180, 30);
        QW.setFont(new Font("Open Sans", Font.PLAIN, 13));
        con.add(QW);

        Comm = new JCheckBox("Good Communication");
        Comm.setBounds(70, 305, 180, 30);
        Comm.setFont(new Font("Open Sans", Font.PLAIN, 13));
        con.add(Comm);

        TakeIni = new JCheckBox("Takes Initiative");
        TakeIni.setBounds(70, 330, 180, 30);
        TakeIni.setFont(new Font("Open Sans", Font.PLAIN, 13));
        con.add(TakeIni);

        CRTVY = new JCheckBox("Creativity");
        CRTVY.setBounds(70, 355, 180, 30);
        CRTVY.setFont(new Font("Open Sans", Font.PLAIN, 13));
        con.add(CRTVY);

        Rlbty = new JCheckBox("Reliability");
        Rlbty.setBounds(70, 380, 180, 30);
        Rlbty.setFont(new Font("Open Sans", Font.PLAIN, 13));
        con.add(Rlbty);

        PRDTVY = new JCheckBox("Productivity");
        PRDTVY.setBounds(400, 230, 180, 30);
        PRDTVY.setFont(new Font("Open Sans", Font.PLAIN, 13));
        con.add(PRDTVY);

        TechSkl = new JCheckBox("Technical Skills");
        TechSkl.setBounds(400, 255, 180, 30);
        TechSkl.setFont(new Font("Open Sans", Font.PLAIN, 13));
        con.add(TechSkl);

        Effy = new JCheckBox("Efficiency");
        Effy.setBounds(400, 280, 180, 30);
        Effy.setFont(new Font("Open Sans", Font.PLAIN, 13));
        con.add(Effy);

        TMW = new JCheckBox("Teamwork");
        TMW.setBounds(400, 305, 180, 30);
        TMW.setFont(new Font("Open Sans", Font.PLAIN, 13));
        con.add(TMW);

        Leader = new JCheckBox("Leadership");
        Leader.setBounds(400, 330, 180, 30);
        Leader.setFont(new Font("Open Sans", Font.PLAIN, 13));
        con.add(Leader);

        IndepWk = new JCheckBox("Independent Work");
        IndepWk.setBounds(400, 355, 180, 30);
        IndepWk.setFont(new Font("Open Sans", Font.PLAIN, 13));
        con.add(IndepWk);

        Puntly = new JCheckBox("Punctuality");
        Puntly.setBounds(400, 380, 180, 30);
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
        overallResultComboBox.setBackground(Color.LIGHT_GRAY);
        overallResultComboBox.setFocusable(false);
        con.add(overallResultComboBox);
        
        deleteButton = new JButton();
        deleteButton.setText("Delete");
        deleteButton.setFont(new Font("Open Sans", Font.BOLD, 13));
        deleteButton.setBounds(370, 590, 90, 30);
        deleteButton.setBackground(Color.GRAY);
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFocusable(false);
        deleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        deleteButton.addActionListener(this);
        con.add(deleteButton);

        updateButton = new JButton();
        updateButton.setText("Update");
        updateButton.setFont(new Font("Open Sans", Font.BOLD, 13));
        updateButton.setBounds(260, 590, 90, 30);
        updateButton.setBackground(Color.GRAY);
        updateButton.setForeground(Color.WHITE);
        updateButton.setFocusable(false);
        updateButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        updateButton.addActionListener(this);
        con.add(updateButton);


        employeeIdComboBox = new JComboBox();
        employeeIdComboBox.setFont(new Font("Open Sans", Font.PLAIN, 13));
        employeeIdComboBox.setBounds(315, 50, 180, 20);
        employeeIdComboBox.addActionListener(this);
        con.add(employeeIdComboBox);

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
    
    private boolean updateReviewData(String employeeId) 
    {
        GetSetEmployee review = database.getEmployeeReview(employeeId);
            review.setEmployeeId(employeeId);
            review.setName(jTextName.getText());
            review.setPosition(jTextPos.getText());
            review.setManager(jTextMan.getText());
            review.setDate(jTextDate.getDate());
            review.setDepartment(jTextDep.getText());
            review.setWorkToFullPotential(WFP.isSelected());
            review.setWorkConsistency(WC.isSelected());
            review.setQualityOfWork(QW.isSelected());
            review.setGoodCommunication(Comm.isSelected());
            review.setTakesInitiative(TakeIni.isSelected());
            review.setCreativity(CRTVY.isSelected());
            review.setReliability(Rlbty.isSelected());
            review.setProductivity(PRDTVY.isSelected());
            review.setTechnicalSkills(TechSkl.isSelected());
            review.setEfficiency(Effy.isSelected());
            review.setTeamwork(TMW.isSelected());
            review.setLeadership(Leader.isSelected());
            review.setIndependentWork(IndepWk.isSelected());
            review.setPunctuality(Puntly.isSelected());
            review.setAreaOfImprovement(Improve.getText());
            review.setComment(Comment.getText());
            review.setOverallReview(overallResultComboBox.getSelectedItem().toString());

        boolean success = database.updateReviewData(review);
            if (success) 
            {
                JOptionPane.showMessageDialog(this, "Review updated successfully.", "Update Success", JOptionPane.INFORMATION_MESSAGE);
            } 
            else 
            {
                JOptionPane.showMessageDialog(this, "Failed to update review.", "Update Failed", JOptionPane.ERROR_MESSAGE);
            }
        return false;
    }

    private boolean deleteReviewData(String employeeId) 
    {
        boolean success = database.deleteReviewData(employeeId);
            if (success) 
            {
                clearReviewData();
                employeeIdComboBox.removeItem(employeeId);
                JOptionPane.showMessageDialog(this, "Review deleted successfully.", "Delete Success", JOptionPane.INFORMATION_MESSAGE);
            } 
            else 
            {
                JOptionPane.showMessageDialog(this, "Failed to delete review.", "Delete Failed", JOptionPane.ERROR_MESSAGE);
            }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == employeeIdComboBox) 
        {
            String selectedEmployeeId = employeeIdComboBox.getSelectedItem().toString();
            displayReviewData(selectedEmployeeId);
        }  
        else if (e.getSource() == updateButton) 
        {
           
            if (employeeIdComboBox.getSelectedIndex() != -1) 
            { 
                 String selectedEmployeeId = employeeIdComboBox.getSelectedItem().toString();
                 updateReviewData(selectedEmployeeId); 
            } 
            else 
            {
                JOptionPane.showMessageDialog(this, "Please select an employee ID to update.", "Delete Error", JOptionPane.ERROR_MESSAGE);
            }
        } 
        else if (e.getSource() == deleteButton) 
        {
            if (employeeIdComboBox.getSelectedIndex() != -1) 
            { 
                String selectedEmployeeId = employeeIdComboBox.getSelectedItem().toString();
                deleteReviewData(selectedEmployeeId);
            } 
            else 
            {
                JOptionPane.showMessageDialog(this, "Please select an employee ID to delete.", "Delete Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
