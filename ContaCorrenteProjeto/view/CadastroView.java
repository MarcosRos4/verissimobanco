package ContaCorrenteProjeto.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroView {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroView window = new CadastroView();
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
	public CadastroView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro");
		lblNewLabel.setForeground(new Color(62, 118, 136));
		lblNewLabel.setFont(new Font("MS Gothic", Font.BOLD, 40));
		lblNewLabel.setBounds(122, 11, 181, 63);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setForeground(new Color(62, 118, 136));
		lblNewLabel_1.setFont(new Font("MS Gothic", Font.BOLD, 22));
		lblNewLabel_1.setBounds(10, 85, 106, 41);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Agência:");
		lblNewLabel_1_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1_1.setForeground(new Color(62, 118, 136));
		lblNewLabel_1_1.setFont(new Font("MS Gothic", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(10, 128, 106, 41);
		panel.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(77, 98, 347, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("1");
		rdbtnNewRadioButton.setVerticalAlignment(SwingConstants.BOTTOM);
		rdbtnNewRadioButton.setFont(new Font("MS Gothic", Font.BOLD, 15));
		rdbtnNewRadioButton.setBounds(122, 136, 45, 36);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("2");
		rdbtnNewRadioButton_1.setVerticalAlignment(SwingConstants.BOTTOM);
		rdbtnNewRadioButton_1.setFont(new Font("MS Gothic", Font.BOLD, 15));
		rdbtnNewRadioButton_1.setBounds(169, 136, 45, 36);
		panel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("3");
		rdbtnNewRadioButton_2.setVerticalAlignment(SwingConstants.BOTTOM);
		rdbtnNewRadioButton_2.setFont(new Font("MS Gothic", Font.BOLD, 15));
		rdbtnNewRadioButton_2.setBounds(216, 136, 45, 36);
		panel.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("4");
		rdbtnNewRadioButton_3.setVerticalAlignment(SwingConstants.BOTTOM);
		rdbtnNewRadioButton_3.setFont(new Font("MS Gothic", Font.BOLD, 15));
		rdbtnNewRadioButton_3.setBounds(263, 136, 45, 36);
		panel.add(rdbtnNewRadioButton_3);
		
		JButton btnNewButton = new JButton("Cadastrar Conta");
		btnNewButton.setForeground(new Color(62, 118, 136));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("MS Gothic", Font.BOLD, 15));
		btnNewButton.setBounds(122, 198, 181, 23);
		panel.add(btnNewButton);
	}
}
