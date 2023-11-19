package model;

public class Diem {
	private String MaSV;
	private String MaLopHP;
	private int soTietNghi;
	private double diemKTTX1;
	private double diemKTTX2;
	private double diemCuoiKy;
	public Diem() {
		super();
	}
	public Diem(String maSV, String maLopHP, int soTietNghi, double diemKTTX1, double diemKTTX2, double diemCuoiKy) {
		super();
		MaSV = maSV;
		MaLopHP = maLopHP;
		this.soTietNghi = soTietNghi;
		this.diemKTTX1 = diemKTTX1;
		this.diemKTTX2 = diemKTTX2;
		this.diemCuoiKy = diemCuoiKy;
	}
	
	
	public Diem(String maSV, String maLopHP, int soTietNghi, double diemKTTX1, double diemKTTX2) {
		super();
		MaSV = maSV;
		MaLopHP = maLopHP;
		this.soTietNghi = soTietNghi;
		this.diemKTTX1 = diemKTTX1;
		this.diemKTTX2 = diemKTTX2;
	}
	
	public Diem(String maSV, String maLopHP, double diemCuoiKy) {
		super();
		MaSV = maSV;
		MaLopHP = maLopHP;
		this.diemCuoiKy = diemCuoiKy;
	}
	public String getMaSV() {
		return MaSV;
	}
	public void setMaSV(String maSV) {
		MaSV = maSV;
	}
	public String getMaLopHP() {
		return MaLopHP;
	}
	public void setMaLopHP(String maLopHP) {
		MaLopHP = maLopHP;
	}
	public int getSoTietNghi() {
		return soTietNghi;
	}
	public void setSoTietNghi(int soTietNghi) {
		this.soTietNghi = soTietNghi;
	}
	public double getDiemKTTX1() {
		return diemKTTX1;
	}
	public void setDiemKTTX1(double diemKTTX1) {
		this.diemKTTX1 = diemKTTX1;
	}
	public double getDiemKTTX2() {
		return diemKTTX2;
	}
	public void setDiemKTTX2(double diemKTTX2) {
		this.diemKTTX2 = diemKTTX2;
	}
	public double getDiemCuoiKy() {
		return diemCuoiKy;
	}
	public void setDiemCuoiKy(double diemCuoiKy) {
		this.diemCuoiKy = diemCuoiKy;
	}
	
	
}
