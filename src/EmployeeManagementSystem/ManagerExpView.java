package EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class ManagerExpView extends JFrame implements ActionListener, MouseListener
{
    private JLabel Direc;
    private JTable expenseTable;
    private JButton backButton;
    private EMSdataAccess database = new EMSdataAccess();
    
    public ManagerExpView()
    {

        setTitle("Expense List");
        setBounds(100, 100, 750, 550);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        Vector<String> columnNames = new Vector<>();
        columnNames.add("Request No.");
        columnNames.add("Employee Name");
        columnNames.add("Department");
        columnNames.add("Date");
        columnNames.add("Status");
        
        Vector<Vector<Object>> data = database.getExpenseRequests();
        
        DefaultTableModel model = new DefaultTableModel(data, columnNames) 
        {
            @Override
            public boolean isCellEditable(int row, int column) 
            {
                return column == 4;
            }
        };
        
        expenseTable = new JTable(model);
        expenseTable.setEnabled(false);
        expenseTable.addMouseListener(this);
        JScrollPane scrollPane = new JScrollPane(expenseTable);
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
            new ManagerPage();
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) 
    {
        if (e.getSource() == expenseTable) 
        {
            int row = expenseTable.rowAtPoint(e.getPoint());
            int col = expenseTable.columnAtPoint(e.getPoint());
            
            if (col == 0) 
            {
                int requestId = Integer.parseInt(expenseTable.getValueAt(row, 0).toString());
                Vector<Object> rowData = database.getExpenseRequestById(requestId);

                if (rowData != null) 
                {

                    GetSetEmployee employee = new GetSetEmployee();
                    
                    employee.setRequestId((int) rowData.get(0));
                    employee.setName(rowData.get(1).toString());
                    employee.setEmployeeId(rowData.get(2).toString());
                    employee.setEmail(rowData.get(3).toString());
                    employee.setRequestDate((Date) rowData.get(4));
                    employee.setProjName(rowData.get(5).toString());
                    employee.setDepartment(rowData.get(6).toString());
                    employee.setdateEnd((Date) rowData.get(7));
                    employee.setAmount((int)rowData.get(8));
                    employee.setNotes(rowData.get(9).toString());
                    employee.setInitiation((boolean) rowData.get(10));
                    employee.setPlanning((boolean) rowData.get(11));
                    employee.setExecution((boolean) rowData.get(12));
                    employee.setPerform((boolean) rowData.get(13));
                    employee.setClosure((boolean) rowData.get(14));
                    employee.setSummary(rowData.get(15).toString());
                    employee.setStatus(rowData.get(16).toString());
                    
                        
                            ManConfirmExp expenseForm = new ManConfirmExp(employee);
                            expenseForm.setVisible(true);
                            
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
