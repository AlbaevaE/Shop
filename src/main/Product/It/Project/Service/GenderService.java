package It.Project.Service;


import It.Project.Dao.GenderDao;
import It.Project.Model.Gender;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

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

    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Gender addGender_JSON(Gender gender){
        System.out.println("Adding a gender");
        GenderDao genderDao = new GenderDao();
        genderDao.addGender(gender);
        return gender;
    }

    @PUT
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Gender updateGender_JSON(Gender gender){
        System.out.println("Updating gender");
        GenderDao genderDao = new GenderDao();
        genderDao.updateGender(gender);
        return gender;
    }

    @DELETE
    @Path("{deleteId}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public boolean deleteGender(@PathParam("deleteId") Integer id){
        System.out.println("Deleting gender");
        GenderDao genderDao = new GenderDao();
        genderDao.deleteGender(id);
        return true;
    }

    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public List<Gender> getAllGenders(){
        System.out.println("Getting all genders");
        GenderDao genderDao = new GenderDao();
        List<Gender> genders = genderDao.getAllGender();
        return genders;
    }


}
