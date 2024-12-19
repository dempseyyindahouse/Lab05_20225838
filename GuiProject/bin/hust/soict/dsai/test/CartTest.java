package hust.soict.dsai.test.cart;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DVD;

public class CartTest {
    public static void main(String[] args) {
        // Create a new cart
        Cart cart = new Cart();

        // Create new DVD objects and add them to the cart
        DVD dvd1 = new DVD("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DVD dvd2 = new DVD("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DVD dvd3 = new DVD("Aladdin", "Animation", "Guy Ritchie", 120, 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        // Test the print method
        cart.print();

        // Test search by ID
        System.out.println("\nSearch by ID (2):");
        cart.searchById(2);

        // Test search by Title
        System.out.println("\nSearch by Title (\"Aladdin\"):");
        cart.searchByTitle("Aladdin");

        System.out.println("\nSearch by Title (\"Unknown Title\"):");
        cart.searchByTitle("Unknown Title");
    }
}


