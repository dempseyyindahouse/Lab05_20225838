package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;  // Import the Media class

public class Store {
    private ArrayList<Media> itemsInStore;  // List to hold all Media in the store

    // Constructor
    public Store() {
        itemsInStore = new ArrayList<>();
    }

    // Method to add Media (DVD, Book, CompactDisc) to the store
    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("The media \"" + media.getTitle() + "\" has been added to the store.");
    }

    // Method to remove Media (DVD, Book, CompactDisc) from the store
    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("The media \"" + media.getTitle() + "\" has been removed from the store.");
        } else {
            System.out.println("The media \"" + media.getTitle() + "\" was not found in the store.");
        }
    }

    // Method to display all media in the store
    public void displayStore() {
        System.out.println("***********************STORE***********************");
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is currently empty.");
        } else {
            for (Media media : itemsInStore) {
                System.out.println(media.getClass().getSimpleName() + " - " + media.toString());
            }
        }
        System.out.println("***************************************************");
    }
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

}

