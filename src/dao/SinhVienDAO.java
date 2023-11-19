package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBC;
import model.SinhVien;

public class SinhVienDAO {
	public static SinhVienDAO getInstance() {
		return new SinhVienDAO();
	}

	// insert
	public int insert(SinhVien t) {
		int ketQua = 0;
		try {
			Connection con = JDBC.getConnection();
			Statement st = con.createStatement();
			String sql = "INSERT INTO SinhVien(MaSV, HoTen, NgaySinh, GioiTinh, SDT, DiaChi)" + " VALUES ('"
					+ t.getMaSV() + "', N'" + t.getHoTen() + "', '" + t.getNgaySinh() + "', N'" + t.getGioiTinh()
					+ "', '" + t.getSdt() + "' ,N'" + t.getDiaChi() + "')";
			
			ketQua = st.executeUpdate(sql);
			JDBC.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;

	}

	// update
	public int update(SinhVien t) {
		int ketQua = 0;
		try {
			Connection con = JDBC.getConnection();

			Statement st = con.createStatement();

			String sql = "UPDATE SinhVien SET HoTen = N'" + t.getHoTen() + "', NgaySinh = '" + t.getNgaySinh()
					+ "', GioiTinh = N'" + t.getGioiTinh() + "', SDT = '" + t.getSdt() + "', DiaChi = N'"
					+ t.getDiaChi() + "'" + " WHERE MaSV = '" + t.getMaSV() + "'";

			ketQua = st.executeUpdate(sql);

			JDBC.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	// delete
	public int delete(SinhVien t) {
		int ketQua = 0;

		try {
			Connection con = JDBC.getConnection();
			Statement st = con.createStatement();
			String sql = "DELETE FROM SinhVien " + "WHERE MaSV= '" + t.getMaSV() + "'";
			ketQua = st.executeUpdate(sql);
			JDBC.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;

	}

	// select dssv
	public ArrayList<SinhVien> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<SinhVien> ketQua = new ArrayList<SinhVien>();

		try {

			Connection con = JDBC.getConnection();

			Statement st = con.createStatement();

			String sql = "SELECT * FROM SinhVien";

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				String maSV = rs.getString("MaSV");
				String hoTen = rs.getString("HoTen");
				String ngaySinh = rs.getString("NgaySinh");
				String gioiTinh = rs.getString("GioiTinh");
				String sdt = rs.getString("SDT");
				String diaChi = rs.getString("DiaChi");

				SinhVien sinhVien = new SinhVien(maSV, hoTen, ngaySinh, gioiTinh, sdt, diaChi);
				ketQua.add(sinhVien);
			}

			JDBC.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	// select sinh vien by MaSV
	public SinhVien selectById(String t) {
		// TODO Auto-generated method stub
		SinhVien ketQua = null;

		try {
			Connection con = JDBC.getConnection();

			Statement st = con.createStatement();

			String sql = "SELECT * FROM SinhVien WHERE MaSV = '" + t + "' ";

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String maSV = rs.getString("MaSV");
				String hoTen = rs.getString("HoTen");
				String ngaySinh = rs.getString("NgaySinh");
				String gioiTinh = rs.getString("GioiTinh");
				String sdt = rs.getString("SDT");
				String diaChi = rs.getString("DiaChi");

				ketQua = new SinhVien(maSV, hoTen, ngaySinh, gioiTinh, sdt, diaChi);

			}

			JDBC.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	// Select sv by condition
	public ArrayList<SinhVien> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		ArrayList<SinhVien> ketQua = new ArrayList<SinhVien>();
		try {
			Connection con = JDBC.getConnection();
			
			Statement st = con.createStatement();

			String sql = "SELECT * FROM SinhVien WHERE HoTen LIKE N'%" + condition + "%'";

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String maSV = rs.getString("MaSV");
				String hoTen = rs.getString("HoTen");
				String ngaySinh = rs.getString("NgaySinh");
				String gioiTinh = rs.getString("GioiTinh");
				String sdt = rs.getString("SDT");
				String diaChi = rs.getString("DiaChi");

				SinhVien sinhVien = new SinhVien(maSV, hoTen, ngaySinh, gioiTinh, sdt, diaChi);
				ketQua.add(sinhVien);
			}

			JDBC.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}
}
