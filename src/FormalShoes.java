import java.util.ArrayList;
import java.util.Arrays;

public class FormalShoes extends Item{
	
	static ArrayList<FormalShoes> list = new ArrayList<>();
	//static ArrayList<String> types = new ArrayList<String>(Arrays.asList("flat", "platform", "high heel"));
	static int numberOf=0;

	FormalShoes(){
		numberOf++;
	}
	
	FormalShoes(double price, String material){
		super(price, material);
		numberOf++;
	}
/*
	public static ArrayList<String> getTypes() {
		return types;
	}

	public static void setTypes(ArrayList<String> types) {
		FormalShoes.types = types;
	}
*/
	@Override
	public String toString() {
		return "FormalShoes []";
	}
	
	
}
