package BusinessIntelligence;

import RemoteInterface.Main;

public class CalculateRevenues {
	
	public static double calcul() {
		double revenues=0;
		for (Transaction trans: Main.transactions) {
			if (trans.description.equals("Client Payment")){
				double amount2 = Double.parseDouble(trans.amount);
				revenues=revenues+amount2;
			}
			}
		
		return revenues;
		}

	
	}
    
 


