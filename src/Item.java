
public class Item {
	
	private double price;
	private String material;
	
	Item(){
		
	}
	
	Item(double price, String material){
		this.price=price;
		this.material=material;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "Item [price=" + price + ", material=" + material + "]";
	}
	
	
	
}
