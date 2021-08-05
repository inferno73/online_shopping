import java.util.ArrayList;

public class FormalShoes extends Item{
	
	static ArrayList<FormalShoes> list = new ArrayList<>();
	static int numberOf=0;

	FormalShoes(){
		numberOf++;
	}
	
	FormalShoes(double price, String material){
		super(price, material);
		numberOf++;
	}

	@Override
	public String toString() {
		return "FormalShoes []";
	}
	
	
}
