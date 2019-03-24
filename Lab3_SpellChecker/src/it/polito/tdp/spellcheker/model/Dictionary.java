package it.polito.tdp.spellcheker.model;

import java.util.*;
import java.io.*;

public class Dictionary {
	
	private List<String> inglese;
	private List<String>italiano;
	private List<RichWord> paroleLette=new LinkedList<RichWord>();
	
	
	
	
	public Dictionary() {
		
		inglese=new LinkedList<String>();
		italiano=new LinkedList<String>();
	}




	public void loadDictionary(String language) {
		
		if(language.compareTo("English")==0) {
			
			try{
				FileReader fr=new FileReader("rsc/English.txt");
				BufferedReader br=new BufferedReader(fr);
				String word;
				
				while((word=br.readLine())!=null) {
					
					inglese.add(word.toLowerCase());
					
					
				}
				
				br.close();
			}catch(IOException e) {
				
				System.out.println("Errore nella lettura del file");
			}
				

		}
		
		else if(language.compareTo("Italian")==0) {
			
			try{
				FileReader fr=new FileReader("rsc/Italian.txt");
				BufferedReader br=new BufferedReader(fr);
				String word;
				
				while((word=br.readLine())!=null) {
					
					italiano.add(word.toLowerCase());
					
				}
				
				br.close();
			}catch(IOException e) {
				
				System.out.println("Errore nella lettura del file");
			}
			
			
			
		}
		
		
	}
	
	public List<RichWord> spellCheckText(List<String>inputTextList){
		
		paroleLette.clear();
		
		for(String parola: inputTextList) {
			
			if(inglese.contains(parola)) {
				
				RichWord temp=new RichWord(parola);
				temp.setCorretta();
				paroleLette.add(temp);
			}
			
			else if(italiano.contains(parola)) {
				
				RichWord temp=new RichWord(parola);
				temp.setCorretta();
				paroleLette.add(temp);
				
			}
			
			else {
				
				RichWord temp=new RichWord(parola);
				paroleLette.add(temp);
			}
				
		}
		
		return paroleLette;
	}

}
