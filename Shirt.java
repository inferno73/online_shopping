import java.util.ArrayList;
import java.util.Arrays;

public class Shirt extends Clothes{
	
	static ArrayList<Shirt> list = new ArrayList<>();
	static ArrayList<String> types = new ArrayList<String>(Arrays.asList("pullover", "blouse", "T-shirt", "shirt", "hoodie", "crop top"));
	static int numberOf=0;
	private boolean hasButtons;
	private String sleeveLength;
	
	Shirt(){
		numberOf++;
	}
	
	Shirt(double price, String material, String size, String color, String sleeveLength, boolean hasButtons){
		super(price, material, size, color);
		this.sleeveLength=sleeveLength;
		this.hasButtons=hasButtons;
		numberOf++;
	}

	public boolean isHasButtons() {
		return hasButtons;
	}

	public void setHasButtons(boolean hasButtons) {
		this.hasButtons = hasButtons;
	}

	public String getSleeveLength() {
		return sleeveLength;
	}

	public void setSleeveLength(String sleeveLength) {
		this.sleeveLength = sleeveLength;
	}

	@Override
	public String toString() {
		return "Shirt [hasButtons=" + hasButtons + ", sleeveLength=" + sleeveLength + "]";
	}
	
	
	
}
