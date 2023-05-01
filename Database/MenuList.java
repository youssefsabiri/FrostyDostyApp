package Database;

import java.util.ArrayList;
import java.util.Iterator;

public class MenuList {
	
	public static ArrayList<MenuItem> Menu = new ArrayList<>(); // Initialize the Menu ArrayList as a static variable

	public static void Add(String name, int price) {
		MenuItem item = new MenuItem(name, price);
		Menu.add(item);
	}
	
	public static MenuItem search(String itemname){
		MenuItem item = new MenuItem("not found", 0);
		for(MenuItem i: Menu ){
			if(i.name.equals(itemname)){
				return i;
			}
		}
		return(item);
	}

	public static void display(){
		Iterator<MenuItem> i=Menu.iterator();
		while(i.hasNext()) {
			System.out.println(i.next().toString());
		}
	}
}
