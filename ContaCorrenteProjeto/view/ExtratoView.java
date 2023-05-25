package ContaCorrenteProjeto.view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Collection;
import java.util.Vector;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ContaCorrenteProjeto.controller.TransferenciaController;

import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ExtratoView {

	private JFrame frame, parentFrame;
	private JTable table;
	private ResultSet result;
	private TransferenciaController transferenciaController;
	/**
	 * Create the application.
	 */
	public ExtratoView(String numero_da_conta, String numero_da_agencia, JFrame frame) {
		transferenciaController = new TransferenciaController(numero_da_conta, numero_da_agencia);
		this.result = transferenciaController.mostrarTransferencias();
		this.parentFrame = frame;
		try {
			initialize();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws Exception{
		frame = new JFrame();
		frame.setTitle("Extrato");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\coisasdovini2\\Programacao\\verissimobanco\\ContaCorrenteProjeto\\view\\Imagens\\vasco escudo.png"));
		frame.setBounds(735, 390, 650, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblExtrato = new JLabel("Extrato");
		lblExtrato.setIcon(new ImageIcon("C:\\coisasdovini2\\Programacao\\verissimobanco\\ContaCorrenteProjeto\\view\\Imagens\\extrato.png"));
		lblExtrato.setBounds(245, 11, 141, 31);
		lblExtrato.setHorizontalAlignment(SwingConstants.CENTER);
		lblExtrato.setForeground(new Color(62, 118, 136));
		lblExtrato.setFont(new Font("MS Gothic", Font.BOLD, 30));
		panel.add(lblExtrato);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 53, 614, 259);
		
		panel.add(scrollPane);
		
		table = new JTable(buildTableModel(result));
		table.setAutoResizeMode(4);
		
		table.setColumnSelectionAllowed(true);
		table.setEnabled(false);
		table.setFont(new Font("MS Gothic", Font.BOLD, 15));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		table.getColumnModel().getColumn(0).setResizable(false);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Sair");
		btnNewButton.setIcon(new ImageIcon("C:\\coisasdovini2\\Programacao\\verissimobanco\\ContaCorrenteProjeto\\view\\Imagens\\sair.png"));
		btnNewButton.setForeground(new Color(62, 118, 136));
		btnNewButton.setFont(new Font("MS Gothic", Font.BOLD, 15));
		btnNewButton.setBounds(245, 317, 141, 33);
		panel.add(btnNewButton);

		// evento mouse click botao sair
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				parentFrame.setVisible(true);
				frame.dispose();
			}
		});
	}

	public DefaultTableModel buildTableModel(ResultSet rs) throws Exception {

    ResultSetMetaData metaData = rs.getMetaData();

    // names of columns
    Vector<String> columnNames = new Vector<String>();
	columnNames.add("NumTransferencia");
	columnNames.add("Valor");
	columnNames.add("Credor");
	columnNames.add("Destinatário");
	columnNames.add("Data da Transferencia");
	
    int columnCount = metaData.getColumnCount();
    

    // data of the table
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    while (rs.next()) {
        Vector<Object> vector = new Vector<Object>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector.add(rs.getObject(columnIndex));
        }
        data.add(vector);
    }

    return new DefaultTableModel(data, columnNames);

}

}


