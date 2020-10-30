package chapter06;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertEmployees {
	
	public static void main(String[] args) {
		
		ArrayList<Employee> empList = new ArrayList<Employee>();
		
		for(int i=0;i<10;i++) {
			
			Employee temp = new Employee();
			temp.setEmpName("Employee"+i);
			temp.setEmpAddress("Finland"+i);
			
			empList.add(temp);
			
			
		}
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		for(Employee e: empList) {
			
			session.save(e);
		}

		
		session.getTransaction().commit();
		
		session.close();

		
	}

}
