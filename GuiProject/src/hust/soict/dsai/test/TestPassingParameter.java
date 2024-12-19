package hust.soict.dsai.test.disc;
import hust.soict.dsai.aims.media.DVD;

public class TestPassingParameter {
    
    public static void swap(DVD[] dvds) {
        if (dvds.length == 2) {
        	DVD temp = dvds[0];
            dvds[0] = dvds[1];
            dvds[1] = temp;
        }
    }
    public static void swap(DVD o1, DVD o2) {
        DVD temp = o1;  // Copy o1 reference into temp
        o1 = o2;        // Point o1 to o2
        o2 = temp;      // Point o2 to temp (original o1)
    }

    // Method to change the title of a DVD
    public static void changeTitle(DVD dvd, String newTitle) {
        dvd.setTitle(newTitle);  // Use the setter to update the title
    }
}
