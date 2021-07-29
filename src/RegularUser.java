import java.util.ArrayList;

public class RegularUser extends User {

	RegularUser(String username, String password, int numberOfBankAccount){ 
		super(username, password, numberOfBankAccount);
		setHasShipping(true);
		//if from desired country shipping $5 otherwise $20
		}
	
	private static ArrayList<RegularUser> list = new ArrayList<RegularUser>();
	
		public static ArrayList<RegularUser> getList() {
		return list;
	}

	public static void setList(ArrayList<RegularUser> list) {
		RegularUser.list = list;
	}

		@Override
		void finishShopping(double total) {
			ShopMethods shopMethods = ShopMethods.getInstance();
			//TODO deal with shipping
			shopMethods.giveAReceipt(total);
			
		}

}
