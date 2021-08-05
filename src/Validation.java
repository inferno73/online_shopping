
public class Validation {

    // kod kreiranja usera prvi put
    // check username
    public static boolean alreadyTakenUsername(String username) {
    	if(User.getCredentials().containsKey(username)) {
    		//System.out.println("Already taken username.");
    		return true;
    	}
    	return false;
    }
    
    public static boolean alreadyTakenPassword(String password) {
    	if(User.getCredentials().containsKey(password)) {
    		//System.out.println("Already taken password.");
    		return true;
    	}
    	return false;
    }

    public static boolean alreadyTakenBankAccount(int number) {
    	for (int i = 0; i < User.getList().size(); i++){
			if(User.getList().get(i).getNumberOfBankAccount() == number){
				//System.out.println("Already taken username.");
				return true;
			}
		}
    	return false;
    }
    // kod logina 
    // check username and password
    public static boolean invalidLogin(String username, String password) {
    	if(User.getCredentials().containsKey(username) && User.getCredentials().get(username).equals(password)) {
    		//System.out.println("Invalid login.");
    		return true;
    	}
    	return false;
    }
    
    // check numberOfBankAccount
    public static boolean validNumberOfBankAccount(String username, int numberOfBankAccount) {
    	for (int i = 0; i < User.getList().size(); i++){
			if(User.getList().get(i).getUsername() == username){
				if(User.getList().get(i).getNumberOfBankAccount() == numberOfBankAccount) {
					//System.out.println("Valid Number of BankAccount.");
					return true;
				}
			}
		}
    	return false;
    }

    // check money on bank account
    public static boolean enoughMoney(BankAccount numberOfBankAccount, int totalPrice) throws ClassNotFoundException {
    	if(numberOfBankAccount.getAmount() >= totalPrice) 
    		return true;
    	else {
    		//System.out.println("You do not have enough money on your bank account.");
    		return false;
    	}
    }
  
}
