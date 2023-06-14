package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import hust.soict.dsai.aims.cart.media.Media;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private int qtyOrdered = 0;
	private List<Media> itemsOrdered = new ArrayList<Media>();
	
	
	// Methods
	public void addMedia(Media media) {
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("This cart is already full");
			return;
		}
	    if (itemsOrdered.contains(media)) {
	        System.out.println("The media is already in the cart");
	        return;
	    }
	    itemsOrdered.add(media);
		qtyOrdered++;
		System.out.println("The disc has been added");
	}
	
	public boolean removeMedia(Media media) {
		if (itemsOrdered.contains(media)) {
	        itemsOrdered.remove(media);
	        qtyOrdered--;
//	        System.out.println("The disc has been removed");
	        return true;
	    } else {
//	        System.out.println("The disc was not found in the cart");
	    	return false;
	    }
	}
	public float totalCost() {
		if (qtyOrdered == 0) return 0;
		float total = 0;
		for(Media media : itemsOrdered) {
			total += media.getCost();
		}
		return total;
	}
	
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (Media media : itemsOrdered) {
			System.out.println(media.toString());
		}
	}
	
	public void Search(int Id) {
		boolean found = false;
		for (Media media : itemsOrdered) {
			if (media.getId() == Id) {
				System.out.println("Media with ID "+ Id + " is found:\n" + media.toString());
				found = true;
				break;
			}
		}			
		if (!found){
				System.out.println("No media with matching ID is found");
		}
	}
	
	public Media Search(String title) {
//		boolean found = false;
		Media r_media = null;
		for (Media media : itemsOrdered) {
			if (media.isMatch(title)) {
//				System.out.println("DVD with title \""+ title + "\" is found:\n" + media.toString());
//				found = true;
//				break;
				r_media = media;
				return r_media;
			}
		}
//		if (r_media == null){
//			System.out.println("No media with matching title is found");
//		}
		return r_media;
	}
	
	public int getNumberOfDVDs() {
		return qtyOrdered;
	}

	public void filterById(int id) {
		// TODO Auto-generated method stub
        List<Media> filteredList = new ArrayList<>();
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                filteredList.add(media);
            }
        }
        if (filteredList.isEmpty()) {
            System.out.println("No media with matching ID is found");
        } else {
            System.out.println("Filtered Medias:");
            for (int i = 0; i < filteredList.size(); i++) {
                System.out.println((i + 1) + ". " + filteredList.get(i).toString());
            }
        }
	}

	public void filterByTitle(String title) {
		// TODO Auto-generated method stub
        List<Media> filteredList = new ArrayList<>();
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                filteredList.add(media);
            }
        }
        if (filteredList.isEmpty()) {
            System.out.println("No media with matching title is found");
        } else {
            System.out.println("Filtered Medias:");
            for (int i = 0; i < filteredList.size(); i++) {
                System.out.println((i + 1) + ". " + filteredList.get(i).toString());
            }
        }
	}

	public void sortByTitle() {
		// TODO Auto-generated method stub
        Collections.sort(itemsOrdered, new Comparator<Media>() {
            public int compare(Media media1, Media media2) {
                int result = media1.getTitle().compareToIgnoreCase(media2.getTitle());
                if (result == 0) {
                    return Double.compare(media2.getCost(), media1.getCost());
                }
                return result;
            }
        });
        System.out.println("Medias sorted by title");
	}

	public void sortByCost() {
		// TODO Auto-generated method stub
        Collections.sort(itemsOrdered, new Comparator<Media>() {
            public int compare(Media media1, Media media2) {
                int result = Double.compare(media2.getCost(), media1.getCost());
                if (result == 0) {
                    return media1.getTitle().compareToIgnoreCase(media2.getTitle());
                }
                return result;
            }
        });
        System.out.println("Medias sorted by cost");
	}

	public void clear() {
		// TODO Auto-generated method stub
		itemsOrdered.clear();
        qtyOrdered = 0;
	}
}
