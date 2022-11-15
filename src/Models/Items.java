package Models;

public class Items {
    private String id;
    private String name;
    private Itemcategory category;
    private double price;
    public Items(String id, String name, Itemcategory category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }
    public Items() {
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Itemcategory getCategory() {
        return category;
    }
    public void setCategory(Itemcategory category) {
        this.category = category;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
