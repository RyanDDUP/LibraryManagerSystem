package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class BookTypeManagerFrm extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeManagerFrm frame = new BookTypeManagerFrm();
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
	public BookTypeManagerFrm() {
		setBounds(100, 100, 450, 300);

	}

}
