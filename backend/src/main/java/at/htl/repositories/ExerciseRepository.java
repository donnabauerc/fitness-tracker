package at.htl.repositories;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import at.htl.entities.Exercise;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ExerciseRepository implements PanacheRepository<Exercise>{
    public List<String> listDistinctNames() {
        return listAll()
            .stream()
            .map(e -> e.name)
            .distinct()
            .collect(Collectors.toList());
    }
}
