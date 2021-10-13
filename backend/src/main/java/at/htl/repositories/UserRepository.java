package at.htl.repositories;

import javax.enterprise.context.ApplicationScoped;

import at.htl.entities.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User>{
    
}
