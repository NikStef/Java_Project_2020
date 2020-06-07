
public class ItemOrdered {
	
	private int quantity;
	Item Item;
	private int citems = 0 ;//counter pou metraei to kalathi
	
	
	public ItemOrdered(int quantity, Item item,int citems) {
		this.citems = citems;
		this.quantity = quantity;
		Item = item;
		if (Item.getItemStock()>quantity) { //tsekarei to stock poy exoyme me to stock poy theloyme
		Item.setItemStock(Item.getItemStock() - quantity); 
		}else {
			System.out.println("Doesn't have stock!");
		}
		
	}

	@Override
	public String toString(){
    	return (citems+".Item" +"\n--Quantiy:" + quantity + "-- \n" + Item.toString()+ " \n");
	}
	public Item getItem() {
		return Item;
	}
	public int getQuantity() {
		return quantity;
	}
	public int getCItems() {
		return citems;
	}
	public void setCItems(int newCItems) {
		this.citems = newCItems;
	}
	
	public void setQuantity(int newQuant) {
		this.quantity = newQuant;
	}
	
	
}
