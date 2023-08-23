package BusinessIntelligence;


public class CalculateIncome {
	public static double calcul() {
		double revenues=CalculateRevenues.calcul();
		double expenses=CalculateExpenses.calcul();
		double income=revenues-expenses;
		
		
		return income;
		}
	
	}
  


