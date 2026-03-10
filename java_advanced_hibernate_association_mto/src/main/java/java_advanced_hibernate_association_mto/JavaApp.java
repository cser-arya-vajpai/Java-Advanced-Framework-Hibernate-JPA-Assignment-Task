package java_advanced_hibernate_association_mto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JavaApp {
	public static void execution() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Project p1 = new Project();
		p1.setId(101);
		p1.setTitle("AI Chatbot");

		Student s1 = new Student();
		s1.setId(1);
		s1.setName("Arya");
		s1.setMailId("arya@gmail.com");

		Student s2 = new Student();
		s2.setId(2);
		s2.setName("Riya");
		s2.setMailId("riya@gmail.com");

		Student s3 = new Student();
		s3.setId(3);
		s3.setName("Aman");
		s3.setMailId("aman@gmail.com");

		s1.setProject(p1);
		s2.setProject(p1);
		s3.setProject(p1);

		et.begin();

		em.persist(p1);
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);

		et.commit();
	}

}


