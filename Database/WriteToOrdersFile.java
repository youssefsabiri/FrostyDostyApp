package Database;


import BusinessIntelligence.order;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteToOrdersFile {
	
    public static void write(ArrayList<order> orders) {
    	
        String fileName = "src/Database/RecordOfOrders.txt";
        //String filePath = new File(fileName).getAbsolutePath();

        try {
            FileWriter writer = new FileWriter(fileName);
            for (order element : orders) {
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


