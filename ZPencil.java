
public class ZPencil extends Item{
	 private double tipSize;
	 private String type; //H,B,HB
	
	 public ZPencil(String name, double price, String description, int stock, int id, double tipsize,String type) {
		super(name, price, description, stock, id);
		//this.name = name;
		//this.price = price;
		//this.description = description;
		//this.stock = stock;
		//this.id = id;
		this.tipSize = tipsize;
		this.type = type;
	}
	 @Override
		public String getDetails() {
			return ("Tipsize:" + tipSize + "\n" +" Type:"+ type+"\n");
		}

	
}
