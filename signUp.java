package javanew;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;

public class signUp extends JFrame {

	private JPanel contentPane;
	private JTextField user_name;
	private JPasswordField pass;
	private JTextField Email_id;
	private JTextField ph_no;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signUp frame = new signUp();
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
	public signUp() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(379, 0, 329, 491);
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("Login ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login l = new login();
				l.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(0, 128, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(50, 205, 50));
		btnNewButton.setBounds(107, 421, 114, 36);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SignUp ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validateSignup() == true)
		        {
		            insertSignupdatail();
		        }
			}
			
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBackground(new Color(123, 104, 238));
		btnNewButton_1.setBounds(97, 374, 137, 36);
		panel.add(btnNewButton_1);
		
		JLabel lblUserId = new JLabel("User Id : *");
		lblUserId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUserId.setBounds(43, 113, 96, 21);
		panel.add(lblUserId);
		
		user_name = new JTextField();
		user_name.setBackground(Color.LIGHT_GRAY);
		user_name.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		user_name.setFont(new Font("Tahoma", Font.PLAIN, 13));
		user_name.setColumns(10);
		user_name.setBounds(43, 145, 232, 21);
		panel.add(user_name);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(43, 300, 96, 21);
		panel.add(lblPassword);
		
		pass = new JPasswordField();
		pass.setBackground(Color.LIGHT_GRAY);
		pass.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		pass.setToolTipText("");
		pass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pass.setBounds(43, 332, 232, 20);
		panel.add(pass);
		
		JLabel lblNewLabel_1 = new JLabel("  WellCome to LMS ");
		lblNewLabel_1.setBorder(new MatteBorder(0, 2, 0, 2, (Color) new Color(148, 0, 211)));
		lblNewLabel_1.setBackground(new Color(148, 0, 211));
		lblNewLabel_1.setForeground(new Color(148, 0, 211));
		lblNewLabel_1.setFont(new Font("Rockwell", Font.BOLD, 16));
		lblNewLabel_1.setBounds(86, 11, 162, 50);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Create A new Account  ");
		lblNewLabel_2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(97, 72, 156, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblEmailId = new JLabel("Email id : *");
		lblEmailId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmailId.setBounds(43, 177, 96, 21);
		panel.add(lblEmailId);
		
		Email_id = new JTextField();
		Email_id.setBackground(Color.LIGHT_GRAY);
		Email_id.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		Email_id.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Email_id.setColumns(10);
		Email_id.setBounds(43, 209, 232, 21);
		panel.add(Email_id);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number : *");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPhoneNumber.setBounds(43, 241, 114, 21);
		panel.add(lblPhoneNumber);
		
		ph_no = new JTextField();
		ph_no.setBackground(Color.LIGHT_GRAY);
		ph_no.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		ph_no.setToolTipText("");
		ph_no.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ph_no.setColumns(10);
		ph_no.setBounds(43, 273, 232, 21);
		panel.add(ph_no);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 381, 483);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\java projects in Eclips\\java\\icons\\Annual-income-report-and-update-380x480.png"));
		lblNewLabel_3.setBounds(0, 0, 381, 483);
		panel_1.add(lblNewLabel_3);
	}
	public void insertSignupdatail() 
    {
        String name = user_name.getText();
        String email = Email_id.getText();
        String phone = ph_no.getText();
		String Password = new String(pass.getPassword()); 
        try 
        {
            
            Connection con = DbConnection.GetConnection();
            //String insert = "INSERT INTO `userinfo`(`User_name`,`Email_id`,`Phone`,`password`) VALUES("+name+","+email+","+phone+","+Password+")";
            

            String insert = "INSERT INTO `userinfo`(`User_name`,`Email_id`,`Phone`,`password`) VALUES(?,?,?,?)";
            /*String resultSet2 = "INSERT INTO Clientes(nome) VALUES(?);";
			*/
            //PreparedStatement pst = con.prepareStatement(sql);
            
            try(PreparedStatement pst = con.prepareStatement(insert))
            {
            	 pst.setString(1,name);
            	 pst.setString(2,email);
            	 pst.setString(3,phone);
            	 pst.setString(4,Password);
            	 
            	int uprowcount = pst.executeUpdate(); // When the data sucessfully added in our data base then its automatically increment
            	if(uprowcount >= 1)
            	{
            		JOptionPane.showMessageDialog(this,"You have Successfully Sign UP ");
            		JOptionPane.showMessageDialog(this,"Now you can login with user is and password ");
            		login l = new login();
    				l.setVisible(true);
    				dispose();
            	}
            	else
            	{
                    JOptionPane.showMessageDialog(this,"Sign Up Failure");
            	}
            // When the data successfull added in our data base then its automatically increment
            }
            name = "";
            email = "";
            phone = "";
            Password = "";
        }   
        catch (HeadlessException | SQLException e) 
        {
            JOptionPane.showMessageDialog(this,"this can be Error"+e);
        }
    }
    // Validation 
    public boolean validateSignup()
    {
        String name = user_name.getText();
        String email = Email_id.getText();
        String phone = ph_no.getText();
		String password = new String(pass.getPassword());
        
        if(name.equals(""))
        {   
            JOptionPane.showMessageDialog(this,"please Enter username ");
            return false;
        }
        if(email.equals("") || !email.matches("^(.+)@(.+)$"))
        {   
            JOptionPane.showMessageDialog(this,"please Enter valid email Id ");
            return false;
        }
        if(phone.equals(""))
        {   
            JOptionPane.showMessageDialog(this,"please Enter phone No.  ");
            return false;
        }
        if(password.equals(""))
        {   
            JOptionPane.showMessageDialog(this,"please Enter password");
            return false;
        }
        return true;
    }
}
