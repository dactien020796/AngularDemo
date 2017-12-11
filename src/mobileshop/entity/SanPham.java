package mobileshop.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="SanPhams")
public class SanPham {
	@Id
	@GeneratedValue
	Integer ma;
	String ten;
	Integer donGia;
	String hinhAnh;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	Date ngayDang;
	Integer soLuong;
//	String maHang;
	Boolean trangThai;
	String manHinh;
	String hDH;
	String rAM;
	String rOM;
	String camera;
	String selfie;
	String pin;
	String ghiChu;
	String baoHanh;
	Integer khuyenMai;
	Boolean dacBiet;
	Boolean moiNhat;
	Integer luotXem;

	@ManyToOne
	@JoinColumn(name="MaHang")
	Hang hang;
	
	@JsonIgnore
	@OneToMany(mappedBy="sanPham")
	Collection<CTHoaDon> cTHoaDons;

	public Integer getMa() {
		return ma;
	}

	public void setMa(Integer ma) {
		this.ma = ma;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public Integer getDonGia() {
		return donGia;
	}

	public void setDonGia(Integer donGia) {
		this.donGia = donGia;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public Date getNgayDang() {
		return ngayDang;
	}

	public void setNgayDang(Date ngayDang) {
		this.ngayDang = ngayDang;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public Boolean getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Boolean trangThai) {
		this.trangThai = trangThai;
	}

	public String getManHinh() {
		return manHinh;
	}

	public void setManHinh(String manHinh) {
		this.manHinh = manHinh;
	}

	public String gethDH() {
		return hDH;
	}

	public void sethDH(String hDH) {
		this.hDH = hDH;
	}

	public String getrAM() {
		return rAM;
	}

	public void setrAM(String rAM) {
		this.rAM = rAM;
	}

	public String getrOM() {
		return rOM;
	}

	public void setrOM(String rOM) {
		this.rOM = rOM;
	}

	public String getCamera() {
		return camera;
	}

	public void setCamera(String camera) {
		this.camera = camera;
	}

	public String getSelfie() {
		return selfie;
	}

	public void setSelfie(String selfie) {
		this.selfie = selfie;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public String getBaoHanh() {
		return baoHanh;
	}

	public void setBaoHanh(String baoHanh) {
		this.baoHanh = baoHanh;
	}

	public Integer getKhuyenMai() {
		return khuyenMai;
	}

	public void setKhuyenMai(Integer khuyenMai) {
		this.khuyenMai = khuyenMai;
	}

	public Boolean getDacBiet() {
		return dacBiet;
	}

	public void setDacBiet(Boolean dacBiet) {
		this.dacBiet = dacBiet;
	}

	public Boolean getMoiNhat() {
		return moiNhat;
	}

	public void setMoiNhat(Boolean moiNhat) {
		this.moiNhat = moiNhat;
	}

	public Integer getLuotXem() {
		return luotXem;
	}

	public void setLuotXem(Integer luotXem) {
		this.luotXem = luotXem;
	}

	public Hang getHang() {
		return hang;
	}

	public void setHang(Hang hang) {
		this.hang = hang;
	}

	public Collection<CTHoaDon> getcTHoaDons() {
		return cTHoaDons;
	}

	public void setcTHoaDons(Collection<CTHoaDon> cTHoaDons) {
		this.cTHoaDons = cTHoaDons;
	}

	
	
	
}
