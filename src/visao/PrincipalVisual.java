package visao;

import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;

import controle.*;

public class PrincipalVisual {

	private JFrame frame;
	Jogo jogando = new Jogo();
	int x; int y;
	Color cor = Color.BLACK;
	JLabel palavra = null;
	JTextArea textoDeSaida = null;
	


	private JPanel jPanelDoll = new JPanel()			
	{
        // Sobrescrevendo o método 'paintComponent' do 'JPanel'.
        @Override public void paintComponent(Graphics g) {
            super.paintComponent(g);                       
            g.setColor(Color.BLACK);
            g.drawRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);
            g.drawRect(2, 2, this.getWidth() - 5, this.getHeight() - 5);
            g.drawLine(x-60, y-20, x-60, y+120); //forca
            g.drawLine(x-80, y+120, x-40, y+120); //forca
            g.drawLine(x-60, y-20, x+15, y-20); //forca
            g.drawLine(x+15, y-20, x+15, y-5); //forca            
            if (jogando.getErros() == 0) 
            	{
            		g.setColor(this.getBackground());
            		g.drawOval(x, y, 30, 30); //cabeça;
                    g.drawLine(x+16, y+31, x+16, y+81); //corpo
                    g.drawLine(x+15, y+41, x-5, y+61); //braço direito
                    g.drawLine(x+17, y+41, x+37, y+61); //braço esquerdo
                    g.drawLine(x+15, y+82, x-5, y+102); //perna direita
                    g.drawLine(x+17, y+82, x+37, y+102); //perna esquerda 
            	}            
            if (jogando.getErros() >= 1) g.drawOval(x, y, 30, 30); //cabeça;
            if (jogando.getErros() >= 2) g.drawLine(x+16, y+31, x+16, y+81); //corpo
            if (jogando.getErros() >= 3) g.drawLine(x+15, y+41, x-5, y+61); //braço direito
            if (jogando.getErros() >= 4) g.drawLine(x+17, y+41, x+37, y+61); //braço esquerdo
            if (jogando.getErros() >= 5) g.drawLine(x+15, y+82, x-5, y+102); //perna direita
            if (jogando.getErros() == 6) g.drawLine(x+17, y+82, x+37, y+102); //perna esquerda                                   
        }
	};
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalVisual window = new PrincipalVisual();
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
	public PrincipalVisual() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 656, 413);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		x = 130; y = 80;
		//cor = Color.BLACK;
		frame.getContentPane().setLayout(null);
		jPanelDoll.setBounds(306, 54, 278, 271);
		frame.getContentPane().add(jPanelDoll);
		jPanelDoll.setLayout(null);
		//jPanelDoll.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		JButton btnEnforcaParte = new JButton("Novo Jogo");
		btnEnforcaParte.setBounds(15, 108, 146, 29);
		frame.getContentPane().add(btnEnforcaParte);
		
		JLabel lblLabelpalavra = new JLabel("nenhuma");
		lblLabelpalavra.setBounds(15, 171, 160, 29);
		frame.getContentPane().add(lblLabelpalavra);
		palavra = lblLabelpalavra;
		JLabel lblTitulopalavra = new JLabel("Palavra Sorteada:");
		lblTitulopalavra.setBounds(15, 151, 146, 22);
		frame.getContentPane().add(lblTitulopalavra);
		
		JTextArea saidaDetexto = new JTextArea();
		saidaDetexto.setBounds(15, 222, 168, 96);		
		saidaDetexto.setFont(new Font("Dialog", Font.BOLD, 14));
		//saidaDetexto.setForeground(UIManager.getColor("TextArea.foreground"));
		saidaDetexto.setForeground(Color.BLACK);
		saidaDetexto.setRows(3);
		saidaDetexto.setEnabled(false);
		frame.getContentPane().add(saidaDetexto);
		textoDeSaida = saidaDetexto;
		
		JButton btnSalvarJogo = new JButton("Salvar Jogo");
		btnSalvarJogo.setBounds(15, 61, 146, 29);
		frame.getContentPane().add(btnSalvarJogo);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 634, 31);		
		frame.getContentPane().add(menuBar);		
				
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenuItem mntmSalvarJogo = new JMenuItem("Salvar Jogo");
		mnArquivo.add(mntmSalvarJogo);
		
		JMenuItem mntmCarregarJogo = new JMenuItem("Carregar Jogo");
		mnArquivo.add(mntmCarregarJogo);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnArquivo.add(mntmSair);
		
		btnSalvarJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String folder;		
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setDialogTitle("Escolha o arquivo:");
				int ret = chooser.showOpenDialog(null);
				if (ret==JFileChooser.APPROVE_OPTION){
					folder= chooser.getSelectedFile().getAbsolutePath();
					//System.out.println("Arquivo escolhido: " + folder);						
				try 
				{
					OutputStream os = new FileOutputStream(folder);// + "/saida.txt");
					OutputStreamWriter osw = new OutputStreamWriter(os);
					BufferedWriter bw = new BufferedWriter(osw);
					
					bw.write("jogo salvo");				
					bw.close();
				}
				catch (IOException x)
				{
					JOptionPane.showMessageDialog(null, "Erro \n" + x);
				}
								
				}	
				
			}
		});
		btnEnforcaParte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//cor = jPanelDoll.getBackground();
				jogando.setErros(0);
				jPanelDoll.repaint();
				jogando.jogar(palavra,textoDeSaida,jPanelDoll);
				
			}
		});
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}