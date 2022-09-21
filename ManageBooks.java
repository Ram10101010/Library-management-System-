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

public class ManageBooks extends JFrame {

	private JPanel contentPane;
	private JTextField book_id1;
	private JTextField book_name;
	private JTextField author_name;
	private JTextField quantity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageBooks frame = new ManageBooks();
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
	public ManageBooks() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				setBookDetailintoTable();
			}
		});
		//setBookDetailintoTable();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 20, 1111, 723);
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
		
		JLabel lblEnterBookId = new JLabel("Enter Book Id ");
		lblEnterBookId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEnterBookId.setBounds(92, 98, 96, 21);
		panel.add(lblEnterBookId);
		
		book_id1 = new JTextField();
		book_id1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		book_id1.setColumns(10);
		book_id1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		book_id1.setBackground(new Color(148, 0, 211));
		book_id1.setBounds(92, 130, 232, 21);
		panel.add(book_id1);
		
		JLabel lblEnterBookName = new JLabel("Enter Book Name");
		lblEnterBookName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEnterBookName.setBounds(92, 178, 96, 21);
		panel.add(lblEnterBookName);
		
		book_name = new JTextField();
		book_name.setFont(new Font("Tahoma", Font.PLAIN, 13));
		book_name.setColumns(10);
		book_name.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		book_name.setBackground(new Color(148, 0, 211));
		book_name.setBounds(92, 210, 232, 21);
		panel.add(book_name);
		
		JLabel lblAuthorName = new JLabel("Author Name ");
		lblAuthorName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAuthorName.setBounds(92, 254, 114, 21);
		panel.add(lblAuthorName);
		
		author_name = new JTextField();
		author_name.setToolTipText("");
		author_name.setFont(new Font("Tahoma", Font.PLAIN, 13));
		author_name.setColumns(10);
		author_name.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		author_name.setBackground(new Color(148, 0, 211));
		author_name.setBounds(92, 286, 232, 21);
		panel.add(author_name);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblQuantity.setBounds(92, 331, 96, 21);
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
		
		quantity = new JTextField();
		quantity.setToolTipText("");
		quantity.setFont(new Font("Tahoma", Font.PLAIN, 13));
		quantity.setColumns(10);
		quantity.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		quantity.setBackground(new Color(148, 0, 211));
		quantity.setBounds(92, 376, 232, 21);
		panel.add(quantity);
		
		JLabel lblNewLabel_4 = new JLabel("Manage Books  ");
		lblNewLabel_4.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(134, 42, 141, 23);
		panel.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
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
				
				book_id1.setText(model.getValueAt(row_no,0).toString());
				book_name.setText(model.getValueAt(row_no,1).toString());
				author_name.setText(model.getValueAt(row_no, 2).toString());
				quantity.setText(model.getValueAt(row_no,3).toString());
			}
		});
		scrollPane.setViewportView(book_table);
		book_table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(148, 0, 211)));
		book_table.setBackground(Color.WHITE);
		book_table.setModel(model);
		
		JLabel B_detail = new JLabel("Book Details ");
		B_detail.setAutoscrolls(true);
		B_detail.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(153, 50, 204)));
		B_detail.setFont(new Font("Tahoma", Font.BOLD, 17));
		B_detail.setBounds(297, 50, 113, 21);
		panel_1.add(B_detail);
		
		JLabel lblNewLabel = new JLabel("Refresh ");
		lblNewLabel.setBackground(new Color(148, 0, 211));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(314, 414, 68, 21);
		panel_1.add(lblNewLabel);
		
	}
	
	public void AddBooks()      // ADD BooKs  
    {
        String Book_id = book_id1.getText();
        String Book_name = book_name.getText();
        String Author_name = author_name.getText();
        String Quantity = quantity.getText();
        try 
        {
            
            Connection con = DbConnection.GetConnection();
            

            String insert = "INSERT INTO `managebooks`(`book_id`, `book_name`, `auther_name`, `quantity`) VALUES(?,?,?,?)";
            try(PreparedStatement pst = con.prepareStatement(insert))
            {
            	 pst.setString(1,Book_id);
            	 pst.setString(2,Book_name);
            	 pst.setString(3,Author_name);
            	 pst.setString(4,Quantity);
            	 
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
            Author_name = "";
            Quantity = "";
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
        String Book_id = book_id1.getText();
        String Book_name = book_name.getText();
        String Author_name = author_name.getText();
        String Quantity = quantity.getText();
        
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
        if(Author_name.equals(""))
        {   
            JOptionPane.showMessageDialog(this,"please Enter Auther Name  ");
            return false;
        }
        if(Quantity.equals(""))
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
    		 ResultSet rs = st.executeQuery("select * from managebooks ");
    		 
    		 
    		 
    		 while(rs.next()) //`book_id`, `book_name`, `auther_name`, `quantity`
    		 {
    			 String books_id = rs.getString("book_id");
    			 String books_name = rs.getString("book_name");
    			 String Auther_namee = rs.getString("auther_name");
    			 String quantitys = rs.getString("quantity");
    			 
    			 Object [] col = {"Book_id","Book_Name","Auther_Name","Quantity"}; 
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
    
    
    public void updateBook()
    {
    	int bookId = Integer.parseInt(book_id1.getText());
    	String Book_name = book_name.getText();
        String Author_name = author_name.getText();
        int Quantity = Integer.parseInt(quantity.getText());
        try 
        {
            
            Connection con = DbConnection.GetConnection();
            

            String insert = "UPDATE `managebooks` SET `book_name`= ?, `auther_name` = ?, `quantity` =? WHERE `book_id`= ?";
            try(PreparedStatement pst = con.prepareStatement(insert))
            {
            	 pst.setString(1,Book_name);
            	 pst.setString(2,Author_name);
            	 pst.setInt(3,Quantity);
            	 pst.setInt(4,bookId);
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
    public void DeleteBook()
    {
    	int bookId = Integer.parseInt(book_id1.getText());
        try 
        {
            
            Connection con = DbConnection.GetConnection();
            

            String insert = "DELETE FROM `managebooks` WHERE `book_id`= ?";
            try(PreparedStatement pst = con.prepareStatement(insert))
            {
            	 pst.setInt(1,bookId);
            	int uprowcount = pst.executeUpdate(); // When the data sucessfully added in our data base then its automatically increment
            	if(uprowcount >= 1)
            	{
            		JOptionPane.showMessageDialog(this,"You have Successfully DELETE this Book ");
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
