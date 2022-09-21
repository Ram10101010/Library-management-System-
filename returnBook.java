

// Return issue 
package javanew;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.text.SimpleDateFormat;
import java.util.Calendar;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Date; 

import com.toedter.calendar.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class returnBook extends JFrame {

	private JPanel contentPane;
	private JTextField B_name;
	private JTextField issue_id;
	private JTextField Student_name;
	private JTextField issue_date;
	private JTextField return_date;
	private JTextField book_idd;
	private JTextField student_idd;
	private  JLabel issue_D_Nfound;
	private JLabel status;
	private JTextField BookCount;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					returnBook frame = new returnBook();
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
	public returnBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 20, 1110, 740);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(70, 130, 180));
		panel_2.setBounds(788, 0, 306, 701);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel B_detail_1_1 = new JLabel("    Return Book");
		B_detail_1_1.setBounds(101, 193, 161, 21);
		B_detail_1_1.setForeground(new Color(255, 153, 0));
		B_detail_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		B_detail_1_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(153, 50, 204)));
		B_detail_1_1.setBackground(new Color(255, 153, 0));
		B_detail_1_1.setAutoscrolls(true);
		panel_2.add(B_detail_1_1);
		
		JLabel Bookid_1 = new JLabel("Book Id          :");
		Bookid_1.setBounds(23, 326, 108, 21);
		Bookid_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_2.add(Bookid_1);
		
		book_idd = new JTextField();
		book_idd.setBounds(132, 328, 153, 20);
		book_idd.setColumns(10);
		book_idd.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0,0)));
		book_idd.setBackground(new Color(70,130,180));
		panel_2.add(book_idd);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(37, 166, 73, 64);
		lblNewLabel_2.setIcon(new ImageIcon("D:\\project\\icones\\AddNewBookIcons\\icons8_Books_52px_1.png"));
		panel_2.add(lblNewLabel_2);
		
		JLabel S_id_1 = new JLabel("Student Id   :");
		S_id_1.setBounds(23, 388, 103, 21);
		S_id_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_2.add(S_id_1);
		
		student_idd = new JTextField();
		student_idd.setBounds(132, 390, 153, 20);
	
		student_idd.setColumns(10);
		student_idd.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		student_idd.setBackground(new Color(70,130,180));
		panel_2.add(student_idd);
		
		JButton btnNewButton = new JButton("Return Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(returndBook() == true)
				{
					UpdateBookCount();
					JOptionPane.showMessageDialog(null,"SuccessFully Returnd this book  ");
				}
				else {
					JOptionPane.showMessageDialog(null,"Tile It is Not Returned ");
					
				}
			}
		});
		btnNewButton.setBounds(98, 562, 141, 39);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_2.add(btnNewButton);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getIssueBookdetails();
			}
			
		});
		btnFind.setBounds(98, 491, 141, 39);
		btnFind.setForeground(Color.WHITE);
		btnFind.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnFind.setBackground(new Color(0, 0, 128));
		panel_2.add(btnFind);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(469, 0, 320, 720);
		contentPane.add(panel_1);
		panel_1.setForeground(new Color(240, 248, 255));
		panel_1.setBackground(new Color(102, 51, 153));
		panel_1.setLayout(null);
		
		JLabel S_id = new JLabel("Id :");
		S_id.setForeground(Color.WHITE);
		S_id.setFont(new Font("Tahoma", Font.BOLD, 14));
		S_id.setBounds(31, 275, 118, 21);
		panel_1.add(S_id);
		
		issue_id = new JTextField();
		issue_id.setForeground(Color.WHITE);
		issue_id.setColumns(10);
		issue_id.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		issue_id.setBackground(new Color(102,51,153));
		issue_id.setBounds(137, 277, 153, 20);
		panel_1.add(issue_id);
		
		JLabel S_name = new JLabel("Student Name :");
		S_name.setForeground(Color.WHITE);
		S_name.setFont(new Font("Tahoma", Font.BOLD, 14));
		S_name.setBounds(31, 387, 115, 30);
		panel_1.add(S_name);
		
		Student_name = new JTextField();
		Student_name.setForeground(Color.WHITE);
		Student_name.setColumns(10);
		Student_name.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		Student_name.setBackground(new Color(102, 51, 153));
		Student_name.setBounds(156, 394, 153, 20);
		panel_1.add(Student_name);
		
		issue_date = new JTextField();
		issue_date.setForeground(Color.WHITE);
		issue_date.setColumns(10);
		issue_date.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		issue_date.setBackground(new Color(102, 51, 153));
		issue_date.setBounds(137, 455, 146, 20);
		panel_1.add(issue_date);
		
		return_date = new JTextField();
		return_date.setForeground(Color.WHITE);
		return_date.setColumns(10);
		return_date.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		return_date.setBackground(new Color(102, 51, 153));
		return_date.setBounds(137, 515, 153, 20);
		panel_1.add(return_date);
		
		issue_D_Nfound = new JLabel();
		issue_D_Nfound.setForeground(Color.WHITE);
		issue_D_Nfound.setFont(new Font("Tahoma", Font.BOLD, 14));
		issue_D_Nfound.setBounds(31, 614, 259, 71);
		panel_1.add(issue_D_Nfound);
		
		JLabel S_id_1_1 = new JLabel("Issue Date :");
		S_id_1_1.setBounds(31, 453, 118, 21);
		panel_1.add(S_id_1_1);
		S_id_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel S_id_1_1_1 = new JLabel("Return Date :");
		S_id_1_1_1.setBounds(31, 514, 118, 21);
		panel_1.add(S_id_1_1_1);
		S_id_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel bookname = new JLabel("Book Name      :");
		bookname.setBounds(24, 338, 115, 30);
		panel_1.add(bookname);
		bookname.setForeground(Color.WHITE);
		bookname.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		B_name = new JTextField();
		B_name.setBounds(136, 329, 174, 39);
		panel_1.add(B_name);
		B_name.setForeground(Color.WHITE);
		B_name.setColumns(10);
		B_name.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		B_name.setBackground(new Color(102,51,153));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(107, 81, 106, 112);
		panel_1.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("D:\\project\\icones\\AddNewBookIcons\\icons8_Literature_100px_1.png"));
		
		JLabel B_detail = new JLabel("         Book Details ");
		B_detail.setBounds(64, 204, 190, 21);
		panel_1.add(B_detail);
		B_detail.setForeground(Color.WHITE);
		B_detail.setFont(new Font("Tahoma", Font.BOLD, 17));
		B_detail.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.WHITE));
		B_detail.setAutoscrolls(true);
		
		JLabel status_N = new JLabel("Status     :");
		status_N.setFont(new Font("Tahoma", Font.BOLD, 14));
		status_N.setBounds(31, 562, 88, 21);
		panel_1.add(status_N);
		
		status = new JLabel("");
		status.setForeground(Color.WHITE);
		status.setFont(new Font("Tahoma", Font.BOLD, 15));
		status.setBounds(137, 567, 117, 21);
		panel_1.add(status);
		
		// BookCount 
		BookCount = new JTextField();
		BookCount.setForeground(Color.WHITE);
		BookCount.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0,0)));
		BookCount.setFont(new Font("Tahoma", Font.BOLD, 15));
		BookCount.setBounds(137,600 , 150, 30);
		panel_1.add(BookCount);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(0, 0, 470, 701);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\project\\icones\\icons\\library-3.png.png"));
		lblNewLabel_1.setBounds(-34, 23, 504, 678);
		panel.add(lblNewLabel_1);
		
		JLabel back = new JLabel("");
		back.setForeground(new Color(0, 0, 255));
		back.setBounds(0, 11, 33, 21);
		panel.add(back);
		back.setBackground(new Color(72, 61, 139));
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LHomepage ho = new LHomepage();
				ho.setVisible(true);
				dispose();
			}
		});
		back.setIcon(new ImageIcon("D:\\project\\icones\\AddNewBookIcons\\icons8_Rewind_48px.png"));
	}
	
	
	
	// Check the input is valid or not or any filed empty or not 
	 public boolean validateIssueBook()
	    {
		 	String Book_id = book_idd.getText();
	        String student_id = student_idd.getText();
	        
	      
	        
	      
	        
	        if(Book_id.equals(""))
	        {   
	            JOptionPane.showMessageDialog(this,"please Enter valid Book Id ");
	            return false;
	        }
	        if(student_id.equals(""))
	        {   
	            JOptionPane.showMessageDialog(this,"please Enter valid Book Name ");
	            return false;
	        }
	       
	        return true;
	    }
	// Insert book details in to data base 
	
	public void BOOKCOUNT()
	{
		 String Book_id1 = book_idd.getText();
		// For Showing the  NO Books 
				 try {
					 Connection con = DbConnection.GetConnection();
					 String sql = "SELECT `quantity` FROM `managebooks` WHERE `book_id` = ?"; // 
					 try(PreparedStatement pst = con.prepareStatement(sql))
					{
						pst.setString(1,Book_id1);
						
						ResultSet rs = pst.executeQuery();
						
						if(rs.next())
						{
							BookCount.setText(rs.getString("quantity"));
							JOptionPane.showMessageDialog(this,"Book Cuantity Updated :");
						}
						else 
							JOptionPane.showMessageDialog(this,"Book Cuantity is not Updated :");
						
					}
				 }
				 catch(Exception e)
				 {
					 JOptionPane.showMessageDialog(this,e);
				 }
	}
	public void UpdateBookCount()
	{
		 String Book_id1 = book_idd.getText();
		 
		 int BC = Integer.parseInt(BookCount.getText());
		 
		 try {
			 Connection con = DbConnection.GetConnection();
			 
			 String sql = "UPDATE `managebooks` SET `quantity` = ?  WHERE `book_id` = ? ";
			 
			 try(PreparedStatement pst = con.prepareStatement(sql)) 
			 {
				 pst.setInt(1,BC+1);
				 pst.setString(2, Book_id1);
				 
				 int rowCount = pst.executeUpdate();
				 
				 System.out.println("Update Row Count = "+rowCount);
				 if(rowCount >= 1)
				 {
					 JOptionPane.showMessageDialog(this,"Book Count Update ");
				 }
				 else 
					 JOptionPane.showMessageDialog(this," Can't Update Book Count");
			 }
			 catch(Exception e)
			 {
				 JOptionPane.showMessageDialog(this,e);
			 }
		 }
		 catch(Exception e) {
		 	JOptionPane.showMessageDialog(this,"ERROR");
		 }
	}
	
	/*public boolean CBookStudent()
	{
		boolean CBookStudent = false;
		int Book_id = Integer.parseInt(book_idd.getText());  // Book Id 
        int student_id = Integer.parseInt(student_idd.getText()); // Student ID 
        
        try {
        	Connection con = DbConnection.GetConnection();
        	//`id`, `b_id`, `book_name`, `s_id`, `s_name`, `issue_date`, `return_date`, `status`
        	String sql = "SELECT * FROM `issuebook1` WHERE b_id = ? AND s_id = ? AND status = ?";
        	
        	 try(PreparedStatement pst = con.prepareStatement(sql)) 
        	{
        		pst.setInt(1, Book_id);
        		pst.setInt(2, student_id);
        		pst.setString(3, "Pending");
        		
        		ResultSet rs = pst.executeQuery();
        		
        		if(rs.next())
        			CBookStudent = true;
        		else
        			CBookStudent = false;
        	}
        }
		catch (Exception e)
        {
			JOptionPane.showMessageDialog(this,e);
        }
        return CBookStudent;
	}*/
	
	//for finding the student and book id and name also and show 
	public void getIssueBookdetails()
	{
		int book_id = Integer.parseInt(book_idd.getText());
		int student_id = Integer.parseInt(student_idd.getText());
		
		try
		{
			Connection con = DbConnection.GetConnection();
			//SELECT `id`, `b_id`, `book_name`, `s_id`, `s_name`, `issue_date`, `return_date`, `status` FROM `issuebook1` WHERE 1
			String sql = " SELECT * FROM issuebook1 WHERE b_id = ? AND s_id = ? AND status = ?";
			
			try(PreparedStatement pst = con.prepareStatement(sql))
			{
				pst.setInt(1,book_id);
				pst.setInt(2, student_id);
				pst.setString(3,"panding");
				
				ResultSet rs = pst.executeQuery();
				
				if(rs.next())
				{
					issue_id.setText(rs.getString("id"));
					B_name.setText(rs.getString("book_name"));
					Student_name.setText(rs.getString("s_name"));
					issue_date.setText(rs.getString("issue_date"));
					return_date.setText(rs.getString("return_date"));
					status.setText(rs.getString("status"));
					issue_D_Nfound.setText("");
				}
				else
				{
					issue_D_Nfound.setText("In this book id or Student have not any borrow book ");

					issue_id.setText(" ");
					B_name.setText(" ");
					Student_name.setText(" ");
					issue_date.setText(" ");
					return_date.setText(" ");
					status.setText(" ");
				}
			}catch(Exception e)
			{
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(this,e);
		}
	}
	// After returned  book the status must  be change 
	public boolean returndBook()
	{
		boolean isReturnd = false;
		
		String Book_id = book_idd.getText();
		String Student_id = student_idd.getText();
		
		try
		{
			Connection con = DbConnection.GetConnection();

			String sql = "UPDATE `issuebook1` SET `status`=? WHERE  `b_id` = ? AND `s_id` = ? ";
			
			try(PreparedStatement pst = con.prepareStatement(sql))
			{
				pst.setString(1, "Returned");
				pst.setString(2, Book_id);
				pst.setString(3, Student_id);
				
				int rowCount = pst.executeUpdate();
				System.out.println("Row Count = "+rowCount);
				if(rowCount >= 1)
				{
					isReturnd = true;
				}
				else
					isReturnd = false;
			}
			catch(Exception e)
			{
				JOptionPane.showConfirmDialog(this, e);
			}
		}
		catch (Exception e) {
			JOptionPane.showConfirmDialog(this, e);
		}
		
		return isReturnd;
	}
}