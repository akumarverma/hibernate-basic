package chapter03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class EmployeeDemo {

	public static void main(String[] args) throws IOException {
		EmployeeId empId = null;
		String empName = null;
		String empAddress = null;
		String empDept = null;

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

//		System.out.println("Enter the Id:");
//		empId = in.readLine();

		System.out.println("Enter the Employee Name:");
		empName = in.readLine();

		System.out.println("Enter the Employee Department:");
		empDept = in.readLine();
		
//		System.out.println("Enter the Employee Address:");
//		empAddress = in.readLine();

		Employee emp = new Employee();
		
		Address address = new Address("Piilipuuntie 15 A2","02250","Espoo","Finland");
		
		empId = new EmployeeId();
		empId.setId(1);
		empId.setDepartment("IT");
		

//		emp.setEmpId(Integer.parseInt(empId));
		emp.setEmpId(empId);
		emp.setEmpName(empName);
		emp.setEmpAddress(address);
		emp.setDateOfJoining(new Date());
		emp.setEmpType("P");


		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.save(emp);
		} catch (Exception e) {

			System.out.println("Employee Record created Failed" + e.getMessage());
			e.printStackTrace();
		}

		session.getTransaction().commit();
		session.close();

		// getting the employee

		session = sessionFactory.openSession();
		session.beginTransaction();

		Query<Employee> query = session.createQuery("from chapter03.Employee",Employee.class);
		List<Employee> empList = query.getResultList();

		for (Employee e : empList) {
			System.out.println("Displaying Employee Details");
			System.out.println("Employee Id is: " + e.getEmpId());
			System.out.println("Employee Name is: " + e.getEmpName());
			System.out.println("Employee Address is: " + e.getEmpAddress());

		}

		session.getTransaction().commit();
		session.close();

	}

}
