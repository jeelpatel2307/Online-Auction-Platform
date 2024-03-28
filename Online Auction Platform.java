import java.util.HashMap;
import java.util.Map;

class Item {
    private final String name;
    private final String description;
    private double currentBid;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
        this.currentBid = 0.0;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(double currentBid) {
        this.currentBid = currentBid;
    }
}

class AuctionPlatform {
    private final Map<String, Item> items;

    public AuctionPlatform() {
        this.items = new HashMap<>();
    }

    public void addItem(String name, String description) {
        items.put(name, new Item(name, description));
    }

    public void placeBid(String itemName, double bidAmount) {
        Item item = items.get(itemName);
        if (item != null && bidAmount > item.getCurrentBid()) {
            item.setCurrentBid(bidAmount);
            System.out.println("Bid placed successfully for " + itemName + " at $" + bidAmount);
        } else {
            System.out.println("Failed to place bid for " + itemName + ". Please enter a higher bid.");
        }
    }

    public void displayItems() {
        System.out.println("Available Items:");
        for (Item item : items.values()) {
            System.out.println(item.getName() + " - " + item.getDescription() + " (Current Bid: $" + item.getCurrentBid() + ")");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        AuctionPlatform platform = new AuctionPlatform();

        // Add items to the auction platform
        platform.addItem("Painting", "Beautiful landscape painting");
        platform.addItem("Antique Watch", "Rare vintage wristwatch");

        // Display available items
        platform.displayItems();

        // Place bids
        platform.placeBid("Painting", 200.0);
        platform.placeBid("Antique Watch", 500.0);
        platform.placeBid("Antique Watch", 600.0);

        // Display updated bids
        platform.displayItems();
    }
}
