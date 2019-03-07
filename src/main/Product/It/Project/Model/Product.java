package It.Project.Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.awt.*;
@XmlRootElement(name="product")
@XmlAccessorType(XmlAccessType.FIELD)

public class Product {
    Clothes clothes;
    Footwear footwear;
    Accessories accessories;

    public Product() {
    }

    public Product(Clothes clothes, Footwear footwear, Accessories accessories) {
        this.clothes = clothes;
        this.footwear = footwear;
        this.accessories = accessories;
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
    }

    public Accessories getAccessories() {
        return accessories;
    }

    public void setAccessories(Accessories accessories) {
        this.accessories = accessories;
    }
}




