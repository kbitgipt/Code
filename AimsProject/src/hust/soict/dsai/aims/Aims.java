package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.media.Book;
import hust.soict.dsai.aims.cart.media.CompactDisc;
import hust.soict.dsai.aims.cart.media.Media;
import hust.soict.dsai.aims.cart.media.Playable;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.*;

public class Aims {
	public static void main(String args[]) {
		Store store = new Store();
		Cart cart = new Cart();
		
		Scanner scanner = new Scanner(System.in);
		int option;
		
		do {
			showMenu();
			option = scanner.nextInt();
			scanner.nextLine();
			
			switch (option) {
			case 1:
				viewStore(store, cart, scanner);
				break;
			case 2:
				updateStore(store, scanner);
				break;
			case 3:
				seeCurrentCart(cart, scanner);
				break;
			case 0:
				System.out.println("Exiting the application. Goodbye!");
                break;
			default:
				System.out.println("Invalid option, please try again");
			}
		} while (option !=0); 
		
	}
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void viewStore(Store store,Cart cart,Scanner scanner) {
		int option;
		
		do {
			storeMenu();
			option = scanner.nextInt();
			scanner.nextLine();
			
			switch (option) {
			case 1: 
				seeMediaDetails(store, cart, scanner);
				break;
			case 2:
				addMediaToCart(store, cart, scanner);
				break;
			case 3: 
				playMedia(store, scanner);
				break;
			case 4:
				seeCurrentCart_1(cart, scanner);
				break;
			case 0:
				System.out.println("Returning to main Menu");
				break;
			default:
				System.out.println("Invalid option, please try again");
			}
		}	while (option!=0);
		
	}
	private static void seeCurrentCart_1(Cart cart, Scanner scanner) {
		// TODO Auto-generated method stub
		cart.print();
	}
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}

	public static void seeMediaDetails(Store store, Cart cart, Scanner scanner) {
		System.out.println("Enter title: ");
		String title = scanner.nextLine();
		
		Media media = store.Search(title);
		
		if (media != null) {
			System.out.println(media.toString());
			int option;
			do {
				mediaDetailsMenu();
				option = scanner.nextInt();
				scanner.nextLine();
				
				switch(option) {
				case 1: 
					addToCart(media, cart, scanner);
					break;
				case 2:
					if (media instanceof Playable) {
						((Playable) media).play();
					}
					else {
						System.out.println("This media cannot be played");
					}
					break;
				case 0:
					System.out.println("Returning to store menu");
					break;
				default:
					System.out.println("Invalid option, please try again");
				}
			} while (option!=0);
		}
		else {
			System.out.println("Not found media");
		}
		return;
	}
	
	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void addToCart(Media media,Cart cart, Scanner scanner) {
		System.out.println("Adding " + media.getTitle() + " to cart.");
		
		cart.addMedia(media);
	}
	
	public static void addMediaToCart(Store store,Cart cart, Scanner scanner) {
		System.out.println("Enter the title of the media to add to cart:");
        String title = scanner.nextLine();

        System.out.println("Enter the cost of the media:");
        float cost = scanner.nextFloat();
        scanner.nextLine(); // Consume the newline character

        System.out.println("Enter the category of the media (Book/CD/DVD):");
        String category = scanner.nextLine();

        Media media = null;
        if (category.equalsIgnoreCase("book")) {
            media = new Book(title, cost);
        } else if (category.equalsIgnoreCase("cd")) {
            media = new CompactDisc(title, cost);
        } else if (category.equalsIgnoreCase("dvd")) {
            media = new DigitalVideoDisc(title, cost);
        } else {
            System.out.println("Invalid category.");
        }

	    if (media != null) {
	    	addToCart(media, cart, scanner);
	    	int numDVDs = cart.getNumberOfDVDs();
	        System.out.println("Number of DVDs in cart: " + numDVDs);
	    } else {
	        System.out.println("Media not found.");
	    }	
	}
	
	public static void playMedia(Store store, Scanner scanner) {
        System.out.println("Enter the title of the media to play:");
        String title = scanner.nextLine();

        Media media = store.Search(title);
        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("Media not found or cannot be played.");
        }
	}
	
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}

	public static void updateStore(Store store, Scanner scanner) {
		int option;
		
		do {
			updateStoreMenu();
			option = scanner.nextInt();
			scanner.nextLine(); // Consume the newline character
			
			switch (option) {
			case 1:
				addMediaToStore(store, scanner);
				break;
			case 2:
				removeMediaFromStore(store, scanner);
				break;
			case 0:
				 System.out.println("Returning to main menu.");
                 break;
             default:
                 System.out.println("Invalid option. Please try again.");
			}
		} while (option != 0);
		
	}
	
	public static void updateStoreMenu() {
		System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Add a media to store");
        System.out.println("2. Remove a media from store");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void addMediaToStore(Store store, Scanner scanner) {
		System.out.println("Enter the title of the media to add to store:");
        String title = scanner.nextLine();

        System.out.println("Enter the cost of the media:");
        float cost = scanner.nextFloat();
        scanner.nextLine(); // Consume the newline character

        System.out.println("Enter the category of the media (Book/CD/DVD):");
        String category = scanner.nextLine();

        Media media = null;
        if (category.equalsIgnoreCase("book")) {
            media = new Book(title, cost);
        } else if (category.equalsIgnoreCase("cd")) {
            media = new CompactDisc(title, cost);
        } else if (category.equalsIgnoreCase("dvd")) {
            media = new DigitalVideoDisc(title, cost);
        } else {
            System.out.println("Invalid category.");
        }
        if (media != null) {
        	store.addMedia(media);
        	System.out.println("Media added to store successfully.");
        }
	}
	
	public static void removeMediaFromStore(Store store, Scanner scanner) {
	    System.out.println("Enter the title of the media to remove from store:");
	    String title = scanner.nextLine();
	    Media media = store.Search(title);
	    store.removeMedia(media);
	}
	
	public static void seeCurrentCart(Cart cart, Scanner scanner) {
		cart.print();

	    int option;
	    do {
	        cartMenu();
	        option = scanner.nextInt();
	        scanner.nextLine(); // Consume the newline character

	        switch (option) {
	            case 1:
	                filterMediasInCart(cart, scanner);
	                break;
	            case 2:
	                sortMediasInCart(cart, scanner);
	                break;
	            case 3:
	                removeMediaFromCart(cart, scanner);
	                break;
	            case 4:
	                playMediaInCart(cart, scanner);
	                break;
	            case 5:
	                placeOrder(cart);
	                break;
	            case 0:
	                System.out.println("Returning to main menu.");
	                break;
	            default:
	                System.out.println("Invalid option. Please try again.");
	        }
	    } while (option != 0);
	}
	public static void filterMediasInCart(Cart cart, Scanner scanner) {
	    int option;
	    do {
	        filterMenu();
	        option = scanner.nextInt();
	        scanner.nextLine(); // Consume the newline character

	        switch (option) {
	            case 1:
	                filterById(cart, scanner);
	                break;
	            case 2:
	                filterByTitle(cart, scanner);
	                break;
	            case 0:
	                System.out.println("Returning to cart menu.");
	                break;
	            default:
	                System.out.println("Invalid option. Please try again.");
	        }
	    } while (option != 0);
	}

	public static void filterMenu() {
	    System.out.println("Options:");
	    System.out.println("--------------------------------");
	    System.out.println("1. Filter by ID");
	    System.out.println("2. Filter by title");
	    System.out.println("0. Back");
	    System.out.println("--------------------------------");
	    System.out.println("Please choose a number: 0-1-2");
	}

	public static void filterById(Cart cart, Scanner scanner) {
	    System.out.println("Enter the ID of the media to filter:");
	    int id = scanner.nextInt();
	    scanner.nextLine(); // Consume the newline character

	    cart.filterById(id);
	}

	public static void filterByTitle(Cart cart, Scanner scanner) {
	    System.out.println("Enter the title of the media to filter:");
	    String title = scanner.nextLine();

	    cart.filterByTitle(title);
	}

	public static void sortMediasInCart(Cart cart, Scanner scanner) {
	    int option;
	    do {
	        sortMenu();
	        option = scanner.nextInt();
	        scanner.nextLine(); // Consume the newline character

	        switch (option) {
	            case 1:
	                sortByTitle(cart);
	                break;
	            case 2:
	                sortByCost(cart);
	                break;
	            case 0:
	                System.out.println("Returning to cart menu.");
	                break;
	            default:
	                System.out.println("Invalid option. Please try again.");
	        }
	    } while (option != 0);
	}

	public static void sortMenu() {
	    System.out.println("Options:");
	    System.out.println("--------------------------------");
	    System.out.println("1. Sort by title");
	    System.out.println("2. Sort by cost");
	    System.out.println("0. Back");
	    System.out.println("--------------------------------");
	    System.out.println("Please choose a number: 0-1-2");
	}

	public static void sortByTitle(Cart cart) {
	    cart.sortByTitle();
	}

	public static void sortByCost(Cart cart) {
	    cart.sortByCost();
	}

	public static void removeMediaFromCart(Cart cart, Scanner scanner) {
	    System.out.println("Enter the title of the media to remove from cart:");
	    String title = scanner.nextLine();
	    Media media = cart.Search(title);
	    boolean removed = cart.removeMedia(media);
	    if (removed) {
	        System.out.println("Media removed from cart successfully.");
	    } else {
	        System.out.println("Media not found in cart.");
	    }
	}

	public static void playMediaInCart(Cart cart, Scanner scanner) {
	    System.out.println("Enter the title of the media to play from cart:");
	    String title = scanner.nextLine();

	    Media media = cart.Search(title);
	    if (media != null && media instanceof Playable) {
	        ((Playable) media).play();
	    } else {
	        System.out.println("Media not found in cart or cannot be played.");
	    }
	}

	public static void placeOrder(Cart cart) {
	    System.out.println("Order created. Thank you for your purchase!");
	    cart.clear();
	}

}
