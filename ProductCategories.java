import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;

public class ProductCategories extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductCategories frame = new ProductCategories();
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
	public ProductCategories() {
		setTitle("Product Categories");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 376);
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
				MainSupplier sp = new MainSupplier();
				sp.show();
				close();
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
				Inventory in = new Inventory();
				in.show();
				close();
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

		JButton btnNewButton = new JButton("Jewellery Sets");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JewellerySets js = new JewellerySets();
				js.setVisible(true);
				close();

			}
		});
		// Image img = new ImageIcon(this.getClass().getResource("jss.png")).getImage();
		// btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.setForeground(new Color(0, 139, 139));
		btnNewButton.setFont(new Font("Poor Richard", Font.BOLD, 18));
		btnNewButton.setBackground(new Color(32, 178, 170));
		btnNewButton.setBounds(219, 97, 256, 80);
		contentPane.add(btnNewButton);

		JButton btnEarrings = new JButton("Earrings\r\n");
		btnEarrings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Earrings er = new Earrings();
				er.setVisible(true);
				close();
			}
		});
		// Image img1 = new
		// ImageIcon(this.getClass().getResource("jumki.jpg")).getImage();
		// btnEarrings.setIcon(new ImageIcon(img1));
		btnEarrings.setForeground(new Color(0, 139, 139));
		btnEarrings.setFont(new Font("Poor Richard", Font.BOLD, 18));
		btnEarrings.setBackground(new Color(32, 178, 170));
		btnEarrings.setBounds(219, 200, 256, 80);
		contentPane.add(btnEarrings);

		JLabel lblProductCategories = new JLabel("Product categories");
		lblProductCategories.setFont(new Font("Poor Richard", Font.BOLD, 36));
		lblProductCategories.setBackground(new Color(32, 178, 170));
		lblProductCategories.setBounds(209, 22, 313, 41);
		contentPane.add(lblProductCategories);

	}

}
