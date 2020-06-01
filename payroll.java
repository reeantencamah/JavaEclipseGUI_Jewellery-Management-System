import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class payroll extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtfname;
	private JTextField txtlname;
	private JLabel lblNoOfWorked;
	private JTextField txthw;
	private JLabel lblNoOfOvertimehr;
	private JLabel lblHourlyRate;
	private JLabel lblOvertimeRate;
	private JTextField txtow;
	private JTextField txtor;
	private JTextField txthr;
	private JLabel lblNoOfDay;
	private JTextField txtdw;
	private JButton btnCalculate;
	private JLabel lblNetPay;
	private JTextField txtpay;
	private JButton btnSave;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					payroll frame = new payroll();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
	
	private void clearFields() {
		txthw.setText(null);
		txthr.setText(null);
		txtow.setText(null);
		txtor.setText(null);
		txtdw.setText(null);
		txtpay.setText(null);

	
	}
	
	public void close() {
		this.setVisible(false);
		this.dispose();
	}
	
	/**
	 * Create the frame.
	 */
	public payroll() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				loadtable();
			}
		});
		setTitle("Payroll System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 331);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPayroll = new JLabel("Payroll");
		lblPayroll.setBounds(10, 11, 99, 23);
		lblPayroll.setFont(new Font("Perpetua Titling MT", Font.BOLD, 18));
		contentPane.add(lblPayroll);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 45, 60, 102);
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
						txtfname.setText(rs.getString("Fname"));
						txtlname.setText(rs.getString("Lname"));
						txthw.setText(rs.getString("NoHourW"));
						txthr.setText(rs.getString("HourlyRate"));
						txtow.setText(rs.getString("NoOvertime"));
						txtor.setText(rs.getString("OvertimeRate"));
										
					}
			}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(table);
		
		txtfname = new JTextField();
		txtfname.setBounds(10, 172, 99, 23);
		contentPane.add(txtfname);
		txtfname.setColumns(10);
		
		txtlname = new JTextField();
		txtlname.setColumns(10);
		txtlname.setBounds(10, 215, 99, 23);
		contentPane.add(txtlname);
		
		lblNoOfWorked = new JLabel("No. Of Worked(hr):");
		lblNoOfWorked.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNoOfWorked.setBounds(141, 46, 125, 14);
		contentPane.add(lblNoOfWorked);
		
		txthw = new JTextField();
		txthw.setBounds(265, 43, 60, 20);
		contentPane.add(txthw);
		txthw.setColumns(10);
		
		lblNoOfOvertimehr = new JLabel("No. Of Overtime(hr):");
		lblNoOfOvertimehr.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNoOfOvertimehr.setBounds(141, 79, 125, 14);
		contentPane.add(lblNoOfOvertimehr);
		
		lblHourlyRate = new JLabel("Hourly Rate:");
		lblHourlyRate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHourlyRate.setBounds(346, 47, 99, 14);
		contentPane.add(lblHourlyRate);
		
		lblOvertimeRate = new JLabel("Overtime Rate:");
		lblOvertimeRate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOvertimeRate.setBounds(346, 80, 99, 14);
		contentPane.add(lblOvertimeRate);
		
		txtow = new JTextField();
		txtow.setColumns(10);
		txtow.setBounds(265, 77, 60, 20);
		contentPane.add(txtow);
		
		txtor = new JTextField();
		txtor.setColumns(10);
		txtor.setBounds(442, 77, 60, 20);
		contentPane.add(txtor);
		
		txthr = new JTextField();
		txthr.setColumns(10);
		txthr.setBounds(442, 43, 60, 20);
		contentPane.add(txthr);
		
		lblNoOfDay = new JLabel("No. Of Day Worked:");
		lblNoOfDay.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNoOfDay.setBounds(141, 133, 125, 14);
		contentPane.add(lblNoOfDay);
		
		txtdw = new JTextField();
		txtdw.setColumns(10);
		txtdw.setBounds(265, 127, 60, 20);
		contentPane.add(txtdw);
		
		btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int hw=Integer.parseInt(txthw.getText());
				int hr=Integer.parseInt(txthr.getText());
				int ow=Integer.parseInt(txtow.getText());
				int or=Integer.parseInt(txtor.getText());
				int dw=Integer.parseInt(txtdw.getText());
				
				int pay =(dw*((hw*hr)+(ow*or)));
				txtpay.setText(Integer.toString(pay));
				
			}
		});
		btnCalculate.setBounds(346, 124, 89, 23);
		contentPane.add(btnCalculate);
		
		lblNetPay = new JLabel("Net Pay(Rs):");
		lblNetPay.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNetPay.setBounds(184, 165, 82, 14);
		contentPane.add(lblNetPay);
		
		txtpay = new JTextField();
		txtpay.setColumns(10);
		txtpay.setBounds(265, 163, 82, 20);
		contentPane.add(txtpay);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						Connection myCon=DriverManager.getConnection("jdbc:mysql://localhost/jewellery_shop","root","");
						String sql="update employee set NoHourW='"+txthw.getText()+"',HourlyRate='"+txthr.getText()+"',NoOvertime='"+txtow.getText()+"',OvertimeRate='"+txtor.getText()+"',NetPay='"+txtpay.getText()+"' where Fname='"+txtfname.getText()+"' ";
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
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSave.setBounds(258, 215, 89, 23);
		contentPane.add(btnSave);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeDetails ed = new EmployeeDetails();
				ed.show();
				close();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBounds(370, 215, 89, 23);
		contentPane.add(btnBack);
	}

}
