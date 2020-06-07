import java.util.List;
import java.util.ArrayList;


public class Eshop {
	private String name = "ZStore";
	private int position = -1;//position sto List
	private String senc;
	
	private int showProductsCounter = 1;
	private int showProductsInCCounter = 0;
	private int quant1 = 0;//pen
	private int quant2 = 0;//pencil
	private int quant3 = 0;//notebook
	private int quant4 = 0;//paper
	
	private int counterTIMES = 0;
	private int buycount = 0;
	
	List itemsList = new ArrayList();
	List buyerList = new ArrayList();
	List ownerList = new ArrayList();
	
	public void addItem(String name, double price, String description, int stock, int id, String color,double tipSize) {//ZPen
		ZPen pen = new ZPen(name,price,description,stock,id,color,tipSize);
		itemsList.add(pen);		
	}
	public void addItem(String name, double price, String description, int stock, int id, double tipSize,String type) {//ZPencil
		ZPencil pencil = new ZPencil(name,price,description,stock,id,tipSize,type);
		itemsList.add(pencil);		
	}
	public void addItem(String name, double price, String description, int stock, int id, int sections) {//ZNotebook
		ZNotebook notebook = new ZNotebook(name,price,description,stock,id,sections);
		itemsList.add(notebook);		
	}
	public void addItem(String name,double price,String description,int stock,int id,int weight,int pages) {//ZPaper
		ZPaper paper = new ZPaper(name,price,description,stock,id,weight,pages);
		itemsList.add(paper);
	
	}
	
	public void addBuyer(String name,String email,int bonus) {
		Buyer buyer = new Buyer(name,email,bonus);
		buyerList.add(buyer);
		
		
	}
	public void addOwner(String name,String email) {
		Owner owner = new Owner(name,email); 
		ownerList.add(owner);
		
		
	}
	public int oSearchAndDestroy(String email) {
		Object[] itenz = ownerList.toArray();
		position = -1; //arxikopoihsh position -1
		for (int i = 0; i < itenz.length; i++) {
			Owner o1 = (Owner) itenz[i];
			if (email.contentEquals(o1.getEmail())) { //vriskei to email an uparxei
				position = i; 
				
			}
		} //an den to vrei ginetai -1
		return position;
	}
	
	public int bSearchAndDestroy(String email) { 
		Object[] itenz = buyerList.toArray();
		for (int i = 0; i < itenz.length; i++) {
			Buyer b1 = (Buyer) itenz[i];
			if (email.contentEquals(b1.getEmail())) {
				position = i;
				
			}
		}
		return position;
	}
	private int iSearchAndDestroy(int id0) { //vriskei thn thesh
		Object[] itenz = itemsList.toArray();
		for (int i = 0; i < itenz.length; i++) {
			Item i1 = (Item) itenz[i];
			if (id0 == i1.getId()) {
				position = i;
			}
		}
		return position;
	}
	
	private void iSearchAndDestroy(int newStock,int id0) { //thetei to stock
		Object[] itenz = itemsList.toArray();
		for (int i = 0; i < itenz.length; i++) {
			Item i1 = (Item) itenz[i];
			if (id0 == i1.getId()) {
				i1.setItemStock(newStock);
				position = -1;
			}
		}
	}
	public void removeBuyer(String email) {
		position = bSearchAndDestroy(email);
		if (position > -1) {
			buyerList.remove(position);
			position = -1; //arxikopoihsh position -1

		} else {
			System.out.println("The buyer doesn't exist.");
		}
	}
	
	public void checkStatus() {
		Object[] itenz = buyerList.toArray();
		if (itenz.length>0) {
		for (int i = 0; i < itenz.length; i++) {
			Buyer a1 = (Buyer) itenz[i];
			senc = a1.setbuyerCategory(a1.getBonus());
			buycount++; //metraei tous buyer
			System.out.println( buycount +".Buyer:" + a1.getName() + " Pontoi:" + a1.getBonus() +" Kathgoria:" + senc);
		}
		buycount=0;
		}else { System.out.println("No more buyers.");}
	}
	
	public void updateItemStock(int newStock,int id0) {
		iSearchAndDestroy(newStock,id0);	
	}
	
	public Item getItemById(int id1) { 
		position = iSearchAndDestroy(id1);
		if (position > -1) {
			Item a1 = (Item) itemsList.get(position);
			position = -1;			
			return a1;
		} else {
			System.out.println("Doesn't exist!");
			ZPen Dummy = new ZPen("null",0,"null",0, -999, "null", 0); //dummy item otan den vriskei to id
			return Dummy;
			}
	}
	
	public void removeItem(int id2) {
		position = iSearchAndDestroy(id2);
		if (position > -1) {
			itemsList.remove(position);
			position = -1;
		} else {
			System.out.println("Doesnt exist!");
		}		
	}
	
	public void showCategories() {//case 1
		Object[] itenz = itemsList.toArray();
		if (counterTIMES==0){ //vriskei ta quantities mono thn prwth fora
			counterTIMES=1;
		for (int i = 0; i < itenz.length; i++) {
			Item a1 = (Item) itenz[i];
			switch(a1.getClass().getName()) {
			case "ZPen":
				quant1++;
				break;
			case "ZPencil":
				quant2++;
				break;
			case "ZNotebook":
				quant3++;
				break;
			case "ZPaper":
				quant4++;
				break;
			}
			}
		}
			if (quant1 >0) {
				System.out.print(showProductsCounter);
				System.out.print(".");
				showProductsCounter++;
				System.out.print("ZPen("+quant1+ ")\n");
			}
			if (quant2 >0) {
				System.out.print(showProductsCounter);
				System.out.print(".");
				showProductsCounter++;
				System.out.print("ZPencil("+quant2+ ")\n");
			}
			if (quant3 >0) {
			    System.out.print(showProductsCounter);
				System.out.print(".");
				showProductsCounter++;
				System.out.print("ZNotebook("+ quant3 + ")\n");
			}
			if (quant4 >0) {
			    System.out.print(showProductsCounter);
				System.out.print(".");
				showProductsCounter++;
				System.out.print("ZPaper("+quant4+ ")\n");
			}
			
		showProductsCounter = 1; //arithmish arxis system.out
	}
	
	
	public void showProductsInCategory(String Class) {
		Object[] itenz = itemsList.toArray();
		for (int i = 0; i < itenz.length; i++) {
			Item a1 = (Item) itenz[i];
			
			if (Class.contentEquals(a1.getClass().getName())) {
				if (showProductsInCCounter == 0) {
					System.out.print(Class+":\n");
					showProductsInCCounter++;
				}
				System.out.print(showProductsInCCounter+".");
				System.out.print(a1.getName());
				System.out.print("-Id(" + a1.getId()+").");
				System.out.print("\n");
				showProductsInCCounter++;
			}
		}
		showProductsInCCounter=1;
		System.out.println("");
	}
	public void showProduct(int id3) {	
		position = iSearchAndDestroy(id3);
		Item a1 = (Item) itemsList.get(position);
		System.out.println(a1.toString());
	}
	public void printbName(int pos) {
		
		Buyer Bruno = (Buyer) buyerList.get(pos);
		System.out.println("Hallo "+ Bruno.getName() +".It's been a while."+"Your bonus is:"+Bruno.getBonus()+".");
	}
	public void printoName(int pos) {
		
		Owner Giorno = (Owner) ownerList.get(pos);
		System.out.println("Hallo "+ Giorno.getName() +".It's been a while."+"You are admin.("+Giorno.isAdmin()+").");
	}
	
	public Buyer getBuyer(int position) {
		Buyer Bruno = (Buyer) buyerList.get(position);
		return Bruno;
	}
	public String getName() {
		return name;
	}
}

