package It.Project.Service;

import It.Project.Dao.SizeDao;
import It.Project.Model.Size;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/size")
public class SizeService {

    @GET
    @Path("/{sizeId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Size getSize(@PathParam("sizeId") Integer sizeId) {
        SizeDao sizeDao = new SizeDao();
        Size size = sizeDao.getSize(sizeId);
        return size;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Size>getAllSizes(){
        SizeDao sizeDao = new SizeDao();
        List<Size>sizes = sizeDao.getAllSizes();
        return sizes;
    }


//    @GET
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public Size getSizeName_JSON(@PathParam("sizeName") String allSize) {
//        SizeDao sizeDao = new SizeDao();
//        Size size = sizeDao.getSizesName(allSize);
//        return size;
//
//    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON})
    public Size updateSize_JSON(Size size) {
        SizeDao sizeDao = new SizeDao();
        sizeDao.updateSize(size);
        return size;
    }

    @DELETE
    @Path("/{sizeId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public boolean deleteSize_JSON(@PathParam("sizeId") Integer sizeId) {
        SizeDao sizeDao = new SizeDao();
        sizeDao.deleteSize(sizeId);
        return true;

    }
    @POST
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Size addSize_Json(Size sizes) {
        SizeDao sizeDao = new SizeDao();
       sizeDao.addSize(sizes);
       return sizes;
    }
}
