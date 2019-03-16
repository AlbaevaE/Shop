package It.Project.Service;

import It.Project.Dao.ShopDao;
import It.Project.Model.Shop;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/shop")

public class ShopService {
    @GET
    @Path("{shopInfo}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Shop getShopInfo_JSON(@PathParam("shopInfo") String info) {
        ShopDao shopDao = new ShopDao();
        Shop shop = shopDao.getShopInfo(info);
        return shop;
    }

}
