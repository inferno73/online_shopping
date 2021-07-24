//singleton class
public class Admin extends User {
	
	private static Admin single_instance = null;
	
	private Admin(){
		
	}
	
	public static Admin getInstance() {
		if(single_instance==null) {
			single_instance = new Admin();
			single_instance.setPassword("OnlineAdmin73$");
		}
		return single_instance;
	}
	
	//TODO when inserted the hardcoded pass, able to change it
	public void changePassword() {}
	
	public void addItemToList(Item item) {
		//nabavka - dodati "nove objekte ili items"
		
	}
	
	public void removeAUser(String username) {
		User.getCredentials().remove(username);
	}

	//TODO treba li ova metoda?!
	@Override
	void finishShopping() {
		// TODO Auto-generated method stub
		
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