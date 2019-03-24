package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellcheker.model.Dictionary;
import it.polito.tdp.spellcheker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class SpellCheckerController {
	
	private Dictionary model; 
	private List<String>inputTextList=new LinkedList<String>();
	private String lingua=null;
	private List<RichWord>lette=new LinkedList<RichWord>();
	private List<String>errate=new LinkedList<String>();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> menu;

    @FXML
    private TextArea txtTesto;

    @FXML
    private TextArea txtErrori;

    @FXML
    private Text setText;

    @FXML
    private Text setTextErr;
    
    @FXML
    void doChoice(ActionEvent event) {
    	

    	if(menu.getValue()!=null)
    		txtTesto.setDisable(false);
    	else
    		txtTesto.setDisable(true);
		

    }

    @FXML
    void doClearText(ActionEvent event) {
    	
    	txtTesto.clear();
    	txtErrori.clear();
    	lette.clear();
    	errate.clear();
    	inputTextList.clear();

    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	
    	lette.clear();
    	errate.clear();
    	inputTextList.clear();

    	txtErrori.clear();
    	
		lingua=menu.getValue();
		
		model.loadDictionary(lingua);
		
		
		

    	
    	String frase=txtTesto.getText().toLowerCase();
    	frase=frase.replaceAll("\n"," ");
    	String fraseCorretta=frase.replaceAll("[.,?=\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]]", "");
    	
    	
    	for(String temp:fraseCorretta.split(" ")) {
    		
    		inputTextList.add(temp);
    	}
    	
    	
    	
    	
    	
    	lette=model.spellCheckText(inputTextList);
    	
    	
    	for(RichWord temp: lette) {
    		
    		if(temp.isCorretta()==false)
    			errate.add(temp.getParola());
    	}
    	
    	
    	for(String s:errate)
    		txtErrori.appendText(s+"\n");
    	

    	
    	
    	errate.clear();
    	



    }

    @FXML
    void initialize() {
        assert menu != null : "fx:id=\"menu\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtTesto != null : "fx:id=\"txtTesto\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtErrori != null : "fx:id=\"txtErrori\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert setText != null : "fx:id=\"setText\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert setTextErr != null : "fx:id=\"setTextErr\" was not injected: check your FXML file 'SpellChecker.fxml'.";

    }

	public void setModel(Dictionary model) {
		
		this.model=model;
		
		txtTesto.setDisable(true);
		
		menu.getItems().addAll("English", "Italian");
		

		
	}
}
