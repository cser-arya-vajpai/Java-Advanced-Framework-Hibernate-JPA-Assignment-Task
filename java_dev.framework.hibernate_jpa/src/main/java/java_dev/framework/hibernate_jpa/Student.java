package java_dev.framework.hibernate_jpa;

// Importing Serializable so that the entity object can be converted
// into a byte stream if required (used in caching, session handling, etc.)
import java.io.Serializable;

// Importing JPA annotations
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * Student entity class.
 * 
 * This class represents the Student table in the database.
 * Each object of this class corresponds to a row in the table.
 */
@Entity
public class Student implements Serializable {

    // Marks this field as the Primary Key of the table
    @Id
    private Integer id;

    // Variable to store student name
    private String name;

    // Variable to store student email ID
    private String mailId;

    // Variable to store student contact number
    private long contactNumber;

    /**
     * Default constructor.
     * Required by JPA for creating objects using reflection.
     */
    public Student() {}

    /**
     * Parameterized constructor to initialize all fields.
     * Useful for creating Student objects with values.
     */
    public Student(Integer id, String name, String mailId, long contactNumber) {
        this.id = id;
        this.name = name;
        this.mailId = mailId;
        this.contactNumber = contactNumber;
    }

    /**
     * Getter method for student ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter method for student ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter method for student name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for student name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for student mail ID
     */
    public String getMailId() {
        return mailId;
    }

    /**
     * Setter method for student mail ID
     */
    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    /**
     * Getter method for contact number
     */
    public long getContactNumber() {
        return contactNumber;
    }

    /**
     * Setter method for contact number
     */
    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }
}