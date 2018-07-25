package DAO;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class JogoDAO {
	
	public void salvarJogo(String[] dadosJogo)
	{
		String folder;		
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		chooser.setDialogTitle("Escolha o arquivo:");
		int ret = chooser.showOpenDialog(null);
		if (ret==JFileChooser.APPROVE_OPTION) {
			folder= chooser.getSelectedFile().getAbsolutePath();
			//System.out.println("Arquivo escolhido: " + folder);						
		try 
		{
			OutputStream os = new FileOutputStream(folder,false);// + "/saida.txt");
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			for (int i = 0; i < dadosJogo.length; i++)
			{
				bw.write(dadosJogo[i]);
				bw.newLine();
			}			
			bw.close();
		}
		catch (IOException x)
		{
			JOptionPane.showMessageDialog(null, "Erro \n" + x);
		}
		}
	}		

}
