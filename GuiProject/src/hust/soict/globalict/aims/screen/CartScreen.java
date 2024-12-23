package hust.soict.globalict.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CartScreen extends Application {
    private Cart cart;
    private VBox cartItemsBox; // Box to hold cart items dynamically
    private Label totalCostLabel; // Label to display the total cost

    // Default no-argument constructor required by JavaFX
    public CartScreen() {
        this.cart = new Cart(); // Initialize cart if no argument is passed
    }

    // Constructor to accept an existing Cart
    public CartScreen(Cart cart) {
        this.cart = cart;
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        // Title Bar
        HBox titleBar = new HBox();
        Label title = new Label("Cart Details");
        title.setStyle("-fx-font-size: 24; -fx-font-weight: bold;");
        Button backButton = new Button("Back to Store");

        // Navigate back to StoreScreen
        backButton.setOnAction(e -> {
            StoreScreen storeScreen = new StoreScreen(cart); // Pass the same cart
            try {
                storeScreen.start(primaryStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        titleBar.getChildren().addAll(title, backButton);
        titleBar.setSpacing(20);
        root.setTop(titleBar);

        // Cart Items (Center)
        cartItemsBox = new VBox(10);
        ScrollPane scrollPane = new ScrollPane(cartItemsBox);
        root.setCenter(scrollPane);

        // Footer: Total Cost
        HBox footer = new HBox();
        totalCostLabel = new Label("Total Cost: $" + cart.totalCost());
        totalCostLabel.setStyle("-fx-font-size: 16; -fx-font-weight: bold;");
        footer.getChildren().add(totalCostLabel);
        footer.setSpacing(20);
        root.setBottom(footer);

        // Populate cart items dynamically
        updateCartItems();

        // Scene setup
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Cart Screen");
        primaryStage.show();
    }

    private void updateCartItems() {
        cartItemsBox.getChildren().clear(); // Clear existing items
        for (Media media : cart.getItemsOrdered()) {
            HBox itemBox = createMediaBox(media);
            cartItemsBox.getChildren().add(itemBox);
        }
        updateTotalCost(); // Update the total cost
    }

    private HBox createMediaBox(Media media) {
        HBox hbox = new HBox(10);

        // Display Media details
        Label mediaLabel = new Label(media.getTitle() + " - $" + media.getCost());

        // Remove button
        Button removeButton = new Button("Remove");
        removeButton.setOnAction(e -> {
            cart.removeMedia(media); // Remove media from cart
            System.out.println(media.getTitle() + " removed from cart.");
            updateCartItems(); // Update UI after removal
        });

        hbox.getChildren().addAll(mediaLabel, removeButton);
        return hbox;
    }

    private void updateTotalCost() {
        if (totalCostLabel != null) { // Ensure totalCostLabel is initialized
            totalCostLabel.setText("Total Cost: $" + cart.totalCost());
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
