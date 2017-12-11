package mobileshop.service;


import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import mobileshop.entity.Hang;

@Transactional
@Component
public class HangService {
	@Autowired
	SessionFactory factory;
	
	public void insert(Hang hang) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(hang);
			t.commit();
		} 
		catch (Exception e) {
			t.rollback();
			throw new RuntimeException(e);
		}
		finally {
			session.close();
		}
	}
	
	public void update(Hang hang) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(hang);
			t.commit();
		} 
		catch (Exception e) {
			t.rollback();
			throw new RuntimeException(e);
		}
		finally {
			session.close();
		}
	}
	
	public void delete(Hang hang) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(hang);
			t.commit();
		} 
		catch (Exception e) {
			t.rollback();
			throw new RuntimeException(e);
		}
		finally {
			session.close();
		}
	}
	
	public void refresh(Hang hang) {
		Session session = factory.getCurrentSession();
		session.refresh(hang);
		//nap kem Sanpham voi hang
		Hibernate.initialize(hang.getSanPhams());
	}
	
	public Hang get(String id) {
		Session session = factory.getCurrentSession();
		Hang hang = (Hang) session.get(Hang.class, id);
		//nap kem Sanpham voi hang
		Hibernate.initialize(hang.getSanPhams());
		return hang;
	}
	
	public List<Hang> list(){
		String hql = "FROM Hang";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		List<Hang> list = query.list();
		return list;
	}
}
