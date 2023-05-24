package ContaCorrenteProjeto.view;

import ContaCorrenteProjeto.controller.TransferenciaController;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TransferenciaView {

	private JFrame frame;
	TransferenciaController transferenciaController;
	private String conta_destino;
	/**
	 * Create the application.
	 */
	public TransferenciaView(String numero_da_conta, String conta_destino) {
		transferenciaController = new TransferenciaController(numero_da_conta);
		this.conta_destino = conta_destino;
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
		panel.setBackground(SystemColor.menu);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblTransferncia = new JLabel("Transferência");
		lblTransferncia.setIcon(new ImageIcon("C:\\coisasdovini2\\Programacao\\verissimobanco\\ContaCorrenteProjeto\\view\\Imagens\\transferir.png"));
		lblTransferncia.setBounds(88, 11, 236, 31);
		lblTransferncia.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransferncia.setForeground(new Color(62, 118, 136));
		lblTransferncia.setFont(new Font("MS Gothic", Font.BOLD, 30));
		panel.add(lblTransferncia);
		
		JLabel lblSaldoAtualR = new JLabel("Saldo Atual R$: $$$$$");
		lblSaldoAtualR.setBounds(10, 50, 221, 21);
		lblSaldoAtualR.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaldoAtualR.setForeground(new Color(62, 118, 136));
		lblSaldoAtualR.setFont(new Font("MS Gothic", Font.BOLD, 20));
		panel.add(lblSaldoAtualR);
		
		JLabel lblDigiteOValor_1 = new JLabel("Digite o valor da transferencia:");
		lblDigiteOValor_1.setBounds(10, 82, 269, 16);
		lblDigiteOValor_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDigiteOValor_1.setForeground(new Color(62, 118, 136));
		lblDigiteOValor_1.setFont(new Font("MS Gothic", Font.BOLD, 15));
		panel.add(lblDigiteOValor_1);
		
		JTextField textField = new JTextField();
		textField.setBounds(297, 74, 116, 27);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("MS Gothic", Font.BOLD, 20));
		textField.setColumns(10);
		panel.add(textField);
		
		JLabel lblDigiteOValor_1_1 = new JLabel("Digite o numero da conta destino:");
		lblDigiteOValor_1_1.setBounds(10, 120, 277, 16);
		lblDigiteOValor_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDigiteOValor_1_1.setForeground(new Color(62, 118, 136));
		lblDigiteOValor_1_1.setFont(new Font("MS Gothic", Font.BOLD, 15));
		panel.add(lblDigiteOValor_1_1);
		
		JTextField textField_1 = new JTextField();
		textField_1.setBounds(297, 112, 116, 27);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("MS Gothic", Font.BOLD, 20));
		textField_1.setColumns(10);
		panel.add(textField_1);
		
		JButton btnSacar = new JButton("Transferir");
		btnSacar.setBounds(0, 223, 434, 37);
		btnSacar.setForeground(new Color(62, 118, 136));
		btnSacar.setFont(new Font("MS Gothic", Font.BOLD, 20));
		btnSacar.setBackground(Color.WHITE);
		panel.add(btnSacar);
		
		JLabel lblDigiteOValor_1_1_1 = new JLabel("Escolha a agênciada conta destino:");
		lblDigiteOValor_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDigiteOValor_1_1_1.setForeground(new Color(62, 118, 136));
		lblDigiteOValor_1_1_1.setFont(new Font("MS Gothic", Font.BOLD, 15));
		lblDigiteOValor_1_1_1.setBounds(10, 162, 286, 16);
		panel.add(lblDigiteOValor_1_1_1);
		
		JRadioButton rdbtnNewRadioButton_0 = new JRadioButton("1");
		rdbtnNewRadioButton_0.setVerticalAlignment(SwingConstants.BOTTOM);
		rdbtnNewRadioButton_0.setSelected(true);
		rdbtnNewRadioButton_0.setFont(new Font("MS Gothic", Font.BOLD, 15));
		rdbtnNewRadioButton_0.setBounds(144, 187, 33, 25);
		panel.add(rdbtnNewRadioButton_0);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("2");
		rdbtnNewRadioButton_1.setVerticalAlignment(SwingConstants.BOTTOM);
		rdbtnNewRadioButton_1.setFont(new Font("MS Gothic", Font.BOLD, 15));
		rdbtnNewRadioButton_1.setBounds(179, 187, 33, 25);
		panel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("3");
		rdbtnNewRadioButton_2.setVerticalAlignment(SwingConstants.BOTTOM);
		rdbtnNewRadioButton_2.setFont(new Font("MS Gothic", Font.BOLD, 15));
		rdbtnNewRadioButton_2.setBounds(214, 187, 33, 25);
		panel.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("4");
		rdbtnNewRadioButton_3.setVerticalAlignment(SwingConstants.BOTTOM);
		rdbtnNewRadioButton_3.setFont(new Font("MS Gothic", Font.BOLD, 15));
		rdbtnNewRadioButton_3.setBounds(249, 187, 33, 25);
		panel.add(rdbtnNewRadioButton_3);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnNewRadioButton_0);
		buttonGroup.add(rdbtnNewRadioButton_1);
		buttonGroup.add(rdbtnNewRadioButton_2);
		buttonGroup.add(rdbtnNewRadioButton_3);

		btnSacar.addMouseListener(new MouseAdapter() {
			//String agenciaEscolhida;
			public void mouseClicked(MouseEvent e) {
				/*
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
				*/
				transferenciaController.transferir(conta_destino, textField_1.getText());
			}
		});

		
	}

}
