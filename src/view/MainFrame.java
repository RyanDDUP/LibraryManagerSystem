  package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
	private JDesktopPane  table = null;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setTitle("Library Manager Main Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnBasicMaintainance = new JMenu("Basic Maintainance");
		mnBasicMaintainance.setIcon(new ImageIcon(MainFrame.class.getResource("/images/base.png")));
		menuBar.add(mnBasicMaintainance);
		
		JMenu mnBooksClaa = new JMenu("Book Clacification");
		mnBooksClaa.setIcon(new ImageIcon(MainFrame.class.getResource("/images/bookTypeManager.png")));
		mnBasicMaintainance.add(mnBooksClaa);
		
		JMenuItem mntmAddClass = new JMenuItem("Add Class");
		mntmAddClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BookTypeAddInterFrm bookTypeAddInterFrm =new BookTypeAddInterFrm();
				bookTypeAddInterFrm.setVisible(true);
				table.add(bookTypeAddInterFrm);
				
			}
		});
		mntmAddClass.setIcon(new ImageIcon(MainFrame.class.getResource("/images/add.png")));
		mnBooksClaa.add(mntmAddClass);
		
		JMenuItem mntmClassMaintainance = new JMenuItem("Class Maintainance");
		mntmClassMaintainance.setIcon(new ImageIcon(MainFrame.class.getResource("/images/edit.png")));
		mnBooksClaa.add(mntmClassMaintainance);
		
		JMenu mnBooksMaintainance = new JMenu("Book Maintainance");
		mnBooksMaintainance.setIcon(new ImageIcon(MainFrame.class.getResource("/images/bookManager.png")));
		mnBasicMaintainance.add(mnBooksMaintainance);
		
		JMenuItem mntmAddBook = new JMenuItem("Add Book");
		mntmAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAddInterFrm bookAddInterFrm =new BookAddInterFrm();
				bookAddInterFrm.setVisible(true);
				table.add(bookAddInterFrm);
			} 
		});
		mntmAddBook.setIcon(new ImageIcon(MainFrame.class.getResource("/images/add.png")));
		mnBooksMaintainance.add(mntmAddBook);
		
		JMenuItem mntmBooksMaintainance = new JMenuItem("Book Maintainance");
		mntmBooksMaintainance.setIcon(new ImageIcon(MainFrame.class.getResource("/images/modify.png")));
		mnBooksMaintainance.add(mntmBooksMaintainance);
		
		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mntmLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog( null, "Exit System?"); //返回0,1,2
				if (result == 0) {
					dispose();
				}
			}
		});
		mntmLogOut.setIcon(new ImageIcon(MainFrame.class.getResource("/images/exit.png")));
		mnBasicMaintainance.add(mntmLogOut);
		
		JMenu mnAboutUs = new JMenu("About US");
		mnAboutUs.setIcon(new ImageIcon(MainFrame.class.getResource("/images/about.png")));
		menuBar.add(mnAboutUs);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Contact info:rz1015@nyu.edu");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				About about = new About();
				about.setVisible(true);
				table.add(about); 
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/images/me.png")));
		mnAboutUs.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		table = new JDesktopPane();
		contentPane.add(table, BorderLayout.CENTER);
		
		//set max size;
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
