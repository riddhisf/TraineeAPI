package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Trainee;
import com.example.demo.exceptions.TraineeIdNotFoundException;
import com.example.demo.repositories.ITraineeRepo;

@Service
public class TraineeServiceImpl implements ITraineeService {

    @Autowired
    private ITraineeRepo repo;

    @Override
    public List<Trainee> getAllTrainees() {
        return repo.findAll();
    }

    @Override
    public Trainee getTraineeById(int id) {
    	Optional<Trainee> trainee=repo.findById(id);
        if(trainee.isPresent()) {
            return trainee.get();
        }
        else {
        	throw new TraineeIdNotFoundException("Trainee not found!");
        }
    }

    @Override
    public List<Trainee> getTraineeByName(String name) {
    	return repo.findByTraineeName(name);
    }

    @Override
    public Trainee addTrainee(Trainee trainee) {
        return repo.save(trainee);
    }

    @Override
    public Trainee updateTrainee(int id, Trainee trainee) {
        Trainee existing = getTraineeById(id);
        existing.setTraineeName(trainee.getTraineeName());
        existing.setTraineeDomain(trainee.getTraineeDomain());
        existing.setTraineeLocation(trainee.getTraineeLocation());
        return repo.save(existing);
    }

    @Override
    public void deleteTrainee(int id) {
        repo.deleteById(id);
    }
}