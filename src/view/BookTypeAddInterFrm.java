package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.BookTypeDao;
import model.BookType;
import util.DB_util;
import util.StringUtil;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class BookTypeAddInterFrm extends JInternalFrame {
	private JTextField bookTypeNametxt;
	private JTextArea bookTypeDesctxt;
	
	private DB_util dbUtil = new DB_util();
	private BookTypeDao bookTypeDao = new BookTypeDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) { 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeAddInterFrm frame = new BookTypeAddInterFrm();
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
	public BookTypeAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("BookType Add Frame");
		setBounds(100, 100, 450, 300);
		
		JLabel lblBooktypeName = new JLabel("BookType Name:");
		
		JLabel lblBooktypeDescription = new JLabel("BookType Description:");
		
		bookTypeNametxt = new JTextField();
		bookTypeNametxt.setColumns(10);
		
		bookTypeDesctxt = new JTextArea();
		
		JButton btnAdd = new JButton(" Add ");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeAddActionPerfomed(e);
			}
		});
		btnAdd.setIcon(new ImageIcon(BookTypeAddInterFrm.class.getResource("/images/add.png")));
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reSetValueAcionPerformed(e);
			}
		});
		btnReset.setIcon(new ImageIcon(BookTypeAddInterFrm.class.getResource("/images/reset.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblBooktypeDescription)
						.addComponent(btnAdd)
						.addComponent(lblBooktypeName))
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnReset)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(bookTypeNametxt, Alignment.LEADING)
								.addComponent(bookTypeDesctxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(bookTypeNametxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBooktypeName))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(bookTypeDesctxt, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBooktypeDescription))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdd)
						.addComponent(btnReset))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
	
	/**
	 * add book funcktion;
	 * @param e
	 */
	private void bookTypeAddActionPerfomed(ActionEvent evt) {
		String bookTypeName = this.bookTypeNametxt.getText();
		String bookTypeDesc = this.bookTypeDesctxt.getText();
		if (StringUtil.isEmpty(bookTypeName)) {
			JOptionPane.showMessageDialog(null, "Empty BookType!");
			return ; 
		}
		
		BookType bookType  = new BookType(bookTypeName, bookTypeDesc);
		Connection conn = null;
		conn = dbUtil.getConn();
		try {
			int n = bookTypeDao.add(conn, bookType);
			
			if (n ==1) {
				JOptionPane.showMessageDialog(null, "Add Successfully!");
				reSetValue();
			}else if (n == -1) {
				JOptionPane.showMessageDialog(null, "Add Failed! BookType existed.");
				reSetValue();
			}else {
				
		
				JOptionPane.showMessageDialog(null, "Add Failed!Try again...");
				reSetValue();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Add Failed!Try again...");
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.reSetValue();
		
	}

	private void reSetValueAcionPerformed(ActionEvent evt) {
		this.reSetValue();
		
	}

	/**
	 * Reset Value;
	 */
	private void reSetValue() {
		this.bookTypeNametxt.setText("");
		this.bookTypeDesctxt.setText("");
		
	}
}
