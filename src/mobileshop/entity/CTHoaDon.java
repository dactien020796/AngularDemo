package mobileshop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CTHoaDons")
public class CTHoaDon {
	@Id
	@GeneratedValue
	Integer ma;
//	Integer maHD;
//	Integer maSP;
	Integer donGia;
	Integer soLuong;
	Integer khuyenMai;
		
	@ManyToOne
	@JoinColumn(name="MaHD")
	HoaDon hoaDon;
	
	@ManyToOne
	@JoinColumn(name="MaSP")
	SanPham sanPham;

	public Integer getMa() {
		return ma;
	}

	public void setMa(Integer ma) {
		this.ma = ma;
	}

	public Integer getDonGia() {
		return donGia;
	}

	public void setDonGia(Integer donGia) {
		this.donGia = donGia;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public Integer getKhuyenMai() {
		return khuyenMai;
	}

	public void setKhuyenMai(Integer khuyenMai) {
		this.khuyenMai = khuyenMai;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	
	
	
}
