package chapter04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CollectionDemo {
	
	public static void main(String[] args) throws IOException {
		
		Address india = new Address();
		Address uk = new Address();
		Address finland = new Address();
		
		india.setAddress("Nizampet");
		india.setPostCode("500090");
		india.setCity("Hyderabad");
		india.setCountry("India");
		
		uk.setAddress("Preston Count");
		uk.setPostCode("EH49 4LX");
		uk.setCity("Linlithgow");
		uk.setCountry("UK");
		
		finland.setAddress("Piilipuuntie 15 A2");
		finland.setPostCode("02250");
		finland.setCity("Espoo");
		finland.setCountry("Finland");
		
		Collection<Address> listOfAddress = new ArrayList<Address>();
		listOfAddress.add(india);
		listOfAddress.add(uk);
		listOfAddress.add(finland);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter the name of Employee:");
		String empName = in.readLine();
		
		Employee emp = new Employee();
		emp.setEmpName(empName);
		emp.setEmpAddress(listOfAddress);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		session.save(emp);
		
		session.getTransaction().commit();
		
		session.close();
		
		session = sessionFactory.openSession();
		
		session.beginTransaction();
		Employee temp = session.get(Employee.class, 1);
		
		System.out.println("Name of employee is: "+temp.getEmpName());
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println("Name of employee is: "+temp.getEmpAddress().size());
		
	
		
		
		
		
	}

}
