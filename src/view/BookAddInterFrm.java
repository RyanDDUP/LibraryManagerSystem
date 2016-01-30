package view;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.BookDao;
import dao.BookTypeDao;
import model.Book;
import model.BookType;
import util.DB_util;
import util.StringUtil;

public class BookAddInterFrm extends JInternalFrame {
	private JTextField authorTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField priceTxt;
	
	private DB_util dbutil = new DB_util();
	private BookTypeDao bookTypeDao = new BookTypeDao();
	private BookDao bookDao = new BookDao();
	private JComboBox bookTypeJcb = new JComboBox();
	private JTextField bookNameTxt;
	private JTextArea bookDescTxt;
	private JRadioButton maleJrb;
	private JRadioButton femaleJrb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAddInterFrm frame = new BookAddInterFrm();
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
	public BookAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("Book Add");
		setBounds(100, 100, 478, 444);
		
		JLabel lblBookName = new JLabel("Book Name:");
		
		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);
		
		JLabel lblAuthor = new JLabel("Author:");
		
		authorTxt = new JTextField();
		authorTxt.setColumns(10);
		
		JLabel lblAuthorSex = new JLabel("Author Sex:");
		
		maleJrb = new JRadioButton("M");
		buttonGroup.add(maleJrb);
		maleJrb.setSelected(true);
		
		femaleJrb = new JRadioButton("F");
		buttonGroup.add(femaleJrb);
		
		JLabel lblPrice = new JLabel("Price:");
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel lblBook = new JLabel("Book Desc:");
		
		bookDescTxt = new JTextArea();
		
		JLabel lblBookType = new JLabel("Book Type:");
		
		bookTypeJcb = new JComboBox();
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//////////////////
				try {
					bookAddActionPerformed(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnAdd.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/add.png")));
		
		JButton btnRest = new JButton("Rest");
		btnRest.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/reset.png")));
		btnRest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValue();
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBookName, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblAuthorSex)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblBook)
								.addComponent(lblBookType))))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblAuthor))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(bookTypeJcb, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
											.addComponent(maleJrb)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(femaleJrb)))
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblPrice)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(authorTxt, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(priceTxt, 0, 0, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(31))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(169, Short.MAX_VALUE)
					.addComponent(btnAdd)
					.addGap(56)
					.addComponent(btnRest)
					.addGap(118))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBookName, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAuthor)
						.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAuthorSex)
						.addComponent(maleJrb)
						.addComponent(femaleJrb)
						.addComponent(lblPrice)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBookType)
						.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBook)
						.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRest)
						.addComponent(btnAdd))
					.addGap(34))
		);
		getContentPane().setLayout(groupLayout);
		fillBookType();
	}
	
	/**
	 * book add function;
	 * @param e
	 * @throws SQLException 
	 */
	protected void bookAddActionPerformed(ActionEvent e) throws SQLException {
		String bookName = this.bookNameTxt.getText();
		String author = this.authorTxt.getText();
		
		String price = this.priceTxt.getText();
		String bookDesc = this.bookDescTxt.getText();
		if (StringUtil.isEmpty(bookName)) {
			JOptionPane.showMessageDialog(null, "Empty BookName!");
			return ; 
		}
		if (StringUtil.isEmpty(author)) {
			JOptionPane.showMessageDialog(null, "Empty author!");
			return ; 
		}
		if (StringUtil.isEmpty(this.priceTxt.getText())) {
			JOptionPane.showMessageDialog(null, "Empty price!");
			return ; 
		}
		
		String sex = "";
		if(maleJrb.isSelected()) {
			sex="male";
			
		}else if(femaleJrb.isSelected()) {
			sex="female";
		}
		BookType bookType = (BookType) bookTypeJcb.getSelectedItem();
		int bookTypeId = bookType.getId();
		
		Book book = new Book(bookName, author,sex, Float.parseFloat(price),bookDesc);
		
		Connection conn =null;
		
		try {
			conn = dbutil.getConn();
			int addNum = bookDao.add(conn, book);
			if(addNum==1) {
				JOptionPane.showMessageDialog(null, "Add Successfully");
				resetValue();
			}else{
				JOptionPane.showMessageDialog(null, "Add Fail");
			}
		} catch (HeadlessException e1) {
			JOptionPane.showMessageDialog(null, "Add Fail");
			e1.printStackTrace();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Add Fail");
			e1.printStackTrace();
		}finally{
			conn.close();;
			
		}
		
	}

	private void resetValue() {
		this.bookNameTxt.setText("");
		this.authorTxt.setText("");
		this.priceTxt.setText("");
		this.maleJrb.setSelected(true);
		this.bookDescTxt.setText("");
		
		if(this.bookTypeJcb.getItemCount()>0){
			this.bookTypeJcb.setSelectedIndex(0);
		}
		
	}

	/**
	 * bookType choice
	 */
	private void fillBookType() {
		Connection conn = null;
		try {
			conn = dbutil.getConn();
			BookType bookType = null;
			ResultSet rst = bookTypeDao.list(conn, new BookType());

			while(rst.next()){
				bookType = new BookType();
				bookType.setId(rst.getInt("id"));
				bookType.setBookTypeName(rst.getString("bookTypeName"));
				this.bookTypeJcb.addItem(bookType.getBookTypeName());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			
		}
	}
}
