package It.Project.Service;

import It.Project.Dao.SizeDao;
import It.Project.Model.Size;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


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
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Size getSizeName_JSON(@PathParam("sizeName") String allSize) {
        SizeDao sizeDao = new SizeDao();
        Size size = sizeDao.getSizesName(allSize);
        return size;

    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Size updateSize_JSON(@PathParam("size") Size size) {
        SizeDao sizeDao = new SizeDao();
        Size size1 = sizeDao.updateSize(size);
        return size1;
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
        Size size = sizeDao.addSize(sizes);
        return size;
    }
}
