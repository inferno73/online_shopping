
public class Clothes extends Item{
	
	private String size;
	private String color;
	
	Clothes(){
		
	}
	
	Clothes(double price, String material, String size, String color){
		super(price, material);
		this.size=size;
		this.color=color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Clothes [size=" + size + ", color=" + color + "]";
	}
	
	
	
}
