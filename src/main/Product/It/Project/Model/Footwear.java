package It.Project.Model;

import java.awt.*;

public class Footwear {
    int id;
    String name;
    Size size;
    String brand;
    Color color;
    int price;
    ToWhom toWhom;

    public Footwear() {
    }

    public Footwear(int id, String name, Size size, String brand, Color color, int price, ToWhom toWhom) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.brand = brand;
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

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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
