package Database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Store {
	
	
    public static void loadMenu() {
        String fileName = "src/Database/Menu.txt";
        String filePath = new File(fileName).getAbsolutePath();
        String name, temp, pricestr;
        int price;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null) {
                if (line.contains("$")) { // Check if line contains "$"
                    temp = line;
                    String[] parts = temp.split("\\$");
                    name = parts[0];
                    pricestr = parts[1];
                    price = Integer.valueOf(pricestr);
                    MenuList.Add(name, price);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + filePath);
            e.printStackTrace();
        }

    }
}
