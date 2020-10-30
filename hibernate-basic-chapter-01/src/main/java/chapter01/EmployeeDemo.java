package chapter01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
		
		int result = service.insertEmployee(emp);
		
		if (result ==0) {
			System.out.println("Insertion failed");
		}
		else {
			System.out.println("Employee Record created Sucessfully");
		}
		
		
		
	}

}
