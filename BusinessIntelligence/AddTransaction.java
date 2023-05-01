package BusinessIntelligence;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Random;


public class AddTransaction {
	
	public void transactionVerified(String name, double amount, double discount) {
		GregorianCalendar date = new GregorianCalendar();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = dateFormat.format(date.getTime());
		Random random = new Random();
        int min = 0;
        int max = 10000;
        int code = random.nextInt(max - min + 1) + min;
		Main.transactions.Add(code, dateString, name , amount, discount);
		JOptionPane.showMessageDialog(null, "Transaction was added successfully to the Transaction Record File", "Success", JOptionPane.INFORMATION_MESSAGE);
		
		
		
	}

}


 