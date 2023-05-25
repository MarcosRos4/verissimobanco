package ContaCorrenteProjeto.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ContaCorrenteProjeto.model.dao.ContasDao;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConfirmacaoCadastroView {

	private JFrame frame;
	private String nome, numero_da_agencia, numero_da_conta;
	private ContasDao contasDao;
	/**
	 * Create the application.
	 */
	public ConfirmacaoCadastroView(String nome, String numero_da_agencia) {
		
		this.nome = nome;
		this.numero_da_agencia = numero_da_agencia;
		this.contasDao = new ContasDao();
		this.numero_da_conta = contasDao.getNumeroConta(nome, numero_da_agencia);

		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Confirmação de Cadastro");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\coisasdovini2\\Programacao\\verissimobanco\\ContaCorrenteProjeto\\view\\Imagens\\vasco escudo.png"));
		frame.setBounds(735, 390, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro bem Sucedido!");
		lblNewLabel.setForeground(new Color(62, 118, 136));
		lblNewLabel.setFont(new Font("MS Gothic", Font.BOLD, 20));
		lblNewLabel.setBounds(91, 11, 233, 21);
		panel.add(lblNewLabel);
		
		JLabel lblNomeDoTitular = new JLabel("Nome do Titular: "+this.nome);
		lblNomeDoTitular.setForeground(new Color(62, 118, 136));
		lblNomeDoTitular.setFont(new Font("MS Gothic", Font.BOLD, 20));
		lblNomeDoTitular.setBounds(30, 59, 394, 21);
		panel.add(lblNomeDoTitular);
		
		JLabel lblAgnciaEscolhida = new JLabel("Agência Escolhida: "+this.numero_da_agencia);
		lblAgnciaEscolhida.setForeground(new Color(62, 118, 136));
		lblAgnciaEscolhida.setFont(new Font("MS Gothic", Font.BOLD, 20));
		lblAgnciaEscolhida.setBounds(30, 103, 394, 21);
		panel.add(lblAgnciaEscolhida);
		
		JLabel lblNumeroDaConta = new JLabel("Numero da Conta: "+this.numero_da_conta);
		lblNumeroDaConta.setForeground(new Color(62, 118, 136));
		lblNumeroDaConta.setFont(new Font("MS Gothic", Font.BOLD, 20));
		lblNumeroDaConta.setBounds(30, 145, 394, 21);
		panel.add(lblNumeroDaConta);
		
		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.setFont(new Font("MS Gothic", Font.BOLD, 15));
		btnNewButton.setForeground(new Color(62, 118, 136));
		btnNewButton.setBounds(158, 206, 119, 30);
		panel.add(btnNewButton);
		
		// evento mouse click botao "Continuar"
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ContaAcessadaView contaAcessadaView = new ContaAcessadaView(numero_da_conta, numero_da_agencia);
				frame.dispose();
			}
		});
	}

}
