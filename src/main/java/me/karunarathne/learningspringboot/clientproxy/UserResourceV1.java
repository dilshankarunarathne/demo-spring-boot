package me.karunarathne.learningspringboot.clientproxy;

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
