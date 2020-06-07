
public class ZNotebook extends Item{
	private int sections;

	public ZNotebook(String name, double price, String description, int stock, int id,int sections) {
		super(name, price, description, stock, id);
		//this.name = name;
		//this.price = price;
		//this.description = description;
		//this.stock = stock;
		//this.id = id;
		this.sections = sections;	
	}
	
	@Override
	public String getDetails() {
		return ("Sections:" + sections + "\n");
	}
	

	

}
