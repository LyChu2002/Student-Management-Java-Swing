package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.DangNhapView;
import view.QuanLyLopHocPhanView;
import view.QuanLyMonHocView;
import view.ThongTinSinhVienView;
import view.TrangChuAdminView;

public class TrangChuAdminController implements ActionListener{
	private TrangChuAdminView view;

	public TrangChuAdminController(TrangChuAdminView view) {
		super();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		if(command.equals("Thông tin sinh viên")) {
			openThongTinSinhVien();
		}else if(command.equals("Quản lý môn học")){
			openQuanLyMonHoc();
		}else if(command.equals("Quản lý lớp học phần")) {
			openQuanLyLopHP();
		}else if(command.equals("Đăng xuất")) {
			JFrame frame = new DangNhapView();
			frame.setVisible(true);
			this.view.dispose();
		}
	}

	private void openQuanLyLopHP() {
		// TODO Auto-generated method stub
		JFrame frame = new QuanLyLopHocPhanView();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		view.setVisible(false);
	}

	private void openQuanLyMonHoc() {
		// TODO Auto-generated method stub
		JFrame frame = new QuanLyMonHocView();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		view.setVisible(false);
	}

	private void openThongTinSinhVien() {
		// TODO Auto-generated method stub
		JFrame frame = new ThongTinSinhVienView();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		view.setVisible(false);
	}
	
}
