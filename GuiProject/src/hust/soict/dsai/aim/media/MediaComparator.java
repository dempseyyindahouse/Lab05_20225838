package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparator implements Comparator<Media> {
    private boolean sortByTitleThenCost;

    // Constructor to determine sorting criteria
    public MediaComparator(boolean sortByTitleThenCost) {
        this.sortByTitleThenCost = sortByTitleThenCost;
    }

    @Override
    public int compare(Media m1, Media m2) {
        if (sortByTitleThenCost) {
            // Sort by title, then by cost (descending)
            int titleCompare = m1.getTitle().compareTo(m2.getTitle());
            return titleCompare != 0 ? titleCompare : Float.compare(m2.getCost(), m1.getCost());
        } else {
            // Sort by cost (descending), then by title
            int costCompare = Float.compare(m2.getCost(), m1.getCost());
            return costCompare != 0 ? costCompare : m1.getTitle().compareTo(m2.getTitle());
        }
    }
}
