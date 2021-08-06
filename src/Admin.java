//singleton class
public class Admin extends User {
	
	private static final double SHIPPING_DISCOUNT = 0.4;
	private static Admin single_instance = null;
	
	private Admin(){
		setHasShipping(false);
	}
	
	public static Admin getInstance() {
		if(single_instance==null) {
			single_instance = new Admin();
			single_instance.setPassword("OnlineAdmin73$"); //admin123
		}
		return single_instance;
	}
	
	public void changePassword(String newPassword) {
		single_instance.setPassword(newPassword);
	}
	
	public void removeAUser(String username) {
		for(int i = 9; i < User.getList().size(); i++)
		{
			if(User.getList().get(i).getUsername().equals(username)) {
				User.getList().remove(User.getList().get(i));
			}
		}
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

}

/*class Singleton
{
    // static variable single_instance of type Singleton
    private static Singleton single_instance = null;
  
    // variable of type String
    public String s;
  
    // private constructor restricted to this class itself
    private Singleton()
    {
        s = "Hello I am a string part of Singleton class";
    }
  
    // static method to create instance of Singleton class
    public static Singleton getInstance()
    {
        if (single_instance == null)
            single_instance = new Singleton();
  
        return single_instance;
    }
}
  */