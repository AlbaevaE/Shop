package It.Project.Service;


import It.Project.Dao.GenderDao;
import It.Project.Model.Gender;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/gender")
public class GenderService {
    @GET
    @Path("{genderId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Gender getGender_JSON(@PathParam("genderId") Integer genderId){
        System.out.println("Getting gender");
        GenderDao genderDao = new GenderDao();
        Gender gender = genderDao.getGender(genderId);
        return gender;
    }
}
