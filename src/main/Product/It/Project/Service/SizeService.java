package It.Project.Service;

import It.Project.Dao.SizeDao;
import It.Project.Model.Size;
import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.List;

@Path("size")
public class SizeService {
    @Get
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Size> getSize_JSON() {
        List<Size> size = SizeDao.getAllSize();
        return size;
    }

    @Get
    @Path("/{sizeId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Size getSize(@PathParam("sizeId") Integer sizeId) {
        return SizeDao.getSize(sizeId);
    }
}
