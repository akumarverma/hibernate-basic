package chapter02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeDemo {
	
	public static void main(String[] args) throws IOException {
		String empId = null;
		String empName = null;
		String empAddress = null;
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter the Id:");
		empId = in.readLine();
		
		System.out.println("Enter the Employee Name:");
		empName = in.readLine();
		
		System.out.println("Enter the Employee Address:");
		empAddress = in.readLine();
		
		Employee emp = new Employee();
		
		emp.setEmpId(Integer.parseInt(empId));
		emp.setEmpName(empName);
		emp.setEmpAddress(empAddress);
		emp.setDateOfJoining(new Date(2020,10,28));
		emp.setEmpType("P");
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();  
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.save(emp);
		}
		catch(Exception e) {	

			System.out.println("Employee Record created Failed"+e.getMessage());
			e.printStackTrace();
		}
		
		session.getTransaction().commit();
		session.close();
		
		
		
	}

}
