package It.Project.Model;

import java.awt.*;

public class Product {
    Clothes clothes;
    Footwear footwear;

    public Product() {
    }

    public Product(Clothes clothes, Footwear footwear) {
        this.clothes = clothes;
        this.footwear = footwear;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public Footwear getFootwear() {
        return footwear;
    }

    public void setFootwear(Footwear footwear) {
        this.footwear = footwear;
    }//
}




