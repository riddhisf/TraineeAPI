package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.Trainee;
import com.example.demo.exceptions.TraineeIdNotFoundException;
import com.example.demo.repositories.ITraineeRepo;

@ExtendWith(MockitoExtension.class)
class TraineeServiceImplTest {

    @Mock
    private ITraineeRepo repo;

    @InjectMocks
    private TraineeServiceImpl service;

    private Trainee trainee;

    @BeforeEach
    void setup() {

        trainee = new Trainee();
        trainee.setTraineeId(1);
        trainee.setTraineeName("Riddhi");
        trainee.setTraineeDomain("Java");
        trainee.setTraineeLocation("Ghaziabad");
    }

    @Test
    void testGetAllTrainees() {
    	//mock
        when(repo.findAll()).thenReturn(List.of(trainee));
        List<Trainee> result = service.getAllTrainees();
        //assert
        assertEquals(1, result.size());
        //verify
        verify(repo, times(1)).findAll();
    }

    @Test
    void testGetTraineeById() {
        when(repo.findById(1)).thenReturn(Optional.of(trainee));

        Trainee result = service.getTraineeById(1);

        assertEquals("Riddhi", result.getTraineeName());
    }

    @Test
    void testGetTraineeById_NotFound() {
        when(repo.findById(1)).thenReturn(Optional.empty());

        assertThrows(TraineeIdNotFoundException.class, () -> {
            service.getTraineeById(1);
        });
    }

    @Test
    void testAddTrainee() {
        when(repo.save(trainee)).thenReturn(trainee);

        Trainee result = service.addTrainee(trainee);

        assertNotNull(result);
        verify(repo).save(trainee);
    }

    @Test
    void testUpdateTrainee() {
        when(repo.findById(1)).thenReturn(Optional.of(trainee));
        when(repo.save(any(Trainee.class))).thenReturn(trainee);

        trainee.setTraineeName("Updated");

        Trainee result = service.updateTrainee(1, trainee);

        assertEquals("Updated", result.getTraineeName());
        
        verify(repo).save(any(Trainee.class));
    }

    @Test
    void testDeleteTrainee() {
        doNothing().when(repo).deleteById(1);

        service.deleteTrainee(1);

        verify(repo, times(1)).deleteById(1);
    }
}