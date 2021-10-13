package at.htl.endpoints;

import javax.inject.Inject;

import at.htl.repositories.WorkoutRepository;

public class WorkoutEndpoint {
    @Inject
    WorkoutRepository workoutRepository;
}
