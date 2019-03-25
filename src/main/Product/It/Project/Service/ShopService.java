package It.Project.Service;

import It.Project.Dao.ShopDao;
import It.Project.Model.Shop;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/shop")
public class ShopService {

    @GET
    @Path("/{shopId}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Shop getShop_JSON(@HeaderParam("shopId") Integer id){
       System.out.println("Getting a shop");
        ShopDao shopDao = new ShopDao();
        Shop shop = shopDao.getShop(id);
        return shop;
    }


    @POST
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Shop addShop(Shop shop){
        System.out.println("Adding a shop");
        ShopDao shopDao = new ShopDao();
        shopDao.registerShop(shop);
        return shop;
    }


}
