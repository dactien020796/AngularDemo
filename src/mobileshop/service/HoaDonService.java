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

import mobileshop.entity.CTHoaDon;
import mobileshop.entity.HoaDon;
import mobileshop.entity.KhachHang;
import mobileshop.entity.SanPham;

@Transactional
@Component
public class HoaDonService {
	@Autowired
	SessionFactory factory;
	
	public void insert(HoaDon hoaDon) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(hoaDon);
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
	
	public void update(HoaDon hoaDon) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(hoaDon);
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
	
	public void delete(HoaDon hoaDon) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(hoaDon);
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
	
	public void refresh(HoaDon hoaDon) {
		Session session = factory.getCurrentSession();
		session.refresh(hoaDon);
	}
	
	public HoaDon get(Integer id) {
		Session session = factory.getCurrentSession();
		HoaDon hoaDon = (HoaDon) session.get(HoaDon.class, id);
		//nap kem CTHD voi HD
		Hibernate.initialize(hoaDon.getcTHoaDons());
		return hoaDon;
	}
	
	public List<HoaDon> list(){
		String hql = "FROM HoaDon";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		List<HoaDon> list = query.list();
		return list;
	}

	public void purchase(HoaDon order, ShoppingCart cart) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(order);// insert into Order
			
			for(SanPham p : cart.getItems())
			{
				CTHoaDon detail = new CTHoaDon();
				detail.setHoaDon(order);
				detail.setSanPham(p);
				detail.setDonGia(p.getDonGia());
				detail.setKhuyenMai(p.getKhuyenMai());
				detail.setSoLuong(p.getSoLuong());
				
				session.save(detail); // insert into OrderDetail
				
			}
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

	public List<HoaDon> getOrderListByUser(KhachHang user) {
		String hql = "FROM HoaDon WHERE khachHang.ma=:uid";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		
		query.setParameter("uid", user.getMa());
		List<HoaDon> list = query.list();
		return list;
	}

	public List<SanPham> getPurchasedItems(KhachHang user) {
		String hql = "SELECT DISTINCT d.sanPham FROM CTHoaDon d WHERE d.hoaDon.khachHang.ma=:uid";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		
		query.setParameter("uid", user.getMa());
		List<SanPham> list = query.list();
		return list;
	}
}
