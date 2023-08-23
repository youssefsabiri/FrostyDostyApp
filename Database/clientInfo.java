package Database;


public class clientInfo {
	public String fullname;
	public String phonenumber;
	public String address;
	public String email;

    public clientInfo(String firstname, String middlename, String lastname, String phonenumber, String city, String street, String email) {
        this.phonenumber = phonenumber;
        this.email = email;

        this.fullname = String.join(" ", 
            firstname == null ? "" : firstname, 
            middlename == null ? "" : middlename, 
            lastname == null ? "" : lastname
        ).trim();

        // Concatenating city, street into address
        this.address = String.join(",", 
            street == null ? "" : street, 
            city == null ? "" : city
        ).replaceAll("\\s*,\\s*", ",");
    }

	
}

