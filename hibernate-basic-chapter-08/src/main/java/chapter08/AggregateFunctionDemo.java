package chapter08;


import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class AggregateFunctionDemo {
	
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		Query query = session.createQuery("select count(salary),min(salary),max(salary),avg(salary),sum(salary) from Employee");
		
		List<Object[]> empList = query.list();
		
		Iterator<Object[]> iter = empList.iterator();
		
		System.out.println("Salary details");
		
		while(iter.hasNext()) {
			Object[] emp = iter.next();
			System.out.println("Count: "+emp[0]);
			System.out.println("Min: "+emp[1]);
			System.out.println("Max: "+emp[2]);
			System.out.println("Avg: "+emp[3]);
			System.out.println("Sum: "+emp[4]);
		}
		
		System.out.println("Query:"+ query.getQueryString());
		
		session.getTransaction().commit();
		session.close();

		
	}
	


}
