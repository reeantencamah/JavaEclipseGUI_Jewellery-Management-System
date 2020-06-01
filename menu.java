

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
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
	public menu() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(menu.class.getResource("/images/logo.png")));
		setTitle("Vi-Jewellery Dashboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 344);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(47, 79, 79));
		panel.setBounds(0, 0, 167, 315);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(menu.class.getResource("/images/logo5.png")));
		lblNewLabel.setBounds(20, 42, 147, 126);
		panel.add(lblNewLabel);
		
		JLabel lblVijewellery = new JLabel("Vi-Jewellery");
		lblVijewellery.setForeground(new Color(250, 128, 114));
		lblVijewellery.setFont(new Font("Perpetua Titling MT", Font.BOLD, 16));
		lblVijewellery.setBounds(20, 168, 127, 31);
		panel.add(lblVijewellery);
		
		JLabel lblUniqueeloquent = new JLabel("Unique.Eloquent.Dazzling");
		lblUniqueeloquent.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblUniqueeloquent.setForeground(new Color(222, 184, 135));
		lblUniqueeloquent.setBounds(20, 191, 127, 42);
		panel.add(lblUniqueeloquent);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(menu.class.getResource("/images/2.png")));
		lblNewLabel_1.setBounds(0, 254, 167, 42);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(menu.class.getResource("/images/2.png")));
		lblNewLabel_2.setBounds(0, 0, 167, 31);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Product");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductCategories pc = new ProductCategories();
				pc.show();
				close();
			}
		});
		btnNewButton.setBackground(new Color(176, 196, 222));
		btnNewButton.setFont(new Font("Perpetua Titling MT", Font.BOLD, 11));
		btnNewButton.setBounds(177, 113, 101, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(menu.class.getResource("/images/m1.png")));
		lblNewLabel_3.setBounds(188, 27, 83, 89);
		contentPane.add(lblNewLabel_3);
		
		JButton btnSupplier = new JButton("Supplier");
		btnSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainSupplier sup = new MainSupplier();
				sup.show();
				close();
			}
		});
		btnSupplier.setFont(new Font("Perpetua Titling MT", Font.BOLD, 11));
		btnSupplier.setBackground(new Color(176, 196, 222));
		btnSupplier.setBounds(317, 112, 101, 23);
		contentPane.add(btnSupplier);
		
		JButton btnOrder = new JButton("Order");
		btnOrder.setFont(new Font("Perpetua Titling MT", Font.BOLD, 11));
		btnOrder.setBackground(new Color(176, 196, 222));
		btnOrder.setBounds(177, 233, 101, 23);
		contentPane.add(btnOrder);
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.setFont(new Font("Perpetua Titling MT", Font.BOLD, 11));
		btnCustomer.setBackground(new Color(176, 196, 222));
		btnCustomer.setBounds(452, 112, 101, 23);
		contentPane.add(btnCustomer);
		
		JButton btnInventory = new JButton("Inventory");
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inventory in = new Inventory();
				in.show();
				close();
			}
		});
		btnInventory.setFont(new Font("Perpetua Titling MT", Font.BOLD, 11));
		btnInventory.setBackground(new Color(176, 196, 222));
		btnInventory.setBounds(305, 232, 124, 23);
		contentPane.add(btnInventory);
		
		JButton btnEmployee = new JButton("Employee");
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeDetails ed = new EmployeeDetails();
				ed.show();
				close();
			}
		});
		btnEmployee.setFont(new Font("Perpetua Titling MT", Font.BOLD, 11));
		btnEmployee.setBackground(new Color(176, 196, 222));
		btnEmployee.setBounds(452, 232, 101, 23);
		contentPane.add(btnEmployee);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setIcon(new ImageIcon(menu.class.getResource("/images/m2.png")));
		lblNewLabel_4.setBounds(313, 27, 105, 78);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(menu.class.getResource("/images/m3.png")));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(452, 38, 101, 72);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setIcon(new ImageIcon(menu.class.getResource("/images/m4.png")));
		lblNewLabel_6.setBounds(177, 162, 101, 66);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(menu.class.getResource("/images/m5.png")));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(307, 162, 124, 72);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setIcon(new ImageIcon(menu.class.getResource("/images/m6.png")));
		lblNewLabel_8.setBounds(452, 162, 101, 66);
		contentPane.add(lblNewLabel_8);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnNewButton_1.setBackground(new Color(205, 92, 92));
		btnNewButton_1.setFont(new Font("Perpetua Titling MT", Font.BOLD, 13));
		btnNewButton_1.setBounds(327, 281, 89, 23);
		contentPane.add(btnNewButton_1);
	}

}
