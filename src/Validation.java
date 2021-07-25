import java.util.HashMap;

public class Validation {
	
	static HashMap<String, String> usernamePassword = new HashMap<String, String>();
	static HashMap<String, String> usernameNumOfBankAcc = new HashMap<String, String>();

    // kod kreiranja usera prvi put
    // check username
    public static boolean alreadyTakenUsername(String username) {
    	if(usernamePassword.containsKey(username)) {
    		System.out.println("Already taken username");
    		return true;
    	}
    	return false;
    }
    
    // kod logina 
    // check username and password
    public static boolean notValidLogin(String username, String password) {
    	if(usernamePassword.containsKey(username) && usernamePassword.get(username).equals(password)) {
    		System.out.println("Not valid login");
    		return true;
    	}
    	return false;
    }
    
    // check numberOfBankAccount
    public static boolean validNumberOfBankAccount(String username, String numberOfBankAccount) {
    	return usernameNumOfBankAcc.containsKey(username) && usernameNumOfBankAcc.get(username).equals(numberOfBankAccount);
    }

    // check money on bank account
    public static boolean enoughMoney(BankAccount numberOfBankAccount, int totalPrice) throws ClassNotFoundException {
    	if(numberOfBankAccount.getAmount() >= totalPrice) 
    		return true;
    	else {
    		System.out.println("You do not have enough money on your bank account");
    		return false;
    	}
    }
  
}
