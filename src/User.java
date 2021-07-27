import java.util.ArrayList;
import java.util.HashMap;

public abstract class User {
	
	private static ArrayList<User> list = new ArrayList<User>();
	private static HashMap<String, String> credentialsMap = new HashMap<String,String>(); //Credentials - including username, password
	

	User() {
		
	}
	
	User(boolean hasShipping) {
		this.hasShipping = hasShipping;
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
	
	private String username;
	private String password;
	private int numberOfBankAccount;
	private int rate; //number of rating stars: 1 being bad and 5 excellent
	private boolean hasShipping; //free for admin and vip
	private int numberOfPurchases;
	

	abstract void finishShopping(double total); //as the way of calculating the final price is different for each type of users

	public void addToCart(Item item) {
		//cijena i zapamtiti toString artikla jer to ispisati na kraju
		ShopMethods shopMethods = ShopMethods.getInstance();
		shopMethods.createFile("receipt.txt");  //if not created
		shopMethods.writeToReceipt(item.toString()); //TOCHECK treba da se pozove metoda definisanog objekta npr pants a ne metoda items
		//TODO remove added item from the list of available items: metoda da se pozove nakon ove u mainu i rijesi se ovaj problem
		
	}
	
	//store credentials
    public static void addCredentials(String username, String password) {
        credentialsMap.put(username, password);
    }
    
    public static HashMap<String, String> getCredentials () {
    	return credentialsMap;
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

	public static ArrayList<User> getList() {
		return list;
	}

	public static void setList(ArrayList<User> list) {
		User.list = list;
	}

	public boolean getHasShipping() {
		return hasShipping;
	}

	public void setHasShipping(boolean hasShipping) {
		this.hasShipping = hasShipping;
	}

	public int getNumberOfPurchases() {
		return numberOfPurchases;
	}

	public void setNumberOfPurchases(int numberOfPurchases) {
		this.numberOfPurchases = numberOfPurchases;
	}		
	
	
}
