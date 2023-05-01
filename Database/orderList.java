package Database;

import BusinessIntelligence.order;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class orderList {

    public ArrayList<order> orders= new ArrayList<>();
    FileWriter writer;

    public orderList() {
        orders = new ArrayList<>();
    }

    public void add(int orderCode, String date, String des, int quantity) {
        order or = new order(orderCode, date, des, quantity);
        orders.add(or);
        WriteToOrdersFile.write(orders);
    }

    public void remove(int orderCode){
        for(order i: orders ){
            if(i.orderCode==orderCode){
            	orders.remove(i);
            	WriteToOrdersFile.write(orders);
            	return; 
            }
        }

    }


    public order search(int orderCode){
    	order a = new order(0,"not found" , "not found", 0);
        for(order i: orders ){
            if(i.orderCode==orderCode){
                return i;
                
            }
        }
        
        return(a);

    }
    
    
    public void update(int code, order neworder) {
    for (order i : orders) {
        if (i.orderCode==code) {
            i=neworder;
            WriteToOrdersFile.write(orders);
            return ;
        }
    }

}

    public void display(){
        Iterator<order> i=orders.iterator();
        while(i.hasNext()) {
            System.out.println(i.next().toString());
        }
    }



}

