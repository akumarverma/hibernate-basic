package chapter09;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class PositionalParametersDemo {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		String queryString = "select userId from my_users where userName=?0 and password=?1";
			
		
		Query query = session.createQuery(queryString);
		
		query.setParameter(0, "Amit");
		query.setParameter(1, "123");
		
		List<Integer> list = query.list();
		
		if (list.size()>0) {
			
			Iterator iter = list.iterator();
			
			while(iter.hasNext()) {
				System.out.println("user id is: "+iter.next());
			}
			
		}
		else {
			System.out.println("No record found in DB");
		}
		

		
		
		
		session.getTransaction().commit();
		
		session.close();
		
	}

}
