package com.example.demo;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.controller.TraineeController;
import com.example.demo.entities.Trainee;

@SpringBootApplication
public class TraineeApiApplication implements CommandLineRunner {

    @Autowired
    private TraineeController controller;

    public static void main(String[] args) {
        SpringApplication.run(TraineeApiApplication.class, args);
    }

    @Override
    public void run(String... args) {

        // Scanner sc = new Scanner(System.in);
        // int choice;

        // do {
        //     System.out.println("---Select from Following Options---");
        //     System.out.println("1. Insert Trainee");
        //     System.out.println("2. View All Trainees");
        //     System.out.println("3. View Trainee By ID");
        //     System.out.println("4. Update Trainee");
        //     System.out.println("5. Delete Trainee");
        //     System.out.println("6. Search By Name");
        //     System.out.println("0. Exit");

        //     System.out.print("Enter choice: ");
        //     choice = sc.nextInt();
        //     sc.nextLine();

        //     try {
        //         switch (choice) {

        //             case 1:
        //                 Trainee t = new Trainee();

        //                 System.out.print("Enter Name: ");
        //                 t.setTraineeName(sc.nextLine());
        //                 System.out.print("Enter Domain: ");
        //                 t.setTraineeDomain(sc.nextLine());
        //                 System.out.print("Enter Location: ");
        //                 t.setTraineeLocation(sc.nextLine());
        //                 controller.addTrainee(t);
        //                 System.out.println("Trainee added successfully!");
        //                 break;

        //             case 2:
        //                 List<Trainee> list = controller.getAllTrainees();
        //                 list.forEach(System.out::println);
        //                 break;

        //             case 3:
        //                 System.out.print("Enter ID: ");
        //                 int id = sc.nextInt();
        //                 Trainee trainee = controller.getTraineeById(id);
        //                 System.out.println(trainee);
        //                 break;

        //             case 4:
        //                 System.out.print("Enter Trainee ID: ");
        //                 int updateId = sc.nextInt();
        //                 sc.nextLine();
        //                 Trainee existing = controller.getTraineeById(updateId);

        //                 System.out.println("1. Name");
        //                 System.out.println("2. Domain");
        //                 System.out.println("3. Location");
        //                 System.out.println("4. Update All");

        //                 int updateChoice = sc.nextInt();
        //                 sc.nextLine();

        //                 switch (updateChoice) {
        //                     case 1:
        //                         System.out.print("Enter new Name: ");
        //                         existing.setTraineeName(sc.nextLine());
        //                         break;

        //                     case 2:
        //                         System.out.print("Enter new Domain: ");
        //                         existing.setTraineeDomain(sc.nextLine());
        //                         break;

        //                     case 3:
        //                         System.out.print("Enter new Location: ");
        //                         existing.setTraineeLocation(sc.nextLine());
        //                         break;

        //                     case 4:
        //                         System.out.print("Enter Name: ");
        //                         existing.setTraineeName(sc.nextLine());
        //                         System.out.print("Enter Domain: ");
        //                         existing.setTraineeDomain(sc.nextLine());
        //                         System.out.print("Enter Location: ");
        //                         existing.setTraineeLocation(sc.nextLine());
        //                         break;

        //                     default:
        //                         System.out.println("Invalid choice");
        //                 }

        //                 controller.updateTrainee(updateId, existing);
        //                 System.out.println("Updated successfully!");
        //                 break;

        //             case 5:
        //                 System.out.print("Enter ID: ");
        //                 int deleteId = sc.nextInt();
        //                 controller.deleteTrainee(deleteId);
        //                 System.out.println("Deleted successfully!");
        //                 break;

        //             case 6:
        //                 System.out.print("Enter Name: ");
        //                 String name = sc.nextLine();
        //                 List<Trainee> result = controller.getTraineeByName(name);
        //                 result.forEach(System.out::println);
        //                 break;

        //             case 0:
        //                 System.out.println("Exiting.");
        //                 break;

        //             default:
        //                 System.out.println("Invalid choice!");
        //         }

        //     } catch (Exception e) {
        //         System.err.println("Error: " + e.getMessage());
        //     }

        // } while (choice != 0);

        // sc.close();
    }
}
