package at.htl.entities;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "FT_WORKOUT")
public class Workout extends PanacheEntity{

    public LocalDateTime starttime;
    public LocalDateTime endtime;
    public int duration;
    public int calories;
    public int bpm;
    public String note;

    @ManyToOne
    public User user;

    @Enumerated(EnumType.STRING)
    public WorkoutType workoutType;

    @OneToMany
    public List<Exercise> exercises = new LinkedList<Exercise>();

    public Workout() {
    }

    public Workout(LocalDateTime starttime, LocalDateTime endtime, int calories, int bpm, String note,
            User user, String workoutType) {
        this.starttime = starttime;
        this.endtime = endtime;
        // this.duration = endtime - starttime;
        this.calories = calories;
        this.bpm = bpm;
        this.note = note;
        this.user = user;
        this.workoutType = WorkoutType.valueOf(workoutType.toUpperCase());
    }

    public Workout(LocalDateTime starttime, LocalDateTime endtime, int calories, int bpm, String note,
            User user, String workoutType, LinkedList<Exercise> exercises) {
        this.starttime = starttime;
        this.endtime = endtime;
        // this.duration = endtime - starttime;
        this.calories = calories;
        this.bpm = bpm;
        this.note = note;
        this.user = user;
        this.workoutType = WorkoutType.valueOf(workoutType.toUpperCase());
        this.exercises = exercises;
    }

    public void addExercise(Exercise exercise) {
        this.exercises.add(exercise);
    }
    
}
