package com.example.demo.service;

import java.util.List;
import com.example.demo.entities.Trainee;

public interface ITraineeService {

    List<Trainee> getAllTrainees();
    Trainee getTraineeById(int id);
    List<Trainee> getTraineeByName(String traineeName);
    Trainee addTrainee(Trainee trainee);
    Trainee updateTrainee(int id, Trainee trainee);
    void deleteTrainee(int id);
}