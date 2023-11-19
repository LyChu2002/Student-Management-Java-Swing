package model;

public class MonHoc {
	private String maMH;
	private String tenMH;
	private int SoTC;
	public MonHoc() {
		super();
	}
	public MonHoc(String maMH, String tenMH, int soTC) {
		super();
		this.maMH = maMH;
		this.tenMH = tenMH;
		SoTC = soTC;
	}
	public String getMaMH() {
		return maMH;
	}
	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}
	public String getTenMH() {
		return tenMH;
	}
	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}
	public int getSoTC() {
		return SoTC;
	}
	public void setSoTC(int soTC) {
		SoTC = soTC;
	}
	
	
}
