package It.Project.Service;



import It.Project.Dao.TypeDao;
import It.Project.Model.Type;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/type")
public class TypeService {
    @GET
    @Path("/{typeId}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Type getType_JSON(@PathParam("typeId") Integer typeId){
        System.out.println("Getting Type");
        TypeDao typeDao = new TypeDao();
        Type type = typeDao.getType(typeId);
        return type;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Type> getAllType_JSON(){
        System.out.println("Getting all types");
        TypeDao typeDao = new TypeDao();
        List<Type> types = typeDao.getAllType();
        return types;
    }


    @POST
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Type addType_JSON(Type type){
        System.out.println("Adding type");
        TypeDao typeDao = new TypeDao();
        return typeDao.addType(type);
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Type updateType_JSON(Type type){
        System.out.printf("Updating type");
        TypeDao typeDao = new TypeDao();
        return typeDao.updateType(type);
    }

    @DELETE
    @Path("{deleteId}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public boolean deleteType(@PathParam("deleteId") Integer deleteId){
        System.out.printf("Deleting type");
        TypeDao typeDao = new TypeDao();
        if(typeDao.deleteType(deleteId)){
            return true;
        }else return false;
    }



}
