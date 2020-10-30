package chapter08;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PreLoadEmployeeData {
	
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		Employee amit = new Employee();
		amit.setEmpAddress("Finland");
		amit.setEmpName("Amit");
		amit.setSalary(1000.00);
		amit.setEmpType("P");
		
		Employee swati = new Employee();
		swati.setEmpAddress("Finland");
		swati.setEmpName("Swati");
		swati.setSalary(2000.00);
		swati.setEmpType("P");
		
		Employee shubh = new Employee();
		shubh.setEmpAddress("Finland");
		shubh.setEmpName("Shubh");
		shubh.setSalary(3000.00);
		shubh.setEmpType("T");
		
		Employee prisha = new Employee();
		prisha.setEmpAddress("Finland");
		prisha.setEmpName("Prisha");
		prisha.setSalary(4000.00);
		prisha.setEmpType("T");
		
		session.save(amit);
		session.save(swati);
		session.save(shubh);
		session.save(prisha);
		
		session.getTransaction().commit();
		session.close();
		
		
		
		
		
	}

}
