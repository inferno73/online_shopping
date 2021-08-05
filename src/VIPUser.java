import java.util.ArrayList;

public class VIPUser extends User {
	
	private static ArrayList<VIPUser> VIPlist = new ArrayList<VIPUser>();
	private static final double SHIPPING_DISCOUNT = 0.3;
	
	VIPUser() {
		setHasShipping(false);
	}
	
	
	@Override
	void finishShopping(double total, int currentNumberOfBankAccount) {
		ShopMethods shopMethods = ShopMethods.getInstance();
		total = total * SHIPPING_DISCOUNT;
		
		if(Validation.enoughMoney(currentNumberOfBankAccount, total))
		{
			for(int i=0; i<BankAccount.getList().size(); i++) {
				if(BankAccount.getList().get(i).getNumberOfBankAccount() == currentNumberOfBankAccount) {
					BankAccount.getList().get(i).reduceAmount(total);
				}
			}
		}
		shopMethods.giveAReceipt(total);

		System.out.println("Thank You!");
	}

	public static ArrayList<VIPUser> getVIPlist() {
		return VIPlist;
	}

	public static void setVIPlist(ArrayList<VIPUser> vIPlist) {
		VIPlist = vIPlist;
	}

		
		
		

}
