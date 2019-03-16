package It.Project.Service;

import It.Project.Dao.SizeDao;
import It.Project.Model.Size;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/size")
public class SizeService {

    @GET
    @Path("/{sizeId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Size getSize(@PathParam("sizeId") Integer sizeId) {
        SizeDao sizeDao =  new SizeDao();
        Size size = sizeDao.getSize(sizeId);
        return size;
    }


    //    @GET
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public List<Size> getSize_JSON() {
//
//        List<Size> size = SizeDao.getAllSizes();
//        return size;
//    }
}
