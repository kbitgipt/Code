package hust.soict.dsai.aims.cart.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {

	@Override
	public int compare(Media o1, Media o2) {
		// TODO Auto-generated method stub
		int costCompare = Float.compare(o2.getCost(), o1.getCost());
		
		if (costCompare != 0) {
			// if title is different, sort by ascending order
			return costCompare;
		}
		else {
			// if title is the same, sort by desc order by cost
			return o1.getTitle().compareTo(o2.getTitle());
		}
	}

}

