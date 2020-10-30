package chapter08;


import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class SelectMultipleFieldsDemo {
	
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		Query query = session.createQuery("select empName,empAddress from Employee");
		
		List<Object[]> empList = query.list();
		
		Iterator<Object[]> iter = empList.iterator();
		
		System.out.println("Name\t"+"Address");
		
		while(iter.hasNext()) {
			Object[] emp = iter.next();
			System.out.println(emp[0]+"\t"+emp[1]);
		}
		
		System.out.println("Query:"+ query.getQueryString());
		
		session.getTransaction().commit();
		session.close();

		
	}
	


}
