package hust.soict.dsai.aims.cart.media;

import java.util.Comparator;

public abstract class Media { //implements Comparable<Media> {
	public static final Comparator<Media> COMPARE_TITLE_BY_COST = new MediaComparatorByTitleCost();
	
	public static final Comparator<Media> COMPARE_COST_BY_TITLE = new MediaComparatorByCostTitle();

	// for Comparable need to modify as below
//    @Override
//    public int compareTo(Media other) {
//        int titleComparison = this.getTitle().compareTo(other.getTitle());
//        if (titleComparison != 0) {
//            return titleComparison;
//        } else {
//            return Float.compare(this.getCost(), other.getCost());
//        }
//    }
    
	private int id;
	private String title;
	private String category;
	private float cost;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public Media() {
	}
	
	public Media(String title) {
		super();
		this.title = title;
	}
	
	public Media(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public Media(int id, String title, String category) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
	}

	public Media(int id, String title, String category, float cost) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
	// Methods
	public String toString() {
        return "Media - " +
                "[" + this.getId() + "] - " +
                "[" + this.getTitle() + "] - "+
                "[" + this.getCategory() + "] - " +
                "["  + this.getCost() + "] $";
	}
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    Media other = (Media) obj;
	    return getTitle().equals(other.getTitle());
	}
	
	public boolean isMatch(String title) {
		 return this.getTitle().equals(title);
	}


    
}
