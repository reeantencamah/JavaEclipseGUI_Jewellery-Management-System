//package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textAdd;
	private JTextField textContact;
	private JTextField textMail;
	private JTextField textItem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setResizable(false);
		setTitle("Register New Supplier");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 840, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 153, 255));
		panel.setBounds(0, 98, 379, 430);
		contentPane.add(panel);
		
		JLabel label = new JLabel("New Supplier");
		label.setFont(new Font("Times New Roman", Font.BOLD, 40));
		panel.add(label);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Register.class.getResource("/images/supplier1.jpg")));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel.add(lblNewLabel_1);
		
		textName = new JTextField();
		textName.setFont(new Font("Poor Richard", Font.PLAIN, 20));
		textName.setBounds(420, 98, 346, 44);
		contentPane.add(textName);
		textName.setColumns(10);
		
		JLabel lblName = new JLabel("Name:\r\n");
		lblName.setFont(new Font("Poor Richard", Font.BOLD, 20));
		lblName.setBounds(420, 68, 69, 20);
		contentPane.add(lblName);
		
		textAdd = new JTextField();
		textAdd.setFont(new Font("Poor Richard", Font.BOLD, 20));
		textAdd.setColumns(10);
		textAdd.setBounds(420, 194, 346, 44);
		contentPane.add(textAdd);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Poor Richard", Font.BOLD, 20));
		lblAddress.setBounds(420, 158, 108, 20);
		contentPane.add(lblAddress);
		
		textContact = new JTextField();
		textContact.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		textContact.setFont(new Font("Poor Richard", Font.BOLD, 20));
		textContact.setColumns(10);
		textContact.setBounds(420, 290, 346, 44);
		contentPane.add(textContact);
		
		JLabel lblContactNumber = new JLabel("Contact Number:");
		lblContactNumber.setFont(new Font("Poor Richard", Font.BOLD, 20));
		lblContactNumber.setBounds(420, 254, 146, 20);
		contentPane.add(lblContactNumber);
		
		textMail = new JTextField();
		textMail.setFont(new Font("Poor Richard", Font.BOLD, 20));
		textMail.setColumns(10);
		textMail.setBounds(420, 375, 346, 44);
		contentPane.add(textMail);
		
		textItem = new JTextField();
		textItem.setFont(new Font("Poor Richard", Font.BOLD, 20));
		textItem.setColumns(10);
		textItem.setBounds(420, 484, 346, 44);
		contentPane.add(textItem);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Poor Richard", Font.BOLD, 20));
		lblEmail.setBounds(420, 350, 69, 20);
		contentPane.add(lblEmail);
		
		JLabel lblItem = new JLabel("Item:");
		lblItem.setFont(new Font("Poor Richard", Font.BOLD, 20));
		lblItem.setBounds(420, 448, 69, 20);
		contentPane.add(lblItem);
		
		JButton btnReg = new JButton("Register");
		btnReg.setBackground(new Color(102, 205, 170));
		btnReg.setFont(new Font("Courier New", Font.BOLD, 20));
		btnReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textName.getText().trim().isEmpty() || textAdd.getText().trim().isEmpty() || textContact.getText().trim().isEmpty() || textMail.getText().trim().isEmpty() || textItem.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Fill all the fields!");
				}
				String name = textName.getText();
				String address = textAdd.getText();
				int contact = Integer.parseInt(textContact.getText());				
				String email = textMail.getText();
				String item = textItem.getText();
				
				
				
				PreparedStatement ps; //import java.sql.PreparedStatement This interface creates an object that represents a precompiled SQL statement. This object can then be used to efficiently execute this statement multiple times
				
				String query = "INSERT INTO `supplierregister`(`Name`, `Address`, `Contact Number`, `Email`, `Items`) VALUES (?,?,?,?,?)";			    
			    
				try {
					ps = MyConnection.getConnection().prepareStatement(query);
					
					ps.setString(1, name);
					ps.setString(2, address);
					ps.setLong(3, contact);
					ps.setString(4, email);
					ps.setString(5, item);
				
					if (ps.executeUpdate() > 0) {
						
						JOptionPane.showMessageDialog(null, "New supplier registered succesfully");
						textName.setText("");
						textAdd.setText("");
						textContact.setText("");
						textMail.setText("");
						textItem.setText("");
					}
					
			
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					
					
						JOptionPane.showMessageDialog(null, e1);
					
				}
				close();
			}
		});
		btnReg.setBounds(414, 574, 158, 44);
		contentPane.add(btnReg);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Courier New", Font.BOLD, 21));
		btnCancel.setBackground(new Color(255, 51, 51));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			
			}
			
		});
		btnCancel.setBounds(587, 574, 179, 44);
		contentPane.add(btnCancel);
	}
}
