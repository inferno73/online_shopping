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
				Pants.getList().add(pants);
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
			
			for(Pants pants : Pants.getList()) {	
				// type?
				writer.write("color: " + pants.getColor() + " ");
				if(pants.doesHaveBelt())
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

	
	
	
//TODO overloading za ove
/*
	@Override
	public void saveFileToList(String fileName, ArrayList<?> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveListToFile(String fileName, ArrayList<Pants> Pants.getList()) {
		// TODO Auto-generated method stub
		
	}
*/	
	

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
	
//MENUS
	@Override
	public void menuWelcome(){
		
		while(true) {
			
			System.out.println("Choose an option: ");
			System.out.println("1. LogIn");
			System.out.println("2. SignUp");
			System.out.println("3. Exit");
		

            try {
                int option = input.nextInt();
                int brr=0; 

                switch(option) {
                case 1: 
                    menuLogIn();
                    break;
                case 2:
                	menuSignUp();
                    break;
                case 3: 
                	brr=1;
                    break;              
                }
                
                if(brr==1) 
                    break;  
                
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
	public void menuLogIn() {
		try {
			while(true) {
				System.out.println("Input username: ");
				String username = input.next();
				
				System.out.println("Input password: ");
				String password = input.next();
				
				if(Validation.invalidLogin(username, password)) {
					System.out.println("Invalid login, username and password don't match. Try again.");
					System.out.println();
					
				}
				else {
					//check if admin --then goto adminMenu
					if(Admin.getInstance().getPassword().equals(password))
						menuAdmin();
					else
						menuUser();
				}
			}
			
		} catch(InputMismatchException e) {
            input.nextLine();
            System.out.println("Invalid input. Try again.");
            System.out.println();
            menuWelcome();
        }
	}
	
	@Override
	public void menuSignUp() {
		System.out.println("Please type in these information about yourself: ");
		try {
			String username, password;
			int accountNumber;
			while(true) {
				System.out.println("Username: ");
				 username = input.next();
				if(Validation.alreadyTakenUsername(username)) {
					System.out.println("This username is already taken, please enter a different one.");
					System.out.println();
					continue;
				} else 
					break;
			}
			while(true) {
					System.out.println("Password: ");
					password = input.next();
					if (Validation.alreadyTakenPassword(password)) {
						System.out.println("This password is already taken, please enter a different one.");
						System.out.println();
						continue;
					} else
						break;
			}
			while(true) {
				System.out.println("Bank account number: ");
				accountNumber = input.nextInt();
				
				if (Validation.alreadyTakenBankAccount(accountNumber)) { 
					System.out.println("This bank account is already taken, please enter a different one.");
					System.out.println();
					continue;
				} else
					break;
			}
			//as this user is just creating his/her account ---regularUser
			RegularUser newUser = new RegularUser(username, password, accountNumber);
			RegularUser.getList().add(newUser);
			
		} catch(InputMismatchException e) {
            input.nextLine();
            System.out.println("Invalid input. Try again.");
            System.out.println();
            menuWelcome();
        }
	}
	
	@Override
	public void menuAdmin(){

	    while(true) {

	        System.out.println("Choose an option: ");
	        System.out.println("1. Add New Item");
	        System.out.println("2. Remove a User");
	        System.out.println("3. Change your password");
	        System.out.println("4. Go to shop");
	        System.out.println("5. Exit");

	        try {
	            int option = input.nextInt();
	            int brr=0; 

	            switch(option) {
	            case 1: 
	            	System.out.println("Add New Item: ");
	            	menuAddNewItem();
	                break;
	            case 2:
	                System.out.println("Remove a User");
	                System.out.println();
	                System.out.println("Username: ");
	                String username = input.next();
					Admin.getInstance().removeAUser(username);
					System.out.println();
					menuAdmin();
	                break;
	            case 3:
	            	System.out.println("Change password");
	                System.out.println();
	                System.out.println("NewPassword: ");
	                String newPassword = input.next();
					Admin.getInstance().changePassword(newPassword);
					System.out.println();
					menuAdmin();
	                break;
	            case 4:
	                menuShop();
	                break;
	            case 5:
	            	brr=1;
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
                int option = input.nextInt();
                int brr=0; 

                switch(option) {
                case 1: 
                    menuShop();
                    break;
                case 2:            		
            		/*for (int i = 0; i < User.getList().size(); i++)
            		{
            			if(User.getList().get(i).getUsername() == username)
            			{
                			BankAccount.getList.get(i).getNumberofBankAccount(User.getList().get(i).getNumberOfBankAccount();).toString();
            			}
            		}*/
                    break;
                case 3:
                	brr=1;
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
            System.out.println("7. Back");
            System.out.println("8. Exit");


            try {
                int option = input.nextInt();
                int brr=0; 

                switch(option) {
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
                    menuEndShopping();
                    break;
                case 7:
                    menuUser();
                    break;
                case 8:
                    brr=1;
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
	public void menuRating(String password) {
		for(User user : User.getList()) {
			  if(user.getRate() !=0) {
					System.out.println("Do you want to rate our store? ");
	    			System.out.println("1. YES");
	    			System.out.println("2. NO");
	    			System.out.println();
	    			System.out.println("Choose an option");
	    			int option = input.nextInt();
	    			
	    			switch(option) {
	    			case 1:
	    				System.out.println("Rate our store with 1-5 stars");
	    				user.setRate(input.nextInt());
	    				break;
	    			case 2:
	    				break;
	    			}
				}
				break;
			}
	}
	
	public void menuEndShopping ()
	{
		 while(true) {

			 	System.out.println("End shopping?");
			 	System.out.println();
	            System.out.println("Choose an option: ");
	            System.out.println("1. Yas");
	            System.out.println("2. No");
	            
	            try {
	                int option = input.nextInt();
	                int brr=0; 

	                switch(option) {
	                case 1: 
	                	determineShippingInfo();
	                	//finishShoping(total)
						//menuMakeAPurchase();
	                    break;
	               
	                case 2:
	                    brr=1;
	                    menuShop();
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
	}
	
	public void menuMakeAPurchase (double total, String username)
	{
		while(true) {

		 	System.out.println("Do you want to make purchase?");
		 	System.out.println();
            System.out.println("Choose an option: ");
            System.out.println("1. Yas");
            System.out.println("2. No");
            
            try {
                int option = input.nextInt();
                int brr=0; 

                switch(option) {
                case 1: 
					System.out.println("Thank You!");
					countPurchases(username);
                    break;
               
                case 2:
                    brr=1;
                    menuShop();
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
	}
	
	public void menuAddNewItem(){

	    while(true) {

	        System.out.println("Choose an option: ");
	        System.out.println("1. Pants");
	        System.out.println("2. Shirt");
	        System.out.println("3. Formal Shoes");
	        System.out.println("4. Sneakers");
	        System.out.println("5. Jewerly");
	        System.out.println("6. Back");
	        System.out.println("7. Exit");

	        try {
	            int option = input.nextInt();
	            int brr=0; 

	            switch(option) {
	            case 1:
	            	System.out.println("Add Pants" );
	            	Pants pants = new Pants();
					
	            	System.out.println("Color: ");
					pants.setColor(input.next());
					
					int br=0;
					while(br==0)
					{
						System.out.println("Has Belt: ");
						System.out.println("(Input YAS or NO!)");
						String hasBelt = input.next();
						
					if(hasBelt.equals("YAS")) {
						pants.setHasBelt(true);
						br = 1;
					}
					else if (hasBelt.equals("NO")) {
						pants.setHasBelt(false);
						br = 1;
					}
					else {
						System.out.println("Invalid input. Try again.");
						br = 0;
					}
					}
					
					System.out.println("Length: ");
					pants.setLength(input.next());
					
					System.out.println("Material: ");
					pants.setMaterial(input.next());
					
					System.out.println("Size: ");
					pants.setSize(input.next());
					
					System.out.println("Price: ");
					pants.setPrice(input.nextDouble());
					
					//Pants.getList().add(pants);
	            	break;
	            	
	            case 2:
	            	System.out.println("Add Shirt" );
	            	Shirt shirt = new Shirt();
	            	
	            	System.out.println("Color: ");
					shirt.setColor(input.next());
					
					int br2=0;
					while(br2==0)
					{
						System.out.println("Has Buttons: ");
						System.out.println("(Input YAS or NO!)");
						String hasButtons = input.next();
						
					if(hasButtons.equals("YAS")) {
						shirt.setHasButtons(true);
						br2 = 1;
					}
					else if (hasButtons.equals("NO")) {
						shirt.setHasButtons(false);
						br2 = 1;
					}
					else {
						System.out.println("Invalid input. Try again.");
						br2 = 0;
					}
					}
					
					System.out.println("Sleeve length: ");
					shirt.setSleeveLength(input.next());
					
					System.out.println("Material: ");
					shirt.setMaterial(input.next());
					
					System.out.println("Size: ");
					shirt.setSize(input.next());
					
					System.out.println("Price: ");
					shirt.setPrice(input.nextDouble());
					
					//Shirt.list.add(shirt);
	            	break;
	            	
	            case 3: 
	            	System.out.println("Add Formal Shoes: ");
	            	
	            	FormalShoes formalshoes = new FormalShoes();
					
	            	System.out.println("Material: ");
					formalshoes.setMaterial(input.next());
					
					System.out.println("Price: ");
					formalshoes.setPrice(input.nextDouble());
					
					//FormalShoes.list.add(formalshoes);
	                break;
	                
	            case 4:
	                System.out.println("Add Sneakers: ");
	                
	                Sneakers sneakers = new Sneakers();
	                
	                System.out.println("Brand: ");
					sneakers.setBrand(input.next());
					
					int br3=0;
					while(br3==0)
					{
						System.out.println("For Sports: ");
						System.out.println("(Input YAS or NO!)");
						String forSports = input.next();
						
					if(forSports.equals("YAS")) {
						sneakers.setForSports(true);
						br3 = 1;
					}
					else if (forSports.equals("NO")) {
						sneakers.setForSports(false);
						br3 = 1;
					}
					else {
						System.out.println("Invalid input. Try again.");
						br3 = 0;
					}
					}
					
					System.out.println("Material: ");
					sneakers.setMaterial(input.next());
					
					System.out.println("Price: ");
					sneakers.setPrice(input.nextDouble());
					
					//Sneakers.list.add(sneakers);
	                break;
	                
	            case 5:
	            	System.out.println("Add Jewerly: ");
	            	
	            	Jewelry jewelry = new Jewelry();
	            	
	            	System.out.println("Material: ");
					jewelry.setMaterial(inputFile.next());
					
					System.out.println("Price: ");
					jewelry.setPrice(inputFile.nextDouble());
					
					//Jewelry.list.add(jewelry);
	                break;
	                
	            case 6:
	                menuAdmin();
	                break;
	                
	            case 7:
	            	brr=1;
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
	public double calculateTotal(double itemPrice, double previousTotal) {
		double total = previousTotal + itemPrice;
		return total;
	}

	@Override
	public void determineShippingInfo() {
		//trazi adresu
		//trazi drzavz na osnovu nje odredi shipping
		
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
	public double calculateRating() {
		double result=0, numberOfRatings=0, currentRating=0;
		
		for(int i=0; i<VIPUser.getList().size(); i++) {
			if(VIPUser.getList().get(i).getRate() !=0) {
				currentRating+=VIPUser.getList().get(i).getRate();
				numberOfRatings++;
			}
		}
		
		for(int i=0; i<RegularUser.getList().size(); i++) {
			if(RegularUser.getList().get(i).getRate() !=0) {
				currentRating+=RegularUser.getList().get(i).getRate();
				numberOfRatings++;
			}
		}
		
		result=currentRating/numberOfRatings;
		
		return result;
	}
	
	public void becomeVIPUser (String username)
	{
		VIPUser newVIPUser = new VIPUser ();
		
		for (int i = 0; i < User.getList().size(); i++){
			if(User.getList().get(i).getUsername() == username){
				if(User.getList().get(i).getNumberOfPurchases() >= 4){
					newVIPUser.setUsername(User.getList().get(i).getUsername());
					newVIPUser.setPassword(User.getList().get(i).getPassword());
					newVIPUser.setNumberOfBankAccount(User.getList().get(i).getNumberOfBankAccount());
					newVIPUser.setHasShipping(User.getList().get(i).getHasShipping());
					newVIPUser.setRate(User.getList().get(i).getRate());
					
					VIPUser.getVIPlist().add(newVIPUser);
				}
			}
		}
	}
	
	public void countPurchases (String username)
	{	
		for (int i = 0; i < User.getList().size(); i++){
			if(User.getList().get(i).getUsername() == username){
				User.getList().get(i).setNumberOfPurchases(User.getList().get(i).getNumberOfPurchases() + 1);
			}

		}
	}
		

	public void saveAllToFile() {
		
		saveToFilePants();
		
		saveToFileShirt();
		
		saveToFileJewelry();
		
		saveToFileSneakers();
		
		saveToFileFormalShoes();
	}
	//TODO dodati za usere metode overloadane
		
		public void saveAllToList() {
			saveToListPants();
			saveToListShirt();
			saveToListJewelry();
			saveToListSneakers();
			saveToListFormalShoes();
			saveToListRegularUser();
			saveToListVIPUser();
			saveToListAdmin();
		}

		@Override
		public void saveToListRegularUser() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void saveToFileRegularUser() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void saveToListVIPUser() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void saveToFileVIPUser() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void saveToListAdmin() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void saveToFileAdmin() {
			// TODO Auto-generated method stub
			
		}
		
		

}
