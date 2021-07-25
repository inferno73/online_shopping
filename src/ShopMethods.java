import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ShopMethods implements ShopInterface {
	static Scanner inputFile;

	@Override
	public void createFile() throws IOException {
		Path path = Paths.get("item.txt");
		
		if(!Files.exists(path)) {
			Files.createFile(path);
		}
		
	}

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
	public void saveToList() {
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
	public void saveToFile() {
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
			System.out.println("Problemi sa inputom/outputom.");
			e.getMessage();
		}
		
	} 
	
	
}
