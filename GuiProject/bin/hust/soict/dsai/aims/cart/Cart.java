package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import hust.soict.dsai.aims.media.MediaComparator;  // Import Media class

import hust.soict.dsai.aims.media.Media;  // Import Media class
import hust.soict.dsai.aims.media.DVD;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<>(); // Use ArrayList<Media>
    private static final int MAX_NUMBERS_ORDERED = 20;

    // Add media (DVD, Book, CompactDisc) to the cart
    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            System.out.println("The media \"" + media.getTitle() + "\" has been added.");
        } else {
            System.out.println("The cart is full.");
        }
    }

    // Remove media (DVD, Book, CompactDisc) from the cart
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The media \"" + media.getTitle() + "\" has been removed.");
        } else {
            System.out.println("The media \"" + media.getTitle() + "\" is not in the cart.");
        }
    }

    // Calculate and return the total cost of items in the cart
    public float totalCost() {
        float totalCost = 0;
        for (Media media : itemsOrdered) {
            totalCost += media.getCost();
        }
        return totalCost;
    }

    // Print the cart's content
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        float totalCost = 0;
        int index = 1;
        for (Media media : itemsOrdered) {
            System.out.println(index + ". " + media.getClass().getSimpleName() + " - " + media.toString());
            totalCost += media.getCost();
            index++;
        }
        System.out.println("***************************************************");
        System.out.println("Total cost: " + totalCost + " $");
    }

    // Search for media by ID
    public void searchById(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Media Found: " + media.toString());
                return;
            }
        }
        System.out.println("No media found with ID: " + id);
    }

    // Search for media by title
    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                System.out.println("Media Found: " + media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media found with title: \"" + title + "\"");
        }
    }

    // Getter for itemsOrdered (useful for testing or other operations)
    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    // Sort by Title then Cost
    public void sortByTitleThenCost() {
        Collections.sort(itemsOrdered, new MediaComparator(true));  // true for title then cost
    }

    // Sort by Cost then Title
    public void sortByCostThenTitle() {
        Collections.sort(itemsOrdered, new MediaComparator(false));  // false for cost then title
    }
}

