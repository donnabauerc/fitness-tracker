package at.htl.entities;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "FT_EXERCISE")
public class Exercise extends PanacheEntity{

    public String name;
    public int sets;
    public ArrayList<Integer> reps;
    public ArrayList<Double> weight;

    public Exercise() {
        this.reps = new ArrayList<Integer>();
        this.weight = new ArrayList<Double>();
    }

    public Exercise(String name, ArrayList<Integer> reps, ArrayList<Double> weight) {
        this.name = name;
        this.reps = reps;
        this.sets = reps.size();
        this.weight = weight;
    }
        
}
