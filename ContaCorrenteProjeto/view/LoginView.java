package ContaCorrenteProjeto.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginView {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
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
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\coisasdovini2\\Programacao\\verissimobanco\\ContaCorrenteProjeto\\view\\Imagens\\vasco escudo.png"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setIcon(new ImageIcon("C:\\coisasdovini2\\Programacao\\verissimobanco\\ContaCorrenteProjeto\\view\\Imagens\\conecte-se.png"));
		lblNewLabel.setBounds(133, 11, 135, 41);
		lblNewLabel.setFont(new Font("MS Gothic", Font.BOLD, 40));
		lblNewLabel.setForeground(new Color(62, 118, 136));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("MS Gothic", Font.BOLD, 22));
		lblNewLabel_1.setForeground(new Color(62, 118, 136));
		lblNewLabel_1.setBounds(10, 70, 106, 41);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(74, 83, 350, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Numero da Conta:");
		lblNewLabel_1_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1_1.setForeground(new Color(62, 118, 136));
		lblNewLabel_1_1.setFont(new Font("MS Gothic", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(10, 122, 186, 41);
		panel.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(196, 135, 228, 28);
		panel.add(textField_1);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton.setFont(new Font("MS Gothic", Font.BOLD, 20));
		btnNewButton.setForeground(new Color(62, 118, 136));
		btnNewButton.setBounds(155, 174, 106, 28);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Ainda não tem conta?");
		lblNewLabel_2.setFont(new Font("MS Gothic", Font.BOLD, 12));
		lblNewLabel_2.setForeground(new Color(62, 118, 136));
		lblNewLabel_2.setBounds(74, 231, 168, 14);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Criar Conta");
		btnNewButton_1.setForeground(new Color(62, 118, 136));
		btnNewButton_1.setFont(new Font("MS Gothic", Font.BOLD, 12));
		btnNewButton_1.setBounds(214, 227, 106, 23);
		panel.add(btnNewButton_1);
	}
}
