package Database;


import BusinessIntelligence.account;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class WriteToAccountsFile {
	
    public static void write(ArrayList<account> accounts) {
    	
        String fileName = "src/Database/RecordOfAccounts.txt";
        //String filePath = new File(fileName).getAbsolutePath();

        try {
            FileWriter writer = new FileWriter(fileName);
            for (account element : accounts) {
                writer.write(element.login + "." + element.getPassword()+ "\n");
            }
            writer.close();
            //System.out.println("Successfully wrote to the file: " + filePath);
        } catch (IOException e) {
            //System.out.println("An error occurred while writing to the file: " + filePath);
            e.printStackTrace();
        }
    }
}


