package CartManagement;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] =
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
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
}
