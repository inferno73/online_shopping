
public class Validation {

    public static boolean alreadyTakenUsername(String username) {
    	for (int i = 0; i < User.getList().size(); i++){
			if(User.getList().get(i).getUsername().equals(username)){
				return true;
			}
		}
    	return false;
    }
    
    public static boolean alreadyTakenPassword(String password) {
    	for (int i = 0; i < User.getList().size(); i++){
			if(User.getList().get(i).getPassword().equals(password)){
				return true;
			}
		}
    	return false;
    }

    public static boolean alreadyTakenBankAccount(int number) {
    	for (int i = 0; i < User.getList().size(); i++){
			if(User.getList().get(i).getNumberOfBankAccount() == number){
				return true;
			}
		}
    	return false;
    }
    
    // password and username not matching
    public static boolean invalidLogin(String username, String password) {
    	for (int i = 0; i < User.getList().size(); i++){
			if(User.getList().get(i).getUsername().equals(username) && User.getList().get(i).getPassword().equals(password)){
				return false;
			}
		}
    	return true;
    }
    
    // check numberOfBankAccount
    public static boolean validNumberOfBankAccount(String username, int numberOfBankAccount) {
    	for (int i = 0; i < User.getList().size(); i++){
			if(User.getList().get(i).getUsername().equals(username)){
				if(User.getList().get(i).getNumberOfBankAccount() == numberOfBankAccount) {
					return true;
				}
			}
		}
    	return false;
    }

    // check money on bank account
    public static boolean enoughMoney(int numberOfBankAccount, double totalPrice) {
    	for(int i=0; i<BankAccount.getList().size(); i++) {
			if(BankAccount.getList().get(i).getNumberOfBankAccount() == numberOfBankAccount) {
				if(BankAccount.getList().get(i).getAmount() >= totalPrice) {
		    		return true;
				}
			}
    	}
    	return false;
    }
    
}
