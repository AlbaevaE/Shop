package It.Project.Service;

import It.Project.Dao.ShopDao;
import It.Project.Model.Shop;

import It.Project.Dao.ShopDao;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/shop")
public class ShopService {
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Shop> getShop_JSON() {
        System.out.println("getting shop");
        ShopDao shopDao = new ShopDao();
        List<Shop> shops = shopDao.getAllShop();
        return shops;
    }

    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Shop getShop(@PathParam("/shopId") Integer shopId) {
        return ShopDao.getShop(shopId);
    }

    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Shop addShop(Shop shop) {
        return ShopDao.addShop(shop);
    }

    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Shop updateShop(Shop shop){
        return ShopDao.updateShop(shop);
    }

    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteShop(@PathParam("shopId")Integer shopId){
        ShopDao.deleteShop(shopId);
    }

}
