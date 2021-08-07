import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {

		ShopMethods method = ShopMethods.getInstance();
		
		method.createFile("pants.txt");
		method.createFile("shirt.txt");
		method.createFile("jewelry.txt");
		method.createFile("sneakers.txt");
		method.createFile("formal_shoes.txt");
		method.createFile("user.txt");
		method.createFile("vip_user.txt");
		method.createFile("bank_account.txt");
		method.saveAllToList();
		
		System.out.println("Welcome to our online shop! ");
		System.out.println();
		
		method.menuWelcome();

		method.saveAllToFile();
		
	}
}
