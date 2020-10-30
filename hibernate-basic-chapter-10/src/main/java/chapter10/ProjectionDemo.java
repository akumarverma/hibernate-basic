package chapter10;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

public class ProjectionDemo {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Employee.class);
		Projection projection = Projections.property("empName");
		criteria.setProjection(projection);
		
		List<String> list = criteria.list();
		
		Iterator<String> iter = list.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		criteria.setProjection(Projections.count("salary"));
		System.out.println(criteria.list().get(0));
		criteria.setProjection(Projections.min("salary"));
		System.out.println(criteria.list().get(0));
		criteria.setProjection(Projections.max("salary"));
		System.out.println(criteria.list().get(0));
		criteria.setProjection(Projections.sum("salary"));
		System.out.println(criteria.list().get(0));
		criteria.setProjection(Projections.avg("salary"));
		System.out.println(criteria.list().get(0));
		
		
		
		session.getTransaction().commit();
		session.close();
	}

}
