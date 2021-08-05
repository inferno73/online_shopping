import java.util.ArrayList;

public class Pants extends Clothes{
	
	static ArrayList<Pants> list = new ArrayList<>();
	private static int numberOf=0;
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

	public boolean doesHaveBelt() {
		return hasBelt;
	}

	public void setHasBelt(boolean hasBelt) {
		this.hasBelt = hasBelt;
	}

	public static int getNumberOf() {
		return numberOf;
	}

	public static void setNumberOf(int numberOf) {
		Pants.numberOf = numberOf;
	}
	@Override
	public String toString() {
		return "Pants [length=" + length + ", hasBelt=" + hasBelt + "]";
	}
	
	
}
