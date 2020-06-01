//package forms;

import java.sql.*;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.MatteBorder;
import java.awt.Font;

public class MainSupplier extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainSupplier frame = new MainSupplier();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null;
	PreparedStatement pst ;
	ResultSet rs;
	
	private JTable table;
	
	public void close() {
		this.setVisible(false);
		this.dispose();
	}
	
	private void updateTable() {
		String sql = "Select * from supplierregister";
		try {
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public MainSupplier() {
		setResizable(false);
		setTitle("Supplier Form");
		connection = MyConnection.getConnection();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1459, 602);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
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
				EmployeeDetails emp = new EmployeeDetails();
				emp.show();
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
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(5, 5, 266, 560);
		contentPane.add(panel1);
		
		
	
		
		
		JButton btnRegister = new JButton("Register New Supplier");
		btnRegister.setFont(new Font("Courier New", Font.BOLD, 20));
		btnRegister.setBackground(new Color(102, 205, 170));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//create an object of second frame
				Register rframe = new Register();
				rframe.setVisible(true);
				
			}
			
		});
		btnRegister.setBounds(528, 492, 294, 52);
		contentPane.add(btnRegister);
		
		try {
			String query = "Select * from supplierregister";
			pst = connection.prepareStatement(query);
			rs = pst.executeQuery();
			
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setFont(new Font("Poor Richard", Font.BOLD, 18));
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			scrollPane.setBounds(286, 111, 1155, 358);
			contentPane.add(scrollPane);
			
			table = new JTable();
			scrollPane.setViewportView(table);
			table.setRowHeight(30);
			table.setFont(new Font("Poor Richard", Font.BOLD, 20));
			table.setEnabled(true);
			table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			table.setBackground(new Color(230, 230, 250));
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{new Integer(2), "Jenita Joli Fille", "Royal Road La Flora", new Integer(57035021), "j@gmail.com", "Diamond"},
					{new Integer(3), "A&A Company Ltd", "Plaisance, Rose Hill", new Integer(58469356), "a_a@hotmail.com", "Stones"},
					{new Integer(4), "abc ltd", "fatima road, Plaine Magnien", new Integer(6179627), "abc@gmail.com", "Water"},
					{new Integer(5), "kr ltd", "royal road petit raffray", new Integer(52894613), "k@gmail.com", "Stones White"},
					{new Integer(6), "kede ltd", "royal road ebene", new Integer(57896412), "ke@gmail.com", "White Pearl"},
					{new Integer(12), "XYZ Ltd", "Royal Road, Camp Thorel", new Integer(57841391), "xy@yahoo.com", "Shiny White Stones"},
					{new Integer(13), "Figaro Ltd", "Petit lil street, Montagne Long", new Integer(6152342), "f@gmail.com", "Gems Blue"},
					{new Integer(14), "Tylon Ltd", "Royal road Petit Cabane", new Integer(54023146), "t@yahoo.com", "Gem White"},
				},
				new String[] {
					"Id", "Name", "Address", "Contact Number", "Email", "Items"
				}
			));
			table.getColumnModel().getColumn(1).setPreferredWidth(283);
			table.getColumnModel().getColumn(2).setPreferredWidth(400);
			table.getColumnModel().getColumn(3).setPreferredWidth(162);
			table.getColumnModel().getColumn(4).setPreferredWidth(232);
			table.getColumnModel().getColumn(5).setPreferredWidth(216);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				pst.close();
				rs.close();
			} 
			catch (Exception e) {
				
			}
		}
		
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Courier New", Font.BOLD, 20));
		btnDelete.setBackground(new Color(102, 205, 170));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String cell = table.getModel().getValueAt(row,0).toString();
				String sql = "Delete from supplierregister where id = " + cell;
				
				try {
					
					pst = connection.prepareStatement(sql);
					pst.execute();
					updateTable();
					JOptionPane.showMessageDialog(null, "Deleted Successfully");					
					
				}				
				catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Deletion Error");
				}
				finally {
					try {
						pst.close();
						rs.close();
					} 
					catch (Exception ex) {
						
					}
				}
			
				
			}
		});
		btnDelete.setBounds(1005, 492, 128, 52);
		contentPane.add(btnDelete);
		
		JLabel labelSupplier = new JLabel("SUPPLIER");
		labelSupplier.setVerticalAlignment(SwingConstants.TOP);
		labelSupplier.setFont(new Font("Courier New", Font.BOLD, 45));
		labelSupplier.setBounds(689, 43, 247, 45);
		contentPane.add(labelSupplier);
		
		JButton btnView = new JButton("View History");		
		btnView.setFont(new Font("Courier New", Font.BOLD, 21));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Histo rframe = new Histo();
				rframe.setVisible(true);
			}
		});
		btnView.setBackground(new Color(102, 205, 170));
		btnView.setBounds(286, 492, 216, 52);
		contentPane.add(btnView);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Courier New", Font.BOLD, 20));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				updateTable();
			}
		});
		btnUpdate.setBackground(new Color(102, 205, 170));
		btnUpdate.setBounds(850, 492, 128, 52);
		contentPane.add(btnUpdate);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainSupplier.class.getResource("/images/supp.jpg")));
		lblNewLabel.setBounds(580, 16, 99, 79);
		contentPane.add(lblNewLabel);
			
		
	}
}
