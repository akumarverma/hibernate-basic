package chapter06;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteEmployee {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Employee e = session.get(Employee.class, 5);
		
		session.delete(e);
		
		session.getTransaction().commit();
		
		session.close();
		
		System.out.println("Employee details are: "+e.getEmpName()+ " "+ e.getEmpAddress());


		
	}

}
