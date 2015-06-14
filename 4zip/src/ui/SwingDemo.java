package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class SwingDemo {
	public static void main(String[] args) {
		final JFrame jf = new JFrame("4ZIP");
		jf.setSize(600, 600);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fecha aplicativo
		jf.setLocationRelativeTo(null); // centraliza
		jf.setResizable(false); // nao altera o tamanho da janela

		
		
		

		// LookAndFeel Ninbus

		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (UnsupportedLookAndFeelException e) {

			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();

		} catch (ClassNotFoundException e) {

			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();

		} catch (InstantiationException e) {

			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();

		} catch (IllegalAccessException e) {

			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}

		
		
		// Label
		final JLabel LStatus = new JLabel("");
		final JLabel LCaminho = new JLabel("");

		
		
		// tabela
		final JTable tabela = new JTable();
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(tabela);

		
		
		// criar panels
		JPanel panelPrincipal = new JPanel();

		
		
		// criar botoes
		JButton btnProcurarArquivo = new JButton(new ImageIcon("Image/pasta.png"));
		JButton btnCompactar = new JButton(new ImageIcon("Image/compactar.png"));
		JButton btnCompactarsenha = new JButton(new ImageIcon("Image/chave.png"));
		
		
		// Busca
		final JFileChooser jfChooser = new JFileChooser();
		btnProcurarArquivo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int returnValue = jfChooser.showOpenDialog(jf); // return int 0
																// / 1
//				System.out.println("Valor retornado " + returnValue);
				
				// pega o caminho do arquivo
				String caminho = null;
				int id = 0;
				SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");

				String data = "";
				String hora = "";
				if (jfChooser.getSelectedFile() != null) {
					LCaminho.setText("Caminho " + jfChooser.getSelectedFile());
					caminho = ("" + jfChooser.getSelectedFile());
					data = sdfData.format(new Date());
					hora = sdfHora.format(new Date());
					id = 1;
				} else {
					JOptionPane.showMessageDialog(null,
							"Nenhum arquivo selecionado", "Retorno",
							JOptionPane.INFORMATION_MESSAGE);
				}

				if (jfChooser.APPROVE_OPTION == returnValue) {
					LStatus.setText("Compactando arquivo...");
				} else {
					JOptionPane.showMessageDialog(null,
							"Nao foi possivel compactar arquivo");
				}

				
//				Dados Tabela
				tabela.setModel(new javax.swing.table.DefaultTableModel(

				new Object[][] { { id, caminho, data + "  " + hora } },

				new String[] { "ID", "Caminho", "Data" }) {
					Class[] types = new Class[] { java.lang.Integer.class,
							java.lang.String.class, java.lang.String.class };
					boolean[] canEdit = new boolean[] { false, false, false };

					public Class getColumnClass(int columnIndex) {
						return types[columnIndex];
					}

					public boolean isCellEditable(int rowIndex, int columnIndex) {
						return canEdit[columnIndex];
					}
				});
			}
		});
		tabela.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {
//				{ "01", "c:/arquivo.txt", "03/06/2015 - 19:21" },
//				{ "02", "c:/arquivo.txt", "03/06/2015 - 19:21" },
//				{ "03", "c:/arquivo.txt", "03/06/2015 - 19:21" },
//				{ "04", "c:/arquivo.txt", "03/06/2015 - 19:21" }, 
//				{ "05", "c:/arquivo.txt", "03/06/2015 - 19:21" },
				{ "", "", "" } },

		new String[] { "ID", "Caminho", "Data" }));

		// adicionar compoenentes
		panelPrincipal.add(btnCompactar);
		panelPrincipal.add(btnCompactarsenha);
		panelPrincipal.add(btnProcurarArquivo);
		// panelPrincipal.add(LCaminho);
		panelPrincipal.add(scroll);
		jf.add(panelPrincipal, BorderLayout.CENTER);

		jf.setVisible(true);

	}
}
