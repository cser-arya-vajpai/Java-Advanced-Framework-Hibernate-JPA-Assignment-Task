package java_dev.framework.hibernate_jpa;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity
public class Employee implements Serializable{
	
	@Id
	private Integer emp_Id;
	private String name;
	private String mailId;
	private String dept;
	private long Salary;
	
	public Employee() {
		
	}

	public Employee(Integer emp_Id, String name, String mailId, String dept, long salary) {
		this.emp_Id = emp_Id;
		this.name = name;
		this.mailId = mailId;
		this.dept = dept;
		Salary = salary;
	}
	
	public Integer getEmp_Id() {
		return emp_Id;
	}
	
	public void setEmp_Id(Integer emp_Id) {
		this.emp_Id = emp_Id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public long getSalary() {
		return Salary;
	}
	
	public void setSalary(long salary) {
		Salary = salary;
	}

}
