package me.karunarathne.learningspringboot.clientproxy;

import me.karunarathne.learningspringboot.model.User;
import me.karunarathne.learningspringboot.resource.ErrorMessage;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

public interface UserResourceV1 {
    @GET
    @Produces(APPLICATION_JSON)
    List<User> fetchUsers (@QueryParam("gender") String gender) ;

    @GET
    @Produces (MediaType.APPLICATION_JSON)
    @Path("{userUid}")
    Response fetchUser (@PathParam("userUid") UUID userUid) ;

    @POST
    @Consumes (MediaType.APPLICATION_JSON)
    @Produces (MediaType.APPLICATION_JSON)
    Response insertNewUser (User user) ;

    @PUT
    @Consumes (MediaType.APPLICATION_JSON)
    @Produces (MediaType.APPLICATION_JSON)
    Response updateUser (User user) ;

    @DELETE
    @Produces (MediaType.APPLICATION_JSON)
    @Path ("{userUid}")
    Response deleteUser (@PathParam ("userUid") UUID userUid) ;
}
