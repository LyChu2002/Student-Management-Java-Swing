package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBC;
import model.LopHocPhan;

public class LopHocPhanDAO {
	public static LopHocPhanDAO getInstance() {
		return new LopHocPhanDAO();
	}

	public int insert(LopHocPhan t) {
		int ketQua = 0;
		try {
			Connection con = JDBC.getConnection();
			Statement st = con.createStatement();
			String sql = "INSERT INTO LopHocPhan(MaLopHP, TenLopHP, MaMH, TenGV, NgayBatDau, NgayKetThuc, SoTiet)" + " VALUES ('"
					+ t.getMaLopHP() + "', '" + t.getTenLopHP() + "', '" + t.getMaMH() + "', N'" + t.getTenGV()
					+ "', '" + t.getNgayBatDau() + "' ,'" + t.getNgayKetThuc() + "', "+t.getSoTiet()+")";
			System.out.println("Bạn đã thực thị: " + sql);
			ketQua = st.executeUpdate(sql);
			System.out.println("Bạn đã thực thị: " + sql);
			System.out.println("Có: " + ketQua + " dòng bị thay đổi");
			JDBC.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	public int update(LopHocPhan t) {
		int ketQua = 0;
		try {
			Connection con = JDBC.getConnection();

			Statement st = con.createStatement();

			String sql = "UPDATE LopHocPhan SET TenLopHP = '" + t.getTenLopHP() + "', MaMH = '" + t.getMaMH()
					+ "', TenGV = N'" + t.getTenGV() + "', NgayBatDau = '" + t.getNgayBatDau() + "', NgayKetThuc = '"
					+ t.getNgayKetThuc() + "', SoTiet = "+ t.getSoTiet() + " WHERE MaLopHP = '" + t.getMaLopHP() + "'";

			ketQua = st.executeUpdate(sql);

			JDBC.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	public int delete(LopHocPhan t) {
		int ketQua = 0;
		try {
			Connection con = JDBC.getConnection();
			Statement st = con.createStatement();
			String sql = "DELETE FROM LopHocPhan WHERE MaLopHP = '" + t.getMaLopHP() + "' ";
			
			ketQua = st.executeUpdate(sql);
			JDBC.closeConnection(con);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<LopHocPhan> selectAll() {
		ArrayList<LopHocPhan> ketQua = new ArrayList<LopHocPhan>();

		try {

			Connection con = JDBC.getConnection();

			Statement st = con.createStatement();

			//String sql = "SELECT MaLopHP, TenLopHP, LopHocPhan.MaMH, TenMH, TenGV, NgayBatDau, NgayKetThuc"
					//+ " FROM LopHocPhan INNER JOIN MonHoc ON LopHocPhan.MaMH = MonHoc.MaMH";
			String sql = "SELECT * FROM LopHocPhan";

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				String maLopHP = rs.getString("MaLopHP");
				String tenLopHP = rs.getString("TenLopHP");
				String maMH = rs.getString("MaMH");
				String tenGV = rs.getString("TenGV");
				String ngayBatDau = rs.getString("NgayBatDau");
				String ngayKetThuc = rs.getString("NgayKetThuc");
				int soTiet = rs.getInt("SoTiet");

				LopHocPhan lopHocPhan = new LopHocPhan(maLopHP, tenLopHP, maMH, tenGV, ngayBatDau, ngayKetThuc, soTiet);
				ketQua.add(lopHocPhan);
			}

			JDBC.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	public LopHocPhan selectById(String t) {

		LopHocPhan ketQua = null;

		try {
			Connection con = JDBC.getConnection();

			Statement st = con.createStatement();

			String sql = "SELECT * FROM LopHocPhan WHERE MaLopHP = '" + t + "' ";

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String maLopHP = rs.getString("MaLopHP");
				String tenLopHP = rs.getString("TenLopHP");
				String maMH = rs.getString("MaMH");
				String tenGV = rs.getString("TenGV");
				String ngayBatDau = rs.getString("NgayBatDau");
				String ngayKetThuc = rs.getString("NgayKetThuc");
				int soTiet = rs.getInt("SoTiet");

				ketQua = new LopHocPhan(maLopHP, tenLopHP, maMH, tenGV, ngayBatDau, ngayKetThuc, soTiet);
			}

			JDBC.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	public ArrayList<LopHocPhan> selectBySubjectName(String condition) {
		// TODO Auto-generated method stub
		ArrayList<LopHocPhan> ketQua = new ArrayList<LopHocPhan>();
		try {
			Connection con = JDBC.getConnection();
			
			Statement st = con.createStatement();

			String sql = "SELECT MaLopHP, TenLopHP, LopHocPhan.MaMH, TenMH, TenGV, NgayBatDau, NgayKetThuc, SoTiet "
					+ "FROM LopHocPhan INNER JOIN MonHoc "
					+ "ON LopHocPhan.MaMH = MonHoc.MaMH WHERE TenMH = N'" + condition + "'";

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String maLopHP = rs.getString("MaLopHP");
				String tenLopHP = rs.getString("TenLopHP");
				String maMH = rs.getString("MaMH");
				String tenGV = rs.getString("TenGV");
				String ngayBatDau = rs.getString("NgayBatDau");
				String ngayKetThuc = rs.getString("NgayKetThuc");
				int soTiet = rs.getInt("SoTiet");

				LopHocPhan lopHocPhan = new LopHocPhan(maLopHP, tenLopHP, maMH, tenGV, ngayBatDau, ngayKetThuc, soTiet);
				ketQua.add(lopHocPhan);
			}

			JDBC.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}
}
