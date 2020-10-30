package chapter07;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StateDemo2 {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Employee emp = session.get(Employee.class, 1);
		
		System.out.println("Details of employee in DB are:");
		System.out.println("Employee Name: "+emp.getEmpName());
		System.out.println("Employee Address"+ emp.getEmpAddress());
		
		
		
		session.getTransaction().commit();
		session.close();
		
//		emp.setEmpAddress(emp.getEmpAddress()+"-updated");
//		emp.setEmpName(emp.getEmpName()+"-updated");
		
		System.out.println("Details of employee in APP are:");
		System.out.println("Employee Name: "+emp.getEmpName());
		System.out.println("Employee Address"+ emp.getEmpAddress());
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.update(emp);
		
		session.getTransaction().commit();
		session.close();
		
		
		
	}

}
