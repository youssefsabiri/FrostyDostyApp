package BusinessIntelligence;



public class account {
    public String login;
    private String password ;

    public account(String login, String password) {
        this.login = login;
        this.password = password;
    }

    

	@Override
	public String toString() {
		return "account [login=" + login + ", password=" + password + "]";
	}


	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}





