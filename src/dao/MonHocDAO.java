package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBC;
import model.MonHoc;

public class MonHocDAO {
	public static MonHocDAO getInstance() {
		return new MonHocDAO();
	}
	
	public int insert(MonHoc t) {
		int ketQua = 0;
		try {
			Connection con = JDBC.getConnection();
			Statement st = con.createStatement();
			String sql = "INSERT INTO MonHoc(MaMH, TenMH, SoTC)" + " VALUES ('"
					+ t.getMaMH() + "', N'" + t.getTenMH() + "', " + t.getSoTC() + ")";
		
			ketQua = st.executeUpdate(sql);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
		
	}

	public int update(MonHoc t) {

		int ketQua = 0;
		try {
			Connection con = JDBC.getConnection();

			Statement st = con.createStatement();

			String sql = "UPDATE MonHoc SET TenMH = N'" + t.getTenMH() + "', SoTC = " + t.getSoTC() + " WHERE MaMH = '" + t.getMaMH() + "'";

			ketQua = st.executeUpdate(sql);

			JDBC.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	public int delete(MonHoc t) {
		// TODO Auto-generated method stub
		int ketQua = 0;

		try {
			Connection con = JDBC.getConnection();
			Statement st = con.createStatement();
			String sql = "DELETE FROM MonHoc " + "WHERE MaMH= '" + t.getMaMH() + "'";

			ketQua = st.executeUpdate(sql);

			JDBC.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	
	}

	public ArrayList<MonHoc> selectAll() {
		ArrayList<MonHoc> ketQua = new ArrayList<MonHoc>();
		try {
			Connection con = JDBC.getConnection();

			Statement st = con.createStatement();

			String sql = "SELECT * FROM MonHoc";

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				String maMH = rs.getString("MaMH");
				String tenMH = rs.getString("TenMH");
				int soTC = rs.getInt("SoTC");

				MonHoc monHoc = new MonHoc(maMH, tenMH, soTC);
				ketQua.add(monHoc);
			}

			JDBC.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
		
	}

	public MonHoc selectById(String t) {
		MonHoc ketQua = null;

		try {
			Connection con = JDBC.getConnection();

			Statement st = con.createStatement();

			String sql = "SELECT * FROM MonHoc WHERE MaMH = '" + t + "' ";

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String maMH = rs.getString("MaMH");
				String tenMH = rs.getString("TenMH");
				int soTC = rs.getInt("SoTC");

				ketQua = new MonHoc(maMH, tenMH, soTC);
			}

			JDBC.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}


	public ArrayList<MonHoc> selectByCondition(String condition) {
		ArrayList<MonHoc> ketQua = new ArrayList<MonHoc>();
		try {
			Connection con = JDBC.getConnection();

			Statement st = con.createStatement();

			String sql = "SELECT * FROM MonHoc WHERE TenMH = N'" + condition + "' ";

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				String maMH = rs.getString("MaMH");
				String tenMH = rs.getString("TenMH");
				int soTC = rs.getInt("SoTC");

				MonHoc monHoc = new MonHoc(maMH, tenMH, soTC);
				ketQua.add(monHoc);
			}

			JDBC.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}
}
