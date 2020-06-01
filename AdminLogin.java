

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtusername;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void close() {
		this.setVisible(false);
		this.dispose();
	}

	/**
	 * Create the frame.
	 */
	public AdminLogin() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminLogin.class.getResource("/images/logo.png")));
		setTitle("Admin login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 231);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Username");
		label.setFont(new Font("Perpetua Titling MT", Font.BOLD, 16));
		label.setBackground(new Color(32, 178, 170));
		label.setBounds(184, 44, 115, 31);
		contentPane.add(label);
		
		txtusername = new JTextField();
		txtusername.setColumns(10);
		txtusername.setBounds(287, 44, 144, 25);
		contentPane.add(txtusername);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setFont(new Font("Perpetua Titling MT", Font.BOLD, 16));
		label_1.setBackground(new Color(32, 178, 170));
		label_1.setBounds(184, 86, 115, 31);
		contentPane.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(287, 86, 144, 25);
		contentPane.add(passwordField);
		
		JButton button = new JButton("Login");
		button.setIcon(new ImageIcon(AdminLogin.class.getResource("/images/Actions-mail-receive-icon.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String user=txtusername.getText();
					String pass= passwordField.getText();
					
					if(user.equals("vijewel") && pass.equals("nandu")) {
						JOptionPane.showMessageDialog(null,"Welcome to Vi-Jewel App","Login Successful",JOptionPane.INFORMATION_MESSAGE);
						menu m = new menu();
						m.show();
						close();
					}
					else {
						JOptionPane.showMessageDialog(null,"Re-enter username and password.","Access Denied",JOptionPane.ERROR_MESSAGE);
					}
					
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button.setFont(new Font("Perpetua Titling MT", Font.BOLD, 15));
		button.setBounds(287, 135, 144, 40);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AdminLogin.class.getResource("/images/vijewel.png")));
		lblNewLabel.setBounds(10, 0, 165, 198);
		contentPane.add(lblNewLabel);
	}

}
