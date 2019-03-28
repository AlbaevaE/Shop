package It.Project.Service;


import It.Project.Dao.ItemDao;
import It.Project.Model.Item;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/item")
public class ItemService {

    @GET
    @Path("/{itemId}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Item getItem_JSON(@PathParam("itemId") Integer id){
        System.out.println("Getting a item");
        ItemDao itemDao = new ItemDao();
        return itemDao.getItem(id);
    }


    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Item> getAllItem(){
        System.out.println("Getting all items");
        ItemDao itemDao = new ItemDao();
        List<Item> items = itemDao.getAllItem();
        return items;
    }


    @POST
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Item addItem(Item item){
        System.out.println("Adding item");
        ItemDao itemDao = new ItemDao();
        return itemDao.addItem(item);
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Item updateItem(Item item){
        System.out.println("Updating item");
        ItemDao itemDao = new ItemDao();
        return itemDao.updateItem(item);
    }

    @DELETE
    @Path("/{itemId}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public boolean deleteItem(int id){
        System.out.println("Deleting item");
        ItemDao itemDao = new ItemDao();
        if(itemDao.deleteItem(id)){
            return true;
        }else return false;
    }

}
