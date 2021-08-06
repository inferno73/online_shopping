
public class Item {
	
	private int id;
	private double price;
	private String material;
	
	Item(){
		
	}
	
	Item(int id, double price, String material){
		this.id = id;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
