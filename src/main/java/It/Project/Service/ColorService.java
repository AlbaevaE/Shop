//package It.Project.Service;
//
//import It.Project.Dao.ColorDao;
//import It.Project.Model.Color;
//
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//
//@Path("/color")
//public class ColorService {
//    @GET
//    @Path("{colorId}")
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public Color getColor_JSON(@PathParam("colorId") Integer colorId){
//        System.out.println("Getting color");
//        ColorDao colorDao = new ColorDao();
//        Color color = colorDao.getColor(colorId);
//        return color;
//    }
//}
