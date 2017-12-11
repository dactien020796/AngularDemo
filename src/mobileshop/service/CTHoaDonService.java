package mobileshop.service;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import mobileshop.entity.CTHoaDon;

@Transactional
@Component
public class CTHoaDonService {
	@Autowired
	SessionFactory factory;
	
	public void insert(CTHoaDon cTHoaDon) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(cTHoaDon);
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
	
	public void update(CTHoaDon cTHoaDon) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(cTHoaDon);
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
	
	public void delete(CTHoaDon cTHoaDon) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(cTHoaDon);
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
	
	public void refresh(CTHoaDon cTHoaDon) {
		Session session = factory.getCurrentSession();
		session.refresh(cTHoaDon);
	}
	
	public CTHoaDon get(String id) {
		Session session = factory.getCurrentSession();
		CTHoaDon cTHoaDon = (CTHoaDon) session.get(CTHoaDon.class, id);
		return cTHoaDon;
	}
	
	public List<CTHoaDon> list(){
		String hql = "FROM CTHoaDon";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		List<CTHoaDon> list = query.list();
		return list;
	}

	public List<Object[]> revenueBySanPham() {
		String hql = "SELECT d.sanPham.ten, SUM(d.donGia*d.soLuong*(1-d.khuyenMai)), "
				+ "SUM(d.soLuong), MIN(d.donGia), MAX(d.donGia), AVG(d.donGia) "
				+ "FROM CTHoaDon d GROUP BY d.sanPham.ten";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		return list;
	}
	
	public List<Object[]> revenueByHang() {
		String hql = "SELECT d.sanPham.hang.ten, SUM(d.donGia*d.soLuong*(1-d.khuyenMai)), "
				+ "SUM(d.soLuong), MIN(d.donGia), MAX(d.donGia), AVG(d.donGia) "
				+ "FROM CTHoaDon d GROUP BY d.sanPham.hang.ten";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		return list;
	}

	
	public List<Object[]> revenueByKhachHang() {
		String hql = "SELECT d.hoaDon.khachHang.ma, SUM(d.donGia*d.soLuong*(1-d.khuyenMai)), "
				+ "SUM(d.soLuong), MIN(d.donGia), MAX(d.donGia), AVG(d.donGia) "
				+ "FROM CTHoaDon d GROUP BY d.hoaDon.khachHang.ma";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		return list;
	}
	
	public List<Object[]> revenueByYear() {
		String hql = "SELECT YEAR(d.hoaDon.ngayDat), SUM(d.donGia*d.soLuong*(1-d.khuyenMai)), "
				+ "SUM(d.soLuong), MIN(d.donGia), MAX(d.donGia), AVG(d.donGia) "
				+ "FROM CTHoaDon d GROUP BY YEAR(d.hoaDon.ngayDat) "
				+ "ORDER BY YEAR(d.hoaDon.ngayDat)";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		return list;
	}
	
	public List<Object[]> revenueByQuarter() {
		String hql = "SELECT CEILING(MONTH(d.hoaDon.ngayDat)/3.0), SUM(d.donGia*d.soLuong*(1-d.khuyenMai)), "
				+ "SUM(d.soLuong), MIN(d.donGia), MAX(d.donGia), AVG(d.donGia) "
				+ "FROM CTHoaDon d GROUP BY CEILING(MONTH(d.hoaDon.ngayDat)/3.0) "
				+ "ORDER BY CEILING(MONTH(d.hoaDon.ngayDat)/3.0)";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		return list;
	}
	
	public List<Object[]> revenueByMonth() {
		String hql = "SELECT MONTH(d.hoaDon.ngayDat), SUM(d.donGia*d.soLuong*(1-d.khuyenMai)), "
				+ "SUM(d.soLuong), MIN(d.donGia), MAX(d.donGia), AVG(d.donGia) "
				+ "FROM CTHoaDon d GROUP BY MONTH(d.hoaDon.ngayDat) "
				+ "ORDER BY MONTH(d.hoaDon.ngayDat)";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		return list;
	}
}
