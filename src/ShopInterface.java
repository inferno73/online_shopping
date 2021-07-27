import java.io.IOException;

public interface ShopInterface {
	
	public void createFile(String fileName) throws IOException;
	
	public void printFromFile();
	
	public void saveFileToList(); //TODO add parameters lista i ime filea
	
	public void saveListToFile();  //TODO add parameters lista i ime filea
	
	public void writeToReceipt(String itemDetails);  //writes down item specs when it is added to cart
	
	public void giveAReceipt(double total); //gives a receipt based on writeToReceipt method 
	
	public double calculateTotal(double itemPrice, double previousTotal); //returns total price: adds new expense to previous expense
	
	public void determineShippingInfo();
	
}
