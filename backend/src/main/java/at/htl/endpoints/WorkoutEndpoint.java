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
import at.htl.entities.Workout;
import at.htl.repositories.UserRepository;
import at.htl.repositories.WorkoutRepository;

@Path("/workout")
public class WorkoutEndpoint {

    @Inject
    Logger log;

    @Inject
    WorkoutRepository workoutRepository;

    @Inject
    UserRepository userRepository;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") long id) {
        log.info("Get By Id");
        return Response.ok(workoutRepository.findById(id)).build();
    }

    @GET
    @Path("/listall")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAll() {
        log.info("ListAll Workouts");
        return Response.ok(workoutRepository.listAll()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(Workout workout) {
        log.info("Create Workout");
        workoutRepository.getEntityManager().merge(workout);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateWorkout(Workout workout) {
        log.info("Update Workout");
        workoutRepository.getEntityManager().merge(workout);
        return Response.ok(workout).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public Response deleteById(@PathParam("id") long id) {
        log.info("Delete By Id");
        workoutRepository.delete(workoutRepository.findById(id));
        return Response.ok().build();
    }

    @GET
    @Path("/last-week/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response lastWeekWorkouts(@PathParam("userId")long id) {
        log.info("Get last Week Workouts");
        return Response.ok(workoutRepository.getLastWeeksWorkouts(userRepository.findById(id))).build();
    }
}
