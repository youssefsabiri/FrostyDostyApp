package Database;

import BusinessIntelligence.product;

import java.util.ArrayList;
import java.util.Iterator;

public class productlist {

        public ArrayList<product> products= new ArrayList<>();

        public void add(int number, String des, double price, int quantity, String location){
            product pr = new product(number,des,price,quantity,location);
            products.add(pr);
            WriteToProductsFile.write(products);
        }
        
        public void remove(int number){
            for(product i: products ){
                if(i.inventoryNumber == number){
                    products.remove(i);
                    WriteToProductsFile.write(products);
                    return;
                }
            }

        }



        public product search(int number){
        	product a = new product(0, "not found", 0,0,  "not found");
            for(product i: products ){
                if(i.inventoryNumber == number){
                    return i;
                    
                }
            }
            
            return(a);

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
    


}
