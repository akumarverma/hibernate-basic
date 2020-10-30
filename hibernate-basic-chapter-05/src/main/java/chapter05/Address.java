package chapter05;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name="Address")
public class Address {
	
	@Id
	@GeneratedValue
	@Column(name="address_id")
	private int addressId;
	
//	@ManyToOne
//	@JoinColumn(name="employee_id")
//	Employee employee;
	
	@ManyToMany
	@JoinTable(name="address_employee"
	,joinColumns=@JoinColumn(name="address_id")
	,inverseJoinColumns=@JoinColumn(name="employee_id") )
	Collection<Employee> employeeCollection;	
	
	public Collection<Employee> getEmployee() {
		return employeeCollection;
	}

	public void setEmployee(Collection<Employee> employeeCollection) {
		this.employeeCollection = employeeCollection;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setEmpId(int addressId) {
		this.addressId = addressId;
	}

	private String address;
	private String postCode;
	private String city;
	private String country;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public Address() {}

	public Address(String address, String postCode, String city, String country) {
		super();
		this.address = address;
		this.postCode = postCode;
		this.city = city;
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", address=" + address + ", postCode=" + postCode + ", city=" + city
				+ ", country=" + country + "]";
	}
	
	
	

}
