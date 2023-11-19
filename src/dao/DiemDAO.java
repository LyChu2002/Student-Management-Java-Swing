package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBC;
import model.Diem;

public class DiemDAO {
	public static DiemDAO getInstance() {
		return new DiemDAO();
	}

	public int update(Diem t) {

		int ketQua = 0;
		try {
			Connection con = JDBC.getConnection();

			Statement st = con.createStatement();

			String sql = "UPDATE Diem SET SoTietNghi = " + t.getSoTietNghi() + ", DiemKTTX1 = " + t.getDiemKTTX1()
					+ " , DiemKTTX2 = " + t.getDiemKTTX2() + " ,DiemCuoiKy = " + t.getDiemCuoiKy() + " WHERE MaSV = '"
					+ t.getMaSV() + "' AND MaLopHP = '" + t.getMaLopHP() + "'";

			ketQua = st.executeUpdate(sql);

			JDBC.closeConnection(con);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return ketQua;
	}

	public int updateKQHT(Diem t) {

		int ketQua = 0;
		try {
			Connection con = JDBC.getConnection();

			Statement st = con.createStatement();

			String sql = "UPDATE Diem SET DiemKTTX1 = " + t.getDiemKTTX1()
					+ " , DiemKTTX2 = " + t.getDiemKTTX2() + " WHERE MaSV = '"
					+ t.getMaSV() + "' AND MaLopHP = '" + t.getMaLopHP() + "'";

			ketQua = st.executeUpdate(sql);

			JDBC.closeConnection(con);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return ketQua;
	}

	public int updateDiemThi(Diem t) {
		int ketQua = 0;
		try {
			Connection con = JDBC.getConnection();

			Statement st = con.createStatement();

			String sql = "UPDATE Diem SET DiemCuoiKy = " + t.getDiemCuoiKy() + " WHERE MaSV = '" + t.getMaSV()
					+ "' AND MaLopHP = '" + t.getMaLopHP() + "'";

			ketQua = st.executeUpdate(sql);

			JDBC.closeConnection(con);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return ketQua;
	}

	public Diem selectByStudentAndClassId(String t, String p) {

		Diem ketQua = null;

		try {
			Connection con = JDBC.getConnection();

			Statement st = con.createStatement();

			String sql = "SELECT * FROM Diem WHERE MaSV = '" + t + "' AND MaLopHP = '" + p + "' ";

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				double diemTX1, diemTX2, cuoiKy;
				String maSV = rs.getString("MaSV");
				String maLopHP = rs.getString("MaLopHP");
				int soTietNghi = rs.getInt("SoTietNghi");
				diemTX1 = rs.getDouble("DiemKTTX1");
				diemTX2 = rs.getDouble("DiemKTTX2");
				cuoiKy = rs.getDouble("DiemCuoiKy");

				ketQua = new Diem(maSV, maLopHP, soTietNghi, diemTX1, diemTX2, cuoiKy);

			}

			JDBC.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	public ArrayList<Diem> selectByClassID(String condition) {

		ArrayList<Diem> ketQua = new ArrayList<Diem>();
		try {
			Connection con = JDBC.getConnection();

			Statement st = con.createStatement();

			String sql = "SELECT Diem.MaSV, HoTen, MaLopHP, SoTietNghi, DiemKTTX1, DiemKTTX2, DiemCuoiKy "
					+ "FROM Diem INNER JOIN SinhVien " + "ON Diem.MaSV = SinhVien.MaSV WHERE MaLopHP = '" + condition
					+ "'" + "order by HoTen";

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				double diemTX1, diemTX2, cuoiKy;
				String maSV = rs.getString("MaSV");
				String hoTen = rs.getString("HoTen");
				String maLopHP = rs.getString("MaLopHP");
				int soTietNghi = rs.getInt("SoTietNghi");
				diemTX1 = rs.getDouble("DiemKTTX1");
				diemTX2 = rs.getDouble("DiemKTTX2");
				cuoiKy = rs.getDouble("DiemCuoiKy");

				Diem diem = new Diem(maSV, maLopHP, soTietNghi, diemTX1, diemTX2, cuoiKy);
				ketQua.add(diem);
			}

			JDBC.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	public ArrayList<Diem> selectByPassedCondition(String condition) {

		ArrayList<Diem> ketQua = new ArrayList<Diem>();
		try {
			Connection con = JDBC.getConnection();

			Statement st = con.createStatement();

			String sql = "SELECT Diem.MaSV, Diem.MaLopHP, SoTietNghi, DiemKTTX1, DiemKTTX2, DiemCuoiKy "
					+ "FROM Diem INNER JOIN LopHocPhan " + "ON Diem.MaLopHP = LopHocPhan.MaLopHP "
					+ "INNER JOIN SinhVien ON Diem.MaSV = SinhVien.MaSV"
					+ " WHERE (Diem.DiemKTTX1 + Diem.DiemKTTX2)/2 >= 4 and Diem.SoTietNghi <= LopHocPhan.SoTiet * 30 / 100 and Diem.MaLopHP = '"
					+ condition + "'" + "order by HoTen";

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				double diemTX1, diemTX2, cuoiKy;
				String maSV = rs.getString("MaSV");
				String maLopHP = rs.getString("MaLopHP");
				int soTietNghi = rs.getInt("SoTietNghi");
				diemTX1 = rs.getDouble("DiemKTTX1");
				diemTX2 = rs.getDouble("DiemKTTX2");
				cuoiKy = rs.getDouble("DiemCuoiKy");
				Diem diem = new Diem(maSV, maLopHP, soTietNghi, diemTX1, diemTX2, cuoiKy);
				ketQua.add(diem);
			}

			JDBC.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

}
