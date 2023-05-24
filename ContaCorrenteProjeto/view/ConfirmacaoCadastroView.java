package ContaCorrenteProjeto.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Toolkit;

public class ConfirmacaoCadastroView {

	private JFrame frame;
	/**
	 * Create the application.
	 */
	public ConfirmacaoCadastroView() {
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
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro bem Sucedido!");
		lblNewLabel.setForeground(new Color(62, 118, 136));
		lblNewLabel.setFont(new Font("MS Gothic", Font.BOLD, 20));
		lblNewLabel.setBounds(91, 11, 233, 21);
		panel.add(lblNewLabel);
		
		JLabel lblNomeDoTitular = new JLabel("Nome do Titular:");
		lblNomeDoTitular.setForeground(new Color(62, 118, 136));
		lblNomeDoTitular.setFont(new Font("MS Gothic", Font.BOLD, 20));
		lblNomeDoTitular.setBounds(30, 59, 222, 21);
		panel.add(lblNomeDoTitular);
		
		JLabel lblAgnciaEscolhida = new JLabel("Agência Escolhida:");
		lblAgnciaEscolhida.setForeground(new Color(62, 118, 136));
		lblAgnciaEscolhida.setFont(new Font("MS Gothic", Font.BOLD, 20));
		lblAgnciaEscolhida.setBounds(30, 103, 222, 21);
		panel.add(lblAgnciaEscolhida);
		
		JLabel lblNumeroDaConta = new JLabel("Numero da Conta:");
		lblNumeroDaConta.setForeground(new Color(62, 118, 136));
		lblNumeroDaConta.setFont(new Font("MS Gothic", Font.BOLD, 20));
		lblNumeroDaConta.setBounds(30, 145, 222, 21);
		panel.add(lblNumeroDaConta);
		
		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.setFont(new Font("MS Gothic", Font.BOLD, 15));
		btnNewButton.setForeground(new Color(62, 118, 136));
		btnNewButton.setBounds(158, 206, 109, 25);
		panel.add(btnNewButton);
	}

}
