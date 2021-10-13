package at.htl.endpoints;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.logging.Logger;

import at.htl.entities.User;
import at.htl.repositories.UserRepository;

@Path("/user")
public class UserEndpoint {

    @Inject
    Logger log;

    @Inject
    UserRepository userRepository;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") long id) {
        log.info("Get By Id");
        return Response.ok(userRepository.findById(id)).build();
    }

    @GET
    @Path("/listall")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAll() {
        log.info("ListAll User");
        return Response.ok(userRepository.listAll()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(User user) {
        log.info("Create User");
        userRepository.getEntityManager().merge(user);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateExercise(User user) {
        log.info("Update User");
        userRepository.getEntityManager().merge(user);
        return Response.ok(user).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public Response deleteById(@PathParam("id") long id) {
        log.info("Delete By Id");
        userRepository.delete(userRepository.findById(id));
        return Response.ok().build();
    }
    
}
