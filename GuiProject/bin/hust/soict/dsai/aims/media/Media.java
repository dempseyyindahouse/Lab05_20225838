package hust.soict.dsai.aims.media;

public abstract class Media {
    // Fields
    private int id;
    private String title;
    private String category;
    private float cost;

    // Constructor
    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Getter and Setter methods (generated in Eclipse or written manually)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    // Override equals() to compare Media objects based on title
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

        // Cast the object to Media type for comparison
        Media otherMedia = (Media) obj;

        // Compare the titles of the two Media objects
        return this.title != null && this.title.equals(otherMedia.title);
    }

    // Override hashCode() to be consistent with equals()
    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }
    // Abstract method to be implemented by subclasses
    public abstract void displayInfo();
    public boolean isMatch(String title) {
        return this.getTitle().equalsIgnoreCase(title);
    }
    
}
