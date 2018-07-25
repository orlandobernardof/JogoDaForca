package modelo;


public class LetrasEscolhidas {

	String letras = "";
	
	
	
	public String getLetras() {
		return letras;
	}

	public void setLetras(String letras) {
		this.letras = letras;
	}

	public boolean jaEscolheu (char let)
	{
		if (letras.indexOf(let) < 0) return false;
		return true;
	}
	
	public void inserir (char let)
	{
		letras = letras + " " + let;
	}
	
	public void mostrar()
	{
		System.out.println(letras);
	}
}