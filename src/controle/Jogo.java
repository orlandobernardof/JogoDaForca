package controle;

import javax.swing.JOptionPane;
import java.util.*;
import javax.swing.*;
import modelo.*;


public class Jogo {

	/**
	 * @param args
	 */
	
	String[] palavras = {"CARRO", "CASA", "ONIBUS", "MERCADO", "FLAMENGO",
			             "VASCO", "BOTAFOGO", "FLUMINENSE"};
	
	int erros = 0;
	
	public int getErros() {
		return erros;
	}

	public void setErros(int erros) {
		this.erros = erros;
	}	
	
	public void jogar(JLabel jlabel, JTextArea saida, JPanel boneco) {
/*
		System.out.println("Hello world!");
		
		JOptionPane.showMessageDialog(null, "Hello world!");
		
		String pergunta = "Qual é o seu nome?";		
		String np = JOptionPane.showInputDialog(pergunta);
		JOptionPane.showMessageDialog(null, "Olá " + np);
		pergunta = "Qual a sua idade?";
		String idadestr = JOptionPane.showInputDialog(pergunta);
		int idade = Integer.parseInt(idadestr);
		String comentario;
		if (idade > 50) comentario = "Nossa, como você está velho!";
		else comentario = "É, não está tão mal.";
		JOptionPane.showMessageDialog(null, comentario); */
		
		Jogo princ = new Jogo();		
		int indice = (int) Math.round (Math.random() * 7);
		
		Palavra pal = new Palavra(princ.palavras[indice]);		
		Forca f = new Forca();
		LetrasEscolhidas letesc = new LetrasEscolhidas(); 
		String pergunta;
		String letrastr;
		
		char letra;
		//int tentativas = 6;
		//ArrayList<String> lista = new ArrayList<String>();
		
		/*
		
		*/
		
		
		
		do
		{
			//System.out.println("PALAVRA: "); //lista.add("PALAVRA: ");
			//java.awt.Toolkit.getDefaultToolkit().beep();
			//pal.showTexto_descoberto();
			jlabel.setText(pal.getTexto_descoberto());
			pergunta = "Escolha uma letra:";		
			letrastr = JOptionPane.showInputDialog(pergunta);
			if (letrastr == null) 
				{
					jlabel.setText("nenhuma");
					saida.setText("");
					erros = 0;
					boneco.repaint();
					break;
				}
			letrastr = letrastr.toUpperCase();
			letra = letrastr.charAt(0);						
			if (letesc.jaEscolheu(letra))
			{	
				//System.out.println("Letra repetida");				
				JOptionPane.showMessageDialog(null, "Letra repetida");
				//System.out.print("Letras já escolhidas: ");
				saida.setText("Letras já escolhidas: \n" + letesc.getLetras());
				//letesc.mostrar();
			}
			else {				
				letesc.inserir(letra);
				//System.out.print("Letras já escolhidas: ");
				//letesc.mostrar();				
				saida.setText("Letras já escolhidas: \n" + letesc.getLetras());
				if (pal.checar_letra(letra) == false) 
					{
					  f.setItens(f.getItens()+1);//System.out.println("ERREI");System.out.println("ITENS = "+f.getItens());
					  //tentativas--;
					  erros++;
					  boneco.repaint();
					}
				else 
					{
					  //System.out.println("PALAVRA: ");
					  //pal.showTexto_descoberto(); //lista.add(pal.getTexto_descoberto());
					  jlabel.setText(pal.getTexto_descoberto());
					}
				//System.out.println("Você ainda possui " + tentativas + 
				//		           " tentativas.");				
			}
		} while (!f.isEnforcado() && !pal.isGanhou());
		if (f.isEnforcado()) 
			{
				//System.out.println("Você foi enforcado!!");
				JOptionPane.showMessageDialog(null, "Você foi enforcado!!");
			}
		if (pal.isGanhou()) 
			{
				//System.out.println("Você acertou a palavra!");
				JOptionPane.showMessageDialog(null, "Você acertou a palavra!");
			}
	}

}
