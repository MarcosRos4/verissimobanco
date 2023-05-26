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
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SaqueView {

	private JFrame frame, parentFrame;
	private JTextField txtDigiteUmValor;
	private ContaController contaController;
	private String saldo;
	/**
	 * Create the application.
	 */
	public SaqueView(String numero_da_conta, String numero_da_agencia, JFrame frame) {
		this.parentFrame = frame;
		this.contaController = new ContaController(numero_da_conta, numero_da_agencia);
		this.saldo = ""+contaController.getSaldo();
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(SaqueView.class.getResource("/ContaCorrenteProjeto/view/Imagens/vasco escudo.png")));
		frame.setBounds((Toolkit.getDefaultToolkit().getScreenSize().width/2)-225, (Toolkit.getDefaultToolkit().getScreenSize().height/2)-150, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblSaque = new JLabel("Saque");
		lblSaque.setBounds(156, 11, 109, 31);
		lblSaque.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaque.setIcon(new ImageIcon(SaqueView.class.getResource("/ContaCorrenteProjeto/view/Imagens/perdas.png")));
		lblSaque.setForeground(new Color(62, 118, 136));
		lblSaque.setFont(new Font("MS Gothic", Font.BOLD, 30));
		panel.add(lblSaque);
		
		JLabel lblSaldoAtualR = new JLabel("Saldo Atual R$: "+saldo);
		lblSaldoAtualR.setBounds(10, 53, 414, 26);
		lblSaldoAtualR.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaldoAtualR.setForeground(new Color(62, 118, 136));
		lblSaldoAtualR.setFont(new Font("MS Gothic", Font.BOLD, 25));
		panel.add(lblSaldoAtualR);
		
		JLabel lblDigiteOValor_1 = new JLabel("Digite o valor a ser sacado:");
		lblDigiteOValor_1.setBounds(69, 90, 294, 21);
		lblDigiteOValor_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDigiteOValor_1.setForeground(new Color(62, 118, 136));
		lblDigiteOValor_1.setFont(new Font("MS Gothic", Font.BOLD, 20));
		panel.add(lblDigiteOValor_1);
		
		txtDigiteUmValor = new JTextField();
		txtDigiteUmValor.setBounds(69, 122, 294, 27);
		txtDigiteUmValor.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigiteUmValor.setFont(new Font("MS Gothic", Font.BOLD, 20));
		txtDigiteUmValor.setColumns(10);
		panel.add(txtDigiteUmValor);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("MS Gothic", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(69, 163, 294, 21);
		panel.add(lblNewLabel);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon(SaqueView.class.getResource("/ContaCorrenteProjeto/view/Imagens/sair.png")));
		btnSair.setForeground(new Color(62, 118, 136));
		btnSair.setFont(new Font("MS Gothic", Font.BOLD, 20));
		btnSair.setBounds(218, 195, 145, 29);
		panel.add(btnSair);
		
		JButton btnSacar = new JButton("Sacar");
		btnSacar.setIcon(new ImageIcon(SaqueView.class.getResource("/ContaCorrenteProjeto/view/Imagens/perdas.png")));
		btnSacar.setForeground(new Color(62, 118, 136));
		btnSacar.setFont(new Font("MS Gothic", Font.BOLD, 20));
		btnSacar.setBounds(69, 195, 150, 29);
		panel.add(btnSacar);

		// evento mouse click botao sair
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				parentFrame.setVisible(true);
				frame.dispose();
			}
		});

		// evento mouse click botao sacar
		btnSacar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (!txtDigiteUmValor.getText().equals("") && contaController.podeSacar(Float.parseFloat(txtDigiteUmValor.getText()))) {
					
					contaController.saque(Float.parseFloat(txtDigiteUmValor.getText()));
					saldo = ""+contaController.getSaldo();
					lblNewLabel.setForeground(Color.decode("#008000"));
					lblSaldoAtualR.setText("Saldo Atual R$: "+saldo);
					lblNewLabel.setText("Saque Concluído com Sucesso");

				}
				else{

					lblNewLabel.setForeground(Color.RED);
					lblNewLabel.setText("Valor Inválido");
					txtDigiteUmValor.setText("");
					
				}
			}
		});

		// evento mouse click textfield
		txtDigiteUmValor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel.setText("");
			}
		});
	}

}
