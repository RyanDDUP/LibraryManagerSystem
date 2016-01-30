package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class About extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
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
	public About() {
		getContentPane().setBackground(new Color(148, 0, 211));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(About.class.getResource("/images/nyu.jpg")));
		
		JLabel lblRyanZhang = new JLabel("Ryan Zhang");
		lblRyanZhang.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		
		JLabel lblCeGradStudent = new JLabel("CE Grad Student");
		lblCeGradStudent.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		
		JLabel lblRznyuedu = new JLabel("rz1015@nyu.edu");
		lblRznyuedu.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCeGradStudent, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRyanZhang, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRznyuedu))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(73)
							.addComponent(lblRyanZhang)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCeGradStudent)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblRznyuedu)))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		setTitle("About me");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);

	}

}
