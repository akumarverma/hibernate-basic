package chapter08;


import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class OrderByDemo {
	
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		Query query = session.createQuery("from Employee order by empName");
		
		List<Employee> empList = query.list();
		
		Iterator<Employee> iter = empList.iterator();
		
		System.out.println("Id\t"+"Name\t"+"Address\t"+"Salary");
		
		while(iter.hasNext()) {
			Employee emp = iter.next();
			System.out.println(emp.getEmpId()+"\t"+emp.getEmpName()+"\t"+emp.getEmpAddress()+"\t"+emp.getSalary());
		}
		
		System.out.println("Query:"+ query.getQueryString());
		

		query = session.createQuery("from Employee order by salary DESC");
		
		empList = query.list();
		
		iter = empList.iterator();
		
		System.out.println("Id\t"+"Name\t"+"Address\t"+"Salary");
		
		while(iter.hasNext()) {
			Employee emp = iter.next();
			System.out.println(emp.getEmpId()+"\t"+emp.getEmpName()+"\t"+emp.getEmpAddress()+"\t"+emp.getSalary());
		}
		
		System.out.println("Query:"+ query.getQueryString());

		
		
		session.getTransaction().commit();
		session.close();

		
	}
	


}
