package com.company.Shop.Service;


import com.company.Shop.Dao.CoWorkerDao;
import com.company.Shop.Model.CoWorker;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;

@Path("/coWorkers")
public class CoWorkerService {

    @GET
    @Path("{coWorkerId}")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public CoWorker getCoWorker_JSON(@HeaderParam("coWorkerId") Integer id){
        return CoWorkerDao.getCoWorker(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON ,MediaType.APPLICATION_XML})
    public CoWorker updateCoWorker_JSON(CoWorker coWorker){
        return CoWorkerDao.updateCoWorker(coWorker);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public CoWorker addCoWorker(CoWorker coWorker){
        return CoWorkerDao.addCoWorker(coWorker);
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public void deleteCoWorker(Integer id){
        CoWorkerDao.deleteCoWorker(id);
    }
}
