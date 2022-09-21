package javanew;

import java.awt.BorderLayout;
import java.util.Scanner;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.ScrollPane;
import java.sql.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.cj.xdevapi.Statement;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class StudentM extends JFrame {

	private JPanel contentPane;
	private JTextField S_id;
	private JTextField S_name;
	static private JComboBox Dep_name;
	static private JComboBox Cour_name; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentM frame = new StudentM();
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
	public StudentM() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				setBookDetailintoTable();
			}
		});
		//setBookDetailintoTable();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 20, 1112, 724);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(148, 0, 211));
		panel.setBounds(0, 0, 379, 735);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LHomepage home = new LHomepage();
				home.setVisible(true);
				dispose();
			}
		});
		BackButton.setBackground(new Color(123, 104, 238));
		BackButton.setBounds(0, 0, 89, 23);
		panel.add(BackButton);
		
		JLabel lblEnterBookId = new JLabel("Enter Student Id");
		lblEnterBookId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEnterBookId.setBounds(92, 98, 204, 21);
		panel.add(lblEnterBookId);
		
		S_id = new JTextField();
		S_id.setFont(new Font("Tahoma", Font.PLAIN, 13));
		S_id.setColumns(10);
		S_id.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		S_id.setBackground(new Color(148, 0, 211));
		S_id.setBounds(92, 130, 232, 21);
		panel.add(S_id);
		
		JLabel lblEnterBookName = new JLabel("Enter Student Name");
		lblEnterBookName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEnterBookName.setBounds(92, 178, 217, 21);
		panel.add(lblEnterBookName);
		
		S_name = new JTextField();
		S_name.setFont(new Font("Tahoma", Font.PLAIN, 13));
		S_name.setColumns(10);
		S_name.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		S_name.setBackground(new Color(148, 0, 211));
		S_name.setBounds(92, 210, 232, 21);
		panel.add(S_name);
		
		JLabel lblAuthorName = new JLabel("Depertment");
		lblAuthorName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAuthorName.setBounds(92, 254, 114, 21);
		panel.add(lblAuthorName);
		
		JLabel lblQuantity = new JLabel("Course Name");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblQuantity.setBounds(92, 331, 232, 21);
		panel.add(lblQuantity);
		
		JLabel idBook = new JLabel("");
		idBook.setIcon(new ImageIcon("D:\\project\\icones\\AddNewBookIcons\\icons8_Contact_26px.png"));
		idBook.setBounds(43, 98, 46, 32);
		panel.add(idBook);
		
		JLabel NameBook = new JLabel("");
		NameBook.setIcon(new ImageIcon("D:\\project\\icones\\AddNewBookIcons\\icons8_Moleskine_26px.png"));
		NameBook.setBounds(43, 182, 46, 32);
		panel.add(NameBook);
		
		JLabel NameAuthor = new JLabel("");
		NameAuthor.setIcon(new ImageIcon("D:\\project\\icones\\AddNewBookIcons\\icons8_Collaborator_Male_26px.png"));
		NameAuthor.setBounds(43, 258, 46, 32);
		panel.add(NameAuthor);
		
		JLabel bookQuantity = new JLabel("");
		bookQuantity.setIcon(new ImageIcon("D:\\project\\icones\\AddNewBookIcons\\icons8_Unit_26px.png"));
		bookQuantity.setBounds(43, 335, 46, 32);
		panel.add(bookQuantity);
		
		JButton ADDBook = new JButton("ADD");
		ADDBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validateManageBook() == true)
		        {
					//setBookDetailintoTable();
					AddBooks();
					ClearTable();
					setBookDetailintoTable();
		        }
			}
		});
		ADDBook.setBounds(39, 445, 89, 23);
		panel.add(ADDBook);
		
		JButton UpdateBook = new JButton("UPDATE");
		UpdateBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateBook();
				ClearTable();
				setBookDetailintoTable();
			}
		});
		UpdateBook.setBounds(151, 445, 89, 23);
		panel.add(UpdateBook);
		
		JButton DeleteBook = new JButton("DELETE");
		DeleteBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					DeleteBook();
					ClearTable();
					setBookDetailintoTable();
			}
			
		});
		DeleteBook.setBounds(250, 445, 89, 23);
		panel.add(DeleteBook);
		
		JLabel lblNewLabel_4 = new JLabel("Manage Books  ");
		lblNewLabel_4.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(134, 42, 141, 23);
		panel.add(lblNewLabel_4);
		
		String dept[] = {"CS", "ENGN", "IT", "LOW", "MEDICAL"};
		Dep_name = new JComboBox(dept);;
		Dep_name.setToolTipText("");
		Dep_name.setBounds(98, 298, 226, 22);
		panel.add(Dep_name);
		
		Cour_name = new JComboBox();
		Cour_name.setModel(new DefaultComboBoxModel(new String[] {"BBA", "BCA", "BSC", "BTECH", "MBA", "MCA", "MSC", "MTECH"}));
		Cour_name.setBounds(98, 381, 226, 22);
		panel.add(Cour_name);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("Button.darkShadow"));
		panel_1.setBounds(380, 0, 715, 684);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setFont(new Font("Mongolian Baiti", Font.PLAIN, 13));
		scrollPane.setBounds(10, 107, 695, 256);
		panel_1.add(scrollPane); 
		
		/* JScrollPane BookTable = new JScrollPane();
		scrollPane.setViewportView(BookTable); */
		
		book_table = new JTable();
		book_table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row_no = book_table.getSelectedRow();
				TableModel model = book_table.getModel();
				
				S_id.setText(model.getValueAt(row_no,0).toString());
				S_name.setText(model.getValueAt(row_no,1).toString());
				Dep_name.setSelectedItem(model.getValueAt(row_no, 2).toString());
				Cour_name.setSelectedItem(model.getValueAt(row_no, 3).toString());
			}
		});
		scrollPane.setViewportView(book_table);
		book_table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(148, 0, 211)));
		book_table.setBackground(Color.WHITE);
		book_table.setModel(model);
		
		JLabel B_detail = new JLabel("  Students Details ");
		B_detail.setForeground(UIManager.getColor("Button.highlight"));
		B_detail.setBackground(UIManager.getColor("Button.disabledShadow"));
		B_detail.setAutoscrolls(true);
		B_detail.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(153, 50, 204)));
		B_detail.setFont(new Font("Tahoma", Font.BOLD, 17));
		B_detail.setBounds(297, 50, 161, 21);
		panel_1.add(B_detail);
		
	}
	
	public void AddBooks()      // ADD BooKs  
    {
        String Book_id = S_id.getText();
        String Book_name = S_name.getText();
        String Dept_name = Dep_name.getSelectedItem().toString();
        String Course = Cour_name.getSelectedItem().toString();
        try 
        {
            
            Connection con = DbConnection.GetConnection();
            

            String insert = "INSERT INTO `managestudent`(`S_id`, `S_name`, `S_add`, `course`) VALUES(?,?,?,?)";
            try(PreparedStatement pst = con.prepareStatement(insert))
            {
            	 pst.setString(1,Book_id);
            	 pst.setString(2,Book_name);
            	 pst.setString(3,Dept_name);
            	 pst.setString(4,Course);
            	 
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
            Book_id = "";
            Book_name = "";
            Dept_name = "";
            Course = "";
        }   
        catch (HeadlessException | SQLException e) 
        {
            JOptionPane.showMessageDialog(this,"this can be Error"+e);
        }
    }
	// Method to Clear Table 
	public void ClearTable()
	{
		DefaultTableModel model = (DefaultTableModel)book_table.getModel();
		model.setRowCount(0);
	}
    // Validation 
    public boolean validateManageBook()
    {
        String Book_id = S_id.getText();
        String Book_name = S_name.getText();
        String Dept_name = Dep_name.getSelectedItem().toString();
        String Course = Cour_name.getSelectedItem().toString();
        
        if(Book_id.equals(""))
        {   
            JOptionPane.showMessageDialog(this,"please Enter valid Book Id ");
            return false;
        }
        if(Book_name.equals(""))
        {   
            JOptionPane.showMessageDialog(this,"please Enter valid Book Name ");
            return false;
        }
        if(Dept_name.equals(""))
        {   
            JOptionPane.showMessageDialog(this,"please Enter Auther Name  ");
            return false;
        }
        if(Course.equals(""))
        {   
            JOptionPane.showMessageDialog(this,"please Enter Quantity");
            return false;
        }
        return true;
    }
    
    // For show data in Table
    String books_name,Auther_namee;
    int books_id,quantityes;
    DefaultTableModel model = new DefaultTableModel();
    private JTable book_table;
    public void setBookDetailintoTable()    {
    	try {
    		 Connection con = DbConnection.GetConnection();
    		 java.sql.Statement st = con.createStatement();
    		 ResultSet rs = st.executeQuery("select * from managestudent ");
    		 
    		 
    		 
    		 while(rs.next()) //`book_id`, `book_name`, `auther_name`, `quantity`
    		 {
    			 String books_id = rs.getString("S_id");
    			 String books_name = rs.getString("S_name");
    			 String Auther_namee = rs.getString("S_add");
    			 String quantitys = rs.getString("course");
    			 
    			 Object [] col = {"S_id","S_Name","S_add","course"}; 
    			 Object [] Table = {books_id,books_name,Auther_namee,quantitys};
    			 model = (DefaultTableModel) book_table.getModel();
    			 model.setColumnIdentifiers(col);
    			 model.addRow(Table);
    			 
    		 }
    		 
    	}
    	catch(Exception e)
    	{
    		JOptionPane.showMessageDialog(this,"Error"+e);
    	}
    }
    
    
    public void updateBook()					// Update Student 
    {
    	String bookId = S_id.getText();
    	String Book_name = S_name.getText(); 
    	String Dept_name = Dep_name.getSelectedItem().toString();
        String Course = Cour_name.getSelectedItem().toString();
        try 
        {
            
            Connection con = DbConnection.GetConnection();
            

            String insert = "UPDATE `managestudent` SET `S_name`= ?, `S_add` = ?, `course` =? WHERE `S_id`= ?";
            try(PreparedStatement pst = con.prepareStatement(insert))
            {
            	 pst.setString(1,Book_name);
            	 pst.setString(2,Dept_name);
            	 pst.setString(3,Course);
            	 pst.setString(4,bookId);
            	int uprowcount = pst.executeUpdate(); // When the data sucessfully added in our data base then its automatically increment
            	if(uprowcount >= 1)
            	{
            		JOptionPane.showMessageDialog(this,"You have Successfully UPDATE this Book ");
            	}
            	
            	else
            	{
                    JOptionPane.showMessageDialog(this,"UPDATE Book Failure");
            	}
            	// When the data successfull added in our data base then its automatically increment
            }
        }
        catch (HeadlessException | SQLException e) 
        {
            JOptionPane.showMessageDialog(this,"this can be Error"+e);
        }
    }
    public void DeleteBook()					// Delete Student Details 
    {
    	int bookId = Integer.parseInt(S_id.getText());
        try 
        {
            
            Connection con = DbConnection.GetConnection();
            

            String insert = "DELETE FROM `managestudent` WHERE `S_id`= ?";
            try(PreparedStatement pst = con.prepareStatement(insert))
            {
            	 pst.setInt(1,bookId);
            	int uprowcount = pst.executeUpdate(); // When the data sucessfully added in our data base then its automatically increment
            	if(uprowcount >= 1)
            	{
            		JOptionPane.showMessageDialog(this,"You have Successfully DELETE this Student Detels ");
            	}
            	
            	else
            	{
                    JOptionPane.showMessageDialog(this,"DELETE Failure");
            	}
            	// When the data successfull added in our data base then its automatically increment
            }
        }
        catch (HeadlessException | SQLException e) 
        {
            JOptionPane.showMessageDialog(this,"this can be Error"+e);
        }
    }
}
