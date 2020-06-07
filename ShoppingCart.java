import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {
	private String sss; //string gia thn kathgoria toy buyer
	private int counter=0;
	private int position=-1;
	private int souz = 0;//megethos array
	private double price = 0;//synoliko price
	private double shipping=0;
	private int citems=0; //counter poy metraei to kalathi
	
	List orderList = new ArrayList();
	
	
	
	public int  sSearchAndDestroy(int quantity,Item item) { //allazei to stock toy antikeimenoy kai to stock ths paraggelias
		if (orderList.size()>0) {
			Object[] itenz = orderList.toArray(); 
			for (int i = 0; i < itenz.length; i++) {
				ItemOrdered pc = (ItemOrdered) itenz[i];
				if( pc.getItem() == item) {
					item.setItemStock(item.getItemStock()-quantity);
					pc.setQuantity(pc.getQuantity()+quantity);
					counter=1; //apodeiksh oti eginan allages
				}
			}
		}
		return counter;
	}
	public int sSearchAndDestroy(Item item) { //gurnaei thn thesh toy Item pou psaxnoume
		if (orderList.size()>0) {
			Object[] itenz = orderList.toArray();
			for (int i = 0; i < itenz.length; i++) {
				ItemOrdered pc = (ItemOrdered) itenz[i];
				if( pc.getItem() == item) {
					position = i;
					}
			}
		}
		return position;
	}
	public void addItemOrdered(int quantity,Item item) {
		citems++;
		counter = sSearchAndDestroy(quantity, item);
		if (counter == 0){ //den exoume to idio antikeimeno sto cart
			ItemOrdered product = new ItemOrdered(quantity,item,citems);
			orderList.add(product);
			}
		counter = 0;
		
		}

	public Item getItembyPosition(int pos2) { 
		pos2 = pos2-1;
		ItemOrdered cartitem = (ItemOrdered) orderList.get(pos2);
		return cartitem.getItem();
	}

	public void removeItemOrdered(Item item) {
		position = sSearchAndDestroy(item);
		if (position > -1) {
			ItemOrdered pc = (ItemOrdered) orderList.get(position);		
			item.setItemStock(item.getItemStock()+pc.getQuantity());
			orderList.remove(position);
			position = -1;
			
			souz = orderList.size();
			for (int i = 0; i < souz; i++) {
				ItemOrdered cci = (ItemOrdered) orderList.get(0);
				cci.setCItems(cci.getCItems()-1); //allazei to CItems 
			}
		}
		
		
	}

	public void changeItemOrderedQuantity(int quantity,Item item) {
		position = sSearchAndDestroy(item);
		if (position > -1) {
			ItemOrdered pc = (ItemOrdered) orderList.get(position);
			if (pc.getQuantity()+quantity==0) { //an to quantity meta tis allages einai 0 to vgazei apo to cart
				removeItemOrdered(item);
			}else {
			pc.setQuantity(pc.getQuantity()+quantity);		
			item.setItemStock(item.getItemStock()-quantity);
			position = -1;
			}
		}
		
	}

	
	public void showCart() {
		System.out.println("----Shopping Cart----");
		if (orderList.size()>0) {
		   System.out.println(orderList.toString());}
		else{ 
			System.out.println("Your Cart is empty.");
		}
	}

	public void clearCart() {
		souz = orderList.size();
		if (souz>0) {
		   for (int i = 0; i < souz+1; i++) {
			ItemOrdered pc = (ItemOrdered) orderList.get(0);
			removeItemOrdered(pc.getItem());
		}
		  System.out.println("Your cart is clear!");
		}else {System.out.println("Cart already empty");}
		  
	}

	public void checkout(Buyer b1) {
		if (orderList.size()>0) {
		System.out.println("Would you like to buy those items?(Y/N)"); 
		showCart(); 
		Scanner input = new Scanner(System.in);  
		String answer = input.nextLine();   
		  if (answer.contentEquals("Y")) {  
			 System.out.print("The transaction is complete.You have paid:");
			 price = calculateNet(); 
			 sss = b1.setbuyerCategory(b1.getBonus());  
			
			 shipping = calculateCourierCost(price,sss);  
			
			 System.out.print(price+ "€" + "\n" +"Shipping "+ shipping); //sunoliko price
			 b1.awardBonus(price,b1);  
			 sss =b1.setbuyerCategory(b1.getBonus()); 
			 System.out.println(" " +sss);  
			 price=0;
			 orderList.clear(); 
		}else if(answer.contentEquals("N")) {
			System.out.println("Transaction is cancelled,items still remain in cart.");
		}
	}else {System.out.println("No items to buy.");}
}

			
	public double calculateNet() { //ypologizei thn sunolikh timh
		souz = orderList.size(); 
		for (int i = 0; i < souz; i++) {
			ItemOrdered pc = (ItemOrdered) orderList.get(i); 
			price = price + (pc.getItem().getPrice())*pc.getQuantity();
		}	
		 return price;
	}


	public double calculateCourierCost(double price,String sss) {
	shipping = price* 0.2;
	if (shipping < 3) {
		shipping = 3;
	}
	if (sss.contentEquals(" SILVER")){  
		shipping = shipping/2;
	}else if(sss.contentEquals(" GOLD")){ 
		shipping = 0;
	}
	return shipping;
}

}


		
	

