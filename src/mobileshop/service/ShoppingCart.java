package mobileshop.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import mobileshop.entity.SanPham;


@Component("cart")
// de ShoppingCart nay trong session: cho tung khach hang
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart implements Serializable {
	@Autowired
	SanPhamService sanPhamService;
	Map<Integer, SanPham> map = new HashMap<Integer, SanPham>();

	/**
	 * Them san pham vao gio hang
	 * @param id chua san pham duoc click
	 */
	public void add(Integer ma) {
		SanPham sanpham = map.get(ma);
		// da co trong gio hang
		if(sanpham != null) {
			sanpham.setSoLuong(sanpham.getSoLuong()+1);
		}
		// chua co trong gio hang
		else {
			sanpham = sanPhamService.get(ma);
			sanpham.setSoLuong(1);
			map.put(ma, sanpham);
		}
	}
	
	/**
	 * xoa san pham khoi gio hang
	 * @param id chua ma hang can xoa
	 */
	public void remove(Integer ma) {
		map.remove(ma);
	}

	/**
	 * xoa tat ca san pham trong gio hang
	 */
	public void clear() {
		map.clear();
	}

	/**
	 * cap nhat so luong cua mot san pham bat ki trong gio hang
	 * @param id : ma sp can cap nhat
	 * @param newQuantity : so luong cap nhat moi
	 */
	public void update(Integer ma, Integer newSoLuong) {
		SanPham sanpham = map.get(ma);
		sanpham.setSoLuong(newSoLuong);
	}

	/**
	 * lay tong so luong san pham trong gio hang
	 * @return tong so luong
	 */
	public int getCount() {
		int total =0 ;
		for(SanPham p: getItems()) {
			total += p.getSoLuong();
		}
		return total;
	}

	/**
	 * lay tong tien trong gio hang
	 * @return tong tien
	 */
	public int getAmount() {
		int total =0 ;
		for(SanPham p: getItems()) {
			total += p.getSoLuong() * p.getDonGia() * ( 1- p.getKhuyenMai() );
		}
		return total;
	}

	/**
	 * lay tap hop cac mat hang trong gio
	 * @return tap mat hang
	 */
	public Collection<SanPham> getItems() {
		return map.values();
	}
	
	public SanPham getItem(Integer ma) {
		return map.get(ma);
	}
}
