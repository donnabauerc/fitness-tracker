package at.htl.entities;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.List;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.CascadeType;
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

    @JsonbDateFormat(value = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime starttime;
    @JsonbDateFormat(value = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime endtime;
    public long duration;
    public int calories;
    public int bpm;
    public String note;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    public User user;

    @Enumerated(EnumType.STRING)
    public WorkoutType workoutType;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    public List<Exercise> exercises = new LinkedList<Exercise>();

    public Workout() {
    }

    public Workout(LocalDateTime starttime, LocalDateTime endtime, int calories, int bpm, String note,
            User user, String workoutType) {
        this.starttime = starttime;
        this.endtime = endtime;
        this.calories = calories;
        this.bpm = bpm;
        this.note = note;
        this.user = user;
        this.workoutType = WorkoutType.valueOf(workoutType.toUpperCase());
        this.duration = ChronoUnit.HOURS.between(starttime, endtime);
    }

    public Workout(LocalDateTime starttime, LocalDateTime endtime, int calories, int bpm, String note,
            User user, String workoutType, LinkedList<Exercise> exercises) {
        this.starttime = starttime;
        this.endtime = endtime;
        this.calories = calories;
        this.bpm = bpm;
        this.note = note;
        this.user = user;
        this.workoutType = WorkoutType.valueOf(workoutType.toUpperCase());
        this.exercises = exercises;
        this.duration = ChronoUnit.HOURS.between(starttime, endtime); //TODO: same bug as sets in Exercises
    }

    public void addExercise(Exercise exercise) {
        this.exercises.add(exercise);
    }
    
}
