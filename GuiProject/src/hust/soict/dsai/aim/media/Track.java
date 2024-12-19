package hust.soict.dsai.aims.media;

public class Track implements Playable {
    private String title;
    private int length; // Length in minutes

    // Constructor
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    // Overriding toString() method for Track details
    @Override
    public String toString() {
        return "Track: " + title + " - " + length + " mins";
    }

    // Implement the play method from Playable interface
    @Override
    public void play() {
        System.out.println("Playing Track: " + getTitle());
        System.out.println("Track Length: " + getLength() + " minutes");
    }
    @Override
    public boolean equals(Object obj) {
        // If the object is compared with itself
        if (this == obj) {
            return true;
        }

        // If the object is not of the same type
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        // Cast the object to Track type for comparison
        Track otherTrack = (Track) obj;

        // Compare the title and length of the two Track objects
        return this.title != null && this.title.equals(otherTrack.title) && this.length == otherTrack.length;
    }

    // Override hashCode() to be consistent with equals()
    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + length;
        return result;
    }
}
