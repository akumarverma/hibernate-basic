package chapter05;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.Collection;

@Entity(name = "Employee")
public class Employee implements Serializable{

	@Id
	@Column(name = "emp_id")
	@GeneratedValue
	private int empId;


	@Column(name = "emp_name")
	private String empName;



//	@OneToOne
//	@JoinColumn(name="Address_id")
//	private  Address address;
	
	@ManyToMany(mappedBy="employeeCollection",cascade=CascadeType.PERSIST)
	private  Collection<Address> listOfAddress;

	public Employee() {
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

	public Collection<Address> getEmpAddress() {
		return listOfAddress;
	}

	public void setEmpAddress(Collection<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}

}
