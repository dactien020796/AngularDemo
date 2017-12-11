package mobileshop.service;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import mobileshop.entity.Admin;

@Transactional
@Component
public class AdminService {
	@Autowired
	SessionFactory factory;
	
	public void insert(Admin admin) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(admin);
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
	
	public void update(Admin admin) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(admin);
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
	
	public void delete(Admin admin) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(admin);
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
	
	public void refresh(Admin admin) {
		Session session = factory.getCurrentSession();
		session.refresh(admin);
	}
	
	public Admin get(String id) {
		Session session = factory.getCurrentSession();
		Admin admin = (Admin) session.get(Admin.class, id);
		return admin;
	}
	
	public List<Admin> list(){
		String hql = "FROM Admin";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		List<Admin> list = query.list();
		return list;
	}
}
