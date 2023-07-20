package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class HrTimeOffRequestList extends JFrame implements ActionListener, MouseListener
{
    private JLabel Direc;
    private JTable requestTable;
    private JButton backButton;
    private EMSdataAccess database = new EMSdataAccess();
    
    public HrTimeOffRequestList()
    {

        setTitle("Time Off Request List");
        setBounds(100, 100, 750, 550);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        Vector<String> columnNames = new Vector<>();
        columnNames.add("Request No.");
        columnNames.add("Employee Name");
        columnNames.add("Department");
        columnNames.add("Date");
        columnNames.add("Status");
        
        Vector<Vector<Object>> data = database.getTimeOffRequests();
        
        DefaultTableModel model = new DefaultTableModel(data, columnNames) 
        {
            @Override
            public boolean isCellEditable(int row, int column) 
            {
                return column == 4;
            }
        };
        
        requestTable = new JTable(model);
        requestTable.setEnabled(false);
        requestTable.addMouseListener(this);
        JScrollPane scrollPane = new JScrollPane(requestTable);
        scrollPane.setBounds(50, 80, 630, 350);
        panel.add(scrollPane);
        
        Direc = new JLabel();
        Direc.setText("Click the Request No. to view more details about request.");
        Direc.setFont(new Font("Open Sans", Font.PLAIN,13));
        Direc.setBounds(50,50,500,30);
        panel.add(Direc);

        backButton = new JButton("Back");
        backButton.setFont(new Font("Open Sans", Font.BOLD, 13));
        backButton.setBounds(320, 450, 90, 30);
        backButton.setBackground(Color.GRAY);
        backButton.setForeground(Color.WHITE);
        backButton.setFocusable(false);
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.addActionListener(this);
        panel.add(backButton);

        add(panel);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == backButton) 
        {
            dispose();
            new HrPage();
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) 
    {
        if (e.getSource() == requestTable) 
        {
            int row = requestTable.rowAtPoint(e.getPoint());
            int col = requestTable.columnAtPoint(e.getPoint());
            
            if (col == 0) 
            {
                int requestId = Integer.parseInt(requestTable.getValueAt(row, 0).toString());
                Vector<Object> rowData = database.getTimeOffRequestById(requestId);

                if (rowData != null) 
                {

                    GetSetEmployee employee = new GetSetEmployee();
                    employee.setRequestId((int) rowData.get(0));
                    employee.setName(rowData.get(1).toString());
                    employee.setDepartment(rowData.get(2).toString());
                    employee.setManager(rowData.get(3).toString());
                    employee.setEmployeeId(rowData.get(4).toString());
                    employee.setTotalHours((int) rowData.get(5));
                    employee.setDateOfAbsenceFrom((Date) rowData.get(6));
                    employee.setDateOfAbsenceTo((Date) rowData.get(7));
                    employee.setVacation((boolean) rowData.get(8));
                    employee.setMedicalLeave((boolean) rowData.get(9));
                    employee.setJuryDuty((boolean) rowData.get(10));
                    employee.setPersonalLeave((boolean) rowData.get(11));
                    employee.setFamilyReasons((boolean) rowData.get(12));
                    employee.setToVote((boolean) rowData.get(13));
                    employee.setBereavement((boolean) rowData.get(14));
                    employee.setTimeOffWithoutPay((boolean) rowData.get(15));
                    employee.setReasonForRequest(rowData.get(16).toString());
                    employee.setEmployeeSignature(rowData.get(17).toString());
                    employee.setRequestDate((Date) rowData.get(18));
                    employee.setStatus(rowData.get(19).toString());
                        
                            HrTimeOff timeOffForm = new HrTimeOff(employee);
                            timeOffForm.setVisible(true);
                            
                    dispose();
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) 
    {
       
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {
        
    }
    
    @Override
    public void mouseEntered(MouseEvent e) 
    {
        
    }

    @Override
    public void mouseExited(MouseEvent e) 
    {
         
    }
}
