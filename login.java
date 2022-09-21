package javanew;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField user_name;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(377, 0, 331, 491);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton LoginB = new JButton("Login ");
		LoginB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validateLogin() == true)
		        {
					Login();
		        }
			}
		});
		LoginB.setFont(new Font("Tahoma", Font.BOLD, 13));
		LoginB.setForeground(new Color(0, 128, 128));
		LoginB.setBackground(new Color(50, 205, 50));
		LoginB.setBounds(110, 332, 114, 36);
		panel.add(LoginB);
		
		JButton SignUpB = new JButton("SignUp page");
		SignUpB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signUp s = new signUp();
				s.setVisible(true);
				dispose();
			}
		});
		SignUpB.setFont(new Font("Tahoma", Font.BOLD, 13));
		SignUpB.setForeground(new Color(245, 255, 250));
		SignUpB.setBackground(new Color(102, 102, 255));
		SignUpB.setBounds(98, 381, 137, 36);
		panel.add(SignUpB);
		
		JLabel user = new JLabel("User Id : ");
		user.setFont(new Font("Tahoma", Font.BOLD, 13));
		user.setBounds(56, 161, 96, 21);
		panel.add(user);
		
		user_name = new JTextField();
		user_name.setBackground(Color.LIGHT_GRAY);
		user_name.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		user_name.setFont(new Font("Tahoma", Font.PLAIN, 13));
		user_name.setBounds(56, 193, 203, 21);
		panel.add(user_name);
		user_name.setColumns(10);
		
		JLabel Password = new JLabel("Password :");
		Password.setFont(new Font("Tahoma", Font.BOLD, 13));
		Password.setBounds(56, 242, 96, 21);
		panel.add(Password);
		
		pass = new JPasswordField();
		pass.setBackground(Color.LIGHT_GRAY);
		pass.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		pass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pass.setToolTipText("");
		pass.setBounds(56, 274, 203, 20);
		panel.add(pass);
		
		JLabel lblNewLabel_1 = new JLabel("  WellCome to LMS ");
		lblNewLabel_1.setBorder(new MatteBorder(0, 2, 0, 2, (Color) new Color(148, 0, 211)));
		lblNewLabel_1.setFont(new Font("Maiandra GD", Font.BOLD, 16));
		lblNewLabel_1.setForeground(new Color(148, 0, 211));
		lblNewLabel_1.setBounds(98, 44, 161, 50);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(" Login To your Account ");
		lblNewLabel_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(110, 103, 156, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Ad Mini  ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(253, 466, 114, 14);
		panel.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 378, 483);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\java projects in Eclips\\java\\icons\\signup page.jpg"));
		lblNewLabel_3.setBounds(0, 0, 378, 402);
		panel_1.add(lblNewLabel_3);
	}
	
	// Validation   
    public boolean validateLogin()
    {
        String name = user_name.getText();
        String password = new String(pass.getPassword());
        
        if(name.equals(""))
        {
            JOptionPane.showMessageDialog(this,"please Enter username ");
            return false;
        }
        if(password.equals(""))
        {   
            JOptionPane.showMessageDialog(this,"please Enter password");
            return false;
        }
        return true;
    }
    
    public void Login()
    {
        String name = user_name.getText();
        String password1 = new String(pass.getPassword());
        
        try 
        {
            
            Connection con = DbConnection.GetConnection();
            
            String sql = "SELECT * FROM `userinfo` WHERE User_name = '"+name+"'and password = '"+password1+"'";
            try(PreparedStatement pst = con.prepareStatement(sql))
            {
            
            	/*pst.setString(1,name);
            	pst.setString(2,password1);*/
            	
            	ResultSet result = pst.executeQuery();
            	if(result.next())
            	{
            		JOptionPane.showMessageDialog(this,"Login Successfully");
            		LHomepage home = new LHomepage();
            		home.setVisible(true);
            		this.dispose();
            	}
            	else
            	{
            		JOptionPane.showMessageDialog(this,"Incorrect user Name or Password");
            	}
            }
            catch(Exception e) {
            	JOptionPane.showMessageDialog(this,"This is error ");
            }
        }   
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(this,"Error"+e);
        }
    }
}
