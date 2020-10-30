package chapter06;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SingleTableDemo {
	
	public static void main(String[] args) {
		
		Employee emp = new Employee();
		emp.setEmpName("Amit");
		emp.setEmpAddress("Finland");
		
		RegularEmployee regEmp = new RegularEmployee();
		regEmp.setEmpName("Reg-Amit");
		regEmp.setEmpAddress("Reg-Finland");
		regEmp.setBasic(1000.0);
		regEmp.calculateSalary();
		
		ContractEmployee contractEmp = new ContractEmployee();
		contractEmp.setEmpName("Contract-Amit");
		contractEmp.setEmpAddress("Contract-Finland");
		contractEmp.setConsolidatedSalary(1200.00);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(emp);
		session.save(regEmp);
		session.save(contractEmp);
		
		session.getTransaction().commit();
		
		session.close();

		
	}

}
