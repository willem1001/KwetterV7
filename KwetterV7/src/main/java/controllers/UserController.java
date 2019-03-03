package controllers;

import dao.UserDao;
import models.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/user")
@ApplicationScoped
public class UserController {

    @Inject
    private UserDao userDao;

    @POST
    @Path("/create")
    @Consumes("application/json")
    public Response createUser(User user) {
        userDao.createUser(user);
        return Response.ok(user).build();
    }

    @GET
    public List<User> getAllUsers() {
        List<User> users = userDao.getAllUsers();
        return users;
    }

    @GET
    @Path("/{id}")
    public Response geteUser(@PathParam("id") Long id) {
           User user = userDao.getUserById(id);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(user).build();
        }
    }
}
