public class Buyer extends User {
	private int bonus = 0; //pontoi agorwn
	private int bonusbefore;
	private enum buyerCategory {BRONZE,SILVER,GOLD} ;
	private buyerCategory bC;
	
	ShoppingCart MyCart = new ShoppingCart();
	
	private String senc; //string enum category
	
	public Buyer(String name,String email,int bonus) {
		this.name = name;
		this.email = email;
		this.bonus = bonus;
	}
	
	@Override
	public String toString(){
    	return (name + " " + email + " " + bonus);
	}
	public String getEmail() {
		return email;
	}
	public String getName() {
		return name;
	}
	public int getBonus() {
		return bonus;
	}
	
	public void setBonus(int bonus) {
		this.bonus=bonus;
	}
	public void awardBonus(double price,Buyer b1) {
		bonusbefore = b1.getBonus();
		bonus = (int)Math.round(price * 0.1); //stroggilopoishsh tou apotelesmatos ston pio kontino integer
		
		bonus =  bonus + bonusbefore;
		
		setBonus(bonus);

	}
	
	public String setbuyerCategory(int bonus) {
		if (bonus<100) {
			bC = buyerCategory.BRONZE;
			senc = bC.toString();
			return senc;
		}else if(bonus<200) {
			bC = buyerCategory.SILVER;	
			senc = bC.toString();
			return senc;
		}else {
			bC = buyerCategory.GOLD;
			senc = bC.toString();
			return senc;
		}
	}
	public Item getItembyPosition(int pos2) {
		return MyCart.getItembyPosition(pos2);

	}
	public void placeOrder(int stock,Item item) {
		MyCart.addItemOrdered(stock,item);
	}
	public void removeItemOrdered(Item item) {
		MyCart.removeItemOrdered(item);
	}
	public void updateOrderStock(int stock,Item item) {
		MyCart.changeItemOrderedQuantity(stock,item);
	}
	public void showCart() {
		MyCart.showCart();
	}
	public void clearCart() {
		MyCart.clearCart();
	}
	public void checkout(Buyer b1) {
		MyCart.checkout(b1);
	}
	public void calculateNet() {
		MyCart.calculateNet();
	}
	
}