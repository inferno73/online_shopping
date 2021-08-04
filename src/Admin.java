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
			single_instance.setPassword("OnlineAdmin73$");
		}
		return single_instance;
	}
	
	public void changePassword(String newPassword) {
		single_instance.setPassword(newPassword);
	}
	
	//TODO
	public void addItemToList(Item item) {
		//nabavka - dodati "nove objekte ili items"
		
	}
	//pa save u listu
	
	public void removeAUser(String username) {
		User.getCredentials().remove(username);
	}

	@Override
	void finishShopping(double total) {
		ShopMethods shopMethods = ShopMethods.getInstance();
		total = total * SHIPPING_DISCOUNT;
		shopMethods.giveAReceipt(total);
		//TODO
		
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