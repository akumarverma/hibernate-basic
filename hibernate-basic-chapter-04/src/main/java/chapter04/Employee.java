package chapter04;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.Collection;

@Entity(name = "EMP_TABLE")
public class Employee implements Serializable{

	@Id
	@Column(name = "EMP_ID")
	@GeneratedValue
	private int empId;


	@Column(name = "EMP_NAME")
	private String empName;



	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="EMP_ADDRESS")
	@JoinColumns(value = @JoinColumn(name="EMP_ID"))
	@GenericGenerator(name="mygenerator", strategy="increment")  
	@CollectionId(columns=@Column(name="ADDRESS_ID"), generator="mygenerator", type = @Type(type="long"))
	private Collection<Address> listOfAddress;

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
