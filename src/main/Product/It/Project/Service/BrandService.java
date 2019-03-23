package It.Project.Service;

import It.Project.Dao.BrandDao;
import It.Project.Model.Brand;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/brand")
public class BrandService {
    @GET
    @Path("/{brandId}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Brand getBrand_JSON(@PathParam("brandId") Integer brandId) {
        System.out.println("Getting Type");
        BrandDao brandDao = new BrandDao();
        return brandDao.getBrand(brandId);
    }

        @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Brand > getAllBrands_JSON() {
        BrandDao brandDao = new BrandDao();
            return (List<Brand>) brandDao.getAllBrands();
    }
    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Brand addBrand_Json(Brand brand) {
        BrandDao brandDao = new BrandDao();
        brandDao.addBrand(brand);
        return brand;
    }

    @DELETE
    @Path("/{brandId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public boolean deleteBrand_JSON(@PathParam("brandId") Integer brandId) {
        BrandDao brandDao = new BrandDao();
        brandDao.deleteBrands(brandId);
        return true;
    }
    @PUT
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Brand updateBrand_JSON(Brand brand){
        System.out.println("Updating brand");
        BrandDao brandDao = new BrandDao();
        brandDao.updateBrands(brand);
        return brand;
    }
}
