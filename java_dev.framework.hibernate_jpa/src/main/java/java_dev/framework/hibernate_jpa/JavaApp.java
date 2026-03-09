package java_dev.framework.hibernate_jpa;

// Importing required JPA classes for database interaction
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Scanner;


/**
 * This class demonstrates how to perform basic Hibernate/JPA operations
 * such as retrieving and deleting records from the database.
 */
public class JavaApp {

	// Method responsible for executing the database operations
	public static void execution() {

		// Creating EntityManagerFactory using the persistence unit
		// name defined inside persistence.xml
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Student");

		// Creating EntityManager which is used to interact with the database
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// Obtaining the transaction object to perform database transactions
		EntityTransaction entityTransaction = entityManager.getTransaction();

		// Starting the transaction
		entityTransaction.begin();

		// Creating first Student entity object and assigning values
		Student s1 = new Student();
		s1.setId(1); // Student ID
		s1.setName("Arya"); // Student Name
		s1.setMailId("aryavajpai4141@gmail.com"); // Student Email
		s1.setContactNumber(1234567890); // Contact Number

		// Creating second Student entity object
		Student s2 = new Student();
		s2.setId(2);
		s2.setName("Raghav");
		s2.setMailId("123raghav@gmail.com");
		s2.setContactNumber(826632789);

		// Creating third Student entity object
		Student s3 = new Student();
		s3.setId(3);
		s3.setName("Aparna");
		s3.setMailId("aparna4342@gmail.com");
		s3.setContactNumber(227864897);

		// Creating fourth Student entity object
		Student s4 = new Student();
		s4.setId(4);
		s4.setName("Gaurav");
		s4.setMailId("gaurav@gmail.com");
		s4.setContactNumber(889067890);

		// These lines would store the student objects into the database.
		// Currently they are commented, so no new records will be inserted.
		
/*		entityManager.persist(s1);
		entityManager.persist(s2);
		entityManager.persist(s3);
		entityManager.persist(s4);
*/

		// Retrieving the student whose primary key (id) is 1 from the database
		// If the record exists, the corresponding Student object will be returned
		Student student = entityManager.find(Student.class, 1);

		// Printing the retrieved student object
		// If toString() is overridden in the Student class, full details will print
		System.out.println(student);

		// Attempting to retrieve a student with id = 10
		// Since this record does not exist in the database, find() will return null
		Student student2 = entityManager.find(Student.class, 10);

		// Checking whether the student exists or not
		if(student2 != null) {

		    // If the student exists, print the student details
		    System.out.println(student2);

		} else {

		    // If no student exists with this id, print a message
		    System.out.println("student not found");
		}

		// Retrieving the student with id = 2 from the database
		Student data = entityManager.find(Student.class, 2);

		// Removing (deleting) the retrieved student record from the database
		entityManager.remove(data);
		
		

		// Committing the transaction to permanently apply the delete operation
		entityTransaction.commit();

		// Printing confirmation message after execution
		System.out.println("Hello World");
	}
	
	public static void execution1() {
		
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Employee");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        
        entityTransaction.begin();
        
        System.out.println("Enter the number of employees you want to add:");
        int n = sc.nextInt();
        
        for(int i = 0; i < n; i++) {

            Employee employee = new Employee();

            System.out.println("Enter employee ID:");
            employee.setEmp_Id(sc.nextInt());

            System.out.println("Enter employee name:");
            employee.setName(sc.next());

            System.out.println("Enter employee mailId:");
            employee.setMailId(sc.next());

            System.out.println("Enter department:");
            employee.setDept(sc.next());

            System.out.println("Enter salary:");
            employee.setSalary(sc.nextLong());

            entityManager.persist(employee);
        }
        entityTransaction.commit();
        
        
        System.out.println("Enter employee id to search:");
        int id = sc.nextInt();

        Employee emp = entityManager.find(Employee.class, id);

        if(emp != null) {
            System.out.println(emp);
        }
        else {
            System.out.println("Employee not found");
        }

		
	}
}