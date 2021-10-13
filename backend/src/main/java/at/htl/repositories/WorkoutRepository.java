package at.htl.repositories;

import javax.enterprise.context.ApplicationScoped;

import at.htl.entities.Workout;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class WorkoutRepository implements PanacheRepository<Workout>{
    
}
