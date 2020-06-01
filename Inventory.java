import java.awt.BorderLayout;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;


public class Inventory extends JFrame {
	
	Connection myConn = null;
	ResultSet rs = null;
	PreparedStatement ps=null;

	private JPanel contentPane;
	private JTable table_Inventory;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inventory frame = new Inventory();
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
	public Inventory() {
		setBackground(new Color(0, 139, 139));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 346);
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
				ProductCategories ps = new ProductCategories();
				ps.show();
				close();
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
		
		table_Inventory = new JTable();
		table_Inventory.setSurrendersFocusOnKeystroke(true);
		table_Inventory.setFillsViewportHeight(true);
		table_Inventory.setColumnSelectionAllowed(true);
		table_Inventory.setCellSelectionEnabled(true);
		table_Inventory.setBounds(196, 22, 368, 165);
		contentPane.add(table_Inventory);
		
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost/jewellery_shop","root","");
		
		String query = "select * from inventoryjewels";
		ps = myConn.prepareStatement(query);
		rs = ps.executeQuery();
		table_Inventory.setModel(DbUtils.resultSetToTableModel(rs));
		
		JButton btnNewOrder = new JButton("New Order");
		btnNewOrder.setFont(new Font("Poor Richard", Font.BOLD, 18));
		btnNewOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderMaterial rframe = new OrderMaterial();
				rframe.setVisible(true);
				close();

			}
		});
		btnNewOrder.setBounds(375, 245, 128, 35);
		contentPane.add(btnNewOrder);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setForeground(Color.RED);
		btnDelete.setFont(new Font("Poor Richard", Font.BOLD, 18));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableModel model = table_Inventory.getModel();
				
				 
				int i = table_Inventory.getSelectedRow();
				((DefaultTableModel) model).removeRow(i);
			}
		});
		btnDelete.setBounds(212, 245, 119, 35);
		contentPane.add(btnDelete);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(10, 11, 165, 280);
		contentPane.add(panel1);
		
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e);
		}
	}
}
