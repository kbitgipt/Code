package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] =
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	
	// Methods
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("This cart is already full");
		}
		itemsOrdered[qtyOrdered] = disc;
		qtyOrdered++;
		System.out.println("The disc has been added");
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		boolean found = false;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i] == disc) {
				found = true;
				for (int j = i; j < qtyOrdered - 1; j++) {
					itemsOrdered[j] = itemsOrdered[j+1];
				}
				qtyOrdered--;
				itemsOrdered[qtyOrdered] = null;
				break;
			}
		}
		if (found) {
			System.out.println("The disc has been removed");
		} 
		else {
			System.out.println("The disc was not found in the cart");
		}
	}
	public float totalCost() {
		if (qtyOrdered == 0) return 0;
		float total = 0;
		for (int i = 0; i < qtyOrdered; i++) {
				total += itemsOrdered[i].getCost();
		}
		return total;
	}
	
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println((i+1) + ". " + itemsOrdered[i].toString());
		}
	}
	
	public void Search(int Id) {
		boolean found = false;
		for (int i = 0; i < qtyOrdered; i++) {
			if (Id == itemsOrdered[i].getId()) {
				System.out.println("DVD with ID "+ Id + " is found:\n" + itemsOrdered[i].toString());
				found = true;
				break;
			}
		}			
		if (!found){
				System.out.println("No match ID is found");
		}
	}
	
	public void Search(String title) {
		boolean found = false;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].isMatch(title) == true) {
				System.out.println("DVD with title \""+ title + "\" is found:\n" + itemsOrdered[i].toString());
				found = true;
				break;
			}
		}
		if (!found){
			System.out.println("No match ID is found");
		}
	}
}
