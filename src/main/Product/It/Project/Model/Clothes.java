package It.Project.Model;

import java.awt.*;

public class Clothes {
    int id;
    String name;
    String brand;
    Size size;
    Color color;
    int price;
    ToWhom toWhom;

    public Clothes() {
    }

    public Clothes(int id, String name, String brand, Size size, Color color, int price, ToWhom toWhom) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.size = size;
        this.color = color;
        this.price = price;
        this.toWhom = toWhom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ToWhom getToWhom() {
        return toWhom;
    }

    public void setToWhom(ToWhom toWhom) {
        this.toWhom = toWhom;
    }
}
