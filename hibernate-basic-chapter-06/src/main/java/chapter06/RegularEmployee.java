package chapter06;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;

@Entity
//@DiscriminatorColumn(name="empType")
//@DiscriminatorValue("re")
@PrimaryKeyJoinColumn(name="empId")
public class RegularEmployee extends Employee {
	
	private double basic;
	
	//@Transient
	private double da;
	
	//@Transient
	private double hra;
	
	//@Transient
	private double salary;
	
	public RegularEmployee() {}

	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
	}

	public double getDa() {
		return da;
	}

	public void setDa() {
		this.da = this.getBasic()*.20;
	}

	public double getHra() {
		return hra;
	}

	public void setHra() {
		this.hra = this.getBasic()*.30;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public void calculateSalary() {
		this.setDa();
		this.setHra();
		this.setSalary(this.getBasic()+this.getDa()+this.getHra());
	}
	
	
	

}
