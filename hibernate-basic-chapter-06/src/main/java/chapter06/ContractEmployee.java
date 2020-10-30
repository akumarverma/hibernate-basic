package chapter06;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
//@DiscriminatorColumn(name="empType")
//@DiscriminatorValue("ce")
@PrimaryKeyJoinColumn(name="empId")
public class ContractEmployee extends Employee {
	
	private double consolidatedSalary;

	public double getConsolidatedSalary() {
		return consolidatedSalary;
	}

	public void setConsolidatedSalary(double consolidatedSalary) {
		this.consolidatedSalary = consolidatedSalary;
	}
	
	public ContractEmployee() {}
	

}
