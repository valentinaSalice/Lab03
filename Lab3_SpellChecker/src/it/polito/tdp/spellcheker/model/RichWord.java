package it.polito.tdp.spellcheker.model;

public class RichWord {
	
	private String parola;
	private boolean corretta;
	
	public RichWord(String parola) {
		
		this.parola = parola;
		corretta=false;
		
	}
	
	public void setCorretta() {
		
		corretta=true;
	}
	
	
	public String getParola() {
		
		return parola;
	}
	
	public boolean isCorretta() {
		
		return corretta;
	}
	
	
	
	

}
