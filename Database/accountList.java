package Database;

import BusinessIntelligence.account;

import java.util.ArrayList;
import java.util.Iterator;



public class accountList {

     public   ArrayList<account> accounts= new ArrayList<>();
     
     

        public accountList() {
        	ArrayList<account> accounts = new ArrayList<account>();
        	this.accounts = accounts;
	}

		public void Add(String email, String password){
            account ac = new account(email ,password);
            accounts.add(ac);
            WriteToAccountsFile.write(accounts);
        }
        
        public void remove(String login){
            for(account i: accounts ){
                if(i.login.equals(login)){
                    accounts.remove(i);
                    WriteToAccountsFile.write(accounts);
                    return;
                }
            }

        }


        public account search(String login){
        	account a = new account("not found", "not found");
            for(account i: accounts ){
                if(i.login.equals(login)){
                    return i;
                    
                }
            }
            return(a);
            
            
        	/*String fileName = "src/Database/RecordOfAccounts.txt";
            String filePath = new File(fileName).getAbsolutePath();
            String email, temp, password;

            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                String line = reader.readLine();
                while (line != null) {
                    if (line.contains(".")) { // Check if line contains "$"
                        temp = line;
                        String[] parts = temp.split(".");
                        email = parts[0];
                        password = parts[1];
                        account b = new account(email, password);
                    }
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                System.out.println("An error occurred while reading the file: " + filePath);
                e.printStackTrace();
            }  */
        	


        }
        
        public void update(account oldacc, account newacc) {
        for (account i : accounts) {
            if (i.login.equals(oldacc.login)) {
                i=newacc;
                WriteToAccountsFile.write(accounts);
                return ;
            }
        }

    }

        public void display(){
            Iterator<account> i=accounts.iterator();
            while(i.hasNext()) {
                System.out.println(i.next().toString());
            }
        }
    


}




