package It.Project.Model;

public class Order {
   private int  id;
    private double discount;
    private int clientId;

    public Order(int id, double discount, int clientId) {
        this.id = id;
        this.discount = discount;
        this.clientId = clientId;
    }

    public Order() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", discount=" + discount +
                ", clientId=" + clientId +
                '}';
    }
}
