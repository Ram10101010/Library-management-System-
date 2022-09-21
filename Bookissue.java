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

public class Bookissue extends JFrame {

	private JPanel contentPane;
	private JTextField B_id;
	private JTextField B_name;
	private JTextField author_namee;
	private JTextField Quantity;
	private JTextField Student_id;
	private JTextField Student_name;
	private JTextField Depertment;
	private JTextField Course_name;
	private JTextField book_idd;
	private JTextField student_idd;
	public JDateChooser issue_date;
	private JDateChooser return_date;
	private JLabel Book_D_error;
	private  JLabel Student_D_error;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bookissue frame = new Bookissue();
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
	public Bookissue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 20, 1110, 740);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 51, 153));
		panel.setBounds(0, 0, 320, 720);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel B_detail = new JLabel("         Book Details ");
		B_detail.setBounds(67, 161, 190, 21);
		B_detail.setForeground(Color.WHITE);
		B_detail.setFont(new Font("Tahoma", Font.BOLD, 17));
		B_detail.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.WHITE));
		B_detail.setAutoscrolls(true);
		panel.add(B_detail);
		
		JLabel Bookid = new JLabel("Book Id            :");
		Bookid.setBounds(34, 222, 118, 21);
		Bookid.setForeground(Color.WHITE);
		Bookid.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(Bookid);
		
		B_id = new JTextField();
		B_id.setBounds(146, 224, 135, 20);
		B_id.setForeground(Color.WHITE);
		B_id.setBackground(new Color(153, 51, 153));
		B_id.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		panel.add(B_id);
		B_id.setColumns(10);
		
		JLabel bookname = new JLabel("Book Name      :");
		bookname.setBounds(34, 278, 115, 30);
		bookname.setForeground(Color.WHITE);
		bookname.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(bookname);
		
		B_name = new JTextField();
		B_name.setBounds(146, 269, 174, 39);
		B_name.setForeground(Color.WHITE);
		B_name.setColumns(10);
		B_name.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		B_name.setBackground(new Color(153, 51, 153));
		panel.add(B_name);
		
		JLabel lblNewLabel_1_1 = new JLabel("Quantity          :");
		lblNewLabel_1_1.setBounds(34, 393, 125, 30);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblNewLabel_1_1);
		
		JLabel author = new JLabel("Author Name  :");
		author.setBounds(34, 343, 106, 21);
		author.setForeground(Color.WHITE);
		author.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(author);
		
		author_namee = new JTextField();
		author_namee.setBounds(146, 345, 135, 20);
		author_namee.setForeground(Color.WHITE);
		author_namee.setColumns(10);
		author_namee.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		author_namee.setBackground(new Color(153, 51, 153));
		panel.add(author_namee);
		
		Quantity = new JTextField();
		Quantity.setBounds(146, 400, 153, 20);
		Quantity.setForeground(Color.WHITE);
		Quantity.setColumns(10);
		Quantity.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		Quantity.setBackground(new Color(153, 51, 153));
		panel.add(Quantity);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(110, 38, 106, 112);
		lblNewLabel.setIcon(new ImageIcon("D:\\project\\icones\\AddNewBookIcons\\icons8_Literature_100px_1.png"));
		panel.add(lblNewLabel);
		
		JLabel back = new JLabel("");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LHomepage ho = new LHomepage();
				ho.setVisible(true);
				dispose();
			}
		});
		back.setBounds(0, 5, 33, 21);
		back.setIcon(new ImageIcon("D:\\project\\icones\\AddNewBookIcons\\icons8_Rewind_48px.png"));
		panel.add(back);
		
		Book_D_error = new JLabel();
		Book_D_error.setForeground(Color.WHITE);
		Book_D_error.setFont(new Font("Tahoma", Font.BOLD, 14));
		Book_D_error.setBounds(49, 464, 232, 30);
		panel.add(Book_D_error);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(240, 248, 255));
		panel_1.setBackground(new Color(102, 51, 153));
		panel_1.setBounds(319, 0, 320, 720);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel B_detail_1 = new JLabel("  Students Details ");
		B_detail_1.setForeground(Color.WHITE);
		B_detail_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		B_detail_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(153, 50, 204)));
		B_detail_1.setBackground(Color.WHITE);
		B_detail_1.setAutoscrolls(true);
		B_detail_1.setBounds(97, 150, 161, 21);
		panel_1.add(B_detail_1);
		
		JLabel S_id = new JLabel("Student Id     :");
		S_id.setForeground(Color.WHITE);
		S_id.setFont(new Font("Tahoma", Font.BOLD, 14));
		S_id.setBounds(31, 219, 118, 21);
		panel_1.add(S_id);
		
		Student_id = new JTextField();
		Student_id.setForeground(Color.WHITE);
		Student_id.setColumns(10);
		Student_id.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		Student_id.setBackground(new Color(75, 0, 130));
		Student_id.setBounds(137, 221, 153, 20);
		panel_1.add(Student_id);
		
		JLabel S_name = new JLabel("Student Name :");
		S_name.setForeground(Color.WHITE);
		S_name.setFont(new Font("Tahoma", Font.BOLD, 14));
		S_name.setBounds(31, 270, 115, 30);
		panel_1.add(S_name);
		
		Student_name = new JTextField();
		Student_name.setForeground(Color.WHITE);
		Student_name.setColumns(10);
		Student_name.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		Student_name.setBackground(new Color(102, 51, 153));
		Student_name.setBounds(157, 277, 153, 20);
		panel_1.add(Student_name);
		
		JLabel Depertment_name = new JLabel("Depertment     :");
		Depertment_name.setForeground(Color.WHITE);
		Depertment_name.setFont(new Font("Tahoma", Font.BOLD, 14));
		Depertment_name.setBounds(31, 322, 118, 21);
		panel_1.add(Depertment_name);
		
		Depertment = new JTextField();
		Depertment.setForeground(Color.WHITE);
		Depertment.setColumns(10);
		Depertment.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		Depertment.setBackground(new Color(102, 51, 153));
		Depertment.setBounds(144, 324, 146, 20);
		panel_1.add(Depertment);
		
		JLabel c_name = new JLabel("Course  :");
		c_name.setForeground(Color.WHITE);
		c_name.setFont(new Font("Tahoma", Font.BOLD, 14));
		c_name.setBounds(31, 391, 115, 30);
		panel_1.add(c_name);
		
		Course_name = new JTextField();
		Course_name.setForeground(Color.WHITE);
		Course_name.setColumns(10);
		Course_name.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		Course_name.setBackground(new Color(102, 51, 153));
		Course_name.setBounds(137, 398, 153, 20);
		panel_1.add(Course_name);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\project\\icones\\AddNewBookIcons\\icons8_Student_Registration_100px_2.png"));
		lblNewLabel_1.setBounds(121, 39, 115, 100);
		panel_1.add(lblNewLabel_1);
		
		Student_D_error = new JLabel();
		Student_D_error.setForeground(Color.WHITE);
		Student_D_error.setFont(new Font("Tahoma", Font.BOLD, 14));
		Student_D_error.setBounds(31, 468, 256, 30);
		panel_1.add(Student_D_error);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(639, 0, 456, 701);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel B_detail_1_1 = new JLabel("  Students Details ");
		B_detail_1_1.setForeground(new Color(255, 153, 0));
		B_detail_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		B_detail_1_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(153, 50, 204)));
		B_detail_1_1.setBackground(new Color(255, 153, 0));
		B_detail_1_1.setAutoscrolls(true);
		B_detail_1_1.setBounds(206, 118, 161, 21);
		panel_2.add(B_detail_1_1);
		
		JLabel Bookid_1 = new JLabel("Book Id          :");
		Bookid_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		Bookid_1.setBounds(97, 223, 108, 21);
		panel_2.add(Bookid_1);
		
		book_idd = new JTextField();
		book_idd.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!book_idd.getText().equals(" "))
					getBookDetails();
			}
		});
		book_idd.setColumns(10);
		book_idd.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		book_idd.setBackground(Color.WHITE);
		book_idd.setBounds(206, 225, 153, 20);
		panel_2.add(book_idd);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\project\\icones\\AddNewBookIcons\\icons8_Books_52px_1.png"));
		lblNewLabel_2.setBounds(142, 91, 73, 64);
		panel_2.add(lblNewLabel_2);
		
		JLabel S_id_1 = new JLabel("Student Id   :");
		S_id_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		S_id_1.setBounds(97, 285, 103, 21);
		panel_2.add(S_id_1);
		
		student_idd = new JTextField();
		student_idd.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!student_idd.getText().equals(" "))
					getStudentDetails();
			}
		});
		student_idd.setColumns(10);
		student_idd.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		student_idd.setBackground(Color.WHITE);
		student_idd.setBounds(206, 287, 153, 20);
		panel_2.add(student_idd);
		
		issue_date = new JDateChooser();
		issue_date.setBounds(206, 346, 184, 27);
		panel_2.add(issue_date);
		
		JLabel S_id_1_1 = new JLabel("Issue Date :");
		S_id_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		S_id_1_1.setBounds(97, 346, 118, 21);
		panel_2.add(S_id_1_1);
		
		JLabel S_id_1_1_1 = new JLabel("Return Date :");
		S_id_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		S_id_1_1_1.setBounds(97, 407, 118, 21);
		panel_2.add(S_id_1_1_1);
		
		return_date = new JDateChooser();
		return_date.setBounds(206, 407, 184, 27);
		panel_2.add(return_date);
		
		JButton btnNewButton = new JButton("Issue Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validateIssueBook() == true)
				{
					if(CBookStudent() == false)
					{
						//setBookDetailintoTable();
						BookIssueDetails();
						UpdateBookCount();
					}
					else {
						JOptionPane.showMessageDialog(null,"This Student Already Have this Book ");
				  	
					}
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(195, 549, 141, 39);
		panel_2.add(btnNewButton);
	}
	
	public void getBookDetails()
	{
		int bookID = Integer.parseInt(book_idd.getText());
		
		try {
			
			Connection con = DbConnection.GetConnection();
			
			String sql = "SELECT * FROM `managebooks` WHERE `book_id` = ?";
			try(PreparedStatement  p = con.prepareStatement(sql))
			{
			
				p.setInt(1,bookID);
				
				ResultSet r = p.executeQuery();
				
				if(r.next())
				{
					B_id.setText(r.getString("book_id"));
					B_name.setText(r.getString("book_name"));
					author_namee.setText(r.getString("auther_name"));
					Quantity.setText(r.getString("quantity"));
					Book_D_error.setText(" ");
				}
				else {
					Book_D_error.setText("Invalid Book ID ***");
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void getStudentDetails()
	{
		String StudentID = student_idd.getText();
		
		try {
			Connection con = DbConnection.GetConnection();
			
			PreparedStatement  p = con.prepareStatement("SELECT * FROM `managestudent` WHERE S_id = ?");
			
			p.setString(1,StudentID);
			
			ResultSet r = p.executeQuery();
			// System.out.println(r.next());
			if(r.next())
			{
				Student_id.setText(r.getString("S_id"));
				Student_name.setText(r.getString("S_name"));
				Depertment.setText(r.getString("S_add"));
				Course_name.setText(r.getString("course"));
				Student_D_error.setText(" ");
			}
			else 
				Student_D_error.setText("Invalid Student ID ***");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	// Check the input is valid or not or any filed empty or not 
	 public boolean validateIssueBook()
	    {
		 	String Book_id = book_idd.getText();
	        String student_id = student_idd.getText();
	        
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        String issue = sdf.format(issue_date.getDate());		// Issue Date 
	        
	        String returnb = sdf.format(return_date.getDate());		//Get Return Date
	        
	        int Bookquantity = Integer.parseInt(Quantity.getText());
	        
	        if(Bookquantity == 0)
	        {
	        	JOptionPane.showMessageDialog(this, "Book Is Not Available ");
	        	return false;
	        }
	        
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
	        if(issue.equals(""))
	        {   
	            JOptionPane.showMessageDialog(this,"please Enter Auther Name  ");
	            return false;
	        }
	        if(returnb.equals(""))
	        {   
	            JOptionPane.showMessageDialog(this,"please Enter Quantity");
	            return false;
	        }
	        return true;
	    }
	// Insert book details in to data base 
	public void BookIssueDetails()      // Issue Book Details   
    {
		
        String Book_id = book_idd.getText();
        String Book_name = B_name.getText();
        String student_id = student_idd.getText();
        String S_name = Student_name.getText();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String issue = sdf.format(issue_date.getDate());		// Issue Date 
        
        String returnb = sdf.format(return_date.getDate());		//Get Return Date
        
        try 
        {
            Connection con = DbConnection.GetConnection();
            

            String insert = "INSERT INTO `issuebook1`(`b_id`, `book_name`, `s_id`, `s_name`, `issue_date`, `return_date`, `status`) VALUES (?,?,?,?,?,?,?)";
            try(PreparedStatement pst = con.prepareStatement(insert))
            {
            	 pst.setString(1,Book_id);
            	 pst.setString(2,Book_name);
            	 pst.setString(3,student_id);
            	 pst.setString(4,S_name);
            	 pst.setString(5,issue);
            	 pst.setString(6, returnb);
            	 pst.setString(7, "panding");
            	 
            
            	int uprowcount = pst.executeUpdate(); // When the data sucessfully added in our data base then its automatically increment
            	if(uprowcount >= 1)
            	{
            		JOptionPane.showMessageDialog(this,"You have Successfully Add this Book ");
            	}
            	else
            	{	
                    JOptionPane.showMessageDialog(this,"Add Book Failure");
            	}
            // When the data successfull added in our data base then its automatically increment
            }
            Book_id = " ";
            Book_name =" ";
            
            student_id = " ";
            S_name = " ";
            issue =" ";
            returnb = " ";
        }   
        catch (HeadlessException | SQLException e) 
        {
            JOptionPane.showMessageDialog(this,"this can be Error"+e);
        }
    }
	
	public void UpdateBookCount()
	{
		 int Book_id1 = Integer.parseInt(book_idd.getText());
		 int Quantity_a = Integer.parseInt(Quantity.getText());
		 
		 try {
			 Connection con = DbConnection.GetConnection();
			 
			// String sql = "UPDATE `managebooks` SET `quantity` = ? WHERE `book_id` = ? ";
			 
			PreparedStatement pst = con.prepareStatement("UPDATE `managebooks` SET `quantity` = ? WHERE `book_id` = ?");
			
				 pst.setInt(1,Quantity_a - 1);
				 pst.setInt(2, Book_id1);
				 
				 int rowCount = pst.executeUpdate();
				 //System.out.println(rowCount);
				 if(rowCount >= 1)
				 {
					 JOptionPane.showMessageDialog(this,"Book Count Update ");
					 int bCount = Integer.parseInt(Quantity.getText());
					 Quantity.setText(Integer.toString(bCount - 1));
				 }
				 else 
					 JOptionPane.showMessageDialog(this," Can't Update Book Count");
			
			 /*catch(Exception e)
			 {
				 JOptionPane.showMessageDialog(this,e);
			 }*/
		 }
		 catch(Exception e) {
		 	JOptionPane.showMessageDialog(this,"ERROR");
		 }
	}
	
	public boolean CBookStudent()   // is already allocated or not this book 
	{
		boolean check = false;
		int Book_id =Integer.parseInt(book_idd.getText());  // Book Id 
        int student_id =Integer.parseInt(student_idd.getText()); // Student ID 
        
        try {
        	Connection con = DbConnection.GetConnection();
        	//`id`, `b_id`, `book_name`, `s_id`, `s_name`, `issue_date`, `return_date`, `status`
        	String sql = "SELECT * FROM `issuebook1` WHERE `b_id` = ? AND `s_id` = ? AND `status` = ?";
        	
        	try(PreparedStatement pst = con.prepareStatement(sql)) 
        	{
        		pst.setInt(1, Book_id);
        		pst.setInt(2, student_id);
        		pst.setString(3, "Pending");
        		
        		ResultSet rs = pst.executeQuery();
        		
        		System.out.println(rs.next());
        		if(rs.next())
        			 check = true;
        		else
        			 check = false;
        	}
        	catch(Exception e)
        	{
        		JOptionPane.showMessageDialog(this,"This error is arrive for return false ");
        	}
        }
		catch (Exception e)
        {
			JOptionPane.showMessageDialog(this,e);
        }
        return check;
	}
}
