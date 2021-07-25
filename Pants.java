import java.util.ArrayList;
import java.util.Arrays;

public class Pants extends Clothes{
	
	static ArrayList<Pants> list = new ArrayList<>();
	static int numberOf=0;
	static ArrayList<String> types = new ArrayList<String>(Arrays.asList("trapeze", "skinny", "straight", "baggy"));
	private String length;
	private boolean hasBelt;
	
	Pants(){
		numberOf++;
	}
	
	Pants(double price, String material, String size, String color, String length, boolean hasBelt){
		super(price, material, size, color);
		this.length=length;
		this.hasBelt=hasBelt;
		numberOf++;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public boolean isHasBelt() {
		return hasBelt;
	}

	public void setHasBelt(boolean hasBelt) {
		this.hasBelt = hasBelt;
	}

	@Override
	public String toString() {
		return "Pants [length=" + length + ", hasBelt=" + hasBelt + "]";
	}
	
	
}
