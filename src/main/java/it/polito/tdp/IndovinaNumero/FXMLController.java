package it.polito.tdp.IndovinaNumero;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.TreeMap;

import it.polito.tdp.IndovinaNumero.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class FXMLController {
	
	private Model model;
	
	public void SetController(Model model) {
		this.model = model;
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
    private Button TryButton;

    @FXML
    void Easy(ActionEvent event) {

    	model.EasyGame();
    	MediumB.setDisable(true);
    	EasyB.setDisable(true);
    	HardB.setDisable(true);
    	Attemptsleft.setText("Attempts Left: "+model.getAttempts());
    	Interval.setDisable(false);
    	Interval.setText("Interval of secret number: " +model.getA()+ "-" +model.getB());
    	TryButton.setDisable(false);
    	TxtNumber.setDisable(false);
    	
    }

    @FXML
    void Hard(ActionEvent event) {
    	
    	model.HardGame();
    	EasyB.setDisable(true);
    	MediumB.setDisable(true);
    	HardB.setDisable(true);
    	Attemptsleft.setText("Attempts Left: "+model.getAttempts());
    	Interval.setDisable(true);
    	TryButton.setDisable(false);
    	TxtNumber.setDisable(false);

    }

    @FXML
    void Medium(ActionEvent event) {
  
    	model.MediumGame();
    	EasyB.setDisable(true);
    	HardB.setDisable(true);
    	MediumB.setDisable(true);
    	Attemptsleft.setText("Attempts Left: "+model.getAttempts());
    	Interval.setDisable(false);
    	Interval.setText("Interval of secret number: " +model.getA()+ "-" +model.getB());
    	TryButton.setDisable(false);
    	TxtNumber.setDisable(false);
    	 	
    }
    
    
    @FXML
    void New(ActionEvent event) {

    	model.NewGame();
        TxtNumber.setText("");
        Result.setText("");
        Attemptsleft.setText("Attempts Left: "+model.getAttempts());
        PBar.setProgress(0);
        EasyB.setDisable(false);
        MediumB.setDisable(false);
    	HardB.setDisable(false);
        Interval.setDisable(false);
        Interval.setText("");
        Result.setText("");
        TryButton.setDisable(true);
        TxtNumber.setDisable(true);
        
    }
    
    @FXML
    void Try(ActionEvent event) {

    	if(model.getAttempts() <= 0) {
    		Result.setText(model.CheckEnteredNumber("1")+ " and the secret number was: " +model.getSecretNumber());
    		TryButton.setDisable(true);
            TxtNumber.setText("");
            TxtNumber.setDisable(true);
    	}
    	
    	Result.setText(model.CheckEnteredNumber(TxtNumber.getText()));
    	
    	if(model.isShowInterval() == true) {
    		Interval.setText("Interval of secret number: " +model.getA()+ "-" +model.getB());
    	}
   
    		Attemptsleft.setText("Attempts Left: "+model.getAttempts());
    		
    		PBar.setProgress(model.ProgressPercentage());
    		
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
        assert TryButton != null : "fx:id=\"TryButton\" was not injected: check your FXML file 'Scene.fxml'.";
        EasyB.setDisable(true);
        MediumB.setDisable(true);
        HardB.setDisable(true);
        TryButton.setDisable(true);
        TxtNumber.setDisable(true);
    }
}
