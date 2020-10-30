package chapter05;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyMappingOneDirectionalDemo {
	
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
		
		Employee employee = new Employee();
		
		employee.setEmpName(empName);
		
		Collection<Address> listOfAddress = new ArrayList<Address>();
		listOfAddress.add(address1);
		listOfAddress.add(address2);		
		employee.setEmpAddress(listOfAddress);

		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(address1);
		session.save(address2);
		session.save(employee);
		session.getTransaction().commit();
		session.close();
		
		
	}

}
