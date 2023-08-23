package BusinessIntelligence;

public class Client {
	public String fullname;
    public String address;
    public String phonenumber;
    public account account;
    
    
	public Client(String fullname, String address, String phonenumber, account account) {
		this.fullname = fullname;
		this.address = address;
		this.phonenumber = phonenumber;
		this.account = account;
	}


	@Override
	public String toString() {
		return "Client [fullname=" + fullname + ", address=" + address + ", phonenumber=" + phonenumber + ", account="
				+ account + "]";
	}

	


     

}
