package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Aims {
	public static void main(String args[]) {
		//Create a new cart
		Cart newOrder = new Cart();
		
		//Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		newOrder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		newOrder.addDigitalVideoDisc(dvd2);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		newOrder.addDigitalVideoDisc(dvd3);
		
		//print total cost of the items int the cart
		System.out.println("Total cost: ");
		System.out.println(newOrder.totalCost());
		
		//Remove dvd from cart
		newOrder.removeDigitalVideoDisc(dvd3);
		System.out.println("Total cost after remove dvd3: ");
		System.out.println(newOrder.totalCost());
	
		
	}
}
