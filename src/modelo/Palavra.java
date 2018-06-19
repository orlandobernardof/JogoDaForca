package modelo;


public class Palavra {
	
	String texto;
	String texto_descoberto;
	boolean ganhou = false;

	public Palavra (String txt)
	{
		texto = txt;
		texto_descoberto = "";
		for (int i = 0; i < texto.length(); i++)
		{
			texto_descoberto = texto_descoberto + "_ ";			
		}
	}
		
	public String getTexto() {
		return texto;
	}
	
	public void showTexto() {
		System.out.println (texto);
	}

	public void showTexto_descoberto() {
		System.out.println (texto_descoberto);
	}	
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
		
	public String getTexto_descoberto() {
		return texto_descoberto;
	}
	
	public boolean isGanhou() {
		return ganhou;
	}

	public boolean checar_letra (char letra)
	{
		boolean acertou = false;
		for (int i = 0; i < texto.length(); i++)
		{
			if (texto.charAt(i) == letra)
			{
				texto_descoberto = texto_descoberto.substring(0,2*i) + letra 
			                      + texto_descoberto.substring(2*i+1);
			    acertou = true;
			}   
		}
		
		if (texto_descoberto.indexOf("_") < 0) ganhou = true;
		
		return acertou;
	}

}
