public class ZPen extends Item {
	private String color;
	private double tipSize;//se mm
 
 
	public ZPen(String name, double price, String description, int stock, int id, String color, double tipSize) {
		super(name, price, description, stock, id);
		//this.name = name;
		//this.price = price;
		//this.description = description;
		//this.stock = stock;
		//this.id = id;
		this.color = color;
		this.tipSize = tipSize;
		
	}
	
	@Override
	public String getDetails() {
		return ("Color:" + color + " \n" +" Tipsize:" + tipSize +"\n");
	}
	

}
