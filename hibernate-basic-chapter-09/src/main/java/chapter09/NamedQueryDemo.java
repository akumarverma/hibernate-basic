package chapter09;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class NamedQueryDemo {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		Query query = session.getNamedQuery("findByName");
		
		query.setParameter("empName", "Amit");

		
		List<Employee> list = query.list();
		
		if (list.size()>0) {
			
			Iterator<Employee> iter = list.iterator();
			
			while(iter.hasNext()) {
				Employee e = iter.next();
				System.out.println("Employee id is: "+e.getEmpId()
				+"\t"+e.getEmpName()
				+"\t"+e.getEmpAddress()
				+"\t"+e.getEmpType()
				+"\t"+e.getSalary()
				);
			}
			
		}
		else {
			System.out.println("No record found in DB");
		}
		
		query = session.getNamedQuery("MoreThanSalary");
		
		query.setParameter("salary", Double.parseDouble("1500"));

		
		list = query.list();
		
		if (list.size()>0) {
			
			Iterator<Employee> iter = list.iterator();
			
			while(iter.hasNext()) {
				Employee e = iter.next();
				System.out.println("Employee id is: "+e.getEmpId()
				+"\t"+e.getEmpName()
				+"\t"+e.getEmpAddress()
				+"\t"+e.getEmpType()
				+"\t"+e.getSalary()
				);
			}
			
		}
		else {
			System.out.println("No record found in DB");
		}

		
		
		
		session.getTransaction().commit();
		
		session.close();
		
	}

}
