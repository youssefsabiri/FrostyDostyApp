package BusinessIntelligence;

import RemoteInterface.Main;

public class CalculateExpenses {
	
	public static double calcul() {
		double expenses=0;
		for (Transaction trans: Main.transactions) {
			if (trans.description.equals("Employee Salary") || trans.description.equals("Supplier Payment")){
				double amount2 = Double.parseDouble(trans.amount);
				expenses=expenses+amount2;
			}
			}
		
		return expenses;
		}
	
	}
    
 


