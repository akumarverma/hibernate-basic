package chapter02;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity(name="EMP_TABLE")
public class Employee {
	
	@Id
	@Column(name="EMP_ID")
	private int empId;
	
	@Column(name="EMP_NAME")
	private String empName;
	
	@Column(name="EMP_ADDRESS")
	private String empAddress;
	
	@Column(name="DATE_OF_JOINING")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfJoining;
	
	@Transient
	private String empType;
	
	public Employee() {}
	
	
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


	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	

}
