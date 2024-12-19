package hust.soict.dsai.aims.media;

public class DVD extends Media implements Playable {
    private String director;
    private int length;

    // Constructor
    public DVD(int id, String title, String category, float cost, String director, int length) {
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }

    // Getters and Setters for DVD-specific fields
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    // Overriding displayInfo method from Media
    @Override
    public void displayInfo() {
        System.out.println("DVD ID: " + getId());
        System.out.println("Title: " + getTitle());
        System.out.println("Category: " + getCategory());
        System.out.println("Cost: " + getCost() + " $");
        System.out.println("Director: " + director);
        System.out.println("Length: " + length + " minutes");
    }

    // Implement the play method from Playable interface
    @Override
    public void play() {
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("DVD Length: " + getLength() + " minutes");
    }
 // Overloaded constructor without id
    public DVD(String title, String category, String director, int length, float cost) {
        super(0, title, category, cost); // Default id = 0 for simplicity
        this.director = director;
        this.length = length;
    }

}
