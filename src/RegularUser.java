
public class RegularUser extends User {

	RegularUser(String username, String password, int numberOfBankAccount){ 
		super(username, password, numberOfBankAccount);
		setHasShipping(true);
		//if from desired country shipping $5 otherwise $20
	}
	
	// TODO
	@Override
	void finishShopping(double total) {
		ShopMethods shopMethods = ShopMethods.getInstance();
		if( User.getUsername.getNumberOfPurchases >= 5) {
			shopMethods.becomeVIPUser(getUsername());
		}
		shopMethods.giveAReceipt(total);
		System.out.println("Thank You!");
	}

}
