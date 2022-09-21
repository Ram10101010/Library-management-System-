package javanew;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import javax.swing.event.AncestorEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDayChooser;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JYearChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class issueBookDetails extends JFrame {

	private JPanel contentPane;
	public JTable table;
	public JDateChooser issue_date;
	public JDateChooser return_date;
	public JComboBox St_choice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					issueBookDetails frame = new issueBookDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public issueBookDetails() {
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				setIssueDetailintoTable();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 20, 1111, 723);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setLocation(0, 0);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 50, 204));
		panel.setBounds(0, 0, 1095, 297);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(397, 11, 100, 100);
		lblNewLabel.setIcon(new ImageIcon("D:\\project\\icones\\AddNewBookIcons\\icons8_Literature_100px_1.png"));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("records Books Details ");
		lblNewLabel_1.setBounds(507, 43, 170, 42);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(148, 0, 211));
		lblNewLabel_1.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(255, 255, 255)));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 16));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(385, 107, 292, 14);
		lblNewLabel_2.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(255, 255, 255)));
		panel.add(lblNewLabel_2);
		
		
		
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(0, 0, 53, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LHomepage home = new LHomepage();
				home.setVisible(true);
				dispose();
			}
		});
		
		
		btnNewButton.setBackground(new Color(148, 0, 211));
		btnNewButton.setIcon(new ImageIcon("D:\\project\\icones\\AddNewBookIcons\\icons8_Rewind_48px.png"));
		panel.add(btnNewButton);
		
		issue_date = new JDateChooser();
		issue_date.setBounds(238, 191, 170, 23);
		panel.add(issue_date);
		
		return_date = new JDateChooser();
		return_date.setBounds(517, 191, 170, 23);
		panel.add(return_date);
		
		JLabel iss_date = new JLabel("Issue Date : ");
		iss_date.setBounds(238, 162, 162, 23);
		iss_date.setForeground(new Color(255, 255, 255));
		iss_date.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(iss_date);
		
		JLabel ret_date = new JLabel("Return Date : ");
		ret_date.setBounds(517, 162, 162, 23);
		ret_date.setForeground(Color.WHITE);
		ret_date.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(ret_date);
		
		JButton btnNewButton_1 = new JButton("SEARCH");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClearTable();
				Search();
			}
		});
		btnNewButton_1.setBounds(476, 250, 112, 36);
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(255, 127, 80));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(btnNewButton_1);
		
		St_choice = new JComboBox();
		St_choice.setForeground(new Color(72, 61, 139));
		St_choice.setFont(new Font("Tahoma", Font.BOLD, 12));
		St_choice.setModel(new DefaultComboBoxModel(new String[] {"ALL", "Returned", "panding"}));
		St_choice.setBounds(757, 184, 131, 30);
		panel.add(St_choice);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(112, 128, 144));
		scrollPane.setFont(new Font("Tahoma", Font.BOLD, 14));
		scrollPane.setForeground(new Color(255, 255, 255));
		scrollPane.setBounds(80, 353, 935, 263);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setBackground(new Color(153, 50, 204));
		table.setForeground(new Color(255, 255, 255));
		scrollPane.setViewportView(table);
	}
	
	// For show Issue data in Table
    String books_name,Student_namee;
    String returnDate,issueDate;
    DefaultTableModel model = new DefaultTableModel();
    //private JTable table;
    
    public void setIssueDetailintoTable() 
    {
    	try {
    		 Connection con = DbConnection.GetConnection();
    		 java.sql.Statement st = con.createStatement();
    		 ResultSet rs = st.executeQuery("select * from  `issuebook1` ");
    		 
    		 
    		 
    		 while(rs.next()) //`book_id`, `book_name`, `auther_name`, `quantity`
    		 {
    			 String books_id = rs.getString("id");
    			 String books_name = rs.getString("book_name");
    			 String Student_namee = rs.getString("s_name");
    			 String issueDate = rs.getString("issue_date");
    			 String returnDate = rs.getString("return_date");
    			 String statue = rs.getString("status");
    			 
    			 Object [] col = {"id","Book_Name","Student_Name","Issue Date","Return Date","Status"}; 
    			 Object [] Table = {books_id,books_name,Student_namee,issueDate,returnDate,statue};
    			 model = (DefaultTableModel) table.getModel();
    			 model.setColumnIdentifiers(col);
    			 model.addRow(Table);
    			 
    		 }
    		 
    	}
    	catch(Exception e)
    	{
    		JOptionPane.showMessageDialog(this,"Error"+e);
    	}
    }
    
    // Clear Table 
    public void ClearTable()
	{
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setRowCount(0);
	}
    // Search by date & return or allocated Book 
    public void Search()
    {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String issue = sdf.format(issue_date.getDate());		// Issue Date 
        
        String returnb = sdf.format(return_date.getDate());		//Get Return Date
        
        String Status = St_choice.getSelectedItem().toString();
        
        try 
        {
        	Connection con = DbConnection.GetConnection();
        	if(Status =="ALL")
        	{
        		String sql = "SELECT * FROM `issuebook1` WHERE  issue_date BETWEEN ? AND ?";
            	try (PreparedStatement pst = con.prepareStatement(sql))
            	{
            		pst.setString(1, issue);
            		pst.setString(2, returnb);
            		
            		ResultSet rs = pst.executeQuery();
            		
            		if(rs.next() == false)
            		{
            			JOptionPane.showMessageDialog(this,"No Record Found ");
            		}
            		else
            		{
            			while(rs.next())
                		{
        	        		 String books_id = rs.getString("id");
        	       			 String books_name = rs.getString("book_name");
        	       			 String Student_namee = rs.getString("s_name");
        	       			 String issueDate = rs.getString("issue_date");
        	       			 String returnDate = rs.getString("return_date");
        	       			 String statue = rs.getString("status");
        	       			 
        	       			 Object [] Table = {books_id,books_name,Student_namee,issueDate,returnDate,statue};
        	    			 model = (DefaultTableModel) table.getModel();
        	    			 model.addRow(Table);
                		}
            		}
            	}
        	}
            else
            {
            	String sql = "SELECT * FROM `issuebook1` WHERE status = ? AND issue_date BETWEEN ? AND ?";
            	try (PreparedStatement pst = con.prepareStatement(sql))
            	{
            		pst.setString(1, Status);
            		pst.setString(2, issue);
            		pst.setString(3, returnb);
            		
            		ResultSet rs = pst.executeQuery();
            		
            		if(rs.next() == false)
            		{
            			JOptionPane.showMessageDialog(this,"No Record Found ");
            		}
            		else
            		{
            			while(rs.next())
                		{
        	        		 String books_id = rs.getString("id");
        	       			 String books_name = rs.getString("book_name");
        	       			 String Student_namee = rs.getString("s_name");
        	       			 String issueDate = rs.getString("issue_date");
        	       			 String returnDate = rs.getString("return_date");
        	       			 String statue = rs.getString("status");
        	       			 
        	       			 Object [] Table = {books_id,books_name,Student_namee,issueDate,returnDate,statue};
        	    			 model = (DefaultTableModel) table.getModel();
        	    			 model.addRow(Table);
                		}
            		}
            	}
            	catch(Exception e)
            	{
            		JOptionPane.showMessageDialog(this," Error is present in Database Connection ");
            	}
            }	
        	
        }
        catch(Exception e)
        {
        	JOptionPane.showMessageDialog(this, e);
        }
    }
}
