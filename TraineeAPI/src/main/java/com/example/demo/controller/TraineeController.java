package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Trainee;
import com.example.demo.exceptions.TraineeIdNotFoundException;
import com.example.demo.service.ITraineeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/trainees")
public class TraineeController {

    @Autowired
    private ITraineeService service;

    private int a=10;

    @GetMapping
    public List<Trainee> getAllTrainees() {
        return service.getAllTrainees();
    }

    @GetMapping("/{id}")
    public Trainee getTraineeById(@PathVariable int id) {
        return service.getTraineeById(id);
    }

    @GetMapping("/name/{name}")
    public List<Trainee> getTraineeByName(@PathVariable String name) {
        return service.getTraineeByName(name);
    }

    @PostMapping
    public Trainee addTrainee(@Valid @RequestBody Trainee trainee) {
        return service.addTrainee(trainee);
    }

    @PutMapping("/{id}")
    public Trainee updateTrainee(@PathVariable int id, @RequestBody Trainee trainee) {
        return service.updateTrainee(id, trainee);
    }

    @DeleteMapping("/{id}")
    public String deleteTrainee(@PathVariable int id) {
        service.deleteTrainee(id);
        return "Trainee deleted successfully with id: " + id;
    }
    
    /*
    @ExceptionHandler(TraineeIdNotFoundException.class)
    ResponseEntity<String> handlerForIdNotFoundException(TraineeIdNotFoundException e){
    	return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
    }*/
}
