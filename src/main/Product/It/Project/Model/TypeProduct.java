package It.Project.Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.awt.*;
@XmlRootElement(name="typeProduct")
@XmlAccessorType(XmlAccessType.FIELD)

public class TypeProduct {

    int id;
    String name;
    PreType preType;

    public TypeProduct() {
    }

    public TypeProduct(int id, String name, PreType preType) {
        this.id = id;
        this.name = name;
        this.preType = preType;
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

    public PreType getPreType() {
        return preType;
    }

    public void setPreType(PreType preType) {
        this.preType = preType;
    }
}
