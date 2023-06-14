package hust.soict.dsai.aims.disc;

import hust.soict.dsai.aims.cart.media.Disc;
import hust.soict.dsai.aims.cart.media.Playable;

public class DigitalVideoDisc extends Disc implements Playable{
	private static int nbDigitalVideoDiscs = 0;
	
	// Create Constructor method
	public DigitalVideoDisc(String title) {
		super();
		this.setTitle(title);
		incrementNbDigitalVideoDiscs();
        this.setId(nbDigitalVideoDiscs);;
	}
	
	public DigitalVideoDisc(String title, float cost) {
		super();
		this.setTitle(title);
		this.setCost(cost);
		incrementNbDigitalVideoDiscs();
        this.setId(nbDigitalVideoDiscs);;
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.setCategory(category);
		this.setTitle(title);
		this.setCost(cost);
		incrementNbDigitalVideoDiscs();
        this.setId(nbDigitalVideoDiscs);;
	}
	public DigitalVideoDisc(String director, String category, String title, int Id, int length, float cost) {
		super();
		this.setCategory(category);
		this.setTitle(title);
		this.setCost(cost);
		this.setDirector(director);
		incrementNbDigitalVideoDiscs();
        this.setId(nbDigitalVideoDiscs);
        this.setLength(length);
	}
	// Class attribute related methods
	private static void incrementNbDigitalVideoDiscs() {
        nbDigitalVideoDiscs++;
    }
	
	// Instance attribute methods
	@Override
	public String toString() {
	        return "DVD - " +
	                "[" + this.getTitle() + "] - "+
	                "[" + this.getCategory() + "] - " +
	                "[" + this.getDirector() + "] - " +
	                "[" + this.getLength() + "]: " +
	                "["  + this.getCost() + "] $";
	 }
	 
	 public boolean isMatch(String title) {
		 return this.getTitle().equals(title);
	 }
	 
	 public void play() {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
		}
	 
//  DVDs have a different ordering rule (
//	 public int compareTo(Media other) {
//	     if (other instanceof DigitalVideoDisc ) {
//	        DigitalVideoDisc otherDVD = (DigitalVideoDisc) other;
//	           int titleComparison = this.getTitle().compareTo(otherDVD.getTitle());
//	           if (titleComparison != 0) {
//	               return titleComparison;
//	           } else {
//	               int lengthComparison = Integer.compare(otherDVD.getLength(), this.getLength());
//	               if (lengthComparison != 0) {
//	                   return lengthComparison;
//	               } else {
//	                   return Float.compare(this.getCost(), otherDVD.getCost());
//	               }
//	           }
//	      } else {
//	    	  return 0;
//	      }
//	 }

}