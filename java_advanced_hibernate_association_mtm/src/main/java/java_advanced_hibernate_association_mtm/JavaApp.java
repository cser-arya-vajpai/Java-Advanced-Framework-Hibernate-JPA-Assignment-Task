package java_advanced_hibernate_association_mtm;
import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;


public class JavaApp {
	public static void execution() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		// Projects
		Project p1 = new Project();
		p1.setId(101);
		p1.setTitle("AI Chatbot");

		Project p2 = new Project();
		p2.setId(102);
		p2.setTitle("JobFindr");

		Project p3 = new Project();
		p3.setId(103);
		p3.setTitle("E-Commerce");

		// Students
		Student s1 = new Student();
		s1.setId(1);
		s1.setName("Arya");
		s1.setEmail("arya@gmail.com");

		Student s2 = new Student();
		s2.setId(2);
		s2.setName("Riya");
		s2.setEmail("riya@gmail.com");

		Student s3 = new Student();
		s3.setId(3);
		s3.setName("Aman");
		s3.setEmail("aman@gmail.com");

		// Assign projects
		s1.setProjects(List.of(p1, p2));
		s2.setProjects(List.of(p2, p3));
		s3.setProjects(List.of(p1));

		// Transaction
		et.begin();

		em.persist(p1);
		em.persist(p2);
		em.persist(p3);

		em.persist(s1);
		em.persist(s2);
		em.persist(s3);

		et.commit();
	}

}
