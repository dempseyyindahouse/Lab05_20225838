package hust.soict.globalict.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.DVD;
import hust.soict.dsai.aims.media.Book;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class StoreScreen extends Application {
    private Cart cart;
    private ArrayList<Media> storeItems; // List of store items

    // Default constructor required for JavaFX Application
    public StoreScreen() {
        this.cart = new Cart();
        this.storeItems = new ArrayList<>();
        prepopulateStore(); // Add sample items to the store
    }

    // Constructor for custom cart injection
    public StoreScreen(Cart cart) {
        this.cart = cart;
        this.storeItems = new ArrayList<>();
        prepopulateStore(); // Add sample items to the store
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        // Title Bar
        HBox titleBar = new HBox();
        Label title = new Label("AIMS Store");
        title.setStyle("-fx-font-size: 24; -fx-font-weight: bold;");
        Button viewCartButton = new Button("View Cart");

        // Navigate to CartScreen
        viewCartButton.setOnAction(e -> {
            CartScreen cartScreen = new CartScreen(cart); // Pass the existing cart
            try {
                cartScreen.start(primaryStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        titleBar.getChildren().addAll(title, viewCartButton);
        titleBar.setSpacing(20);

        root.setTop(titleBar);

        // Display Store Items (Center)
        VBox storeItemsBox = new VBox(10);
        for (Media media : storeItems) {
            HBox itemBox = createMediaBox(media);
            storeItemsBox.getChildren().add(itemBox);
        }
        ScrollPane scrollPane = new ScrollPane(storeItemsBox);
        root.setCenter(scrollPane);

        // Scene setup
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Store Screen");
        primaryStage.show();
    }

    private void prepopulateStore() {
        // Add sample items to the store
        storeItems.add(new DVD("Inception", "Sci-Fi", "Christopher Nolan", 120, 19.99f));
        storeItems.add(new Book("Effective Java", "Programming", 45.0f));
        storeItems.add(new DVD("The Dark Knight", "Action", "Christopher Nolan", 152, 14.99f));
    }

    private HBox createMediaBox(Media media) {
        HBox hbox = new HBox(10);

        // Display Media details
        Label mediaLabel = new Label(media.getTitle() + " - $" + media.getCost());

        // Add to Cart button
        Button addToCartButton = new Button("Add to Cart");
        addToCartButton.setOnAction(e -> {
            cart.addMedia(media);
            System.out.println(media.getTitle() + " added to cart.");
        });

        hbox.getChildren().addAll(mediaLabel, addToCartButton);
        return hbox;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
