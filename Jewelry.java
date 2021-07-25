import java.util.ArrayList;

public class Jewelry extends Item{
	
	static ArrayList<Jewelry> list = new ArrayList<>();
	private double grams;
	final double goldKoef=58.22;
	final double silverKoef=0.8;
	final double stainlessSteelKoef=0.77;
	static int numberOf=0;

	Jewelry(){
		numberOf++;
	}
	Jewelry(double price, String material, double grams){
		super(price, material);
		this.grams=grams;
		numberOf++;
	}
	
	public double calculatePrice(double grams, double koeficijent) {
		
		double result=0;
		if(this.getMaterial()=="gold") {
			result=grams*this.goldKoef;
		}
		else if(this.getMaterial()=="silver") {
			result=grams*this.silverKoef;
		}
		else if(this.getMaterial()=="stainless steel") {
			result=grams*this.stainlessSteelKoef;
		}
		
		return result;
	}
	public double getGrams() {
		return grams;
	}
	public void setGrams(double grams) {
		this.grams = grams;
	}
	@Override
	public String toString() {
		return "Jewelry [grams=" + grams + ", goldKoef=" + goldKoef + ", silverKoef=" + silverKoef
				+ ", stainlessSteelKoef=" + stainlessSteelKoef + "]";
	}
	
	
}
