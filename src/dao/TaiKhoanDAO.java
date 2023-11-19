package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBC;
import model.TaiKhoan;

public class TaiKhoanDAO {
	public static TaiKhoanDAO getInstance() {
		return new TaiKhoanDAO();
	}
	
	public ArrayList<TaiKhoan> selectAll() {
		ArrayList<TaiKhoan> dstk = new ArrayList<TaiKhoan>();
		try {
			Connection conn = JDBC.getConnection();
			
			Statement st = conn.createStatement();
			String sql = "SELECT * FROM TaiKhoan WHERE TenTK != 'admin'";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				TaiKhoan taiKhoan = new TaiKhoan(rs.getString("TenTK").trim(), rs.getString("MatKhau").trim());
				dstk.add(taiKhoan);
			}
			JDBC.closeConnection(conn);
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dstk;
	}
}
