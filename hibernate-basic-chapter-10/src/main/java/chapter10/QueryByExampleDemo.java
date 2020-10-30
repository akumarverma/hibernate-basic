package chapter10;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

public class QueryByExampleDemo {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Employee.class);
		Employee sample = new Employee();
		sample.setEmpAddress("Finland");
		
		Example example = Example.create(sample);
		
		criteria.add(example);
		
		List<Employee> list = criteria.list();
		
		if(list.size()>0)
		{
			Iterator<Employee> iter = list.iterator();
			
			while(iter.hasNext()) {
				Employee emp = iter.next();
				System.out.println(
						emp.getEmpId()+"\t"+
								emp.getEmpName()+"\t"+
								emp.getEmpAddress()+"\t"+
								emp.getEmpType()+"\t"+
								emp.getSalary()
						
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
