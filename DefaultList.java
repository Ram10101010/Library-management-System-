package javanew;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DefaultList extends JFrame {

	private JPanel contentPane;
	private JTable Default_table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DefaultList frame = new DefaultList();
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
	public DefaultList() {
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				DefaultTable();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 20, 1111, 723);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(153, 50, 204));
		panel.setBounds(0, 0, 1095, 297);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\project\\icones\\adminIcons\\male_user_50px.png"));
		lblNewLabel.setBounds(463, 93, 73, 74);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Default List ");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_1.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(255, 255, 255)));
		lblNewLabel_1.setBackground(new Color(148, 0, 211));
		lblNewLabel_1.setBounds(520, 115, 170, 42);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(255, 255, 255)));
		lblNewLabel_2.setBounds(414, 178, 292, 14);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LHomepage home = new LHomepage();
				home.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon("D:\\project\\icones\\AddNewBookIcons\\icons8_Rewind_48px.png"));
		btnNewButton.setBackground(new Color(148, 0, 211));
		btnNewButton.setBounds(0, 0, 78, 29);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(72, 374, 946, 272);
		contentPane.add(scrollPane);
		
		Default_table = new JTable();
		scrollPane.setViewportView(Default_table);
	}
	// For show data in Table
    String Student_name,Depertment,course;
    int Student_id;
    DefaultTableModel model = new DefaultTableModel();
   
    public void DefaultTable()  
    {
    	long l = System.currentTimeMillis();
    	
    	Date today = new Date(l);
    	try 
    	{
    		 Connection con = DbConnection.GetConnection();
    		 String sql = "SELECT * FROM `issuebook1` WHERE return_date < ? AND status = ?";
         	try (PreparedStatement pst = con.prepareStatement(sql))
         	{
         		pst.setDate(1, today);
         		pst.setString(2, "panding");
         		
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
     	       			 
     	       			 Object [] col = {"id","Book_Name","Student_Name","Issue Date","Return Date","Status"}; 
     	       			 Object [] Table = {books_id,books_name,Student_namee,issueDate,returnDate,statue};
     	    			 model = (DefaultTableModel) Default_table.getModel();
     	    			 model.setColumnIdentifiers(col);
     	    			 model.addRow(Table);
             		}
         		}
         	}
         	catch(Exception e)
         	{
         		JOptionPane.showMessageDialog(this," Error is present in Database Connection ");
         	}
    		 
    	}
    	catch(Exception e)
    	{
    		JOptionPane.showMessageDialog(this,"Error"+e);
    	}
    }
 
}
