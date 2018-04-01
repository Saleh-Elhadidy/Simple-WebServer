package toSubmit;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;

public class ChooseFiles {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseFiles window = new ChooseFiles();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChooseFiles() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 515, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("TextFile1");

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("HERE ta7t");
			}
		});
		btnNewButton.setBounds(26, 40, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("TextFile2");
	
		btnNewButton_1.setBounds(26, 108, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("HERE ta7t");
			}
		});
		
		JButton btnNewButton_2 = new JButton("TextFile3");
		btnNewButton_2.setBounds(26, 171, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("HERE ta7t");
			}
		});
		JButton btnNewButton_3 = new JButton("TextFile4");
		btnNewButton_3.setBounds(26, 232, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("HERE ta7t");
			}
		});
		
		JButton btnNewButton_4 = new JButton("PNG1");
		btnNewButton_4.setBounds(181, 40, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("HERE ta7t");
			}
		});
		
		JButton btnNewButton_5 = new JButton("PNG2");
		btnNewButton_5.setBounds(181, 108, 89, 23);
		frame.getContentPane().add(btnNewButton_5);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("HERE ta7t");
			}
		});
		
		JButton btnNewButton_6 = new JButton("JPEG1");
		btnNewButton_6.setBounds(181, 171, 89, 23);
		frame.getContentPane().add(btnNewButton_6);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("HERE ta7t");
			}
		});
		
		JButton btnNewButton_7 = new JButton("JPEG2");
		btnNewButton_7.setBounds(181, 232, 89, 23);
		frame.getContentPane().add(btnNewButton_7);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("HERE ta7t");
			}
		});
		
		JButton btnNewButton_8 = new JButton("MP4-1");
		btnNewButton_8.setBounds(331, 40, 89, 23);
		frame.getContentPane().add(btnNewButton_8);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("HERE ta7t");
			}
		});
		

		
		textField = new JTextField();
		textField.setBounds(26, 314, 440, 106);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JCheckBox chckbxCloseConnectionNext = new JCheckBox("Close Connection next object");
		chckbxCloseConnectionNext.setBounds(181, 284, 228, 23);
		frame.getContentPane().add(chckbxCloseConnectionNext);
		JButton btnNewButton_9 = new JButton("MP4-2");
		btnNewButton_9.setBounds(331, 108, 89, 23);
		frame.getContentPane().add(btnNewButton_9);
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxCloseConnectionNext.isSelected()){
					System.out.println("it is check right now");
				}
			}
		});
	}
}
