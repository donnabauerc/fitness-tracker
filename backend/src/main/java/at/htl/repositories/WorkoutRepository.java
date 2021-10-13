package at.htl.repositories;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import at.htl.entities.User;
import at.htl.entities.Workout;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class WorkoutRepository implements PanacheRepository<Workout>{
    
    public List<Workout> getLastWeeksWorkouts(User user) {
        return list("from Workout where user = ?1 and starttime >= ?2", user, LocalDateTime.now().minus(1, ChronoUnit.WEEKS));
    }
}
