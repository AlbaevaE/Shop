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
    String parentTypeId;

    public TypeProduct() {
    }

    public TypeProduct(int id, String name, String parentTypeId) {
        this.id = id;
        this.name = name;
        this.parentTypeId = parentTypeId;
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

    public String getParentTypeId() {
        return parentTypeId;
    }

    public void setParentTypeId(String parentTypeId) {
        this.parentTypeId = parentTypeId;
    }
}