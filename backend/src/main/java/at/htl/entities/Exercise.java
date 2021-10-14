package at.htl.entities;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "FT_EXERCISE")
public class Exercise extends PanacheEntity{

    public String name;
    public int sets;
    public LinkedList<Integer> reps;
    public LinkedList<Double> weight;

    public Exercise() {
        this.sets = 0;
        this.reps = new LinkedList<Integer>();
        this.weight = new LinkedList<Double>();
    }

    public Exercise(String name, LinkedList<Integer> reps, LinkedList<Double> weight, int sets) {
        this.name = name;
        this.reps = reps;
        this.weight = weight;
        this.sets = sets;
    }
        
}
