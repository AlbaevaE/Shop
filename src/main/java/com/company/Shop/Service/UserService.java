package com.company.Shop.Service;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.company.Shop.Dao.UserDao;
import com.company.Shop.Model.User;

import java.rmi.MarshalException;
import java.util.List;

@Path("/users")
public class UserService {
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<User> getUsers_JSON(){
        System.out.println("Getting users");
        List<User> users = UserDao.getAllUsers();
        return users;
    }

    @GET
    @Path("{userId}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public User getUser_JSON(@HeaderParam("userId") Integer id){
        return UserDao.getUser(id);
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public  User addUser(User user){
        return UserDao.addUSer(user);
    }


    @POST
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public  User updateUser(User user){
        return UserDao.updateUser(user);
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public void deleteUser(Integer id){
        UserDao.deleteUser(id);
    }
}
