import java.util.Scanner;
import java.util.regex.Pattern; 
import java.util.InputMismatchException;

public class Amain {
	 

	public static boolean isValid(String mail) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,5}$"; //kanonikh ekfrash gia ena email
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (mail == null) 
        	return false; 
        return pat.matcher(mail).matches(); 
    } 
	
	public static void main(String[] args) {
		
		Eshop MyShop = new Eshop();
		Menu MyMenu = new Menu();
		Boolean validity = true; //email
		int position;
		int loop = 1;
		String back;
		String SolemnWarning; //catch /n
		int btry;//convertion string to int
		
		String cas2an = "0time";//case2 debugger
		
		
		//(String name, double price, String description, int stock, int id, String color,double tipSize)ZPen
		//(String name, double price, String description, int stock, int id, double tipSize,String type) ZPencil	
		//(String name, double price, String description, int stock, int id, int sections)  			 ZNotebook
		//(String name,double price,String description,int stock,int id,int weight,int pages)  		 	 ZPaper
		
	    MyShop.addItem("Faber Castell",2,"The best blue pen",10, 193, "Blue", 0.4);//ZPen
	    MyShop.addItem("Pelikan",1.5,"Our new black pen",15, 165, "Black", 0.3);//ZPen
	    MyShop.addItem("Bic",1.8,"Classic",20, 132, "Blue", 0.6);//ZPen

		MyShop.addItem("Dessin",3,"Your favourite pencil",40, 154, 0.4,"B");//ZPencil 
		MyShop.addItem("Staedtler",2.1,"OUR BESTSELLER",34, 152, 0.6,"HB");//ZPencil
		MyShop.addItem("Faber Castell",2.5,"THE BEST PENCIL EVER",21, 170, 0.5,"H");//ZPencil
		
		
		MyShop.addItem("Apica", 6.5, "Economical and ecological", 9, 123, 2);//ZNotebook
		MyShop.addItem("Moleskine", 5, "For all kids", 15, 120, 3);//ZNotebook
		MyShop.addItem("Skag", 4.5, "Classic and cool", 6, 110, 2);//ZNotebook

		
		MyShop.addItem("Hp Paper", 4.5, "Special Quality", 20, 211, 5,350);//ZPaper
		MyShop.addItem("Fabriano", 5, "Very economical, you must buy it", 32, 220, 5,500);//ZPaper
		MyShop.addItem("Navigator", 3.5, "You must have it", 28, 215, 4,300);//ZPaper

		MyShop.addBuyer("Kostas", "des@des.des", 132);
		MyShop.addBuyer("Antreas", "antreas_1@gmail.com",89);

		MyShop.addOwner("Mhtsos", "dos@dos.dos");
		
		MyShop.getBuyer(0).placeOrder(1, MyShop.getItemById(193)); //placeorder(stock,item)  0 - position sto list me toys buyer
		MyShop.getBuyer(0).placeOrder(1, MyShop.getItemById(165));
		MyShop.getBuyer(0).placeOrder(2, MyShop.getItemById(152));
		MyShop.getBuyer(0).placeOrder(1, MyShop.getItemById(110));
		MyShop.getBuyer(0).placeOrder(3, MyShop.getItemById(211));
		
		MyShop.getBuyer(1).placeOrder(2, MyShop.getItemById(120));
		MyShop.getBuyer(1).placeOrder(1, MyShop.getItemById(193));
		MyShop.getBuyer(1).placeOrder(3, MyShop.getItemById(220));
		MyShop.getBuyer(1).placeOrder(1, MyShop.getItemById(215));
		MyShop.getBuyer(1).placeOrder(7, MyShop.getItemById(132));
		
		
		Scanner input = new Scanner(System.in);		
		do {
			System.out.println("Welcome to " + MyShop.getName() + "!" );			
			System.out.print("What's ur email:");
			String mail = input.nextLine();	
			validity = isValid(mail);
			if (validity == false) {
				System.out.println("Pls enter ur email CORRECTLY!");
			}else {
				position = MyShop.oSearchAndDestroy(mail); //elegxei prwta an to email einai toy owner
				  if (position == -1) { //den einai owner
					position = MyShop.bSearchAndDestroy(mail); //elegxei an einai buyer
					if (position == -1) { //den einai buyer
						System.out.println("This email is not registered.Would u like to make a new account?(Y/N)");
						String answer = input.nextLine();
						if (answer.contentEquals("Y")){
							System.out.print("Then,please enter your name:");
							String name = input.nextLine();
							MyShop.addBuyer(name, mail, 0);  //prosthetei buyer
							position = MyShop.bSearchAndDestroy(mail); //alternative position = 0
						}else {
							System.out.println("Ok,exiting the program now.");
							System.exit(0);
						}

					}
					
			     if (position > -1) { //einai buyer
						
						do{
							loop = 0;
							MyShop.printbName(position); //ektypwnei kalwsorisma
							MyMenu.bMenu(); 
							int ans1 = input.nextInt(); 
							String ans2 = input.nextLine(); 
							switch(ans1) {
							case 1: //1.Browse Store
								do {
									MyShop.showCategories();
									System.out.println("Write the name of the category of items u wanna see.");
									ans2 = input.nextLine();
									if (ans2.contentEquals("Back")){
										loop = 1;
										break;
									}
									MyShop.showProductsInCategory(ans2);
									System.out.println("Write the id of the item u want to see.");
							
									try {
										int ans3=input.nextInt();
										MyShop.showProduct(ans3);
										System.out.println("Do you want to buy the item?(Y/N)");
										String ans4 = input.nextLine();
										ans4 = input.nextLine();
										if (ans4.contentEquals("Y")){
					      					MyShop.getBuyer(position).placeOrder(1,MyShop.getItemById(ans3)); //mpainoun sto cart mia mia h paraggelia
											System.out.println("If you want to return to the Categories press Back");
											back = input.nextLine();
										}else {	back  = "Back";}
									}
									catch(InputMismatchException e) //an den valei int ton gurnaei pisw
									{
										SolemnWarning = input.nextLine();
										back = "Back";	
									}
							
									}while(back.contentEquals("Back"));
								break;
						  case 2: //View Cart
							  do {
								MyShop.getBuyer(position).showCart();
								MyMenu.bViewCart();
								System.out.println("If you wanna edit an item in the cart press the number of the item.Else press the other options.");
								
								if (cas2an.contentEquals("ftime")){
									cas2an=input.nextLine();
								}
								String ans5 = input.nextLine();
								if (ans5.contentEquals("Back")){
									loop=1;
									break;
								}else if (ans5.contentEquals("b")){ //ClearCart
									MyShop.getBuyer(position).clearCart();
									back  = "Back";
									cas2an = "0time";
								}else if (ans5.contentEquals("c")){ //Checkout
									MyShop.getBuyer(position).checkout(MyShop.getBuyer(position));
									back  = "Back";
									cas2an = "0time";
								}else {
									try {
									   btry = Integer.parseInt(ans5); //allazei an mporei to ans5 se int
									  }
									catch (NumberFormatException e)
									{
									   SolemnWarning = input.nextLine();							   
									   btry = -1;
									}
									
									System.out.println("1.Delete the item?");
									System.out.println("2.Change stock?");
									
									try {
										int ans6=input.nextInt();
										if (ans6 == 1) {
											MyShop.getBuyer(position).removeItemOrdered(MyShop.getBuyer(position).getItembyPosition(btry));
											back  = "Back";
											cas2an = "ftime";
										}else if(ans6==2) {
											System.out.println("Type how you want to change the stock.");
											int ans7 = input.nextInt();
											MyShop.getBuyer(position).updateOrderStock(ans7,MyShop.getBuyer(position).getItembyPosition(btry)); //o xrhsths plhktrologei pws tha allaksei to stock + gia prosthesi - gia afairesi
											back  = "Back";
											cas2an = "ftime";
										}else {	back  = "Back";}
									}
									catch(InputMismatchException e)
									{
										SolemnWarning = input.nextLine();
										back = "Back";	
									}
									
								}
							  }while(back.contentEquals("Back"));
						    break;
						  case 3: //Checkout
							  MyShop.getBuyer(position).checkout(MyShop.getBuyer(position));
							  loop = 1;
							  break;
						  case 4: //Back
							  System.out.println("You want to logout?(Y/N)");
							  String ans8 = input.nextLine();
							  if (ans8.contentEquals("Y")) {
								loop = 0;  
							  }else {
								 loop = 1;
							  }
							  break;
						  case 5: //Logout
							  loop=0;
							  break;
						  case 6: //Exit
							  System.out.println("Ok,exiting the program now.");
							  System.exit(0);
							  break;
					 	}
					}while( loop == 1);
				}
			}else { //owner
				do {
				loop=0;
				MyShop.printoName(position); //ektypwnei kaloswrisma
				MyMenu.oMenu();
				int ans9 = input.nextInt();
				String ans10 = input.nextLine();
				switch(ans9) {
				case 1: //Browse Store
					do {
						
						MyShop.showCategories();
						System.out.println("Write the name of the category of items u wanna see.");
						String ans2 = input.nextLine();
					    if (ans2.contentEquals("Back")){
							loop = 1;
							break;
						}
						MyShop.showProductsInCategory(ans2);
						System.out.println("Write the id of the item u want to see.");
				
						try {
							int ans3=input.nextInt();
							MyShop.showProduct(ans3);
							System.out.println("Do you want to update the item stock the item?(Y/N)");
							String ans4 = input.nextLine();
							ans4 = input.nextLine();
							if (ans4.contentEquals("Y")){
								System.out.println("Enter new stock.");
								int nws = input.nextInt();
								MyShop.updateItemStock(nws,ans3); //setarei to neo stock, den plhktrologei pws allazei
								System.out.println("If you want to return to the Categories press Back");
								back = input.nextLine();
								back= input.nextLine();
							}else {	back  = "Back";}
						}
						catch(InputMismatchException e)
						{
							SolemnWarning = input.nextLine();
							back = "Back";	
						}
				
						}while(back.contentEquals("Back"));
					break;
				case 2: //Check Status
					do {
						
						MyShop.checkStatus();
						System.out.println("Which one of the buyers you want to check?");
						try {
							int ans13 = input.nextInt();
							position = ans13-1;
							MyShop.getBuyer(position).showCart();
							System.out.println("Would u like to delete this buyer?(Y/N)");
							String ans14 = input.nextLine();
							ans14 = input.nextLine();
							if (ans14.contentEquals("Y")) {
								MyShop.removeBuyer(MyShop.getBuyer(position).getEmail()); //diagrafh buyer
							}
							System.out.println("Type Back if you want to see the buyers again");
							back = input.nextLine();
						}
						catch(InputMismatchException e){
							SolemnWarning = input.nextLine();
							loop=1;
							break;	
						}
					}while (back.contentEquals("Back"));
					break;
				case 3: //Back
					 System.out.println("You want to logout?(Y/N)");
					  String ans11 = input.nextLine();
					  if (ans11.contentEquals("Y")) {
						loop = 0;  
					  }else {
						 loop = 1;
					  }
					break;
				case 4: //Exit
					 loop=0;
					break;
				case 5:
					System.out.println("Ok,exiting the program now.");
					System.exit(0);
					break;
				}
				}while (loop==1);
			}
		}
	}
	while((validity == false) || (loop==0)); //an to email einai lathos morfhs h ekane log out o xrhsths
  } 
		
}


