package Database;

import BusinessIntelligence.Client;
import BusinessIntelligence.account;

import java.util.ArrayList;
import java.util.Iterator;


public class ClientList {

     public  ArrayList<Client> clients= new ArrayList<>();
     
     

        public ClientList() {
        	ArrayList<Client> clients = new ArrayList<Client>();
        	this.clients = clients;
	}

		public void Add(String fullname, String phonenumber, String address, account account){
            Client ac = new Client(fullname ,phonenumber, address, account);
            clients.add(ac);
            WriteToClientsFile.write(clients);
        }
        


		public void remove(String fullname){
            for(Client i: clients ){
                if(i.fullname.equals(fullname)){
                	clients.remove(i);
                	WriteToClientsFile.write(clients);
                	return;
                }
            }

        }


        public Client search(String fullname){
        	account acc = new account("not found", "not found");
        	Client a = new Client("not found", "not found", "not found", acc);
            for(Client i: clients ){
                if(i.fullname.equals(fullname)){
                    return i;
                    
                }
            }
            																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																	
            return(a);

        }
        
        
        public Client searchByAccount(account acc){
        	account acct = new account("not found", "not found");
        	Client a = new Client("not found", "not found", "not found", acct);
            for(Client i: clients ){
                if(i.account.equals(acc)){
                    return i;
                    
                }
            }
            return (a);

        }
        
        public void update(Client oldclient, Client newclient) {
            for (Client i : clients) {
                if (i.account.equals(oldclient.account)) {
                    i=newclient;
                    WriteToClientsFile.write(clients);
                    return ;
                }
            }
        }
        public void display(){
            Iterator<Client> i=clients.iterator();
            while(i.hasNext()) {
                System.out.println(i.next().toString());
            }
        }
    }