package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
	public static final int MAX_NUMBERS_ORDERED = 1000;
	private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int itemCount = 0;
	
	// Constructor
	
	// Methods
	public void addDVD(DigitalVideoDisc disc) {
		if (itemCount == MAX_NUMBERS_ORDERED) {
			System.out.println("Run out of space");
		}
		itemsInStore[itemCount] = disc;
		itemCount++;
		System.out.println("The disc has been added");
	}
	
	public void removeDVD(DigitalVideoDisc disc) {
		boolean found = false;
		for (int i = 0; i < itemCount; i++) {
			if (itemsInStore[i] == disc) {
				found = true;
				for (int j = i; j < itemCount - 1; j++) {
					itemsInStore[j] = itemsInStore[j+1];
				}
				itemCount--;
				itemsInStore[itemCount] = null;
				break;
			}
		}
		if (found) {
			System.out.println("The disc has been removed");
		} 
		else {
			System.out.println("The disc was not found");
		}
	}
	
}

