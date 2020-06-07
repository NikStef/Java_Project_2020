
public class Item { //na doume simeiwseis
	private String name;
	private Double price;
	private String description;
	private int stock;
	private int id;
	
	private String OLA;

	public Item(String name, double price, String description, int stock, int id) {
		//super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.stock = stock;
		this.id = id;
	}
	public String getBasicInfo() {
		return (" Name:" + name + " \n" + " Price:"+ price + " \n" +" Description:"+ description + " \n" +" Stock:" + stock + " \n" +" Id:" + id +"\n");
	}
	public String getDetails() {
		return name; //dummy method
	}
	@Override
	public String toString(){
    	OLA = getBasicInfo() + " " + getDetails();
    	return OLA;
	}
	
	public int getId() {
		return id;
	}
	public double getPrice() {
		return price;
	}
	public String getName() {
		return name;
	}
	public int getItemStock() {
		return stock;
	}
	public void setItemStock(int newStock) {
		this.stock = newStock;
	}
	
}