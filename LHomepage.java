
package javanew;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import java.awt.ComponentOrientation;
import java.awt.Rectangle;
import java.awt.Point;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.UIManager;

public class LHomepage extends JFrame {

	private JPanel contentPane;
	public JTable B_table;
	private JLabel no_books;
	private JLabel no_students;
	private JLabel no_issued;
	private JLabel no_default;
	
	
	 
	Color MEnter = new Color(255, 255, 255);
	Color MExit = new Color(51,51,51);
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 LHomepage frame = new  LHomepage();
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
	public LHomepage() {
		addWindowListener(new WindowAdapter() {
				public void windowOpened(WindowEvent e) {
					setBookDetailintoTable();
					setStudentDetailintoTable();
					SetCountData();
				}
		});
		
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setAlwaysOnTop(true);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 20, 1111, 723);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 0, 255));
		panel.setForeground(new Color(75, 0, 130));
		panel.setBounds(0, 0, 1095, 36);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\project\\icones\\adminIcons\\icons8_menu_48px_1.png"));
		lblNewLabel_2.setBounds(10, 5, 37, 25);
		panel.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(60, 0, 4, 40);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Libary Management System ");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Maiandra GD", Font.BOLD, 14));
		lblNewLabel_3.setBounds(74, 5, 223, 25);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setBounds(0, 34, 224, 650);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblManageBooks = new JLabel("Manage Books  ");
		lblManageBooks.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ManageBooks mb= new ManageBooks();
				mb.setVisible(true);
				dispose();
			}
			public void mouseEntered(MouseEvent e) {
				lblManageBooks.setBackground(MEnter);;
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblManageBooks.setBackground(MExit);
			}
		});
		lblManageBooks.setHorizontalAlignment(SwingConstants.LEFT);
		lblManageBooks.setForeground(Color.WHITE);
		lblManageBooks.setFont(new Font("Maiandra GD", Font.BOLD, 14));
		lblManageBooks.setBackground(Color.WHITE);
		lblManageBooks.setBounds(78, 84, 124, 26);
		panel_1.add(lblManageBooks);
		
		JLabel lblManageStudent = new JLabel("Manage Student  ");
		lblManageStudent.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				StudentM ms = new StudentM();
				ms.setVisible(true);
				dispose();
			}
		});
		lblManageStudent.setHorizontalAlignment(SwingConstants.LEFT);
		lblManageStudent.setForeground(Color.WHITE);
		lblManageStudent.setFont(new Font("Maiandra GD", Font.BOLD, 14));
		lblManageStudent.setBackground(Color.WHITE);
		lblManageStudent.setBounds(78, 135, 124, 26);
		panel_1.add(lblManageStudent);
		
		JLabel lblNewLabel_1_1 = new JLabel("Isssue Book  ");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Bookissue Biss = new Bookissue();
				Biss.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 14));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(78, 182, 146, 36);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Return Book ");
		lblNewLabel_4_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				returnBook rb = new returnBook();
				rb.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Maiandra GD", Font.BOLD, 14));
		lblNewLabel_4_1.setBackground(Color.WHITE);
		lblNewLabel_4_1.setBounds(74, 242, 150, 36);
		panel_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("   View Records  ");
		lblNewLabel_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				issueBookDetails ib = new issueBookDetails();
				ib.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Maiandra GD", Font.BOLD, 14));
		lblNewLabel_1_2.setBackground(Color.WHITE);
		lblNewLabel_1_2.setBounds(64, 300, 160, 36);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\project\\icones\\adminIcons\\icons8_Book_Shelf_50px.png"));
		lblNewLabel_1.setBounds(28, 84, 36, 26);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setBackground(Color.PINK);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("");
		lblNewLabel_1_3_1.setIcon(new ImageIcon("D:\\project\\icones\\adminIcons\\icons8_Read_Online_26px.png"));
		lblNewLabel_1_3_1.setBackground(Color.PINK);
		lblNewLabel_1_3_1.setBounds(28, 130, 40, 26);
		panel_1.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_4 = new JLabel("");
		lblNewLabel_1_4.setIcon(new ImageIcon("D:\\project\\icones\\adminIcons\\icons8_Sell_26px.png"));
		lblNewLabel_1_4.setBackground(Color.PINK);
		lblNewLabel_1_4.setBounds(32, 192, 32, 26);
		panel_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("");
		lblNewLabel_1_4_1.setIcon(new ImageIcon("D:\\project\\icones\\adminIcons\\icons8_Return_Purchase_26px.png"));
		lblNewLabel_1_4_1.setBackground(Color.PINK);
		lblNewLabel_1_4_1.setBounds(32, 253, 32, 26);
		panel_1.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("");
		lblNewLabel_1_4_2.setIcon(new ImageIcon("D:\\project\\icones\\adminIcons\\icons8_View_Details_26px.png"));
		lblNewLabel_1_4_2.setBackground(Color.PINK);
		lblNewLabel_1_4_2.setBounds(32, 310, 32, 26);
		panel_1.add(lblNewLabel_1_4_2);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Default List ");
		lblNewLabel_4_2_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				DefaultList df = new DefaultList();
				df.setVisible(true);
				dispose();
			}
		});
		
		lblNewLabel_4_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4_2_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1.setFont(new Font("Maiandra GD", Font.BOLD, 14));
		lblNewLabel_4_2_1.setBackground(Color.WHITE);
		lblNewLabel_4_2_1.setBounds(74, 363, 128, 26);
		panel_1.add(lblNewLabel_4_2_1);
		
		JLabel lblNewLabel_1_4_2_1_1 = new JLabel("");
		lblNewLabel_1_4_2_1_1.setIcon(new ImageIcon("D:\\project\\icones\\adminIcons\\icons8_Conference_26px.png"));
		lblNewLabel_1_4_2_1_1.setBackground(Color.PINK);
		lblNewLabel_1_4_2_1_1.setBounds(32, 363, 32, 26);
		panel_1.add(lblNewLabel_1_4_2_1_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 26, 224, 36);
		panel_1.add(panel_4);
		panel_4.setBackground(new Color(255, 69, 0));
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1_3 = new JLabel("");
		lblNewLabel_1_3.setBounds(30, 5, 40, 26);
		panel_4.add(lblNewLabel_1_3);
		lblNewLabel_1_3.setIcon(new ImageIcon("D:\\project\\icones\\adminIcons\\home_24px.png"));
		lblNewLabel_1_3.setBackground(Color.PINK);
		
		JLabel lblNewLabel = new JLabel("Home page ");
		lblNewLabel.setBounds(76, 5, 138, 26);
		panel_4.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Maiandra GD", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 558, 224, 36);
		panel_1.add(panel_5);
		panel_5.setBackground(new Color(148, 0, 211));
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_1_4_2_1_1_1 = new JLabel("");
		lblNewLabel_1_4_2_1_1_1.setBounds(44, 5, 32, 26);
		panel_5.add(lblNewLabel_1_4_2_1_1_1);
		lblNewLabel_1_4_2_1_1_1.setIcon(new ImageIcon("D:\\project\\icones\\adminIcons\\icons8_Exit_26px.png"));
		lblNewLabel_1_4_2_1_1_1.setBackground(Color.PINK);
		
		JLabel lblNewLabel_4_2_1_1 = new JLabel("LogOut");
		lblNewLabel_4_2_1_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				signUp sp = new signUp();
				sp.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_4_2_1_1.setBounds(86, 5, 128, 26);
		panel_5.add(lblNewLabel_4_2_1_1);
		lblNewLabel_4_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1.setFont(new Font("Maiandra GD", Font.BOLD, 14));
		lblNewLabel_4_2_1_1.setBackground(Color.WHITE);
		
		JPanel panel_3 = new JPanel();
		panel_3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel_3.setBackground(UIManager.getColor("Button.background"));
		panel_3.setBounds(221, 34, 874, 650);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_6_0 = new JPanel();
		panel_6_0.setBackground(new Color(204, 102, 255));
		panel_6_0.setBorder(new MatteBorder(0, 0, 24, 0, (Color) new Color(153, 0, 204)));
		panel_6_0.setBounds(21, 45, 186, 113);
		panel_3.add(panel_6_0);
		panel_6_0.setLayout(null);
		
		no_books = new JLabel("10");
		no_books.setFont(new Font("Maiandra GD", Font.BOLD, 36));
		no_books.setBounds(10, 9, 63, 41);
		panel_6_0.add(no_books);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\project\\icones\\adminIcons\\icons8_Book_Shelf_50px.png"));
		lblNewLabel_4.setBounds(113, 9, 63, 56);
		panel_6_0.add(lblNewLabel_4);
		
		JLabel books = new JLabel("No of Books ");
		books.setBounds(10, 61, 166, 21);
		panel_6_0.add(books);
		books.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		
		
		JPanel panel_6_1 = new JPanel();
		panel_6_1.setBackground(new Color(255, 0, 153));
		panel_6_1.setLayout(null);
		panel_6_1.setBorder(new MatteBorder(0, 0, 25, 0, (Color) new Color(204, 0, 102)));
		panel_6_1.setBounds(245, 45, 186, 113);
		panel_3.add(panel_6_1);
		
		no_students = new JLabel("10");
		no_students.setFont(new Font("Maiandra GD", Font.BOLD, 36));
		no_students.setBounds(10, 11, 59, 41);
		panel_6_1.add(no_students);
		
		JLabel students = new JLabel("No o Students  ");
		students.setBounds(10, 63, 166, 21);
		panel_6_1.add(students);
		students.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("D:\\project\\icones\\adminIcons\\icons8_People_50px.png"));
		lblNewLabel_5.setBounds(117, 11, 59, 50);
		panel_6_1.add(lblNewLabel_5);
		
		JPanel panel_6_2 = new JPanel();
		panel_6_2.setBackground(new Color(60, 179, 113));
		panel_6_2.setLayout(null);
		panel_6_2.setBorder(new MatteBorder(0, 0, 25, 0, (Color) new Color(51, 153, 102)));
		panel_6_2.setBounds(461, 45, 186, 113);
		panel_3.add(panel_6_2);
		
		no_issued = new JLabel("10");
		no_issued.setFont(new Font("Maiandra GD", Font.BOLD, 36));
		no_issued.setBounds(10, 11, 63, 40);
		panel_6_2.add(no_issued);
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setIcon(new ImageIcon("D:\\project\\icones\\adminIcons\\icons8_Sell_50px.png"));
		lblNewLabel_5_1.setBounds(119, 11, 57, 50);
		panel_6_2.add(lblNewLabel_5_1);
		
		JLabel ibooks = new JLabel("Issued Books ");
		ibooks.setBounds(10, 64, 166, 21);
		panel_6_2.add(ibooks);
		ibooks.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		
		JPanel panel_6_2_3 = new JPanel();
		panel_6_2_3.setBackground(new Color(205, 92, 92));
		panel_6_2_3.setLayout(null);
		panel_6_2_3.setBorder(new MatteBorder(0, 0, 25, 0, (Color) new Color(153, 0, 51)));
		panel_6_2_3.setBounds(677, 45, 186, 113);
		panel_3.add(panel_6_2_3);
		
		no_default = new JLabel("10");
		no_default.setFont(new Font("Maiandra GD", Font.BOLD, 36));
		no_default.setBounds(10, 11, 67, 40);
		panel_6_2_3.add(no_default);
		
		JLabel lblNewLabel_4_4_1 = new JLabel("Default List");
		lblNewLabel_4_4_1.setBounds(10, 63, 166, 21);
		panel_6_2_3.add(lblNewLabel_4_4_1);
		lblNewLabel_4_4_1.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("D:\\project\\icones\\adminIcons\\icons8_People_50px.png"));
		lblNewLabel_7.setBounds(113, 11, 63, 40);
		panel_6_2_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_6 = new JLabel("Student Details ");
		lblNewLabel_6.setFont(new Font("Maiandra GD", Font.BOLD, 14));
		lblNewLabel_6.setBounds(65, 184, 123, 14);
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("Book Details ");
		lblNewLabel_6_1.setFont(new Font("Maiandra GD", Font.BOLD, 14));
		lblNewLabel_6_1.setBounds(65, 405, 123, 14);
		panel_3.add(lblNewLabel_6_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 431, 777, 172);
		panel_3.add(scrollPane);
		
		B_table = new JTable();
		B_table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(B_table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBackground(new Color(205, 92, 92));
		scrollPane_1.setBounds(45, 209, 777, 172);
		panel_3.add(scrollPane_1);
		
		S_table = new JTable();
		S_table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane_1.setViewportView(S_table);
	}
	
	 // For show data in Table
    String books_name,Auther_namee;
    int books_id,quantityes;
    DefaultTableModel model = new DefaultTableModel();
    private JTable S_table;
  
    public void setBookDetailintoTable()    {
    	try {
    		 Connection con = DbConnection.GetConnection();
    		 java.sql.Statement st = con.createStatement();
    		 ResultSet rs = st.executeQuery("select * from managebooks ");
    		 
    		 
    		 
    		 while(rs.next()) //`book_id`, `book_name`, `auther_name`, `quantity`
    		 {
    			 String books_id = rs.getString("book_id");
    			 String books_name = rs.getString("book_name");
    			 String Auther_namee = rs.getString("auther_name");
    			 String quantitys = rs.getString("quantity");
    			 
    			 Object [] col = {"Book_id","Book_Name","Depertment","Course"}; 
    			 Object [] Table = {books_id,books_name,Auther_namee,quantitys};
    			 model = (DefaultTableModel) B_table.getModel();
    			 model.setColumnIdentifiers(col);
    			 model.addRow(Table);
    			 
    		 }
    		 
    	}
    	catch(Exception e)
    	{
    		JOptionPane.showMessageDialog(this,"Error"+e);
    	}
    }
    
 // For show Student data in Table
    String Student_name,Depertment,course;
    int Student_id;
    DefaultTableModel model1 = new DefaultTableModel();
   
    public void setStudentDetailintoTable()    {
    	try {
    		 Connection con = DbConnection.GetConnection();
    		 java.sql.Statement st = con.createStatement();
    		 ResultSet rs = st.executeQuery("select * from managestudent ");
    		 
    		 
    		 
    		 while(rs.next()) //`book_id`, `book_name`, `auther_name`, `quantity`
    		 {
    			 String Student_id = rs.getString("S_id");
    			 String Student_name = rs.getString("S_name");
    			 String Depertment = rs.getString("S_add");
    			 String course = rs.getString("course");
    			 
    			 Object [] col = {"S_id","Student_Name","Depertment","course"}; 
    			 Object [] Table = {Student_id,Student_name,Depertment,course};
    			 model1 = (DefaultTableModel) S_table.getModel();
    			 model1.setColumnIdentifiers(col);
    			 model1.addRow(Table);
    			 
    		 }
    		 
    	}
    	catch(Exception e)
    	{
    		JOptionPane.showMessageDialog(this,"Error"+e);
    	}
    }
    public void SetCountData()
    {
    	PreparedStatement  p = null;
    	
    	ResultSet rs = null;
    	
    	long l = System.currentTimeMillis();
    	
    	Date today = new Date(l);
    	
    	try
    	{
    		Connection con = DbConnection.GetConnection();
    		
    		p = con.prepareStatement("select * from managebooks");
    		rs = p.executeQuery();
    		int count =0;
    		while(rs.next())
    		{
    			count++;
    		}
    		no_books.setText(Integer.toString(count));
    		
    		p = con.prepareStatement("select * from managestudent");
    		rs = p.executeQuery();
    		rs.last();
    		no_students.setText(Integer.toString(rs.getRow()));
    		
    		rs = p.executeQuery("SELECT * FROM `issuebook1` WHERE status = '"+"panding"+"'");
    		rs.last();
    		no_issued.setText(Integer.toString(rs.getRow()));
    		
    		p = con.prepareStatement("SELECT * FROM `issuebook1` WHERE return_date < ? AND status = ?");
    		p.setDate(1, today);
     		p.setString(2, "panding");

     		rs = p.executeQuery();
    	
     		
    		int countd =0;
    		while(rs.next())
    		{
    			countd++;
    		}
    		no_default.setText(Integer.toString(countd-1));    		
    	}
    	catch(Exception e)
    	{
    		
    	}
    	
    }
}

