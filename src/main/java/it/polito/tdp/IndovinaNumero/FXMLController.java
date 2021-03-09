package it.polito.tdp.IndovinaNumero;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.TreeMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class FXMLController {
	
	TreeMap<Integer,Integer> MapNumero = new TreeMap<Integer,Integer>();
	int Attempts;
    int TotAtt;
	double Nmax = 100;
	int SecretNumber = GetSecretNumber();
	int Intervall;
	int a;
	int b;
	boolean ShowInterval = true;
	
	
	private int GetSecretNumber(){
		
		double Random = Math.random()*Nmax;
		int SecretNumber = (int)Random;
		
		if(SecretNumber==0) {
			SecretNumber = GetSecretNumber();
		}
		
		return SecretNumber;
	}
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField TxtNumber;
    
    @FXML
    private Label Attemptsleft;
   
    @FXML
    private Label Result;
    
    @FXML
    private ProgressBar PBar;
    
    @FXML
    private Button EasyB;

    @FXML
    private Button MediumB;

    @FXML
    private Button HardB;
    
    @FXML
    private Label Interval;

    @FXML
    void Easy(ActionEvent event) {

    	Nmax = 100;
    	Attempts = 16;
    	TotAtt = Attempts;
    	MediumB.setDisable(true);
    	HardB.setDisable(true);
    	Attemptsleft.setText("Attempts Left: "+Attempts);
    	Interval.setDisable(false);
    	Intervall = 25;
        a = SecretNumber-Intervall;
        b = SecretNumber+Intervall;
    	
    	if((SecretNumber-Intervall)<1 ) {
    		a = 1;
    	}
    	if((SecretNumber+Intervall)>100) {
    		b = 100;
    	}
    	
    	Interval.setText("Interval of secret number: " +a+ "-" +b);
    	
    }

    @FXML
    void Hard(ActionEvent event) {
    	
    	Nmax = 100;
    	Attempts = 2;
    	TotAtt = Attempts;
    	EasyB.setDisable(true);
    	MediumB.setDisable(true);
    	Attemptsleft.setText("Attempts Left: "+Attempts);
    	Interval.setDisable(true);
    	ShowInterval = false;

    }

    @FXML
    void Medium(ActionEvent event) {
  
    	Nmax = 100;
    	Attempts = 7;
    	TotAtt = Attempts;
    	EasyB.setDisable(true);
    	HardB.setDisable(true);
    	Attemptsleft.setText("Attempts Left: "+Attempts);
    	Intervall = 15;
    	Interval.setDisable(false);
    	
    	a = SecretNumber-Intervall;
        b = SecretNumber+Intervall;
    	
    	if((SecretNumber-Intervall)<1 ) {
    		a = 1;
    	}
    	if((SecretNumber+Intervall)>100) {
    		b = 100;
    	}
    	
    	Interval.setText("Interval of secret number: " +a+ "-" +b);
    	 	
    }
    
    
    @FXML
    void New(ActionEvent event) {

    	//Attempts = 7;
    	SecretNumber = GetSecretNumber();
        TxtNumber.setText("");
        TxtNumber.setDisable(false);
        Result.setText("");
        Attemptsleft.setText("Attempts Left: "+Attempts);
        PBar.setProgress(0);
        EasyB.setDisable(false);
        MediumB.setDisable(false);
    	HardB.setDisable(false);
        MapNumero.clear();
        Interval.setDisable(false);
        Interval.setText("");
        Result.setText("");
        ShowInterval = true;
        
    }
    
    @FXML
    void Try(ActionEvent event) {

    	String u = TxtNumber.getText();
    	int p = 0;
    	
    	if(u.equals("")) {
    		Result.setText("Enter a whole Number between 1-100 please");
    		return;
    	}
    	
    	try{
    	p = Integer.parseInt(u);
    	
    	}
    	catch(NumberFormatException e) {
    		Result.setText("Enter a whole Number please");
    		return;
    	}
    	
    	if(p <= 0 || p >= 101 ) {
    		Result.setText("Choose a whole number between 1-100");
    		return;
    	}
    	
    	if(MapNumero.get(p)!=null) {
    		Result.setText("Number already entered, enter a different one");
    		return;
    	}
    	
    	MapNumero.put(p, p);
    	
    	if(p == SecretNumber) {
    		Result.setText("U win!");
    		TxtNumber.setDisable(true);
    	}
    	else if(p < SecretNumber) {
    		Result.setText("Too Low");
    		Attempts--;
    		a = a+3;
    		
    		if(a>b) {
    			a = SecretNumber-1;
    		}
    		
    		b = b-3;
    		
    		if(b<a) {
    			b = a+2;
    		}
    		
    		if(ShowInterval == true) {
    			
    			System.out.println("hola1");
    			Interval.setText("Interval of secret number: " +a+ "-" +b);
    			
    		}
    		
    		//Interval.setText("Interval of secret number: " +a+ "-" +b);
    		Attemptsleft.setText("Attempts Left: "+Attempts);
    		double i = 1 - (double)(Attempts)/TotAtt;
    		PBar.setProgress(i);
    		//return;
    	}
    	else if(p > SecretNumber ) {
    		Result.setText("Too High");
    		Attempts--;
    		a = a+3;
    		
    		if(a>b) {
    			a = SecretNumber-1;
    		}
    		
    		b = b-3;
    		
    		if(b<a) {
    			b = a+2;
    		}
    		
    		if(ShowInterval == true) {
    			
    			System.out.println("hola2");
    			Interval.setText("Interval of secret number: " +a+ "-" +b);
    			
    		}
    		
    		//Interval.setText("Interval of secret number: " +a+ "-" +b);
    		Attemptsleft.setText("Attempts Left: "+Attempts);
    		double i = 1 - (double)(Attempts)/TotAtt;
    		PBar.setProgress(i);
    		//return;
    	}
    	
    	if(Attempts <= 0) {
    		Result.setText("U Lose! and the secret number was: " +SecretNumber);
    		return;
    	}
	
    }

    @FXML
    void initialize() {
        assert TxtNumber != null : "fx:id=\"TxtNumber\" was not injected: check your FXML file 'Scene.fxml'.";
        assert Attemptsleft != null : "fx:id=\"Attemptsleft\" was not injected: check your FXML file 'Scene.fxml'.";
        assert Result != null : "fx:id=\"Result\" was not injected: check your FXML file 'Scene.fxml'.";
        assert PBar != null : "fx:id=\"PBar\" was not injected: check your FXML file 'Scene.fxml'.";
        assert EasyB != null : "fx:id=\"EasyB\" was not injected: check your FXML file 'Scene.fxml'.";
        assert MediumB != null : "fx:id=\"MediumB\" was not injected: check your FXML file 'Scene.fxml'.";
        assert HardB != null : "fx:id=\"HardB\" was not injected: check your FXML file 'Scene.fxml'.";
        assert Interval != null : "fx:id=\"Interval\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
