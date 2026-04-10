package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Trainee;


@Repository
public interface ITraineeRepo extends JpaRepository<Trainee, Integer>{
	List<Trainee> findByTraineeName(String name);
}
