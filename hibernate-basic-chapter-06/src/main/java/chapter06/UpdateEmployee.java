package chapter06;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateEmployee {
	
	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Employee e = session.get(Employee.class, 5);
		
		e.setEmpAddress(e.getEmpAddress()+"-Updated");
		e.setEmpName(e.getEmpName()+"-Updated");

		
		session.getTransaction().commit();
		
		session.close();
		
		System.out.println("Employee details are: "+e.getEmpName()+ " "+ e.getEmpAddress());

		
	}

}
