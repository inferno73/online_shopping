import java.util.ArrayList;

public class Jewelry extends Item{
	
	static ArrayList<Jewelry> list = new ArrayList<>();
	private double grams;
	final double goldCoeff=58.22;
	final double silverCoeff=0.8;
	final double stainlessSteelCoeff=0.77;
	static int numberOf=0;

	Jewelry(){
		numberOf++;
	}
	
	Jewelry(int id, double price, String material, double grams){
		super(id, price, material);
		this.grams=grams;
		numberOf++;
	}
	
	public double calculatePrice(double grams, double coefficient) {
		
		double result=0;
		if(this.getMaterial()=="gold") {
			result=grams*this.goldCoeff;
		}
		else if(this.getMaterial()=="silver") {
			result=grams*this.silverCoeff;
		}
		else if(this.getMaterial()=="stainless steel") {
			result=grams*this.stainlessSteelCoeff;
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
		return "Jewelry [grams=" + grams + ", goldKoef=" + goldCoeff + ", silverKoef=" + silverCoeff
				+ ", stainlessSteelKoef=" + stainlessSteelCoeff + "]";
	}
	
	
}
