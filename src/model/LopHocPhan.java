package model;

public class LopHocPhan {
	private String maLopHP;
	private String tenLopHP;
	private String maMH;
	private String tenGV;
	private String ngayBatDau;
	private String ngayKetThuc;
	private int soTiet;
	public LopHocPhan() {
		super();
	}
	public LopHocPhan(String maLopHP, String tenLopHP, String maMH, String tenGV, String ngayBatDau, String ngayKetThuc,
			int soTiet) {
		super();
		this.maLopHP = maLopHP;
		this.tenLopHP = tenLopHP;
		this.maMH = maMH;
		this.tenGV = tenGV;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.soTiet = soTiet;
	}
	public String getMaLopHP() {
		return maLopHP;
	}
	public void setMaLopHP(String maLopHP) {
		this.maLopHP = maLopHP;
	}
	public String getTenLopHP() {
		return tenLopHP;
	}
	public void setTenLopHP(String tenLopHP) {
		this.tenLopHP = tenLopHP;
	}
	public String getMaMH() {
		return maMH;
	}
	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}
	public String getTenGV() {
		return tenGV;
	}
	public void setTenGV(String tenGV) {
		this.tenGV = tenGV;
	}
	public String getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(String ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public String getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(String ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	public int getSoTiet() {
		return soTiet;
	}
	public void setSoTiet(int soTiet) {
		this.soTiet = soTiet;
	}
	
	
}
