package ContaCorrenteProjeto.view;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import ContaCorrenteProjeto.model.dao.ContasDao;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;


public class ContaAcessadaView {

	private JFrame frame;
	private String numero_da_conta, numero_da_agencia, nome, saldo;
	private ContasDao contasDao;
	private boolean olhoStatus = false;
	/**
	 * Create the application.
	 */
	public ContaAcessadaView(String numero_da_conta, String numero_da_agencia) {
		this.numero_da_conta = numero_da_conta;
		this.numero_da_agencia = numero_da_agencia;
		contasDao = new ContasDao();
		this.nome = contasDao.getNome(numero_da_conta, numero_da_agencia);
		this.saldo = ""+contasDao.getSaldo(numero_da_conta, numero_da_agencia);
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Conta de "+this.nome);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(ContaAcessadaView.class.getResource("/ContaCorrenteProjeto/view/Imagens/vasco escudo.png")));
		frame.setBounds((Toolkit.getDefaultToolkit().getScreenSize().width/2)-225, (Toolkit.getDefaultToolkit().getScreenSize().height/2)-150, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Conta de "+this.nome);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(ContaAcessadaView.class.getResource("/ContaCorrenteProjeto/view/Imagens/conta.png")));
		lblNewLabel.setFont(new Font("MS Gothic", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(62, 118, 136));
		lblNewLabel.setBounds(10, 11, 464, 31);
		panel.add(lblNewLabel);
		
		JLabel lblSaldoR = new JLabel("Saldo R$: $$$$$");
		lblSaldoR.setHorizontalAlignment(SwingConstants.LEFT);
		lblSaldoR.setForeground(new Color(62, 118, 136));
		lblSaldoR.setFont(new Font("MS Gothic", Font.BOLD, 15));
		lblSaldoR.setBounds(55, 82, 419, 16);
		panel.add(lblSaldoR);
		
		JButton btndeposito = new JButton("Depósito");
		btndeposito.setIcon(new ImageIcon(ContaAcessadaView.class.getResource("/ContaCorrenteProjeto/view/Imagens/ganho.png")));
		btndeposito.setBounds(10, 137, 103, 33);
		panel.add(btndeposito);
		
		JButton btnSaque = new JButton("Saque");
		btnSaque.setIcon(new ImageIcon(ContaAcessadaView.class.getResource("/ContaCorrenteProjeto/view/Imagens/perdas.png")));
		btnSaque.setBounds(123, 137, 103, 33);
		panel.add(btnSaque);
		
		JButton btnTransferir = new JButton("Transferir");
		btnTransferir.setIcon(new ImageIcon(ContaAcessadaView.class.getResource("/ContaCorrenteProjeto/view/Imagens/transferir.png")));
		btnTransferir.setBounds(252, 137, 109, 33);
		panel.add(btnTransferir);
		
		JButton btnExtrato = new JButton("Extrato");
		btnExtrato.setIcon(new ImageIcon(ContaAcessadaView.class.getResource("/ContaCorrenteProjeto/view/Imagens/extrato.png")));
		btnExtrato.setBounds(371, 137, 103, 33);
		panel.add(btnExtrato);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon(ContaAcessadaView.class.getResource("/ContaCorrenteProjeto/view/Imagens/sair.png")));
		btnSair.setBounds(371, 217, 103, 33);
		panel.add(btnSair);
		
		JButton btnVerSaldo = new JButton("");
		btnVerSaldo.setIcon(new ImageIcon(ContaAcessadaView.class.getResource("/ContaCorrenteProjeto/view/Imagens/olhofechado.png")));
		btnVerSaldo.setBounds(10, 75, 35, 23);
		panel.add(btnVerSaldo);

		// evento mouse click botao extrato
		btnExtrato.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ExtratoView extratoView = new ExtratoView(numero_da_conta, numero_da_agencia, frame);
				olhoStatus = false;
				lblSaldoR.setText("Saldo R$: $$$$$");
				btnVerSaldo.setIcon(new ImageIcon(ContaAcessadaView.class.getResource("/ContaCorrenteProjeto/view/Imagens/olhofechado.png")));
				frame.setVisible(false);
			}
		});
		
		// evento mouse click botao deposito
		btndeposito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepositoView depositoView = new DepositoView(numero_da_conta, numero_da_agencia, frame);
				olhoStatus = false;
				lblSaldoR.setText("Saldo R$: $$$$$");
				btnVerSaldo.setIcon(new ImageIcon(ContaAcessadaView.class.getResource("/ContaCorrenteProjeto/view/Imagens/olhofechado.png")));
				frame.setVisible(false);
			}
		});

		// evento mouse click botao saque
		btnSaque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaqueView saqueView = new SaqueView(numero_da_conta, numero_da_agencia, frame);
				olhoStatus = false;
				lblSaldoR.setText("Saldo R$: $$$$$");
				btnVerSaldo.setIcon(new ImageIcon(ContaAcessadaView.class.getResource("/ContaCorrenteProjeto/view/Imagens/olhofechado.png")));
				frame.setVisible(false);
			}
		});

		// evento mouse click botao sair
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginView loginView = new LoginView();
				frame.dispose();
			}
		});
		
		// evento mouse click botao transferir
		btnTransferir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TransferenciaView transferenciaView = new TransferenciaView(numero_da_conta, numero_da_agencia, frame);
				olhoStatus = false;
				lblSaldoR.setText("Saldo R$: $$$$$");
				btnVerSaldo.setIcon(new ImageIcon(ContaAcessadaView.class.getResource("/ContaCorrenteProjeto/view/Imagens/olhofechado.png")));
				frame.setVisible(false);
			}
		});
		
		// evento mouse click boato mostrar o saldo
		btnVerSaldo.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!olhoStatus) {
					saldo = ""+contasDao.getSaldo(numero_da_conta, numero_da_agencia);
					olhoStatus = true;
					lblSaldoR.setText("Saldo R$: "+ saldo);
					btnVerSaldo.setIcon(new ImageIcon(ContaAcessadaView.class.getResource("/ContaCorrenteProjeto/view/Imagens/olhoaberto.png")));
					 
				}
				else{
					olhoStatus = false;
					lblSaldoR.setText("Saldo R$: $$$$$");
					btnVerSaldo.setIcon(new ImageIcon(ContaAcessadaView.class.getResource("/ContaCorrenteProjeto/view/Imagens/olhofechado.png")));
				}
				
			}
		});
	}

	
}
