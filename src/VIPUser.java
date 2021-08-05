import java.util.ArrayList;

public class VIPUser extends User {
	
	private static ArrayList<VIPUser> VIPlist = new ArrayList<VIPUser>();
	private static final double SHIPPING_DISCOUNT = 0.3;
	
	VIPUser() {
		setHasShipping(false);
	}
	
	//TODO - deal with racun stuff - OSTAVITI ZA MAIN!
	@Override
	void finishShopping(double total) {
		ShopMethods shopMethods = ShopMethods.getInstance();
		total = total * SHIPPING_DISCOUNT;
		shopMethods.giveAReceipt(total);
		
		//skini sa racuna total, provjeri prvo validacija ima li dovoljno pa onda skini
		Validation.enoughMoney(, total);
		System.out.println("Thank You!");
	}

	public static ArrayList<VIPUser> getVIPlist() {
		return VIPlist;
	}

	public static void setVIPlist(ArrayList<VIPUser> vIPlist) {
		VIPlist = vIPlist;
	}

		
		
		

}
