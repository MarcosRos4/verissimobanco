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
import java.awt.Toolkit;

import javax.swing.ImageIcon;

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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\coisasdovini2\\Programacao\\verissimobanco\\ContaCorrenteProjeto\\view\\Imagens\\vasco escudo.png"));
		frame.setResizable(false);
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro");
		lblNewLabel.setIcon(new ImageIcon("C:\\coisasdovini2\\Programacao\\verissimobanco\\ContaCorrenteProjeto\\view\\Imagens\\cadastro.png"));
		lblNewLabel.setBounds(134, 64, 199, 41);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(62, 118, 136));
		lblNewLabel.setFont(new Font("MS Gothic", Font.BOLD, 40));
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("MS Gothic", Font.BOLD, 15));
		textField.setBounds(120, 212, 239, 22);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Agência:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(188, 116, 100, 23);
		lblNewLabel_1_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1_1.setForeground(new Color(62, 118, 136));
		lblNewLabel_1_1.setFont(new Font("MS Gothic", Font.BOLD, 22));
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(202, 178, 75, 23);
		lblNewLabel_1.setForeground(new Color(62, 118, 136));
		lblNewLabel_1.setFont(new Font("MS Gothic", Font.BOLD, 22));
		panel.add(lblNewLabel_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("3");
		rdbtnNewRadioButton_2.setBounds(244, 146, 33, 25);
		rdbtnNewRadioButton_2.setVerticalAlignment(SwingConstants.BOTTOM);
		rdbtnNewRadioButton_2.setFont(new Font("MS Gothic", Font.BOLD, 15));
		panel.add(rdbtnNewRadioButton_2);
		
		JButton btnNewButton = new JButton("Cadastrar Conta");
		btnNewButton.setBounds(120, 259, 239, 35);
		btnNewButton.setForeground(new Color(62, 118, 136));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("4");
		rdbtnNewRadioButton_3.setBounds(279, 146, 33, 25);
		rdbtnNewRadioButton_3.setVerticalAlignment(SwingConstants.BOTTOM);
		rdbtnNewRadioButton_3.setFont(new Font("MS Gothic", Font.BOLD, 15));
		panel.add(rdbtnNewRadioButton_3);
		btnNewButton.setFont(new Font("MS Gothic", Font.BOLD, 25));
		panel.add(btnNewButton);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("1");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(174, 146, 33, 25);
		rdbtnNewRadioButton.setVerticalAlignment(SwingConstants.BOTTOM);
		rdbtnNewRadioButton.setFont(new Font("MS Gothic", Font.BOLD, 15));
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("2");
		rdbtnNewRadioButton_1.setBounds(209, 146, 33, 25);
		rdbtnNewRadioButton_1.setVerticalAlignment(SwingConstants.BOTTOM);
		rdbtnNewRadioButton_1.setFont(new Font("MS Gothic", Font.BOLD, 15));
		panel.add(rdbtnNewRadioButton_1);
	}
}
