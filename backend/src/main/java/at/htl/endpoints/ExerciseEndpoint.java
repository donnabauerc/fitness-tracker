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

import at.htl.entities.Exercise;
import at.htl.repositories.ExerciseRepository;

@Path("/exercise")
public class ExerciseEndpoint {

    @Inject
    Logger log;

    @Inject
    ExerciseRepository exerciseRepository;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") long id) {
        log.info("Get By Id");
        return Response.ok(exerciseRepository.findById(id)).build();
    }

    @GET
    @Path("/listall")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAll() {
        log.info("ListAll Exercises");
        return Response.ok(exerciseRepository.listAll()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(Exercise exercise) {
        log.info("Create Exercise");
        exerciseRepository.getEntityManager().merge(exercise);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateExercise(Exercise exercise) {
        log.info("Update Exercise");
        exerciseRepository.getEntityManager().merge(exercise);
        return Response.ok(exercise).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public Response deleteById(@PathParam("id") long id) {
        log.info("Delete By Id");
        exerciseRepository.delete(exerciseRepository.findById(id));
        return Response.ok().build();
    }

    @GET
    @Path("/list-possibilities")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listDistinctNames() {
        log.info("List of Distinct Exercise names ");
        return Response.ok(exerciseRepository.listDistinctNames()).build();
    }
}
