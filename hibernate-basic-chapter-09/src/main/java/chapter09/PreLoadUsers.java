package chapter09;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PreLoadUsers {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session  session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		User amit = new User();
		amit.setUserName("Amit");
		amit.setPassword("123");
		
		User shubh = new User();
		shubh.setUserName("shubh");
		shubh.setPassword("123");
		
		session.save(amit);
		session.save(shubh);
		
		
		session.getTransaction().commit();
		session.close();
		
	}

}
