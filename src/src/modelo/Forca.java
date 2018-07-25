package modelo;


public class Forca {
	
	boolean enforcado = false;
	int itens = 0;
	
	
	public boolean isEnforcado() {
		return enforcado;
	}
	public void setEnforcado(boolean enforcado) {
		this.enforcado = enforcado;
	}
	public int getItens() {
		return itens;
	}
	public void setItens(int itens) {
		this.itens = itens;
		if (this.itens == 6) this.enforcado = true;
	}
	
}