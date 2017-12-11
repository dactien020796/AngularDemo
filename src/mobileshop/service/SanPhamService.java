package mobileshop.service;

import java.util.Collections;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import mobileshop.entity.SanPham;

@Transactional
@Component
public class SanPhamService {
	@Autowired
	SessionFactory factory;

	public void insert(SanPham sanPham) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(sanPham);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
	}

	public void update(SanPham sanPham) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(sanPham);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
	}

	public void delete(SanPham sanPham) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(sanPham);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
	}

	public void refresh(SanPham sanPham) {
		Session session = factory.getCurrentSession();
		session.refresh(sanPham);
		//nap kem Sanphammau voi sanpham
//		Hibernate.initialize(sanPham.getSanPhamMaus());
	}

	public SanPham get(Integer id) {
		Session session = factory.getCurrentSession();
		SanPham sanPham = (SanPham) session.get(SanPham.class, id);
		//nap kem Sanphammau voi sanpham
		Hibernate.initialize(sanPham.getHang());
		return sanPham;
	}

	public List<SanPham> list() {
		String hql = "FROM SanPham";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		List<SanPham> list = query.list();
		return list;
	}

	public List<SanPham> get5SanPhamDacBiet() {
		String hql = "FROM SanPham WHERE dacBiet = true";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		List<SanPham> list = query.list();

		Collections.shuffle(list);
		List<SanPham> sec5 = list.subList(0, 4);
		for (SanPham s : sec5) {
			Hibernate.initialize(s.getTen());
		}
		return sec5;
	}
	
	public List<SanPham> get5SanPhamMoiNhat() {
		String hql = "SELECT s.ma, s.ten, s.donGia, s.hinhAnh FROM SanPham s WHERE s.moiNhat = true";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		List<SanPham> list = query.list();

//		Collections.shuffle(list);
//		List<SanPham> new5 = list.subList(0, 4);
//		for (SanPham s : new5) {
//			Hibernate.initialize(s.getTen());
//		}
//		return new5;
		return list;
	}

	public List<SanPham> search(String keywords) {
		String hql = "FROM SanPham WHERE ten LIKE :kw";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter("kw","%" + keywords + "%");
		List<SanPham> list = query.list();
		return list;
	}

	public List<SanPham> loadPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String hql = "FROM SanPham";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(pageNo * pageSize);
		query.setMaxResults(pageSize);
		List<SanPham> list = query.list();
		return list;
	}

	public List<Object[]> inventoryByHang() {
		String hql = "SELECT p.hang.ten, SUM(p.donGia*p.soLuong), SUM(p.soLuong), "
				+ "MIN(p.donGia), MAX(p.donGia), AVG(p.donGia) "
				+ "FROM SanPham p GROUP BY p.hang.ten";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		return list;
	}
	
}
