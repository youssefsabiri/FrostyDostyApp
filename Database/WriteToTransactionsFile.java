package Database;


import BusinessIntelligence.Transaction;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class WriteToTransactionsFile {
	
    public static void write(ArrayList<Transaction> transactions) {
    	
        String fileName = "src/Database/RecordOfTransactions.txt";
        //String filePath = new File(fileName).getAbsolutePath();

        try {
            FileWriter writer = new FileWriter(fileName);
            for (Transaction element : transactions) {
                writer.write(element.toString() + "\n");
            }
            writer.close();
            //System.out.println("Successfully wrote to the file: " + filePath);
        } catch (IOException e) {
            //System.out.println("An error occurred while writing to the file: " + filePath);
            e.printStackTrace();
        }
    }
}


