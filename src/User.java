import java.util.ArrayList;

public abstract class User {

	private String username;
	private String password;
	private int numberOfBankAccount;
	private boolean hasShipping; //free for admin and vip
	private int numberOfPurchases;
	private static ArrayList<User> list = new ArrayList<User>();
	
	User() {
		
	}
	
	User (String username, String password, int numberOfBankAccount,  boolean hasShipping, int numberOfPurchases){
		this.username = username;
		this.password = password;
		this.numberOfBankAccount = numberOfBankAccount;
		this.hasShipping = hasShipping;
		this.numberOfPurchases = numberOfPurchases;
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

	abstract void finishShopping(double total, int currentNumberOfBankAccount, int shipping); //as the way of calculating the final price is different for each type of users
	
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

	public static ArrayList<User> getList() {
		return list;
	}

	public static void setList(ArrayList<User> list) {
		User.list = list;
	}		
	
	
}
