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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TransferenciaView {

	private JFrame frame, parentFrame;
	private TransferenciaController transferenciaController;

	/**
	 * Create the application.
	 */
	public TransferenciaView(String numero_da_conta, String numero_da_agencia, JFrame frame) {
		
		transferenciaController = new TransferenciaController(numero_da_conta, numero_da_agencia);
		
		this.parentFrame = frame;
		initialize();
		this.frame.setVisible(true);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\coisasdovini2\\Programacao\\verissimobanco\\ContaCorrenteProjeto\\view\\Imagens\\vasco escudo.png"));
		frame.setBounds(735, 390, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblMensagemSucesso = new JLabel("");
		lblMensagemSucesso.setBackground(new Color(0, 0, 0));
		lblMensagemSucesso.setFont(new Font("MS Gothic", Font.BOLD, 20));
		lblMensagemSucesso.setForeground(new Color(0, 128, 64));
		lblMensagemSucesso.setBounds(10, 191, 403, 21);
		panel.add(lblMensagemSucesso);
		
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
		btnSacar.setIcon(new ImageIcon("C:\\coisasdovini2\\Programacao\\verissimobanco\\ContaCorrenteProjeto\\view\\Imagens\\transferir.png"));
		btnSacar.setBounds(0, 223, 277, 37);
		btnSacar.setForeground(new Color(62, 118, 136));
		btnSacar.setFont(new Font("MS Gothic", Font.BOLD, 20));
		btnSacar.setBackground(new Color(240, 240, 240));
		panel.add(btnSacar);
		
		JLabel lblDigiteOValor_1_1_1 = new JLabel("Escolha a agência da conta destino:");
		lblDigiteOValor_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblDigiteOValor_1_1_1.setForeground(new Color(62, 118, 136));
		lblDigiteOValor_1_1_1.setFont(new Font("MS Gothic", Font.BOLD, 15));
		lblDigiteOValor_1_1_1.setBounds(10, 147, 357, 16);
		panel.add(lblDigiteOValor_1_1_1);
		
		JRadioButton rdbtnNewRadioButton_0 = new JRadioButton("1");
		rdbtnNewRadioButton_0.setVerticalAlignment(SwingConstants.BOTTOM);
		rdbtnNewRadioButton_0.setSelected(true);
		rdbtnNewRadioButton_0.setFont(new Font("MS Gothic", Font.BOLD, 15));
		rdbtnNewRadioButton_0.setBounds(131, 170, 33, 25);
		panel.add(rdbtnNewRadioButton_0);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("2");
		rdbtnNewRadioButton_1.setVerticalAlignment(SwingConstants.BOTTOM);
		rdbtnNewRadioButton_1.setFont(new Font("MS Gothic", Font.BOLD, 15));
		rdbtnNewRadioButton_1.setBounds(166, 170, 33, 25);
		panel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("3");
		rdbtnNewRadioButton_2.setVerticalAlignment(SwingConstants.BOTTOM);
		rdbtnNewRadioButton_2.setFont(new Font("MS Gothic", Font.BOLD, 15));
		rdbtnNewRadioButton_2.setBounds(201, 170, 33, 25);
		panel.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("4");
		rdbtnNewRadioButton_3.setVerticalAlignment(SwingConstants.BOTTOM);
		rdbtnNewRadioButton_3.setFont(new Font("MS Gothic", Font.BOLD, 15));
		rdbtnNewRadioButton_3.setBounds(236, 170, 33, 25);
		panel.add(rdbtnNewRadioButton_3);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnNewRadioButton_0);
		buttonGroup.add(rdbtnNewRadioButton_1);
		buttonGroup.add(rdbtnNewRadioButton_2);
		buttonGroup.add(rdbtnNewRadioButton_3);
		
		JButton btnNewButton = new JButton("Sair");
		btnNewButton.setIcon(new ImageIcon("C:\\coisasdovini2\\Programacao\\verissimobanco\\ContaCorrenteProjeto\\view\\Imagens\\sair.png"));
		btnNewButton.setForeground(new Color(62, 118, 136));
		btnNewButton.setFont(new Font("MS Gothic", Font.BOLD, 20));
		btnNewButton.setBounds(277, 223, 157, 37);
		panel.add(btnNewButton);
		
		// evento mouse click transferir dinheiro
		btnSacar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				if (rdbtnNewRadioButton_0.isSelected()) {
					try {
						transferenciaController.transferir(textField_1.getText(), "1", textField.getText());
						lblMensagemSucesso.setForeground(Color.GREEN);
						lblMensagemSucesso.setText("Transferencia Concluida com Sucesso!");
					} catch (Exception excp1) {
						lblMensagemSucesso.setForeground(Color.RED);
						lblMensagemSucesso.setText("Transferencia Não Pode Ser Concluida");
					}
                    
                }
                else if (rdbtnNewRadioButton_1.isSelected()) {
                    try {
						transferenciaController.transferir(textField_1.getText(), "2", textField.getText());
						lblMensagemSucesso.setForeground(Color.GREEN);
						lblMensagemSucesso.setText("Transferencia Concluida com Sucesso!");
					} catch (Exception excp1) {
						lblMensagemSucesso.setForeground(Color.RED);
						lblMensagemSucesso.setText("Transferencia Não Pode Ser Concluida");
					}
                }
                else if (rdbtnNewRadioButton_2.isSelected()) {
                    try {
						transferenciaController.transferir(textField_1.getText(), "3", textField.getText());
						lblMensagemSucesso.setForeground(Color.GREEN);
						lblMensagemSucesso.setText("Transferencia Concluida com Sucesso!");
					} catch (Exception excp1) {
						lblMensagemSucesso.setForeground(Color.RED);
						lblMensagemSucesso.setText("Transferencia Não Pode Ser Concluida");
					}
                }
                else if(rdbtnNewRadioButton_3.isSelected()){
                    try {
						transferenciaController.transferir(textField_1.getText(), "4", textField.getText());
						lblMensagemSucesso.setText("Transferencia Concluida com Sucesso!");
						lblMensagemSucesso.setForeground(Color.GREEN);
					} catch (Exception excp1) {
						lblMensagemSucesso.setForeground(Color.RED);
						lblMensagemSucesso.setText("Transferencia Não Pode Ser Concluida");
					}
                }
				else{
					lblMensagemSucesso.setForeground(Color.RED);
					lblMensagemSucesso.setText("Nenhuma Agência Escolhida");
				}

				textField.setText(""); textField_1.setText(""); buttonGroup.clearSelection();
			}
		});
		// evento mouse click botao "sair"
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parentFrame.setVisible(true);
				frame.dispose();
			}
		});
		// evento mouse click textfield 1 (valor)		
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblMensagemSucesso.setText("");
			}
		});
	}
}
