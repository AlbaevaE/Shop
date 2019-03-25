package It.Project.Service;

import It.Project.Dao.SeasonDao;
import It.Project.Model.Season;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/season")
public class SeasonService {
    @GET
    @Path("/{seasonId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public Season getSeason(@PathParam("seasonId") Integer seasonId) {
        SeasonDao seasonDao = new SeasonDao();
        Season season = seasonDao.getSeason(seasonId);
        return season;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Season> getAllSeason() {
        SeasonDao seasonDao = new SeasonDao();
        List<Season> seasons = seasonDao.getAllSeason();
        return seasons;
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Season updateSeason_JSON(Season season) {
        SeasonDao seasonDao = new SeasonDao();
        seasonDao.updateSeason(season);
        return season;
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Season addSeason_JSON(Season season) {
        SeasonDao seasonDao = new SeasonDao();
        seasonDao.addSeason(season);
        return season;
    }

    @DELETE
    @Path("/{seasonId}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public boolean deleteSeason_JSON(@PathParam("seasonId")Integer seasonId){
        SeasonDao seasonDao = new SeasonDao();
        seasonDao.deleteSeason(seasonId);
        return true;
    }

}
