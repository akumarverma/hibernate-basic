package chapter07;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StateDemo1 {
	public static void main(String[] args) {
		
		Employee emp = new Employee();
		
		emp.setEmpAddress("Finland");
		emp.setEmpName("Amit");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		session.save(emp);
		emp.setEmpName("Amit-updated-1");
		emp.setEmpName("Amit-updated-2");
		
		
		session.getTransaction().commit();
		session.close();
	}

}
