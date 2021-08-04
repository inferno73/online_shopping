import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
	static Scanner input = new Scanner (System.in);
	static Scanner inputFile;
	
	public static void main(String[] args) throws IOException {
		
		ShopMethods method = ShopMethods.getInstance();
		
		method.createFile("pants.txt");
		method.createFile("shirt.txt");
		method.createFile("jewelry.txt");
		method.createFile("sneakers.txt");
		method.createFile("formal_shoes.txt");
		method.createFile("regular_user.txt");
		method.createFile("vip_user.txt");
		method.createFile("admin.txt");
	
		//TODO populate lists from file data
		
		System.out.println("Welcome to our online shop! ");
		System.out.print("Our average rating: " + method.calculateRating());
		
		
		method.menuWelcome();
		//SignUp
		//LogIn
			//Admin meni 
			//user meni
				// shop meni
						// Pants (file)
							// add cost
		
						// Shirts (file)
							// add cost

						// Sneakers (file)
							// add cost
				
						// FormalShoes (file)
							// add cost
					
						// Jewelry (file)
							// add cost
					
						// End Shopping?
							// YAS
								// discount?
									// input adress
									// input country
									// output shipping
										/* name:
										 * artik:
										 * ....................
										 * COST:
										 */
									// do you want to make a purchase?
										// YAS
											// report
											// Tank You...
										// NO
											// artikli
							// NO
								// "go to shop" meni

	
	 
	}
}
