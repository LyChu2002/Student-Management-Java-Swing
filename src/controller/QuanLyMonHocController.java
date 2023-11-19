package controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JFrame;

import view.QuanLyMonHocView;
import view.TrangChuAdminView;

public class QuanLyMonHocController implements Action, MouseListener{
	private QuanLyMonHocView view;

	public QuanLyMonHocController(QuanLyMonHocView view) {
		super();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		if(command.equals("Thêm")) {
			this.view.themMonHoc();
		}else if(command.equals("Xóa")) {
			this.view.xoaMonHoc();
		}else if(command.equals("Sửa")) {
			this.view.suaMonHoc();
		}else if(command.equals("Tìm kiếm")) {
			this.view.timKiemMonHoc();
		}else if(command.equals("Quay lại")) {
			JFrame frame = TrangChuAdminView.getInstance();
			frame.setVisible(true);
			this.view.dispose();
		}else if(command.equals("Hiển thị")) {
			this.view.hienThiData();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		this.view.chonDong();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
