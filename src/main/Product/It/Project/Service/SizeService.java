package It.Project.Service;


import It.Project.Dao.SizeDao;
import It.Project.Model.Size;

import java.awt.*;
import java.util.List;

@Path("/size")

public class SizeService {
    @Get
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Size> getSize_JSON(){
        System.out.println("Getting size");
        List<Size>sizes = SizeDao.getAllSizes();
        return sizes;
    }


}
