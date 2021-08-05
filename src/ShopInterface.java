import java.io.IOException;
import java.util.ArrayList;

public interface ShopInterface {
	
	//FILES-LISTS
	public void createFile(String fileName) throws IOException;
	
	public void printFromFile(String fileName)throws IOException; //writes file data to console so user can choose what to buy
	 
	//TODO Kanita - pokusaj da imas samo ove dvije metode ispod, pa da ih OVERLOAD u ShopMethods i dajes joj parametre razlicitog tipa tj listu objekata, ako ne bude
	//moglo tako, onda ih izbrisi a u shopMethods da imas overloadane samo metode bez overridinga
/*	
	public void saveToList();
	
	public void saveToFile();
	
	public void saveFileToList(String fileName, ArrayList<?> list); //TODO add parameters lista i ime filea
	
	public void saveListToFile(String fileName, ArrayList<?> list);  //TODO add parameters lista i ime filea
*/	
	
	 //TODO kodove ovih metoda iskoristi kad uradis OVERLOAD ovih iznad u shopMethods
	  
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
	
/*
	public void saveToListUser();
	
	public void saveToFileUser();
	
	public void saveToListVIPUser();
	
	public void saveToFileVIPUser();
	
	public void saveToListAdmin();
	
	public void saveToFileAdmin();
	
	public void saveToListRegularUser();
	
	public void saveToFileRegularUser();
*/	
	
	//MENUS
	public void menuWelcome();
	public void menuSignUp();
	public void menuLogIn();
	public void menuAdmin();
	public void menuUser(String username);
	public void menuShop(String username);
	public void menuRating(String password);
	public void menuAddNewItem();
	
	public void writeToReceipt(String itemDetails);  //writes down item specs when it is added to cart
	
	public void giveAReceipt(double total); //gives a receipt based on writeToReceipt method 
	
	public double calculateTotal(double itemPrice, double previousTotal); //returns total price: adds new expense to previous expense
	
	public void determineShippingInfo();
	
	public double calculateRating();
	
	public void becomeVIPUser(String username);
	
	public void countPurchases (String username);
	
	
}
