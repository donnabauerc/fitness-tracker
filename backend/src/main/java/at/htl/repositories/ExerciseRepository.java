package at.htl.repositories;

import javax.enterprise.context.ApplicationScoped;

import at.htl.entities.Exercise;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ExerciseRepository implements PanacheRepository<Exercise>{
    
}
