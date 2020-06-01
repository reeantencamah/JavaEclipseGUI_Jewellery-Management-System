import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JSplitPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

import java.sql.*;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EmployeeDetails extends JFrame {

	private JPanel contentPane;
	private JTextField txtFname;
	private JTextField txtlname;
	private JTextField txtAdd;
	private JTextField txtPnum;
	private JTextField txtPosition;
	private String gender;
	private JRadioButton rdbtnFemale; 
	private JRadioButton rdbtnMale;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connection myCon=DriverManager.getConnection("jdbc:mysql://localhost/jewellery_shop","root","");
					
					EmployeeDetails frame = new EmployeeDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/** clear textbox **/
	private void clearFields() {
		txtFname.setText(null);
		txtlname.setText(null);
		txtAdd.setText(null);
		txtPnum.setText(null);
		txtPosition.setText(null);
		//rdbtnMale.setSelected(false);
		//rdbtnFemale.setSelected(false);
	
	}
	
	/**public void fillComboBox() {

			try {
				Connection myCon=DriverManager.getConnection("jdbc:mysql://localhost/jewellery_shop","root","");
				String retrive ="select * from employee";
				PreparedStatement pst=myCon.prepareStatement(retrive);			
				ResultSet rs = pst.executeQuery();
				while(rs.next()) {
					String name=rs.getString("Fname");
					cmbId.addItem(name);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
	}**/
	//close the current form
	public void close() {
		this.setVisible(false);
		this.dispose();
	}
	
	public void loadtable() {
		try {
			Connection myCon=DriverManager.getConnection("jdbc:mysql://localhost/jewellery_shop","root","");
			String load ="select EmpId from employee";
			PreparedStatement pst=myCon.prepareStatement(load);			
			ResultSet rs = pst.executeQuery();
			//convert result set to table model-Dbutils is a class in the model
			table.setModel(DbUtils.resultSetToTableModel(rs));

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public EmployeeDetails() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(EmployeeDetails.class.getResource("/images/logo.png")));
		setTitle("Employee Form");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				
				loadtable();
			}
		});
		
		//Connection myCon=null;
		//fillComboBox() ;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 402);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearFields();
			}
		});
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
		
		JLabel label_1 = new JLabel("First Name :");
		label_1.setFont(new Font("Poor Richard", Font.BOLD, 18));
		label_1.setBounds(175, 102, 120, 18);
		contentPane.add(label_1);
		
		txtFname = new JTextField();
		txtFname.setColumns(10);
		txtFname.setBounds(275, 104, 141, 20);
		contentPane.add(txtFname);
		
		JLabel label_2 = new JLabel("Last Name :");
		label_2.setFont(new Font("Poor Richard", Font.BOLD, 18));
		label_2.setBounds(175, 135, 120, 18);
		contentPane.add(label_2);
		
		txtlname = new JTextField();
		txtlname.setColumns(10);
		txtlname.setBounds(275, 137, 141, 20);
		contentPane.add(txtlname);
		
		JLabel label_3 = new JLabel("Gender :");
		label_3.setFont(new Font("Poor Richard", Font.BOLD, 18));
		label_3.setBounds(175, 164, 120, 18);
		contentPane.add(label_3);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender="M";
			}
		});
		rdbtnMale.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnMale.setBackground(new Color(0, 128, 128));
		rdbtnMale.setBounds(253, 165, 62, 23);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender="F";
			}
		});
		rdbtnFemale.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnFemale.setBackground(new Color(0, 128, 128));
		rdbtnFemale.setBounds(321, 165, 109, 23);
		contentPane.add(rdbtnFemale);
		
		JLabel label_4 = new JLabel("Address :");
		label_4.setFont(new Font("Poor Richard", Font.BOLD, 18));
		label_4.setBounds(175, 199, 120, 18);
		contentPane.add(label_4);
		
		txtAdd = new JTextField();
		txtAdd.setColumns(10);
		txtAdd.setBounds(253, 197, 163, 20);
		contentPane.add(txtAdd);
		
		JLabel label_5 = new JLabel("Phone Number :");
		label_5.setFont(new Font("Poor Richard", Font.BOLD, 18));
		label_5.setBounds(175, 228, 120, 18);
		contentPane.add(label_5);
		
		txtPnum = new JTextField();
		txtPnum.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		txtPnum.setColumns(10);
		txtPnum.setBounds(305, 230, 111, 20);
		contentPane.add(txtPnum);
		
		JLabel label_6 = new JLabel("Position :");
		label_6.setFont(new Font("Poor Richard", Font.BOLD, 18));
		label_6.setBounds(175, 263, 120, 18);
		contentPane.add(label_6);
		
		txtPosition = new JTextField();
		txtPosition.setColumns(10);
		txtPosition.setBounds(253, 261, 163, 20);
		contentPane.add(txtPosition);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection myCon=DriverManager.getConnection("jdbc:mysql://localhost/jewellery_shop","root","");
					String sql="Insert into employee(Fname,Lname,Gender,Address,Pnumber,Position) values(?,?,?,?,?,?)";
					PreparedStatement pst=myCon.prepareStatement(sql);
					
					pst.setString(1,txtFname.getText());
					pst.setString(2,txtlname.getText());					
					pst.setString(3,gender);
					pst.setString(4,txtAdd.getText());
					int a=Integer.parseInt(txtPnum.getText());
					pst.setString(5,Integer.toString(a));
					pst.setString(6,txtPosition.getText());
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Employee details saved");
					clearFields();
					
				}
				catch(Exception e1) {
					//JOptionPane.showMessageDialog(null, e1);
					e1.printStackTrace();
				}
				loadtable();
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdd.setBackground(new Color(224, 255, 255));
		btnAdd.setBounds(175, 326, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection myCon=DriverManager.getConnection("jdbc:mysql://localhost/jewellery_shop","root","");
					String sql="delete from employee where Fname='"+txtFname.getText()+"' ";
					PreparedStatement pst=myCon.prepareStatement(sql);
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Employee details deleted");
					clearFields();
					pst.close();
					
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
				loadtable();
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDelete.setBackground(new Color(224, 255, 255));
		btnDelete.setBounds(373, 327, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnSave = new JButton("Update");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection myCon=DriverManager.getConnection("jdbc:mysql://localhost/jewellery_shop","root","");
					String sql="update employee set Fname='"+txtFname.getText()+"',Lname='"+txtlname.getText()+"',Address='"+txtAdd.getText()+"',Pnumber='"+txtPnum.getText()+"',Position='"+txtPosition.getText()+"' where Fname='"+txtFname.getText()+"' ";
					PreparedStatement pst=myCon.prepareStatement(sql);
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Employee details update");
					clearFields();
					pst.close();
					
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSave.setBackground(new Color(224, 255, 255));
		btnSave.setBounds(274, 327, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnEmployee_1 = new JButton("Employee");
		btnEmployee_1.setBackground(new Color(0, 139, 139));
		btnEmployee_1.setIcon(new ImageIcon(EmployeeDetails.class.getResource("/images/employee.png")));
		btnEmployee_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEmployee_1.setBounds(170, 11, 193, 56);
		contentPane.add(btnEmployee_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(466, 11, 62, 135);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					
					int row=table.getSelectedRow();
					String eid=(table.getModel().getValueAt(row, 0).toString());
					
					Connection myCon=DriverManager.getConnection("jdbc:mysql://localhost/jewellery_shop","root","");
					String sql="select * from employee where EmpId='"+eid+"'";
					PreparedStatement pst=myCon.prepareStatement(sql);
					ResultSet rs=pst.executeQuery();
					
					while(rs.next()) {
						txtFname.setText(rs.getString("Fname"));
						txtlname.setText(rs.getString("Lname"));
						txtAdd.setText(rs.getString("Address"));
						txtPnum.setText(rs.getString("Pnumber"));
						txtPosition.setText(rs.getString("position"));
						
						//display retrieve value to radio buttons
						String a=rs.getString("Gender");
						if(a.equals("M")) {
							rdbtnFemale.setSelected(false);
							rdbtnMale.setSelected(true);							
						}
						else if (a.equals("F")) {
							rdbtnMale.setSelected(false);
							rdbtnFemale.setSelected(true);
						}						
					}

				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnPayroll = new JButton("Payroll");
		btnPayroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				payroll p = new payroll();
				p.show();
				close();
			}
		});
		btnPayroll.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPayroll.setBackground(new Color(224, 255, 255));
		btnPayroll.setBounds(460, 165, 89, 23);
		contentPane.add(btnPayroll);
		

	}
}
