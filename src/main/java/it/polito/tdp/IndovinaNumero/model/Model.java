package it.polito.tdp.IndovinaNumero.model;

import java.util.TreeMap;

public class Model {
	
	public TreeMap<Integer,Integer> MapNumero = new TreeMap<Integer,Integer>();
	public int Attempts;
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
	
	public void EasyGame () {
		
		Nmax = 100;
    	Attempts = 10;
    	TotAtt = Attempts;
    	Intervall = 30;
        a = SecretNumber-Intervall;
        b = SecretNumber+Intervall;
    	
    	if((SecretNumber-Intervall)<1 ) {
    		a = 1;
    	}
    	if((SecretNumber+Intervall)>100) {
    		b = 100;
    	}
		
	}

	public void HardGame () {
		
		Nmax = 100;
    	Attempts = 2;
    	TotAtt = Attempts;
    	ShowInterval = false;
		
	}
	
	public void MediumGame () {
		
		Nmax = 100;
    	Attempts = 6;
    	TotAtt = Attempts;
    	Intervall = 40;
    	
    	a = SecretNumber-Intervall;
        b = SecretNumber+Intervall;
    	
    	if((SecretNumber-Intervall)<1 ) {
    		a = 1;
    	}
    	if((SecretNumber+Intervall)>100) {
    		b = 100;
    	}
		
	}
	
	public void NewGame() {
		
		SecretNumber = GetSecretNumber();
        MapNumero.clear();
        ShowInterval = true;
		
	}
	
	public String CheckEnteredNumber (String x) {
				
		int u = 0;
		
		if(x.length()==0) {
			return "Enter a whole Number between 1 and 100 please";
		}
		
		try {
			u = Integer.parseInt(x);
		}
		catch(NumberFormatException e) {
			System.out.println("Enter a whole Number between 1 and 100 please");
		}
		
		if(MapNumero.get(u)!=null) {
			return "Number already Entered previously";
		}
		
		MapNumero.put(u, u);
		
		if(u > 100) {
			return "Number should be whole and between 1 and 100";
		}
		
		else if(u < 1) {
			return "Number should be whole and between 1 and 100";
		}
		
		else if(u == SecretNumber) {
			return "You win";
		}
		
		else if(u > SecretNumber) {
			Attempts--;
			a += 3;
			
			if(a > SecretNumber) {
				a = SecretNumber - 1 ;
			}
			
			b -= 3;
			
			if(b < SecretNumber) {
				b = SecretNumber+1;
			}
			
			if(Attempts <= 0) {
				return "Your attempts have finished, you lose, and the secret number was: " +SecretNumber;
			}
			
			return "Number is too big";
		}
		
		else if(u < SecretNumber) {
			Attempts--;
			a += 3;
			
			if(a > SecretNumber) {
				a = SecretNumber - 1 ;
			}
			
			b -= 3;
			
			if(b < SecretNumber) {
				b = SecretNumber+1;
			}
			
			if(Attempts <= 0) {
				return "Your attempts have finished, you lose, and the secret number was: " +SecretNumber;
			}
			
			return "Number is too small";
		}
		
		
		return "";
	}
	
	public double ProgressPercentage() {
		
		double i = 1 - (double)(Attempts)/TotAtt;
		
		return i;
	}

	public TreeMap<Integer, Integer> getMapNumero() {
		return MapNumero;
	}

	public void setMapNumero(TreeMap<Integer, Integer> mapNumero) {
		MapNumero = mapNumero;
	}

	public int getAttempts() {
		return Attempts;
	}

	public void setAttempts(int attempts) {
		Attempts = attempts;
	}

	public int getTotAtt() {
		return TotAtt;
	}

	public void setTotAtt(int totAtt) {
		TotAtt = totAtt;
	}

	public double getNmax() {
		return Nmax;
	}

	public void setNmax(double nmax) {
		Nmax = nmax;
	}

	public int getSecretNumber() {
		return SecretNumber;
	}

	public void setSecretNumber(int secretNumber) {
		SecretNumber = secretNumber;
	}

	public int getIntervall() {
		return Intervall;
	}

	public void setIntervall(int intervall) {
		Intervall = intervall;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public boolean isShowInterval() {
		return ShowInterval;
	}

	public void setShowInterval(boolean showInterval) {
		ShowInterval = showInterval;
	}
	
	
	
}
