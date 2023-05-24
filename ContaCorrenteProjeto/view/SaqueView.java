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

	private JFrame frame;
	private JTextField textField;
	ContaController contaController;
	/**
	 * Create the application.
	 */
	public SaqueView(String numero_da_conta) {
		
		contaController = new ContaController(numero_da_conta);
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
		panel.setBackground(new Color(240, 240, 240));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblSaque = new JLabel("Saque");
		lblSaque.setBounds(165, 39, 109, 31);
		lblSaque.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaque.setIcon(new ImageIcon("C:\\coisasdovini2\\Programacao\\verissimobanco\\ContaCorrenteProjeto\\view\\Imagens\\perdas.png"));
		lblSaque.setForeground(new Color(62, 118, 136));
		lblSaque.setFont(new Font("MS Gothic", Font.BOLD, 30));
		panel.add(lblSaque);
		
		JLabel lblSaldoAtualR = new JLabel("Saldo Atual R$: $$$$$");
		lblSaldoAtualR.setBounds(69, 81, 287, 26);
		lblSaldoAtualR.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaldoAtualR.setForeground(new Color(62, 118, 136));
		lblSaldoAtualR.setFont(new Font("MS Gothic", Font.BOLD, 25));
		panel.add(lblSaldoAtualR);
		
		JLabel lblDigiteOValor_1 = new JLabel("Digite o valor a ser sacado:");
		lblDigiteOValor_1.setBounds(69, 118, 294, 21);
		lblDigiteOValor_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDigiteOValor_1.setForeground(new Color(62, 118, 136));
		lblDigiteOValor_1.setFont(new Font("MS Gothic", Font.BOLD, 20));
		panel.add(lblDigiteOValor_1);
		
		textField = new JTextField();
		textField.setBounds(165, 150, 116, 27);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("MS Gothic", Font.BOLD, 20));
		textField.setColumns(10);
		panel.add(textField);
		
		JButton btnSacar = new JButton("Sacar");
		
		btnSacar.setBounds(165, 188, 116, 29);
		btnSacar.setBackground(Color.WHITE);
		btnSacar.setForeground(new Color(62, 118, 136));
		btnSacar.setFont(new Font("MS Gothic", Font.BOLD, 20));
		panel.add(btnSacar);
		
		btnSacar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contaController.saque(Float.parseFloat(textField.getText()));
			}
		});
	}

}
