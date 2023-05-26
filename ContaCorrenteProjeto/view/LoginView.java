package ContaCorrenteProjeto.view;

import ContaCorrenteProjeto.model.dao.ContasDao;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;



import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class LoginView {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	ContasDao contasDao = new ContasDao();
	/**
	 * Create the application.
	 */
	public LoginView() {
		
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Login");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginView.class.getResource("/ContaCorrenteProjeto/view/Imagens/vasco escudo.png")));
		frame.setBounds((Toolkit.getDefaultToolkit().getScreenSize().width/2)-225, (Toolkit.getDefaultToolkit().getScreenSize().height/2)-150, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Agência: ");
		lblNewLabel_3.setForeground(new Color(62, 118, 136));
		lblNewLabel_3.setFont(new Font("MS Gothic", Font.BOLD, 22));
		lblNewLabel_3.setBounds(10, 141, 105, 23);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("Login ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(LoginView.class.getResource("/ContaCorrenteProjeto/view/Imagens/conecte-se.png")));
		lblNewLabel.setBounds(10, 11, 414, 41);
		lblNewLabel.setFont(new Font("MS Gothic", Font.BOLD, 40));
		lblNewLabel.setForeground(new Color(62, 118, 136));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("MS Gothic", Font.BOLD, 22));
		lblNewLabel_1.setForeground(new Color(62, 118, 136));
		lblNewLabel_1.setBounds(10, 68, 58, 23);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(74, 63, 350, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Numero da Conta:");
		lblNewLabel_1_1.setForeground(new Color(62, 118, 136));
		lblNewLabel_1_1.setFont(new Font("MS Gothic", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(10, 107, 186, 23);
		panel.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(196, 102, 228, 28);
		panel.add(textField_1);
		
		JButton btnNewButton = new JButton("Entrar");
		
		btnNewButton.setFont(new Font("MS Gothic", Font.BOLD, 20));
		btnNewButton.setForeground(new Color(62, 118, 136));
		btnNewButton.setBounds(147, 188, 106, 28);
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
		
		JRadioButton rdbtnNewRadioButton_0 = new JRadioButton("1");
		rdbtnNewRadioButton_0.setFont(new Font("MS Gothic", Font.BOLD, 15));
		rdbtnNewRadioButton_0.setBounds(121, 145, 33, 25);
		panel.add(rdbtnNewRadioButton_0);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("2");
		rdbtnNewRadioButton_1.setFont(new Font("MS Gothic", Font.BOLD, 15));
		rdbtnNewRadioButton_1.setBounds(156, 145, 33, 25);
		panel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("3");
		rdbtnNewRadioButton_2.setFont(new Font("MS Gothic", Font.BOLD, 15));
		rdbtnNewRadioButton_2.setBounds(191, 145, 33, 25);
		panel.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("4");
		rdbtnNewRadioButton_3.setFont(new Font("MS Gothic", Font.BOLD, 15));
		rdbtnNewRadioButton_3.setBounds(226, 145, 33, 25);
		panel.add(rdbtnNewRadioButton_3);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnNewRadioButton_0);
		buttonGroup.add(rdbtnNewRadioButton_1);
		buttonGroup.add(rdbtnNewRadioButton_2);
		buttonGroup.add(rdbtnNewRadioButton_3);

		// evento mouse click botao "Entrar"
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
				String agenciaEscolhida;
				if (rdbtnNewRadioButton_0.isSelected()) {
					agenciaEscolhida = "1";
				}
				else if (rdbtnNewRadioButton_1.isSelected()) {
					agenciaEscolhida = "2";
				}
				else if (rdbtnNewRadioButton_2.isSelected()) {
					agenciaEscolhida = "3";
				}
				else{
					agenciaEscolhida = "4";
				}
								
				if (contasDao.existe(textField_1.getText())) {
					ContaAcessadaView contaAcessadaView = new ContaAcessadaView(textField_1.getText(), agenciaEscolhida);
					frame.dispose();
				}
				else{

				}
			}
		});

		// evento mouse click boasto "Criar Conta"
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CadastroView cadastroView = new CadastroView();
				frame.dispose();
			}
		});
	}
}
