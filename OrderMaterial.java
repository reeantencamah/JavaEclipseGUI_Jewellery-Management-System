import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class OrderMaterial extends JFrame {

	private JPanel contentPane;
	private JTextField textMId;
	private JTextField textMName;
	private JTextField textDate;
	private JTextField textQuantity;
	private JTextField textDescription;
	private JTextField textSupName;
	private JTextField textSupEmail;
	private JTextField textPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderMaterial frame = new OrderMaterial();
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
	public OrderMaterial() {
		setBackground(new Color(0, 139, 139));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 354);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(47, 79, 79));
		panel.setForeground(new Color(255, 255, 240));
		panel.setBounds(0, 0, 148, 373);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setForeground(new Color(95, 158, 160));
		lblMenu.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 19));
		lblMenu.setBackground(new Color(47, 79, 79));
		lblMenu.setBounds(35, 5, 74, 26);
		panel.add(lblMenu);
		
		JButton btnHome = new JButton("Home");
		btnHome.setForeground(new Color(0, 0, 0));
		btnHome.setToolTipText("");
		btnHome.setBackground(new Color(192, 192, 192));
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHome.setHorizontalAlignment(SwingConstants.LEFT);
		btnHome.setIcon(new ImageIcon(EmployeeDetails.class.getResource("/images/Apps-Home-icon.png")));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu mu= new menu();
				mu.show();
				close();
			}
		});
		btnHome.setBounds(10, 42, 128, 36);
		panel.add(btnHome);
		
		JButton btnProduct = new JButton("Product");
		btnProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnProduct.setIcon(new ImageIcon(EmployeeDetails.class.getResource("/images/product.png")));
		btnProduct.setToolTipText("");
		btnProduct.setHorizontalAlignment(SwingConstants.LEFT);
		btnProduct.setForeground(Color.BLACK);
		btnProduct.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnProduct.setBackground(new Color(192, 192, 192));
		btnProduct.setBounds(10, 89, 128, 36);
		panel.add(btnProduct);
		
		JButton btnSupplier = new JButton("Supplier");
		btnSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSupplier.setIcon(new ImageIcon(EmployeeDetails.class.getResource("/images/supplier.png")));
		btnSupplier.setToolTipText("");
		btnSupplier.setHorizontalAlignment(SwingConstants.LEFT);
		btnSupplier.setForeground(Color.BLACK);
		btnSupplier.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSupplier.setBackground(new Color(192, 192, 192));
		btnSupplier.setBounds(10, 134, 128, 36);
		panel.add(btnSupplier);
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCustomer.setIcon(new ImageIcon(EmployeeDetails.class.getResource("/images/customer.png")));
		btnCustomer.setToolTipText("");
		btnCustomer.setHorizontalAlignment(SwingConstants.LEFT);
		btnCustomer.setForeground(Color.BLACK);
		btnCustomer.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCustomer.setBackground(new Color(192, 192, 192));
		btnCustomer.setBounds(10, 181, 128, 36);
		panel.add(btnCustomer);
		
		JButton btnOrder = new JButton("Order");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOrder.setIcon(new ImageIcon(EmployeeDetails.class.getResource("/images/sale.png")));
		btnOrder.setToolTipText("");
		btnOrder.setHorizontalAlignment(SwingConstants.LEFT);
		btnOrder.setForeground(Color.BLACK);
		btnOrder.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnOrder.setBackground(new Color(192, 192, 192));
		btnOrder.setBounds(10, 227, 128, 36);
		panel.add(btnOrder);
		
		JButton btnInventory = new JButton("Inventory");
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInventory.setIcon(new ImageIcon(EmployeeDetails.class.getResource("/images/material.png")));
		btnInventory.setToolTipText("");
		btnInventory.setHorizontalAlignment(SwingConstants.LEFT);
		btnInventory.setForeground(Color.BLACK);
		btnInventory.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInventory.setBackground(new Color(192, 192, 192));
		btnInventory.setBounds(10, 274, 128, 36);
		panel.add(btnInventory);
		
		JButton btnEmployee = new JButton("Employee");
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeDetails ed = new EmployeeDetails();
				ed.show();
				close();
			}
		});
		btnEmployee.setIcon(new ImageIcon(EmployeeDetails.class.getResource("/images/employee.png")));
		btnEmployee.setToolTipText("");
		btnEmployee.setHorizontalAlignment(SwingConstants.LEFT);
		btnEmployee.setForeground(Color.BLACK);
		btnEmployee.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEmployee.setBackground(new Color(192, 192, 192));
		btnEmployee.setBounds(10, 321, 128, 36);
		panel.add(btnEmployee);
		
		JLabel lblNewLabel = new JLabel("Material Id :");
		lblNewLabel.setFont(new Font("Poor Richard", Font.BOLD, 16));
		lblNewLabel.setBounds(190, 29, 140, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Poor Richard", Font.BOLD, 18));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost/jewellery_shop","root","");
				String query = "Insert into materialorder (MaterialId, MaterialName, Date, Quantity, Description, SupplierName, SupplierEmail, Price ) values (?,?,?,?,?,?,?,?)";
				PreparedStatement ps =  myConn.prepareStatement(query);
				
				int a =Integer.parseInt(textMId.getText());
				ps.setString(1,Integer.toString(a));
				ps.setString(2,textMName.getText());
				ps.setString(3,textDate.getText());
				int c = Integer.parseInt(textQuantity.getText());
				ps.setString(4,Integer.toString(c));
				ps.setString(5,textDescription.getText());
				ps.setString(6,textSupName.getText());
				ps.setString(7,textSupEmail.getText());
				int d = Integer.parseInt(textPrice.getText());
				ps.setString(8,Integer.toString(d));
				
				ps.execute();
				
				JOptionPane.showMessageDialog(null, "Order have been successfully send");
				}
				catch(Exception e1){
					e1.printStackTrace();
					
				}

			}
		});
		btnSubmit.setBounds(256, 251, 97, 35);
		contentPane.add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.RED);
		btnCancel.setFont(new Font("Poor Richard", Font.BOLD, 18));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int YesOrNo = JOptionPane.showConfirmDialog(null," Do you want to Cancel the Order", "Clear JTextField",JOptionPane.DEFAULT_OPTION,JOptionPane.YES_NO_OPTION);
				if(YesOrNo ==0) {
					textMId.setText("");
					textMName.setText("");
					textDate.setText("");
					textQuantity.setText("");
					textDescription.setText("");
					textSupName.setText("");
					textSupEmail.setText("");
					textPrice.setText("");
					Inventory in= new Inventory();
					in.show();
					close();
				}else {	
					
					
				}

			}
		});
		btnCancel.setBounds(483, 251, 97, 35);
		contentPane.add(btnCancel);
		
		textMId = new JTextField();
		textMId.setFont(new Font("Poor Richard", Font.PLAIN, 15));
		textMId.setBounds(340, 27, 106, 20);
		contentPane.add(textMId);
		textMId.setColumns(10);
		
		JLabel lblMaterialName = new JLabel("Material Name :");
		lblMaterialName.setFont(new Font("Poor Richard", Font.BOLD, 16));
		lblMaterialName.setBounds(185, 81, 140, 14);
		contentPane.add(lblMaterialName);
		
		textMName = new JTextField();
		textMName.setFont(new Font("Poor Richard", Font.PLAIN, 15));
		textMName.setBounds(340, 80, 106, 20);
		contentPane.add(textMName);
		textMName.setColumns(10);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setFont(new Font("Poor Richard", Font.BOLD, 16));
		lblDate.setBounds(185, 135, 140, 14);
		contentPane.add(lblDate);
		
		textDate = new JTextField();
		textDate.setFont(new Font("Poor Richard", Font.PLAIN, 15));
		textDate.setBounds(340, 129, 106, 20);
		contentPane.add(textDate);
		textDate.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity :");
		lblQuantity.setFont(new Font("Poor Richard", Font.BOLD, 16));
		lblQuantity.setBounds(185, 178, 140, 29);
		contentPane.add(lblQuantity);
		
		textQuantity = new JTextField();
		textQuantity.setFont(new Font("Poor Richard", Font.PLAIN, 15));
		textQuantity.setBounds(340, 184, 106, 20);
		contentPane.add(textQuantity);
		textQuantity.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setFont(new Font("Poor Richard", Font.BOLD, 16));
		lblDescription.setBounds(497, 28, 111, 14);
		contentPane.add(lblDescription);
		
		textDescription = new JTextField();
		textDescription.setFont(new Font("Poor Richard", Font.PLAIN, 15));
		textDescription.setBounds(618, 26, 135, 20);
		contentPane.add(textDescription);
		textDescription.setColumns(10);
		
		JLabel lblSupplierName = new JLabel("Supplier Name :");
		lblSupplierName.setFont(new Font("Poor Richard", Font.BOLD, 16));
		lblSupplierName.setBounds(497, 81, 111, 20);
		contentPane.add(lblSupplierName);
		
		textSupName = new JTextField();
		textSupName.setFont(new Font("Poor Richard", Font.PLAIN, 15));
		textSupName.setBounds(618, 79, 135, 20);
		contentPane.add(textSupName);
		textSupName.setColumns(10);
		
		JLabel lblSupplierEmail = new JLabel("Supplier Email :");
		lblSupplierEmail.setFont(new Font("Poor Richard", Font.BOLD, 16));
		lblSupplierEmail.setBounds(497, 135, 111, 20);
		contentPane.add(lblSupplierEmail);
		
		textSupEmail = new JTextField();
		textSupEmail.setFont(new Font("Poor Richard", Font.PLAIN, 15));
		textSupEmail.setBounds(618, 133, 135, 20);
		contentPane.add(textSupEmail);
		textSupEmail.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price :");
		lblPrice.setFont(new Font("Poor Richard", Font.BOLD, 16));
		lblPrice.setBounds(515, 185, 46, 14);
		contentPane.add(lblPrice);
		
		textPrice = new JTextField();
		textPrice.setFont(new Font("Poor Richard", Font.PLAIN, 15));
		textPrice.setBounds(618, 183, 135, 20);
		contentPane.add(textPrice);
		textPrice.setColumns(10);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(10, 19, 165, 280);
		contentPane.add(panel1);
	}
}
