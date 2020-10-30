package chapter03;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GeneratorType;

@Entity(name = "EMP_TABLE")
public class Employee implements Serializable{

//	@Id
//	@Column(name = "EMP_ID")
//	@GeneratedValue
//	private int empId;
	
	@Id
	@Embedded
	private EmployeeId empId;

	@Column(name = "EMP_NAME")
	private String empName;

//	@Id
//	@Column(name = "EMP_DEPT")
//	private String department;

//	public String getDepartment() {
//		return department;
//	}
//
//	public void setDepartment(String department) {
//		this.department = department;
//	}

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "address", column = @Column(name = "EMP_ADDRESS")),
			@AttributeOverride(name = "postCode", column = @Column(name = "EMP_POSTCODE")),
			@AttributeOverride(name = "city", column = @Column(name = "EMP_CITY")),
			@AttributeOverride(name = "country", column = @Column(name = "EMP_COUNTRY")) })

	private Address empAddress;

	@Column(name = "DATE_OF_JOINING")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfJoining;

	@Transient
	private String empType;

	public Employee() {
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public EmployeeId getEmpId() {
		return empId;
	}

	public void setEmpId(EmployeeId empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Address getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(Address empAddress) {
		this.empAddress = empAddress;
	}

}
