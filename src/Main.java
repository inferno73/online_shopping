import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
	static Scanner input = new Scanner (System.in);
	static Scanner inputFile;
	
	public static void main(String[] args) {
		/*public static calculateRating() {
		//ocijeniti usluge, pa racunati srednju vrijednost ocjena i printati je na pocetku uz ime Radnje
		 * kroz hashmap proci i uzeti sve rating i izracunati
	} */
		
		
		// Welcome
		System.out.println("Welcome to our online shop! ");
		System.out.println("Our average rating: ");
		 //TODO rating
		
		menuWelcome();
		
				
		//item files
		// SignUp
		//Login 
			//if Admin meni 
				
			
			//user meni
				
		
				// "go to shop" meni
					
		
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
	
	public static void menuWelcome(){
		
		while(true) {
			
			System.out.println("Choose an option: ");
			System.out.println("1. LogIn");
			System.out.println("2. SignUp");
			System.out.println("3. Exit");
		

            try {
                int opcija = input.nextInt();
                int brr=0; 

                switch(opcija) {
                case 1: 
                    //
                    break;
                case 2:
                    //
                    break;
                case 3: 
                	brr=1;
                    //
                    break;              
                }
                
                if(brr==1) {
                    //pohraniUFile();
                    break;
                }
                
            } catch(InputMismatchException e) {
                input.nextLine();
                System.out.println("Invalid input. Try again.");
                System.out.println();
                menuWelcome();
            }

        }
        System.out.println("Application is closed successfully.");

    }
	
	
	public static void menuAdmin(){

	    while(true) {

	        System.out.println("Choose an option: ");
	        System.out.println("1. Add New Item");
	        System.out.println("2. Remove a User");
	        System.out.println("3. Buy");
	        System.out.println("4. Exit");

	        try {
	            int opcija = input.nextInt();
	            int brr=0; 

	            switch(opcija) {
	            case 1: 
	                //
	                break;
	            case 2:
	                //
	                break;
	            case 3:
	                //
	                break;
	            case 4:
	                brr=1;
	                //
	                break;

	            }

	            if(brr==1) {
	                //pohraniUFile();
	                break;
	            }

	        } catch(InputMismatchException e) {
	            input.nextLine();
	            System.out.println("Invalid input. Try again.");
	            System.out.println();
	            menuAdmin();
	        }

	    }
	    System.out.println("Application is closed successfully.");

	}
	
	public static void menuUser(){
		
		while(true) {
			
			System.out.println("Choose an option: ");
			System.out.println("1. Go to Shop");
			System.out.println("2. BankAccount Options");
			System.out.println("3. Log Out");		

            try {
                int opcija = input.nextInt();
                int brr=0; 

                switch(opcija) {
                case 1: 
                    //
                    break;
                case 2:
                    //
                    break;
                case 3:
                	brr=1;
                    //
                    break;
                }
                
                if(brr==1) {
                    //pohraniUFile();
                    break;
                }
                
            } catch(InputMismatchException e) {
                input.nextLine();
                System.out.println("Invalid input. Try again.");
                System.out.println();
                menuWelcome();
            }

        }
        System.out.println("Application is closed successfully.");

    }
	
	
	public static void menuShop(){

        while(true) {

            System.out.println("Choose an option: ");
            System.out.println("1. Pants");
            System.out.println("2. Shirts");
            System.out.println("3. Sneakers");
            System.out.println("4. FormalShoes");
            System.out.println("5. Jewelry");
            System.out.println("6. End Shopping");
            System.out.println("7. Back"); //menuUser
            System.out.println("8. Exit"); // break;


            try {
                int opcija = input.nextInt();
                int brr=0; 

                switch(opcija) {
                case 1: 
                    //
                    break;
                case 2:
                    //
                    break;
                case 3:
                    //
                    break;
                case 4:
                    //
                    break;
                case 5: 
                    //
                    break;
                case 6:
                    //
                    break;
                case 7:
                    //
                    break;
                case 8:
                    brr=1;
                    //
                    break;
                }

                if(brr==1) {
                    //pohraniUFile();
                    break;
                }

            } catch(InputMismatchException e) {
                input.nextLine();
                System.out.println("Invalid input. Try again.");
                System.out.println();
                menuWelcome();
            }

        }
        System.out.println("Application is closed successfully.");

    }
	
}
