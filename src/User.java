import java.util.HashMap;

public abstract class User {
/*
    methods: buyItem();  ()*/
	User() {
		
	}
	
	User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	User(String username, String password, int numberOfBankAccount) {
		this.username = username;
		this.password = password;
		this.numberOfBankAccount = numberOfBankAccount;
	}
	
	/*TODO HashMap ILI DATA CLASS
    //check if valid username
    public boolean alreadyTakenUsername(String username) {
        return credentialsMap.containsKey(username);
    }
    
    //check if valid pair
	public boolean checkCredentials(String username, String password) {
	        return credentialsMap.containsKey(username) && credentialsMap.get(username).equals(password);
	}

    */
	
	private String username;
	private String password;
	private int numberOfBankAccount;
	private int rate; //number of rating stars: 1 being bad and 5 excellent
	private HashMap<String, String> credentialsMap = new HashMap<String,String>(); //Credentials - including username, password
	private double shipping; //free for admin and vip
	
	
	//TODO abstract?
	abstract void finishShopping(); //as the way of calculating the final price is different for each type of users

	//TODO
	public void addToCart() {
		//cijena i zapamtiti toString artikla jer to ispisati na kraju
	}
	//store credentials
    public void addCredentials(String username, String password) {
        credentialsMap.put(username, password);
    }
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getNumberOfBankAccount() {
		return numberOfBankAccount;
	}

	public void setNumberOfBankAccount(int numberOfBankAccount) {
		this.numberOfBankAccount = numberOfBankAccount;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public double getShipping() {
		return shipping;
	}

	public void setShipping(double shipping) {
		this.shipping = shipping;
	}		
	
	
}
