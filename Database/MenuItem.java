package Database;

public class MenuItem {
	
	public String name;
	public int price;
	
	
	public MenuItem(String name, int price) {
		this.name = name;
		this.price = price;
	}


	@Override
	public String toString() {
		return "MenuItem [name=" + name + ", price=" + price + "]";
	}
	
	
	

}
