package Database;



import BusinessIntelligence.Transaction;
import BusinessIntelligence.product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class productlist implements Iterable<product>{

        public ArrayList<product> products= new ArrayList<>();

        public void add(int number, String name, double price, double quantity, double min,String location){
            product pr = new product(number,name,price,quantity, min,location);
            products.add(pr);

        }
        
        public void remove(int number){
            for(product i: products ){
                if(i.inventoryNumber == number){
                    products.remove(i);

                    return;
                }
            }

        }



      
        
        public void update(product oldproduct, product newproduct) {
        for (product i : products) {
            if (i.inventoryNumber == oldproduct.inventoryNumber) {
                i=newproduct;
                return ;
            }
        }

    }

        public void display(){
            Iterator<product> i=products.iterator();
            while(i.hasNext()) {
                System.out.println(i.next().toString());
            }
        }
    
        public Iterator<product> iterator() {
            return products.iterator();
        }
        

        
        public void populate() {
            Random rand = new Random();

            for (int i = 1; i <= 100; i++) {
                int code = i;
                String name = getRandomInventoryMaterial(rand);
                double price = rand.nextDouble(39) +12;
                double quantity = rand.nextDouble(51);
                double min = 1; // Random amount between 100 and 10000
                String location = getRandomLocation(rand);

                add(code, name, price, quantity, min, location);
            }
        }

        // Helper method to generate random date in format (DD-MM-YYYY)

        
        private static String getRandomLocation(Random rand) {
            String[] locations = {"Row 1", "Row 2", "Row 3", "Row 4"};
            return locations[rand.nextInt(locations.length)];
        }

        // Helper method to get a random description from the given options
        private static String getRandomInventoryMaterial(Random rand) {
            String[] inventoryMaterials = {
                "Coffee Beans",
                "Milk",
                "Espresso",
                "Cappuccino Mix",
                "Latte Mix",
                "Sugar",
                "Sweetener",
                "Honey",
                "Vanilla Syrup",
                "Caramel Syrup",
                "Chocolate Syrup",
                "Hazelnut Syrup",
                "Whipped Cream",
                "Cinnamon",
                "Cocoa Powder",
                "Nutmeg",
                "Ground Cinnamon",
                "Ground Nutmeg",
                "Ground Ginger",
                "Ground Cloves",
                "Ground Allspice",
                "Ground Cardamom",
                "Ground Coriander",
                "Ground Fennel",
                "Ground Turmeric",
                "Ground Vanilla Bean",
                "Ground Cayenne Pepper",
                "Ground Black Pepper",
                "Ground White Pepper",
                "Ground Red Pepper",
                "Ground Paprika",
                "Ground Smoked Paprika",
                "Ground Chili Powder",
                "Ground Cumin",
                "Ground Mustard",
                "Ground Thyme",
                "Ground Rosemary",
                "Ground Sage",
                "Ground Oregano",
                "Ground Basil",
                "Ground Parsley",
                "Ground Marjoram",
                "Ground Tarragon",
                "Ground Dill",
                "Ground Bay Leaf",
                "Ground Caraway",
                "Ground Celery Seed",
                "Ground Onion",
                "Ground Garlic",
                "Ground Ginger",
                "Ground Cloves",
                "Ground Allspice",
                "Ground Cardamom",
                "Ground Coriander",
                "Ground Fennel",
                "Ground Turmeric",
                "Ground Vanilla Bean",
                "Ground Cayenne Pepper",
                "Ground Black Pepper",
                "Ground White Pepper",
                "Ground Red Pepper",
                "Ground Paprika",
                "Ground Smoked Paprika",
                "Ground Chili Powder",
                "Ground Cumin",
                "Ground Mustard",
                "Ground Thyme",
                "Ground Rosemary",
                "Ground Sage",
                "Ground Oregano",
                "Ground Basil",
                "Ground Parsley",
                "Ground Marjoram",
                "Ground Tarragon",
                "Ground Dill",
                "Ground Bay Leaf",
                "Ground Caraway",
                "Ground Celery Seed",
                "Ground Onion",
                "Ground Garlic",
                "Ground Ginger",
                "Ground Cloves",
                "Ground Allspice",
                "Ground Cardamom",
                "Ground Coriander",
                "Ground Fennel",
                "Ground Turmeric",
                "Ground Vanilla Bean",
                "Ground Cayenne Pepper",
                "Ground Black Pepper",
                "Ground White Pepper",
                "Ground Red Pepper",
                "Ground Paprika",
                "Ground Smoked Paprika",
                "Ground Chili Powder",
                "Ground Cumin",
                "Ground Mustard",
                "Ground Thyme",
                "Ground Rosemary",
                "Ground Sage",
                "Ground Oregano"};
        return inventoryMaterials[rand.nextInt(inventoryMaterials.length)];
                }

           


}
