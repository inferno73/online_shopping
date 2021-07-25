import java.util.ArrayList;

public class Sneakers extends Item{
	
	static ArrayList<Sneakers> list = new ArrayList<>();
	private String brand;
	private boolean forSports;
	static int numberOf=0;

	Sneakers(){
		numberOf++;
	}
	
	Sneakers(double price, String material, String brand, boolean forSports){
		super(price, material);
		this.brand=brand;
		this.forSports=forSports;
		numberOf++;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public boolean isForSports() {
		return forSports;
	}

	public void setForSports(boolean forSports) {
		this.forSports = forSports;
	}

	@Override
	public String toString() {
		return "Sneakers [brand=" + brand + ", forSports=" + forSports + "]";
	}
	
	
	
}
