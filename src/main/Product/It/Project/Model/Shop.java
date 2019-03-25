package It.Project.Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="shop")
@XmlAccessorType(XmlAccessType.FIELD)
public class Shop {
    int id;
    String name;
    String password;
    String number;
    String adress;
    String email;
    String newPassword;

    public Shop(int id, String name, String password, String number, String adress, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.number = number;
        this.adress = adress;
        this.email = email;
    }

    public Shop(int id, String name, String password, String number, String adress, String email, String newPassword) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.number = number;
        this.adress = adress;
        this.email = email;
        this.newPassword = newPassword;
    }

    public Shop(){

    }

    public Shop(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", number='" + number + '\'' +
                ", adress='" + adress + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
