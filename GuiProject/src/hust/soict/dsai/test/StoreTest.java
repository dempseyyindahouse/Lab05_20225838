package hust.soict.dsai.test.store;
import hust.soict.dsai.aims.media.DVD;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        // Create a new store
        Store store = new Store();

        // Create sample DVDs
        DVD dvd1 = new DVD("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DVD dvd2 = new DVD("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DVD dvd3 = new DVD("Aladdin", "Animation", "Guy Ritchie", 120, 18.99f);

        // Add DVDs to the store
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        // Display store contents
        System.out.println("\nStore contents after adding DVDs:");
        store.displayStore();

        // Remove a DVD from the store
        store.removeDVD(dvd2);

        // Display store contents after removal
        System.out.println("\nStore contents after removing a DVD:");
        store.displayStore();

        // Attempt to remove a DVD that is not in the store
        DVD dvdNotInStore = new DVD("Unknown Title", "Genre", "Director", 100, 9.99f);
        store.removeDVD(dvdNotInStore);
    }
}
