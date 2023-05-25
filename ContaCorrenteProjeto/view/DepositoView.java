package ContaCorrenteProjeto.view;

import ContaCorrenteProjeto.controller.ContaController;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DepositoView {

	private JFrame frame, parentFrame;
	private JTextField textField;
	private ContaController contaController;
	private String saldo;
	/**
	 * Create the application.
	 */
	public DepositoView(String numero_da_conta, String numero_da_agencia, JFrame frame) {
		this.contaController = new ContaController(numero_da_conta, numero_da_agencia);
		this.saldo = ""+contaController.getSaldo();
		this.parentFrame = frame;
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Depósito");
		frame.setBounds(735, 390, 450, 300);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\coisasdovini2\\Programacao\\verissimobanco\\ContaCorrenteProjeto\\view\\Imagens\\vasco escudo.png"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblDepsito = new JLabel("Depósito");
		lblDepsito.setBounds(127, 11, 157, 31);
		lblDepsito.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepsito.setIcon(new ImageIcon("C:\\coisasdovini2\\Programacao\\verissimobanco\\ContaCorrenteProjeto\\view\\Imagens\\ganho.png"));
		lblDepsito.setForeground(new Color(62, 118, 136));
		lblDepsito.setFont(new Font("MS Gothic", Font.BOLD, 30));
		panel.add(lblDepsito);
		
		JLabel lblSaldoAtualR = new JLabel("Saldo Atual R$: "+saldo);
		lblSaldoAtualR.setBounds(10, 54, 414, 26);
		lblSaldoAtualR.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaldoAtualR.setForeground(new Color(62, 118, 136));
		lblSaldoAtualR.setFont(new Font("MS Gothic", Font.BOLD, 25));
		panel.add(lblSaldoAtualR);
		
		JLabel lblDigiteOValor = new JLabel("Digite o valor a ser depositado:");
		lblDigiteOValor.setBounds(45, 91, 337, 21);
		lblDigiteOValor.setHorizontalAlignment(SwingConstants.CENTER);
		lblDigiteOValor.setForeground(new Color(62, 118, 136));
		lblDigiteOValor.setFont(new Font("MS Gothic", Font.BOLD, 20));
		panel.add(lblDigiteOValor);
		
		textField = new JTextField();
		textField.setBounds(45, 123, 337, 27);
		textField.setFont(new Font("MS Gothic", Font.BOLD, 20));
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Depositar");
		btnNewButton.setIcon(new ImageIcon("C:\\coisasdovini2\\Programacao\\verissimobanco\\ContaCorrenteProjeto\\view\\Imagens\\ganho.png"));
		btnNewButton.setBounds(45, 195, 179, 29);
		btnNewButton.setFont(new Font("MS Gothic", Font.BOLD, 20));
		btnNewButton.setForeground(new Color(62, 118, 136));
		panel.add(btnNewButton);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon("C:\\coisasdovini2\\Programacao\\verissimobanco\\ContaCorrenteProjeto\\view\\Imagens\\sair.png"));
		btnSair.setForeground(new Color(62, 118, 136));
		btnSair.setFont(new Font("MS Gothic", Font.BOLD, 20));
		btnSair.setBounds(221, 195, 163, 29);
		panel.add(btnSair);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("MS Gothic", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(45, 163, 337, 21);
		panel.add(lblNewLabel);

		// evento mouse click textfield valor
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel.setText("");
			}
		});
		
		// evento mouse click boato depositar
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!textField.getText().equals("") && contaController.podeDepositar(Float.parseFloat(textField.getText()))) {

					contaController.deposito(Float.parseFloat(textField.getText()));
					saldo = ""+contaController.getSaldo();
					lblNewLabel.setForeground(Color.decode("#008000"));
					lblNewLabel.setText("Deposito Concluido com sucesso!");
					textField.setText("");
					lblSaldoAtualR.setText("Saldo Atual R$: "+saldo);

				}
				else{
					lblNewLabel.setForeground(Color.RED);
					lblNewLabel.setText("Deposito Não Conluído!");
					textField.setText("");

				}
			}
		});

		// evento mouse click botao sair
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				parentFrame.setVisible(true);
				frame.dispose();
				
			}
		});
	}
}
