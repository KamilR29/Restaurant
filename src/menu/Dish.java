package menu;

public class Dish {

    private int number;
    private String name;
    private String description;
    private int price;
    private boolean available;

    public Dish(int number, String name, String description, int price, boolean available) {
        this.number = number;
        this.name = name;
        this.description = description;
        this.price = price;
        this.available = available;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }
}
