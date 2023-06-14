package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.cart.media.Media;

public class Store {
	public static final int MAX_NUMBERS_ORDERED = 1000;
	private List<Media> itemsInStore = new ArrayList<Media>();
	private int itemCount = 0;
	
	// Constructor
	
	// Methods
	public void addMedia(Media media) {
		if (itemCount == MAX_NUMBERS_ORDERED) {
			System.out.println("Run out of store storage");
			return;
		}
	    if (itemsInStore.contains(media)) {
	        System.out.println("The media is already in the cart");
	        return;
	    }
	    itemsInStore.add(media);
		itemCount++;
		System.out.println("The item has been added");
	}

	
	public boolean removeMedia(Media media) {
		if (itemsInStore.contains(media)) {
	        itemsInStore.remove(media);
	        itemCount--;
	        System.out.println("The media has been removed");
	        return true;
	    } else {
	        System.out.println("The media was not found in the cart");
	        return false;
	    }
	}
	
	public Media Search(String title) {
		for (Media media : itemsInStore) {
			if (media.isMatch(title)) {
				return media;
			}
		}
		return null;
	}
}

