package hust.soict.dsai.aims.media;

public class Disc extends Media {
    private int length; // Length of the disc in minutes
    private String director;

    // Constructor
    public Disc(int id, String title, String category, float cost, String director, int length) {
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }

    // Getters and Setters
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    // Overriding displayInfo() to show information about the disc
    @Override
    public void displayInfo() {
        System.out.println("Disc ID: " + getId());
        System.out.println("Title: " + getTitle());
        System.out.println("Category: " + getCategory());
        System.out.println("Cost: " + getCost());
        System.out.println("Director: " + director);
        System.out.println("Length: " + length + " minutes");
    }
}
