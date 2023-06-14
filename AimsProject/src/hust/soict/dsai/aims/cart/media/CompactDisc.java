package hust.soict.dsai.aims.cart.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
	private static int nbCompactDisc = 0;
	private String artist;
	private List<Track> tracks = new ArrayList<Track>(); 
	
	// Create Constructor method
	public CompactDisc(String artist, ArrayList<Track> tracks) {
		super();
		this.artist = artist;
		this.tracks = tracks;
	}
	
	public CompactDisc(String title) {
		super();
		this.setTitle(title);
		incrementCompactDisc();
        this.setId(nbCompactDisc);
	}

	public CompactDisc(String title, String category, int Id) {
		super();
		this.setTitle(title);
		this.setCategory(category);
		incrementCompactDisc();
        this.setId(nbCompactDisc);
	}
	public CompactDisc(String title, String category, float cost) {
		super();
		this.setCategory(category);
		this.setTitle(title);
		this.setCost(cost);
		incrementCompactDisc();
        this.setId(nbCompactDisc);
	}
	public CompactDisc(String title, String category, int Id, float cost) {
		super();
		this.setCategory(category);
		this.setTitle(title);
		this.setCost(cost);
		incrementCompactDisc();
        this.setId(nbCompactDisc);
	}
	public CompactDisc(int Id, String title, String category, String Director, String artist, float cost) {
		super();
		this.setCategory(category);
		this.setTitle(title);
		this.setCost(cost);
		this.setDirector(Director);
		incrementCompactDisc();
        this.setId(nbCompactDisc);
		this.artist = artist;
	}

	public CompactDisc(String title, float cost) {
		// TODO Auto-generated constructor stub
		super();
		this.setTitle(title);
		this.setCost(cost);
		incrementCompactDisc();
		this.setId(nbCompactDisc);
	}

	// Class attribute related methods
	public String getArtist() {
		return artist;
	}
	
	private static void incrementCompactDisc() {
        nbCompactDisc++;
    }
	
	public void addTrack(Track track) {
		if (tracks.contains(track)) {
			System.out.println("Track already exists in the CD.");
		}
		else tracks.add(track);
	}
	
	public void removeTrack(Track track) {
		if (tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("Track removed from the CD.");
		}
		else System.out.println("Track not found in the CD.");
	}
	
	public int getLength() {
		int totallength = 0;
		for (Track track : tracks) {
			totallength += track.getLength();
		}
		return totallength;
	}

    public void play() {
        System.out.println("Playing CD by " + artist);
        System.out.println("CD length: " + getLength());
        System.out.println("Tracks:");
        for (Track track : tracks) {
            track.play();
        }
    }
    
	@Override
	public String toString() {
	        return "CD - " +
	                "[" + this.getTitle() + "] - "+
	                "[" + this.getCategory() + "] - " +
	                "[" + this.getDirector() + "] - " +
	                "[" + this.getArtist() + "] - " +
	                "[" + this.getLength() + "]: " +
	                "["  + this.getCost() + "] $";
	 }
}
