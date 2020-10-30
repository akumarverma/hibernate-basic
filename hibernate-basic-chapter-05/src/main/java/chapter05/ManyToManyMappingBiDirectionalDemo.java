package chapter05;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToManyMappingBiDirectionalDemo {
	
	public static void main(String[] args) {
		
		String empName="Amit";
		
		Address address1 = new Address();

		address1.setAddress("piilipuuntie 15 A2");
		address1.setPostCode("02250");
		address1.setCity("Espoo");
		address1.setCountry("Finland");
		
		Address address2 = new Address();
		address2.setAddress("Nizampet");
		address2.setPostCode("500090");
		address2.setCity("Hyderabad");
		address2.setCountry("India");
		
		Employee employee1 = new Employee();
		Employee employee2 = new Employee();
		
		employee1.setEmpName(empName);
		employee2.setEmpName(empName+"dummy");
		
		Collection<Address> listOfAddress = new ArrayList<Address>();
		listOfAddress.add(address1);
		listOfAddress.add(address2);		
		employee1.setEmpAddress(listOfAddress);
		
		Collection<Employee> listOfEmployee = new ArrayList<Employee>();
		listOfEmployee.add(employee1);
		listOfEmployee.add(employee2);		
		employee1.setEmpAddress(listOfAddress);
		employee2.setEmpAddress(listOfAddress);
		
		address1.setEmployee(listOfEmployee);
		address2.setEmployee(listOfEmployee);

		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

//		session.save(employee1);
//		session.save(employee2);
		
//		session.save(address1);
//		session.save(address2);
		
		session.persist(employee1);
		session.persist(employee2);
		
		session.getTransaction().commit();
		session.close();
		
		
	}

}
