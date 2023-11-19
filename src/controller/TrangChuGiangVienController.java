package controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JFrame;

import view.DangNhapView;
import view.QuanLyKetQuaHocTapView;
import view.QuanLyKetQuaThiView;
import view.TrangChuGiangVienView;

public class TrangChuGiangVienController implements Action{
	private TrangChuGiangVienView view;
	
	
	public TrangChuGiangVienController(TrangChuGiangVienView view) {
		super();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		if(command.equals("Quản lý kết quả học tập")) {
			openQuanLyKetQuaHocTap();
		}else if(command.equals("Quản lý kết quả thi")) {
			openQuanLyKetQuaThi();
		}else if(command.equals("Đăng xuất")) {
			JFrame frame = new DangNhapView();
			frame.setVisible(true);
			this.view.dispose();
		}
	}

	private void openQuanLyKetQuaThi() {
		// TODO Auto-generated method stub
		JFrame frame = new QuanLyKetQuaThiView();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		view.setVisible(false);
	}

	private void openQuanLyKetQuaHocTap() {
		// TODO Auto-generated method stub
		JFrame frame = new QuanLyKetQuaHocTapView();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		view.setVisible(false);
	}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

}
