package Database;


import BusinessIntelligence.Client;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class WriteToClientsFile {
	
    public static void write(ArrayList<Client> clients) {
    	
        String fileName = "src/Database/RecordOfClients.txt";
        //String filePath = new File(fileName).getAbsolutePath();

        try {
            FileWriter writer = new FileWriter(fileName);
            for (Client element : clients) {
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


