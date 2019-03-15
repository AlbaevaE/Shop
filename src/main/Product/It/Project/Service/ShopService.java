package It.Project.Service;

import It.Project.Dao.ShopDao;
import It.Project.Model.Shop;
import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.List;

@Path("/shop")
public class ShopService {
    @Get
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Shop> getShop_JSON() {
        System.out.println("getting shop");
        List<Shop> shops = ShopDao.getAllShop;
        return shops;
    }

    @Get
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Shop getShop(@PathParam("/shopId") Integer shopId) {
        return ShopDao.getShop(shopId);
    }

    @Get
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Shop addShop(Shop shop) {
        return ShopDao.addShop(shop);
    }

    @Get
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Shop updateShop(Shop shop){
        return ShopDao.updateShop(shop);
    }

    @Get
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteShop(@PathParam("shopId")Integer shopId){
        ShopDao.deleteShop(shopId);
    }

}

