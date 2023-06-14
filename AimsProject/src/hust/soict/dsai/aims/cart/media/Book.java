package hust.soict.dsai.aims.cart.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	
	private List<String> authors = new ArrayList<String>(); 
	private static int nbBook = 0;
	
	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	// Create Constructor method
	public Book(String title) {
		super(title);
		this.setTitle(title);
		incrementNbBooks();
        this.setId(nbBook);
	}
	public Book(String title, float cost) {
		super();
		this.setTitle(title);
		this.setCost(cost);
		incrementNbBooks();
        this.setId(nbBook);
	}
	
	public Book(String title, List<String> athors) {
		super();
		this.setTitle(title);
		this.setAuthors(authors);
		incrementNbBooks();
        this.setId(nbBook);
	}
	public Book(String title, String category, List<String> athors) {
		super();
		this.setCategory(category);
		this.setTitle(title);
		this.setAuthors(authors);
		incrementNbBooks();
        this.setId(nbBook);
	}
	public Book(String title, String category, List<String> authors, int Id, float cost) {
		super();
		this.setCategory(category);
		this.setTitle(title);
		this.setCost(cost);
		this.setAuthors(authors);
		incrementNbBooks();
        this.setId(nbBook);
	}
	public void addAuthor(String authorName) {
		if (!authors.contains(authorName)) {
			authors.add(authorName);
		}
	}
	
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authorName);
		}
	}
	
	// Class attribute related methods
	private static void incrementNbBooks() {
        nbBook++;
    }
	
	@Override
	public String toString() {
	        return "Book - " +
	                "[" + this.getTitle() + "] - "+
	                "[" + this.getCategory() + "] - " +
	                "[" + this.getAuthors() + "] - " +
	                "["  + this.getCost() + "] $";
	 }

}
