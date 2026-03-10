package java_advanced_hibernate_association_otm_infinite;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JavaApp {

    public static void execution() {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("Students");

        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();


        // Create Student
        Student s = new Student();
        s.setStudentId(1);
        s.setStudentName("Arya");
        s.setEmail("arya@gmail.com");
        
        Student s2 = new Student();
        s2.setStudentId(2);
        s2.setStudentName("Riya");
        s2.setEmail("riya@gmail.com");

        Project p4 = new Project();
        p4.setProjectId(201);
        p4.setProjectName("E-commerce App");
        p4.setTechnology("Spring Boot");

        Project p5 = new Project();
        p5.setProjectId(202);
        p5.setProjectName("Chat Application");
        p5.setTechnology("WebSocket");

        p4.setStudent(s2);
        p5.setStudent(s2);

        List<Project> projects2 = new ArrayList<>();
        projects2.add(p4);
        projects2.add(p5);

        s2.setProjects(projects2);
        
        
        Student s3 = new Student();
        s3.setStudentId(3);
        s3.setStudentName("Kabir");
        s3.setEmail("kabir@gmail.com");

        Project p6 = new Project();
        p6.setProjectId(301);
        p6.setProjectName("Banking System");
        p6.setTechnology("Java");

        Project p7 = new Project();
        p7.setProjectId(302);
        p7.setProjectName("Machine Learning Model");
        p7.setTechnology("Python");

        p6.setStudent(s3);
        p7.setStudent(s3);

        List<Project> projects3 = new ArrayList<>();
        projects3.add(p6);
        projects3.add(p7);

        s3.setProjects(projects3);


        // Create Projects
        Project p1 = new Project();
        p1.setProjectId(101);
        p1.setProjectName("AI Chatbot");
        p1.setTechnology("AI");

        Project p2 = new Project();
        p2.setProjectId(102);
        p2.setProjectName("Web Application");
        p2.setTechnology("Spring Boot");

        Project p3 = new Project();
        p3.setProjectId(103);
        p3.setProjectName("Data Analysis");
        p3.setTechnology("Python");


        // Assign student to projects
        p1.setStudent(s);
        p2.setStudent(s);
        p3.setStudent(s);


        // Store projects in list
        List<Project> projects = new ArrayList<>();

        projects.add(p1);
        projects.add(p2);
        projects.add(p3);


        // Assign list to student
        s.setProjects(projects);


        et.begin();
//        em.persist(p1);
//        em.persist(p2);
//        em.persist(p3);

      

      //  em.persist(s);
        em.persist(s2);
        em.persist(s3);


        em.persist(p4);
        em.persist(p5);
        em.persist(p6);
        em.persist(p7);

        et.commit();

        System.out.println("Data inserted successfully");

    }
}