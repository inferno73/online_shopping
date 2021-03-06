import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;
//singleton class

public class ShopMethods implements ShopInterface { 
	private static ShopMethods single_instance = null;
	static Scanner inputFile;
	static Scanner input = new Scanner(System.in);

	private ShopMethods() {}
  
    // static method to create instance of Singleton class
    public static ShopMethods getInstance()
    {
        if (single_instance == null)
            single_instance = new ShopMethods();
  
        return single_instance;
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
        saveAllToFile();
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
						menuUser(username);
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
			double amount;
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
				{
					System.out.println("Enter amount of money: ");
					amount = input.nextDouble();
				}
					break;
			}
			//as this user is just creating his/her account ---regularUser
			RegularUser newUser = new RegularUser(username, password, accountNumber);
			RegularUser.getList().add(newUser);
			saveToFileUser();
			
			
			BankAccount newBankAccount = new BankAccount (accountNumber, amount);
			BankAccount.getList().add(newBankAccount);
			saveToFileBankAccount();
			
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
	        System.out.println("2. Go to shop");
	        System.out.println("3. Exit");

	        try {
	            int option = input.nextInt();
	            int brr=0; 

	            switch(option) {
	            case 1: 
	            	System.out.println("Add New Item: ");
	            	menuAddNewItem();
	                break;
	                
	            case 2:
	                menuShop("Admin"); 
	                break;
	                
	            case 3:
	            	brr=1;
	            	break;
	            }

	            if(brr==1) {
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
	    menuWelcome();

	}
	
	@Override
	public void menuUser(String username){
		
		while(true) {
			
			System.out.println("Choose an option: ");
			System.out.println("1. Go to Shop");
			System.out.println("2. Check bank account balance ");
			System.out.println("3. Add money on bank account: ");
			System.out.println("4. Log Out");		

            try {
                int option = input.nextInt();
                int brr=0; 

                switch(option) {
                case 1: 
                    menuShop(username);
                    break;
                case 2:            		
            		for (int i = 0; i < User.getList().size(); i++){
            			if(User.getList().get(i).getUsername().equals(username)){
                			for(int j = 0; j< BankAccount.getList().size(); j++){
                				if(BankAccount.getList().get(j).getNumberOfBankAccount() == User.getList().get(i).getNumberOfBankAccount())   
                					System.out.println("Amount: " + BankAccount.getList().get(j).getAmount());
                			}
            			}
            		}
            		break;	
                case 3:	
                	for (int i = 0; i < User.getList().size(); i++){
            			if(User.getList().get(i).getUsername().equals(username)){
                			for(int j = 0; j< BankAccount.getList().size(); j++){
                				if(BankAccount.getList().get(j).getNumberOfBankAccount() == User.getList().get(i).getNumberOfBankAccount()) {
                					System.out.println("Enter amount of money: ");
                					BankAccount.getList().get(j).setAmount(BankAccount.getList().get(j).getAmount() + input.nextDouble());
                				}	
                			}
            			}
            		}
            		break;
                case 4:
                	brr=1;
                    break;
                }
                
                if(brr==1) {
                    break;
                }  
            } catch(InputMismatchException e) {
                input.nextLine();
                System.out.println("Invalid input. Try again.");
                System.out.println();
                menuUser(username);
            }

        }
        System.out.println("Application is closed successfully.");
        menuWelcome();
    }
	
	@Override
	public void menuShop(String username){

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
                int itemNumber;
                double cost = 0;
                switch(option) {
                case 1: 
                	printFromFile("pants.txt");
                	System.out.println("Choose an item from the list by entering the correct number: ");
                	itemNumber = input.nextInt();
                	for(int i=0; i<Pants.list.size(); i++) {
                		if(Pants.list.get(i).getId()==itemNumber) {
                			cost += Pants.list.get(i).getPrice(); 
                			menuEndShopping(username, cost);
                		}
                	}
                    break;
                case 2:
                	printFromFile("shirt.txt");
                	System.out.println("Choose an item from the list by entering the correct number: ");
                	itemNumber = input.nextInt();
                	for(int i=0; i<Shirt.list.size(); i++) {
                		if(Shirt.list.get(i).getId()==itemNumber) {
                			cost += Shirt.list.get(i).getPrice(); 
                			menuEndShopping(username, cost);
                			}
                	}
                    break;
                case 3:
                	printFromFile("sneakers.txt");
                	System.out.println("Choose an item from the list by entering the correct number: ");
                	itemNumber = input.nextInt();
                	for(int i=0; i<Sneakers.list.size(); i++) {
                		if(Sneakers.list.get(i).getId()==itemNumber) {
                			cost += Sneakers.list.get(i).getPrice(); 
                			menuEndShopping(username, cost);
                		}
                	}
                    break;
                case 4:
                	printFromFile("formalshoes.txt");
                	System.out.println("Choose an item from the list by entering the correct number: ");
                	itemNumber = input.nextInt();
                	for(int i=0; i<FormalShoes.list.size(); i++) {
                		if(FormalShoes.list.get(i).getId()==itemNumber) {
                			cost += FormalShoes.list.get(i).getPrice(); 
                			menuEndShopping(username, cost);
                			}
                	}
                    break;
                case 5: 
                	printFromFile("jewelry.txt");
                	System.out.println("Choose an item from the list by entering the correct number: ");
                	itemNumber = input.nextInt();
                	
                	for(int i=0; i<Jewelry.list.size(); i++) {
                		if(Jewelry.list.get(i).getId()==itemNumber) {
                			cost += Jewelry.list.get(i).getPrice(); 
                			menuEndShopping(username, cost);
                		}
                	}
                    break;
                case 6:
                	menuEndShopping(username, cost);
                	break;
                case 7:
                    menuUser(username);
                    break;
                case 8:
                    brr=1;
                    break;
                }

                if(brr==1) {
                    break;
                }
            } catch(InputMismatchException e) {
                input.nextLine();
                System.out.println("Invalid input. Try again.");
                System.out.println();
                menuShop(username);
            }
        }
        System.out.println("Application is closed successfully.");
        menuWelcome();
    }
	
	@Override
	public void menuAddNewItem() {
		
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
					
	            	System.out.println("ID: ");
					pants.setId(input.nextInt());
					
	            	System.out.println("Color: ");
					pants.setColor(input.next());
					
					int br=0;
					while(br==0)
					{
						System.out.println("Has Belt: ");
						System.out.println("(Input Yes or No!)");
						String hasBelt = input.next();
						
						if(hasBelt.equals("Yes")) {
							pants.setHasBelt(true);
							br = 1;
						}
						else if (hasBelt.equals("No")) {
							pants.setHasBelt(false);
							br = 1;
						} else {
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
					
					Pants.list.add(pants);
					saveToFilePants();
	            	break;
	            	
	            case 2:
	            	System.out.println("Add Shirt" );
	            	Shirt shirt = new Shirt();
	            	
	            	System.out.println("ID: ");
					shirt.setId(input.nextInt());
	            	
	            	System.out.println("Color: ");
					shirt.setColor(input.next());
					
					int br2=0;
					while(br2==0)
					{
						System.out.println("Has Buttons: ");
						System.out.println("(Input Yes or No!)");
						String hasButtons = input.next();
						
						if(hasButtons.equals("Yes")) {
							shirt.setHasButtons(true);
							br2 = 1;
						}
						else if (hasButtons.equals("No")) {
							shirt.setHasButtons(false);
							br2 = 1;
						} else {
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
					
					Shirt.list.add(shirt);
					saveToFileShirt();
	            	break;
	            	
	            case 3: 
	            	System.out.println("Add Formal Shoes: ");
	            	
	            	FormalShoes formalshoes = new FormalShoes();
	            	
	            	System.out.println("ID: ");
					formalshoes.setId(input.nextInt());
					
	            	System.out.println("Material: ");
					formalshoes.setMaterial(input.next());
					
					System.out.println("Price: ");
					formalshoes.setPrice(input.nextDouble());
					
					FormalShoes.list.add(formalshoes);
					saveToFileFormalShoes();
	                break;
	                
	            case 4:
	                System.out.println("Add Sneakers: ");
	                
	                Sneakers sneakers = new Sneakers();
	                
	                System.out.println("ID: ");
					sneakers.setId(input.nextInt());
	                
	                System.out.println("Brand: ");
					sneakers.setBrand(input.next());
					
					int br3=0;
					while(br3==0)
					{
						System.out.println("For Sports: ");
						System.out.println("(Input Yes or No!)");
						String forSports = input.next();
							
						if(forSports.equals("Yes")) {
							sneakers.setForSports(true);
							br3 = 1;
						}
						else if (forSports.equals("No")) {
							sneakers.setForSports(false);
							br3 = 1;
						} else {
							System.out.println("Invalid input. Try again.");
							br3 = 0;
						}
					}
					
					System.out.println("Material: ");
					sneakers.setMaterial(input.next());
					
					System.out.println("Price: ");
					sneakers.setPrice(input.nextDouble());
					
					Sneakers.list.add(sneakers);
					saveToFileSneakers();
	                break;
	                
	            case 5:
	            	System.out.println("Add Jewelry: ");
	            	
	            	Jewelry jewelry = new Jewelry();
	            	
	            	System.out.println("ID: ");
					jewelry.setId(input.nextInt());
	            	
	            	System.out.println("Material: ");
					jewelry.setMaterial(inputFile.next());
					
					System.out.println("Price: ");
					jewelry.setPrice(inputFile.nextDouble());
					
					Jewelry.list.add(jewelry);
					saveToFileJewelry();
	                break;
	                
	            case 6:
	                menuAdmin();
	                break;
	                
	            case 7:
	            	brr=1;
	            	break;
	            }

	            if(brr==1) {
	                break;
	            }

	        } catch(InputMismatchException e) {
	            input.nextLine();
	            System.out.println("Invalid input. Try again.");
	            System.out.println();
	            menuAddNewItem();
	        }

	    }
	    System.out.println("Application is closed successfully.");
	    menuWelcome();
	}
	
	@Override
	public void menuEndShopping (String username, double cost) {
		
		while(true) {

           System.out.println("End shopping?");
           System.out.println();
           System.out.println("Choose an option: ");
           System.out.println("1. Yes");
           System.out.println("2. No");

           try {
               int option = input.nextInt();
               int brr=0; 
               
               VIPUser vipUser = new VIPUser();
               RegularUser regularUser = new RegularUser();
               
               switch(option) {
               case 1: 
            	   System.out.println("Choose your country: ");
	           		System.out.println("1. Bosnia and Herzegovina");
	           		System.out.println("2. Other");
	           		int country = input.nextInt();
	           		int shipping = 0;
	           		
	           		if(country == 1)
	           			shipping = 5;
	           		else if (country == 2)
	           			shipping = 20;
	           		else
	           		{
	           			System.out.println("Invalid input. Try again.");
	           			menuEndShopping(username, cost);
	           		}

                   while(true) {
                	   
	                   System.out.println("Enter Number of BankAccount: ");
	                   int currentNumberOfBankAccount =  input.nextInt();
	                   
                	   if(Validation.validNumberOfBankAccount(username, currentNumberOfBankAccount))
                       {
                       	for(int i = 0; i < User.getList().size(); i++)
                        {  
                           	if(User.getList().get(i).getUsername().equals(username)){
                           		
                           		if(username.equals("Admin"))
                           		{
                           			Admin.getInstance().finishShopping(cost, currentNumberOfBankAccount, shipping);
                           		}
                           		else
                           		{
                           			for(int j = 0; j < VIPUser.getVIPlist().size(); j++ ) {
	                           			if(VIPUser.getVIPlist().get(i).getUsername().equals(User.getList().get(i).getUsername())) {
	                           				vipUser.finishShopping(cost, currentNumberOfBankAccount, shipping);
	                           			}
	                           		}
	                           		regularUser.finishShopping(cost, currentNumberOfBankAccount, shipping);
                           		}
                           		
                           	}
                        }
                       	countPurchases(username);
                       	becomeVIPUser(username);
                       	
                       } else {
                    	   System.out.println("Invalid number of bank account. Please enter again: ");
                       }
                	   break;
                   }
                   
                   menuWelcome();
                   break;
                   
               case 2:
                   brr=1;
                   menuShop(username);
                   break;
               }

               if(brr==1) {
                   break;
               }

           } catch(InputMismatchException e) {
               input.nextLine();
               System.out.println("Invalid input. Try again.");
               System.out.println();
               menuEndShopping(username, cost);
           }

       }
	}


	@Override
	public double calculateTotal(double cost, int shipping) {
		double total = cost + shipping;
		return total;
	}
	
	@Override
	public void countPurchases (String username)
	{	
		for (int i = 0; i < User.getList().size(); i++){
			if(User.getList().get(i).getUsername() == username)
				User.getList().get(i).setNumberOfPurchases(User.getList().get(i).getNumberOfPurchases() + 1);
		}
	}
	
	@Override
	public void becomeVIPUser (String username) {
		VIPUser newVIPUser = new VIPUser ();
		
		for (int i = 0; i < User.getList().size(); i++){
			if(User.getList().get(i).getUsername() == username){
				if(User.getList().get(i).getNumberOfPurchases() >= 4){
					newVIPUser.setUsername(User.getList().get(i).getUsername());
					newVIPUser.setPassword(User.getList().get(i).getPassword());
					newVIPUser.setNumberOfBankAccount(User.getList().get(i).getNumberOfBankAccount());
					newVIPUser.setHasShipping(User.getList().get(i).getHasShipping());
					
					VIPUser.getVIPlist().add(newVIPUser);
					saveToFileVIPUser();
				}
			}
		}
	}

		
	@Override
	public void giveAReceipt(double cost, int shipping) {
		System.out.println("----------------------------------");
		System.out.println("Shipping: " + shipping);
		System.out.println("Cost: "+ cost);
		System.out.println();
		System.out.println("TOTAL: " + calculateTotal(cost, shipping) + " $" );
		System.out.println("----------------------------------");
	}	
	
//FILES-LISTS
    
	@Override
	public void createFile(String fileName) {
		try {
			Path path = Paths.get(fileName);
			
			if(!Files.exists(path)) {
				Files.createFile(path);
			}
		} catch (IOException exception){
			System.out.println("IOException occurred. StackTrace: ");
			exception.printStackTrace();
		}
	}

	@Override
	public void printFromFile(String fileName) {
		try {
			inputFile = new Scanner (Paths.get(fileName)); 
			
			while(inputFile.hasNext()) {
				System.out.println(inputFile.next()+" ");
					
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
				pants.setId(inputFile.nextInt());
				pants.setColor(inputFile.next());
				pants.setHasBelt(Boolean.parseBoolean(inputFile.next()));
				pants.setLength(inputFile.next());
				pants.setMaterial(inputFile.next());
				pants.setSize(inputFile.next());
				pants.setPrice(Double.parseDouble(inputFile.next()));
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
            	writer.write(pants.getId() + " ");
                writer.write(pants.getColor() + " ");
                if(pants.doesHaveBelt())
                    writer.write("has ");
                else
                    writer.write("hasn't ");
                writer.write(pants.getLength() + " ");
                writer.write(pants.getMaterial() + " ");
                writer.write(pants.getSize() + " ");
                writer.write(String.valueOf(pants.getPrice()) + " ");
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
				shirt.setId(inputFile.nextInt());
				shirt.setColor(inputFile.next());
				shirt.setHasButtons(Boolean.parseBoolean(inputFile.next())); 
				shirt.setSleeveLength(inputFile.next());
				shirt.setMaterial(inputFile.next());
				shirt.setSize(inputFile.next());
				shirt.setPrice(Double.parseDouble(inputFile.next()));
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
            	writer.write(shirt.getId() + " ");
                writer.write(shirt.getColor() + " ");
                if(shirt.isHasButtons())
                    writer.write("has ");
                else
                    writer.write("hasn't ");
                writer.write(shirt.getSleeveLength() + " ");
                writer.write(shirt.getMaterial() + " ");
                writer.write(shirt.getSize() + " ");
                writer.write(String.valueOf(shirt.getPrice()) + " ");
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
				jewelry.setId(inputFile.nextInt());
				jewelry.setMaterial(inputFile.next());
				jewelry.setPrice(Double.parseDouble(inputFile.next()));
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
            	writer.write(jewelry.getId() + " ");
                writer.write(jewelry.getMaterial() + " ");
                writer.write(String.valueOf(jewelry.getPrice()) + " ");
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
				sneakers.setId(inputFile.nextInt());
				sneakers.setBrand(inputFile.next());
				sneakers.setForSports(Boolean.parseBoolean(inputFile.next()));
				sneakers.setMaterial(inputFile.next());
				sneakers.setPrice(Double.parseDouble(inputFile.next()));
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
            	writer.write(sneakers.getId() + " ");
            	writer.write(sneakers.getBrand() + " ");
                if(sneakers.isForSports())
                    writer.write("is");
                else
                    writer.write("isn't");
                writer.write(sneakers.getMaterial() + " ");
                writer.write(String.valueOf(sneakers.getPrice()) + " ");
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
			inputFile = new Scanner (Paths.get("formal_shoes.txt"));	
		
			while(inputFile.hasNext()) {	
				FormalShoes formalshoes = new FormalShoes();
				formalshoes.setId(inputFile.nextInt());
				formalshoes.setMaterial(inputFile.next());
				formalshoes.setPrice(Double.parseDouble(inputFile.next()));
				FormalShoes.list.add(formalshoes);
			}
			
		} catch(IOException e) {
			System.out.println("File error.");
		}
	}

	@Override
    public void saveToFileFormalShoes() {
        try {
            Path path = Paths.get("formal_shoes.txt");
            BufferedWriter writer = Files.newBufferedWriter(path);

            for(FormalShoes formalshoes : FormalShoes.list) {
            	writer.write(formalshoes.getId() + " ");
                writer.write(formalshoes.getMaterial() + " ");
                writer.write(String.valueOf(formalshoes.getPrice()) + " ");
                writer.write("\n");
            }
            writer.close();

        } catch(IOException e) {
            System.out.println("Input/output error.");
            e.getMessage();
        }
    }

	@Override
	public void saveToListUser() {
		try {
			inputFile = new Scanner (Paths.get("user.txt"));	
		
			while(inputFile.hasNext()) {	
				User user = new RegularUser();
				
				user.setUsername(inputFile.next());
				user.setPassword(inputFile.next());
				user.setNumberOfBankAccount(inputFile.nextInt());
				user.setHasShipping(Boolean.parseBoolean(inputFile.next()));
				user.setNumberOfPurchases(inputFile.nextInt());
				
				
				User.getList().add(user);
			}
			
		} catch(IOException e) {
			System.out.println("File error.");
		}
	}

	@Override
	public void saveToFileUser() {
		try {
			Path path = Paths.get("user.txt");	
			BufferedWriter writer = Files.newBufferedWriter(path);
			
			for(User user : User.getList()) {	
				writer.write(user.getUsername() + " " + user.getPassword() + " " + user.getNumberOfBankAccount() + " " 
				 + user.getHasShipping() + " " + user.getNumberOfPurchases()   );
				writer.write("\n");
			}
			writer.close();
			
		} catch(IOException e) {
			System.out.println("Input/output error.");
			e.getMessage();
		}
	}
	
	@Override
	public void saveToListVIPUser() {
		try {
			inputFile = new Scanner (Paths.get("vip_user.txt"));	
		
			while(inputFile.hasNext()) {	
				VIPUser vipUser = new VIPUser();
				vipUser.setUsername(inputFile.next());
				vipUser.setPassword(inputFile.next());
				vipUser.setNumberOfBankAccount(inputFile.nextInt());
				vipUser.setHasShipping(Boolean.parseBoolean(inputFile.next()));
				
				User.getList().add(vipUser);
			}
			
		} catch(IOException e) {
			System.out.println("File error.");
		}
	}

	@Override
	public void saveToFileVIPUser() {
		try {
			Path path = Paths.get("vip_user.txt");	
			BufferedWriter writer = Files.newBufferedWriter(path);
			
			for(VIPUser vipUser : VIPUser.getVIPlist()) {	
				writer.write(vipUser.getUsername() + " " + vipUser.getPassword() + " " + vipUser.getNumberOfBankAccount() + " " 
						+ vipUser.getHasShipping() );
				writer.write("\n");
			}
			writer.close();
			
		} catch(IOException e) {
			System.out.println("Input/output error.");
			e.getMessage();
		}
	}
	
	@Override
	public void saveToListBankAccount() {
		try {
			inputFile = new Scanner (Paths.get("bank_account.txt"));	
		
			while(inputFile.hasNext()) {	
				BankAccount bankAccount = new BankAccount();
				
				bankAccount.setNumberOfBankAccount(inputFile.nextInt());
				bankAccount.setAmount(Double.parseDouble(inputFile.next()));
				
				BankAccount.getList().add(bankAccount);
			}
			
		} catch(IOException e) {
			System.out.println("File error.");
		}
		
	}

	@Override
	public void saveToFileBankAccount() {
		try {
			Path path = Paths.get("bank_account.txt");	
			BufferedWriter writer = Files.newBufferedWriter(path);
			
			for(BankAccount bankAccount : BankAccount.getList()) {	
				writer.write(bankAccount.getNumberOfBankAccount() + " " + bankAccount.getAmount());
				writer.write("\n");
			}
			writer.close();
			
		} catch(IOException e) {
			System.out.println("Input/output error.");
			e.getMessage();
		}
	}

	@Override
	public void saveAllToFile() {
		saveToFilePants();
		saveToFileShirt();
		saveToFileJewelry();
		saveToFileSneakers();
		saveToFileFormalShoes();
		saveToFileUser();
		saveToFileVIPUser();
		saveToFileBankAccount();
	}
	
	@Override
	public void saveAllToList() {
		saveToListPants();
		saveToListShirt();
		saveToListJewelry();
		saveToListSneakers();
		saveToListFormalShoes();
		saveToListUser();
		saveToListVIPUser();
		saveToListBankAccount();
	}

	
}
