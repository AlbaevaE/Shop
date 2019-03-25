package It.Project.Service;

import It.Project.Dao.ShopDao;
import It.Project.Model.Shop;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


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


    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Shop> getAllShop(){
        System.out.println("Getting all shops");
        ShopDao shopDao = new ShopDao();
        List<Shop> shops = shopDao.getAllShop();
        return shops;
    }
    @POST
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Shop addShop_JSON(Shop shop){
        System.out.println("Adding a shop");
        ShopDao shopDao = new ShopDao();
        shopDao.registerShop(shop);
        return shop;
    }

    @PUT
    @Path("/updateShop")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Shop updateShop_JSON(Shop shop){
        System.out.println("Updating a shop");
        ShopDao shopDao = new ShopDao();
        shopDao.updateShop(shop);
        return shop;
    }

    @PUT
    @Path("/updatePasswords")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Shop updatePassword_JSON(Shop shop){
        System.out.println("Updating password of Shop");
        ShopDao shopDao = new ShopDao();
        shopDao.updatePasswordOfShop(shop);
        return shop;
    }

    @DELETE
    @Path("/{deleteId}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public boolean deleteShop_JSON(@HeaderParam("deleteId") Integer id){
        System.out.println("Deleting a shop");
        ShopDao shopDao  = new ShopDao();
        if(shopDao.deleteShop(id)){
            return true;
        }else return false;
    }

}
