package It.Project.Model;

import java.awt.*;

public class Accessories {
    int id;
    String name;
    Size size;
    Color color;
    int price;
    Season season;
    ToWhom toWhom;

    public Accessories() {
    }

    public Accessories(int id, String name, Size size, Color color, int price, Season season, ToWhom toWhom) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.color = color;
        this.price = price;
        this.season = season;
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

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public ToWhom getToWhom() {
        return toWhom;
    }

    public void setToWhom(ToWhom toWhom) {
        this.toWhom = toWhom;
    }
}
