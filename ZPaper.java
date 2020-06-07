
public class ZPaper extends Item {
	private int pages;
	private int weight;
	
	public ZPaper(String name, double price, String description, int stock, int id, int pages, int weight) {
		super(name, price, description, stock, id);
		//this.name = name;
		//this.price = price;
		//this.description = description;
		//this.stock = stock;
		//this.id = id;
		this.pages = pages;
		this.weight = weight;
	}
	
	@Override
	public String getDetails() {
		return ("Pages:" + pages + " \n" +" Weight:"+ weight + "\n");
	}

	
}
