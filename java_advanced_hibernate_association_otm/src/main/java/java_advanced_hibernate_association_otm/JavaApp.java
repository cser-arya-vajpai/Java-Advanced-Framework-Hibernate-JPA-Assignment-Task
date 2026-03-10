package java_advanced_hibernate_association_otm;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;


public class JavaApp {

    public static void execution() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        // Creating Student
        Student s = new Student();
        s.setId(1);
        s.setName("Arya");
        s.setMailId("arya@gmail.com");

     // Creating Project 1
        Project p1 = new Project();
        p1.setId(101);
        p1.setTitle("AI Chatbot");

        // Creating Project 2
        Project p3 = new Project();
        p3.setId(103);
        p3.setTitle("JobFindr");

        // Setting relationship
        p1.setStudent(s);
        p3.setStudent(s);

        s.setProjects(p1);   // since Student stores only one project

        
     // Creating another Student
        Student s2 = new Student();
        s2.setId(2);
        s2.setName("Riya");
        s2.setMailId("riya@gmail.com");

        // Creating Project
        Project p4 = new Project();
        p4.setId(104);
        p4.setTitle("E-Commerce App");

        p4.setStudent(s2);
        s2.setProjects(p4);
        
        
        // Saving data
        et.begin();

       //em.persist(s);
        //em.persist(p1);
        //em.persist(p3);
        
       // em.persist(s2);
      //  em.persist(p4);

        et.commit();

        // Fetching data
        Student student = em.find(Student.class, 1);

        if(student != null) {
            System.out.println(student);

            Project project = student.getProjects();

            if(project != null) {
                System.out.println(project);
            } else {
                System.out.println("Project data not found.");
            }
        } else {
            System.out.println("Student data not found");
        }
        
        //UPDATE
        Student updateStudent = em.find(Student.class, 1);

        if(updateStudent != null) {

            et.begin();

            updateStudent.setName("Arya Updated");
            updateStudent.setMailId("arya_updated@gmail.com");

            et.commit();

            System.out.println("Student updated successfully");
        }
        
        
        //DELETE
 /*       Student deleteStudent = em.find(Student.class, 2);

        if(deleteStudent != null) {

            et.begin();

            em.remove(deleteStudent);

            et.commit();
            

            System.out.println("Student deleted successfully");
        }
*/
        
        em.close();
        emf.close();

        System.out.println("Data inserted successfully!");
    }
}