package ContaCorrenteProjeto.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContaAcessadaView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContaAcessadaView window = new ContaAcessadaView();
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
	public ContaAcessadaView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Conta de ########");
		lblNewLabel.setFont(new Font("MS Gothic", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(62, 118, 136));
		lblNewLabel.setBounds(125, 11, 179, 21);
		panel.add(lblNewLabel);
		
		JLabel lblSaldoR = new JLabel("Saldo R$: $$$$$");
		lblSaldoR.setForeground(new Color(62, 118, 136));
		lblSaldoR.setFont(new Font("MS Gothic", Font.BOLD, 12));
		lblSaldoR.setBounds(10, 43, 95, 21);
		panel.add(lblSaldoR);
		
		JButton btnDepstio = new JButton("Depósito");
		btnDepstio.setIcon(new ImageIcon("C:\\Users\\marcos.vcrosa\\Documents\\GitHub\\verissimobanco\\ContaCorrenteProjeto\\view\\Imagens\\ganho.png"));
		btnDepstio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDepstio.setBounds(10, 75, 103, 33);
		panel.add(btnDepstio);
		
		JButton btnSaque = new JButton("Saque");
		btnSaque.setIcon(new ImageIcon("C:\\Users\\marcos.vcrosa\\Documents\\GitHub\\verissimobanco\\ContaCorrenteProjeto\\view\\Imagens\\perdas.png"));
		btnSaque.setBounds(123, 75, 91, 33);
		panel.add(btnSaque);
		
		JButton btnTransferir = new JButton("Transferir");
		btnTransferir.setIcon(new ImageIcon("C:\\Users\\marcos.vcrosa\\Documents\\GitHub\\verissimobanco\\ContaCorrenteProjeto\\view\\Imagens\\transferir.png"));
		btnTransferir.setBounds(240, 75, 109, 33);
		panel.add(btnTransferir);
		
		JButton btnExtrato = new JButton("Extrato");
		btnExtrato.setIcon(new ImageIcon("C:\\Users\\marcos.vcrosa\\Documents\\GitHub\\verissimobanco\\ContaCorrenteProjeto\\view\\Imagens\\extrato.png"));
		btnExtrato.setBounds(10, 119, 97, 33);
		panel.add(btnExtrato);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon("C:\\Users\\marcos.vcrosa\\Documents\\GitHub\\verissimobanco\\ContaCorrenteProjeto\\view\\Imagens\\sair.png"));
		btnSair.setBounds(125, 119, 79, 33);
		panel.add(btnSair);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\marcos.vcrosa\\Documents\\GitHub\\verissimobanco\\ContaCorrenteProjeto\\view\\Imagens\\olhoaberto.png"));
		btnNewButton.setBounds(115, 43, 35, 23);
		panel.add(btnNewButton);
	}
}
