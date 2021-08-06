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
		method.saveAllToList();
		
		System.out.println("Welcome to our online shop! ");
		System.out.println("Our average rating: " + method.calculateRating());
		System.out.println();
		
		method.menuWelcome();

		method.saveAllToFile();
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
							// YES
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
										// YES
											// report
											// Tank You...
										// NO
											// artikli
							// NO
								// "go to shop" meni

	}
}
