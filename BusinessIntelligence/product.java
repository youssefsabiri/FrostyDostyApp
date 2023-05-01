package BusinessIntelligence;

public class product {
    public int inventoryNumber;
    public String Description;
    public double price;
    public int quantity;
    public String location;


    public product(int inventoryNumber, String description, double price, int quantity, String location) {
        this.inventoryNumber = inventoryNumber;
        Description = description;
        this.price = price;
        this.quantity = quantity;
        this.location = location;
    }

    @Override
    public String toString() {
        return "product{" +
                "inventoryNumber=" + inventoryNumber +
                ", Description='" + Description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", location='" + location + '\'' +
                '}';
    }


}
