package ContaCorrenteProjeto.view;

import java.awt.EventQueue;

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

public class DepositoView {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepositoView window = new DepositoView();
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
	public DepositoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\coisasdovini2\\Programacao\\verissimobanco\\ContaCorrenteProjeto\\view\\Imagens\\vasco escudo.png"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblDepsito = new JLabel("Depósito");
		lblDepsito.setBounds(127, 34, 157, 31);
		lblDepsito.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepsito.setIcon(new ImageIcon("C:\\coisasdovini2\\Programacao\\verissimobanco\\ContaCorrenteProjeto\\view\\Imagens\\ganho.png"));
		lblDepsito.setForeground(new Color(62, 118, 136));
		lblDepsito.setFont(new Font("MS Gothic", Font.BOLD, 30));
		panel.add(lblDepsito);
		
		JLabel lblSaldoAtualR = new JLabel("Saldo Atual R$: $$$$$");
		lblSaldoAtualR.setBounds(74, 77, 287, 26);
		lblSaldoAtualR.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaldoAtualR.setForeground(new Color(62, 118, 136));
		lblSaldoAtualR.setFont(new Font("MS Gothic", Font.BOLD, 25));
		panel.add(lblSaldoAtualR);
		
		JLabel lblDigiteOValor = new JLabel("Digite o valor a ser depositado:");
		lblDigiteOValor.setBounds(45, 114, 337, 21);
		lblDigiteOValor.setHorizontalAlignment(SwingConstants.CENTER);
		lblDigiteOValor.setForeground(new Color(62, 118, 136));
		lblDigiteOValor.setFont(new Font("MS Gothic", Font.BOLD, 20));
		panel.add(lblDigiteOValor);
		
		textField = new JTextField();
		textField.setBounds(155, 146, 129, 27);
		textField.setFont(new Font("MS Gothic", Font.BOLD, 20));
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Depositar");
		btnNewButton.setBounds(155, 194, 129, 29);
		btnNewButton.setFont(new Font("MS Gothic", Font.BOLD, 20));
		btnNewButton.setForeground(new Color(62, 118, 136));
		panel.add(btnNewButton);
	}
}
