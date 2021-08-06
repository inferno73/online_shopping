import java.io.IOException;

public interface ShopInterface {
	
	//MENUS
	public void menuWelcome();
	public void menuSignUp();
	public void menuLogIn();
	public void menuAdmin();
	public void menuUser(String username);
	public void menuShop(String username);
	public void menuRating(String password);
	public void menuAddNewItem();
	public void menuEndShopping (String username, double cost);
	
	
	public void giveAReceipt(double total); //gives a receipt based on writeToReceipt method 
	
	public double calculateTotal(double cost, int shipping); //returns total price: adds new expense to previous expense
	
	public int determineShippingInfo();
	
	public double calculateRating();
	
	public void becomeVIPUser(String username);
	
	public void countPurchases(String username); // counts purchases for discounts

	
	//FILES-LISTS
	public void createFile(String fileName) throws IOException;
	
	public void printFromFile(String fileName)throws IOException; //writes file data to console so user can choose what to buy

	public void saveToListPants();
	public void saveToFilePants();
	
	public void saveToListShirt();
	public void saveToFileShirt();
	
	public void saveToListJewelry();
	public void saveToFileJewelry();
	
	public void saveToListSneakers();
	public void saveToFileSneakers();
	
	public void saveToListFormalShoes();
	public void saveToFileFormalShoes();
	
	public void saveToListUser();	
	public void saveToFileUser();
	
	public void saveToListVIPUser();	
	public void saveToFileVIPUser();
	
	public void saveAllToFile();
	public void saveAllToList();
	
}
