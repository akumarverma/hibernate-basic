package chapter05;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneMappingDemo {
	
	public static void main(String[] args) {
		
		String empName="Amit";
		Address address = new Address();
		Employee employee = new Employee();
		address.setAddress("piilipuuntie 15 A2");
		address.setPostCode("02250");
		address.setCity("Espoo");
		address.setCountry("Finland");
		employee.setEmpName(empName);
//		employee.setEmpAddress(address);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(address);
		session.save(employee);
		session.getTransaction().commit();
		session.close();
		
		
	}

}
