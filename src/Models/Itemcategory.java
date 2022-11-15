package Models;

public class Itemcategory {
    private String ItemCategoryId;
    private String ItemCategoryName;

    public Itemcategory() {
    }

    public String getItemcategoryId() {
        return ItemCategoryId;
    }

    public void setItemcategoryId(String ItemCategoryId) {
        this.ItemCategoryId = ItemCategoryId;
    }

    public String getItemcategoryName() {
        return ItemCategoryName;
    }

    public void setItemcategoryName(String ItemCategoryName) {
        this.ItemCategoryName = ItemCategoryName;
    }

    public String toString() {
        return "ItemCategory{" +
                "ItemCategoryId=" + ItemCategoryId +
                ", ItemCategoryName='" + ItemCategoryName + '\'' +
                '}';
    }
}
