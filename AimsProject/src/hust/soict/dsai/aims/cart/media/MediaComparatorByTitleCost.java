package hust.soict.dsai.aims.cart.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {

	@Override
	public int compare(Media o1, Media o2) {
		// TODO Auto-generated method stub
		int titleCompare = o1.getTitle().compareTo(o2.getTitle());
		
		if (titleCompare != 0) {
			// if title is different, sort by ascending order
			return titleCompare;
		}
		else {
			// if title is the same, sort by desc order by cost
			return Float.compare(o2.getCost(), o1.getCost());
		}
	}

}

