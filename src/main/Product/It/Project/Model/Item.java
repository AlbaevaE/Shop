package It.Project.Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.awt.*;
@XmlRootElement(name="item")
@XmlAccessorType(XmlAccessType.FIELD)

public class Item {
    int id;
    String name;
    TypeProduct typeProduct;
    Brand brand;
    Color color;
    Size size;
    Season season;
    int price;
    Shop shop;
    ToWhom toWhom;

    public Item() {
    }

    public Item(int id, String name, TypeProduct typeProduct, Brand brand, Color color, Size size,
                Season season, int price, Shop shop, ToWhom toWhom) {
        this.id = id;
        this.name = name;
        this.typeProduct = typeProduct;
        this.brand = brand;
        this.color = color;
        this.size = size;
        this.season = season;
        this.price = price;
        this.shop = shop;
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

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public ToWhom getToWhom() {
        return toWhom;
    }

    public void setToWhom(ToWhom toWhom) {
        this.toWhom = toWhom;
    }
}
