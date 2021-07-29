import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
//singleton class

public class ShopMethods implements ShopInterface { 
	private static ShopMethods single_instance = null;
	static Scanner inputFile;
	static Scanner input;

	private ShopMethods()
    {
  
    }
  
    // static method to create instance of Singleton class
    public static ShopMethods getInstance()
    {
        if (single_instance == null)
            single_instance = new ShopMethods();
  
        return single_instance;
    }
	
    
    
	@Override
	public void createFile(String fileName) {
		try {
			Path path = Paths.get(fileName);
			
			if(!Files.exists(path)) {
				Files.createFile(path);
			}
		}catch (IOException exception){
			System.out.println("IOException occurred. StackTrace: ");
			exception.printStackTrace();
		}
	
	}

	@Override
	public void printFromFile(String fileName) {
		try {
			inputFile = new Scanner (Paths.get(fileName)); 
			
			int br = 0;
			while(inputFile.hasNext()) {
				System.out.print(inputFile.next()+" ");
				br++;
				if(br%3==0) {
					System.out.println();
					br=0;
				}
			}
			
			System.out.println();
			System.out.println();
			
		} catch(IOException e) {
			System.out.println("File error.");
		}
		
	}

	@Override
	public void saveToListPants() {
		try {
			inputFile = new Scanner (Paths.get("pants.txt"));	
		
			while(inputFile.hasNext()) {	
				Pants pants = new Pants();
				// type?
				pants.setColor(inputFile.next());
				pants.setHasBelt(inputFile.nextBoolean()); 
				pants.setLength(inputFile.next());
				pants.setMaterial(inputFile.next());
				pants.setSize(inputFile.next());
				pants.setPrice(inputFile.nextDouble());
				Pants.list.add(pants);
			}
			
		} catch(IOException e) {
			System.out.println("File error.");
		}
	}

	@Override
	public void saveToFilePants() {
		try {
			Path path = Paths.get("pants.txt");	
			BufferedWriter writer = Files.newBufferedWriter(path);
			
			for(Pants pants : Pants.list) {	
				// type?
				writer.write("color: " + pants.getColor() + " ");
				if(pants.isHasBelt())
					writer.write("has belt");
				else
					writer.write("doesn't have belt");
				writer.write("length: " + pants.getLength() + " ");
				writer.write("material: " + pants.getMaterial() + " ");
				writer.write("size: " + pants.getSize() + " ");
				writer.write("price: " + pants.getPrice() + " ");
				writer.write("\n");
			}
			writer.close();
			
		} catch(IOException e) {
			System.out.println("Input/output error.");
			e.getMessage();
		}
	}

	@Override
	public void saveToListShirt() {
		try {
			inputFile = new Scanner (Paths.get("shirt.txt"));	
		
			while(inputFile.hasNext()) {	
				Shirt shirt = new Shirt();
				// type?
				shirt.setColor(inputFile.next());
				shirt.setHasButtons(inputFile.nextBoolean()); 
				shirt.setSleeveLength(inputFile.next());
				shirt.setMaterial(inputFile.next());
				shirt.setSize(inputFile.next());
				shirt.setPrice(inputFile.nextDouble());
				Shirt.list.add(shirt);
			}
			
		} catch(IOException e) {
			System.out.println("File error.");
		}
	}

	@Override
	public void saveToFileShirt() {
		try {
			Path path = Paths.get("shirt.txt");	
			BufferedWriter writer = Files.newBufferedWriter(path);
			
			for(Shirt shirt : Shirt.list) {	
				// type?
				writer.write("color: " + shirt.getColor() + " ");
				if(shirt.isHasButtons())
					writer.write("has belt");
				else
					writer.write("doesn't have belt");
				writer.write("length: " + shirt.getSleeveLength() + " ");
				writer.write("material: " + shirt.getMaterial() + " ");
				writer.write("size: " + shirt.getSize() + " ");
				writer.write("price: " + shirt.getPrice() + " ");
				writer.write("\n");
			}
			writer.close();
			
		} catch(IOException e) {
			System.out.println("Input/output error.");
			e.getMessage();
		}		
	}

	@Override
	public void saveToListJewelry() {
		try {
			inputFile = new Scanner (Paths.get("jewelry.txt"));	
		
			while(inputFile.hasNext()) {	
				Jewelry jewelry = new Jewelry();
				jewelry.setMaterial(inputFile.next());
				jewelry.setPrice(inputFile.nextDouble());
				Jewelry.list.add(jewelry);
			}
			
		} catch(IOException e) {
			System.out.println("File error.");
		}
	}

	@Override
	public void saveToFileJewelry() {
		try {
			Path path = Paths.get("jewelry.txt");	
			BufferedWriter writer = Files.newBufferedWriter(path);
			
			for(Jewelry jewelry : Jewelry.list) {	
				writer.write("material: " + jewelry.getMaterial() + " ");
				writer.write("price: " + jewelry.getPrice() + " ");
				writer.write("\n");
			}
			writer.close();
			
		} catch(IOException e) {
			System.out.println("Input/output error.");
			e.getMessage();
		}
	}

	@Override
	public void saveToListSneakers() {
		try {
			inputFile = new Scanner (Paths.get("sneakers.txt"));	
		
			while(inputFile.hasNext()) {	
				Sneakers sneakers = new Sneakers();
				sneakers.setBrand(inputFile.next());
				sneakers.setForSports(inputFile.nextBoolean());
				sneakers.setMaterial(inputFile.next());
				sneakers.setPrice(inputFile.nextDouble());
				Sneakers.list.add(sneakers);
			}
			
		} catch(IOException e) {
			System.out.println("File error.");
		}
	}

	@Override
	public void saveToFileSneakers() {
		try {
			Path path = Paths.get("sneakers.txt");	
			BufferedWriter writer = Files.newBufferedWriter(path);
			
			for(Sneakers sneakers : Sneakers.list) {	
				writer.write("brand: " + sneakers.getBrand() + " ");
				if(sneakers.isForSports())
					writer.write("is for sports");
				else
					writer.write("isn't for sports");
				writer.write("material: " + sneakers.getMaterial() + " ");
				//writer.write("size: " + sneakers.getSize() + " ");
				writer.write("price: " + sneakers.getPrice() + " ");
				writer.write("\n");
			}
			writer.close();
			
		} catch(IOException e) {

			System.out.println("Input/output error.");
			e.getMessage();

			System.out.println("IOException occurred. StackTrace: ");
			e.printStackTrace();
		}
	}

	@Override
	public void saveToListFormalShoes() {
		try {
			inputFile = new Scanner (Paths.get("formalshoes.txt"));	
		
			while(inputFile.hasNext()) {	
				FormalShoes formalshoes = new FormalShoes();
				// type?
				formalshoes.setMaterial(inputFile.next());
				formalshoes.setPrice(inputFile.nextDouble());
				FormalShoes.list.add(formalshoes);
			}
			
		} catch(IOException e) {
			System.out.println("File error.");
		}
	}

	@Override
	public void saveToFileFormalShoes() {
		try {
			Path path = Paths.get("jewelry.txt");	
			BufferedWriter writer = Files.newBufferedWriter(path);
			
			for(FormalShoes formalshoes : FormalShoes.list) {	
				writer.write("material: " + formalshoes.getMaterial() + " ");
				writer.write("price: " + formalshoes.getPrice() + " ");
				writer.write("\n");
			}
			writer.close();
			
		} catch(IOException e) {
			System.out.println("Input/output error.");
			e.getMessage();
		}
	}
	
	
	
	

	@Override
	public void saveFileToList(String fileName, ArrayList<Object> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveListToFile(String fileName, ArrayList<Object> list) {
		// TODO Auto-generated method stub
		
	}
	
	//TODO napraviti da radi za svaki file, parameters: ime file-a i mozda br, da znamo kad treba u novi red

		@Override
		public void writeToReceipt(String itemDetails) {	//params ce biti item.toString
			createFile("receipt.txt");
			Path path = Paths.get("receipt.txt");
			try {
				BufferedWriter writer = Files.newBufferedWriter(path);
				writer.write(itemDetails);
				writer.write("\n");
			} catch (IOException e) {
				System.out.println("IOException occurred. StackTrace: ");
				e.printStackTrace();
			}
			
		}
		
		@Override
		public double calculateTotal(double itemPrice, double previousTotal) {
			double total = previousTotal + itemPrice;
			return total;
		}

		@Override
		public void giveAReceipt(double total) {
			//sysout all from receipt file -TODO dodati parametre u printFromFile()
			printFromFile("receipt.txt");
			System.out.println("----------------------------------");
			//delivery address, shipping
			//total
			System.out.println("TOTAL: --------------- " + " $"+ total );
			
		}

		@Override
		public void determineShippingInfo() {
			//trazi adresu
			//trazi drzavz na osnovu nje odredi shipping
			
		}
		
//MENUS
		@Override
		public void menuWelcome(){
			
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
	                    menuLogIn();
	                    break;
	                case 2:
	                	menuSignUp();
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
		
		@Override
		public void menuAdmin(){

		    while(true) {

		        System.out.println("Choose an option: ");
		        System.out.println("1. Add New Item");
		        System.out.println("2. Remove a User");
		        System.out.println("3. Change password");
		        System.out.println("4. Buy");
		        System.out.println("5. Exit");

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
		
		@Override
		public void menuUser(){
			
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
		
		public void menuShop(){

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
	                	//method.printFromFile("pants.txt");
	                    break;
	                case 2:
	                    //
	                	//method.printFromFile("shirt.txt");
	                    break;
	                case 3:
	                    //
	                	//method.printFromFile("sneakers.txt");
	                    break;
	                case 4:
	                    //
	                	//method.printFromFile("formalshoes.txt");
	                    break;
	                case 5: 
	                    //
	                	//method.printFromFile("jewelry.txt");
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
		
		@Override
		public void menuSignUp() {
			System.out.println("Please input these information about yourself: ");
			
			try {
			System.out.println("Username: ");
			String username = input.next();
			if(Validation.alreadyTakenUsername(username)) {
				System.out.println("");
				menuWelcome();
			}
			else {
				System.out.println("Password: ");
			String password = input.next();
			
			System.out.println("Bank account number: ");
			int accountNumber = input.nextInt();
			
			//as this user is just creating his/her account ---regularUser
			RegularUser newUser = new RegularUser(username, password, accountNumber);
			RegularUser.getList().add(newUser);
			}
			
			
			 }
			catch(InputMismatchException e) {
	            input.nextLine();
	            System.out.println("Invalid input. Try again.");
	            System.out.println();
	            menuWelcome();
	        }
		}
		
		@Override
		public void menuLogIn() {
			try {
				System.out.println("Input username:");
				String username = input.next();
				
				System.out.println("Input password: ");
				String password = input.next();
				
				if(Validation.notValidLogin(username, password)) {
					System.out.println("");
					menuWelcome();
				}
				else {
					menuUser();
				}
			} catch(InputMismatchException e) {
	            input.nextLine();
	            System.out.println("Invalid input. Try again.");
	            System.out.println();
	            menuWelcome();
	        }
		}
		
		@Override
		public void menuRating() {
			//TODO uvrstiti liste iz regularUser i VIPuser
			//provjeriti da li je vec ocijnio
			    for(int i=0; i<User.list.size(); i++) {
			    	if(User.list.get(i).getUsername.equals(username)) {
			    		if(User.list.get(i).getRate != 0) {
			    			
			    			//ako nije, pitati da li zeli da ocijeni
			    			
			    			System.out.println("Do you want to rate our store? ");
			    			System.out.println("1. YES");
			    			System.out.println("2. NO");
			    			System.out.println("Choose an option");
			    			int option = input.nextInt();
			    			switch(option) {
			    			//ako zeli, unijeti i spremiti ocjenu
			    			case 1:
			    				System.out.println("Rate our store with 1-5 stars");
			    				User.list.get(i).setRate(input.nextInt());
			    				break;
			    			case 2:
			    				break;
			    			}
			    		}
			    		break;
			    	}
			    }	
		}
		
		//TODO koristiti liste vipUser i regularUser
		public double calculateRating() {
			double result=0, numberOfRatings=0, currentRating=0; 
			for(int i=0; i<VIPUser.list.size(); i++) {
				if(VIPUser.list.get(i).getRate !=0) {
					currentRating+=VIPUser.list.get(i).getRate;
					numberOfRatings++;
				}
			}
			
			result=currentRating/numberOfRatings;
			return result;
		}

}
