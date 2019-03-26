package It.Project.Service;

import It.Project.Dao.ColorDao;

import It.Project.Model.Color;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.List;

@Path("/color")
public class ColorService {
    @GET
    @Path("{colorId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Color getColor_JSON(@PathParam("colorId") Integer colorId) {
        System.out.println("Getting color");
        ColorDao colorDao = new ColorDao();
        Color color = colorDao.getColor(colorId);
        return color;
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Color addColor_JSON(Color color) {
        System.out.println("Adding color");
        ColorDao colorDao = new ColorDao();
        colorDao.addColor(color);
        return color;
    }


    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Color updateColor_JSON(Color color) {
        System.out.println("Updating color");
        ColorDao colorDao = new ColorDao();
        colorDao.updateColor(color);
        return color;
    }

    @DELETE
    @Path("{deleteId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public boolean deleteGender(@PathParam("deleteId") Integer id) {
        System.out.println("Deleting color");
        ColorDao colorDao = new ColorDao();
        colorDao.deleteColor(id);
        return true;
    }


    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Color> getAllColors() {
        System.out.println("Getting all colors");
        ColorDao colorDao = new ColorDao();
        List<Color> colors = colorDao.getAllColor();
        return colors;
    }
}
