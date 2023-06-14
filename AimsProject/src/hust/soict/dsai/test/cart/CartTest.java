package hust.soict.dsai.test.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.cart.media.*;

public class CartTest {
	public static void main(String args[]) {
		// Create a new cart
		List<Media> mediae = new ArrayList<Media>();
		
        // Create a list of tracks for the CD
		List<String> authors = new ArrayList<String>();
		authors.add("Author 1");
		authors.add("Author 2");
		
		// Create new dvd objects and add them to the cart
		Media dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 130, 19.95f);
		mediae.add(dvd1);
		
		CompactDisc CD = new CompactDisc(69, "Blank Space",
				"Country", "George Lucas", "Taylor Swift", 24.95f);
		mediae.add(CD);
		
		Book book = new Book("Aladin",
				"Mist", authors, 78, 18.99f);
		mediae.add(book);
		CD.setLength(20);
		//Test the print method
		// sort by comparator
		Collections.sort(mediae, Media.COMPARE_COST_BY_TITLE);
		// sort by comparable
		// Collections.sort(mediae);
		for (Media m : mediae) {
			System.out.println(m.toString());
		}
		System.out.println(dvd1.getId());
		
		// Create tracks for the CD
		Track track1 = new Track("Track 1", 3);
		Track track2 = new Track("Track 2", 4);
		Track track3 = new Track("Track 3", 5);
		
		CD.addTrack(track1);
		CD.addTrack(track2);
		CD.addTrack(track3);
		//Test the search method
//		cart.Search(2);
//		cart.Search("Aladin");
		CD.play();
	}
}
