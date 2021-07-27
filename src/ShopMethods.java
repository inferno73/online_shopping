import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
//singleton class
class Singleton
{
    // static variable single_instance of type Singleton
   
  
    // variable of type String
    public String s;
  
    // private constructor restricted to this class itself
    
}
public class ShopMethods implements ShopInterface { 
	private static ShopMethods single_instance = null;
	static Scanner inputFile;

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
	//updated: parametar fileName added
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

	//TODO napraviti da radi za svaki file, parameters: ime file-a i mozda br, da znamo kad treba u novi red
	@Override
	public void printFromFile() {
		try {
			inputFile = new Scanner (Paths.get("item.txt")); 	// promijeniti file
			//System.out.println("Podaci sa file-a item.txt: ");
			int br = 0;
			while(inputFile.hasNext()) {
				//za lijep ispis
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
			System.out.println("Problemi sa file-om. Provjerite da li imate item.txt u paketu.");
		}
		
	}

	@Override
	public void saveFileToList() {
		try {
			inputFile = new Scanner (Paths.get("item.txt"));	// promijeniti file
		//pohrani podatke u listu
			while(inputFile.hasNext()) {
				//kreiraj objekte s tim podacima i upisuj u array listu		// promijeniti metode
				Item item = new Item();
				item.setBrojRacuna(inputFile.nextInt());
				item.setImeVlasnikaRacuna(inputFile.next());
				item.setIznosRacuna(Double.parseDouble(inputFile.next()));
				item.listaRacuna.add(item);
			}
			//inputFile.close();
		} catch(IOException e) {
			System.out.println("Problemi sa file-om. Provjerite da li imate item.txt u paketu.");
		}
		
	}

	@Override
	public void saveListToFile() {
		try {
			Path path = Paths.get("item.txt");	// promijeniti file
			BufferedWriter writer = Files.newBufferedWriter(path);
			
			for(Item item : Item.listaRacuna) {		// promijeniti metode i listu
				writer.write(item.getBrojRacuna()+" ");
				writer.write(item.getImeVlasnikaRacuna()+" ");
				writer.write(String.valueOf(item.getIznosRacuna()));
				writer.write("\n");
			}
			writer.close();
			
		} catch(IOException e) {
			System.out.println("IOException occurred. StackTrace: ");
			e.printStackTrace();
		}
		
	}


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
		printFromFile();
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
}
