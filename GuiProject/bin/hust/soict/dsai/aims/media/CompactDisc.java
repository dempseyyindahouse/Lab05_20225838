package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks;

    // Constructor
    public CompactDisc(int id, String title, String category, float cost, String director, int length, String artist) {
        super(id, title, category, cost, director, length);
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }

    // Getter for artist
    public String getArtist() {
        return artist;
    }

    // Add track to the CD
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        } else {
            System.out.println("Track already exists.");
        }
    }

    // Remove track from the CD
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.out.println("Track not found.");
        }
    }

    // Get the total length of the CD by summing the lengths of its tracks
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    // Overriding displayInfo() to show CD-specific details
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call the parent class method
        System.out.println("Artist: " + artist);
        System.out.println("Total Length of CD: " + getLength() + " minutes");
        System.out.println("Tracks: ");
        for (Track track : tracks) {
            System.out.println(track.toString());
        }
    }

    // Implement the play method from Playable interface
    @Override
    public void play() {
        System.out.println("Playing Compact Disc: " + getTitle());
        System.out.println("Artist: " + artist);
        System.out.println("Total Length: " + getLength() + " minutes");

        // Play each track on the CD
        for (Track track : tracks) {
            track.play(); // Call the play method of each track
        }
    }
}
