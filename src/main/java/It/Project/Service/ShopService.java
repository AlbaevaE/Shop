package It.Project.Service;

import It.Project.Dao.ShopDao;
import It.Project.Model.Shop;


import javax.ws.rs.*;
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

    @GET
    @Path("/{shopId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Shop getShop(@PathParam("shopId") Integer shopId) {
        ShopDao shopDao = new ShopDao();
        return shopDao.getShop(shopId);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public boolean addShop(Shop shop) {
        ShopDao shopDao = new ShopDao();
        return shopDao.registerShop(shop);
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Shop updateShop(Shop shop){
        ShopDao shopDao = new ShopDao();
        return shopDao.updateShop(shop);
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Shop updateShopPassword(Shop shop){
        ShopDao shopDao = new ShopDao();
        return shopDao.updatePasswordOfShop(shop);
    }


    @DELETE
    @Path("/{shopId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteShop(@PathParam("shopId")Integer shopId){
        ShopDao shopDao = new ShopDao();
        shopDao.deleteShop(shopId);
    }

}
