
public class RegularUser extends User {

	RegularUser(String username, String password, int numberOfBankAccount){ 
		super(username, password, numberOfBankAccount);
		setHasShipping(true);
		//if from desired country shipping $5 otherwise $20
		}
	
	
		@Override
		void finishShopping(double total) {
			ShopMethods shopMethods = ShopMethods.getInstance();
			//TODO deal with shipping
			shopMethods.giveAReceipt(total);
			
		}

}
