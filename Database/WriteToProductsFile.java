package Database;


import BusinessIntelligence.product;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class WriteToProductsFile {
	
    public static void write(ArrayList<product> products) {
    	
        String fileName = "src/Database/RecordOfProducts.txt";
        //String filePath = new File(fileName).getAbsolutePath();

        try {
            FileWriter writer = new FileWriter(fileName);
            for (product element : products) {
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


