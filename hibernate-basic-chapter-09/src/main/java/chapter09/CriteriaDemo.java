package chapter09;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

public class CriteriaDemo {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Employee.class);
		//Criterion criterion = Restrictions.eq("empName", "Amit");
		Criterion criterion1 = Restrictions.eq("empType", "P");
		Criterion criterion2 = Restrictions.ge("salary", Double.parseDouble("2500"));
		//criteria.add(criterion1).add(criterion2);
		
		Criterion criterion3 = Restrictions.or(criterion1,criterion2);
		
		criteria.add(criterion3);
		
		
		List<Employee> list = criteria.list();
		
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
