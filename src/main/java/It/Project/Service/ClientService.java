package It.Project.Service;

import It.Project.Dao.ClientDao;
import It.Project.Model.Client;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/client")
public class ClientService {
    @GET
    @Path("/{clientId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Client getClient(@PathParam("clientId") Integer clientId) {
        ClientDao clientDao = new ClientDao();
        Client client = clientDao.getClient(clientId);
        return client;
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Client addClient_JSON(Client client) {
        ClientDao clientDao = new ClientDao();
        clientDao.addClient(client);
        return client;

    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Client updateClient_JSON(Client client) {
        ClientDao clientDao = new ClientDao();
        clientDao.updateClient(client);
        return client;
    }

    @DELETE
    @Path("/{clientId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public boolean deleteClient_JSON(@PathParam("clientId") Integer clientId) {
        ClientDao clientDao = new ClientDao();
        if(clientDao.deleteClient(clientId)){
            return true;
        }else return false;
    }
}
