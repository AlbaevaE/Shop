package It.Project.Service;


import It.Project.Dao.TypeDao;
import It.Project.Model.Type;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/type")
public class TypeService {
    @GET
    @Path("/{typeId}")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Type getType_JSON(@PathParam("typeId") Integer typeId){
        System.out.println("Getting Type");
        TypeDao typeDao = new TypeDao();
        Type type = typeDao.getType(typeId);
        return type;
    }
}
