package mobileshop.service;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import mobileshop.entity.KhachHang;

@Transactional
@Component
public class KhachHangService {
	@Autowired
	SessionFactory factory;
	
	public void insert(KhachHang khachHang) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(khachHang);
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
	
	public void update(KhachHang khachHang) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(khachHang);
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
	
	public void delete(KhachHang khachHang) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(khachHang);
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
	
	public void refresh(KhachHang khachHang) {
		Session session = factory.getCurrentSession();
		session.refresh(khachHang);
	}
	
	public KhachHang get(String id) {
		Session session = factory.getCurrentSession();
		KhachHang khachHang = (KhachHang) session.get(KhachHang.class, id);
		return khachHang;
	}
	
	public List<KhachHang> list(){
		String hql = "FROM KhachHang";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		List<KhachHang> list = query.list();
		return list;
	}
}
