import java.util.ArrayList;

public class Shirt extends Clothes{
	
	static ArrayList<Shirt> list = new ArrayList<>();
	
	static int numberOf=0;
	private boolean hasButtons;
	private String sleeveLength;
	
	Shirt(){
		numberOf++;
	}
	
	Shirt(int id, double price, String material, String size, String color, String sleeveLength, boolean hasButtons){
		super(id, price, material, size, color);
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
