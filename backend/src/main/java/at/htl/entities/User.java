package at.htl.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "FT_USER")
public class User extends PanacheEntity{

    public String username;
    public String firstname;
    public String lastname;
    public String email;

    public User() {
    }
    public User(String username, String firstname, String lastname, String email) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

}
