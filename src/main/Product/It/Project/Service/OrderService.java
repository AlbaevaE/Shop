package It.Project.Service;

import It.Project.Dao.OrdersDao;
import It.Project.Dao.TypeDao;
import It.Project.Model.Order;
import It.Project.Model.Type;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/order")
public class OrderService {
    @GET
    @Path("/{orderId}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Order getOrder_JSON(@PathParam("orderId") Integer orderId){
        System.out.println("Getting Type");
        OrdersDao ordersDao= new OrdersDao();
        Order order = ordersDao.getOrder(orderId);
        return order;
    }
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Order> getAllorders_JSON(){
        System.out.println("Getting all orders");
        OrdersDao ordersDao= new OrdersDao();
        List<Order> orders = ordersDao.getAllOrders();
        return orders;
    }
    @POST
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Order addOrder_JSON(Order order){
        System.out.println("Adding order");
        OrdersDao ordersDao= new OrdersDao();
        return ordersDao.addOrder(order);
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Order updateOrder_JSON(Order order){
        System.out.printf("Updating order");
        OrdersDao ordersDao= new OrdersDao();
        return ordersDao.updateOrder(order);
    }

    @DELETE
    @Path("{deleteId}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public boolean deleteOrder(@PathParam("deleteId") Integer deleteId){
        System.out.printf("Deleting order");
        OrdersDao ordersDao= new OrdersDao();
        ordersDao.deleteOrders(deleteId);
        return true;
    }

}
