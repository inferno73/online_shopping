
public class RegularUser extends User {
	
	
	RegularUser (){
	
	}
	RegularUser(String username, String password, int numberOfBankAccount){ 
		super(username, password, numberOfBankAccount);
		setHasShipping(true);
		//if from desired country shipping $5 otherwise $20
	}
	
	// TODO
	@Override
	void finishShopping(double total, int currentNumberOfBankAccount, int shipping) {
		ShopMethods shopMethods = ShopMethods.getInstance();
		
		if(Validation.enoughMoney(currentNumberOfBankAccount, total))
		{
			for(int i=0; i<BankAccount.getList().size(); i++) {
				if(BankAccount.getList().get(i).getNumberOfBankAccount() == currentNumberOfBankAccount) {
					BankAccount.getList().get(i).reduceAmount(total);
				}
			}
		}
			
		
		shopMethods.giveAReceipt(total, shipping);
		System.out.println("Thank You!");
		
	}

}
